package com.unicdata.service.order;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.order.OrderExtension;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
public interface OrderExtensionService {
    /**
     * 订单延保信息
     * @param orderId
     * @return
     */
    List<Map<String,Object>> getOrderExtension(Integer orderId);

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
     * 根据ID获取延保单实体
     * @param id
     * @return
     */
    OrderExtension getById(Integer id);

    /**
     * 延保保存
     * @param orderExtension
     */
    int save(OrderExtension orderExtension);
}
