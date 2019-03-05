package com.unicdata.service.boutique.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.condition.WareHouseChangeCondition;
import com.unicdata.constant.BoutiqueEnum.ChangeType;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.dao.boutique.BoutiqueWarehouseChangeDetailMapper;
import com.unicdata.dao.boutique.BoutiqueWarehouseChangeMapper;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiqueWarehouseChange;
import com.unicdata.entity.boutique.BoutiqueWarehouseChangeDetail;
import com.unicdata.service.boutique.BoutiqueWarehouseChangeService;
@Service
public class BoutiqueWarehouseChangeServiceImpl implements BoutiqueWarehouseChangeService {

	@Autowired
	private BoutiqueInformationMapper informationMapper;
	
	@Autowired
	private BoutiqueWarehouseChangeMapper changeMapper;
	
	@Autowired
	private BoutiqueWarehouseChangeDetailMapper changeDetailMapper;
	
	@Override
	public int insert(BoutiqueWarehouseChange wareHouseChange) {
		List<BoutiqueInformation> list = wareHouseChange.getList();
		Map<Integer, BoutiqueInformation> listMap = new HashMap<Integer, BoutiqueInformation>();
		Map<Integer, BoutiqueInformation> historyMap = new HashMap<Integer, BoutiqueInformation>();
		
		int status = 0;
		for (BoutiqueInformation info : list) {
			int update_count = 0;
			while(true){
				if(update_count == 3 ) return 0;
				BoutiqueInformation historyInfo = informationMapper.selectByPrimaryKey(info.getId());
				info.setVersion(historyInfo.getVersion());
				BigDecimal taxCost = historyInfo.getTaxPrice().multiply(new BigDecimal(info.getStock()));
				info.setTaxCost(taxCost);
				int update = informationMapper.updateWareHouseAndStock(info);
				if(update == 1){
					listMap.put(info.getId(), info);
					historyMap.put(info.getId(), historyInfo);
					status ++;
					break;
				}
				update_count++;
			}
		}
		
		if(status == list.size()){
			wareHouseChange.setTypeLive(1);
			int chageInsert = changeMapper.insertUseGeneratedKeys(wareHouseChange);
			if(chageInsert == 1){
				List<BoutiqueWarehouseChangeDetail> detailList = new ArrayList<BoutiqueWarehouseChangeDetail>();
				changeDetailCreate(wareHouseChange, historyMap, detailList,ChangeType.BEFORE);
				changeDetailCreate(wareHouseChange, listMap, detailList,ChangeType.AFTER);
				changeDetailMapper.insertBatch(detailList);
			}
			status = 1;
		}else{
			status = 0 ;
		}
		
		list = null;
		listMap = null;
		historyMap = null;
		return status;
	}


	private void changeDetailCreate(BoutiqueWarehouseChange wareHouseChange, Map<Integer, BoutiqueInformation> listMap,
			List<BoutiqueWarehouseChangeDetail> detailList,ChangeType type) {
		Set<Integer> keySet = listMap.keySet();
		for (Integer infoId : keySet) {
			BoutiqueInformation information = listMap.get(infoId);
			BoutiqueWarehouseChangeDetail detail = new BoutiqueWarehouseChangeDetail();
			detail.setType(type.getCode());
			detail.setChangeId(wareHouseChange.getId());
			detail.setStoreId(wareHouseChange.getStoreId());
			detail.setBoutiqueId(information.getId());
			detail.setWarehouseId(information.getWarehouseId());
			detail.setPositionId(information.getPositionId());
			detail.setStock(information.getStock());
			detail.setTypeLive(1);
			detailList.add(detail);
		}
	}


	@Override
	public PageInfo<Map<String, Object>> selectBoutiqueWareHouseChangePage(WareHouseChangeCondition condition) {
		PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
		return changeMapper.selectBoutiqueWareHouseChangePage(condition).toPageInfo();
	}

}
