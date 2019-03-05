package com.unicdata.controller.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.order.OrderInsurance;
import com.unicdata.entity.order.OrderService;
import com.unicdata.entity.order.OrderServiceItem;
import com.unicdata.entity.order.StoreService;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.CounterService;
import com.unicdata.service.order.OrderOtherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 其他服务管理
 * @author admin
 *
 */
@Controller
@RequestMapping("/app/other")
@Api(value="其他服务相关接口",tags={"其他服务相关接口"})
public class OrderOtherServiceController extends HomeBaseController {

    @Autowired
    private OrderOtherService orderOtherService;
    @Autowired
    private com.unicdata.service.order.OrderService orderService;

	@ApiOperation(value="其他服务列表")
    @RequestMapping(value = "/otherServiceList",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo otherServiceList(HttpServletRequest request){
		//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
		//其他服务基础信息列表
		List<Map<String, Object>> list = orderOtherService.selectStoreService(emp.getStoreId());
    	ari.setData(list);
        return ari;
    }
	
	@ApiOperation(value="添加订单其他服务")
    @ApiImplicitParams({
        	@ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "jsonStr", value = "json字符", required = true, dataType = "BigDecimal")
    })
    @RequestMapping(value = "/addOtherService",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo addOrderFinance(HttpServletRequest request,Integer orderId,String jsonStr,Integer editType){
    	ApiReturnInfo ari = new ApiReturnInfo();
    	//修改订单其他服务
    	int res = orderOtherService.addOrderOtherService(orderId,jsonStr);
    	if(res>0){
			orderService.calcUpdateOrderAmount(orderId);
		}
    	ari.setData(null);
        return ari;
    }
    
	@ApiOperation(value="获取已加入订单的其他服务")
	@ApiImplicitParams({
	        @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer")
	})
    @RequestMapping(value = "/getOrderOtherService",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo getOrderOtherService(HttpServletRequest request,Integer orderId){
		//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
		//其他服务基础信息列表
//		List<Map<String, Object>> list = orderOtherService.selectStoreService(emp.getStoreId());
    	List<Map<String, Object>> list = orderOtherService.getOrderService(orderId);
    	ari.setData(list);
        return ari;
    }
	
	@ApiOperation(value="删除订单其他服务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "serviceId", value = "服务项id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/deleteOrderOtherService",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo deleteOrderOtherService(HttpServletRequest request,Integer orderId,Integer serviceId){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//删除订单保险
    	int res = orderOtherService.deleteOrderOtherService(orderId,serviceId);
    	if(res>0){
			orderService.calcUpdateOrderAmount(orderId);
		}
    	ari.setData(null);
        return ari;
    }
}
