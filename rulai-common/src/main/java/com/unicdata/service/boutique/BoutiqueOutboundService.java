package com.unicdata.service.boutique;

import com.unicdata.constant.BoutiqueEnum.BoutiqueSource;
import com.unicdata.entity.boutique.BoutiqueOutbound;

public interface BoutiqueOutboundService {

	/**
	 * 销售订单财务收款后，生成精品出库数据。<hr/>
	 * 注意事项：<br/>
	 * 
	 * 
	 * @param outbound
	 * @param boutiqueSource
	 * @return
	 */
	boolean addOutbound(BoutiqueOutbound outbound,BoutiqueSource boutiqueSource);
	
}
