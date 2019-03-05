package com.unicdata.service.order;

import com.unicdata.entity.order.OrderQuotedPrice;

import java.util.List;

/**
 * 订单报价service
 * @author admin
 *
 */
public interface OrderQuotedPriceService  {
	/**
	 * 新增报价单
	 * @param record
	 * @return
	 */
	int addOrderQuotedPrice(OrderQuotedPrice record);
	
	/**
	 * 根据用户查询报价单
	 * @param record
	 * @return
	 */
	List<OrderQuotedPrice> selectOrderQuotedPriceList(OrderQuotedPrice record);
}
