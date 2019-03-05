package com.unicdata.service.order.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.base.util.StringUtil;
import com.unicdata.dao.order.OrderSetMealItemMapper;
import com.unicdata.dao.order.OrderSetMealMapper;
import com.unicdata.dao.product.MealItemMapper;
import com.unicdata.dao.product.SetMealMapper;
import com.unicdata.entity.order.OrderSetMeal;
import com.unicdata.entity.order.OrderSetMealExample;
import com.unicdata.entity.order.OrderSetMealItem;
import com.unicdata.entity.product.MealItem;
import com.unicdata.entity.product.MealItemExample;
import com.unicdata.entity.product.SetMeal;
import com.unicdata.entity.product.SetMealExample;
import com.unicdata.service.order.OrderSetMealService;

/**
 * 保养套餐-代金券服务层
 * @author admin
 *
 */
@Service
public class OrderSetMealServiceImpl implements OrderSetMealService {

    @Autowired
    private SetMealMapper setMealMapper;
    @Autowired
    private OrderSetMealMapper orderSetMealMapper;
    @Autowired
    private MealItemMapper mealItemMapper;
    @Autowired
    private OrderSetMealItemMapper orderSetMealItemMapper;


    @Transactional(readOnly=true)
	public List<Map<String, Object>> selectSetMealList(SetMeal record) {
    	SetMealExample example = new SetMealExample();
    	SetMealExample.Criteria criteria = example.createCriteria();
    	criteria.andStoreIdEqualTo(record.getStoreId());
    	criteria.andTypeEqualTo(record.getType());
    	List<SetMeal> list = setMealMapper.selectByExample(example);
    	List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
    	Map<String, Object> map = null;
    	for(SetMeal setMeal:list){
    		map = new HashMap<String, Object>();
    		map.put("id", setMeal.getId());
    		map.put("name", setMeal.getName());
    		map.put("price", setMeal.getMoney());
    		map.put("imgUrl", setMeal.getImgUrl());
    		resultList.add(map);
    	}
    	return resultList;
	}

	@Transactional
	public int addOrderSetMeal(OrderSetMealItem record,Integer orderId,Integer editType) {
		int res = 0;
		Integer orderSetmealId = 0;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", orderId);
		params.put("type", record.getType());
		//保养套餐和代金券主单信息
		Map<String, Object> tempMap = orderSetMealMapper.getOrderSetMeal(params);
		if(tempMap!=null){
			orderSetmealId = Integer.valueOf(String.valueOf(tempMap.get("id")));
		}
		SetMeal setMeal = setMealMapper.selectByPrimaryKey(record.getSetMealId());
		record.setCost(setMeal.getCost());
		if(null != editType && editType == 1){
			orderSetMealItemMapper.updateByPrimaryKeySelective(record);
		}else{
			if(orderSetmealId==0){
				OrderSetMeal orderSetMeal = new OrderSetMeal();
				orderSetMeal.setOrderId(orderId);
				orderSetMeal.setType(record.getType());
				res = orderSetMealMapper.insertSelective(orderSetMeal);
				orderSetmealId = orderSetMeal.getId();
			}
			record.setOrderSetmealId(orderSetmealId);
			res = orderSetMealItemMapper.insertSelective(record);
		}
		//查询保养套餐和代金券明细项
		params.put("orderSetmealId", orderSetmealId);
		List<Map<String, Object>> list = orderSetMealItemMapper.getOrderSetMealItem(params);
		BigDecimal saleCount = BigDecimal.ZERO;
		BigDecimal costCount = BigDecimal.ZERO;
		for(Map<String, Object> map:list){
			String service_price = String.valueOf(map.get("price"));
			String costStr = String.valueOf(map.get("cost"));
			String buyNum = String.valueOf(map.get("buyNum"));
			BigDecimal num = new BigDecimal(StringUtil.isNotBlank(buyNum)?buyNum:"1");
			BigDecimal money = new BigDecimal(service_price);
			money = money.multiply(num);
			saleCount = saleCount.add(money);//小计
			BigDecimal cost = new BigDecimal(costStr);
			cost = cost.multiply(num);
			costCount = costCount.add(cost);//成本
		}
		//修改总价
		OrderSetMeal orderSetMeal = new OrderSetMeal();
		orderSetMeal.setId(Integer.valueOf(orderSetmealId));
		orderSetMeal.setDonationAmount(BigDecimal.ZERO);//赠送
		orderSetMeal.setTotalAmount(saleCount);//小计
		orderSetMeal.setSumMealPrice(saleCount);//合计
		orderSetMeal.setMargin(orderSetMeal.getSumMealPrice().subtract(costCount));//毛利
		res = orderSetMealMapper.updateByPrimaryKeySelective(orderSetMeal);
		return res;
	}

	@Override
	public List<MealItem> selectMealTtemById(Integer mealId) {
		MealItemExample example = new MealItemExample();
		MealItemExample.Criteria criteria = example.createCriteria();
		criteria.andMealIdEqualTo(mealId);
		return mealItemMapper.selectByExample(example);
	}

	@Override
	public Map<String, Object> getOrderSetMeal(Integer orderId,Integer type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", orderId);
		params.put("type", type);
		//保养套餐和代金券主单信息
		Map<String, Object> setMealMap = orderSetMealMapper.getOrderSetMeal(params);
		if(null != setMealMap){
			//明细项
			params.put("orderSetmealId", setMealMap.get("id"));
			List<Map<String, Object>> list = orderSetMealItemMapper.getOrderSetMealItem(params);
			setMealMap.put("itemList", list);
		}
		return setMealMap;
	}

	@Override
	public Map<String,Object> getOrderSetMealItemById(Integer setmealItemId) {
		return orderSetMealItemMapper.getOrderSetMealByItemId(setmealItemId);
	}

	@Override
	public int deleteOrderSetMeal(OrderSetMeal record,Integer orderSetMealItemId) {
		//删除
		int res = orderSetMealItemMapper.deleteByPrimaryKey(orderSetMealItemId);
		if(res>0){
			res = clacSumMealPrice(record.getOrderId(),record.getType());
		}
		return res;
	}
	
	public int clacSumMealPrice(Integer orderId,Integer type){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", orderId);
		params.put("type", type);
		//保养套餐和代金券主单信息
		Map<String, Object> setMealMap = orderSetMealMapper.getOrderSetMeal(params);
		String orderSetmealId = String.valueOf(setMealMap.get("id"));
		//查询保养套餐和代金券明细项
		params.put("orderSetmealId", orderSetmealId);
		List<Map<String, Object>> list = orderSetMealItemMapper.getOrderSetMealItem(params);
		BigDecimal saleCount = BigDecimal.ZERO;
		for(Map<String, Object> map:list){
			String service_price = String.valueOf(map.get("price"));
			BigDecimal money = new BigDecimal(service_price);
			saleCount = saleCount.add(money);
		}
		//修改总价
		OrderSetMeal orderSetMeal = new OrderSetMeal();
		orderSetMeal.setId(Integer.valueOf(orderSetmealId));
		orderSetMeal.setSumMealPrice(saleCount);
		return orderSetMealMapper.updateByPrimaryKeySelective(orderSetMeal);
	}

	@Override
	public List<OrderSetMeal> getOrderSetMealByOrderId(Integer orderId) {
		OrderSetMealExample example = new OrderSetMealExample();
		OrderSetMealExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		return orderSetMealMapper.selectByExample(example);
	}

}
