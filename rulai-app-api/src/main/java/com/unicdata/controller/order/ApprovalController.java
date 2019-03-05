package com.unicdata.controller.order;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.Constant;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.CarEnum;
import com.unicdata.constant.MessageCode;
import com.unicdata.constant.OrderEnum;
import com.unicdata.constant.PushEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.approval.ApprovalCus;
import com.unicdata.entity.approval.ApprovalOrder;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoExample;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.PassengerFlow;
import com.unicdata.entity.customer.TestDriveApply;
import com.unicdata.entity.customer.TestDriveApplyCar;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.entity.system.EmployeeAuthorize;
import com.unicdata.entity.system.EmployeeAuthorizeExample;
import com.unicdata.entity.system.EmployeeTarget;
import com.unicdata.service.approval.ApprovalCusService;
import com.unicdata.service.approval.ApprovalOrderService;
import com.unicdata.service.boutique.BoutiqueRetailService;
import com.unicdata.service.car.AppCarGoodInfoService;
import com.unicdata.service.car.AppCarTestInfoService;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.customer.TestDriveApplyCarService;
import com.unicdata.service.customer.TestDriveApplyService;
import com.unicdata.service.employee.AppEmployeeService;
import com.unicdata.service.employee.EmployeeTargetService;
import com.unicdata.service.passengerflow.PassengerFlowService;
import com.unicdata.service.push.PushMessageService;
import com.unicdata.service.system.EmployeeAuthorizeService;
import com.unicdata.service.system.ShowroomManagerRoleService;
import com.unicdata.util.JPushUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2018/6/1.
 */
@Controller
@RequestMapping("/app/approval")
@Api(value = "人员审批和订单审批接口", tags = {"人员审批和订单审批接口"})
public class ApprovalController extends HomeBaseController {
    @Autowired
    private ApprovalCusService approvalCusService;
    @Autowired
    private ApprovalOrderService approvalOrderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private com.unicdata.service.order.OrderService orderService;
    @Autowired
    private AppEmployeeService appEmployeeService;
    @Autowired
    private PassengerFlowService passengerFlowService;
    @Autowired
    private EmployeeAuthorizeService employeeAuthorizeService;
    @Autowired
    private ShowroomManagerRoleService showroomManagerRoleService;
    @Autowired
    private EmployeeTargetService employeeTargetService;
    @Autowired
    private TestDriveApplyService testDriveApplyService;
    @Autowired
    private TestDriveApplyCarService testDriveApplyCarService;
    @Autowired
    private AppCarTestInfoService appCarTestInfoService;
    @Autowired
    private AppCarGoodInfoService appCarGoodInfoService;
    @Autowired
    private PushMessageService pushMessageService;
    @Autowired
    private BoutiqueRetailService boutiqueRetailService;

    /**
     * @param codeNum  门店编号
     * @param type     0人员审批、1订单审批
     * @param pageNum  第几页
     * @param pageSize 每页大小
     * @return
     */
    @ApiOperation(value = "分页——人员审批和订单审批接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "0人员审批1订单审批", defaultValue = "0", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo list(HttpServletRequest request, Integer type, Integer pageNum, Integer pageSize) {
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee emp = getMember(request);
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("storeId", emp.getStoreId());
        //审批状态：0待审批
        map1.put("approvalStatus", 0);
        map1.put("applyTime", new Date());
        //如果是销售顾问只查看自己的
        if (emp.getPostName().equals(this.SALES_CONSULTANT_POSITION)) {
            map1.put("employeeId", emp.getId());
        }
        if (type == OrderEnum.ApprovalType.APPROVAL_CUS.getCode()) {//潜客审批
            PageInfo maps = approvalCusService.selectByCodeNum(map1, pageNum, pageSize);
            if (maps != null) {
                map.put("list", maps.getList());
                map.put("pageResult", getPageResult(maps));
            }
        } else {
            //判断如果是展厅经理，是否有价格审批权限或者退订审批权限
            //判断是否是展厅经理
            String postName = emp.getPostName();
            if (this.SHOWROOM_MANAGER_POSITION.equals(postName)) {
                //查询展厅经理的临时权限
                EmployeeAuthorizeExample employeeAuthorizeExample = new EmployeeAuthorizeExample();
                EmployeeAuthorizeExample.Criteria criteria = employeeAuthorizeExample.createCriteria();
                criteria.andEmployeeIdEqualTo(emp.getId());
                criteria.andTypeEqualTo(Byte.valueOf(OrderEnum.EmployeeAuthorizeType.ONE.getCode() + ""));
                criteria.andStatusEqualTo(Byte.valueOf("1"));
                criteria.andDataStatusEqualTo(Byte.valueOf("1"));
                List<EmployeeAuthorize> employeeAuthorizes = employeeAuthorizeService.selectByExample(employeeAuthorizeExample);
                List<String> integers = new ArrayList<String>();
                for (EmployeeAuthorize employeeAuthorize : employeeAuthorizes) {
                    integers.add(employeeAuthorize.getAuthorizeFunction());
                }
                //加入 过滤条件
                if (integers != null && integers.size() > 0) {
                    map1.put("approvalType", integers);
                }
            }
            PageInfo maps = approvalOrderService.selectByCodeNum(map1, pageNum, pageSize);
            map.put("list", maps.getList());
            map.put("pageResult", getPageResult(maps));
        }
        ar.setData(map);
        return ar;
    }

