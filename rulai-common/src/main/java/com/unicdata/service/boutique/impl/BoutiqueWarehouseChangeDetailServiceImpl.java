package com.unicdata.service.boutique.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.constant.BoutiqueEnum.ChangeType;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.dao.boutique.BoutiqueWarehouseChangeDetailMapper;
import com.unicdata.dao.boutique.BoutiqueWarehouseChangeMapper;
import com.unicdata.dao.boutique.BoutiqueWarehouseMapper;
import com.unicdata.dao.boutique.BoutiqueWarehousePositionMapper;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiqueWarehouse;
import com.unicdata.entity.boutique.BoutiqueWarehouseChange;
import com.unicdata.entity.boutique.BoutiqueWarehouseChangeDetail;
import com.unicdata.entity.boutique.BoutiqueWarehousePosition;
import com.unicdata.service.boutique.BoutiqueWarehouseChangeDetailService;
@Service
public class BoutiqueWarehouseChangeDetailServiceImpl implements BoutiqueWarehouseChangeDetailService {

	@Autowired
	private BoutiqueInformationMapper informationMapper;
	
	@Autowired
	private BoutiqueWarehouseChangeMapper changeMapper;
	
	@Autowired
	private BoutiqueWarehouseChangeDetailMapper changeDetailMapper;
	
	@Autowired
	private BoutiqueWarehouseMapper warehouseMapper;

	@Autowired
	private BoutiqueWarehousePositionMapper positionMapper;

	@Override
	public JSONObject selectBoutiqueWareHouseChangeDetail(Integer changeId) {
		JSONObject result = new JSONObject();
		List<BoutiqueWarehouseChangeDetail> all = changeDetailMapper.selectDetailByChangeId(changeId);
		Map<Integer, List<BoutiqueWarehouseChangeDetail>> allMap = new HashMap<Integer, List<BoutiqueWarehouseChangeDetail>>();
		
		for (BoutiqueWarehouseChangeDetail detail : all) {
			
			BoutiqueInformation information = informationMapper.selectByPrimaryKey(detail.getBoutiqueId());
			detail.setCode(information.getCode());
			detail.setName(information.getName());
			
			BoutiqueWarehouse warehouse = warehouseMapper.selectByPrimaryKey(detail.getWarehouseId());
			detail.setWarehouseIdStr(warehouse.getName());
			
			BoutiqueWarehousePosition position = positionMapper.selectByPrimaryKey(detail.getPositionId());
			detail.setPositionIdStr(position.getName());
			
			Integer boutiqueId = detail.getBoutiqueId();
			List<BoutiqueWarehouseChangeDetail> list = allMap.get(boutiqueId);
			if(list == null ){
				list = new ArrayList<BoutiqueWarehouseChangeDetail>();
			}
			list.add(detail);
			allMap.put(boutiqueId, list);
		}
		List<BoutiqueWarehouseChangeDetail> before = new ArrayList<BoutiqueWarehouseChangeDetail>();
		List<BoutiqueWarehouseChangeDetail> after = new ArrayList<BoutiqueWarehouseChangeDetail>();
		Set<Integer> keySet = allMap.keySet();
		for (Integer boutiqueId : keySet) {
			List<BoutiqueWarehouseChangeDetail> list = allMap.get(boutiqueId);
			for (BoutiqueWarehouseChangeDetail detail : list) {
				if(ChangeType.BEFORE.getCode() == detail.getType()){
					before.add(detail);
				}else{
					after.add(detail);
				}
			}
		}
		result.put("before", before);
		result.put("after", after);
		return result;
	}
}
