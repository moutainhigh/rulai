package com.unicdata.dao.order;

import com.unicdata.entity.order.OrderService;

import java.util.List;
import java.util.Map;
import com.unicdata.entity.order.OrderServiceExample;

public interface OrderServiceMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(OrderService record);

	int insertSelective(OrderService record);

	List<OrderService> selectByExample(OrderServiceExample example);

	OrderService selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(OrderService record);

	int updateByPrimaryKey(OrderService record);

    List<Map<String, Object>> selectListByOrderId(Integer OrderId);
    
    int addOrderOtherService(List<OrderService> list);
    
    Map<String, Object> selectByOrderId(Integer OrderId);

    Map<String, Object> findByOrderId(Integer OrderId);
    
    OrderService getServiceByOrderId(Integer orderId);
}