package com.unicdata.controller.system;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.EmployeeGroup;
import com.unicdata.service.system.EmployeeGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 门店部门管理
 * Created by shenyong on 2018/4/7.
 */
@Controller
@RequestMapping(value = "/rulai/manage/store")
@Api(value = "门店部门管理", tags = { "门店部门管理相关接口" }) // swagger控制器说明注解
public class StoreController extends HomeBaseController {

    @Autowired
    private EmployeeGroupService employeeGroupService;

    /**
     *分页查询门店部门
     */
    @ApiOperation(value = "获取门店部门列表" ,notes = "获取门店部门列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageSize", value = "显示数目", required = false, dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "parentId", value = "上级id", required = false, dataType = "Integer",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public ApiReturnInfo<EmployeeGroup> storeList(Integer pageNum, Integer pageSize, EmployeeGroup employee){
        employee.setGroupType(2);
        PageInfo pageInfo = employeeGroupService.storeList( pageNum, pageSize, employee);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        ar.setData(pageInfo);
        return ar;
    }


    //添加/修改门店部门
    @ApiOperation(value = "保存/修改门店部门",notes = "门店部门编号为空执行保存操作，门店部门编号不为空并且大于零执行修改操作")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "门店部门编号" ,required = false,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "groupName",value = "部门名称" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "parentId",value = "上级id" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "sortno",value = "排序" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "groupType",value = "类型 1集团 2门店" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "dataStatus",value = "数据状态 1在用 0删除" ,required = true,dataType = "Integer",paramType = "form")
    })
    @ResponseBody
    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public ApiReturnInfo saveAndUpd(EmployeeGroup record) {
        record.setGroupType(2);
        return employeeGroupService.save(record);
    }

    /**
     * 逻辑删除
     */
    @ApiOperation(value = "删除门店部门" ,notes = "删除门店部门")
    @ApiImplicitParam(name = "storeId", value = "门店部门编号", required = true, dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    public ApiReturnInfo del(Integer storeId) {
        ApiReturnInfo ar = new ApiReturnInfo();
        if(storeId == null){
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        EmployeeGroup employee = new EmployeeGroup();
        employee.setId(storeId);
        employee.setDataStatus(0);
        employee.setUpdateDate(new Date());
        employeeGroupService.updateByPrimaryKeySelective(employee);
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        return ar;
    }

}
