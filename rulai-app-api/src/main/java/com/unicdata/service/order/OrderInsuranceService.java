package com.unicdata.service.order;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.order.OrderInsurance;
import com.unicdata.entity.order.OrderInsuranceItem;

/**
 * Created by lenovo on 2018/6/2.
 */
public interface OrderInsuranceService {
    List<Map<String, Object>> selectByOrderId(Integer OrderId);
    /**
     * 根据订单id查询
     * @param orderId
     * @return
     */
    Map<String, Object> getInsuranceByOrderId(Integer orderId);
    
    /**
     * 添加或修改订单保险
     * @param record
     * @return
     */
    int editOrderInsurance(OrderInsurance record,String jsonStr);

    int deleteOrderInsurance(OrderInsurance record);
    
    List<Map<String, Object>> getOrderInsuranceItem(Integer storeId,Integer orderInsuranceId);
    
    int calcInsuranceMargin(OrderInsurance record,List<OrderInsuranceItem> list);
    
    List<OrderInsurance> getOrderInsuranceByOrderId(Integer orderId);
}
