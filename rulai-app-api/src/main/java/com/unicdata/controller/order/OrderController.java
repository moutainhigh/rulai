package com.unicdata.controller.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.Constant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.CarEnum.SupplyStatus;
import com.unicdata.constant.ConstantEnum.AppOrderStatus;
import com.unicdata.constant.ConstantEnum.CarPriceStatus;
import com.unicdata.constant.ConstantEnum.nextServiceItem;
import com.unicdata.constant.ConstantEnum.nextTaskChannel;
import com.unicdata.constant.ConstantEnum.nextTaskContent;
import com.unicdata.constant.CustomerEnum;
import com.unicdata.constant.CustomerEnum.CustomerCategory;
import com.unicdata.constant.MessageCode;
import com.unicdata.constant.OrderEnum.ApprovalOrderType;
import com.unicdata.constant.PushEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.approval.ApprovalOrder;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.PassengerFlow;
import com.unicdata.entity.customer.TaskFollowUp;
import com.unicdata.entity.order.DeliverCar;
import com.unicdata.entity.order.Equipment;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderQuotedPrice;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.CounterService;
import com.unicdata.service.approval.ApprovalOrderService;
import com.unicdata.service.boutique.BoutiqueRetailService;
import com.unicdata.service.car.AppCarGoodInfoService;
import com.unicdata.service.car.AppDeliverCarService;
import com.unicdata.service.carInfo.CarVehicleService;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.customer.TaskFollowUpService;
import com.unicdata.service.employee.AppEmployeeService;
import com.unicdata.service.order.OrderExtensionService;
import com.unicdata.service.order.OrderFinanceService;
import com.unicdata.service.order.OrderInsuranceService;
import com.unicdata.service.order.OrderOtherService;
import com.unicdata.service.order.OrderQuotedPriceService;
import com.unicdata.service.order.OrderService;
import com.unicdata.service.order.OrderSetMealService;
import com.unicdata.service.push.PushMessageService;
import com.unicdata.util.RedisUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 订单管理
 * @author admin
 *
 */
@Controller
@RequestMapping("/app/order")
@Api(value="订单相关接口",tags={"订单相关接口"})
public class OrderController extends HomeBaseController {

    @Autowired
    private OrderQuotedPriceService orderQuotedPriceService;
    @Autowired
    private ApprovalOrderService approvalOrderService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderFinanceService orderFinanceService;;
    @Autowired
    private OrderExtensionService orderExtensionService;
    @Autowired
    private OrderInsuranceService orderInsuranceService;
    @Autowired
    private OrderOtherService orderOtherService;
    @Autowired
    private OrderSetMealService orderSetMealService;
    @Autowired
    private BoutiqueRetailService boutiqueRetailService;
    @Autowired
    private AppDeliverCarService deliverCarService;
    @Autowired
    private AppCarGoodInfoService carGoodInfoService;
    @Autowired
    private CounterService counterService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    TaskFollowUpService taskFollowUpService;
    @Autowired
    private AppEmployeeService appEmployeeService;
    @Autowired
    private PushMessageService pushMessageService;
    @Autowired
    private CarVehicleService carVehicleService;

    
    @ApiOperation(value="订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数，默认30", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/orderList",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo orderList(HttpServletRequest request,Integer pageNum, Integer pageSize){
		//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		//订单列表
		map.put("storeId", emp.getStoreId());
		PageInfo pageInfo = orderService.selectOrderList(pageNum,pageSize,map);
		resultMap.put("list", pageInfo.getList());
		resultMap.put("pageResult", getPageResult(pageInfo));
		ari.setData(resultMap);
        return ari;
    }
    
