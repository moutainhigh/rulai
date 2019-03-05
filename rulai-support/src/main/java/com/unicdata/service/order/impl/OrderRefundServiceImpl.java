package com.unicdata.service.order.impl;

import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.order.OrderRefundMapper;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderRefund;
import com.unicdata.service.order.OrderRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by zhang
 */
@Service
public class OrderRefundServiceImpl implements OrderRefundService {
    @Autowired
    private OrderRefundMapper orderRefundMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 插入退单记录
     *
     * @param orderRefund
     * @return
     */
    public int insertOrderRefund(OrderRefund orderRefund) {
        return orderRefundMapper.insertSelective(orderRefund);
    }

    @Override
    @Transactional
    public void orderRefund(OrderRefund orderRefund) {
        //插入退单数据
        orderRefundMapper.insertSelective(orderRefund);
        //修改订单状态为已退单
        Order order = orderMapper.selectByPrimaryKey(orderRefund.getOrderId());
        order.setStatus(9);
        orderMapper.updateByPrimaryKeySelective(order);
    }
}
