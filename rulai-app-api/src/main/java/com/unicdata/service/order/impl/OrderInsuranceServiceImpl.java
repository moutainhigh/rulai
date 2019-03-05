package com.unicdata.service.order.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.unicdata.base.util.BigDecimalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unicdata.base.util.CalculateUtils;
import com.unicdata.base.util.StringUtil;
import com.unicdata.dao.order.OrderInsuranceItemMapper;
import com.unicdata.dao.order.OrderInsuranceMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.product.InsuranceConnectionMapper;
import com.unicdata.dao.product.InsuranceTypeMapper;
import com.unicdata.dao.product.InsurerMapper;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderInsurance;
import com.unicdata.entity.order.OrderInsuranceExample;
import com.unicdata.entity.order.OrderInsuranceItem;
import com.unicdata.entity.product.InsuranceConnection;
import com.unicdata.entity.product.Insurer;
import com.unicdata.service.CounterService;
import com.unicdata.service.order.OrderInsuranceService;

/**
 * Created by lenovo on 2018/6/2.
 */
@Service
public class OrderInsuranceServiceImpl implements OrderInsuranceService{
    @Autowired
    private OrderInsuranceMapper orderInsuranceMapper;
    @Autowired
    private OrderInsuranceItemMapper orderInsuranceItemMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CounterService counterService;
    @Autowired
	private InsuranceTypeMapper insuranceTypeMapper;
    @Autowired
	private InsurerMapper insurerMapper;
    @Autowired
	private InsuranceConnectionMapper insuranceConnectionMapper;

    @Override
    public List<Map<String, Object>> selectByOrderId(Integer orderId) {
        return orderInsuranceMapper.selectByOrderId(orderId);
    }

	@Override
	public Map<String, Object> getInsuranceByOrderId(Integer orderId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", orderId);
		params.put("level", 1);
		List<Map<String, Object>> list = orderInsuranceMapper.getInsuranceListByMap(params);
		List<Map<String, Object>> companyList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> insurerList = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> tempJson = null;
		Map<String, Object> tempJson2 = null;
		String tempId = "";
		BigDecimal total = BigDecimal.ZERO;
		BigDecimal amountTotal = BigDecimal.ZERO;
		BigDecimal donationTotal = BigDecimal.ZERO;
		for (Map<String, Object> company:list) {
			String companyId = String.valueOf(company.get("companyId"));
			if(!tempId.equals(companyId)){
				tempId = companyId;
				tempJson = new HashMap<String, Object>();
				tempJson.put("companyId", Integer.valueOf(companyId));
				tempJson.put("companyName", company.get("companyName"));
				tempJson.put("id", company.get("id"));
//				tempJson.put("remarks", company.get("remarks"));
				tempJson.put("state", company.get("state"));
				BigDecimal saleCount = new BigDecimal(String.valueOf(company.get("sumMoney")));
				total = total.add(saleCount);
				BigDecimal totalAmount = new BigDecimal(String.valueOf(company.get("totalAmount")));
				amountTotal = amountTotal.add(totalAmount);
				BigDecimal donationAmount = new BigDecimal(String.valueOf(company.get("donationAmount")));
				donationTotal = donationTotal.add(donationAmount);
				insurerList = new ArrayList<Map<String, Object>>();
				for(Map<String, Object> insurer:list){
					String insurerCompanyId = String.valueOf(insurer.get("companyId"));
					if(companyId.equals(insurerCompanyId)){
						tempJson2 = new HashMap<String, Object>();
						tempJson2.put("insurerId", insurer.get("insurerId"));
						tempJson2.put("insurerName", insurer.get("insurerName"));
						tempJson2.put("insuredAmount", insurer.get("price"));
//						tempJson2.put("insuredAmount", insurer.get("insuredAmount"));
						insurerList.add(tempJson2);
					}
				}
				tempJson.put("insurerList", insurerList);
				companyList.add(tempJson);
			}
		}
		resultMap.put("companyList", companyList);
		resultMap.put("saleCount", total);
		resultMap.put("donationAmount", donationTotal);
		resultMap.put("totalAmount", amountTotal);
		return resultMap;
	}

