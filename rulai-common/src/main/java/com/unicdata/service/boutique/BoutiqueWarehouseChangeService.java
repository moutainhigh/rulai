package com.unicdata.service.boutique;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.condition.WareHouseChangeCondition;
import com.unicdata.entity.boutique.BoutiqueWarehouseChange;

public interface BoutiqueWarehouseChangeService {

	/**
	 * 保存精品仓库、库位变更
	 * @param wareHouseChange
	 * @return
	 */
	public int insert(BoutiqueWarehouseChange wareHouseChange);
	
	/**
	 * 条件分页查询精品仓库、库位变更
	 * @param condition
	 * @return
	 */
	PageInfo<Map<String, Object>> selectBoutiqueWareHouseChangePage(WareHouseChangeCondition condition);
}
