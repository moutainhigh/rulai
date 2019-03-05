package com.unicdata.service.order.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.base.util.BigDecimalUtils;
import com.unicdata.base.util.CalculateUtils;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.ConstantEnum.enumIsOrNoStatus;
import com.unicdata.dao.order.OrderExtensionMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.product.InsuranceExtensionMapper;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderExtension;
import com.unicdata.entity.product.InsuranceExtension;
import com.unicdata.service.CounterService;
import com.unicdata.service.order.OrderExtensionService;

/**
 * 延保服务层
 * @author admin
 *
 */
@Service
public class OrderExtensionServiceImpl implements OrderExtensionService {
    @Autowired
    private OrderExtensionMapper orderExtensionMapper;
    @Autowired
    private CounterService counterService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private InsuranceExtensionMapper insuranceExtensionMapper;

	@Override
	public Map<String, Object> getOrderExtension(Integer orderId) {
		List<Map<String, Object>> list = orderExtensionMapper.getOrderExtension(orderId);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return new HashMap<String, Object>();
	}

	@Override
	public int deleteOrderExtension(Integer orderId) {
		return orderExtensionMapper.deleteByOrderId(orderId);
	}

	@Override
	public int updateOrderExtension(OrderExtension record) {
		Map<String, Object> map = orderExtensionMapper.selectByOrderId(record.getOrderId());
		InsuranceExtension ie = insuranceExtensionMapper.selectByPrimaryKey(record.getExtensionId());
		//毛利
		record.setMargin(CalculateUtils.calcoOrderExtensionProfit(ie.getPrice(), ie.getCost(), ie.getType(), ie.getRebate()));
		record.setDonationAmount(BigDecimal.ZERO);
		record.setTotalAmount(record.getSumPrice());
		int res = 0;
		if(map!=null){
			String id = String.valueOf(map.get("id"));
			if(StringUtil.isNotBlank(id)){
				record.setId(Integer.valueOf(id));
			}
			res = orderExtensionMapper.updateByPrimaryKeySelective(record);
		}else{
			record.setNumber(counterService.generateCode("DDYB","yyMMdd",8));
			record.setState(1);
			res = orderExtensionMapper.insertSelective(record);
			if(res>0){
				//修改订单延保状态
		        Order tempOrder = new Order();
		        tempOrder.setId(record.getOrderId());
		        tempOrder.setExtensionStatus(1);
		        orderMapper.updateByPrimaryKeySelective(tempOrder);
			}
		}
		return res;
	}

	@Override
	public OrderExtension getOrderExtensionByOrderId(Integer orderId) {
		return orderExtensionMapper.getOrderExtensionByOrderId(orderId);
	}
	

}
