package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.unicdata.condition.OutboundCondition;
import com.unicdata.entity.boutique.BoutiqueOutbound;

public interface OutboundSupportService extends BoutiqueOutboundService{

	PageInfo<Map<String, Object>> selectOutboundByCondition(OutboundCondition condition);

	BoutiqueOutbound outboundPicking(Integer storeId, Integer id);
	
	/**
	 * 出库
	 * @param ids
	 * @return
	 */
	JSONObject beginOutbound(Integer id,Integer[] ids,Integer pickerId);

}
