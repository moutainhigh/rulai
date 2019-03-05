package com.unicdata.service.order.impl;

import com.unicdata.dao.order.OrderInvoiceMapper;
import com.unicdata.entity.order.OrderInvoice;
import com.unicdata.service.order.OrderInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by zhang
 */
@Service
public class OrderInvoiceServiceImpl implements OrderInvoiceService {
    @Autowired
    private OrderInvoiceMapper orderInvoiceMapper;

    @Override
    public int saveOrderInvoice(OrderInvoice orderInvoice) {
        OrderInvoice orderInvoiceNew = selectByOrderId(orderInvoice.getOrderId());
        if (orderInvoiceNew == null) {
            return orderInvoiceMapper.insertSelective(orderInvoice);
        } else {
            orderInvoice.setId(orderInvoiceNew.getId());
            return orderInvoiceMapper.updateByPrimaryKeySelective(orderInvoice);
        }
    }

    @Override
    public OrderInvoice selectByOrderId(Integer orderId) {
        return orderInvoiceMapper.selectByOrderId(orderId);
    }
}
