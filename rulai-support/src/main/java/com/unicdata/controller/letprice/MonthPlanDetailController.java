package com.unicdata.controller.letprice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.letprice.*;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.letprice.MonthPlanDetailService;
import com.unicdata.service.letprice.MonthPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by shenyong on 2018/6/12.
 */
@Api(value = "月度计划关联库存")
@RestController
@RequestMapping(value = "/rulai/monthPlanDetail")
public class MonthPlanDetailController extends HomeBaseController {

    @Autowired
    private MonthPlanDetailService monthPlanDetailService;
    @Autowired
    private MonthPlanService monthPlanService;

    @ApiOperation(value = "查询月度计划关联库存数据")
    @ApiImplicitParam(name = "monthPlanId", value = "月度计划id", required = false, dataType = "Integer", paramType = "form")
    @RequestMapping(value = "/list" ,method = RequestMethod.POST)
    public ApiReturnInfo<MonthPlanCarDto> list(HttpServletRequest request , Integer monthPlanId){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(monthPlanId == null || monthPlanId <= 0){
            ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        Map  monthPlanCarDtos = monthPlanDetailService.selectByMonthPlanId(monthPlanId);
        ar.setData(monthPlanCarDtos);
        return ar;
    }

    @ApiOperation(value = "保存月度计划关联库存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "goalSalesVolume", value = "目标销量", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "goalGrossProfit", value = "目标毛利总额", required = true, dataType = "BigDecimal", paramType = "form")
    })
    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public ApiReturnInfo save(HttpServletRequest request , @RequestBody List<MonthPlanSaveDTO> mp ){
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee employee = super.getMember(request);
        if(employee.getStoreId()!= null && employee.getStoreId() > 0) {
            monthPlanDetailService.save(mp,employee.getId());
        }else{
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage("权限不够，该操作只能由门店人员操作！");
        }
        return ar;
    }

    @ApiOperation(value = "月度计划关联库存详情")
    @ApiImplicitParam(name = "monthPlanId", value = "月度计划id", required = true, dataType = "Integer", paramType = "form")
    @RequestMapping(value = "/selectMonthPlanDetail" ,method = RequestMethod.POST)
    public ApiReturnInfo<MonthPlanCarDto> selectMonthPlanDetail(HttpServletRequest request , Integer monthPlanId){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(monthPlanId == null || monthPlanId <= 0){
            ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        MonthPlan monthPlan = monthPlanService.selectByPrimaryKey(monthPlanId);
        if(monthPlan.getStatus() != 4) {
            Map  monthPlanCarDtos = monthPlanDetailService.selectMonthPlanDetail(monthPlanId);
            ar.setData(monthPlanCarDtos);
        }else{
            MonthPlanExt monthPlanExt = monthPlanService.selectMonthPlanSnapshot(monthPlanId);
            if(monthPlanExt != null) {
                JSONObject o = JSON.parseObject(monthPlanExt.getMonthPlanSnapshot());
                ar.setData(o);
            }
        }
        return ar;
    }

    @ApiOperation(value = "审批/驳回")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "monthPlanId", value = "月度计划id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "status", value = "1 审核通过，2驳回", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "remark", value = "备注", required = true, dataType = "String", paramType = "form")
    })
    @RequestMapping(value = "/approve" ,method = RequestMethod.POST)
    public ApiReturnInfo approve(HttpServletRequest request ,Integer monthPlanId,Integer status ,String remark ){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(monthPlanId == null || monthPlanId <= 0 || status == null || status <= 0){
            ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        monthPlanDetailService.approve(monthPlanId,status,remark);
        return ar;
    }



}
