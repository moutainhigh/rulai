package com.unicdata.service.order.impl;

import com.unicdata.dao.order.OrderServiceMapper;
import com.unicdata.service.order.OrderServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@Service
public class OrderServiceServiceImpl implements OrderServiceService {

    @Autowired
    private OrderServiceMapper orderServiceMapper;

    @Override
    public List<Map<String, Object>> getOrderService(Integer orderId) {
        return orderServiceMapper.selectListByOrderId(orderId);
    }
}
