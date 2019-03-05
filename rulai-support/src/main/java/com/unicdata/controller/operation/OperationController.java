package com.unicdata.controller.operation;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.operation.OperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@RestController
@RequestMapping("/rulai/operation")
@Api("运营分析数据相关")
public class OperationController extends HomeBaseController {
    @Autowired
    private OperationService operationService;

    @ApiOperation(value = "销售订单分析", notes = "销售订单分析")
    @RequestMapping(value = "/saleOperation", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "1销售明细2新增订单分析3库存订单分析", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name = "beginTime", value = "时间段开始时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "时间段结束时间", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "employeeId", value = "所选销售员工id", paramType = "form", dataType = "int"),
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "form", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页数据", paramType = "form", dataType = "int")
    })
    public ApiReturnInfo saleOperation(HttpServletRequest request, @ApiIgnore ApiReturnInfo<PageInfo<Map<String, Object>>> apiReturnInfo, String beginTime, String endTime, Integer type, Integer employeeId, Integer pageNum, Integer pageSize) {
        Employee member = getMember(request);
        Map<String, Object> param = new HashMap();
        param.put("storeId", member.getStoreId());
        String orderStatus = null;
        switch (type){
            case 1:
                if (beginTime != null) {
                    param.put("beginTime", beginTime);
                    param.put("endTime", endTime);
                }
                if (employeeId != null) {
                    param.put("employeeId", employeeId);
                }
                orderStatus = "(4,5,6)";
                break;
            case 2:
                orderStatus = "(5,6,7,8)";
                break;
            case 3:
                param.put("type", type);
                break;
        }
        param.put("orderStatus", orderStatus);
        PageInfo<Map<String, Object>> mapPageInfo = operationService.orderOperation(param, pageNum, pageSize);
        apiReturnInfo.setData(mapPageInfo);
        return apiReturnInfo;
    }
}