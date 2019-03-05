package com.unicdata.service.boutique.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.condition.BoutiqueInstallCondition;
import com.unicdata.constant.BoutiqueEnum.ConstructionNode;
import com.unicdata.constant.BoutiqueEnum.IntsallType;
import com.unicdata.dao.boutique.BoutiqueInstallMapper;
import com.unicdata.dao.boutique.BoutiqueInstallProjectMapper;
import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.entity.boutique.BoutiqueInstall;
import com.unicdata.entity.boutique.BoutiqueInstallProject;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.order.Order;
import com.unicdata.service.boutique.BoutiqueInstallService;
@Service
public class BoutiqueInstallServiceImpl implements BoutiqueInstallService {

	@Autowired
	private BoutiqueInstallMapper installMapper;
	
	@Autowired
	private BoutiqueInstallProjectMapper projectMapper;
	
    @Autowired
    private OrderMapper orderMapper;
	
    @Autowired
    private CarGoodInfoMapper carGoodInfoMapper;
    
	@Override
	public PageInfo<Map<String, Object>> selectInstallByCondition(BoutiqueInstallCondition condition) {
		PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
		
		Page<Map<String, Object>> page = installMapper.selectInstallByCondition(condition);
		IntsallType[] values = IntsallType.values();
		Map<Integer, String> intsallTypeMap = new HashMap<Integer, String>();
		for(int i = 0 ; i < values.length ; i++){
			intsallTypeMap.put(values[i].getCode(),values[i].getReason());
		}
		
		for(int i = 0 ; i < page.size() ; i ++){
			BoutiqueInstall install = (BoutiqueInstall) page.get(i);
			Integer status = install.getStatus();
			
			String vin = install.getVin();
			if(StringUtils.isBlank(vin)){
				Order order = orderMapper.selectByPrimaryKey(install.getOrderId());
				Integer matchingCarId = order.getMatchingCarId();
				if(matchingCarId != null){
					CarGoodInfoWithBLOBs carGoodInfo = carGoodInfoMapper.selectByPrimaryKey(matchingCarId);
					install.setVin(carGoodInfo.getVin());//vin码
					install.setModel(carGoodInfo.getVehicleName());//车型
				}
			}
			
			String statusStr = null;
			switch(status){
				case 1 :{
					statusStr = "未开始";
					break;
				}
				case 2 :{
					statusStr = "已开始";
					break;
				}
				case 3 :{
					statusStr = "已完成";
					break;
				}
			}
			
			install.setStatusStr(statusStr);
//			install.setStatusStr(intsallTypeMap.get(status));
			List<BoutiqueInstallProject> list = projectMapper.selectByInstallId(install.getId());
			if(list != null && list.size() > 0){
				List<BoutiqueInstallProject> not = new ArrayList<BoutiqueInstallProject>();
				for (BoutiqueInstallProject project : list) {
					Integer status2 = project.getStatus();
					project.setStatusStr(intsallTypeMap.get(status2));
					Integer constructionNode = project.getConstructionNode();
					if(constructionNode == ConstructionNode.NOT.getCode()){
						not.add(project);
					}
					project.setConstructionNodeStr(ConstructionNode.getReason(constructionNode));
				}
				list.removeAll(not);
			}
			install.setList(list);
		}
		
		for(int i = 0 ; i < page.size() ; i ++){
			BoutiqueInstall install = (BoutiqueInstall) page.get(i);
			Map<Integer, List<BoutiqueInstallProject>> map = new HashMap<Integer, List<BoutiqueInstallProject>>();
			List<BoutiqueInstallProject> list = install.getList();
			if(list != null && list.size() > 0){
				for (BoutiqueInstallProject project : list) {
					List<BoutiqueInstallProject> list2 = map.get(project.getConstructionNode());
					if(list2 == null || list2.size() == 0){
						list2 = new ArrayList<BoutiqueInstallProject>();
					}
					list2.add(project);
					map.put(project.getConstructionNode(), list2);
				}
				List<BoutiqueInstallProject> not = map.get(ConstructionNode.NOT.getCode());
				List<BoutiqueInstallProject> before = map.get(ConstructionNode.BEFORE.getCode());
				List<BoutiqueInstallProject> after = map.get(ConstructionNode.AFTER.getCode());
				List<BoutiqueInstallProject> installList = new ArrayList<BoutiqueInstallProject>();
				if(not != null){
					installList.addAll(not);
				}
				if(before != null){
					installList.addAll(before);
				}
				if(after != null){
					installList.addAll(after);
				}
				install.setList(installList);
			}
		}
		return page.toPageInfo();
	}

}
