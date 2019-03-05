package com.unicdata.controller.login;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.condition.CarGoodsCondition;
import com.unicdata.constant.BaseEnum;
import com.unicdata.constant.ConstantEnum.AppOrderStatus;
import com.unicdata.constant.OrderEnum;
import com.unicdata.constant.PushEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.BoutiqueTarget;
import com.unicdata.entity.customer.PassengerFlow;
import com.unicdata.entity.push.PushMessageEmployee;
import com.unicdata.entity.system.Employee;
import com.unicdata.entity.system.EmployeeAuthorize;
import com.unicdata.entity.system.EmployeeAuthorizeExample;
import com.unicdata.entity.system.EmployeeTarget;
import com.unicdata.service.approval.ApprovalCusService;
import com.unicdata.service.approval.ApprovalOrderService;
import com.unicdata.service.boutique.BoutiqueTargetService;
import com.unicdata.service.car.AppCarGoodInfoService;
import com.unicdata.service.car.AppDeliverCarService;
import com.unicdata.service.customer.TaskFollowUpService;
import com.unicdata.service.employee.EmployeeTargetService;
import com.unicdata.service.order.OrderService;
import com.unicdata.service.passengerflow.PassengerFlowService;
import com.unicdata.service.system.AppPushMessageService;
import com.unicdata.service.system.EmployeeAuthorizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页
 *
 * @author admin
 */
@Controller
@RequestMapping("/app")
@Api(value = "首页相关", tags = {"首页相关接口"})
public class IndexController extends HomeBaseController {
    @Autowired
    private EmployeeTargetService employeeTargetService;
    @Autowired
    private TaskFollowUpService taskFollowUpService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PassengerFlowService passengerFlowService;
    @Autowired
    private ApprovalCusService approvalCusService;
    @Autowired
    private ApprovalOrderService approvalOrderService;
    @Autowired
    private AppDeliverCarService appDeliverCarService;
    @Autowired
    private BoutiqueTargetService boutiqueTargetService;
    @Autowired
    private AppCarGoodInfoService carGoodInfoService;
    @Autowired
    private AppDeliverCarService deliverCarService;
    @Autowired
    private EmployeeAuthorizeService employeeAuthorizeService;
    @Autowired
    private AppPushMessageService appPushMessageService;

