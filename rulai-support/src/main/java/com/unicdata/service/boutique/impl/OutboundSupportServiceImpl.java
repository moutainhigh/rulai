package com.unicdata.service.boutique.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.condition.OutboundCondition;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.dao.boutique.BoutiqueOutboundDetailMapper;
import com.unicdata.dao.boutique.BoutiqueOutboundMapper;
import com.unicdata.dao.system.EmployeeMapper;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiqueOutbound;
import com.unicdata.entity.boutique.BoutiqueOutboundDetail;
import com.unicdata.entity.boutique.outbound.OutboundPrompt;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.OutboundSupportService;
@Service
public class OutboundSupportServiceImpl extends BoutiqueOutboundServiceImpl implements OutboundSupportService {

	@Autowired
	private BoutiqueOutboundMapper boutiqueOutboundMapper;
	
	@Autowired
	private BoutiqueOutboundDetailMapper boutiqueOutboundDetailMapper;
	
	@Autowired
	private BoutiqueInformationMapper boutiqueInformationMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public PageInfo<Map<String, Object>> selectOutboundByCondition(OutboundCondition condition) {
		PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
		Page<Map<String, Object>> page = boutiqueOutboundMapper.selectOutboundByCondition(condition);
		
//		int no = 1;
//		if(page.size() > 0){
//			for (int i= 0 ; i < page.size() ;i++) {
//				BoutiqueOutbound outbound = (BoutiqueOutbound) page.get(i);
//				
//				
//			}
//		}
		return page.toPageInfo();
	}

	@Override
	public BoutiqueOutbound outboundPicking(Integer storeId, Integer id) {
		BoutiqueOutbound outbound = boutiqueOutboundMapper.outboundPickingById(id);
		List<BoutiqueOutboundDetail> detials = boutiqueOutboundDetailMapper.detialPickingByOutboundId(id);
	    List<BoutiqueOutboundDetail> notConstruction = new ArrayList<>();
	    List<BoutiqueOutboundDetail> beforeConstruction = new ArrayList<>();
	    List<BoutiqueOutboundDetail> afterConstruction = new ArrayList<>();
		
	    int notConstruction_no = 1;
	    int beforeConstruction_no = 1;
	    int afterConstruction_no = 1;
	    
		for (BoutiqueOutboundDetail detail : detials) {
			BoutiqueInformation information = boutiqueInformationMapper.selectByPrimaryKey(detail.getBoutiqueId());
			detail.setNowStock(information.getStock());
			Integer construction = detail.getBoutiqueConstruction();//施工节点
			Integer pickerId = detail.getPickerId();
			if(pickerId != null ){
				Employee selectByPrimaryKey = employeeMapper.selectByPrimaryKey(pickerId);
				detail.setPickerIdStr(selectByPrimaryKey.getFullName());
			}
			switch(construction){
				case(1):{detail.setNo(beforeConstruction_no); beforeConstruction_no++;beforeConstruction.add(detail);break;}
				case(2):{detail.setNo(afterConstruction_no); afterConstruction_no++;afterConstruction.add(detail);break;}
				case(3):{detail.setNo(notConstruction_no); notConstruction_no++;notConstruction.add(detail);break;}
			}
		}
		outbound.setNotConstruction(notConstruction);
		outbound.setBeforeConstruction(beforeConstruction);
		outbound.setAfterConstruction(afterConstruction);
		return outbound;
	}

	@Override
	@Transactional
	public JSONObject beginOutbound(Integer id,Integer[] ids,Integer pickerId) {
		JSONObject json = new JSONObject();
		int jsonStatus = 0;
		BoutiqueOutbound outbound = boutiqueOutboundMapper.selectByPrimaryKey(id);
		
		List<OutboundPrompt> prompts = new ArrayList<>();
		
		if(ids != null && ids.length > 0){
			for (Integer detailId : ids) {
				int count = 0;
				BoutiqueOutboundDetail detail = boutiqueOutboundDetailMapper.selectByPrimaryKey(detailId);
				if(detail.getStatus()  == 0){
					while(true){
						if(count == 3){
							//TODO 库存不足，提示
							OutboundPrompt prompt = new OutboundPrompt();
							Integer boutiqueId = detail.getBoutiqueId();
							BoutiqueInformation information = boutiqueInformationMapper.selectByPrimaryKey(boutiqueId);
							prompt.setName(information.getName());
							prompt.setReason("出库失败！当前库存为：" + information.getStock() + information.getCompany());
							prompts.add(prompt);
							jsonStatus ++;
							break;
						}
						BoutiqueInformation information = boutiqueInformationMapper.selectByPrimaryKey(detail.getBoutiqueId());
						Integer stock = information.getStock();
						Integer numer = detail.getNumer();
						information.setTaxCost( information.getTaxPrice().multiply(new BigDecimal(stock - numer)));
						information.setStock(numer);
						detail.setPickerId(pickerId);
						detail.setOutboundDate(new Date());
						detail.setStatus(1);
						int update = boutiqueInformationMapper.beginOutbound(information);
						
						if(update >= 1){
							update += boutiqueOutboundDetailMapper.updateByPrimaryKey(detail);
							
							break;
						}else{
							count++;
						}
					}
				}
			}
		}
		Map<String, Integer> map = boutiqueOutboundDetailMapper.selectCountOutbound(id);
		if(map.get("allOut") == map.get("isOut")){
			outbound.setStatus(2);
		}else{
			outbound.setStatus(1);
		}
		boutiqueOutboundMapper.updateByPrimaryKeySelective(outbound);
		if(jsonStatus > 0){
			json.put("status", 1);
		}else{
			json.put("status", 0);
		}
		json.put("msg", prompts);
		return json;
	}

}
