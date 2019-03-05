package com.unicdata.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.constant.SettleEnum;
import com.unicdata.dao.order.OrderInsuranceItemMapper;
import com.unicdata.dao.order.OrderInsuranceMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderInsurance;
import com.unicdata.entity.order.OrderInsuranceItem;
import com.unicdata.entity.order.OrderInsuranceItemExample;
import com.unicdata.service.order.OrderInsuranceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class OrderInsuranceItemServiceImpl implements OrderInsuranceItemService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderInsuranceMapper orderInsuranceMapper;

    @Autowired
    private OrderInsuranceItemMapper orderInsuranceItemMapper;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return orderInsuranceItemMapper.selectListByParams(params).toPageInfo();
    }

    @Override
    public Map<String, Object> getInfoById(Integer id) {
        return orderInsuranceItemMapper.getInfoById(id);
    }

    @Override
    public OrderInsuranceItem getById(Integer id) {
        return orderInsuranceItemMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    @Override
    public int save(OrderInsuranceItem orderInsuranceItem) {
        int result = 0;
        result = orderInsuranceItemMapper.updateByPrimaryKeySelective(orderInsuranceItem);
        //提交保险单（判断交强险+商业险是否都提交，如果都提交了同时把状态同步到订单表）
        if (result == 1 && Objects.equals(orderInsuranceItem.getStatus(), SettleEnum.OrderInsuranceStates.COMMITTED.getCode())) {
            OrderInsuranceItemExample example = new OrderInsuranceItemExample();
            OrderInsuranceItemExample.Criteria criteria = example.createCriteria();
            criteria.andOrderInsuranceIdEqualTo(orderInsuranceItem.getOrderInsuranceId());
            //交强险+商业险+车船税
            criteria.andLevelEqualTo(1);
            criteria.andStatusEqualTo(SettleEnum.OrderInsuranceStates.UNCOMMITTED.getCode());
            List<OrderInsuranceItem> orderInsuranceItems = orderInsuranceItemMapper.selectByExample(example);
            if (orderInsuranceItems.size() == 0) {
                OrderInsurance orderInsurance = orderInsuranceMapper.selectByPrimaryKey(orderInsuranceItem.getOrderInsuranceId());
                Order order = orderMapper.selectByPrimaryKey(orderInsurance.getOrderId());
                order.setInsurerStatus(SettleEnum.OrderInsuranceStates.COMMITTED.getCode());
                orderMapper.updateByPrimaryKeySelective(order);
            }
        }
        return result;
    }
}
