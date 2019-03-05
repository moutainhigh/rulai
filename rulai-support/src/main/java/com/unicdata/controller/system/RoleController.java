package com.unicdata.controller.system;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Role;
import com.unicdata.service.system.RoleService;
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
 * 角色管理
 * Created by shenyong on 2018/4/3.
 */
@Controller
@RequestMapping("/rulai/manage/role")
@Api(value = "角色管理", tags = { "角色管理相关接口" }) // swagger控制器说明注解
public class RoleController extends HomeBaseController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取角色列表" ,notes = "获取角色列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageSize", value = "显示数目", required = false, dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "Integer",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public ApiReturnInfo<Role> roluList(ApiReturnInfo resp, Integer pageNum, Integer pageSize, Role role){
        PageInfo<Role> pageInfo = roleService.roluList(resp, pageNum, pageSize, role);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        ar.setData(pageInfo);
        return ar;
    }


    @ApiOperation(value = "角色详情",notes = "角色详情")
    @ApiImplicitParam(name = "id",value = "角色编号" ,required = true,dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/detail",method = {RequestMethod.POST})
    public ApiReturnInfo<Role> ruleDetail(Integer id){
        Role role = roleService.selectByPrimaryKey(id);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        ar.setData(role);
        return ar;
    }

    @ApiOperation(value = "保存/修改角色",notes = "角色编号为空执行保存操作，角色编号不为空并且大于零执行修改操作")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "角色编号" ,required = false,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "roleName",value = "角色名称" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "roleDesc",value = "角色描述" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "status",value = "状态0启用 1禁用" ,required = true,dataType = "Integer",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public ApiReturnInfo saveAndUpd(Role record) {
        return roleService.save(record);
    }

    /**
     * 删除角色
     * @param id
     */
    @ApiOperation(value = "删除角色" ,notes = "删除角色")
    @ApiImplicitParam(name = "id",value = "角色编号" ,required = true , dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    public ApiReturnInfo ruleDel(Integer id){
        int num = roleService.deleteByPrimaryKey(id);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        return ar;
    }

    /**
     * 禁用/启用
     * @param id
     * @param status  0启用 1禁用
     */
    @ApiOperation(value = "禁用/启用" ,notes = "禁用/启用")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "角色编号" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "status",value = "状态 0启用 1禁用" ,required = true,dataType = "Integer",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/changeStatus",method = {RequestMethod.POST})
    public ApiReturnInfo changeStatus(Integer id, Integer status){
        Role p = new Role();
        p.setId(id);
        p.setStatus(status);
        p.setUpdateDate(new Date());
        int num = roleService.updateByPrimaryKeySelective(p);
        ApiReturnInfo ar = new ApiReturnInfo();
        if (num > 0) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        } else {
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage("操作失败!");
        }
        return ar;
    }


    @ApiOperation(value = "角色分配权限" ,notes = "角色分配权限")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId",value = "角色编号" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "permissions",value = "权限编号用,号分割" ,required = true,dataType = "String",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/distributionPermission",method = {RequestMethod.POST})
    public ApiReturnInfo distributionPermission(Integer roleId, String permissions){
        int num = roleService.distributionPermission(roleId,permissions);
        ApiReturnInfo ar = new ApiReturnInfo();
        if (num > 0) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        } else {
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage("操作失败!");
        }
        return ar;
    }

    @ApiOperation(value = "查询角色所有权限" ,notes = "查询角色所有权限")
    @ApiImplicitParam(name = "roleId",value = "角色编号" ,required = true,dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/findRolePermissions",method = {RequestMethod.POST})
    public ApiReturnInfo<Role> findRolePermissions(Integer roleId){
        Role rolePermissions = roleService.findRolePermissions(roleId);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        ar.setData(rolePermissions);
        return ar;
    }





}
