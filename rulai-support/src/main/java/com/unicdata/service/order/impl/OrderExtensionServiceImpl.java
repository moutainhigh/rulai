package com.unicdata.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.constant.SettleEnum;
import com.unicdata.dao.order.OrderExtensionMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderExtension;
import com.unicdata.entity.order.OrderExtensionExample;
import com.unicdata.service.order.OrderExtensionService;
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
public class OrderExtensionServiceImpl implements OrderExtensionService {

    @Autowired
    private OrderExtensionMapper orderExtensionMapper;

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<Map<String, Object>> getOrderExtension(Integer orderId) {
        return orderExtensionMapper.getOrderExtension(orderId);
    }

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return orderExtensionMapper.selectListByParams(params).toPageInfo();
    }

    @Override
    public OrderExtension getById(Integer id) {
        return orderExtensionMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    @Override
    public int save(OrderExtension orderExtension) {
        int result = 0;
        result = orderExtensionMapper.updateByPrimaryKeySelective(orderExtension);
        if(result == 1 && Objects.equals(orderExtension.getState(), SettleEnum.OrderInsuranceStates.COMMITTED.getCode())){
            OrderExtensionExample example = new OrderExtensionExample();
            OrderExtensionExample.Criteria criteria = example.createCriteria();
            criteria.andOrderIdEqualTo(orderExtension.getOrderId());
            criteria.andStateEqualTo(SettleEnum.OrderInsuranceStates.UNCOMMITTED.getCode());
            List<OrderExtension> orderExtensions = orderExtensionMapper.selectByExample(example);
            if (orderExtensions.size() == 0) {
                Order order = orderMapper.selectByPrimaryKey(orderExtension.getOrderId());
                order.setExtensionStatus(SettleEnum.OrderInsuranceStates.COMMITTED.getCode());
                orderMapper.updateByPrimaryKeySelective(order);
            }
        }
        return result;
    }
}
