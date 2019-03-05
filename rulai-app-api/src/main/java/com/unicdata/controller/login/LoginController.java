package com.unicdata.controller.login;

import com.unicdata.base.constant.Constant;
import com.unicdata.base.constant.DictionaryTypeEnum.EmployeeStatus;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.EncryptionUtil;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.ConstantEnum.EmployeeWorkStatus;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.dto.EmployeeDTO;
import com.unicdata.entity.system.Employee;
import com.unicdata.entity.system.EmployeeStatusExample;
import com.unicdata.service.employee.AppEmployeeService;
import com.unicdata.service.system.EmployeeService;
import com.unicdata.service.system.EmployeeStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 登录
 *
 * @author admin
 */
@Controller
@RequestMapping("/app")
@Api(value = "Login", tags = {"登录相关接口"})
public class LoginController extends HomeBaseController {
    //微信二维码
    @Value("${weixin.code.url}")
    public String weixinCodeUrl;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AppEmployeeService appEmployeeService;
    @Autowired
    private EmployeeStatusService employeeStatusService;

    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiReturnInfo login(HttpServletRequest request, String account, String password) {
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {//判断账号密码是否为空
            ari.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ari.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
        } else {//都不为空
            Employee employee = employeeService.selectByLoginName(account);
            if (employee == null) {
                ari.setCode(ResultCodeEnum.RESULT_CODE_PARAM_ACCOUNT_NO_EXISTENT.getCode());
                ari.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_ACCOUNT_NO_EXISTENT.getMessage());
            } else if (employee.getUserStatus().equals(EmployeeStatus.DISABLE.getCode())) {
                ari.setCode(ResultCodeEnum.RESULT_CODE_PARAM_ACCOUNT_STATUS_FAIL.getCode());
                ari.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_ACCOUNT_STATUS_FAIL.getMessage());
            } else if (employee.getPwd().equals(EncryptionUtil.base64Encrypt(password))) {
                //账号密码正确，生成token令牌返回给客户端
                String token = UUID.randomUUID().toString().toUpperCase();
                setMember(request, employee, token);
                map.put("token", token);
                //获取员工状态 0空闲（1忙碌）2休假3培训
                EmployeeStatusExample example = new EmployeeStatusExample();
                EmployeeStatusExample.Criteria criteria = example.createCriteria();
                criteria.andEmployeeIdEqualTo(employee.getId());
                List<com.unicdata.entity.system.EmployeeStatus> statuses = employeeStatusService.selectByExample(example);
                int status = statuses != null && statuses.size() > 0 ? statuses.get(0).getType() == null ? 0 : statuses.get(0).getType() : 0;
                //DTO处理
                EmployeeDTO dto = new EmployeeDTO();
                dto.setStatus(status);
                BeanUtils.copyProperties(employee, dto);
                map.put("employee", dto);
                map.put("codeUrl", weixinCodeUrl);
                map.put("integral", "100");
                map.put("postMap", getPostMap());
                //设置别名
                String alias = StringUtil.md5(Constant.APP_ALIAS + employee.getId());
                //设置组别
                String tag = StringUtil.md5(employee.getPostName() + employee.getStoreId());
                map.put("alias", alias);
                map.put("tag", tag);

                //测试极光推送
                /*String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_PASSENGER_CREATEARCHIVES);
                Map<String, String> msgType = new HashMap<String, String>();
	            msgType.put("code", MessageCode.MESSAGE_PASSENGER_CREATEARCHIVES);
	            msgType.put("message", content);
	            //推送消息
	            JPushUtils.sendTag(content, msgType, tag);*/
            } else {
                ari.setCode(ResultCodeEnum.RESULT_CODE_PARAM_PASSWORD_FAIL.getCode());
                ari.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_PASSWORD_FAIL.getMessage());
            }
        }
        ari.setData(map);
        return ari;
    }

    @ApiOperation(value = "修改销售顾问工作状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "工作状态 0空闲 1忙碌2休假3培训", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/updateWorkStatus", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo quotedPrice(HttpServletRequest request, Integer status) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        //修改员工状态
        if (emp.getEmployeeStatus().getType() != EmployeeWorkStatus.忙碌.getCode()) {
            Map<String, Object> map = new HashMap<>();
            map.put("employeeId", emp.getId());
            map.put("type", status); //状态0空闲（1忙碌）2休假3培训
            appEmployeeService.updateEmpStatus(map);
        } else {
            ari.setCode(ResultCodeEnum.RESULT_CODE_WORK_EXISTENT.getCode());
            ari.setMessage(ResultCodeEnum.RESULT_CODE_WORK_EXISTENT.getMessage());
        }
        ari.setData(null);
        return ari;
    }
}
