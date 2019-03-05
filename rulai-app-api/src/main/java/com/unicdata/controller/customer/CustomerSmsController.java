package com.unicdata.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.CustomerSms;
import com.unicdata.entity.customer.CustomerSmsModel;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.customer.CustomerSmsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 潜客短信管理
 *
 * @author admin
 */
@Controller
@RequestMapping("/app/sms")
@Api(value = "潜客短信相关接口", tags = {"潜客短信相关接口"})
public class CustomerSmsController extends HomeBaseController {

    @Autowired
    private CustomerSmsService customerSmsService;
    @Autowired
    private CustomerService customerService;


    @ApiOperation(value = "获取短信模板")
    @RequestMapping(value = "/smsModelList",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo dictionaryList(String type){
    	ApiReturnInfo ari = new ApiReturnInfo();
		//短信模板数据
		List<CustomerSmsModel> list = customerSmsService.selectSmsModelList();
    	ari.setData(list);
        return ari;
    }

    @ApiOperation(value = "保存发送短信")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cusId", value = "客户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "modelId", value = "模板id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "content", value = "内容", required = true, dataType = "String")
    })
    @RequestMapping(value = "/sendCustomerSms",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo sendCustomerSms(HttpServletRequest request, CustomerSms record) {
    	//当前用户
    	Employee emp = getMember(request);
    	ApiReturnInfo ari = new ApiReturnInfo();
    	Customer customer = customerService.selectByPrimaryKey(record.getCusId());
    	if(null != customer && StringUtil.isNotBlank(customer.getPhone())
    			&& StringUtil.isNotBlank(record.getContent())){
    		record.setCreateId(emp.getId());
        	record.setIphone(customer.getPhone());
            customerSmsService.addCustomerSms(record);
    	}else{
    		ari.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
    		ari.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
    	}
        ari.setData(null);
        return ari;
    }
    
}
