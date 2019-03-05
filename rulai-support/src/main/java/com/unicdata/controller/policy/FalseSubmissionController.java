package com.unicdata.controller.policy;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoExample;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.policy.RebateCar;
import com.unicdata.entity.policy.RebateCarExample;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.policy.RebateCarService;
import com.unicdata.service.policy.RebateProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by shenyong on 2018/6/11.
 */
@Api(value = "返利虚报管理")
@RestController
@RequestMapping(value = "/rulai/falseSubmission")
public class FalseSubmissionController extends HomeBaseController {

    @Autowired
    private CarGoodInfoService carGoodInfoService;
    @Autowired
    private RebateCarService rebateCarService;

    @ApiOperation(value = "列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dmsStartDate" ,value = "首次DMS开始时间" , required = false, dataType = "String", paramType = "form" ),
            @ApiImplicitParam(name = "dmsEndDate" ,value = "首次DMS结束时间" , required = false, dataType = "String", paramType = "form" ),
            @ApiImplicitParam(name = "orderStatus" ,value = "车辆状态" , required = false, dataType = "Integer", paramType = "form" )
    })
    @RequestMapping(value = "/list" ,method = RequestMethod.POST)
    public ApiReturnInfo<CarGoodInfo> list(HttpServletRequest request ,String dmsStartDate ,String dmsEndDate ,Integer orderStatus,Integer pageNum, Integer pageSize){
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee employee = super.getMember(request);
        PageInfo<CarGoodInfo> carGoodInfoPageInfo = carGoodInfoService.selectFalseSubmissionPage(dmsStartDate, dmsEndDate, orderStatus ,employee.getStoreId(), pageNum, pageSize);
        ar.setData(carGoodInfoPageInfo);
        return ar;
    }

    @ApiOperation(value = "查询车辆的所有返利项目")
    @ApiImplicitParam(name = "carId" ,value = "车辆id" , required = true , dataType = "Integer", paramType = "form" )
    @RequestMapping(value = "/selectRebateProjectByCar" ,method = RequestMethod.POST)
    public ApiReturnInfo<CarGoodInfoWithBLOBs> selectRebateProjectByCar(HttpServletRequest request , Integer carId,Integer pageNum, Integer pageSize){
        ApiReturnInfo ar = new ApiReturnInfo();
        PageInfo<CarGoodInfoWithBLOBs> carGoodInfoPageInfo = rebateCarService.selectRebateProjectByCar(carId, pageNum, pageSize);
        ar.setData(carGoodInfoPageInfo);
        return ar;
    }



}