    @ApiOperation(value="查看订单详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单号必填", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/orderDetail",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo orderDetail(HttpServletRequest request,Integer orderId){
    	//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
		Map<String,Object> map = new HashMap<String,Object>();
		//订单详情
		Map<String, Object> orderDetail = orderService.orderDetail(orderId);
		int priceTag = 1;
		if(orderDetail!=null){
			String carId = String.valueOf(orderDetail.get("carId"));
			String salePriceStr = String.valueOf(orderDetail.get("salePrice"));
			if(StringUtil.isNotBlank(carId)){
				int num = -1;
				BigDecimal salePrice = new BigDecimal(salePriceStr); 
				BigDecimal[] priceArr = carVehicleService.selectCarLimitPrice(Integer.valueOf(carId));
				//[销售顾问，销售经理，总经理]
				if(SALES_CONSULTANT_POSITION.equals(emp.getPostName())){//销售顾问
					BigDecimal price = priceArr[0];
					num = salePrice.compareTo(price);
				}else if(SALES_MANAGER_POSITION.equals(emp.getPostName())){//销售经理
					BigDecimal price = priceArr[0];
					num = salePrice.compareTo(price);
				}else if(TOP_MANAGER.equals(emp.getPostName())){//总经理
					BigDecimal price = priceArr[0];
					num = salePrice.compareTo(price);
				}
				if(num>=0){//正常
					priceTag = 2;
				}
			}
			orderDetail.put("priceTag", priceTag);
		}
        Map<String, Object> orderFinance = orderFinanceService.getOrderFinance(orderId);
        Map<String, Object> orderExtension = orderExtensionService.getOrderExtension(orderId);
        Map<String, Object> insurance = orderInsuranceService.getInsuranceByOrderId(orderId);
        Map<String, Object> orderService = orderOtherService.getOrderServiceByOrderId(orderId);
        Map<String, Object> orderMaintain = orderSetMealService.getOrderSetMeal(orderId,1);
//        Map<String, Object> orderCashCoupon = orderSetMealService.getOrderSetMeal(orderId,2);
        //订单精品部分
        Map<String, Object> boutiqueMap = boutiqueRetailService.getBoutiqueListByOrderId(orderId);
        //返回数据
        Map<String, Object> result = new HashMap<>();
        result.put("orderDetail", orderDetail !=null?orderDetail:new HashMap<String, Object>());
        result.put("orderFinance", orderFinance !=null?orderFinance:new HashMap<String, Object>());
        result.put("orderExtension", orderExtension !=null?orderExtension:new HashMap<String, Object>());
        result.put("orderInsurance", insurance !=null?insurance:new HashMap<String, Object>());
        result.put("orderService", orderService !=null?orderService:new HashMap<String, Object>());
        result.put("orderMaintain", orderMaintain !=null?orderMaintain:new HashMap<String, Object>());
        result.put("orderCashCoupon", new HashMap<String, Object>());
        result.put("orderBoutique", boutiqueMap !=null?boutiqueMap:new HashMap<String, Object>());
    	ari.setData(result);
        return ari;
    }
    