	@Transactional
	public int editOrderInsurance(OrderInsurance record,String jsonStr) {
		//查询订单保险
		OrderInsurance temp = orderInsuranceMapper.getInsuranceByMap(record);
		int res = 0;
		if(null != temp){
			record.setId(temp.getId());
			res = orderInsuranceMapper.updateByPrimaryKeySelective(record);
			//先删除保险订单明细
			orderInsuranceItemMapper.deleteByOrderInsuranceId(temp.getId());
		}else{
			record.setState(1);
	    	record.setNumber(counterService.generateCode("DDBX", "yyMMdd",8));
			res = orderInsuranceMapper.insertSelective(record);
			if(res>0){
				//修改订单保险状态
		        Order tempOrder = new Order();
		        tempOrder.setId(record.getOrderId());
		        tempOrder.setInsurerStatus(1);
		        orderMapper.updateByPrimaryKeySelective(tempOrder);
			}
		}
		BigDecimal total = BigDecimal.ZERO;
		if(res>0){
			//赠送金额归零
        	List<Map<String, Object>> insuranceList = orderInsuranceMapper.selectByOrderId(record.getOrderId());
        	OrderInsurance insurance = null;
    		if(insuranceList != null && insuranceList.size()>1){
    			for(Map<String, Object> map:insuranceList){
            		String totalAmount = String.valueOf(map.get("totalAmount"));
            		String id = String.valueOf(map.get("id"));
            		insurance = new OrderInsurance();
            		insurance.setId(Integer.valueOf(id));
            		insurance.setSumMoney(new BigDecimal(totalAmount));
            		insurance.setDonationAmount(BigDecimal.ZERO);
            		orderInsuranceMapper.updateByPrimaryKeySelective(insurance);
            	}
    		}
			/*OrderInsurance tempInsurance = new OrderInsurance();
			tempInsurance.setOrderId(record.getOrderId());
			tempInsurance.setDonationAmount(BigDecimal.ZERO);
			orderInsuranceMapper.updateByOrderId(tempInsurance);*/
			//添加保险订单明细
			int orderInsuranceId = record.getId();
			if(StringUtil.isNotBlank(jsonStr)){
				JSONArray jsonArr = JSON.parseArray(jsonStr);
				List<OrderInsuranceItem> list = new ArrayList<OrderInsuranceItem>();
				OrderInsuranceItem oii = null;
				for (int i = 0; i < jsonArr.size(); i++) {
					String remarks = "";
					JSONObject json = jsonArr.getJSONObject(i);
					Integer choiceStatus = json.getInteger("choiceStatus");
					if(choiceStatus==1){
						oii = new OrderInsuranceItem();
						oii.setOrderInsuranceId(orderInsuranceId);
						oii.setInsuranceId(json.getInteger("id"));
						oii.setLevel(json.getInteger("level"));
						oii.setStatus(1);
						oii.setParentId(json.getInteger("parentId"));
						BigDecimal moneyNum = json.getBigDecimal("moneyNum");
						oii.setPrice(moneyNum);
						if(json.getInteger("level") == 1){
							if(moneyNum!=null){
								total = total.add(moneyNum);
							}
						}else{
							oii.setInsuredAmount(json.getBigDecimal("insuredAmount"));
						}
						if(json.getInteger("id") == 3){//商业险把子险种用逗号拼接
							for (int j = 0; j < jsonArr.size(); j++) {
								JSONObject child = jsonArr.getJSONObject(j);
								Integer childChoiceStatus = child.getInteger("choiceStatus");
								if(child.getInteger("level") == 2 && childChoiceStatus == 1){
									remarks += ","+child.getString("name");
								}
							}
							//当保险选中三年联保时需要将 剩余年份和第一年的保险分开计算，这里设置计算第一年的保险毛利 update by shenyong 2018-07-23
							if(record.getIsRenewal() == 1) {
								//用联保剩余金额/剩余年份 得到每一年的金额
								oii.setPrice(BigDecimalUtils.div(record.getRenewalBalance(),BigDecimal.valueOf(record.getRenewalYears()),2));
							}
							remarks = remarks.substring(1);
						}else{
							remarks = json.getString("name");
						}
						oii.setRemarks(remarks);
						list.add(oii);
					}
				}
				if(list!=null && list.size()>0){
					orderInsuranceItemMapper.insertBatch(list);
					if(total.intValue()>0){
						OrderInsurance tempRecord = new OrderInsurance();
						tempRecord.setId(orderInsuranceId);
						tempRecord.setSumMoney(total);
						tempRecord.setTotalAmount(total);
						tempRecord.setDonationAmount(BigDecimal.ZERO);
						orderInsuranceMapper.updateByPrimaryKeySelective(tempRecord);
						//计算毛利
						calcInsuranceMargin(record, list);
					}
				}
			}
		}
		return res;
	}
	
