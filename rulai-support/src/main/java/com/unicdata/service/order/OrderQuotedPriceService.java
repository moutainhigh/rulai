package com.unicdata.service.order;

import com.unicdata.entity.order.OrderQuotedPrice;

import java.util.List;

public interface OrderQuotedPriceService {
    /**
     * 根据客户ID 和日期等参数 获取客户的报价信息
     * @param customerId
     * @param date("yyyy-MM-dd")
     * @return
     */
    List<OrderQuotedPrice> getOrderQuotesBy(Integer customerId , String date);
}