    @ApiOperation(value = "销售顾问首页接口")
    @ResponseBody
    @RequestMapping(value = "/salesperson/index", method = RequestMethod.POST)
    public ApiReturnInfo index(HttpServletRequest request) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        //销售顾问目标表
        EmployeeTarget target = employeeTargetService.getCurrentMothTarget(emp.getId());
        //实际完成数
        int completeOrder = orderService.getCurrentMothOrderNum(emp.getId(), AppOrderStatus.已付订金.getCode());
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("createId", emp.getId());
        queryMap.put("deliverTime", new Date());
        int completeDeliver = deliverCarService.getMothDeliverCarNumByStoreId(queryMap);
        map.put("targetOrder", null != target ? target.getTargetOrder() : 0);
        map.put("completeOrder", completeOrder);
        map.put("targetDeliver", null != target ? target.getTargetDeliver() : 0);
        map.put("completeDeliver", completeDeliver);
        //我的任务
        PassengerFlow passengerFlow = new PassengerFlow();
        passengerFlow.setEmployeeId(emp.getId());
        passengerFlow.setCreateTime(new Date());
        List<PassengerFlow> pfList = passengerFlowService.selectPassengerFlowMes(passengerFlow);
        int approvalCustomer = approvalCusService.getApprovalCusNum(emp.getId());
        int approvalOrder = approvalOrderService.getApprovalOrderNum(emp.getId());
        map.put("passengerFlow", pfList.size());//客流数
        map.put("approvalCustomer", approvalCustomer);//客户审批数
        map.put("approvalOrder", approvalOrder);//订单审批数
        //跟进任务
        Map<String, Object> taskMap = taskFollowUpService.getTaskNumByEmployee(emp.getId());
        map.put("customerFollowUp", taskMap != null ? taskMap.get("customerFollowUp") : 0);//潜客跟进数
        map.put("invite", taskMap != null ? taskMap.get("invite") : 0);//潜客邀约数
        map.put("orderFollowUp", taskMap != null ? taskMap.get("orderFollowUp") : 0);//订单跟进数
        map.put("todayDeliver", taskMap != null ? taskMap.get("todayDeliver") : 0);//今日交车数
        map.put("afterService", taskMap != null ? taskMap.get("afterService") : 0);//后续服务数
        ari.setData(map);
        return ari;
    }

    @ApiOperation(value = "展厅经理首页接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页最大数量，默认30", required = true, dataType = "Integer")
    })
    @ResponseBody
    @RequestMapping(value = "/showroomManager/index", method = RequestMethod.POST)
    public ApiReturnInfo index(HttpServletRequest request, Integer pageNum, Integer pageSize) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        //销售顾问目标表
        EmployeeTarget target = employeeTargetService.getCurrentMothTarget(emp.getId());
        //实际完成数
        int completeOrder = orderService.getCurrentMothOrderNum(emp.getId(), 1);
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("createId", emp.getId());
        queryMap.put("deliverTime", new Date());
        int completeDeliver = deliverCarService.getMothDeliverCarNumByStoreId(queryMap);
        map.put("targetOrder", null != target ? target.getTargetOrder() : 0);
        map.put("completeOrder", completeOrder);
        map.put("targetDeliver", null != target ? target.getTargetDeliver() : 0);
        map.put("completeDeliver", completeDeliver);
        //客流列表
        PassengerFlow record = new PassengerFlow();
        record.setStoreId(emp.getStoreId());
        record.setCreateTime(new Date());
        Map<String, Object> pfMap = passengerFlowService.getPassengerFlowList(pageNum, pageSize, record);
        //返回客流数据
        map.put("passengerFlow", pfMap);

        //判断如果是展厅经理，是否有价格审批权限或者退订审批权限
        if (this.SHOWROOM_MANAGER_POSITION.equals(emp.getPostName())) {
            //查询展厅经理的临时权限
            EmployeeAuthorizeExample employeeAuthorizeExample = new EmployeeAuthorizeExample();
            EmployeeAuthorizeExample.Criteria criteria = employeeAuthorizeExample.createCriteria();
            criteria.andEmployeeIdEqualTo(emp.getId());
            criteria.andTypeEqualTo(Byte.valueOf(OrderEnum.EmployeeAuthorizeType.ONE.getCode() + ""));
            criteria.andStatusEqualTo(Byte.valueOf("1"));
            criteria.andDataStatusEqualTo(Byte.valueOf("1"));
            List<EmployeeAuthorize> employeeAuthorizes = employeeAuthorizeService.selectByExample(employeeAuthorizeExample);
            //判断展厅经理是否有订单审批权限2有1没有
            if (employeeAuthorizes != null && employeeAuthorizes.size() > 0) {
                map.put("orderApproval", 2);
            } else {
                map.put("orderApproval", 1);
            }
        } else {
            map.put("orderApproval", 1);
        }
        ari.setData(map);
        return ari;
    }

    @ApiOperation(value = "销售经理首页接口")
    @ResponseBody
    @RequestMapping(value = "/saleManager/index", method = RequestMethod.POST)
    public ApiReturnInfo saleManagerIndex(HttpServletRequest request) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            Map<String, Object> hashMap = new HashMap<String, Object>();
            map.put("storeId", emp.getStoreId());
            map.put("targetTime", new Date());
            //本月目标总数
            Map<String, Object> stringObjectMap = employeeTargetService.getMothTargetNumByStoreId(map);
            //建档目标
            Integer recordSum = Integer.valueOf(stringObjectMap.get("recordSum").toString());
            //试驾目标
            Integer driveSum = Integer.valueOf(stringObjectMap.get("driveSum").toString());
            //交车目标
            Integer deliverSum = Integer.valueOf(stringObjectMap.get("deliverSum").toString());
            //订单目标
            Integer orderSum = Integer.valueOf(stringObjectMap.get("orderSum").toString());
            //客流目标
            Integer cusSum = Integer.valueOf(stringObjectMap.get("cusSum").toString());

            // 创建一个数值格式化对象
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);

            //待定判断订单状态
            map.put("mouthTime", new Date());
            Map<String, Object> map1 = orderService.getMothOrderNumByStoreId(map);
            if (map1 != null) {
                //本月订单总数
                Integer sum = Integer.valueOf(map1.get("sum").toString());
                hashMap.put("orderSum", sum);
                //本月订单进度
                if (orderSum != 0) {
                    String orderProgress = numberFormat.format((float) sum / (float) orderSum * 100) + "%";
                    hashMap.put("orderProgress", orderProgress == null ? "0.00%" : orderProgress.replace(",", ""));
                } else {
                    hashMap.put("orderProgress", "0.00%");
                }

                //计划毛利收入
                Map<String, Object> map6 = new HashMap<String, Object>();
                map6.put("storeId", 1);
                List<BoutiqueTarget> targets = boutiqueTargetService.getBoutiqueTargetByStoreId(map6);
                BigDecimal profitPlay = new BigDecimal(0);
                for (BoutiqueTarget target : targets) {
                    BigDecimal profitPlay1 = target.getProfitPlay();
                    if (profitPlay1 != null) {
                        profitPlay = profitPlay.add(profitPlay1);
                    }
                }

                Object sumMargin1 = map1.get("sumMargin");
                if (sumMargin1 != null) {
                    //本月毛利总数
                    BigDecimal bigDecimal = new BigDecimal(sumMargin1.toString());
                    BigDecimal bigDecimal2 = new BigDecimal(10000);
                    hashMap.put("sumMargin", bigDecimal.divide(bigDecimal2, 2, BigDecimal.ROUND_HALF_UP));

                    BigDecimal sumMargin = new BigDecimal(sumMargin1.toString());
                    BigDecimal df = new BigDecimal("100");
                    //本月毛利进度
                    if (profitPlay.compareTo(BigDecimal.ZERO) == 1) {
                        String marginProgress = sumMargin.divide(profitPlay, 4, BigDecimal.ROUND_HALF_UP).multiply(df).setScale(2, BigDecimal.ROUND_HALF_UP) + "%";
                        hashMap.put("marginProgress", marginProgress == null ? "0.00%" : marginProgress);
                    } else {
                        hashMap.put("marginProgress", "0.00%");
                    }
                } else {
                    hashMap.put("sumMargin", 0);
                    hashMap.put("marginProgress", "0.00%");
                }
            }
            //本月待交车数
            map.put("deliverTime", new Date());
            hashMap.put("stayCarSum", taskFollowUpService.selectCountByStore(map));
            //本月已交车数
            int carNum2 = appDeliverCarService.getMothDeliverCarNumByStoreId(map);
            hashMap.put("alreadyCarSum", carNum2);

            //本月交车进度
            if (deliverSum != 0) {
                String carNumProgress = numberFormat.format((float) carNum2 / (float) deliverSum * 100) + "%";
                hashMap.put("carNumProgress", carNumProgress == null ? "0.00%" : carNumProgress);
            } else {
                hashMap.put("carNumProgress", "0.00%");
            }

            //当日交车数
            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("dayTime", new Date());
            map3.put("storeId", 1);
            int daySum = appDeliverCarService.getMothDeliverCarNumByStoreId(map3);
            hashMap.put("daySum", daySum);

            //当日订单
            map3.put("groupName", "DCC");
            Map<String, Object> thisDayDcc = orderService.getMothOrderNumByStoreId(map3);
            hashMap.put("thisDayDcc", (thisDayDcc != null && thisDayDcc.get("sum") != null) ? thisDayDcc.get("sum").toString() : "");

            map3.put("groupName", "销售部");
            Map<String, Object> thisDaySale = orderService.getMothOrderNumByStoreId(map3);
            hashMap.put("thisDaySale", (thisDaySale != null && thisDaySale.get("sum") != null) ? thisDaySale.get("sum").toString() : "");

            map3.put("groupName", "其他");
            Map<String, Object> otherSale = orderService.getMothOrderNumByStoreId(map3);
            hashMap.put("otherSale", (otherSale != null && otherSale.get("sum") != null) ? otherSale.get("sum").toString() : "");

            //当日DCC 暂时不做
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("createTime", new Date());
            map2.put("storeId", 1);
            //首次客流量
            map2.put("type", 1);
            int firstSum = passengerFlowService.getMouthPassengerFlowList(map2);
            hashMap.put("firstSum", firstSum);

            //再次客流量
            map2.put("type", 2);
            int againSum = passengerFlowService.getMouthPassengerFlowList(map2);
            hashMap.put("againSum", againSum);

            //订单审批数
            Map<String, Object> map4 = new HashMap<String, Object>();
            map4.put("storeId", 1);
            map4.put("approvalStatus", 0);
            List<Map<String, Object>> maps = approvalOrderService.selectOrderByStoreId(map4);
            hashMap.put("approvalOrderSum", maps == null ? "0" : maps.size());

            //警戒占比
            Map<String, Object> map5 = new HashMap<String, Object>();
            //库存查询
            map5.put("storeId", 1);
            List<Map<String, Object>> maps1 = carGoodInfoService.selectByManyConditions(map5);
            //利息总额
            BigDecimal bigDecimal = new BigDecimal(0);
            for (Map<String, Object> objectMap : maps1) {
                Object interest_price = objectMap.get("interest_price");
                if (interest_price != null) {
                    BigDecimal bigDecimal1 = new BigDecimal(interest_price.toString());
                    if (bigDecimal1 != null) {
                        bigDecimal = bigDecimal.add(bigDecimal1);
                    }
                }
            }
            BigDecimal bigDecimal3 = new BigDecimal(10000);
            bigDecimal = bigDecimal.divide(bigDecimal3, 2, BigDecimal.ROUND_HALF_UP);
            //库存利息总额
            hashMap.put("interest", bigDecimal + "万");


            // 库存总数
            CarGoodsCondition carGoodsCondition = new CarGoodsCondition();
            carGoodsCondition.setDistributorStoreId(emp.getStoreId());
            // 库存状态为在库、外出、整备出库，处理状态为正常、待整备、整备中、暂收，订单状态为无、已预订
            carGoodsCondition.setType(3);
            PageInfo<Map<String, Object>> maps2 = carGoodInfoService.selectListByStoreSimplify(carGoodsCondition);
            hashMap.put("storageSum", maps2.getList().size());
            // 利息总额
            BigDecimal bigDecimal2 = new BigDecimal(0);
            for (Map<String, Object> objectMap : maps2.getList()) {
                Object interest_price = objectMap.get("interestPrice");
                if (interest_price != null) {
                    BigDecimal bigDecimal1 = new BigDecimal(interest_price.toString());
                    if (bigDecimal1 != null) {
                        bigDecimal2 = bigDecimal2.add(bigDecimal1);
                    }
                }
            }
            // 库存利息总额 转换成万
            hashMap.put("interest", bigDecimal2.divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP) + "万");

            //安全库存查询
            map5.put("inStorageDay", BaseEnum.CAR_STORAGE_WARN);
            List<Map<String, Object>> maps3 = carGoodInfoService.selectByManyConditions(map5);
            if (maps1 != null && maps1.size() > 0) {
                String vigilanceRatio = numberFormat.format((float) maps3.size() / (float) maps1.size() * 100) + "%";
                hashMap.put("vigilanceRatio", vigilanceRatio == null ? "0" : vigilanceRatio);
            } else {
                hashMap.put("vigilanceRatio", "0");
            }
            //库存系数：现有库存总数除以未来3个月平均销量（手动录入未来3个月平均销量值）
            //未来3个月平均销量值
            // 库存系数：现有库存总数除以未来3个月平均销量（手动录入未来3个月平均销量值）
            // 未来3个月平均销量值
            Integer integer = BaseEnum.CAR_AVERAGE_SALE;
            if (integer != 0) {
                hashMap.put("coefficient", numberFormat.format((float) maps2.getList().size() / (float) integer));
            }
            ar.setData(hashMap);
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }

        return ar;
    }

    @ApiOperation(value = "修改推送销售已读")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageId", value = "推送消息id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/push/updateViewState", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo updateViewState(HttpServletRequest request, PushMessageEmployee record) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        record.setEmployeeId(emp.getId());
        record.setViewState(PushEnum.ViewStates.VIEWED.getCode());
        record.setViewTime(new Date());
        appPushMessageService.updateViewState(record);
        ari.setData(null);
        return ari;
    }
}
