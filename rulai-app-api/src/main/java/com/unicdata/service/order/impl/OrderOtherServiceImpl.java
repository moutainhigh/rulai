package com.unicdata.service.order.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unicdata.base.util.StringUtil;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.order.OrderServiceItemMapper;
import com.unicdata.dao.order.OrderServiceMapper;
import com.unicdata.dao.order.StoreServiceMapper;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderService;
import com.unicdata.entity.order.OrderServiceExample;
import com.unicdata.entity.order.OrderServiceItem;
import com.unicdata.entity.order.StoreService;
import com.unicdata.entity.order.StoreServiceExample;
import com.unicdata.service.order.OrderOtherService;

/**
 * 订单其他服务层
 * @author admin
 *
 */
@Service
public class OrderOtherServiceImpl implements OrderOtherService {
	@Autowired
    private OrderServiceMapper orderServiceMapper;
	@Autowired
    private StoreServiceMapper storeServiceMapper;
	@Autowired
    private OrderServiceItemMapper orderServiceItemMapper;
	@Autowired
    private OrderMapper orderMapper;

	@Override
	public Map<String, Object> getOrderServiceByOrderId(Integer orderId) {
		Map<String, Object> resultMap = orderServiceMapper.findByOrderId(orderId);
		if(null != resultMap){
			String id = String.valueOf(resultMap.get("id"));
			List<Map<String, Object>> list = orderServiceItemMapper.getItemsByOrderServiceId(Integer.valueOf(id));
			resultMap.put("serviceList", list);
		}
		return resultMap;
	}

	@Override
	public List<Map<String,Object>> selectStoreService(Integer storeId) {
		StoreServiceExample example = new StoreServiceExample();
		StoreServiceExample.Criteria criteria = example.createCriteria();
		criteria.andStoreIdEqualTo(storeId);
		List<StoreService> list = storeServiceMapper.selectByExample(example);
		//返回数据
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		for(StoreService ss:list){
			map = new HashMap<String,Object>();
			map.put("id", ss.getId());
			map.put("serviceName", ss.getServiceName());
			map.put("servicePrice", ss.getServicePrice());
			map.put("choiceStatus", 0);
			map.put("brand", "");
			map.put("donationAmount",0);
			mapList.add(map);
		}
		return mapList;
	}

