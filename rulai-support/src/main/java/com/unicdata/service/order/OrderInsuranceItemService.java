package com.unicdata.service.order;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.order.OrderInsuranceItem;

import java.util.Map;

public interface OrderInsuranceItemService {

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
    OrderInsuranceItem getById(Integer id);

    /**
     * 保存订单保险信息
     * @param orderInsuranceItem
     * @return
     */
    int save(OrderInsuranceItem orderInsuranceItem);
}
