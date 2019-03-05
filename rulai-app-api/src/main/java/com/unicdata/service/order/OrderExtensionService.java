package com.unicdata.service.order;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.order.OrderExtension;
import com.unicdata.entity.product.InsuranceExtension;
import com.unicdata.entity.product.Insurer;

/**
 * 订单延保service
 * @author admin
 *
 */
public interface OrderExtensionService  {
	
	/**
	 * 修改延保订单
	 * @param record
	 * @return
	 */
	int updateOrderExtension(OrderExtension record);
	
	/**
	 * 根据订单id查询延保信息
	 * @param orderId
	 * @return
	 */
	Map<String,Object> getOrderExtension(Integer orderId);
	
	int deleteOrderExtension(Integer orderId);
	
	OrderExtension getOrderExtensionByOrderId(Integer orderId);
}
