package com.unicdata.controller.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.order.OrderFinance;
import com.unicdata.entity.order.OrderSetMeal;
import com.unicdata.entity.order.OrderSetMealItem;
import com.unicdata.entity.product.MealItem;
import com.unicdata.entity.product.SetMeal;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.order.OrderService;
import com.unicdata.service.order.OrderSetMealService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 保养套餐-代金券管理
 * @author admin
 *
 */
@Controller
@RequestMapping("/app/setMeal")
@Api(value="保养套餐-代金券相关接口",tags={"保养套餐-代金券相关接口"})
public class OrderSetMealController extends HomeBaseController {

    @Autowired
    private OrderSetMealService orderSetMealService;
    @Autowired
    private OrderService orderService;

	@ApiOperation(value="套餐代金券列表")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "类型 1.保养套餐 2:代金券", required = true, dataType = "Integer")
	})
    @RequestMapping(value = "/setMealList",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo setMealList(HttpServletRequest request,SetMeal record){
		//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
		//金融公司列表
		record.setStoreId(emp.getStoreId());
		List<Map<String, Object>> list = orderSetMealService.selectSetMealList(record);
    	ari.setData(list);
        return ari;
    }
    
	@ApiOperation(value="保养套餐明细列表")
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "mealId", value = "保养套餐id", required = true, dataType = "Integer")
	})
    @RequestMapping(value = "/mealItemList",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo mealItemList(HttpServletRequest request,Integer mealId){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//保养套餐明细列表
		List<MealItem> list = orderSetMealService.selectMealTtemById(mealId);
    	ari.setData(list);
        return ari;
    }
	
	@ApiOperation(value="添加保养套餐或代金券")
    @ApiImplicitParams({
    		@ApiImplicitParam(name = "editType", value = "0:新增 1：修改 ，默认新增", required = true, dataType = "Integer"),
    		@ApiImplicitParam(name = "orderSetmealItemId", value = "保养套餐或代金券明细项id", required = true, dataType = "Integer"),
    		@ApiImplicitParam(name = "setMealId", value = "保养套餐或代金券id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "type", value = "类型 1.套餐 2:代金券", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "buyNum", value = "购买数量", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "price", value = "单价", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/addOrderSetMeal",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo addOrderFinance(HttpServletRequest request,OrderSetMealItem record,
    		Integer orderId,Integer editType,Integer orderSetmealItemId,BigDecimal donationAmount){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//添加订单保养套餐-代金券
    	if(null != editType && editType == 1){
    		record.setId(orderSetmealItemId);
    	}
		int res = orderSetMealService.addOrderSetMeal(record,orderId,editType);
		if(res>0){
			orderService.calcUpdateOrderAmount(orderId);
		}
    	ari.setData(null);
        return ari;
    }
	
	@ApiOperation(value="查询已加入订单的保养套餐或代金券")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderSetmealItemId", value = "保养套餐或代金券明细id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/getOrderSetMeal",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo getOrderSetMeal(HttpServletRequest request,Integer orderSetmealItemId){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//查询订单保养套餐-代金券
    	Map<String,Object> setMealItem = orderSetMealService.getOrderSetMealItemById(orderSetmealItemId);
    	ari.setData(setMealItem);
        return ari;
    }
	
	@ApiOperation(value="删除保养套餐或代金券")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "orderSetmealItemId", value = "保养套餐或代金券明细id", required = true, dataType = "Integer"),
//        @ApiImplicitParam(name = "orderSetmealId", value = "套餐订单id", required = true, dataType = "Integer"),
        @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
        @ApiImplicitParam(name = "type", value = "类型 1.套餐 2:代金券", required = true, dataType = "Integer")
	})
    @RequestMapping(value = "/deleteOrderSetMeal",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo deleteOrderSetMeal(HttpServletRequest request,OrderSetMeal record,Integer orderSetmealItemId,Integer orderSetmealId){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//添加订单保养套餐-代金券
    	record.setId(orderSetmealId);
		int res = orderSetMealService.deleteOrderSetMeal(record, orderSetmealItemId);
		if(res>0){
			orderService.calcUpdateOrderAmount(record.getOrderId());
		}
    	ari.setData(null);
        return ari;
    }
}
