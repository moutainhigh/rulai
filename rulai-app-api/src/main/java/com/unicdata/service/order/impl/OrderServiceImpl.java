package com.unicdata.service.order.impl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.util.BigDecimalUtils;
import com.unicdata.base.util.CalculateUtils;
import com.unicdata.base.util.DateUtil;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.CarEnum;
import com.unicdata.dao.boutique.BoutiqueRetailIncludeMapper;
import com.unicdata.dao.boutique.BoutiqueRetailMapper;
import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.order.EquipmentMapper;
import com.unicdata.dao.order.OrderExtensionMapper;
import com.unicdata.dao.order.OrderFinanceMapper;
import com.unicdata.dao.order.OrderInsuranceItemMapper;
import com.unicdata.dao.order.OrderInsuranceMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.order.OrderServiceItemMapper;
import com.unicdata.dao.order.OrderServiceMapper;
import com.unicdata.dao.order.OrderSetMealItemMapper;
import com.unicdata.dao.order.OrderSetMealMapper;
import com.unicdata.dao.product.InsuranceExtensionMapper;
import com.unicdata.dao.product.InsurerMapper;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.CarWashExample;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.order.Equipment;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderExtension;
import com.unicdata.entity.order.OrderFinance;
import com.unicdata.entity.order.OrderInsurance;
import com.unicdata.entity.order.OrderInsuranceItem;
import com.unicdata.entity.order.OrderInsuranceItemExample;
import com.unicdata.entity.order.OrderSetMeal;
import com.unicdata.entity.product.InsuranceExtension;
import com.unicdata.entity.product.Insurer;
import com.unicdata.service.order.OrderInsuranceService;
import com.unicdata.service.order.OrderOtherService;
import com.unicdata.service.order.OrderService;
import com.unicdata.service.order.OrderSetMealService;

