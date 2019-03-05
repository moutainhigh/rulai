package com.unicdata.service.order;

import com.unicdata.entity.order.OrderRefund;

/**
 * Create by zhang
 */
public interface OrderRefundService {
    int insertOrderRefund(OrderRefund orderRefund);

    void orderRefund(OrderRefund orderRefund);
}
