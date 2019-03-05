package com.unicdata.controller.index;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.conditon.TargetCondition;
import com.unicdata.constant.*;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.approval.ApprovalCus;
import com.unicdata.entity.approval.ApprovalOrder;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.car.CarOutApplication;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.TestDriveApply;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.entity.system.EmployeeTarget;
import com.unicdata.service.app.OrderService;
import com.unicdata.service.approval.ApprovalCusService;
import com.unicdata.service.approval.ApprovalOrderService;
import com.unicdata.service.approval.ApprovalReplaceService;
import com.unicdata.service.basedata.PcDictionaryService;
import com.unicdata.service.boutique.BoutiqueRetailIncludeService;
import com.unicdata.service.boutique.RetailIncludeSupportService;
import com.unicdata.service.boutique.RetailSupportService;
import com.unicdata.service.car.CarOutApplicationService;
import com.unicdata.service.car.DeliverCarService;
import com.unicdata.service.customer.*;
import com.unicdata.service.employee.EmployeeTargetService;
import com.unicdata.service.order.SaleOrderService;
import com.unicdata.service.system.EmployeeService;
import com.unicdata.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/rulai/index")
@Api(value = "销售顾问首页", tags = {"销售顾问首页接口"})
public class IndexController extends HomeBaseController {

    @Autowired
    private EmployeeTargetService employeeTargetService;

    @Autowired
    private SaleOrderService saleOrderService;

    @Autowired
    private PassengerFlowService passengerFlowService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TestDriveService testDriveService;

    @Autowired
    private ApprovalCusService approvalCusService;

    @Autowired
    private ApprovalOrderService approvalOrderService;

    @Autowired
    private ApprovalReplaceService approvalReplaceService;

    @Autowired
    private TaskFollowUpService taskFollowUpService;

    @Autowired
    private CarOutApplicationService carOutApplicationService;

    @Autowired
    private TestDriveApplyService testDriveApplyService;

    @Autowired
    private RetailSupportService retailSupportService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DeliverCarService appDeliverCarService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PcDictionaryService pcDictionaryService;

    private static final Integer indexPageNum = 1;
    //首页默认展示5条数据
    private static final Integer indexPageSize = 5;

