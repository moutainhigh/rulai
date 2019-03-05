package com.unicdata.controller.customer;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.customer.TestDrive;
import com.unicdata.service.customer.TestDriveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rulai/drive")
@Api(value = "客户试驾信息", tags = {"客户试驾信息相关接口"})
public class TestDriveController {

    @Autowired
    private TestDriveService testDriveService;

    @ApiOperation(value = "客户试驾信息保存修改", notes = "客户试驾信息保存修改")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "testDrive", value = "客户试驾信息", required = true, dataType = "TestDrive")
    @ResponseBody
    public ApiReturnInfo save(@RequestBody TestDrive testDrive) {
        ApiReturnInfo result = new ApiReturnInfo();
        if (testDrive.getId() == null || testDrive.getDriveMileage() == null || testDrive.getEndMileage() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("必填参数不能为空");
            return result;
        }
        testDriveService.save(testDrive);
        return result;
    }
}
