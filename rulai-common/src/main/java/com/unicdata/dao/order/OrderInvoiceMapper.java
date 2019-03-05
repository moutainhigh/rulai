package com.unicdata.dao.order;

import com.unicdata.entity.order.OrderInvoice;

public interface OrderInvoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInvoice record);

    int insertSelective(OrderInvoice record);

    OrderInvoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInvoice record);

    int updateByPrimaryKey(OrderInvoice record);

    OrderInvoice selectByOrderId(Integer orderId);
}