    @ApiOperation(value = "销售顾问首页顶部接口")
    @RequestMapping(value = "/top", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> salespersonIndex(HttpServletRequest request) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo();
        Map<String, Object> map = Maps.newHashMap();
        Employee member = getMember(request);
        Map<String, Object> params = Maps.newHashMap();
        if (Objects.equals(member.getPostName(), this.SALES_CONSULTANT_POSITION)) {
            //销售顾问目标表
            EmployeeTarget target = employeeTargetService.getCurrentMothTarget(member.getId());
            //完成订单数量
            int completeOrder = saleOrderService.getCurrentMothOrderNum(member.getId(), 1);
            map.put("completeOrder", completeOrder);
            //交车完成数量
            int completeDeliver = saleOrderService.getCurrentMothOrderNum(member.getId(), 4);
            map.put("completeDeliver", completeDeliver);
            //本月客流完成数量
            params.put("employeeId", member.getId());
            int thisMonthPassengerFlow = passengerFlowService.thisMonthPassengerFlow(params);
            map.put("thisMonthPassengerFlow", thisMonthPassengerFlow);
            //本月首次客流总数
            int thisMonthFirstPassengerFlow = passengerFlowService.thisMonthFirstPassengerFlow(params);
            map.put("thisMonthFirstPassengerFlow", thisMonthFirstPassengerFlow);
            //本月留档
            int completeCusRecord = customerService.getCurrentMothCusRecord(params);
            map.put("completeCusRecord", completeCusRecord);
            //本月试驾
            int completeTestDrive = testDriveService.getCurrentMothTestDrive(params);
            map.put("completeTestDrive", completeTestDrive);


            //目标订单数
            int targetOrderSum = (target == null ? 0 : (target.getTargetOrder() == null ? 0 : target.getTargetOrder()));
            map.put("targetOrderSum", targetOrderSum);
            //目标交车数
            int targetDeliveryCar = (target == null ? 0 : (target.getTargetDeliver() == null ? 0 : target.getTargetDeliver()));
            map.put("targetDeliveryCar", targetDeliveryCar);
            //目标客流
            int targetCus = (target == null ? 0 : (target.getTargetCus() == null ? 0 : target.getTargetCus()));
            map.put("targetCus", targetCus);
            //目标留档
            int targetRecord = (target == null ? 0 : (target.getTargetRecord() == null ? 0 : target.getTargetRecord()));
            map.put("targetRecord", targetRecord);
            //目标试驾
            int targetDrive = (target == null ? 0 : (target.getTargetDrive() == null ? 0 : target.getTargetDrive()));
            map.put("targetDrive", targetDrive);
        } else {
            params.put("targetTime", new Date());
            params.put("storeId", member.getStoreId());
            // 本月目标map
            Map<String, Object> stringObjectMap = employeeTargetService.getMothTargetNumByStoreId(params);
            // 本月目标订单数
            map.put("targetOrderSum", Integer.valueOf(stringObjectMap.get("orderSum").toString()));
            // 本月交车目标数
            map.put("targetDeliveryCar", Integer.valueOf(stringObjectMap.get("deliverSum").toString()));
            // 目标客流
            map.put("targetCus", Integer.valueOf(stringObjectMap.get("cusSum").toString()));
            // 目标留档
            map.put("targetRecord", Integer.valueOf(stringObjectMap.get("recordSum").toString()));
            // 本月试驾目标数
            map.put("targetDrive", Integer.valueOf(stringObjectMap.get("driveSum").toString()));
            //本月首次客流数
            int thisMonthFirstPassengerFlow = passengerFlowService.thisMonthFirstPassengerFlow(params);
            map.put("thisMonthFirstPassengerFlow", thisMonthFirstPassengerFlow);

            // 本月订单实际总数
            params.put("mouthTime", new Date());
            Map<String, Object> orderMap = orderService.getMothOrderNumByStoreId(params);
            map.put("completeOrder", (orderMap != null && orderMap.get("sum") != null) ? orderMap.get("sum") : 0);
            // 本月已交车数
            params.put("status", 1);
            map.put("completeDeliver", appDeliverCarService.getMothDeliverCarNumByStoreId(params));
            //本月客流
            map.put("thisMonthPassengerFlow", passengerFlowService.thisMonthPassengerFlow(params));
            //本月留档
            map.put("completeCusRecord", passengerFlowService.thisMonthPassengerFlow(params));
            //本月试驾
            map.put("completeTestDrive", testDriveService.getCurrentMothTestDrive(params));
        }
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "首页订单审批接口")
    @RequestMapping(value = "/order/approve/list", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "日期", dataType = "String"),
            @ApiImplicitParam(name = "isIndex", value = "是否首页", dataType = "Boolean"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> orderApproval(Integer pageNum, Integer pageSize, String date, Boolean isIndex, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        Employee employee = getMember(request);
        Map<String, Object> params = Maps.newHashMap();
        //如果是销售顾问
        if (Objects.equals(employee.getPostName(), this.SALES_CONSULTANT_POSITION)) {
            params.put("employeeId", employee.getId());
        } else if (Objects.equals(employee.getPostName(), this.SALES_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.SHOWROOM_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.TOP_MANAGER)) {//如果是经理
            params.put("storeId", employee.getStoreId());
        }
        //如果是首页
        if (Objects.equals(isIndex, Boolean.TRUE)) {
            pageNum = indexPageNum;
            pageSize = indexPageSize;
            date = DateUtil.dateFormat(new Date(), DateUtil.sdf2);
        }
        if (StringUtils.isNotBlank(date)) {
            params.put("applyTime", date);
        }
        PageInfo<Map<String, Object>> pageInfo = approvalOrderService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> list = pageInfo.getList();
        for (Map<String, Object> map : list) {
            map.put("approvalStatusDesc", map.get("approvalStatus") != null ? SettleEnum.ApprovalStates.getByCode((Integer) map.get("approvalStatus")).getDesc() : "");
            if (map.get("orderId") != null) {
                BoutiqueRetail retail = retailSupportService.getRetailByOrderId((Integer) map.get("orderId"));
                map.put("boutiqueAmount", retail == null ? BigDecimal.ZERO : (retail.getApplyCount() == null ? BigDecimal.ZERO : retail.getApplyCount()));
            } else {
                map.put("boutiqueAmount", null);
            }
        }
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "首页换车审批列表接口")
    @RequestMapping(value = "/changeCar/approve/list", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "日期", dataType = "String"),
            @ApiImplicitParam(name = "isIndex", value = "是否首页", dataType = "Boolean"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> changeCarApproval(Integer pageNum, Integer pageSize, String date, Boolean isIndex, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        Employee employee = getMember(request);
        Map<String, Object> params = Maps.newHashMap();
        //如果是销售顾问
        if (Objects.equals(employee.getPostName(), this.SALES_CONSULTANT_POSITION)) {
            params.put("employeeId", employee.getId());
        } else if (Objects.equals(employee.getPostName(), this.SALES_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.SHOWROOM_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.TOP_MANAGER)) {//如果是经理
            if (employee.getStoreId() != null) {
                params.put("storeId", employee.getStoreId());
            }
        }
        //如果是首页
        if (Objects.equals(isIndex, Boolean.TRUE)) {
            pageNum = indexPageNum;
            pageSize = indexPageSize;
            date = DateUtil.dateFormat(new Date(), DateUtil.sdf2);
        }
        if (StringUtils.isNotBlank(date)) {
            params.put("applyTime", date);
        }
        PageInfo<Map<String, Object>> pageInfo = approvalReplaceService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> list = pageInfo.getList();
        for (Map<String, Object> map : list) {
            map.put("orderStatusDesc", map.get("orderStatus") != null ? SettleEnum.OrderStatus.getByCode((Integer) map.get("orderStatus")).getReason() : "");
            map.put("approvalStatusDesc", map.get("approvalStatus") != null ? SettleEnum.ApprovalStates.getByCode((Integer) map.get("approvalStatus")).getDesc() : "");
        }
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "首页退订审批列表接口")
    @RequestMapping(value = "/order/unApprove/list", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "日期", dataType = "String"),
            @ApiImplicitParam(name = "isIndex", value = "是否首页", dataType = "Boolean"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> orderBack(Integer pageNum, Integer pageSize, String date, Boolean isIndex, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        Employee employee = getMember(request);
        Map<String, Object> params = Maps.newHashMap();
        //如果是销售顾问
        if (Objects.equals(employee.getPostName(), this.SALES_CONSULTANT_POSITION)) {
            params.put("employeeId", employee.getId());
        } else if (Objects.equals(employee.getPostName(), this.SALES_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.SHOWROOM_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.TOP_MANAGER)) {//如果是经理
            if (employee.getStoreId() != null) {
                params.put("storeId", employee.getStoreId());
            }
        }
        //如果是首页
        if (Objects.equals(isIndex, Boolean.TRUE)) {
            pageNum = indexPageNum;
            pageSize = indexPageSize;
            date = DateUtil.dateFormat(new Date(), DateUtil.sdf2);
        }
        if (StringUtils.isNotBlank(date)) {
            params.put("applyTime", date);
        }
        PageInfo<Map<String, Object>> pageInfo = approvalOrderService.getListByParams2(params, pageNum, pageSize);
        List<Map<String, Object>> list = pageInfo.getList();
        for (Map<String, Object> map : list) {
            map.put("orderStatusDesc", map.get("orderStatus") != null ? SettleEnum.OrderStatus.getByCode((Integer) map.get("orderStatus")).getReason() : "");
            map.put("approvalStatusDesc", map.get("approvalStatus") != null ? SettleEnum.ApprovalStates.getByCode((Integer) map.get("approvalStatus")).getDesc() : "");
        }
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "首页休眠审批列表接口")
    @RequestMapping(value = "/customer/sleep/list", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "日期", dataType = "String"),
            @ApiImplicitParam(name = "isIndex", value = "是否首页", dataType = "Boolean"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> cusSleep(Integer pageNum, Integer pageSize, String date, Boolean isIndex, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        Employee employee = getMember(request);
        Map<String, Object> params = Maps.newHashMap();
        //如果是销售顾问
        if (Objects.equals(employee.getPostName(), this.SALES_CONSULTANT_POSITION)) {
            params.put("employeeId", employee.getId());
        } else if (Objects.equals(employee.getPostName(), this.SALES_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.SHOWROOM_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.TOP_MANAGER)) {//如果是经理
            params.put("storeId", employee.getStoreId());
        }
        //如果是首页
        if (Objects.equals(isIndex, Boolean.TRUE)) {
            pageNum = indexPageNum;
            pageSize = indexPageSize;
            date = DateUtil.dateFormat(new Date(), DateUtil.sdf2);
        }
        if (StringUtils.isNotBlank(date)) {
            params.put("applyTime", date);
        }
        params.put("approvalType", 1);
        PageInfo<Map<String, Object>> pageInfo = approvalCusService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> list = pageInfo.getList();
        for (Map<String, Object> map : list) {
            map.put("approvalStatusDesc", map.get("approvalStatus") != null ? SettleEnum.ApprovalStates.getByCode((Integer) map.get("approvalStatus")).getDesc() : "");
            map.put("levelDesc", map.get("level") != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, (Integer) map.get("level")) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, (Integer) map.get("level")).getResourceValue()) : "");
        }
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "首页战败批列表接口")
    @RequestMapping(value = "/customer/fail/list", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "日期", dataType = "String"),
            @ApiImplicitParam(name = "isIndex", value = "是否首页", dataType = "Boolean"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> cusFail(Integer pageNum, Integer pageSize, String date, Boolean isIndex, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        Employee employee = getMember(request);
        Map<String, Object> params = Maps.newHashMap();
        //如果是销售顾问
        if (Objects.equals(employee.getPostName(), this.SALES_CONSULTANT_POSITION)) {
            params.put("employeeId", employee.getId());
        } else if (Objects.equals(employee.getPostName(), this.SALES_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.SHOWROOM_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.TOP_MANAGER)) {//如果是经理
            params.put("storeId", employee.getStoreId());
        }
        //如果是首页
        if (Objects.equals(isIndex, Boolean.TRUE)) {
            pageNum = indexPageNum;
            pageSize = indexPageSize;
            date = DateUtil.dateFormat(new Date(), DateUtil.sdf2);
        }
        if (StringUtils.isNotBlank(date)) {
            params.put("applyTime", date);
        }
        params.put("approvalType", 2);
        PageInfo<Map<String, Object>> pageInfo = approvalCusService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> list = pageInfo.getList();
        for (Map<String, Object> map : list) {
            map.put("approvalStatusDesc", map.get("approvalStatus") != null ? SettleEnum.ApprovalStates.getByCode((Integer) map.get("approvalStatus")).getDesc() : "");
            map.put("levelDesc", map.get("level") != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, (Integer) map.get("level")) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, (Integer) map.get("level")).getResourceValue()) : "");
        }
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "首页潜客跟进/潜客邀约接口")
    @RequestMapping(value = "/customer/follow/list", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "日期", dataType = "String"),
            @ApiImplicitParam(name = "taskType", value = "任务类型(1,潜客跟进 2,潜客邀约)", dataType = "Integer"),
            @ApiImplicitParam(name = "isIndex", value = "是否首页", dataType = "Boolean"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> cusFollow(Integer pageNum, Integer pageSize, Integer taskType, Boolean isIndex, String date, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (taskType == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("taskType字段不能为空");
            return result;
        }
        Employee employee = getMember(request);
        Map<String, Object> params = Maps.newHashMap();
        //如果是销售顾问
        if (Objects.equals(employee.getPostName(), this.SALES_CONSULTANT_POSITION)) {
            params.put("employeeId", employee.getId());
        } else if (Objects.equals(employee.getPostName(), this.SALES_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.SHOWROOM_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.TOP_MANAGER)) {//如果是经理
            params.put("storeId", employee.getStoreId());
        }
        params.put("taskType", taskType);
        //如果是首页
        if (Objects.equals(isIndex, Boolean.TRUE)) {
            pageNum = indexPageNum;
            pageSize = indexPageSize;
            date = DateUtil.dateFormat(new Date(), DateUtil.sdf2);
        }
        if (StringUtils.isNotBlank(date)) {
            params.put("nextDate", date);
        }
        PageInfo<Map<String, Object>> pageInfo = taskFollowUpService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> list = pageInfo.getList();
        for (Map<String, Object> map : list) {
            map.put("sexDesc", map.get("sex") == null ? null : ((Integer) map.get("sex") == 1 ? "女" : "男"));
            map.put("levelDesc", map.get("level") != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, (Integer) map.get("level")) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, (Integer) map.get("level")).getResourceValue()) : "");
            map.put("nextContentDesc", map.get("nextContent") != null ? CustomerEnum.TaskFollowContent.getByCode((Integer) map.get("nextContent")).getDesc() : "");
        }
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "首页订单跟进/今日交车/后续服务接口")
    @RequestMapping(value = "/customer/order/follow/list", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "日期(交车/下次跟进日期)", dataType = "String"),
            @ApiImplicitParam(name = "taskType", value = "任务类型(3:订单跟进 4:今日交车 5:后续服务)", dataType = "Integer"),
            @ApiImplicitParam(name = "isIndex", value = "是否首页", dataType = "Boolean"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> cusFollow2(Integer pageNum, Integer pageSize, Integer taskType, Boolean isIndex, String date, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (taskType == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("taskType字段不能为空");
            return result;
        }
        Employee employee = getMember(request);
        Map<String, Object> params = Maps.newHashMap();
        //如果是销售顾问
        if (Objects.equals(employee.getPostName(), this.SALES_CONSULTANT_POSITION)) {
            params.put("employeeId", employee.getId());
        } else if (Objects.equals(employee.getPostName(), this.SALES_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.SHOWROOM_MANAGER_POSITION) || Objects.equals(employee.getPostName(), this.TOP_MANAGER)) {//如果是经理
            params.put("storeId", employee.getStoreId());
        }
        params.put("taskType", taskType);
        //如果是首页
        if (Objects.equals(isIndex, Boolean.TRUE)) {
            pageNum = indexPageNum;
            pageSize = indexPageSize;
            date = DateUtil.dateFormat(new Date(), DateUtil.sdf2);
        }
        if (StringUtils.isNotBlank(date)) {
            params.put("nextDate", date);
        }

        PageInfo<Map<String, Object>> pageInfo = taskFollowUpService.getListByParams2(params, pageNum, pageSize);
        List<Map<String, Object>> list = pageInfo.getList();
        for (Map<String, Object> map : list) {
            map.put("orderStatusDesc", map.get("orderStatus") != null ? SettleEnum.OrderStatus.getByCode((Integer) map.get("orderStatus")).getReason() : "");
            map.put("nextContentDesc", map.get("nextContent") != null ? CustomerEnum.TaskFollowContent.getByCode((Integer) map.get("nextContent")).getDesc() : "");
        }
        result.setData(pageInfo);
        return result;
    }

    @RequestMapping(value = "/orderApproval", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("订单、退订审批")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalId", value = "审批单号", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "approvalType", value = "审批类型，1订单审批2退订审批", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "approvalResult", value = "审批结果1通过2不通过", dataType = "Integer", required = true)
    })
    public ApiReturnInfo orderApproval(HttpServletRequest request, Integer approvalId, Integer approvalType, Integer approvalResult, @ApiIgnore ApiReturnInfo apiReturnInfo) {
        Employee member = getMember(request);
        ApprovalOrder approvalOrder = approvalOrderService.selectApprovalOrder(approvalId);
        //更新审批表数据
        approvalOrder.setIfSaleApproval(1);
        approvalOrder.setSaleApproveId(member.getId());
        approvalOrder.setSaleApprovalTime(DateUtil.now());
        approvalOrder.setSaleApprovalResult(Integer.parseInt(approvalResult.toString()));
        Order order = saleOrderService.selectByPrimaryKey(approvalOrder.getOrderId());
        Employee employee = employeeService.employeeById(order.getCreateId());
        //审核不通过则直接修改审批状态为不通过
        if (approvalResult == 2) {
            approvalOrder.setApprovalStatus(2);
            approvalOrderService.updateApprovalOrder(approvalOrder);
            //判断是订单审核还是退订审核
            if (approvalType == 1) {
                //推送消息到销售顾问
                List<String> postNames = new ArrayList<String>() {
                    {
                        add(SALES_CONSULTANT_POSITION);
                    }
                };
                saleOrderService.pushMess(member.getStoreId(), postNames,
                        PushEnum.PushType.ORDER_NO_PASS.getCode(), PushEnum.PushType.ORDER_NO_PASS.getDesc(),
                        member.getId(), order, employee);
            }
            return apiReturnInfo;
        }
        approvalOrderService.updateApprovalOrder(approvalOrder);


        //如果是订单审批则需要判断是否审批通过
        if (approvalType == 1) {
            //判断如果销售经理和精品经理都已经审核通过则修改订单状态和审批状态为已生效,否则将审批状态改为不通过
            if (approvalOrderService.ifPass(approvalId)) {
                //修改审核状态为通过
                approvalOrder.setApprovalStatus(1);
                approvalOrderService.updateApprovalOrder(approvalOrder);
                //更新订单状态
                order.setStatus(SettleEnum.OrderStatus.EFFECTIVE.getCode());
                saleOrderService.updateOrder(order);
                //修改客户分类为订单
                Customer customerById = customerService.getCustomerById(order.getCusId());
                customerById.setCategory(2);
                customerService.save(customerById);
                //推送消息到财务、信息员、销售顾问
                List<String> postNames = new ArrayList<String>() {
                    {
                        add(financePosition);
                        add(informationMemberPosition);
                        add(SALES_CONSULTANT_POSITION);
                    }
                };
                saleOrderService.pushMess(member.getStoreId(), postNames,
                        PushEnum.PushType.ORDER_AUDITED.getCode(), PushEnum.PushType.ORDER_AUDITED.getDesc(),
                        member.getId(), order, employee);
            }
            return apiReturnInfo;
        }
        //退订审批通过则修改订单状态为待退单
        order.setStatus(SettleEnum.OrderStatus.WAIT_REFUND.getCode());
        saleOrderService.updateOrder(order);
        //推送消息给财务
        List<String> postNames = new ArrayList<String>() {
            {
                add(financePosition);
            }
        };
        saleOrderService.pushMess(member.getStoreId(), postNames,
                PushEnum.PushType.ORDER_REFUND.getCode(), PushEnum.PushType.ORDER_REFUND.getDesc(),
                member.getId(), order, employee);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/cusApproval", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("休眠、战败审批")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalId", value = "审批单号", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "approvalType", value = "审批类型，1:休眠审批 2:战败审批", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "approvalResult", value = "审批结果1通过2通不过", dataType = "Integer", required = true)
    })
    public ApiReturnInfo cusApproval(HttpServletRequest request, @ApiIgnore ApiReturnInfo apiReturnInfo, Integer approvalId, Integer approvalType, Integer approvalResult) {
        Employee member = getMember(request);
        ApprovalCus approvalCus = approvalCusService.selectByPrimaryKey(approvalId);
        Employee employee = employeeService.employeeById(approvalCus.getEmployeeId());
        Customer customer = customerService.getCustomerById(approvalCus.getCusId());
        approvalCus.setApprovalStatus(Integer.parseInt(approvalResult.toString()));
        approvalCus.setApproveId(member.getId());
        //審核通過則修改客戶分類
        if (approvalResult == 1) {
            if (approvalType == 1) {
                customer.setCategory(CustomerEnum.CustomerCategory.SLEEP_CUS.getCode());
                //消息推送
                List<String> postNames = new ArrayList<String>() {
                    {
                        add(SALES_CONSULTANT_POSITION);
                    }
                };
                Order order = new Order();
                order.setCusName(customer.getName());
                saleOrderService.pushMess(member.getStoreId(), postNames,
                        PushEnum.PushType.ORDER_CUSXM_PASS.getCode(), PushEnum.PushType.ORDER_CUSXM_PASS.getDesc(),
                        member.getId(), order, employee);
            }
            if (approvalType == 2) {
                customer.setCategory(CustomerEnum.CustomerCategory.DIE_CUS.getCode());
                //消息推送
                List<String> postNames = new ArrayList<String>() {
                    {
                        add(SALES_CONSULTANT_POSITION);
                    }
                };
                Order order = new Order();
                order.setCusName(customer.getName());
                saleOrderService.pushMess(member.getStoreId(), postNames,
                        PushEnum.PushType.ORDER_CUSZB_PASS.getCode(), PushEnum.PushType.ORDER_CUSZB_PASS.getDesc(),
                        member.getId(), order, employee);
            }
            customerService.save(customer);
        } else {
            if (approvalType == 1) {
                //消息推送
                List<String> postNames = new ArrayList<String>() {
                    {
                        add(SALES_CONSULTANT_POSITION);
                    }
                };
                Order order = new Order();
                order.setCusName(customer.getName());
                saleOrderService.pushMess(member.getStoreId(), postNames,
                        PushEnum.PushType.ORDER_CUSXM_FIRST.getCode(), PushEnum.PushType.ORDER_CUSXM_FIRST.getDesc(),
                        member.getId(), order, employee);
            }
            if (approvalType == 2) {
                //消息推送
                List<String> postNames = new ArrayList<String>() {
                    {
                        add(SALES_CONSULTANT_POSITION);
                    }
                };
                Order order = new Order();
                order.setCusName(customer.getName());
                saleOrderService.pushMess(member.getStoreId(), postNames,
                        PushEnum.PushType.ORDER_CUSZB_FIRST.getCode(), PushEnum.PushType.ORDER_CUSZB_FIRST.getDesc(),
                        member.getId(), order, employee);
            }
        }

        approvalCusService.updateByPrimaryKeySelective(approvalCus);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/carOutApproval", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("车辆外出审批")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalId", value = "审批单号", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "approvalResult", value = "审批结果1通过2通不过", dataType = "Integer", required = true)
    })
    public ApiReturnInfo carOutApproval(HttpServletRequest request, @ApiIgnore ApiReturnInfo apiReturnInfo, Integer approvalId, Integer approvalResult) {
        Employee member = getMember(request);
        CarOutApplication carOutApplication = carOutApplicationService.selectByPrimaryKey(approvalId);
        carOutApplication.setEmployeeId(member.getId());
        carOutApplication.setApprovalTime(DateUtil.now());
        //如果是销售经理审核，通过则修改状态为总经理审核，不通过修改为不通过
        if (member.getPostName().equals(this.SALES_MANAGER_POSITION)) {
            if (approvalResult == 1) {
                carOutApplication.setApprovalStatus(Byte.parseByte(4 + ""));
            } else {
                carOutApplication.setApprovalStatus(Byte.parseByte(approvalResult.toString()));
            }
        } else {
            carOutApplication.setApprovalStatus(Byte.parseByte(approvalResult.toString()));
        }
        carOutApplicationService.updateByPrimaryKeySelective(carOutApplication);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/targetList", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("员工目标列表")
    @ApiImplicitParam(name = "targetTime", value = "目标周期,'yyyy-MM格式'", dataType = "String", required = true)
    public ApiReturnInfo targetList(HttpServletRequest request, String targetTime, @ApiIgnore ApiReturnInfo apiReturnInfo) {
        Employee member = getMember(request);
        Map param = new HashMap();
        param.put("storeId", member.getStoreId());
        param.put("targetTime", targetTime);
        param.put("postName", this.SALES_CONSULTANT_POSITION);
        List<Map<String, Object>> targetList = employeeTargetService.saleManTarget(param);
        apiReturnInfo.setData(targetList);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/setUpTarget", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("设定员工目标")
    @ApiImplicitParam(name = "targetTime", value = "员工目标列表", dataType = "List", required = true)
    public ApiReturnInfo setUpTarget(@RequestBody TargetCondition targetCondition, @ApiIgnore ApiReturnInfo apiReturnInfo) {
        List<EmployeeTarget> targetList = targetCondition.getTargetList();
        for (EmployeeTarget employeeTarget : targetList) {
            Map<String, Object> param = new HashMap<>();
            param.put("employeeId", employeeTarget.getEmployeeId());
            param.put("targetTime", employeeTarget.getTargetTime());
            EmployeeTarget employeeTarget1 = employeeTargetService.employeeIdTarget(param);
            if (employeeTarget1 == null) {
                employeeTargetService.insertSelective(employeeTarget);
            } else {
                employeeTarget.setId(employeeTarget1.getId());
                employeeTargetService.updateByPrimaryKeySelective(employeeTarget);
            }
        }
        return apiReturnInfo;
    }

    @RequestMapping(value = "/testCarApprovalList", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("获取试驾车申请列表")
    @ApiImplicitParam(name = "createTime", value = "申请时间", dataType = "String")
    public ApiReturnInfo testCarApprovalList(HttpServletRequest request, @ApiIgnore ApiReturnInfo<List<Map<String, Object>>> apiReturnInfo, String createTime) {
        Employee member = getMember(request);
        //展厅经理展示自己发起的申请列表
        if (member.getPostName().equals(this.SHOWROOM_MANAGER_POSITION)) {
            List list = testDriveApplyService.listByCreateId(member.getId());
            apiReturnInfo.setData(list);
            return apiReturnInfo;
        }
        Map<String, Object> param = new HashMap<>();
        param.put("storeId", member.getStoreId());
        if (createTime != null && !createTime.equals("")) {
            param.put("createTime", createTime);
        }
        List<Map<String, Object>> approvalList = testDriveApplyService.testCarApprovalList(param);
        apiReturnInfo.setData(approvalList);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/testCarApprovalCars", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("试驾车申请车辆列表")
    @ApiImplicitParam(name = "approvalId", value = "试驾车申请单id", dataType = "integer", required = true)
    public ApiReturnInfo testCarApprovalDetail(Integer approvalId, @ApiIgnore ApiReturnInfo<List<Map<String, Object>>> apiReturnInfo) {
        List<Map<String, Object>> carList = testDriveApplyService.testCarApprovalCars(approvalId);
        apiReturnInfo.setData(carList);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/testCarApprovalResult", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("试驾车申请审批结果提交")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalId", value = "试驾车申请单id", dataType = "integer", required = true),
            @ApiImplicitParam(name = "approvalResult", value = "审批结果1:通过 2:不通过", dataType = "integer", required = true)
    })
    public ApiReturnInfo testCarApprovalResult(HttpServletRequest request, Integer approvalId, String approvalResult, @ApiIgnore ApiReturnInfo apiReturnInfo) {
        Employee member = getMember(request);
        TestDriveApply testDriveApply = testDriveApplyService.selectByPrimaryKey(approvalId);
        testDriveApply.setApplyTime(DateUtil.now());
        testDriveApply.setApprovecusId(member.getId());
        testDriveApply.setApprovalStatus(Byte.parseByte(approvalResult));
        testDriveApplyService.updatetestCarApproval(testDriveApply);
        return apiReturnInfo;
    }

    @RequestMapping(value = "/caroutList", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("车辆外出申请列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "integer", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页面显示数量", dataType = "integer", required = true),
            @ApiImplicitParam(name = "createTime", value = "申请时间", dataType = "string")
    })
    public ApiReturnInfo caroutList(HttpServletRequest request, @ApiIgnore ApiReturnInfo apiReturnInfo, Integer pageNum, Integer pageSize, String createTime) {
        Employee member = getMember(request);
        Map<String, Object> param = new HashMap<>();
        if (createTime != null && !createTime.equals("")) {
            param.put("createTime", createTime);
        }
        param.put("distributorStoreId", member.getStoreId());
        PageInfo<CarOutApplication> carOutApplicationPageInfo = carOutApplicationService.selectListByParam(param, pageSize, pageNum);
        //判断用户职位，添加flg标识符便于前端判断是否展示操作按钮
        List<CarOutApplication> list = carOutApplicationPageInfo.getList();
        if ((this.SALES_MANAGER_POSITION).equals(member.getPostName())) {
            for (int i = 0; i < list.size(); i++) {
                CarOutApplication carOutApplication = list.get(i);
                if (carOutApplication.getApprovalStatus() == 3) {
                    carOutApplication.setFlg(1);
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                CarOutApplication carOutApplication = list.get(i);
                if (carOutApplication.getApprovalStatus() == 4) {
                    carOutApplication.setFlg(1);
                }
            }
        }
        apiReturnInfo.setData(carOutApplicationPageInfo);
        return apiReturnInfo;
    }
}
