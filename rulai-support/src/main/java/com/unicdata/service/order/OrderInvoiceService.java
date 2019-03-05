package com.unicdata.service.order;

import com.unicdata.entity.order.OrderInvoice;

/**
 * Create by zhang
 */
public interface OrderInvoiceService {
    int saveOrderInvoice(OrderInvoice orderInvoice);

    OrderInvoice selectByOrderId(Integer orderId);
}
