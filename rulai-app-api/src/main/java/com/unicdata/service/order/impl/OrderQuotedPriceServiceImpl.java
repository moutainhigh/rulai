package com.unicdata.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.dao.boutique.BoutiqueRetailMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.order.OrderQuotedPriceMapper;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderQuotedPrice;
import com.unicdata.entity.order.OrderQuotedPriceExample;
import com.unicdata.service.CounterService;
import com.unicdata.service.order.OrderQuotedPriceService;

/**
 * 报价单服务层
 *
 * @author admin
 */
@Service
public class OrderQuotedPriceServiceImpl implements OrderQuotedPriceService {

    @Autowired
    private OrderQuotedPriceMapper orderQuotedPriceMapper;
    @Autowired
    private CounterService counterService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private BoutiqueRetailMapper boutiqueRetailMapper;
    

    @Transactional
    public int addOrderQuotedPrice(OrderQuotedPrice record) {
    	//预生成报价单编号
		String number = counterService.generateCode("BJD", "yyMMdd", 8);
    	record.setNumber(number);
    	//新增报价后原有报价失效
    	int res = orderQuotedPriceMapper.updateQuotedStatus(record);
    	//订单信息
    	Order order = orderMapper.selectByPrimaryKey(record.getOrderId());
    	//订单精品信息
    	BoutiqueRetail boutiqueRetail = new BoutiqueRetail();
    	boutiqueRetail.setOrderId(record.getOrderId());
    	boutiqueRetail.setSource(0);
    	BoutiqueRetail br = boutiqueRetailMapper.selectByCondition(boutiqueRetail);
    	record.setOrderSumPrice(order.getAmount());
    	record.setVehicleId(order.getCarId());
    	record.setVehiclePrice(order.getSalePrice());
    	record.setPayFirst(order.getDeposit());
    	record.setProfit(order.getMargin());
    	record.setCusId(order.getCusId());
    	if(null != br){
        	record.setBoutiquePrice(br.getApplyCount());
    	}
        return orderQuotedPriceMapper.insertSelective(record);
    }

	@Override
	public List<OrderQuotedPrice>  selectOrderQuotedPriceList(OrderQuotedPrice record) {
		OrderQuotedPriceExample example = new OrderQuotedPriceExample();
		OrderQuotedPriceExample.Criteria criteria = example.createCriteria();
		criteria.andCusIdEqualTo(record.getCusId());
		List<OrderQuotedPrice> list = orderQuotedPriceMapper.selectByExample(example);
		return list;
	}

}
