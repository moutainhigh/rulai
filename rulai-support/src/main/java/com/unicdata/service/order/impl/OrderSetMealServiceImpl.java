package com.unicdata.service.order.impl;

import com.unicdata.dao.order.OrderSetMealMapper;
import com.unicdata.service.order.OrderSetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@Service
public class OrderSetMealServiceImpl implements OrderSetMealService {

    @Autowired
    private OrderSetMealMapper orderSetMealMapper;

    @Override
    public List<Map<String, Object>> getOrderSetMeal(Integer orderId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("orderId", orderId);
        map.put("type", 2);
        return orderSetMealMapper.getOrderSetMealList(map);
    }

    @Override
    public List<Map<String, Object>> selectCouponListByOrderId(Integer orderId) {
        return orderSetMealMapper.selectCouponListByOrderId(orderId);
    }

    @Override
    public List<Map<String, Object>> selectMealListByOrderId(Integer orderId) {
        return orderSetMealMapper.selectMealListByOrderId(orderId);
    }

}
