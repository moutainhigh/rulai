package com.unicdata.service.order;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
public interface OrderSetMealService {
    /**
     * 订单代金券和套餐信息
     * @param orderId
     * @return
     */
    List<Map<String, Object>> getOrderSetMeal(Integer orderId);

    List<Map<String, Object>> selectCouponListByOrderId(Integer orderId);

    List<Map<String, Object>> selectMealListByOrderId(Integer orderId);

}
