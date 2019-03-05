package com.unicdata.dao.customer;

import com.github.pagehelper.Page;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.CustomerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);


    List<Map<String, Object>> getListByParams(@Param("keyword") String keyword, @Param("category") Integer category);

    //查询用户信息
    Customer selectCustomer(Customer record);
    Map<String, Object> selectCustomerMap(Customer record);

    //查询订单,交车的客户信�?
    List<Map<String, Object>> selectOrderCusByParams(Map<String,Object> params);

    //查询潜客，休眠，战败的客户信�?
    List<Map<String, Object>> selectCusByStatus(Customer record);

    /**
     * 根据参数获取分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);
    //查询客户列表 wp
    List<Map<String, Object>> selectCustomersList(Map<String,Object> params);

    /**
     * 获取�?售顾问本月建档数
     * @param params
     * @return
     */
    int getCurrentMothCusRecord(Map<String,Object> params);

    Map<String,Object> calcCustomerIntegrity(Integer id);
    /**
     * 意向车型 wp
     */
    Map<String, Object> selectAttentionCarFamily(Map<String, Object> map);
    //试驾信息 wp
    Map<String, Object> testInfo(Map<String, Object> map);

}