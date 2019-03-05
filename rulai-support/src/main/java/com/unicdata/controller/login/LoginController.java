package com.unicdata.controller.login;

import com.google.common.collect.Maps;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.CommonCode;
import com.unicdata.entity.system.Employee;
import com.unicdata.shrio.MyRealm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/rulai")
@Api(value = "用户登录", tags = {"用户登录相关接口"})
public class LoginController {


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String")
    })
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> login(String username, String password) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<Map<String, Object>>();
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            result.setMessage("账号/密码不能为空");
            result.setCode(CommonCode.RESULT_CODE_EXCEPTION);
            return result;
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            Map<String,Object> params = Maps.newHashMap();
            Employee emp = (Employee)subject.getPrincipal();
            params.put("userId",emp.getId());
            params.put("userName", emp.getFullName());
            params.put("departmentId", emp.getDepartmentId());
            params.put("departmentDesc", emp.getDepartmentDesc());
            params.put("postName",emp.getPostName());
            params.put("postId",emp.getPostId());
            params.put("token",subject.getSession().getId());
            result.setData(params);
            result.setMessage("登录成功");
        } catch (IncorrectCredentialsException e) {
            result.setCode(CommonCode.RESULT_CODE_EXCEPTION);
            result.setMessage("密码错误");
        } catch (LockedAccountException e) {
            result.setCode(CommonCode.RESULT_CODE_EXCEPTION);
            result.setMessage("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            result.setCode(CommonCode.RESULT_CODE_EXCEPTION);
            result.setMessage("登录失败，该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> logout() {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<Map<String, Object>>();
        Subject subject = SecurityUtils.getSubject();
        if(subject!=null){
            subject.logout();
        }
        return result;
    }


    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     *
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> unauth() {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<Map<String, Object>>();
        result.setCode(CommonCode.TOKEN_ERROR);
        result.setMessage("未登录");
        return result;
    }
}
