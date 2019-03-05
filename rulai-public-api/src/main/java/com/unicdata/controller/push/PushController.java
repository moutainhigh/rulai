package com.unicdata.controller.push;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.PushEnum;
import com.unicdata.entity.push.PushMessageEmployee;
import com.unicdata.service.push.PushMessageEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/rulai/public/push")
@Api(value = "消息推送", tags = {"消息推送相关接口"})
public class PushController {

    @Autowired
    private PushMessageEmployeeService pushMessageEmployeeService;

    @ApiOperation(value = "获取当前用户所有未查看的推送消息列表", notes = "获取当前用户所有未查看的推送消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeId", value = "登录人ID", dataType = "Integer")
    })
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<List<Map<String, Object>>> list(Integer employeeId) {
        ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (employeeId == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("员工ID不能为空");
        }
        List<Map<String, Object>> data = pushMessageEmployeeService.listByEmployeeId(employeeId);
        result.setData(data);
        return result;
    }

    @ApiOperation(value = "推送消息查看", notes = "推送消息查看")
    @RequestMapping(value = "/view", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageId", value = "消息ID", dataType = "Integer"),
            @ApiImplicitParam(name = "employeeId", value = "登录人ID", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<List<Map<String, Object>>> view(Integer messageId, Integer employeeId) {
        ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (messageId == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("推送消息ID不能为空");
        }
        if (employeeId == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("员工ID不能为空");
        }
        PushMessageEmployee messageEmployee = pushMessageEmployeeService.getByEmployeeIdAndMessageId(messageId, employeeId);
        if (messageEmployee == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("推送消息不存在");
        }
        messageEmployee.setViewState(PushEnum.ViewStates.VIEWED.getCode());
        messageEmployee.setViewTime(new Date());
        int resultCode = pushMessageEmployeeService.updateSelective(messageEmployee);
        if (resultCode == 0) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("网络错误，请重试");
        }
        return result;
    }
}
