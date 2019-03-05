package com.unicdata.service.order;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
public interface OrderServiceService {
    /**
     * 订单其他服务相关信息
     *
     * @param orderId
     * @return
     */
    List<Map<String, Object>> getOrderService(Integer orderId);
}
