package com.unicdata.controller.salemanager;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.constant.SettleEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.order.OrderFinance;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.order.OrderFinanceService;
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
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/rulai/order/finance")
@Api(value = "金融管理", tags = {"金融管理相关接口"})
public class OrderFinanceController extends HomeBaseController {

    @Autowired
    private OrderFinanceService orderFinanceService;

    @ApiOperation(value = "金融管理列表", notes = "金融管理列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderNum", value = "销售单号", dataType = "String"),
            @ApiImplicitParam(name = "cusName", value = "客户/公司名称", dataType = "String"),
            @ApiImplicitParam(name = "cusPhone", value = "客户手机号", dataType = "String"),
            @ApiImplicitParam(name = "vin", value = "vin码", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> list(String orderNum, String cusName, String cusPhone, String vin, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (pageNum == null || pageSize == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("分页字段不能为空");
            return result;
        }
        Map<String, Object> params = Maps.newHashMap();
        if (StringUtils.isNotBlank(orderNum)) {
            params.put("orderNum", orderNum);
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
        params.put("storeId", getMember(request).getStoreId());
        PageInfo<Map<String, Object>> pageInfo = orderFinanceService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> orderFinances = pageInfo.getList();
        for (Map<String, Object> map : orderFinances) {
            //销售单号状态
            map.put("orderStatusDesc", map.get("orderStatus") == null ? null : SettleEnum.OrderStatus.getByCode(Integer.valueOf(map.get("orderStatus").toString())).getReason());
            //贷款状态
            map.put("loanStatusDesc", map.get("loanStatus") == null ? null : SettleEnum.OrderFinanceStates.getByCode(Integer.valueOf(map.get("loanStatus").toString())).getDesc());
        }
        result.setData(pageInfo);
        return result;
    }


    @ApiOperation(value = "订单金融操作", notes = "订单金融操作")
    @RequestMapping(value = "/change", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "state", value = "1:待申请,2:已申请,3:已放款(申请和放款时需要传)", dataType = "Integer"),
            @ApiImplicitParam(name = "date", value = "申请/放款日期", dataType = "String"),
            @ApiImplicitParam(name = "cost", value = "gps安装成本费", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "charge", value = "手续费", dataType = "BigDecimal")
    })
    @ResponseBody
    public ApiReturnInfo detail(Integer state, Integer id, String date, BigDecimal cost, BigDecimal charge, HttpServletRequest request) {
        Employee employee = getMember(request);
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (id == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("id不能为空");
            return result;
        }
        OrderFinance orderFinance = orderFinanceService.getOrderFinanceById(id);
        if (orderFinance == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("订单金融记录为空");
            return result;
        }
        if(state!=null){
            orderFinance.setLoanStatus(state);
        }
        if (cost != null) {
            orderFinance.setMortgageCost(cost);
        }
        if(charge != null){
            orderFinance.setFinanceCharge(charge);
        }
        if (StringUtils.isNotBlank(date)) {
            if (Objects.equals(SettleEnum.OrderFinanceStates.HAVE_APPLIED.getCode(), state)) {
                orderFinance.setApplyDate(DateUtil.stringToDate(date, DateUtil.sdf2));
            } else if (Objects.equals(SettleEnum.OrderFinanceStates.HAVE_RELEASED.getCode(), state)) {
                orderFinance.setLoanDate(DateUtil.stringToDate(date, DateUtil.sdf2));
            }
        }
        int res = orderFinanceService.save(orderFinance , employee);
        if (res == 0) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("操作失败，请重试");
            return result;
        }
        return result;
    }

}
