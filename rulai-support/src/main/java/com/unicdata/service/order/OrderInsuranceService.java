package com.unicdata.service.order;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.order.OrderInsurance;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
public interface OrderInsuranceService {
    /**
     * 根据订单号获取保险相关信息
     * @param orderId
     * @return
     */
    List<Map<String, Object>> getInsuranceByOrderId(Integer orderId);

    /**
     * 根据参数获取订单保险单列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 根据id获取保险单信息
     *
     * @param id
     * @return
     */
    Map<String, Object> getInfoById(Integer id);

    /**
     * 根据id获取保险单实体
     * @param id
     * @return
     */
    OrderInsurance getById(Integer id);

    /**
     * 保存订单保险信息
     * @param orderInsurance
     * @return
     */
     int save(OrderInsurance orderInsurance);
}
