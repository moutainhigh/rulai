package com.unicdata.dao.order;

import com.unicdata.entity.order.OrderSetMeal;
import com.unicdata.entity.order.OrderSetMealExample;

import java.util.List;
import java.util.Map;

public interface OrderSetMealMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(OrderSetMeal record);

    int insertSelective(OrderSetMeal record);

    List<OrderSetMeal> selectByExample(OrderSetMealExample example);

    OrderSetMeal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderSetMeal record);

    int updateByPrimaryKey(OrderSetMeal record);

    Map<String, Object> getOrderSetMeal(Map<String, Object> map);

    List<Map<String, Object>> getOrderSetMealList(Map<String, Object> map);

    List<Map<String, Object>> selectCouponListByOrderId(Integer oderId);

    List<Map<String, Object>> selectMealListByOrderId(Integer oderId);
}