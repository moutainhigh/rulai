package com.unicdata.controller.system;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Permissions;
import com.unicdata.service.system.PermissionService;
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
 * 权限管理
 * Created by shenyong on 2018/4/3.
 */
@Controller
@RequestMapping(value = "/rulai/permission")
@Api(value = "权限管理", tags = { "权限管理相关接口" }) // swagger控制器说明注解
public class PermissionController  extends HomeBaseController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "获取权限列表" ,notes = "获取权限列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageSize", value = "显示数目", required = false, dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "Integer",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public ApiReturnInfo<Permissions> permissionList(ApiReturnInfo resp, Integer pageNum, Integer pageSize, Permissions permissions){
        PageInfo<Permissions> pageInfo = permissionService.permissionList(resp, pageNum, pageSize, permissions);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        ar.setData(pageInfo);
        return ar;
    }

    @ApiOperation(value = "权限详情",notes = "权限详情")
    @ApiImplicitParam(name = "id",value = "权限编号" ,required = true,dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/detail",method = {RequestMethod.POST})
    public ApiReturnInfo<Permissions> permissionDetail(Integer id){
        Permissions permissions = permissionService.selectByPrimaryKey(id);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        ar.setData(permissions);
        return ar;
    }

    @ApiOperation(value = "保存/修改权限",notes = "权限编号为空执行保存操作，权限编号不为空并且大于零执行修改操作")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "权限编号" ,required = false,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "permissionName",value = "权限名称" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "permissionDesc",value = "权限描述" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "type",value = "权限类型 1菜单 2页面 3按钮" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "url",value = "权限url" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "parentId",value = "父级id" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "sortNo",value = "菜单排序" ,required = false,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "status",value = "状态0启用 1禁用" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "iconUrl",value = "图标链接" ,required = false,dataType = "String",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public ApiReturnInfo saveAndUpd(Permissions record) {
        return permissionService.save(record);
    }

    /**
     * 删除权限
     * @param id
     */
    @ApiOperation(value = "删除权限" ,notes = "删除权限")
    @ApiImplicitParam(name = "id",value = "权限编号" ,required = true,dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    public ApiReturnInfo permissionDel(Integer id){
        int num = permissionService.deleteByKey(id);
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

    /**
     * 禁用/启用
     * @param id
     * @param status  0启用 1禁用
     */
    @ApiOperation(value = "禁用/启用" ,notes = "禁用/启用")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "权限编号" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "status",value = "状态0启用 1禁用" ,required = true,dataType = "Integer",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/changeStatus",method = {RequestMethod.POST})
    public ApiReturnInfo changeStatus(Integer id, Integer status){
        Permissions p = new Permissions();
        p.setId(id);
        p.setStatus(status);
        p.setUpdateDate(new Date());
        int num = permissionService.updateByPrimaryKeySelective(p);
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

}
