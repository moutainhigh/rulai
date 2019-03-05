package com.unicdata.service.app;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.order.Order;

import java.util.List;
import java.util.Map;

/**
 * 订单service
 * @author admin
 *
 */
public interface OrderService  {
	/**
	 * 获取订单列表
	 * @param record
	 * @return
	 */
	PageInfo selectOrderList(Integer pageNum, Integer pageSize,Map<String,Object> map);
	
	Order selectOrderbyId(Integer id);

    int updateByPrimaryKeySelective(Order record);
    
    int getCurrentMothOrderNum(Integer employeeId,Integer status);

    Map<String,Object> getMothOrderNumByStoreId(Map<String,Object> map);
    
    /**
     * 根据订单id获取订单详情车辆、客户等相关信息
     *
     * @param orderId
     * @return
     */
    Map<String,Object> orderDetail(Integer orderId);

	/**
	 * 通过客户id获取订单信息
	 * @param cusId
	 * @return
	 */
	List<Order> selectByCusId(Integer cusId);
	
	/**
	 * 创建订单
	 * @param order
	 * @return
	 */
	int createOrder(Order order);
}
