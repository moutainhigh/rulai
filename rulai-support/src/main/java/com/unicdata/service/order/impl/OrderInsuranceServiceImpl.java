package com.unicdata.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.constant.SettleEnum;
import com.unicdata.dao.order.OrderInsuranceMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderInsurance;
import com.unicdata.entity.order.OrderInsuranceExample;
import com.unicdata.service.order.OrderInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Create by zhang
 */
@Service
public class OrderInsuranceServiceImpl implements OrderInsuranceService {

    @Autowired
    private OrderInsuranceMapper orderInsuranceMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Map<String, Object>> getInsuranceByOrderId(Integer orderId) {
        return orderInsuranceMapper.getInsuranceByOrderId(orderId);
    }

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return orderInsuranceMapper.selectListByParams(params).toPageInfo();
    }

    @Override
    public Map<String, Object> getInfoById(Integer id) {
        return orderInsuranceMapper.getInfoById(id);
    }

    @Override
    public OrderInsurance getById(Integer id) {
        return orderInsuranceMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    @Override
    public int save(OrderInsurance orderInsurance) {
        int result = 0;
        result = orderInsuranceMapper.updateByPrimaryKeySelective(orderInsurance);
        //如果提交保险单（判断是否所有存在未提交的保险单）同时把状态同步到订单表
        if (result == 1 && Objects.equals(orderInsurance.getState(), SettleEnum.OrderInsuranceStates.COMMITTED.getCode())) {
            OrderInsuranceExample example = new OrderInsuranceExample();
            OrderInsuranceExample.Criteria criteria = example.createCriteria();
            criteria.andStateEqualTo(SettleEnum.OrderInsuranceStates.UNCOMMITTED.getCode());
            List<OrderInsurance> orderInsurances = orderInsuranceMapper.selectByExample(example);
            if (orderInsurances.size() == 0) {
                Order order = orderMapper.selectByPrimaryKey(orderInsurance.getOrderId());
                order.setInsurerStatus(SettleEnum.OrderInsuranceStates.COMMITTED.getCode());
                orderMapper.updateByPrimaryKeySelective(order);
            }
        }
        return result;
    }
}
