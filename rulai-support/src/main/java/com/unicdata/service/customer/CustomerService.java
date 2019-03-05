package com.unicdata.service.customer;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.order.OrderQuotedPrice;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    /**
     * 保存修改客户
     * @param customer
     */
    void save(Customer customer);

    /**
     * 根据ID获取客户
     * @param id
     * @return
     */
    Customer getCustomerById(Integer id);

    /**
     * 根据客户ID获取客户报价信息
     * @param id
     * @return
     */
    List<OrderQuotedPrice> getByCustomerId(Integer id);

    /**
     * 根据参数获取保险公司列表
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 获取销售顾问本月建档数
     * @param params
     * @return
     */
    int getCurrentMothCusRecord(Map<String,Object> params);

    /**
     * 判断客户是否存在
     * @param customer
     * @return
     */
    Boolean ifCustomerExist(Customer customer);
}
