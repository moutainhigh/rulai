package com.unicdata.controller.salemanager;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.BoutiqueRetailInclude;
import com.unicdata.entity.order.Receipt;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.RetailSupportService;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.order.*;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@RestController
@RequestMapping("/rulai/order")
@Api(value = "订单相关接口", tags = {"订单相关接口"})
public class OrderController extends HomeBaseController {

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private OrderFinanceService orderFinanceService;
    @Autowired
    private OrderExtensionService orderExtensionService;
    @Autowired
    private OrderInsuranceService orderInsuranceService;
    @Autowired
    private OrderServiceService orderServiceService;
    @Autowired
    private OrderSetMealService orderSetMealService;
    @Autowired
    private RetailSupportService retailSupportService;
    @Autowired
    private ReceiptService receiptService;
    @Autowired
    private CarGoodInfoService carGoodInfoService;

    @RequestMapping(value = "/saleOrderList", method = RequestMethod.POST)
    @ApiOperation(value = "销售订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "显示数目", required = true, paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "employeeId", value = "员工id", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "orderNum", value = "单据号", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "cusName", value = "客户姓名", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "cusPhone", value = "手机号", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "orderStatus", value = "订单状态", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "vin", value = "vin码", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "familyId", value = "车系", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "yearGap", value = "年款", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "createTime", value = "订单时间", paramType = "form", dataType = "String")
    })
    public ApiReturnInfo<PageInfo<Map<String, Object>>> orderList(@ApiIgnore ApiReturnInfo<PageInfo<Map<String, Object>>> apiReturnInfo, HttpServletRequest request, Integer pageNum, Integer pageSize, Integer employeeId, String orderNum, String cusName, String cusPhone, Integer orderStatus, String vin, Integer familyId, String yearGap, String createTime) {
        Employee member = getMember(request);
        Map<String, Object> param = new HashMap<>();
        param.put("storeId", member.getStoreId());
        /**
         * 判断登录人的岗位，根据岗位不同查询不同的列表数据
         */
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
        if (orderStatus != null) {
            param.put("orderStatus", "(" + orderStatus + ")");
        }
        if (vin != null) {
            param.put("vin", vin);
        }
        if (familyId != null) {
            param.put("familyId", familyId);
        }
        if (yearGap != null) {
            param.put("yearGap", yearGap);
        }
        if (createTime != null) {
            param.put("createTime", createTime);
        }
        PageInfo<Map<String, Object>> listPageInfo;
        if (this.SALES_CONSULTANT_POSITION.equals(member.getPostName())) {
            param.put("employeeId", member.getId());
            listPageInfo = saleOrderService.salemanOrderList(param, pageNum, pageSize);
        } else {
            listPageInfo = saleOrderService.storeOrderList(param, pageNum, pageSize);
        }
        saleOrderService.replaceCarInfo(listPageInfo.getList());
        apiReturnInfo.setData(listPageInfo);
        return apiReturnInfo;
    }

    /**
     * 根据订单id获取订单详情
     *
     * @param request
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/orderDetail", method = RequestMethod.POST)
    @ApiOperation(value = "销售订单详情")
    @ApiImplicitParam(name = "orderId", value = "订单号", required = true, paramType = "form", dataType = "Integer")
    public ApiReturnInfo orderDetail(HttpServletRequest request, Integer orderId, @ApiIgnore ApiReturnInfo<Map<String, Object>> apiReturnInfo) {
        //订单基本信息
        Map orderDetail = saleOrderService.orderDetail(orderId);
        //订单金融信息
        List<Map<String, Object>> orderFinance = orderFinanceService.getOrderFinance(orderId);
        //订单延保信息
        List<Map<String, Object>> orderExtension = orderExtensionService.getOrderExtension(orderId);
        //订单保险信息
        List<Map<String, Object>> insuranceByOrderId = orderInsuranceService.getInsuranceByOrderId(orderId);
        //订单其他服务选项
        List<Map<String, Object>> orderService = orderServiceService.getOrderService(orderId);
        //订单代金券
        List<Map<String, Object>> couponList = orderSetMealService.selectCouponListByOrderId(orderId);
        BigDecimal couponBigDecimal = new BigDecimal(0);
        for (Map<String, Object> map : couponList) {
            Object mealPrice = map.get("mealPrice");
            couponBigDecimal = couponBigDecimal.add((BigDecimal) mealPrice);
        }
        //订单套餐
        List<Map<String, Object>> mealList = orderSetMealService.selectMealListByOrderId(orderId);
        BigDecimal mealBigDecimal = new BigDecimal(0);
        for (Map<String, Object> map : mealList) {
            Object mealPrice = map.get("mealPrice");
            mealBigDecimal = mealBigDecimal.add((BigDecimal) mealPrice);
        }
        //订单精品部分
        BoutiqueRetail boutiqueRetail = retailSupportService.selectBoutiqueRetailDetailByOrderId(orderId);
        BigDecimal applyCount = new BigDecimal(0);
        List<BoutiqueRetailInclude> boutiqueList = new ArrayList<>();
        if (boutiqueRetail != null) {
            applyCount = boutiqueRetail.getApplyCount();
            boutiqueList = boutiqueRetail.getList();
        }
        //查询收款记录
        Receipt receipt = new Receipt();
        receipt.setOrderId(orderId);
        List receiptList = receiptService.selectReceipts(receipt);

        Map<String, Object> result = new HashMap<>();
        result.put("orderDetail", orderDetail);
        result.put("orderFinance", orderFinance);
        result.put("orderExtension", orderExtension);
        result.put("orderInsurance", insuranceByOrderId);
        result.put("orderService", orderService);
        result.put("couponList", couponList);
        result.put("boutiqueList", boutiqueList);
        result.put("boutiqueApplyCount", applyCount);
        result.put("mealList", mealList);
        result.put("couponSum", couponBigDecimal);
        result.put("mealSum", mealBigDecimal);
        result.put("receiptList", receiptList);

        apiReturnInfo.setData(result);
        return apiReturnInfo;
    }
}