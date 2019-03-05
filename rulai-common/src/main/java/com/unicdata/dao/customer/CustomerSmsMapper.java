package com.unicdata.dao.customer;

import com.unicdata.entity.customer.CustomerSms;
import com.unicdata.entity.customer.CustomerSmsExample;
import java.util.List;

public interface CustomerSmsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerSms record);

    int insertSelective(CustomerSms record);

    List<CustomerSms> selectByExample(CustomerSmsExample example);

    CustomerSms selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerSms record);

    int updateByPrimaryKey(CustomerSms record);
}