	@Transactional
	public int calcInsuranceMargin(OrderInsurance record,List<OrderInsuranceItem> list){
		int res = 0;
		//查询订单保险
		OrderInsurance temp = orderInsuranceMapper.getInsuranceByMap(record);
		BigDecimal total = BigDecimal.ZERO;
		if(null != temp) {
			int insuranceCompanyId = temp.getInsuranceCompanyId();
			//计算三年联保剩余年份的毛利,第一年的毛利由下面那个循环计算  update by shenyong 2018-07-23
			if (temp.getIsRenewal() == 1 ){
				Insurer insurer = insurerMapper.selectByPrimaryKey(insuranceCompanyId);
				BigDecimal rebateRatio = insurer.getRebateRatio();
				BigDecimal taxRemovalRatio = insurer.getTaxRemovalRatio();
				BigDecimal cost = insurer.getCost();
				BigDecimal price = temp.getRenewalBalance();
				total = total.add(CalculateUtils.calcInsuranceProfit(price, taxRemovalRatio, rebateRatio, cost));
			}
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("insurerId", insuranceCompanyId);
			for(OrderInsuranceItem oii:list){
				if(oii.getLevel()==1 && oii.getInsuranceId()!=2){
					params.put("insuranceId", oii.getInsuranceId());
					InsuranceConnection ic = insuranceConnectionMapper.getInsuranceConnectionByMap(params);
					BigDecimal rebateRatio = ic.getRebateRatio();
					BigDecimal taxRemovalRatio = ic.getTaxRemovalRatio();
					BigDecimal cost = ic.getCost();
					BigDecimal price = oii.getPrice();
					total = total.add(CalculateUtils.calcInsuranceProfit(price, taxRemovalRatio, rebateRatio, cost));
				}
			}
		}
		if(total.intValue()>0){
			OrderInsurance tempRecord = new OrderInsurance();
			tempRecord.setId(temp.getId());
			tempRecord.setMargin(total);
			res = orderInsuranceMapper.updateByPrimaryKeySelective(tempRecord);
		}
		return res;
	}

	@Override
	public List<Map<String, Object>> getOrderInsuranceItem(Integer storeId,Integer orderInsuranceId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderInsuranceId", orderInsuranceId);
		params.put("level", 1);
		params.put("storeId", storeId);
		List<Map<String, Object>> list1 = orderInsuranceItemMapper.selectByMap(params);
		for(Map<String, Object> map:list1){
			String parentId = String.valueOf(map.get("id"));
			params.put("level", 2);
			params.put("parentId", parentId);
			List<Map<String, Object>> list2 = orderInsuranceItemMapper.selectByMap(params);
			for (Map<String, Object> insuranceType : list2) {
				Integer selfDefined = Integer.valueOf(String.valueOf(insuranceType.get("selfDefined")));
				if(selfDefined == 2){
					params.put("insuranceId", insuranceType.get("id"));
					List<Map<String, Object>> amountList = insuranceTypeMapper.selectInsuredAmounts(params);
					insuranceType.put("amountList", amountList);
				}
			}
			map.put("childTypes", list2);
		}
		return list1;
	}

	@Override
	public int deleteOrderInsurance(OrderInsurance record) {
		int res = orderInsuranceItemMapper.deleteByOrderInsuranceId(record.getId());
		if(res>0){//删除订单明细后再删除保险订单
			res = orderInsuranceMapper.deleteByOrderInsurance(record);
		}
		return res;
	}

	@Override
	public List<OrderInsurance> getOrderInsuranceByOrderId(Integer orderId) {
		OrderInsuranceExample example = new OrderInsuranceExample();
		OrderInsuranceExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		return orderInsuranceMapper.selectByExample(example);
	}
}