    /**
     * @param id   当是客户审批时，是客户id,订单审批时，是订单id
     * @param type 0客户审批，1订单审批
     * @return
     */
    @ApiOperation(value = "详情--人员审批和订单审批接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "type", value = "type", defaultValue = "0", required = false, dataType = "Integer")
    })
    @RequestMapping(value = "/details", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo details(HttpServletRequest request, Integer id, Integer type) {
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee emp = getMember(request);
        Map<String, Object> map = new HashMap<String, Object>();
        if (type == OrderEnum.ApprovalType.APPROVAL_CUS.getCode()) {
            map = approvalCusService.selectApprovalDetailsById(emp, id);
        } else {
            map = approvalOrderService.approvvalOrderDetails(id);
        }
        if (map == null) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_NULL.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_NULL.getMessage());
        }
        ar.setData(map);
        return ar;
    }


    /**
     * @param id   当是客户审批时，是客户id,订单审批时，是订单id
     * @param type 0客户审批，1订单审批
     * @return
     */
    @ApiOperation(value = "审批不通过--人员审批和订单审批驳回接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（当是客户审批时，是客户id,订单审批时，是订单id）", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "approvalId", value = "审批表Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "type", value = "审批类型（0客户审批，1订单审批）", defaultValue = "0", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "content", value = "驳回内容", defaultValue = "0", required = true, dataType = "String")
    })
    @RequestMapping(value = "/reject", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo reject(HttpServletRequest request, Integer id, Integer type, Integer approvalId, String content) {
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee emp = getMember(request);
        Map<String, Object> map = new HashMap<String, Object>();
        if (type == OrderEnum.ApprovalType.APPROVAL_CUS.getCode()) {
            ApprovalCus approvalCus = approvalCusService.selectByPrimaryKey(approvalId);
            //审批状态设置为审批不通过
            approvalCus.setApprovalStatus(2);
            approvalCus.setApproveId(emp.getId());
            approvalCus.setApprovalTime(new Date());
            approvalCus.setApplyReason(content);
            //更新人员审批表
            int i = approvalCusService.updateByPrimaryKeySelective(approvalCus);
            Integer approvalType = approvalCus.getApprovalType();
            Customer customer = customerService.selectByPrimaryKey(id);
            //审批状态设置为审批不通过
            customer.setUserStatus(OrderEnum.approvalStatus.EARNEST_WAIT.getCode());
            customer.setModifyTime(new Date());
            int i1 = customerService.updateByPrimaryKeySelective(customer);
            if (i <= 0 || i1 <= 0) {
                ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
            } else {
                //推送消息创建
                List<Map<String, Object>> mapList = new ArrayList<>();
                //推送销售顾问自己的url设置
                Map<String, Object> map2 = new HashMap<>();
                Integer code = 0;
                String desc = "";
                String content2 = "";
                //休眠审批
                if (approvalType == 1) {
                    map2.put("urlId", PushEnum.UrlWeb.ORDER_SALE_APPLYCUS_REJECT.getCode());
                    code = PushEnum.PushType.ORDER_CUSXM_FIRST.getCode();
                    desc = PushEnum.PushType.ORDER_CUSXM_FIRST.getDesc();
                    content2 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_APPROVAL_XMCUSREJECT);
                } else {
                    map2.put("urlId", PushEnum.UrlWeb.ORDER_SALE_APPLYCUS_NOREJECT.getCode());
                    code = PushEnum.PushType.ORDER_CUSZB_FIRST.getCode();
                    desc = PushEnum.PushType.ORDER_CUSZB_FIRST.getDesc();
                    content2 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_APPROVAL_ZBCUSREJECT);
                }
                map2.put("employeeId", approvalCus.getEmployeeId());
                map2.put("terminal", 2);
                mapList.add(map2);
                content2 = content2.replace("XXX", customer.getName());
                pushMessageService.createPushMessage(code, desc, content2, emp.getId(), mapList);

            }
            ar.setData(map);
        } else {
            ApprovalOrder approvalOrder = approvalOrderService.selectByPrimaryKey(approvalId);
            //审批状态设置为审批不通过
            approvalOrder.setApprovalStatus(OrderEnum.approvalStatus.EARNEST_WAIT.getCode());
            approvalOrder.setSaleApprovalTime(new Date());
            approvalOrder.setSaleApprovalResult(OrderEnum.approvalStatus.EARNEST_WAIT.getCode());
            //修改为审批时间
            approvalOrder.setUnsubscribeReason(content);
            int i = approvalOrderService.updateByPrimaryKeySelective(approvalOrder);
            Order order = orderService.selectOrderbyId(id);
            //订单整车审批类型
            Integer approvalType = approvalOrder.getApprovalType();
            if (approvalType == 1) {
                //车辆价格审批状态 0：未提交 1：审批中 2:已通过 3：已驳回
                order.setCarPriceStatus(3);
                //精品价格审批状态 0:默认未提交 1：审批中 2：不通过 3：通过
//                order.setBoutiquePriceStatus(2);
                //退订审批类型
            } else if (approvalType == 2) {
                //订单状态 1:未生效 2:待付款 3:已付订金 4:已付全款  5:待交车 6 :已交车 7:退单审批 8:退单中 9:已退单
                order.setStatus(10);
            } else {

            }
            int i1 = orderService.updateByPrimaryKeySelective(order);
            if (i <= 0 || i1 <= 0) {
                ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
            } else {
                //推送消息创建
                List<Map<String, Object>> mapList = new ArrayList<>();
                //推送销售顾问自己的url设置
                Map<String, Object> map2 = new HashMap<>();
                Integer code = 0;
                String desc = "";
                String content2 = "";
                //订单整车审批类型
                if (approvalType == 1) {
                    map2.put("urlId", PushEnum.UrlWeb.ORDER_SALE_OFFICER_REJECT.getCode());
                    code = PushEnum.PushType.ORDER_AUDITED_FIRST.getCode();
                    desc = PushEnum.PushType.ORDER_AUDITED_FIRST.getDesc();
                    content2 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_APPROVALORDREJECT);
                } else {
                    //退订审批类型
                    map2.put("urlId", PushEnum.UrlWeb.ORDER_SALE_REFUND_FINANCE_REJECT.getCode());
                    code = PushEnum.PushType.ORDER_REFUND_FIRST.getCode();
                    desc = PushEnum.PushType.ORDER_REFUND_FIRST.getDesc();
                    content2 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_APPROVAL_TDORDREJECT);
                }
                map2.put("employeeId", approvalOrder.getEmployeeId());
                map2.put("terminal", 2);
                mapList.add(map2);
                content2 = content2.replace("XXX", order != null ? order.getCusName().toString() : "");
                content2 = content2.replace("YYY", order != null ? order.getOrderNum().toString() : "");
                pushMessageService.createPushMessage(code, desc, content2, emp.getId(), mapList);
            }
            ar.setData(map);
        }
        return ar;
    }


    @ApiOperation(value = "审批通过----人员审批")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalId", value = "审批表Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "customerId", value = "客户表ID", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/approvalCusPass", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo approvalPass(HttpServletRequest request, Integer approvalId, Integer customerId) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        ApprovalCus approvalCus = new ApprovalCus();
        approvalCus.setId(approvalId);
        //修改审批状态
        approvalCus.setApprovalStatus(OrderEnum.approvalStatus.APPROVAL_REFUSE.getCode());
        approvalCus.setApproveId(emp.getId());
        approvalCus.setApprovalTime(new Date());
        //更新审批表
        int i = approvalCusService.updateByPrimaryKeySelective(approvalCus);

        //获得审批类型
        ApprovalCus approvalCus1 = approvalCusService.selectByPrimaryKey(approvalId);
        int approvalType = 0;
        if (approvalCus1 != null) {
            approvalType = approvalCus1.getApprovalType();
        }
        //更新客户表，修改客户状态
        Customer customer = customerService.selectByPrimaryKey(customerId);
        //休眠审批
        if (approvalType == OrderEnum.ApprovalyCusType.ONE.getCode()) {
            customer.setCategory(4);
        }
        //战败审批
        if (approvalType == OrderEnum.ApprovalyCusType.TWO.getCode()) {
            customer.setCategory(5);
        }
        int i1 = customerService.updateByPrimaryKeySelective(customer);
        if (i <= 0 || i1 <= 0) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        } else {
            //推送消息创建
            Map<String, Object> mapc = new HashMap<>();
            mapc.put("storeId", emp.getStoreId());
            List<Map<String, Object>> mapList = new ArrayList<>();
            //推送销售顾问自己的url设置
            Map<String, Object> map = new HashMap<>();
            //休眠审批
            Integer code = 0;
            String desc = "";
            String content = "";
            if (approvalType == OrderEnum.ApprovalyCusType.ONE.getCode()) {
                map.put("urlId", PushEnum.UrlWeb.ORDER_SALE_APPLYCUS_PASS.getCode());
                code = PushEnum.PushType.ORDER_CUSXM_PASS.getCode();
                desc = PushEnum.PushType.ORDER_CUSXM_PASS.getDesc();
                content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_APPROVAL_XMCUSPASS);
            } else {
                map.put("urlId", PushEnum.UrlWeb.ORDER_SALE_APPLYCUS_YESPASS.getCode());
                code = PushEnum.PushType.ORDER_CUSZB_PASS.getCode();
                desc = PushEnum.PushType.ORDER_CUSZB_PASS.getDesc();
                content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_APPROVAL_ZBCUSPASS);
            }
            map.put("employeeId", approvalCus1.getEmployeeId());
            map.put("terminal", 2);
            mapList.add(map);
            content = content.replace("XXX", customer.getName());
            pushMessageService.createPushMessage(code, desc, content, emp.getId(), mapList);
        }
        return ar;
    }

    @ApiOperation(value = "审批人员分配列表----休眠或战败审批分配")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "1获取销售顾问，2获取服务顾问", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/approvalCusDistribution", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo approvalCusDistribution(HttpServletRequest requst, Integer type) {
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        Employee emp = getMember(requst);
        Map<String, Object> mapc = new HashMap<String, Object>();
        mapc.put("storeId", emp.getStoreId());
        if (type == 1) {
            //销售顾问
            mapc.put("postName", SALES_CONSULTANT_POSITION);
        } else {
            //销售顾问服务顾问
            mapc.put("postName", SALES_SERVICE);
        }
        List<Map<String, Object>> list = appEmployeeService.selectEmployeByPostName(mapc);
        map.put("list", list);
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "审批人员分配--确定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalId", value = "审批表Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "emplyoeeId", value = "销售顾问ID", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/cusDistributionPass", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo cusDistributionPass(HttpServletRequest request, Integer approvalId, Integer emplyoeeId) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        //删除审批记录
        ApprovalCus approvalCus1 = approvalCusService.selectByPrimaryKey(approvalId);
        approvalCus1.setDataStatus(0);
        int i = approvalCusService.updateByPrimaryKeySelective(approvalCus1);

        //更新客户表的销售顾问id
        Integer cusId = approvalCus1 != null ? approvalCus1.getCusId() : 0;
        Customer customer = customerService.selectByPrimaryKey(cusId);
        if (customer != null) {
            customer.setEmployeeId(emplyoeeId);
            customer.setModifyTime(new Date());
            //客户状态修改为潜客
            customer.setCategory(1);
            int i1 = customerService.updateByPrimaryKeySelective(customer);
            if (i <= 0 || i1 <= 0) {
                ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
            }
        }
        return ar;
    }


    @ApiOperation(value = "审批通过----订单审批接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalId", value = "审批表Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单ID", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/approvalOrderPass", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo approvalOrderPass(HttpServletRequest request, Integer approvalId, Integer orderId) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        try {
            ApprovalOrder approvalOrder = new ApprovalOrder();
            approvalOrder.setId(approvalId);
            approvalOrder.setIfSaleApproval(OrderEnum.approvalStatus.APPROVAL_REFUSE.getCode());
            approvalOrder.setSaleApproveId(emp.getId());
            approvalOrder.setSaleApprovalTime(new Date());
            approvalOrder.setSaleApprovalResult(OrderEnum.approvalStatus.APPROVAL_REFUSE.getCode());
            //更新审批表
            int i = approvalOrderService.updateByPrimaryKeySelective(approvalOrder);
            //判断订单是否有精品
            List<Map<String, Object>> boutiqueOrderId = boutiqueRetailService.getBoutiqueOrderId(orderId);
            if (boutiqueOrderId != null && boutiqueOrderId.size() > 0) {
                //判断订单审批表，4个状态是否已经都满足，如果满足更新order状态表
                boolean b = approvalOrderService.ifPass(approvalId);
                if (b) {
                    approvalOrder.setApprovalStatus(OrderEnum.approvalStatus.APPROVAL_REFUSE.getCode());
                    approvalOrderService.updateByPrimaryKeySelective(approvalOrder);
                }
            } else {
                approvalOrder.setApprovalStatus(OrderEnum.approvalStatus.APPROVAL_REFUSE.getCode());
                approvalOrderService.updateByPrimaryKeySelective(approvalOrder);
            }

            //更新订单审批状态
            Order order2 = new Order();
            order2.setId(orderId);
            ApprovalOrder approvalOrder1 = approvalOrderService.selectByPrimaryKey(approvalId);

            //订单车辆信息
            CarGoodInfoExample carGoodInfoExample = new CarGoodInfoExample();
            CarGoodInfoExample.Criteria criteria = carGoodInfoExample.createCriteria();
            criteria.andCarOrderIdEqualTo(orderId);
            List<CarGoodInfo> carGoodInfos = appCarGoodInfoService.selectByExample(carGoodInfoExample);
            int i2 = 0;
            Integer approvalType = 0;
            //获取审批类型
            if (approvalOrder1 != null) {
                approvalType = approvalOrder1.getApprovalType();
                if (approvalType == 1) {
                    //车辆价格审批状态 0：未提交 1：审批中 2:已通过 3：已驳回
                    order2.setCarPriceStatus(2);
                    //精品价格审批状态 0:默认未提交 1：审批中 2：不通过 3：通过
//                    order2.setBoutiquePriceStatus(3);
                } else if (approvalType == 2) {
                    //订单状态 1:未生效 2:待付款 3:已付订金 4:已付全款  5:待交车 6 :已交车 7:退单审批 8:退单中 9:已退单
                    order2.setStatus(8);
                    //整车状态 0：未配车 1：已配车',
                    order2.setCarStatus(0);
                    for (CarGoodInfo carGoodInfo : carGoodInfos) {
                        carGoodInfo.setCarSupplyStatus(1);
                        i2 = appCarGoodInfoService.updateByPrimaryKey(carGoodInfo);
                    }
                } else {

                }
            }
            //精品状态
            // order.setBoutiqueStatus(1);
            //更新整车审批状态
            int i4 = orderService.updateByPrimaryKeySelective(order2);
            if (i4 < 1 || i < 1) {
                ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
            } else {
                //推送消息创建
                Map<String, Object> mapc = new HashMap<>();
                mapc.put("storeId", emp.getStoreId());
                ArrayList<String> strings = new ArrayList<>();
                strings.add(FINANCIAL_MANAGER);
                strings.add(SALES_INFORMATION_OFFICER);
                //销售顾问
                mapc.put("postNameList", strings);
                //订单审批通过推送标识
                mapc.put("n", 1);
                List<Map<String, Object>> mapList = appEmployeeService.selectEmployeIdByPostName(mapc);
                //推送销售顾问自己的url设置
                Map<String, Object> map = new HashMap<>();
                Integer code = 0;
                String desc = "";
                String content = "";
                if (approvalType == 1) {
                    map.put("urlId", PushEnum.UrlWeb.ORDER_SALE_OFFICER_PASS.getCode());
                    code = PushEnum.PushType.ORDER_AUDITED.getCode();
                    desc = PushEnum.PushType.ORDER_AUDITED.getDesc();
                    content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_APPROVALORDERPASS);
                } else {
                    map.put("urlId", PushEnum.UrlWeb.ORDER_SALE_REFUND_FINANCE_PASS.getCode());
                    code = PushEnum.PushType.ORDER_REFUND.getCode();
                    desc = PushEnum.PushType.ORDER_REFUND.getDesc();
                    content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_APPROVAL_TDORDERPASS);
                }
                map.put("employeeId", approvalOrder1.getEmployeeId());
                map.put("terminal", 2);
                mapList.add(map);
                Order order = orderService.selectOrderbyId(orderId);
                content = content.replace("XXX", order != null ? order.getCusName().toString() : "");
                content = content.replace("YYY", order != null ? order.getOrderNum().toString() : "");
                pushMessageService.createPushMessage(code, desc, content, emp.getId(), mapList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;
    }

    @ApiOperation(value = "展厅经理-我的-试驾车申请分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer")
    })
    @RequestMapping(value = "/testDriveApplyList", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo testDriveApplyList(HttpServletRequest request, Integer pageNum, Integer pageSize) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("storeId", emp.getStoreId());
        map.put("employeeId", emp.getId());
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> mapList = testDriveApplyService.testDriveApplyList(map);
        for (Map<String, Object> objectMap : mapList) {
            Object use_time = objectMap.get("use_time");
            if (use_time != null) {
                objectMap.put("use_time", use_time.toString().substring(0, 10));
            }
            Object apply_time = objectMap.get("apply_time");
            if (apply_time != null) {
                objectMap.put("apply_time", apply_time.toString().substring(0, 10));
            }
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(mapList);
        map.put("list", pageInfo.getList());
        map.put("pageResult", getPageResult(pageInfo));
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "展厅经理-我的-试驾车申请-所有试驾车型分页")
    @RequestMapping(value = "/selectTestCarList", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectTestCarList(HttpServletRequest request) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("storeId", emp.getStoreId());
        //封装分页信息
        Page<Map<String, Object>> mapList = appCarTestInfoService.selectTestCarList(map);
        Page<Map<String, Object>> list = new Page<Map<String, Object>>();
        //拼接品牌车系和车型
        for (Map<String, Object> objectMap : mapList) {
            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("id", objectMap.get("id"));
            map3.put("name", objectMap.get("pingpai_name").toString() + objectMap.get("chexi_name").toString() + objectMap.get("chexing_name").toString());
            map3.put("license_num", objectMap.get("license_num"));
            list.add(map3);
        }
        map.put("list", list);
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "展厅经理-我的-试驾车申请")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "车型集合", required = true, dataType = "String"),
            @ApiImplicitParam(name = "purpose", value = "用途", required = true, dataType = "String"),
            @ApiImplicitParam(name = "useTime", value = "使用时间", required = true, dataType = "Date")
    })
    @RequestMapping(value = "/SRmanagerCarTest", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo SRmanagerCarTest(HttpServletRequest request, String ids, String purpose, String useTime) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        //生成申请单号
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 8; i++) {
            result += random.nextInt(10);
        }
        //试驾车申请表插入数据
        TestDriveApply testDriveApply = new TestDriveApply();
        testDriveApply.setApplyNum(Integer.valueOf(result));
        testDriveApply.setEmployeeId(emp.getId());
        testDriveApply.setApplyTime(new Date());
        testDriveApply.setPurpose(purpose);
        testDriveApply.setApprovalStatus(Byte.valueOf(CarEnum.testDriveApplyStatus.APPROVAL_WAIT.getCode() + ""));
        testDriveApply.setDataStatus(Byte.valueOf(CarEnum.DataStatus.NORMAL.getCode() + ""));
        testDriveApply.setCreateTime(new Date());
        try {
            if (useTime != null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                testDriveApply.setUseTime(format.parse(useTime));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        int i = testDriveApplyService.insertSelective(testDriveApply);

        //试驾申请与车辆关联表插入数据
        TestDriveApplyCar testDriveApplyCar = new TestDriveApplyCar();
        testDriveApplyCar.setApplyId(testDriveApply.getId());
        testDriveApplyCar.setStoreId(emp.getStoreId());
        testDriveApplyCar.setCreateDate(new Date());
        testDriveApplyCar.setStatus(CarEnum.DataStatus.NORMAL.getCode());

        if (ids != null) {
            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
            boolean matches = pattern.matcher(ids).matches();
            if (ids.indexOf("/") > 0 || matches) {
                String[] s = ids.split("/");
                if (s != null && s.length > 0) {
                    for (String id : s) {
                        if (pattern.matcher(id).matches()) {
                            testDriveApplyCar.setCarGoodId(Integer.valueOf(id));
                            testDriveApplyCarService.insertSelective(testDriveApplyCar);
                        }
                    }
                }
            }
        }
        if (i < 1) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        }
        return ar;
    }

    @ApiOperation(value = "销售经理-分配价格审批权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "被授权人id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "postName", value = "被授权人职位", required = true, dataType = "String"),
            @ApiImplicitParam(name = "roleList", value = "权限id，1价格审批，2退订审批(如果选择两个用/隔开)", required = true, dataType = "String")
    })
    @RequestMapping(value = "/SLmanagerPermissions", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo SLmanagerPermissions(HttpServletRequest request, Integer id, String postName, String roleList) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        try {
            //取消授权
            EmployeeAuthorizeExample employeeAuthorizeExample = new EmployeeAuthorizeExample();
            EmployeeAuthorizeExample.Criteria criteria = employeeAuthorizeExample.createCriteria();
            criteria.andEmployeeIdEqualTo(id);
            criteria.andAuthorizerIdEqualTo(emp.getId());
            criteria.andTypeEqualTo(Byte.valueOf(OrderEnum.EmployeeAuthorizeType.ONE.getCode() + ""));
            criteria.andStatusEqualTo(Byte.valueOf("1"));
            criteria.andDataStatusEqualTo(Byte.valueOf("1"));
            List<EmployeeAuthorize> employeeAuthorizes = employeeAuthorizeService.selectByExample(employeeAuthorizeExample);

            for (EmployeeAuthorize authorize : employeeAuthorizes) {
                //禁用
                authorize.setStatus(Byte.valueOf("0"));
                //取消时间
                authorize.setUpdateDate(new Date());
                int i = employeeAuthorizeService.updateByPrimaryKeySelective(authorize);
            }
            int i = 0;

            //授权操作
            EmployeeAuthorize employeeAuthorize = new EmployeeAuthorize();
            employeeAuthorize.setEmployeeId(id);
            employeeAuthorize.setEmployeePost(postName);
            employeeAuthorize.setAuthorizerId(emp.getId());
            employeeAuthorize.setAuthorizerPost(emp.getPostName());
            //默认销售经理-展厅经理 1
            employeeAuthorize.setType(Byte.valueOf(OrderEnum.EmployeeAuthorizeType.ONE.getCode() + ""));
            String[] split = roleList.split("/");
            if (split.length > 0 && roleList != "") {
                for (String s : split) {
                    //授权
                    employeeAuthorize.setStatus(Byte.valueOf("1"));
                    employeeAuthorize.setCreateDate(new Date());
                    employeeAuthorize.setUpdateDate(new Date());
                    employeeAuthorize.setDataStatus(Byte.valueOf("1"));
                    employeeAuthorize.setAuthorizeFunction(s);
                    employeeAuthorizeService.insertSelective(employeeAuthorize);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;
    }


    @ApiOperation(value = "销售经理-我的-权限设定页面初始化")
    @RequestMapping(value = "/SRManagerList", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo SRManagerList(HttpServletRequest request) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        //如果没有数据，获取展厅经理下拉
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("postName", SHOWROOM_MANAGER_POSITION);
        map.put("storeId", emp.getStoreId());
        List<Employee> employees = appEmployeeService.selectCustomersByRoleId(map);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //获取展厅经理已有权限
        try {
            for (Employee employee : employees) {
                //查询展厅经理的临时权限
                EmployeeAuthorizeExample employeeAuthorizeExample = new EmployeeAuthorizeExample();
                EmployeeAuthorizeExample.Criteria criteria = employeeAuthorizeExample.createCriteria();
                criteria.andEmployeeIdEqualTo(employee.getId());
                criteria.andAuthorizerIdEqualTo(emp.getId());
                criteria.andTypeEqualTo(Byte.valueOf(OrderEnum.EmployeeAuthorizeType.ONE.getCode() + ""));
                criteria.andStatusEqualTo(Byte.valueOf("1"));
                criteria.andDataStatusEqualTo(Byte.valueOf("1"));
                List<EmployeeAuthorize> employeeAuthorizes = employeeAuthorizeService.selectByExample(employeeAuthorizeExample);

                Map<String, Object> map2 = new HashMap<String, Object>();
                List<String> list2 = new ArrayList<String>();
                for (EmployeeAuthorize employeeAuthorize : employeeAuthorizes) {
                    list2.add(employeeAuthorize.getAuthorizeFunction());
                }
                map2.put("authorizeFunctions", list2);
                map2.put("id", employee.getId());
                map2.put("name", employee.getFullName());
                map2.put("postName", employee.getPostName());
                list.add(map2);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        ar.setData(list);
        return ar;
    }

    @ApiOperation(value = "销售经理/展厅经理切换销售顾问")
    @RequestMapping(value = "/roleSwitch", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo roleSwitch(HttpServletRequest request) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        try {
            Byte type = new Byte("0");
            if (emp.getPostName().equals(SHOWROOM_MANAGER_POSITION)) {
                //展厅经理
                type = Byte.valueOf(OrderEnum.EmployeeAuthorizeType.THREE.getCode() + "");
            } else {
                //销售经理
                type = Byte.valueOf(OrderEnum.EmployeeAuthorizeType.TWO.getCode() + "");
            }

            //角色转换  销售顾问 ——》销售经理/展厅经理
            EmployeeAuthorizeExample employeeAuthorizeExample = new EmployeeAuthorizeExample();
            EmployeeAuthorizeExample.Criteria criteria = employeeAuthorizeExample.createCriteria();
            criteria.andEmployeeIdEqualTo(emp.getId());
            criteria.andAuthorizerIdEqualTo(emp.getId());
            criteria.andTypeEqualTo(type);
            criteria.andStatusEqualTo(Byte.valueOf("1"));
            criteria.andDataStatusEqualTo(Byte.valueOf("1"));
            List<EmployeeAuthorize> employeeAuthorizes = employeeAuthorizeService.selectByExample(employeeAuthorizeExample);
            if (employeeAuthorizes != null && employeeAuthorizes.size() > 0) {
                //角色转换
                for (EmployeeAuthorize employeeAuthorize : employeeAuthorizes) {
                    employeeAuthorize.setStatus(Byte.valueOf("0"));
                    employeeAuthorize.setUpdateDate(new Date());
                    int i = employeeAuthorizeService.updateByPrimaryKeySelective(employeeAuthorize);
                }
            } else {
                //销售经理/展厅经理——》销售顾问
                EmployeeAuthorize employeeAuthorize = new EmployeeAuthorize();
                employeeAuthorize.setEmployeeId(emp.getId());
                employeeAuthorize.setEmployeePost(SALES_CONSULTANT_POSITION);
                employeeAuthorize.setAuthorizerId(emp.getId());
                employeeAuthorize.setAuthorizerPost(emp.getPostName());
                employeeAuthorize.setType(type);
                employeeAuthorize.setStatus(Byte.valueOf("1"));
                employeeAuthorize.setCreateDate(new Date());
                employeeAuthorize.setUpdateDate(new Date());
                employeeAuthorize.setDataStatus(Byte.valueOf("1"));
                int i1 = employeeAuthorizeService.insertSelective(employeeAuthorize);
                if (i1 < 1) {
                    ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                    ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;
    }

    @ApiOperation(value = "销售经理-我的-目标设定页面初始化")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "销售顾问角色Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "targetTime", value = "查询月份", required = true, dataType = "Date")
    })
    @RequestMapping(value = "/SRManagerTarget", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo SRManagerTarget(HttpServletRequest request, Integer roleId, Date targetTime) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("storeId", emp.getStoreId());
        map.put("roleId", roleId);
        map.put("targetTime", targetTime);
        List<EmployeeTarget> employeeTargets = employeeTargetService.selectEmployeeTargetByStoreId(map);
        ar.setData(employeeTargets);
        return ar;
    }


    @ApiOperation(value = "销售经理-我的-目标保存--待定。。。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "销售顾问角色Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "targetTime", value = "查询月份", required = true, dataType = "Date")
    })
    @RequestMapping(value = "/SRManagerTargetSave", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo SRManagerTargetSave(HttpServletRequest request, Integer roleId, Date targetTime) {
        //当前操作人
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        return ar;
    }
}