package com.unicdata.controller.salemanager;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.order.OrderCarService;
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
import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@RestController
@RequestMapping("/rulai/equipment")
@Api("配车相关接口")
public class EquipmentCarController extends HomeBaseController {
    @Autowired
    private OrderCarService orderCarService;
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private CarGoodInfoService carGoodInfoService;

    @RequestMapping(value = "/orderCarList", method = RequestMethod.POST)
    @ApiOperation("车辆列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单号", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "vin", value = "车架号", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "engineNum", value = "发动机号", paramType = "form", dataType = "String")
    })
    public ApiReturnInfo carList(HttpServletRequest request, @ApiIgnore ApiReturnInfo apiReturnInfo, Integer orderId, String vin, String engineNum) {
        Map<String, Object> param = new HashMap<>();
        Employee member = getMember(request);
        param.put("storeId", member.getStoreId());
        Integer carId = saleOrderService.selectByPrimaryKey(orderId).getCarId();
        CarGoodInfoWithBLOBs carGoodInfoWithBLOBs = carGoodInfoService.selectByPrimaryKey(carId);
        Integer vehicleId = carGoodInfoWithBLOBs.getVehicleId();
        Integer decorationsInId = carGoodInfoWithBLOBs.getDecorationsInId();
        Integer decorationsOutId = carGoodInfoWithBLOBs.getDecorationsOutId();
        String year = carGoodInfoWithBLOBs.getYear();

        if (vin != null && !vin.equals("")) {
            param.put("vin", vin);
        }
        if (engineNum != null && !engineNum.equals("")) {
            param.put("engineNum", engineNum);
        }
        param.put("vehicleId", vehicleId);
        param.put("decorationsInId", decorationsInId);
        param.put("decorationsOutId", decorationsOutId);
        param.put("year", year);

        List<Map<String, Object>> orderCarList = orderCarService.getOrderCarList(param);
        apiReturnInfo.setData(orderCarList);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/equipmentCar", method = RequestMethod.POST)
    @ApiOperation("订单配车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单号", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "carId", value = "车辆编号", paramType = "form", dataType = "Integer")
    })
    public ApiReturnInfo equipmentCar(HttpServletRequest request, @ApiIgnore ApiReturnInfo apiReturnInfo, Integer orderId, Integer carId) {
        Employee member = getMember(request);
        Order order = saleOrderService.selectByPrimaryKey(orderId);
        //如果订单配车状态是未配车，所选车辆也为空,直接返回
        if (order.getCarStatus() == 0 && carId == null) {
            return apiReturnInfo;
        }
        Map<String, Integer> param = new HashMap<>();
        param.put("matchCarId", carId);
        param.put("orderId", orderId);
        param.put("cusId", member.getId());
        //记录配车操作相关信息
        saleOrderService.equipmentCar(param);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/equipOrderList", method = RequestMethod.POST)
    @ApiOperation(value = "配车销售订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "显示数目", required = true, paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "employeeId", value = "员工id", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "orderNum", value = "单据号", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "cusName", value = "客户姓名", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "cusPhone", value = "手机号", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "familyId", value = "车系id", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "vehicleId", value = "车型id", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "carStatus", value = "配车状态0：未配车 1：已配车", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "createTime", value = "订单时间", paramType = "form", dataType = "String")
    })
    public ApiReturnInfo equipOrderList(Integer familyId, Integer carStatus, Integer vehicleId, HttpServletRequest request, @ApiIgnore ApiReturnInfo<PageInfo<Map<String, Object>>> apiReturnInfo, Integer pageNum, Integer pageSize, Integer employeeId, String orderNum, String cusName, String cusPhone, String createTime) {
        Employee member = getMember(request);
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
        if (cusPhone != null) {
            param.put("cusPhone", cusPhone);
        }
        if (createTime != null) {
            param.put("createTime", createTime);
        }
        if (familyId != null) {
            param.put("familyId", familyId);
        }
        if (vehicleId != null) {
            param.put("vehicleId", vehicleId);
        }
        if (carStatus != null) {
            param.put("carStatus", carStatus);
        }
        param.put("storeId", member.getStoreId());

        PageInfo<Map<String, Object>> mapPageInfo = saleOrderService.storeOrderList(param, pageNum, pageSize);
        List<Map<String, Object>> list = mapPageInfo.getList();
        //判断如果订单没有配车则查询订单对应车辆id的相关信息
        saleOrderService.replaceCarInfo(list);
        apiReturnInfo.setData(mapPageInfo);
        return apiReturnInfo;
    }
}
