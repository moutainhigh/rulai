package com.unicdata.controller.order;

import java.util.HashMap;
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
import com.unicdata.entity.order.OrderInsurance;
import com.unicdata.entity.product.Insurer;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.insurer.InsurerServiece;
import com.unicdata.service.order.OrderInsuranceService;
import com.unicdata.service.order.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 订单保险管理
 * @author admin
 *
 */
@Controller
@RequestMapping("/app/insurer")
@Api(value="订单保险相关接口",tags={"订单保险相关接口"})
public class OrderInsurerController extends HomeBaseController {

    @Autowired
    private OrderInsuranceService orderInsuranceService;
    @Autowired
	private InsurerServiece insurerServiece;
    @Autowired
    private OrderService orderService;
	
	@ApiOperation(value="添加订单保险信息")
    @ApiImplicitParams({
        	@ApiImplicitParam(name = "insuranceCompanyId", value = "金融公司id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "jsonStr", value = "险种名称/保额/单位（万元）json数组", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sumMoney", value = "保险金额", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "isRenewal", value = "是否三年联保", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "renewalYears", value = "续保剩余年限", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "renewalBalance", value = "续保剩余金额", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "mortgage", value = "续保押金", required = true, dataType = "BigDecimal")
    })
    @RequestMapping(value = "/addOrderInsurance",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo addOrderFinance(HttpServletRequest request,Integer editType,String jsonStr,OrderInsurance record){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//添加或修改订单保险
		int res = orderInsuranceService.editOrderInsurance(record,jsonStr);
		if(res>0){
			orderService.calcUpdateOrderAmount(record.getOrderId());
		}
    	ari.setData(null);
        return ari;
    }
	
	@ApiOperation(value="查询已加入订单的保险信息")
    @ApiImplicitParams({
        	@ApiImplicitParam(name = "insuranceCompanyId", value = "保险公司id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/getOrderInsurance",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo getOrderInsuranceDetail(HttpServletRequest request,Integer editType,String insurerJson,OrderInsurance record){
		//当前用户
		Employee emp = getMember(request);
		ApiReturnInfo ari = new ApiReturnInfo();
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		//查询订单保险单信息
    	List<Map<String, Object>> list = orderInsuranceService.selectByOrderId(record.getOrderId());
    	Map<String, Object> insurance = null;
    	String id = "0";
    	for(Map<String, Object> map:list){
    		String companyId = String.valueOf(map.get("insurance_company_id"));
    		if(record.getInsuranceCompanyId().equals(Integer.valueOf(companyId))){
    			id = String.valueOf(map.get("id"));
    			insurance = map;
    		}
    	}
    	//保险险种明细列表
    	List<Map<String, Object>> itemList = orderInsuranceService.getOrderInsuranceItem(emp.getStoreId(),Integer.valueOf(id));
    	//查保险公司
		List<Insurer> listinsure = insurerServiece.selectInsure(emp.getStoreId());
    	resultMap.put("listinsure", listinsure);
    	resultMap.put("listinsureTypes", itemList);
    	resultMap.put("otherInsurance", insurance);
    	ari.setData(resultMap);
        return ari;
    }
	
	@ApiOperation(value="删除订单保险信息")
    @ApiImplicitParams({
        	@ApiImplicitParam(name = "insuranceCompanyId", value = "保险公司id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "id", value = "保险订单id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/deleteOrderInsurance",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo deleteOrderInsurance(HttpServletRequest request,OrderInsurance record){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//删除订单保险
		int res = orderInsuranceService.deleteOrderInsurance(record);
		if(res>0){
			orderService.calcUpdateOrderAmount(record.getOrderId());
		}
    	ari.setData(null);
        return ari;
    }
    
}