/**
 * 订单服务层
 *
 * @author admin
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    CarGoodInfoMapper carGoodInfoMapper;
    @Autowired
    private BoutiqueRetailMapper boutiqueRetailMapper;
    @Autowired
    private BoutiqueRetailIncludeMapper boutiqueRetailIncludeMapper;
    @Autowired
    private OrderExtensionMapper orderExtensionMapper;
    @Autowired
    private InsuranceExtensionMapper insuranceExtensionMapper;
    @Autowired
    private OrderSetMealService orderSetMealService;
    @Autowired 
    private OrderSetMealMapper orderSetMealMapper;
    @Autowired
    private OrderSetMealItemMapper orderSetMealItemMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private OrderFinanceMapper orderFinanceMapper;
    @Autowired
    private OrderInsuranceMapper orderInsuranceMapper;
    @Autowired
    private OrderInsuranceItemMapper orderInsuranceItemMapper;
    @Autowired
    private OrderInsuranceService orderInsuranceService;
    @Autowired
    private OrderServiceMapper orderServiceMapper;
	@Autowired
    private OrderServiceItemMapper orderServiceItemMapper;
	@Autowired
    private OrderOtherService orderOtherService;


    @Transactional(readOnly = true)
    public PageInfo selectOrderList(Integer pageNum, Integer pageSize, Map<String, Object> map) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = orderMapper.selectOrderList(map);
        String currentDate = DateUtil.dateFormat(new Date(), "yyyy-MM-dd");
        for (Map<String, Object> order : list) {
            //跟进任务
            String nextDate = String.valueOf(order.get("nextDate"));
            int res = DateUtil.daysBetween(currentDate, nextDate);
            if (res == 0) {
                nextDate = "今日跟进";
            } else if (res > 0) {
                nextDate = nextDate.substring(5) + "跟进";
            } else {
                nextDate = "逾期" + (-res) + "天";
            }
            String cusCreateTime = String.valueOf(order.get("cusCreateTime"));
            int curRes = DateUtil.daysBetween(cusCreateTime, currentDate);
            if (curRes > 0) {
                cusCreateTime = "建档" + curRes + "天";
            } else {
                cusCreateTime = cusCreateTime.substring(0, 10);
            }
            order.put("cusCreateTime", cusCreateTime);
            order.put("nextDate", nextDate);
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        return pageInfo;
    }

    @Transactional(readOnly = true)
    public Order selectOrderbyId(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int getCurrentMothOrderNum(Integer employeeId, Integer status) {
        Order record = new Order();
        record.setCreateId(employeeId);
        record.setStatus(status);
        return orderMapper.getCurrentMothOrderNum(record);
    }

    /**
     * 本月订单数
     *
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> getMothOrderNumByStoreId(Map<String, Object> map) {
        return orderMapper.getMothOrderNumByStoreId(map);
    }

    @Override
    public Map<String, Object> orderDetail(Integer orderId) {
        return orderMapper.orderDetail(orderId);
    }

    @Override
    public List<Order> selectByCusId(Integer cusId) {
        return orderMapper.selectByCusId(cusId);
    }

    @Transactional
    public int createOrder(Order order) {
    	Integer carId = order.getCarId();
    	if(order.getMatchingCarId()!=null){//计算整车毛利
    		carId = order.getMatchingCarId();
    	}
    	BigDecimal carCost = BigDecimal.ZERO;//整车成本
    	BigDecimal carPrice = order.getSalePrice();//整车售价
    	BigDecimal margin = BigDecimal.ZERO;//毛利
		CarGoodInfoWithBLOBs car = carGoodInfoMapper.selectByPrimaryKey(carId);
		if(car!=null){
			carCost = carCost.add(car.getEntirePurchasePrice());
			carCost = carCost.subtract(car.getForecastProfit());
			margin = margin.add(carPrice.subtract(carCost));
		}
		order.setMargin(margin);
        return orderMapper.insertSelective(order);
    }

    @Override
    public Order selectByMap(Map<String, Object> params) {
        return orderMapper.selectByMap(params);
    }

    @Transactional
    public int updateAllPrice(Map<String, Object> params) {
        int res = 0;
        if (params != null) {
            Integer orderId = Integer.valueOf(String.valueOf(params.get("orderId")));
            Integer type = Integer.valueOf(String.valueOf(params.get("type")));
            BigDecimal price = new BigDecimal(String.valueOf(params.get("price")));
            //  1：整车 2：精品 3：保险 4：延保    5：代金券 6：保养套餐 7：金融  8：订金 9：其他
            if (type == 1) {
                Order order = new Order();
                order.setId(orderId);
                order.setSalePrice(price);
                res = orderMapper.updateByPrimaryKeySelective(order);
            } else if (type == 2) {
            	BoutiqueRetail br = boutiqueRetailMapper.selectBoutiqueRetailDetailByOrderId(orderId);
            	BigDecimal applyCount = price != null?price:BigDecimal.ZERO;
            	//修改价格
            	BoutiqueRetail record = new BoutiqueRetail();
            	record.setId(br.getId());
            	record.setApplyCount(price);
                //计算毛利
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("retailId", record.getId());
                List<Map<String, Object>> informationList = boutiqueRetailIncludeMapper.getBoutiquePackageByMap(map);
                BigDecimal cost = BigDecimal.ZERO;
                for(Map<String, Object> info:informationList){
                	String taxPrice = String.valueOf(info.get("taxPrice"));
                	cost = cost.add(new BigDecimal(taxPrice));
                }
                record.setMargin(applyCount.subtract(cost));
                res = boutiqueRetailMapper.updateByPrimaryKeySelective(record);
            } else if (type == 3) {
            	//查询订单保险单信息
            	List<Map<String, Object>> list = orderInsuranceMapper.selectByOrderId(orderId);
            	OrderInsurance insurance = null;
        		BigDecimal total = BigDecimal.ZERO;//多家保险公司合计
        		if(list != null && list.size()>1){
        			for(Map<String, Object> map:list){
                		String totalAmount = String.valueOf(map.get("totalAmount"));
                		total = total.add(new BigDecimal(totalAmount));
                	}
        		}
            	//分配赠送金额
            	for(Map<String, Object> map:list){
            		String totalAmountStr = String.valueOf(map.get("totalAmount"));
            		String companyId = String.valueOf(map.get("insurance_company_id"));
            		String id = String.valueOf(map.get("id"));
            		insurance = new OrderInsurance();
            		insurance.setId(Integer.valueOf(id));
            		if(list.size()==1){
            			insurance.setDonationAmount(price);
            		}else{
            			BigDecimal r = BigDecimalUtils.div(new BigDecimal(totalAmountStr),total);
                		insurance.setDonationAmount(price.multiply(r));
            		}
            		insurance.setSumMoney(new BigDecimal(totalAmountStr).subtract(insurance.getDonationAmount()));
            		res = orderInsuranceMapper.updateByPrimaryKeySelective(insurance);
            		if(res>0){
            			//计算毛利
                		OrderInsuranceItemExample example = new OrderInsuranceItemExample();
                		OrderInsuranceItemExample.Criteria criteria = example.createCriteria();
                        criteria.andOrderInsuranceIdEqualTo(insurance.getId());
                		List<OrderInsuranceItem> itemList = orderInsuranceItemMapper.selectByExample(example);
                		insurance.setInsuranceCompanyId(Integer.valueOf(companyId));
                		insurance.setOrderId(orderId);
                		orderInsuranceService.calcInsuranceMargin(insurance, itemList);
            		}
            	}
            } else if (type == 4) {
            	Map<String, Object> map = orderExtensionMapper.selectByOrderId(orderId);
            	if(map!=null){
            		String id = String.valueOf(map.get("id"));
            		String extensionId = String.valueOf(map.get("extensionId"));
            		String totalAmountStr = String.valueOf(map.get("totalAmount"));
            		BigDecimal totalAmount = new BigDecimal(totalAmountStr);
            		totalAmount = totalAmount.subtract(price);
            		OrderExtension record = new OrderExtension();
            		record.setId(Integer.valueOf(id));
            		record.setDonationAmount(price);
            		record.setSumPrice(totalAmount);
            		InsuranceExtension ie = insuranceExtensionMapper.selectByPrimaryKey(Integer.valueOf(extensionId));
            		//毛利
            		record.setMargin(CalculateUtils.calcoOrderExtensionProfit(record.getSumPrice(), ie.getCost(), ie.getType(), ie.getRebate()));
            		res = orderExtensionMapper.updateByPrimaryKeySelective(record);
            	}
        		
            } else if (type == 5 || type == 6) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("orderId", orderId);
                map.put("type", type == 5 ? 2 : 1);
                Map<String, Object> osm = orderSetMealMapper.getOrderSetMeal(map);
                if (osm != null) {
                    int id = Integer.valueOf(String.valueOf(osm.get("id")));
                    String totalAmountStr = String.valueOf(osm.get("totalAmount"));
            		BigDecimal totalAmount = new BigDecimal(totalAmountStr);
            		totalAmount = totalAmount.subtract(price);
                    OrderSetMeal orderSetMeal = new OrderSetMeal();
                    orderSetMeal.setId(id);
                    orderSetMeal.setDonationAmount(price);
                    orderSetMeal.setSumMealPrice(totalAmount);
                    //计算毛利
                    map.put("orderSetmealId", id);
                    List<Map<String, Object>> list = orderSetMealItemMapper.getOrderSetMealItem(map);
                    BigDecimal costCount = BigDecimal.ZERO;
            		for(Map<String, Object> item:list){
            			String costStr = String.valueOf(item.get("cost"));
            			String buyNum = String.valueOf(item.get("buyNum"));
            			BigDecimal num = new BigDecimal(StringUtil.isNotBlank(buyNum)?buyNum:"1");
            			BigDecimal cost = new BigDecimal(costStr);
            			cost = cost.multiply(num);
            			costCount = costCount.add(cost);//成本
            		}
            		orderSetMeal.setMargin(orderSetMeal.getSumMealPrice().subtract(costCount));
                    res = orderSetMealMapper.updateByPrimaryKeySelective(orderSetMeal);
                }
            } else if (type == 7) {
            	Map<String, Object> map = orderFinanceMapper.selectByOrderId(orderId);
            	if(map!=null){
            		OrderFinance record = new OrderFinance();
        			String id = String.valueOf(map.get("id"));
        			String totalAmountStr = String.valueOf(map.get("totalAmount"));
             		BigDecimal totalAmount = new BigDecimal(totalAmountStr);
             		totalAmount = totalAmount.subtract(price);
    				record.setId(Integer.valueOf(id));
             		record.setDonationAmount(price);
             		record.setSumFinancePrice(totalAmount);
             		record.setMargin(record.getSumFinancePrice());
        			res = orderFinanceMapper.updateByPrimaryKeySelective(record);
        		}
            } else if (type == 8) {
                Order order = new Order();
                order.setId(orderId);
                order.setDeposit(price);
                res = orderMapper.updateByPrimaryKeySelective(order);
            } else if (type == 9) {
            	Integer orderServiceId = null;
        		Map<String, Object> map = orderServiceMapper.findByOrderId(orderId);
        		if(null != map){//修改先删除
            		String idStr = String.valueOf(map.get("id"));
            		orderServiceId = Integer.valueOf(idStr);
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
        		com.unicdata.entity.order.OrderService record = new com.unicdata.entity.order.OrderService();
        		record.setId(orderServiceId);
        		record.setSumOtherPrice(sumOtherPrice.subtract(price));
        		record.setDonationAmount(price);
        		record.setMargin(sumOtherPrice.subtract(substitution).subtract(cost));
        		res = orderServiceMapper.updateByPrimaryKeySelective(record);
            }
        }
        return res;
    }

    @Override
    public int calcUpdateOrderAmount(Integer orderId) {
    	BigDecimal amountTotal = BigDecimal.ZERO;//订单总额
    	BigDecimal donationAmountTotal = BigDecimal.ZERO;//赠送金额
    	BigDecimal marginTotal = BigDecimal.ZERO;//毛利
    	BigDecimal carCost = BigDecimal.ZERO;//整车成本
    	BigDecimal carPrice = BigDecimal.ZERO;//整车售价
    	//订单
    	Order order = orderMapper.selectByPrimaryKey(orderId);
    	Integer carId = order.getMatchingCarId();
		//当分配车辆id没有的时候 拿car_id 的成本计算（零时解决方案。以后需要调整成获取车型的成本数据进行计算） update by shenyong 2018-07-23
    	if(carId == null || carId <= 0){
			carId = order.getCarId();
    	}
		//设置整车成本
		CarGoodInfoWithBLOBs car = carGoodInfoMapper.selectByPrimaryKey(carId);
		carCost = carCost.add(car.getEntirePurchasePrice());
		carCost = carCost.subtract(car.getForecastProfit());

    	if(order!=null && order.getSalePrice()!=null){
    		amountTotal = amountTotal.add(order.getSalePrice());
    		carPrice = order.getSalePrice();
    	}
    	BoutiqueRetail boutiqueRetail = new BoutiqueRetail();
    	boutiqueRetail.setOrderId(orderId);
    	//精品
    	boutiqueRetail = boutiqueRetailMapper.selectByCondition(boutiqueRetail);
    	if(boutiqueRetail!=null && boutiqueRetail.getApplyCount()!=null){
    		amountTotal = amountTotal.add(boutiqueRetail.getApplyCount());
    	}
    	if(boutiqueRetail!=null && boutiqueRetail.getMargin()!=null){
    		marginTotal = marginTotal.add(boutiqueRetail.getMargin());
    	}
    	//精品赠送
    	if(boutiqueRetail!=null){
    		Map<String, Object> calcParams = new HashMap<String, Object>();
            calcParams.put("retailId", boutiqueRetail.getId());
            calcParams.put("isGift", 1);
            //计算总价
            BigDecimal priceSum = boutiqueRetailIncludeMapper.calcBoutiqueSumByRetailId(calcParams);
        	if(priceSum!=null){
        		donationAmountTotal = donationAmountTotal.add(priceSum);
        	}
    	}
        //延保
    	OrderExtension orderExtension = orderExtensionMapper.getOrderExtensionByOrderId(orderId);
    	if(orderExtension!=null && orderExtension.getSumPrice()!=null){
    		amountTotal = amountTotal.add(orderExtension.getSumPrice());
    	}
    	if(orderExtension!=null && orderExtension.getDonationAmount()!=null){
    		donationAmountTotal = donationAmountTotal.add(orderExtension.getDonationAmount());
    	}
    	if(orderExtension!=null && orderExtension.getMargin()!=null){
    		marginTotal = marginTotal.add(orderExtension.getMargin());
    	}
    	//金融
    	OrderFinance orderFinance = orderFinanceMapper.getOrderFinanceByOrderId(orderId);
    	if(orderFinance!=null){
    		if(orderFinance.getMortgageCharge()!=null)
        		amountTotal = amountTotal.add(orderFinance.getMortgageCharge());
    		if(orderFinance.getCharge()!=null)
        		amountTotal = amountTotal.add(orderFinance.getCharge());
    	}
    	if(orderFinance!=null && orderFinance.getDonationAmount()!=null){
    		donationAmountTotal = donationAmountTotal.add(orderFinance.getDonationAmount());
    	}
    	if(orderFinance!=null && orderFinance.getMargin()!=null){
    		marginTotal = marginTotal.add(orderFinance.getMargin());
    	}
    	//保险
    	List<OrderInsurance> insuranceList = orderInsuranceService.getOrderInsuranceByOrderId(orderId);
    	if(insuranceList!=null){
    		for(OrderInsurance oi:insuranceList){
    			amountTotal = amountTotal.add(oi.getSumMoney());
    			donationAmountTotal = donationAmountTotal.add(oi.getDonationAmount());
        		marginTotal = marginTotal.add(oi.getMargin());
    		}
    	}
    	//保养套餐
    	List<OrderSetMeal> orderSetMeal = orderSetMealService.getOrderSetMealByOrderId(orderId);
    	if(orderSetMeal!=null){
    		for(OrderSetMeal osm:orderSetMeal){
    			amountTotal = amountTotal.add(osm.getSumMealPrice());
    			donationAmountTotal = donationAmountTotal.add(osm.getDonationAmount());
    			marginTotal = marginTotal.add(osm.getMargin());
    		}
    	}
    	//其他服务
    	com.unicdata.entity.order.OrderService orderService = orderOtherService.getServiceByOrderId(orderId);
    	if(orderService!=null && orderService.getSumOtherPrice()!=null){
    		amountTotal = amountTotal.add(orderService.getSumOtherPrice());
    	}
    	if(orderService!=null && orderService.getDonationAmount()!=null){
    		donationAmountTotal = donationAmountTotal.add(orderService.getDonationAmount());
    	}
    	if(orderService!=null && orderService.getMargin()!=null){
    		marginTotal = marginTotal.add(orderService.getMargin());
    	}
    	if(donationAmountTotal !=null)
    		carCost = carCost.add(donationAmountTotal);
    	if(carPrice !=null)//整车毛利
    		marginTotal = marginTotal.add(carPrice.subtract(carCost));
    	//更新订单
        Order tempOrder = new Order();
        tempOrder.setId(orderId);
        tempOrder.setAmount(amountTotal);
        tempOrder.setMargin(marginTotal);
        tempOrder.setDonationAmount(donationAmountTotal);
        int res = orderMapper.updateByPrimaryKeySelective(tempOrder);
        return res;
    }

    @Override
    public int saveOrderEquipment(Equipment record) {
        return equipmentMapper.insertSelective(record);
    }

    /**
     * 通过订单对象获取订单数量
     * @return
     */
    @Override
    public int getCurrentMothOrderNumTwo(Map<String, Object> map) {
        return orderMapper.getCurrentMothOrderNumTwo(map);
    }
}
