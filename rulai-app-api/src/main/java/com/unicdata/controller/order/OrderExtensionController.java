package com.unicdata.controller.order;

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
import com.unicdata.entity.order.OrderExtension;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.insurer.InsuranceExtensionService;
import com.unicdata.service.order.OrderExtensionService;
import com.unicdata.service.order.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 订单延保管理
 * @author admin
 *
 */
@Controller
@RequestMapping("/app/extension")
@Api(value="订单延保相关接口",tags={"订单延保相关接口"})
public class OrderExtensionController extends HomeBaseController {

    @Autowired
    private InsuranceExtensionService insuranceExtensionService;
    @Autowired
    private OrderExtensionService orderExtensionService;
    @Autowired
    private OrderService orderService;

	@ApiOperation(value="延保套餐列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "familyId", value = "车系id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/insuranceList",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo insuranceList(HttpServletRequest request,Integer familyId){
		//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
		//延保套餐列表
		List<Map<String,Object>> insuranceList = insuranceExtensionService.selectListByMap(emp.getStoreId(),familyId);
    	ari.setData(insuranceList);
        return ari;
    }
	
	@ApiOperation(value="添加订单延保套餐")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "extensionId", value = "延保套餐id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "sumPrice", value = "销售单价", required = true, dataType = "BigDecimal")
    })
    @RequestMapping(value = "/addOrderExtension",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo addOrderExtension(HttpServletRequest request,OrderExtension record,Integer editType){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//修改延保套餐
		int res = orderExtensionService.updateOrderExtension(record);
		if(res>0){
			orderService.calcUpdateOrderAmount(record.getOrderId());
		}
		ari.setData(null);
        return ari;
    }
    
	@ApiOperation(value="删除订单延保套餐")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/deleteOrderExtension",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo deleteOrderExtension(HttpServletRequest request,OrderExtension record){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//删除延保套餐
		int res = orderExtensionService.deleteOrderExtension(record.getOrderId());
		if(res>0){
			orderService.calcUpdateOrderAmount(record.getOrderId());
		}
    	ari.setData(res);
        return ari;
    }
	
	@ApiOperation(value="查询已加入订单的延保套餐信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/getOrderExtensionDetail",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo getOrderExtensionDetail(HttpServletRequest request,OrderExtension record){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//获取已加入订单的延保套餐
		Map<String, Object> orderExtension = orderExtensionService.getOrderExtension(record.getOrderId());
    	ari.setData(orderExtension);
        return ari;
    }
}