	@Transactional
	public int addOrderOtherService(Integer orderId,String jsonStr) {
		Integer orderServiceId = null;
		Map<String, Object> map = orderServiceMapper.findByOrderId(orderId);
		if(null != map){//修改先删除
    		String idStr = String.valueOf(map.get("id"));
    		orderServiceId = Integer.valueOf(idStr);
    		//删除
    		OrderServiceItem osi = new OrderServiceItem();
    		osi.setOrderServiceId(orderServiceId);
    		orderServiceItemMapper.deleteOrderServiceItem(osi);
    	}else{
    		OrderService record = new OrderService();
    		record.setOrderId(orderId);
    		int res = orderServiceMapper.insertSelective(record);
    		if(res>0){
				//修改订单其他状态
		        Order tempOrder = new Order();
		        tempOrder.setId(record.getOrderId());
		        tempOrder.setOtherStatus(1);
		        orderMapper.updateByPrimaryKeySelective(tempOrder);
			}
    		orderServiceId = record.getId();
    	}
    	//其他服务子项
    	List<OrderServiceItem> list = new ArrayList<OrderServiceItem>();
    	OrderServiceItem orderServiceItem = null;
    	if(StringUtil.isNotBlank(jsonStr)){
    		JSONArray serviceArr = JSON.parseArray(jsonStr);
    		for (int i = 0; i < serviceArr.size(); i++) {
    			JSONObject os = serviceArr.getJSONObject(i);
    			String id = os.getString("id");
    			BigDecimal servicePrice = os.getBigDecimal("servicePrice");
    			String remark = os.getString("remark");
    			String brand = os.getString("brand");
    			Integer choiceStatus = os.getInteger("choiceStatus");
    			if(choiceStatus==1){//选中的
    				orderServiceItem = new OrderServiceItem();
        			orderServiceItem.setOrderServiceId(orderServiceId);
        			orderServiceItem.setServiceId(Integer.valueOf(id));
        			orderServiceItem.setServicePrice(servicePrice);
        			orderServiceItem.setRemark(remark);
        			orderServiceItem.setBrand(brand);
        			list.add(orderServiceItem);
    			}
			}
    	}
    	//批量插入
    	if(list!=null && list.size()>0){
    		orderServiceItemMapper.addOrderServiceItem(list);
    	}
    	//计算毛利
    	List<Map<String, Object>> itemList = orderServiceItemMapper.getItemsByOrderServiceId(orderServiceId);
    	BigDecimal cost = BigDecimal.ZERO;
    	BigDecimal substitution = BigDecimal.ZERO;
    	for(Map<String, Object> item:itemList){
    		int id = Integer.valueOf(String.valueOf(item.get("id")));
        	if(id!=2){
            	String taxPrice = String.valueOf(item.get("cost"));
            	cost = cost.add(new BigDecimal(taxPrice));
        	}else{
        		String servicePrice = String.valueOf(item.get("servicePrice"));
        		substitution =  new BigDecimal(servicePrice);
        	}
        }
		//修改其他服务总价
		BigDecimal sumOtherPrice = orderServiceItemMapper.getSumByOrderServiceId(orderServiceId);
		OrderService record = new OrderService();
		record.setId(orderServiceId);
		record.setSumOtherPrice(sumOtherPrice);
		record.setTotalAmount(sumOtherPrice);
		record.setDonationAmount(BigDecimal.ZERO);
		record.setMargin(sumOtherPrice.subtract(substitution).subtract(cost));
		int res = orderServiceMapper.updateByPrimaryKeySelective(record);
		return res;
	}

	@Override
	public int addOrderOtherService(List<OrderService> list) {
		return orderServiceMapper.addOrderOtherService(list);
	}

	@Override
	public List<Map<String, Object>> getOrderService(Integer orderId) {
		Map<String, Object> resultMap = orderServiceMapper.findByOrderId(orderId);
		String id = String.valueOf(resultMap.get("id"));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderServiceId", id);
		return orderServiceItemMapper.getItemsByMap(params);
	}

	@Override
	public int deleteOrderOtherService(Integer orderId,Integer serviceId) {
		//跟进订单id查询其他服务
		Map<String, Object> resultMap = orderServiceMapper.findByOrderId(orderId);
		String orderServiceId = resultMap!=null?String.valueOf(resultMap.get("id")):"0";
		//删除其他服务明细项
		OrderServiceItem record = new OrderServiceItem();
		record.setOrderServiceId(Integer.valueOf(orderServiceId));
		record.setServiceId(serviceId);
		int res = orderServiceItemMapper.deleteOrderServiceItem(record);
		if(res>0){
			List<Map<String, Object>> list = orderServiceItemMapper.getItemsByOrderServiceId(Integer.valueOf(orderServiceId));
			BigDecimal saleCount = BigDecimal.ZERO;
			for(Map<String, Object> map:list){
				String service_price = String.valueOf(map.get("servicePrice"));
				BigDecimal money = new BigDecimal(service_price);
				saleCount = saleCount.add(money);
			}
			//更新总价
			OrderService orderService = new OrderService();
			orderService.setId(Integer.valueOf(orderServiceId));
			orderService.setSumOtherPrice(saleCount);
			orderServiceMapper.updateByPrimaryKeySelective(orderService);
		}
		return res;
	}

	@Override
	public int updateOrderOtherServiceItem(OrderServiceItem record) {
		return orderServiceItemMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public OrderService getServiceByOrderId(Integer orderId) {
		return orderServiceMapper.getServiceByOrderId(orderId);
	}
}