	@ApiOperation(value="订单报价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单号必填", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderSumPrice", value = "订单总金额必填", required = true, dataType = "BigDecimal")
    })
    @RequestMapping(value = "/quotedPrice",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo quotedPrice(HttpServletRequest request,OrderQuotedPrice quotedPrice){
		//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
		Map<String,Object> map = new HashMap<String,Object>();
		//生成报价单
		quotedPrice.setEmployeeId(emp.getId());
		orderQuotedPriceService.addOrderQuotedPrice(quotedPrice);
    	ari.setData(map);
        return ari;
    }
	
	@ApiOperation(value="历史订单报价列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cusId", value = "客户id", required = true, dataType = "BigDecimal")
    })
    @RequestMapping(value = "/quotedPriceList",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo quotedPriceList(HttpServletRequest request,OrderQuotedPrice quotedPrice){
		//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
		Map<String,Object> map = new HashMap<String,Object>();
		//查询报价单
		quotedPrice.setEmployeeId(emp.getId());
		List<OrderQuotedPrice> list = orderQuotedPriceService.selectOrderQuotedPriceList(quotedPrice);
    	ari.setData(list);
        return ari;
    }
    
	@ApiOperation(value="提交订单审批")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalType", value = "申请类型必填", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id必填", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderStatus", value = "订单状态必填", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "unsubscribeReason", value = "原因", required = true, dataType = "String")
    })
    @RequestMapping(value = "/submitApprovalOrder")
    @ResponseBody
    public ApiReturnInfo approvalOrder(HttpServletRequest request,ApprovalOrder record){
    	//当前用户
		Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
		//发起审批
    	record.setEmployeeId(emp.getId());
    	int res = approvalOrderService.createApprovalOrder(record);
    	if(res>0){
        	/*//保存极光推送消息
    		Map<String, Object> mapc = new HashMap<>();
            mapc.put("storeId", emp.getStoreId());
            ArrayList<String> strings = new ArrayList<>();
            if(record.getApprovalType() == ApprovalOrderType.ORDER.getCode()){
                strings.add(SALES_INFORMATION_OFFICER);
            }
            strings.add(SALES_MANAGER_POSITION);
            //销售顾问
            mapc.put("postNameList", strings);
            //订单审批推送标识
            mapc.put("n", 2);
    		List<Map<String, Object>> mapList = appEmployeeService.selectEmployeIdByPostName(mapc);
    		String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_ORDER_NEW_APPLY);
    		pushMessageService.createPushMessage(PushEnum.PushType.ORDER_SUBMIT.getCode(), PushEnum.PushType.ORDER_SUBMIT.getDesc(), content, emp.getId(), mapList);
    		*/
            
            Map<String, Object> mapc = new HashMap<>();
            mapc.put("storeId", emp.getStoreId());
            ArrayList<String> strings = new ArrayList<>();
            if(record.getApprovalType() == ApprovalOrderType.ORDER.getCode()){
            	Order order = orderService.selectOrderbyId(record.getOrderId());
                strings.add(SALES_INFORMATION_OFFICER);//销售信息员
                mapc.put("postNameList", strings);
                //订单审批推送标识
                mapc.put("n", 2);
        		List<Map<String, Object>> mapList = appEmployeeService.selectEmployeIdByPostName(mapc);
        		String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_ORDER_NEW_APPLY_INFORMATION);
        		content = content.replace("XXX", emp.getFullName()).replace("YYY",order.getCusName()).replace("ZZZ", order.getOrderNum());
        		pushMessageService.createPushMessage(PushEnum.PushType.ORDER_SUBMIT.getCode(), PushEnum.PushType.ORDER_SUBMIT.getDesc(), content, emp.getId(), mapList);
            }
            strings = new ArrayList<>();
            //销售顾问
            strings.add(SALES_MANAGER_POSITION);
            mapc.put("postNameList", strings);
            //订单审批推送标识
            mapc.put("n", 2);
    		List<Map<String, Object>> mapList = appEmployeeService.selectEmployeIdByPostName(mapc);
    		String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_ORDER_NEW_APPLY);
    		Integer type = PushEnum.PushType.ORDER_NEW_APPLY.getCode();
    		String desc = PushEnum.PushType.ORDER_NEW_APPLY.getDesc();
    		if(record.getApprovalType() == ApprovalOrderType.ORDEROUT.getCode()){
    			type = PushEnum.PushType.ORDER_REFUND_APPLY.getCode();
        		desc = PushEnum.PushType.ORDER_REFUND_APPLY.getDesc();
    		}
    		pushMessageService.createPushMessage(type, desc, content, emp.getId(), mapList);
    	}
    	ari.setData(null);
        return ari;
    }
	
	@ApiOperation(value="完善订单信息并提交生效")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "订单id必填", required = true, dataType = "String"),
            @ApiImplicitParam(name = "useType", value = "使用人类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "useName", value = "车主姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "useIphone", value = "车主电话", required = true, dataType = "String"),
            @ApiImplicitParam(name = "cardType", value = "证件类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "number", value = "证件号码/组织机构代码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "deliveryDate", value = "预计交车日期", required = true, dataType = "String"),
            @ApiImplicitParam(name = "doneTime", value = "预计全款日期", required = true, dataType = "String")
    })
    @RequestMapping(value = "/updateOrder",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo updateOrder(HttpServletRequest request,Order record){
    	ApiReturnInfo ari = new ApiReturnInfo();
    	//完善订单客户信息并提交生效
    	record.setStatus(AppOrderStatus.待付款.getCode());
    	int res = orderService.updateByPrimaryKeySelective(record);
    	if(res>0){
    		Order tempOrder = orderService.selectOrderbyId(record.getId());
    		//订单生效，更新客户状态由潜客变为订单
            Customer customer = new Customer();
            customer.setId(tempOrder.getCusId());
            //客户分类设置为订单
            customer.setCategory(CustomerEnum.CustomerCategory.ORDER_CUS.getCode());
            customer.setModifyTime(new Date());
            customerService.updateByPrimaryKeySelective(customer);
    	}
    	ari.setData(null);
        return ari;
    }
	
	@ApiOperation(value="订单交车提交")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id必填", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "serviceEmpId", value = "售后服务人员id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "deliverImg", value = "交车照片", required = true, dataType = "String")
    })
    @RequestMapping(value = "/addDeliverCar")
    @ResponseBody
    public ApiReturnInfo addDeliverCar(HttpServletRequest request,DeliverCar record){
		//当前用户
		Employee emp = getMember(request);
		ApiReturnInfo ari = new ApiReturnInfo();
    	//订单信息
    	Order order = orderService.selectOrderbyId(record.getOrderId());
		//完善订单客户信息
    	record.setCarId(order.getCarId());
    	record.setCusId(order.getCusId());
    	record.setCreateId(emp.getId());
    	record.setStoreId(emp.getStoreId());
    	int res = deliverCarService.addDeliverCar(record);
    	if(res>0){
    		//修改用户阶段类型
    		Customer customer = new Customer();
    		customer.setId(order.getCusId());
    		customer.setCategory(CustomerCategory.DELIVERY_CAR_CUS.getCode());
    		customerService.updateByPrimaryKeySelective(customer);
    		//修改订单状态
    		Order tempOrder = new Order();
    		tempOrder.setId(record.getOrderId());
    		tempOrder.setStatus(AppOrderStatus.已交车.getCode());
    		orderService.updateByPrimaryKeySelective(tempOrder);
    		
    		//添加任务跟进记录
    		Date date = DateUtil.now();
    		TaskFollowUp taskFollowUp = new TaskFollowUp();
    		taskFollowUp.setCreateId(emp.getId());
    		taskFollowUp.setCustomerId(order.getCusId());
    		taskFollowUp.setOrderId(record.getOrderId());
    		taskFollowUp.setOrderStatus(order.getStatus());
    		taskFollowUp.setChennel(nextTaskChannel.展厅接待.getCode());
    		taskFollowUp.setContent(nextTaskContent.今日交车.getCode());
    		taskFollowUp.setThisDate(date);
    		taskFollowUp.setNextDate(DateUtil.addDays(date, 30));
    		taskFollowUp.setNextChennel(nextTaskChannel.电话.getCode());
    		taskFollowUp.setNextContent(nextTaskContent.后续服务.getCode());
    		taskFollowUp.setNextServiceItem(nextServiceItem.首保邀约.getCode());
    		taskFollowUpService.addTaskFollowUpRecord(taskFollowUp);
    	}
    	ari.setData(null);
        return ari;
    }
	
	@ApiOperation(value="库存-进入选购页面")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carId", value = "车辆id非必填", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "cusId", value = "客户id非必填", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/chooseBuyCar")
    @ResponseBody
    public ApiReturnInfo chooseBuyCar(HttpServletRequest request,Integer carId,Integer cusId){
		//当前用户
		Employee emp = getMember(request);
		ApiReturnInfo ari = new ApiReturnInfo();
		Map<String, Object> map = new HashMap<String, Object>();
    	//预生成订单编号
		String orderCode = counterService.generateCode("DD", "yyMMdd", 8);
		Map<String, Object> carMap = new HashMap<>();
		Map<String, Object> customerMap = new HashMap<>();
		if(carId != null && carId != 0){
			carMap = carGoodInfoService.getCarDetailById(carId);
		}
		if(cusId != null && cusId != 0){
			Customer c = customerService.selectByPrimaryKey(cusId);
			customerMap.put("name", c.getName());
			customerMap.put("phone", c.getPhone());
			customerMap.put("useName","");
			customerMap.put("useIphone","");
			map.put("cusName", c.getName());
		}
		map.put("orderCode", orderCode);
		map.put("status", 1);
		map.put("createTime", DateUtil.dateFormat(DateUtil.now(), "yyyy-MM-dd HH:mm:ss"));
		map.put("carId", carId);
		map.put("cusId", cusId);
		map.put("carGoods", carMap);
		map.put("customer", customerMap);
		//保存订单信息到Redis缓存中
		RedisUtil.set(Constant.CHOOSE_BUY_CAR+"_"+emp.getId(), map);
		map.put("createTime", DateUtil.dateFormat(DateUtil.now(), "MM-dd"));
		ari.setData(map);
        return ari;
    }
	
	@ApiOperation(value="选购-添加客户-创建订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "客户id或客流id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "type", value = "类型  1：客户id 2：客流id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "手机", required = true, dataType = "String")
    })
    @RequestMapping(value = "/createCustomerAndOrder")
    @ResponseBody
    public ApiReturnInfo createCustomerAndOrder(HttpServletRequest request,Integer id,Integer type,String name,String phone){
		//当前用户
		Employee emp = getMember(request);
		ApiReturnInfo ari = new ApiReturnInfo();
		Customer customer = new Customer();
		if(type.equals(2)){//客流创建
			customer.setName(name);
			customer.setPhone(phone);
			customer.setPassengerId(id);
			customer.setEmployeeId(emp.getId());
			customer.setStoreId(emp.getStoreId());
			customerService.updateCustomer(customer, null);
		}else{
			if(null != id && 0 != id){
				customer.setId(id);
				customer = customerService.selectCustomer(customer);
			}else{
				customer.setName(name);
				customer.setPhone(phone);
				customer.setEmployeeId(emp.getId());
				customer.setStoreId(emp.getStoreId());
				customerService.updateCustomer(customer, null);
			}
		}
		
		//从Redis里取出订单缓存信息
		Map<String, Object> orderMap = RedisUtil.get(Constant.CHOOSE_BUY_CAR+"_"+emp.getId(), Map.class);
    	//订单信息
    	Order order = new Order();
    	order.setCusId(customer.getId());
    	String orderNum = String.valueOf(orderMap.get("orderCode"));
    	order.setCusName(customer.getName());
    	order.setCusIphone(customer.getPhone());
    	//查询orderNum是否已经存在订单
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orderNum", orderNum);
    	Order o = orderService.selectByMap(params);
    	if(null == o){
    		//判断同一客户是否存在未交车的订单
    		List<Order> orderList = orderService.selectByCusId(customer.getId());
    		for(Order obj:orderList){//不重复下单
    			if(obj.getStatus() <= AppOrderStatus.待交车.getCode()){
    				ari.setCode(ResultCodeEnum.RESULT_CODE_ORDER_EXISTENT.getCode());
        			ari.setMessage(ResultCodeEnum.RESULT_CODE_ORDER_EXISTENT.getMessage());
        			ari.setData(null);
        			return ari;
    			}
    		}
    		String carIdStr = String.valueOf(orderMap.get("carId"));
    		//完善订单客户信息
    		if(carIdStr!=null && !carIdStr.equals("0")){
    			int carId = Integer.valueOf(carIdStr);
    			order.setCarId(carId);//正常销售
    			order.setMatchingCarId(carId);
    			//查询车辆id是否已经被销售出去
            	params = new HashMap<String, Object>();
            	params.put("carId", carId);
            	params.put("excludeStatus", 9);
            	Order carOrder = orderService.selectByMap(params);
            	//选购车辆id
            	Map<String, Object> carMap = carGoodInfoService.getCarDetailById(carId);
            	String includeBoutiquePrice = carMap!=null?String.valueOf(carMap.get("includeBoutiquePrice")):"0";
            	BigDecimal ibp = new BigDecimal(includeBoutiquePrice);
            	if(carOrder!=null){//车辆被销售中自动分配同车型其他vin车辆
            		String vehicleIdStr = String.valueOf(carMap.get("vehicleId"));
                	List<CarGoodInfo> list = carGoodInfoService.getCarListByVehicleId(Integer.valueOf(vehicleIdStr));
                	if(list!=null && list.size()>0){
                		order.setCarId(list.get(0).getId());
                		order.setMatchingCarId(list.get(0).getId());
                    	ibp = list.get(0).getIncludeBoutiquePrice();
                	}else{//没有同车型vin车辆
                		order.setMatchingCarId(null);
                	}
            	}
            	order.setAmount(ibp);
            	order.setSalePrice(ibp);
    		}
        	order.setStoreId(emp.getStoreId());
        	order.setCreateId(emp.getId());
        	order.setOrderNum(orderNum);
        	order.setCreateTime(DateUtil.stringToDate(String.valueOf(orderMap.get("createTime")),"yyyy-MM-dd HH:mm:ss"));
        	order.setStatus(AppOrderStatus.未生效.getCode());
        	order.setCarPriceStatus(CarPriceStatus.未提交.getCode());
        	if(order.getMatchingCarId()!=null){
        		order.setCarStatus(1);
        	}
        	int res = orderService.createOrder(order);
        	if(res>0 && order.getMatchingCarId()!=null){
        		//修改车辆配车状态
        		CarGoodInfoWithBLOBs cgi = new CarGoodInfoWithBLOBs();
        		cgi.setId(order.getMatchingCarId());
        		cgi.setCarSupplyStatus(SupplyStatus.SUPPLY_ING.getCode());
        		carGoodInfoService.updateCarGoodInfo(cgi);
        		//新增配车记录
        		Equipment equipment = new Equipment();
        		equipment.setCusId(order.getCreateId());
        		equipment.setOrderId(order.getId());
        		equipment.setCarId(order.getMatchingCarId());
        		equipment.setType(1);
        		orderService.saveOrderEquipment(equipment);
        	}
    	}else{
    		order.setId(o.getId());
    		orderService.updateByPrimaryKeySelective(order);
    	}
    	orderMap.put("orderId", order.getId());
    	orderMap.put("name", customer.getName());
    	orderMap.put("phone", customer.getPhone());
    	orderMap.put("useName", StringUtil.safeToString(order.getUseName(),""));
    	orderMap.put("useIphone", StringUtil.safeToString(order.getUseIphone(),""));
    	ari.setData(orderMap);
        return ari;
    }
	
	@ApiOperation(value="选购-添加车辆-创建订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carId", value = "车辆id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/createCarAndOrder")
    @ResponseBody
    public ApiReturnInfo createCarAndOrder(HttpServletRequest request,Integer carId){
		//当前用户
		Employee emp = getMember(request);
		ApiReturnInfo ari = new ApiReturnInfo();
		//从Redis里取出订单缓存信息
		Map<String, Object> orderMap = RedisUtil.get(Constant.CHOOSE_BUY_CAR+"_"+emp.getId(), Map.class);
		Map<String, Object> car = carGoodInfoService.getCarDetailById(carId);
		//订单信息
    	Order order = new Order();
    	String orderNum = String.valueOf(orderMap.get("orderCode"));
    	String cusIdStr = String.valueOf(orderMap.get("cusId"));
    	String cusName = String.valueOf(orderMap.get("cusName"));
    	order.setCarId(carId);
    	order.setMatchingCarId(carId);
    	order.setCusId(Integer.valueOf(cusIdStr));
    	order.setCusName(cusName);
    	//查询orderNum是否已经存在订单
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orderNum", orderNum);
    	Order o = orderService.selectByMap(params);
    	if(null == o){
    		String idStr = String.valueOf(orderMap.get("cusId"));
    		//判断同一客户是否存在未交车的订单
    		List<Order> orderList = orderService.selectByCusId(Integer.valueOf(idStr));
    		for(Order obj:orderList){//不重复下单
    			if(obj.getStatus() <= AppOrderStatus.待交车.getCode()){
    				ari.setCode(ResultCodeEnum.RESULT_CODE_ORDER_EXISTENT.getCode());
        			ari.setMessage(ResultCodeEnum.RESULT_CODE_ORDER_EXISTENT.getMessage());
        			ari.setData(null);
        			return ari;
    			}
    		}
    		//查询车辆id是否已经被销售出去
        	params = new HashMap<String, Object>();
        	params.put("carId", carId);
        	params.put("excludeStatus", 9);
        	Order carOrder = orderService.selectByMap(params);
        	String includeBoutiquePrice = car!=null?String.valueOf(car.get("includeBoutiquePrice")):"0";
        	BigDecimal ibp = new BigDecimal(includeBoutiquePrice);
        	if(carOrder!=null){//车辆被销售中自动分配同车型其他vin车辆
        		String vehicleIdStr = String.valueOf(car.get("vehicleId"));
            	List<CarGoodInfo> list = carGoodInfoService.getCarListByVehicleId(Integer.valueOf(vehicleIdStr));
            	if(list!=null && list.size()>0){
            		order.setCarId(list.get(0).getId());
            		order.setMatchingCarId(list.get(0).getId());
                	ibp = list.get(0).getIncludeBoutiquePrice();
            	}else{//没有同车型vin车辆
            		order.setMatchingCarId(null);
            	}
        	}
    		//完善订单客户信息
        	order.setStoreId(emp.getStoreId());
        	order.setCreateId(emp.getId());
        	order.setOrderNum(orderNum);
        	order.setCreateTime(DateUtil.stringToDate(String.valueOf(orderMap.get("createTime")),"yyyy-MM-dd HH:mm:ss"));
        	order.setStatus(AppOrderStatus.未生效.getCode());
        	order.setCarPriceStatus(CarPriceStatus.未提交.getCode());
        	if(order.getMatchingCarId()!=null){
        		order.setCarStatus(1);
        	}
        	order.setAmount(ibp);
        	order.setSalePrice(ibp);
        	int res = orderService.createOrder(order);
        	if(res>0 && order.getMatchingCarId()!=null){
        		//修改车辆配车状态
        		CarGoodInfoWithBLOBs cgi = new CarGoodInfoWithBLOBs();
        		cgi.setId(order.getMatchingCarId());
        		cgi.setCarSupplyStatus(SupplyStatus.SUPPLY_ING.getCode());
        		carGoodInfoService.updateCarGoodInfo(cgi);
        		//新增配车记录
        		Equipment equipment = new Equipment();
        		equipment.setCusId(order.getCreateId());
        		equipment.setOrderId(order.getId());
        		equipment.setCarId(order.getMatchingCarId());
        		equipment.setType(1);
        		orderService.saveOrderEquipment(equipment);
        	}
    	}else{
    		order.setId(o.getId());
    		orderService.updateByPrimaryKeySelective(order);
    	}
    	orderMap.put("orderId", order.getId());
    	orderMap.put("carId", carId);
    	orderMap.put("familyId", car.get("familyId"));
    	orderMap.put("salesdesc", car.get("salesdesc"));
    	orderMap.put("decorationsOutName", car.get("decorationsOutName"));
    	orderMap.put("decorationsInName", car.get("decorationsInName"));
    	orderMap.put("optionalPackageStatus", car.get("optionalPackageStatus"));
    	orderMap.put("standardPrice", car.get("standardPrice"));
    	orderMap.put("includeBoutiquePrice", car.get("includeBoutiquePrice"));
    	orderMap.put("salePrice", car.get("includeBoutiquePrice"));
    	ari.setData(orderMap);
        return ari;
    }
	
	@ApiOperation(value="修改订单相关价格")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "类型 1：整车 2：精品 3：保险 4：延保    5：代金券 6：保养套餐 7：金融  8：订金 9：其他", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "price", value = "价格", required = true, dataType = "BigDecimal")
    })
    @RequestMapping(value = "/updatePrice",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo updatePrice(HttpServletRequest request,Integer orderId,BigDecimal price,Integer type){
    	ApiReturnInfo ari = new ApiReturnInfo();
    	Map<String,Object> map = new HashMap<String, Object>();
    	map.put("orderId", orderId);
    	map.put("type", type);
    	map.put("price", price);
		int res = 1 ;// orderService.updateAllPrice(map);
		if(res>0){
			orderService.calcUpdateOrderAmount(orderId);
		}else{
			ari.setCode(ResultCodeEnum.RESULT_CODE_SUBMIT_FAIL.getCode());
			ari.setMessage(ResultCodeEnum.RESULT_CODE_SUBMIT_FAIL.getMessage());
		}
    	ari.setData(null);
        return ari;
    }
	
	/*@ApiOperation(value="根据订单id获取总价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "String")
    })
    @RequestMapping(value = "/getOrderAmount",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo updatePrice(HttpServletRequest request,Integer orderId){
    	ApiReturnInfo ari = new ApiReturnInfo();
    	Order order = orderService.selectOrderbyId(orderId);
    	ari.setData(order!=null?order.getAmount():0);
        return ari;
    }*/
}
