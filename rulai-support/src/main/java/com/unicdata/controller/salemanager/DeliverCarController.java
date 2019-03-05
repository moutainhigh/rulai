package com.unicdata.controller.salemanager;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.SettleEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.order.CirculationService;
import com.unicdata.service.order.SaleOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhang
 */
@RestController
@RequestMapping("/rulai/deliverCar")
@Api("交车单打印相关接口")
public class DeliverCarController extends HomeBaseController {

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private CirculationService circulationService;

    @RequestMapping(value = "/deliverCarList", method = RequestMethod.POST)
    @ApiOperation("获取订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "显示数目", required = true, paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "employeeId", value = "员工id", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "orderNum", value = "单据号", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "cusName", value = "客户姓名", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "vin", value = "vin码", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "deliveryDate", value = "交车时间，yyyy-MM-dd", paramType = "form", dataType = "String")
    })
    public ApiReturnInfo deliverCarList(HttpServletRequest request, @ApiIgnore ApiReturnInfo<PageInfo<Map<String, Object>>> apiReturnInfo, Integer pageNum, Integer pageSize, Integer employeeId, String orderNum, String cusName, String vin, String deliveryDate) {
        Map<String, Object> param = new HashMap<>();
        if (employeeId != null) {
            param.put("employeeId", employeeId);
        }
        if (orderNum != null) {
            param.put("orderNum", orderNum);
        }
        if (cusName != null) {
            param.put("cusName", cusName);
        }
        if (vin != null) {
            param.put("vin", vin);
        }
        if (deliveryDate != null) {
            param.put("deliveryDate", deliveryDate);
        }
        Employee member = getMember(request);
        param.put("storeId", member.getStoreId());
        int code = SettleEnum.OrderStatus.TOTAL_PAYMENT.getCode();
        int code1 = SettleEnum.OrderStatus.EFFECTIVE.getCode();
        int code2 = SettleEnum.OrderStatus.EARNEST.getCode();
        int code3 = SettleEnum.OrderStatus.DELIVER.getCode();
        String orderStatus = "(" + code + "," + code1 + "," + code2 + "," + code3 + ")";
        param.put("orderStatus", orderStatus);
        PageInfo<Map<String, Object>> listPageInfo = saleOrderService.storeOrderList(param, pageNum, pageSize);
        apiReturnInfo.setData(listPageInfo);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/circulation", method = RequestMethod.POST)
    public ApiReturnInfo circulation(Integer orderId, ApiReturnInfo apiReturnInfo) {
        Map<String, Object> circulation = circulationService.getCirculation(orderId);
        apiReturnInfo.setData(circulation);
        return apiReturnInfo;
    }

}
