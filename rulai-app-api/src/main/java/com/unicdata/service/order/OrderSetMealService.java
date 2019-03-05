package com.unicdata.service.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.unicdata.entity.order.OrderSetMeal;
import com.unicdata.entity.order.OrderSetMealItem;
import com.unicdata.entity.product.MealItem;
import com.unicdata.entity.product.SetMeal;

/**
 * 保养套餐-代金券service
 * @author admin
 *
 */
public interface OrderSetMealService  {
	/**
	 * 保养套餐-代金券列表
	 * @param record
	 * @return
	 */
	List<Map<String,Object>> selectSetMealList(SetMeal record);
	
	/**
	 * 根据套餐id查询明细
	 * @param mealId
	 * @return
	 */
	List<MealItem> selectMealTtemById(Integer mealId);
	
	/**
	 * 添加或修改订单套餐-代金券
	 * @param record
	 * @return
	 */
	int addOrderSetMeal(OrderSetMealItem record,Integer orderId,Integer editType);
	/**
	 * 删除订单套餐-代金券
	 * @param orderSetMealId
	 * @return
	 */
	int deleteOrderSetMeal(OrderSetMeal record,Integer orderSetMealItemId);
	
	/**
	 * 根据订单id查询套餐-代金券信息
	 * @param orderId
	 * @return
	 */
	Map<String,Object> getOrderSetMeal(Integer orderId,Integer type);
	
	/**
	 * 根据条件查询套餐-代金券信息
	 * @param orderId
	 * @param type
	 * @param setmealId
	 * @return
	 */
	Map<String,Object> getOrderSetMealItemById(Integer setmealItemId);
	
	List<OrderSetMeal> getOrderSetMealByOrderId(Integer orderId);
}
