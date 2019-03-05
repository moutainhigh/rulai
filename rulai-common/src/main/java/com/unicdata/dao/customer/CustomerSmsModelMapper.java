package com.unicdata.dao.customer;

import com.unicdata.entity.customer.CustomerSmsModel;
import com.unicdata.entity.customer.CustomerSmsModelExample;
import java.util.List;

public interface CustomerSmsModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerSmsModel record);

    int insertSelective(CustomerSmsModel record);

    List<CustomerSmsModel> selectByExample(CustomerSmsModelExample example);

    CustomerSmsModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerSmsModel record);

    int updateByPrimaryKey(CustomerSmsModel record);
    
    List<CustomerSmsModel> selectSmsModelList();
}