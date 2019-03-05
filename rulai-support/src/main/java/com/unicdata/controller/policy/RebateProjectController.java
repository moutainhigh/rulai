package com.unicdata.controller.policy;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.conditon.RebateProjectCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.policy.ArriveBillList;
import com.unicdata.entity.policy.ProofreaderList;
import com.unicdata.entity.policy.RebateCar;
import com.unicdata.entity.policy.RebateProject;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.policy.RebateCarService;
import com.unicdata.service.policy.RebateProjectService;
import io.swagger.annotations.*;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 返利项目
 * Created by shenyong on 2018/6/3.
 */
@RestController
@RequestMapping("/rulai/rebate")
@Api(value = "返利项目", tags = { "返利项目相关接口" })
public class RebateProjectController extends HomeBaseController {


    @Autowired
    private RebateProjectService rebateProjectService;
    @Autowired
    private RebateCarService rebateCarService;


    @ApiOperation(value = "查询商务政策下的返利项目list")
    @ApiImplicitParam(name = "policyId", value = "商务政策id", required = false, dataType = "Integer", paramType = "form")
    @RequestMapping(value = "/list" ,method = RequestMethod.POST)
    public ApiReturnInfo<RebateProject> list(Integer policyId){
        ApiReturnInfo ar = new ApiReturnInfo();
        List<RebateProject> rebateProjects = rebateProjectService.selectRebate(policyId);
        ar.setData( new PageInfo<>(rebateProjects));
        return ar;
    }

    @ApiOperation(value = "按id查询返利项目")
    @ApiImplicitParam(name = "id", value = "返利项目id", required = true, dataType = "Integer", paramType = "form")
    @RequestMapping(value = "/selectRebate" ,method = RequestMethod.POST)
    public ApiReturnInfo<RebateProject> selectRebateById(HttpServletRequest request,Integer id ){
        ApiReturnInfo ar = new ApiReturnInfo();
        RebateProject rebateProject = rebateProjectService.selectRebateById(id);
        ar.setData(rebateProject);
        return ar;
    }

    @ApiOperation(value = "按返利项目id查询返利项目以保存的所有车辆数据")
    @ApiImplicitParam(name = "rebateId", value = "返利项目id", required = true, dataType = "Integer", paramType = "form")
    @RequestMapping(value = "/selectRebateCar" ,method = RequestMethod.POST)
    public ApiReturnInfo<RebateProject> selectRebateCarByRebateId(Integer rebateId ){
        ApiReturnInfo ar = new ApiReturnInfo();
        List<RebateCar> rebateCars = rebateCarService.selectRebateCarByRebateId(rebateId);
        ar.setData(rebateCars);
        return ar;
    }


    @ApiOperation(value = "保存返利项目")
    @RequestMapping(value = "/saveRebate" ,method = RequestMethod.POST)
    public ApiReturnInfo saveRebate(HttpServletRequest request,RebateProject rp) throws ParseException {
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee employee = super.getMember(request);
        if (StringUtil.isBlank(rp.getRebateName()) || StringUtil.isBlank(rp.getRebateName()) &&
                rp.getPolicyId() == null || rp.getPolicyId() <= 0){
            ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        rp.setStoreId(employee.getStoreId());
        rp.setEmployeeId(employee.getId());
        Integer result = rebateProjectService.saveRebate(rp);
        ar.setData(result);
        return ar;
    }

    @ApiOperation(value = "修改返利项目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "返利项目id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "adjustType", value = "调整类型 1 默认类型，2具体库存", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "rebateTypeValue", value = "返利类型数值", required = true, dataType = "BigDecimal", paramType = "form"),
            @ApiImplicitParam(name = "carMap", value = "[{\"adjust\":\"调整金额(-1000)\",\"type\":\"0调整预估金额，1新增库存，2删除\"},...]", required = true, dataType = "Integer", paramType = "form")
    })
    @RequestMapping(value = "/updateRebate" ,method = RequestMethod.POST)
    public ApiReturnInfo updateRebate(HttpServletRequest request, RebateProject rp ){
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee employee = super.getMember(request);
        if (rp.getId() == null || rp.getId() <= 0){
            ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        rp.setStoreId(employee.getStoreId());
        rp.setEmployeeId(employee.getId());
        rp.setUpdateDate(new Date());
        rebateProjectService.updateRebate(rp);

        return ar;
    }

    @ApiOperation(value = "查询返利项目选择条件下的库存车")
    @RequestMapping(value = "/selectCarInfo" ,method = RequestMethod.POST)
    public ApiReturnInfo<PageInfo<List<CarGoodInfo>>> selectCarInfo(HttpServletRequest request,RebateProject rp,Integer pageNum, Integer pageSize){
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee employee = super.getMember(request);
        rp.setStoreId(employee.getStoreId());
        PageInfo<List<CarGoodInfo>> listPageInfo = rebateProjectService.selectCarInfoPage(rp, pageNum, pageSize);
        ar.setData(listPageInfo);
        return ar;
    }

    @ApiOperation(value = "确认返利项目生效")
    @RequestMapping(value = "/executeRebate" ,method = RequestMethod.POST)
    public ApiReturnInfo<List<CarGoodInfo>> executeRebate(HttpServletRequest request,Integer rebateId){
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee employee = super.getMember(request);
        RebateProject rp = new RebateProject();
        rp.setId(rebateId);
        rp.setEmployeeId(employee.getId());
        rp.setStatus(1);
        rp.setUpdateDate(new Date());
        rebateProjectService.updateByPrimaryKeySelective(rp);
        return ar;
    }



    @ApiOperation(value = "计算车辆计提金额")
    @RequestMapping(value = "/executePlanExtraction" ,method = RequestMethod.POST)
    public ApiReturnInfo<List<CarGoodInfo>> executeCarPlanExtraction(HttpServletRequest request,Integer carId){
        ApiReturnInfo ar = new ApiReturnInfo();
        rebateProjectService.executeCarPlanExtraction(carId);
        return ar;
    }

    @ApiOperation(value = "查询调整明细、核对单明细、到账单明细")
    @RequestMapping(value = "/selectDetail" ,method = RequestMethod.POST)
    public ApiReturnInfo<RebateProjectCondition> selectDetail(Integer rebateId){
        ApiReturnInfo ar = new ApiReturnInfo();
        RebateProjectCondition map = rebateProjectService.selectDetail(rebateId);
        ar.setData(map);
        return ar;
    }




}
