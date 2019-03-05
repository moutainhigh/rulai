package com.unicdata.service.order;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.order.OrderService;
import com.unicdata.entity.order.OrderServiceItem;
import com.unicdata.entity.order.StoreService;

/**
 * 订单其他service
 * @author admin
 *
 */
public interface OrderOtherService  {
	/**
	 * 获取订单其他服务
	 * @param orderId
	 * @return
	 */
	Map<String,Object> getOrderServiceByOrderId(Integer orderId);
	
	List<Map<String,Object>> getOrderService(Integer orderId);
	
	/**
	 * 获取门店其他服务列表
	 * @param storeId
	 * @return
	 */
	List<Map<String,Object>> selectStoreService(Integer storeId);
	
	/**
	 * 添加订单其他服务
	 * @param record
	 * @return
	 */
	int addOrderOtherService(Integer orderId,String jsonStr);
	/**
	 * 添加订单其他服务
	 * @param record
	 * @return
	 */
	int addOrderOtherService(List<OrderService> list);
	
	int deleteOrderOtherService(Integer orderId,Integer serviceId);
	
	int updateOrderOtherServiceItem(OrderServiceItem record);
	
	OrderService getServiceByOrderId(Integer orderId);
}
