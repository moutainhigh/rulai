package com.unicdata.controller.settlement;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.conditon.RecepitCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.order.OrderInvoice;
import com.unicdata.entity.order.OrderRefund;
import com.unicdata.entity.order.Receipt;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.order.OrderInvoiceService;
import com.unicdata.service.order.OrderRefundService;
import com.unicdata.service.order.ReceiptService;
import com.unicdata.service.order.SaleOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@RestController
@RequestMapping("/rulai/salesettle")
@Api("财务管理相关接口")
public class SaleSettleController extends HomeBaseController {

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private ReceiptService receiptService;
    @Autowired
    private OrderRefundService orderRefundService;
    @Autowired
    private OrderInvoiceService orderInvoiceService;
    @Value("${upload.access.path}")
    private String uploadAccessPath;

    @RequestMapping(value = "/orderList", method = RequestMethod.POST)
    @ApiOperation("订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "employeeId", value = "员工id", dataType = "Integer"),
            @ApiImplicitParam(name = "orderNum", value = "订单编号", dataType = "String"),
            @ApiImplicitParam(name = "cusName", value = "客户姓名", dataType = "String"),
            @ApiImplicitParam(name = "vin", value = "vin码", dataType = "String"),
            @ApiImplicitParam(name = "deliveryDate", value = "交车日期", dataType = "String"),
            @ApiImplicitParam(name = "cusPhone", value = "客户手机号", dataType = "String"),
            @ApiImplicitParam(name = "orderStatus", value = "订单状态", dataType = "String")
    })
    public ApiReturnInfo orderList(HttpServletRequest request, @ApiIgnore ApiReturnInfo<PageInfo<Map>> apiReturnInfo, Integer pageNum,
                                   Integer pageSize, Integer employeeId, String orderNum, String cusName, String vin, String deliveryDate,
                                   Integer orderStatus, String cusPhone) {
        Employee member = getMember(request);
        Map<String, Object> param = new HashMap<>();
        param.put("storeId", member.getStoreId());
        if (employeeId != null && !employeeId.equals("")) {
            param.put("employeeId", employeeId);
        }
        if (orderNum != null && !orderNum.equals("")) {
            param.put("orderNum", orderNum);
        }
        if (cusName != null && !cusName.equals("")) {
            param.put("cusName", cusName);
        }
        if (vin != null && !vin.equals("")) {
            param.put("vin", vin);
        }
        if (deliveryDate != null && !deliveryDate.equals("")) {
            param.put("deliveryDate", deliveryDate);
        }
        if (cusPhone != null && !cusPhone.equals("")) {
            param.put("cusPhone", cusPhone);
        }
        param.put("orderStatus", "(2,3,4,8,9)");
        if (orderStatus != null && !orderStatus.equals("")) {
            param.put("orderStatus", "(" + orderStatus + ")");
        }
        PageInfo<Map> listPageInfo = saleOrderService.financeOrderList(param, pageNum, pageSize);
        apiReturnInfo.setData(listPageInfo);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/receiptDetail", method = RequestMethod.POST)
    @ApiOperation("订单支付详情")
    @ApiImplicitParam(name = "orderId", value = "订单号", dataType = "String", required = true)
    public ApiReturnInfo receiptDetail(Integer orderId, @ApiIgnore ApiReturnInfo<Map> apiReturnInfo) {
        Map map = receiptService.receiptDetail(orderId);
        apiReturnInfo.setData(map);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/receivables", method = RequestMethod.POST)
    @ApiOperation("收款操作")
    @ApiImplicitParam(name = "recepitCondition", value = "付款信息相关", dataType = "RecepitCondition", required = true)
    public ApiReturnInfo receivables(@ApiIgnore ApiReturnInfo apiReturnInfo, HttpServletRequest request, @RequestBody RecepitCondition recepitCondition) {
        Integer orderId = recepitCondition.getOrderId();
        List<Receipt> receipt = recepitCondition.getReceipt();
        Integer employeeId = getMember(request).getId();
        //判断订单是否已经全款，已经全款则不允许收款
        if (receiptService.ifFullSection(orderId)) {
            apiReturnInfo.setCode(ConstantEnumStatus.FULL_ORDER.getCode());
            apiReturnInfo.setMessage(ConstantEnumStatus.FULL_ORDER.getReason());
            return apiReturnInfo;
        }
//        //判断是否有业务已经付款
//        for (Receipt rece : receipt) {
//            rece.setOrderId(orderId);
//            rece.setPayName(recepitCondition.getPayName());
//            rece.setPayType(recepitCondition.getPayType());
//            rece.setRemarks(recepitCondition.getRemarks());
//            boolean b = receiptService.ifReceipt(rece);
//            if (b) {
//                apiReturnInfo.setCode(ConstantEnumStatus.HAVE_PAY.getCode());
//                apiReturnInfo.setMessage(ConstantEnumStatus.HAVE_PAY.getReason());
//                return apiReturnInfo;
//            }
//        }
        for (Receipt rece : receipt) {
            rece.setOrderId(orderId);
            rece.setPayName(recepitCondition.getPayName());
            rece.setPayType(recepitCondition.getPayType());
            rece.setRemarks(recepitCondition.getRemarks());
        }
        //收款
        receiptService.receiptMoney(receipt, employeeId);
        //再次判断是否已经全款，全款后做相应操作
        if (receiptService.ifFullSection(orderId)) {
            receiptService.doAfterFullSection(orderId, employeeId);
        }
        return apiReturnInfo;
    }

    /**
     * 退單操作
     *
     * @param request
     * @param apiReturnInfo
     * @return
     */
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    @ApiOperation("退单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单号", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "remark", value = "退单原因", dataType = "String", required = true)
    })
    public ApiReturnInfo refund(HttpServletRequest request, Integer orderId, String remark, @ApiIgnore ApiReturnInfo apiReturnInfo) {
        Employee member = getMember(request);
        OrderRefund orderRefund = new OrderRefund();
        orderRefund.setOrderId(orderId);
        orderRefund.setRemark(remark);
        orderRefund.setCreateId(member.getId());
        orderRefundService.orderRefund(orderRefund);
        return apiReturnInfo;
    }

    /**
     * 发票保存接口
     *
     * @param orderInvoice
     * @param apiReturnInfo
     * @return
     */
    @RequestMapping(value = "/orderInvoice", method = RequestMethod.POST)
    @ApiOperation("发票保存")
    @ApiImplicitParam(name = "orderInvoice", value = "发票保存参数", dataType = "OrderInvoice", required = true)
    public ApiReturnInfo orderInvoice(@RequestBody OrderInvoice orderInvoice, @ApiIgnore ApiReturnInfo apiReturnInfo) {
        orderInvoiceService.saveOrderInvoice(orderInvoice);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/queryorderInvoice", method = RequestMethod.POST)
    @ApiOperation("查看发票")
    @ApiImplicitParam(name = "orderId", value = "订到id", dataType = "int", required = true)
    public ApiReturnInfo queryorderInvoice(Integer orderId, @ApiIgnore ApiReturnInfo<OrderInvoice> apiReturnInfo) {
        OrderInvoice orderInvoice = orderInvoiceService.selectByOrderId(orderId);
        orderInvoice.setPictureUrl(uploadAccessPath + orderInvoice.getPictureUrl());
        apiReturnInfo.setData(orderInvoice);
        return apiReturnInfo;
    }
}
