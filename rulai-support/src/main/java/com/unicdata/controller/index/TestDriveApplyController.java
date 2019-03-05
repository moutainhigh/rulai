package com.unicdata.controller.index;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.customer.TestDriveApply;
import com.unicdata.entity.customer.TestDriveApplyCar;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.customer.TestDriveApplyCarService;
import com.unicdata.service.customer.TestDriveApplyService;
import com.unicdata.util.DateUtil;
import com.unicdata.util.PinyinUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@Controller
@RequestMapping("/rulai/testDrive")
@Api("试乘试驾详情和申请")
public class TestDriveApplyController extends HomeBaseController {

    @Autowired
    private TestDriveApplyService testDriveApplyService;
    @Autowired
    private TestDriveApplyCarService testDriveApplyCarService;


    @RequestMapping(value = "/testDriveDetail", method = RequestMethod.POST)
    @ApiOperation("试乘试驾详情")
    @ResponseBody
    @ApiImplicitParam(name = "applyId", value = "申请单号", dataType = "Integer", required = true)
    public ApiReturnInfo testDriveDetail(Integer applyId, @ApiIgnore ApiReturnInfo<Map> apiReturnInfo) {
        TestDriveApply testDriveApply = testDriveApplyService.selectByPrimaryKey(applyId);
        List testDriveApplyCars = testDriveApplyCarService.selectByApplyId(applyId);
        Map<String, Object> result = new HashMap<>();
        result.put("testDriveApply", testDriveApply);
        result.put("testDriveApplyCars", testDriveApplyCars);
        result.put("carNum", testDriveApplyCars.size());
        apiReturnInfo.setData(result);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/addTestApply", method = RequestMethod.POST)
    @ApiOperation("试驾车申请")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carIds", value = "车辆id，以,隔开", dataType = "String", required = true),
            @ApiImplicitParam(name = "useTime", value = "使用时间", dataType = "String", required = true),
            @ApiImplicitParam(name = "purpose", value = "用途", dataType = "String", required = true)
    })
    public ApiReturnInfo addTestApply(HttpServletRequest request, String carIds, String useTime, String purpose, @ApiIgnore ApiReturnInfo apiReturnInfo) {
        Employee member = getMember(request);
        TestDriveApply testDriveApply = new TestDriveApply();
        testDriveApply.setApplyTime(DateUtil.now());
        Calendar calendar = Calendar.getInstance();
        Integer time = (int) calendar.getTime().getTime();
        testDriveApply.setApplyNum(time);
        testDriveApply.setEmployeeId(member.getId());
        testDriveApply.setUseTime(DateUtil.stringToDate(useTime, DateUtil.sdf1));
        testDriveApply.setPurpose(purpose);
        int testDriveApplyId = testDriveApplyService.insertTestCarApproval(testDriveApply);
        List<String> strings = PinyinUtil.stringToList(carIds, ",");
        for (String string : strings) {
            TestDriveApplyCar testDriveApplyCar = new TestDriveApplyCar();
            testDriveApplyCar.setApplyId(testDriveApplyId);
            testDriveApplyCar.setCarGoodId(Integer.parseInt(string));
            testDriveApplyCar.setStoreId(member.getStoreId());
            testDriveApplyCarService.insertTestDriveApplyCar(testDriveApplyCar);
        }
        return apiReturnInfo;
    }
}
