package com.unicdata.service.boutique.home;

import java.util.Date;
import java.util.Map;

public interface HomeDeliverCarService {

	int getMothDeliverCarNumByStoreId(Date saleDate, Integer storeId);

	int getMothDeliverCarNumByStoreId(Map<String, Object> map);

	/**
	 * 通过订单对象获取订单数量
	 * @param record
	 * @return
	 */
	int getCurrentMothOrderNumTwo(Map<String, Object> map);

}
