package com.unicdata.controller.letprice;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.letprice.MonthPlan;
import com.unicdata.entity.letprice.MonthPlanExample;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.letprice.MonthPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by shenyong on 2018/6/12.
 */
@Api(value = "月度计划管理")
@RestController
@RequestMapping(value = "/rulai/monthPlan")
public class MonthPlanController extends HomeBaseController {

    @Autowired
    private MonthPlanService monthPlanService;


    @ApiOperation(value = "查询列表")
    @ApiImplicitParam(name = "year", value = "计划年份", required = false, dataType = "Integer", paramType = "form")
    @RequestMapping(value = "/list" ,method = RequestMethod.POST)
    public ApiReturnInfo<MonthPlan> list(HttpServletRequest request , Integer year){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(year == null ){
            year = Integer.parseInt(new SimpleDateFormat("yyyy").format(System.currentTimeMillis()));
        }
        Employee u = super.getMember(request);
        MonthPlan mp = new MonthPlan();
        mp.setPlanYear(year);
        mp.setStoreId(u.getStoreId());
        mp.setEmployeeId(u.getId());
        List<MonthPlan> monthPlen = monthPlanService.selectByExampleAndSaveYear(mp);
        ar.setData(monthPlen);
        return ar;
    }

    @ApiOperation(value = "保存月度计划目标")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "goalSalesVolume", value = "目标销量", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "goalGrossProfit", value = "目标毛利总额", required = true, dataType = "BigDecimal", paramType = "form")
    })
    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public ApiReturnInfo save(HttpServletRequest request , MonthPlan mp ){
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee employee = super.getMember(request);
        if(employee.getStoreId()!= null && employee.getStoreId() > 0){
            mp.setEmployeeId(employee.getId());
            Integer save = monthPlanService.save(mp);
            if(save <= 0){
                ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                ar.setMessage("已关联库存，不可修改！");
            }
        }else{
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage("权限不够，该操作只能由门店人员操作！");
        }
        return ar;
    }

    @ApiOperation(value = "保存预算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "budgetVolume", value = "目标销量", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "budgetGrossProfit", value = "目标毛利总额", required = true, dataType = "BigDecimal", paramType = "form")
    })
    @RequestMapping(value = "/saveBudget" ,method = RequestMethod.POST)
    public ApiReturnInfo saveBudget(HttpServletRequest request , MonthPlan mp ){
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee employee = super.getMember(request);
        if(employee.getStoreId()!= null && employee.getStoreId() > 0){
            mp.setEmployeeId(employee.getId());
            Integer save = monthPlanService.saveBudget(mp);
            if(save <= 0){
                ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                ar.setMessage("已设置，不可修改！");
            }
        }else{
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage("权限不够，该操作只能由门店人员操作！");
        }
        return ar;
    }

    @ApiOperation(value = "归档")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer", paramType = "form")
    @RequestMapping(value = "/archiving" ,method = RequestMethod.POST)
    public ApiReturnInfo archiving(HttpServletRequest request ,Integer id) throws ParseException {
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee u = super.getMember(request);
        monthPlanService.archiving(id,u.getId());
        return ar;
    }




}
