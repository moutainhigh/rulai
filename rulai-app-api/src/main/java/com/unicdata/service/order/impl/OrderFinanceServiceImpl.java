package com.unicdata.service.order.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.base.util.StringUtil;
import com.unicdata.dao.order.OrderFinanceMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.product.FinanceCompanyMapper;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderFinance;
import com.unicdata.entity.product.FinanceCompany;
import com.unicdata.entity.product.FinanceCompanyExample;
import com.unicdata.service.order.OrderFinanceService;

/**
 * 金融贷款服务层
 * @author admin
 *
 */
@Service
public class OrderFinanceServiceImpl implements OrderFinanceService {

    @Autowired
    private FinanceCompanyMapper financeCompanyMapper;
    @Autowired
    private OrderFinanceMapper orderFinanceMapper;
    @Autowired
    private OrderMapper orderMapper;


    @Transactional(readOnly=true)
	public List<Map<String, Object>> selectFinanceCompany(FinanceCompany record) {
		FinanceCompanyExample example = new FinanceCompanyExample();
		FinanceCompanyExample.Criteria criteria = example.createCriteria();
    	criteria.andStoreIdEqualTo(record.getStoreId());
    	criteria.andEnabledEqualTo(true);
    	criteria.andStateEqualTo(1);
    	List<FinanceCompany> list = financeCompanyMapper.selectByExample(example);
    	List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
    	Map<String, Object> map = null;
    	for(FinanceCompany company:list){
    		map = new HashMap<String, Object>();
    		map.put("id", company.getId());
    		map.put("name", company.getName());
    		resultList.add(map);
    	}
    	return resultList;
	}
	
	@Override
    public Map<String, Object> getOrderFinance(Integer orderId) {
		List<Map<String, Object>> list = orderFinanceMapper.getOrderFinance(orderId);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
        return new HashMap<String, Object>();
    }

	@Override
	public int updateOrderFinance(OrderFinance record) {
		record.setTotalAmount(record.getCharge().add(record.getMortgageCharge()));
		record.setSumFinancePrice(record.getTotalAmount());
		record.setMargin(record.getSumFinancePrice());
		record.setDonationAmount(BigDecimal.ZERO);
		Map<String, Object> map = orderFinanceMapper.selectByOrderId(record.getOrderId());
		int res = 0;
		if(map!=null){
			String id = String.valueOf(map.get("id"));
			if(StringUtil.isNotBlank(id)){
				record.setId(Integer.valueOf(id));
			}
			res = orderFinanceMapper.updateByPrimaryKeySelective(record);
		}else{
			record.setLoanStatus(1);
			res = orderFinanceMapper.insertSelective(record);
			if(res>0){
				//修改订单金融状态
		        Order tempOrder = new Order();
		        tempOrder.setId(record.getOrderId());
		        tempOrder.setFinanceStatus(1);
		        orderMapper.updateByPrimaryKeySelective(tempOrder);
			}
		}
		return res;
	}

	@Override
	public int deleteOrderFinance(Integer orderId) {
		return orderFinanceMapper.deleteOrderFinance(orderId);
	}

	@Override
	public List<Map<String, Object>> selectFinanceYears(Map<String, Object> params) {
		return financeCompanyMapper.selectFinanceYears(params);
	}

	@Override
	public OrderFinance getOrderFinanceByOrderId(Integer orderId) {
		return orderFinanceMapper.getOrderFinanceByOrderId(orderId);
	}

}
