package com.unicdata.dao.order;

import com.unicdata.entity.order.OrderSetMealItem;
import com.unicdata.entity.order.OrderSetMealItemExample;
import java.util.List;
import java.util.Map;

public interface OrderSetMealItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderSetMealItem record);

    int insertSelective(OrderSetMealItem record);

    List<OrderSetMealItem> selectByExample(OrderSetMealItemExample example);

    OrderSetMealItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderSetMealItem record);

    int updateByPrimaryKey(OrderSetMealItem record);

    List<Map<String,Object>> getOrderSetMealItem(Map<String,Object> map);
    Map<String,Object> getOrderSetMealByItemId(Integer id);
}