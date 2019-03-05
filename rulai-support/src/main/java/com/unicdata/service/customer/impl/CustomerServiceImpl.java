package com.unicdata.service.customer.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.dao.customer.CustomerMapper;
import com.unicdata.dao.order.OrderQuotedPriceMapper;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.CustomerExample;
import com.unicdata.entity.order.OrderQuotedPrice;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.util.NumberGenerateUtil;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderQuotedPriceMapper orderQuotedPriceMapper;

    @Transactional(readOnly = false)
    @Override
    public void save(Customer customer) {
        if (customer.getId() == null) {
            customer.setCreateTime(new Date());
            customer.setModifyTime(new Date());
            customerMapper.insertSelective(customer);
        } else {
            customer.setModifyTime(new Date());
            customerMapper.updateByPrimaryKeySelective(customer);
        }
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderQuotedPrice> getByCustomerId(Integer id) {
        return null;
    }

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return customerMapper.selectListByParams(params).toPageInfo();
    }

    @Override
    public int getCurrentMothCusRecord(Map<String, Object> params) {
        return customerMapper.getCurrentMothCusRecord(params);
    }

    @Override
    public Boolean ifCustomerExist(Customer customer) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(customer.getPhone());
        criteria.andStoreIdEqualTo(customer.getStoreId());
        if (customer.getId() != null) {
            criteria.andIdNotEqualTo(customer.getId());
        }
        List<Customer> customers = customerMapper.selectByExample(example);
        return (customers == null || customers.isEmpty()) ? Boolean.FALSE : Boolean.TRUE;
    }
}
