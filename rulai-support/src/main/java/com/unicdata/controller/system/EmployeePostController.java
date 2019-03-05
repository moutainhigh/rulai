package com.unicdata.controller.system;

import com.unicdata.base.constant.Constant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Employee;
import com.unicdata.entity.system.EmployeePost;
import com.unicdata.entity.system.EmployeePostExample;
import com.unicdata.service.system.EmployeePostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by shenyong on 2018/6/26.
 */
@Api("岗位相关接口")
@RestController
@RequestMapping("/rulai/employeePost")
public class EmployeePostController extends HomeBaseController {

    @Autowired
    private EmployeePostService employeePostService;

    @ApiOperation(value = "获取部门岗位数据" ,notes = "获取部门岗位数据")
    @ApiImplicitParam(name = "departmentId", value = "部门id", required = false, dataType = "Integer",paramType = "form")
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public ApiReturnInfo<EmployeePost> employeePostList(Integer departmentId){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(null == departmentId || departmentId <= 0) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        EmployeePostExample ex = new EmployeePostExample();
        EmployeePostExample.Criteria criteria = ex.createCriteria();
        criteria.andDataStatusEqualTo(1);
        if(departmentId != null && departmentId > 0){
            criteria.andDepartmentIdEqualTo(departmentId);
        }
        ex.setOrderByClause(" department_id ,sortno asc ");
        List<EmployeePost> employeePosts = employeePostService.selectByExample(ex);
        ar.setData(employeePosts);
        return ar;
    }


    @ApiOperation(value = "获取岗位数据" ,notes = "获取指定岗位数据")
    @ApiImplicitParam(name = "postId", value = "岗位id", required = true, dataType = "Integer",paramType = "form")
    @RequestMapping(value = "/selectPost",method = {RequestMethod.POST})
    public ApiReturnInfo<EmployeePost> selectByEmployeePost(Integer postId){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(null == postId || postId <= 0) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        EmployeePost employeePost = employeePostService.selectByPrimaryKey(postId);
        ar.setData(employeePost);
        return ar;
    }

    //添加/修改用户
    @ApiOperation(value = "保存/修改用户",notes = "id为空执行保存操作，id不为空并且大于零执行修改操作")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "id" ,required = false,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "postName",value = "岗位名称" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "departmentId",value = "部门id" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "parentId",value = "上级id" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "sortno",value = "排序" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "groupType",value = "类型 1集团 2门店" ,required = true,dataType = "Integer",paramType = "form")
    })
    @ResponseBody
    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public ApiReturnInfo saveAndUpd(HttpServletRequest request, EmployeePost record) {
        return employeePostService.save(record);
    }
















}


