package com.unicdata.dao.customer;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.customer.TransactCustomer;

public interface TransactCustomerMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(TransactCustomer record);

    int insertSelective(TransactCustomer record);

    TransactCustomer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TransactCustomer record);

    int updateByPrimaryKey(TransactCustomer record);
    //获取办事人员列表 wp
    List<Map<String , Object>> selectTransactCustomer(Map<String , Object> map);
}