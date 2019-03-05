package com.unicdata.dao.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.unicdata.entity.order.OrderServiceItem;
import com.unicdata.entity.order.OrderServiceItemExample;

public interface OrderServiceItemMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(OrderServiceItem record);

    int insertSelective(OrderServiceItem record);

    List<OrderServiceItem> selectByExample(OrderServiceItemExample example);

    OrderServiceItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderServiceItem record);

    int updateByPrimaryKey(OrderServiceItem record);
    
    List<Map<String,Object>> getItemsByOrderServiceId(Integer orderServiceId);

    List<Map<String,Object>> getItemsByMap(Map<String,Object> params);
    
    int deleteOrderServiceItem(OrderServiceItem record);
    
    int addOrderServiceItem(List<OrderServiceItem> list);
    
    BigDecimal getSumByOrderServiceId(Integer orderServiceId);
}