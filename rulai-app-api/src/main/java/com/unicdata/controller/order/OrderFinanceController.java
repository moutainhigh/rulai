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
import com.unicdata.entity.order.OrderFinance;
import com.unicdata.entity.product.FinanceCompany;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.order.OrderFinanceService;
import com.unicdata.service.order.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 金融管理
 * @author admin
 *
 */
@Controller
@RequestMapping("/app/finance")
@Api(value="金融相关接口",tags={"金融相关接口"})
public class OrderFinanceController extends HomeBaseController {

    @Autowired
    private OrderFinanceService financeService;
    @Autowired
    private OrderService orderService;

	@ApiOperation(value="金融公司列表")
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "familyId", value = "车系id", required = true, dataType = "Integer")
    })*/
    @RequestMapping(value = "/financeCompanys",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo insuranceList(HttpServletRequest request,FinanceCompany record){
		//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
		//金融公司列表
		record.setStoreId(emp.getStoreId());
		List<Map<String, Object>> companyList = financeService.selectFinanceCompany(record);
    	ari.setData(companyList);
        return ari;
    }
	
	@ApiOperation(value="金融公司贷款期限利率")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "financeId", value = "金融公司id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "loanAmount", value = "贷款金额", required = true, dataType = "BigDecimal")
    })
    @RequestMapping(value = "/financeYears",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo financeYears(HttpServletRequest request,OrderFinance record){
		//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("storeId", emp.getStoreId());
    	params.put("loanAmount", record.getLoanAmount());
    	params.put("financeId", record.getFinanceId());
		//金融公司贷款期限利率列表
		List<Map<String, Object>> yearList = financeService.selectFinanceYears(params);
    	ari.setData(yearList);
        return ari;
    }
	
	@ApiOperation(value="添加金融信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "financeId", value = "金融公司id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "loanAmount", value = "贷款金额", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "downPayment", value = "首付", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "loanRate", value = "利率", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "loanTerm", value = "贷款期限(月)", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "interest", value = "贷款利息", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "paymentRatio", value = "首付比例", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "monthlySupply", value = "月供", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "isGps", value = "是否有GPS", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "chargeType", value = "服务费类型", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "chargeRatio", value = "服务费比例", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "charge", value = "服务费", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "mortgageCharge", value = "抵押手续费", required = true, dataType = "BigDecimal")
    })
    @RequestMapping(value = "/addOrderFinance",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo addOrderFinance(HttpServletRequest request,OrderFinance record,Integer editType){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//添加或修改订单金融
		int res = financeService.updateOrderFinance(record);
		if(res>0){
			orderService.calcUpdateOrderAmount(record.getOrderId());
		}
    	ari.setData(null);
        return ari;
    }
	
	@ApiOperation(value="查询已加入订单的金融信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/getOrderFinance",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo getOrderFinance(HttpServletRequest request,OrderFinance record){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//查询订单金融
		Map<String, Object> orderFinance = financeService.getOrderFinance(record.getOrderId());
    	ari.setData(orderFinance);
        return ari;
    }
	
	@ApiOperation(value="删除订单的金融信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/deleteOrderFinance",method=RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo deleteOrderFinance(HttpServletRequest request,OrderFinance record){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//删除订单金融
		int res = financeService.deleteOrderFinance(record.getOrderId());
		if(res>0){
			orderService.calcUpdateOrderAmount(record.getOrderId());
		}
    	ari.setData(null);
        return ari;
    }
    
}
