package com.unicdata.controller.policy;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.policy.CommercePolicy;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.policy.CommercePolicyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 商务政策
 * Created by shenyong on 2018/6/3.
 */
@RestController
@RequestMapping("/rulai/policy")
@Api(value = "商务政策", tags = { "商务政策相关接口" })
public class CommercePolicyController extends HomeBaseController {


    @Autowired
    private CommercePolicyService commercePolicyService;

    @ApiOperation(value = "商务政策list")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "policyName", value = "商务政策名称", required = false, dataType = "String", paramType = "form"),
        @ApiImplicitParam(name = "year", value = "商务政策年份(b)", required = false, dataType = "Integer", paramType = "form")
    })
    @RequestMapping(value = "/list" ,method = RequestMethod.POST)
    public ApiReturnInfo<CommercePolicy> list(HttpServletRequest request, String policyName ,Integer year ,Integer pageNum, Integer pageSize){
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee employee = super.getMember(request);
        if(year == null || year <= 0 ){
            year = Integer.parseInt(new SimpleDateFormat("yyyy").format(System.currentTimeMillis()));
        }
        CommercePolicy cp = new CommercePolicy();
        cp.setPolicyName(policyName);
        cp.setStoreId(employee.getStoreId());
        cp.setYear(year);
        Map pageInfo = commercePolicyService.selectPolicyPage(cp, pageNum, pageSize);

        ar.setData(pageInfo);
        return ar;
    }

    @ApiOperation(value = "按id查询商务政策")
    @ApiImplicitParam(name = "id", value = "商务政策id", required = true, dataType = "Integer", paramType = "form")
    @RequestMapping(value = "/selectPolicy" ,method = RequestMethod.POST)
    public ApiReturnInfo<CommercePolicy> selectPolicyById(Integer id ){
        ApiReturnInfo ar = new ApiReturnInfo();
        CommercePolicy commercePolicy = commercePolicyService.selectByPrimaryKey(id);
        ar.setData(commercePolicy);
        return ar;
    }

    @ApiOperation(value = "保存/修改商务政策",notes = "id为空执行保存操作，id不为空并且大于零执行修改操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商务政策编号（传该字段为修改，不传为新增）", required = false, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "policyName", value = "商务政策名称", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "policyCreateDate", value = "商务政策创建时间", required = true, dataType = "String", paramType = "form")
    })
    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public ApiReturnInfo save(HttpServletRequest request ,Integer id , String policyName , String policyCreateDate){
        ApiReturnInfo ar = new ApiReturnInfo();
        if (StringUtil.isBlank(policyName) || StringUtil.isBlank(policyCreateDate)){
            ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        Employee employee = super.getMember(request);
        if(employee.getSubjectionType() == 2) {
            try {
                CommercePolicy cp = new CommercePolicy();
                cp.setId(id);
                cp.setPolicyName(policyName);
                cp.setEmployeeId(employee.getId());
                cp.setStoreId(employee.getStoreId());
                cp.setPolicyCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse(policyCreateDate));
                Integer result = commercePolicyService.save(cp);
                ar.setData(result);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage("商务政策只能由各门店人员新增修改！");
        }
        return ar;
    }











}
