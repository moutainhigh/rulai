package com.unicdata.controller.system;

import java.util.Date;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.Constant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.system.EmployeeService;
import com.unicdata.util.EncryptionUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理
 * Created by shenyong on 2018/4/3.
 */
@Controller
@RequestMapping(value = "/rulai/employee")
@Api(value = "用户管理", tags = { "用户管理相关接口" }) // swagger控制器说明注解
public class EmployeeController extends HomeBaseController {

    /**
     *分页查询用户
     */
    @ApiOperation(value = "获取用户列表" ,notes = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "显示数目", required = false, dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "fullName", value = "真实姓名", required = false, dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "phoneNum", value = "手机号码", required = false, dataType = "String",paramType = "form")
    })
    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public ApiReturnInfo<Employee> employeeList(Integer pageNum, Integer pageSize, Employee employee){
        Employee em = super.getMember(null);
        employee.setSubjectionType(em.getSubjectionType());
        employee.setStoreId(em.getStoreId());
        PageInfo pageInfo = employeeService.employeeList( pageNum, pageSize, employee);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        ar.setData(pageInfo);
        return ar;
    }

    @Autowired
    private EmployeeService employeeService;


    /**
     * 用户id查找用户信息
     */
    @ApiOperation(value = "获取用户详情" ,notes = "获取用户详情")
    @ApiImplicitParam(name = "employeeId", value = "用户编号", required = true, dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/findEmployee",method = {RequestMethod.POST})
    public ApiReturnInfo<Employee> employeeById(ApiReturnInfo resp, Integer employeeId){
        if(employeeId == null ){
            resp.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            resp.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return resp;
        }
        Employee employee = employeeService.employeeById(employeeId);
        resp.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        resp.setMessage("查询成功");
        if(employee == null ){
            resp.setMessage("用户为空");
        }
        resp.setData(employee);
        return resp;
    }

    //添加/修改用户
    @ApiOperation(value = "保存/修改用户",notes = "员工编号为空执行保存操作，员工编号不为空并且大于零执行修改操作")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "用户编号" ,required = false,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "loginName",value = "用户名" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "pwd",value = "密码" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "fullName",value = "姓名" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "phoneNum",value = "电话号码" ,required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "departmentId",value = "部门id" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "storeId",value = "门店id" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "userStatus",value = "状态 1启用 0禁用" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "sex",value = "性别 0未知 ，1男，2女" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "postId",value = "岗位id" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "subjectionType",value = "隶属 1集团 2门店" ,required = true,dataType = "Integer",paramType = "form")
    })
    @ResponseBody
    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public ApiReturnInfo saveAndUpd(HttpServletRequest request, Employee record) {
        return employeeService.save(record);
    }

    /**
     * 逻辑删除
     */
    @ApiOperation(value = "删除用户" ,notes = "删除用户")
    @ApiImplicitParam(name = "employeeId", value = "用户编号", required = true, dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    public ApiReturnInfo del(Integer employeeId) {
        ApiReturnInfo ar = new ApiReturnInfo();
        if(employeeId == null){
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setDataStatus(0);
        employee.setUpdateDate(new Date());
        employeeService.updateByPrimaryKeySelective(employee);
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        return ar;
    }

    /**
     * 禁用/启用
     * @param employeeId
     * @param status  1启用 0禁用
     */
    @ApiOperation(value = "禁用/启用" ,notes = "禁用/启用")
    @ApiImplicitParams({@ApiImplicitParam(name = "employeeId",value = "用户编号" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "status",value = "状态 1启用 0禁用" ,required = true,dataType = "Integer",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/changeStatus",method = {RequestMethod.POST})
    public ApiReturnInfo changeStatus(Integer employeeId, Integer status){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(employeeId == null || employeeId <= 0|| status == null ){
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setUserStatus(status);
        employee.setUpdateDate(new Date());
        employeeService.updateByPrimaryKeySelective(employee);
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        return ar;
    }

    /**
     * 重置密码
     */
    @ApiOperation(value = "重置密码" ,notes = "重置密码")
    @ApiImplicitParams({@ApiImplicitParam(name = "employeeId",value = "用户编号" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "password",value = "新密码" ,required = true,dataType = "String",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/resetPassword",method = {RequestMethod.POST})
    public ApiReturnInfo resetPassword(Integer employeeId, String password, String oldpwd){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(employeeId == null || employeeId <= 0|| "".equals(password)){
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        if(oldpwd != null && !"".equals(oldpwd)){
            Employee oldEmployee = employeeService.selectByPrimaryKey(employeeId);
            if( oldEmployee!=null && !oldEmployee.getPwd().equals(EncryptionUtil.base64Encrypt(oldpwd))) {
                ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                ar.setMessage("原密码不正确，请重新输入！");
                return ar;
            }
        }
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setPwd(EncryptionUtil.base64Encrypt(password));
        employee.setUpdateDate(new Date());
        employeeService.updateByPrimaryKeySelective(employee);
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        return ar;
    }

    /**
     * 分配角色
     */
    @ApiOperation(value = "分配角色" ,notes = "分配角色")
    @ApiImplicitParams({@ApiImplicitParam(name = "employeeId",value = "用户编号" ,required = true,dataType = "Integer",paramType = "form"),
            @ApiImplicitParam(name = "roles",value = "角色用半角逗号,隔开" ,required = true,dataType = "String",paramType = "form")})
    @ResponseBody
    @RequestMapping(value = "/distributionRole",method = {RequestMethod.POST})
    public ApiReturnInfo distributionRole(Integer employeeId, String roles){
        return employeeService.distributionRole(employeeId,roles);
    }


    /**
     * 查询用户拥有的角色
     */
    @ApiOperation(value = "用户拥有的角色" ,notes = "用户拥有的角色")
    @ApiImplicitParam(name = "employeeId",value = "用户编号" ,required = true,dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/userRoles",method = {RequestMethod.POST})
    public ApiReturnInfo<Employee> userRoles(Integer employeeId){
        return employeeService.userRoles(employeeId);
    }

    /**
     * 查询用户拥有的角色
     */
    @ApiOperation(value = "用户拥有的权限" ,notes = "用户拥有的权限")
    @ApiImplicitParam(name = "employeeId",value = "用户编号" ,required = true,dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/userPermission",method = {RequestMethod.POST})
    public ApiReturnInfo<Employee> userPermission(Integer employeeId){
        return employeeService.userPermission(employeeId);
    }
    /**
     * 模糊查询员工
     */
    @ApiOperation(value = "模糊查询员工" ,notes = "模糊查询员工")
    @ApiImplicitParam(name = "name",value = "用户名称" ,required = true,dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/findEmployeeByName",method = {RequestMethod.POST})
    public ApiReturnInfo findEmployeeByName(String name){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(StringUtil.isNotBlank(name)) {
            List<Employee> list = employeeService.findEmployeeByName(name);
            ar.setData(list);
        }
        return ar;
    }

    /**
     * 根据权限名称查询拥有权限的人员集合
     */
    @ApiOperation(value = "用根据权限名称查询拥有权限的人员集合" ,notes = "用户拥有的权限")
    @ApiImplicitParam(name = "perName",value = "权限名称" ,required = true,dataType = "Integer",paramType = "form")
    @ResponseBody
    @RequestMapping(value = "/selectAllUserByPerName",method = {RequestMethod.POST})
    public ApiReturnInfo<List<Employee>> selectAllUserByPerName(HttpServletRequest request,String perName){
    	ApiReturnInfo<List<Employee>> result = new ApiReturnInfo<List<Employee>>();
    	Employee member = getMember(request);
    	List<Employee> list = employeeService.selectAllUserByPerName(member.getStoreId(),perName);
    	result.setData(list);
    	return result;
    }
    
    
}
