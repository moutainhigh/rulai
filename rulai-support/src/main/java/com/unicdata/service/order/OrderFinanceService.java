package com.unicdata.service.order;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.order.OrderFinance;
import com.unicdata.entity.system.Employee;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
public interface OrderFinanceService {
    /**
     * 根据订单号获取金融信息
     * @param orderId
     * @return
     */
    List<Map<String,Object>> getOrderFinance(Integer orderId);

    /**
     * 根据参数获取金融管理列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 保存金融单（同步状态）
     * @param orderFinance
     * @param employee 当前登录人
     * @return
     */
    int save(OrderFinance orderFinance , Employee employee);

    /**
     * 根据ID获取金融信息
     * @param id
     */
    OrderFinance getOrderFinanceById(Integer id);
    /**
     * 根据订单id获取金融信息和付款信息
     */
    Map orderFinancePay(Integer orderId);
}
