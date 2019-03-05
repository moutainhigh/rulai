package com.unicdata.controller.salemanager;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.SettleEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.order.OrderExtension;
import com.unicdata.service.order.OrderExtensionService;
import com.unicdata.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/rulai/order/extension")
@Api(value = "延保管理", tags = {"延保相关接口"})
public class OrderExtensionController extends HomeBaseController {

    @Autowired
    private OrderExtensionService orderExtensionService;

    @ApiOperation(value = "延保管理列表", notes = "延保管理列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "insuranceNum", value = "保险单号", dataType = "String"),
            @ApiImplicitParam(name = "insuranceState", value = "保险单状态", dataType = "Integer"),
            @ApiImplicitParam(name = "cusName", value = "客户/公司名称", dataType = "String"),
            @ApiImplicitParam(name = "cusPhone", value = "客户手机号", dataType = "String"),
            @ApiImplicitParam(name = "vin", value = "vin码", dataType = "String"),
            @ApiImplicitParam(name = "orderNum", value = "销售单号", dataType = "String"),
            @ApiImplicitParam(name = "orderState", value = "销售单状态", dataType = "Integer"),
            @ApiImplicitParam(name = "beginTime", value = "保险到期开始时间", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "保险到期结束时间", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> list(String insuranceNum, Integer insuranceState, String cusName,
                                                                   String cusPhone, String vin, String orderNum,
                                                                   Integer orderState, String beginTime, String endTime,
                                                                   Integer pageNum, Integer pageSize, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        Map<String, Object> params = Maps.newHashMap();
        if (StringUtils.isNotBlank(insuranceNum)) {
            params.put("insuranceNum", insuranceNum);
        }
        if (insuranceState != null) {
            params.put("insuranceState", insuranceState);
        }
        if (StringUtils.isNotBlank(cusName)) {
            params.put("cusName", cusName);
        }
        if (StringUtils.isNotBlank(cusPhone)) {
            params.put("cusPhone", cusPhone);
        }
        if (StringUtils.isNotBlank(vin)) {
            params.put("vin", vin);
        }
        if (StringUtils.isNotBlank(orderNum)) {
            params.put("orderNum", orderNum);
        }
        if (orderState != null) {
            params.put("orderState", orderState);
        }
        params.put("storeId", getMember(request) == null ? null : getMember(request).getStoreId());
        params.put("beginTime", StringUtils.isNotBlank(beginTime) ? beginTime.trim() + " 00:00:00" : null);
        params.put("endTime", StringUtils.isNotBlank(endTime) ? endTime.trim() + " 23:59:59" : null);
        PageInfo<Map<String, Object>> pageInfo = orderExtensionService.getListByParams(params, pageNum, pageSize);
        List<Map<String,Object>> orderExtensions = pageInfo.getList();
        for (Map<String, Object> map : orderExtensions) {
            //销售单号状态
            map.put("orderStateDesc", map.get("orderState") == null ? null : SettleEnum.OrderStatus.getByCode(Integer.valueOf(map.get("orderState").toString())).getReason());
            //保险单状态
            map.put("extensionStateDesc", map.get("extensionState") == null ? null : SettleEnum.OrderInsuranceStates.getByCode(Integer.valueOf(map.get("extensionState").toString())).getDesc());
        }
        result.setData(pageInfo);
        return result;
    }


    @ApiOperation(value = "延保单提交", notes = "延保单提交")
    @RequestMapping(value = "/submit", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "保险单号ID", dataType = "Integer"),
            @ApiImplicitParam(name = "state", value = "延保单状态（1,未提交2,已提交3，已取消）", dataType = "Integer"),
            @ApiImplicitParam(name = "deadline", value = "保险到期日", dataType = "String")
    })
    @ResponseBody
    public ApiReturnInfo save(Integer id, Integer state, String deadline) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (id == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("id不能为空");
            return result;
        }
        if(Objects.equals(state,SettleEnum.OrderInsuranceStates.COMMITTED.getCode()) && StringUtils.isBlank(deadline)){
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("延保日期不能为空");
            return result;
        }
        OrderExtension orderExtension = orderExtensionService.getById(id);
        if (orderExtension == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("订单延保信息为空");
            return result;
        }
        orderExtension.setState(state);
        if(Objects.equals(state,SettleEnum.OrderInsuranceStates.COMMITTED.getCode())){
            orderExtension.setDeadline(StringUtils.isNotBlank(deadline) ? DateUtil.stringToDate(deadline, DateUtil.sdf2) : null);
        }
        int res = orderExtensionService.save(orderExtension);
        if(res == 0){
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("操作失败，请重试");
            return result;
        }
        return result;
    }
}
