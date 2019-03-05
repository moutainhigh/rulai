package com.unicdata.service.boutique;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.entity.boutique.BoutiqueWarehouseChange;

public interface BoutiqueWarehouseChangeDetailService {
	
	/**
	 * 根据变更id查询记录
	 * @param id
	 * @return
	 */
	public JSONObject selectBoutiqueWareHouseChangeDetail(Integer changeId);
	
}
