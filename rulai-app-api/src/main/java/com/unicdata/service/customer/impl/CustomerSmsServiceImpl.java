package com.unicdata.service.customer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.customer.CustomerSmsMapper;
import com.unicdata.dao.customer.CustomerSmsModelMapper;
import com.unicdata.entity.customer.CustomerSms;
import com.unicdata.entity.customer.CustomerSmsModel;
import com.unicdata.service.customer.CustomerSmsService;

/**
 * 潜客短信服务层
 *
 * @author admin
 */
@Service
public class CustomerSmsServiceImpl implements CustomerSmsService {

    @Autowired
    private CustomerSmsMapper customerSmsMapper;
    @Autowired
    private CustomerSmsModelMapper customerSmsModelMapper;

	@Override
	public List<CustomerSmsModel> selectSmsModelList() {
		return customerSmsModelMapper.selectSmsModelList();
	}

	@Override
	public int addCustomerSms(CustomerSms record) {
		return customerSmsMapper.insertSelective(record);
	}
    
}
