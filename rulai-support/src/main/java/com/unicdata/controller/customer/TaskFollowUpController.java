package com.unicdata.controller.customer;


import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.CustomerEnum;
import com.unicdata.constant.DictionaryType;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.TaskFollowUp;
import com.unicdata.entity.order.Order;
import com.unicdata.service.basedata.PcDictionaryService;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.customer.TaskFollowUpService;
import com.unicdata.service.dictionary.DictionaryService;
import com.unicdata.service.order.SaleOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/rulai/follow")
@Api(value = "客户跟进信息", tags = {"客户跟进信息相关接口"})
public class TaskFollowUpController extends HomeBaseController {

    @Autowired
    private TaskFollowUpService taskFollowUpService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SaleOrderService orderService;

    @Autowired
    private PcDictionaryService pcDictionaryService;

    @ApiOperation(value = "客户跟进信息保存修改", notes = "客户跟进信息保存修改")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "taskFollowUp", value = "客户跟进信息", required = true, dataType = "TaskFollowUp")
    @ResponseBody
    public ApiReturnInfo save(@RequestBody TaskFollowUp taskFollowUp, HttpServletRequest request) {
        ApiReturnInfo result = new ApiReturnInfo();
        if (taskFollowUp.getCustomerId() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("客户ID不能为空");
            return result;
        }
        if (taskFollowUp.getThisDate() == null || taskFollowUp.getChennel() == null || taskFollowUp.getContent() == null || StringUtils.isBlank(taskFollowUp.getRemark())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("本次跟进信息必填项不能为空");
            return result;
        }
        if (taskFollowUp.getNextDate() == null || taskFollowUp.getNextChennel() == null || taskFollowUp.getNextContent() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("下次跟进信息必填项不能为空");
            return result;
        }
        //如果是后续服务
        if (Objects.equals(CustomerEnum.TaskFollowContent.SERVICE.getCode(), taskFollowUp.getNextContent()) && taskFollowUp.getNextServiceItem() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("请选择后续服务项");
            return result;
        }
        Customer customer = customerService.getCustomerById(taskFollowUp.getCustomerId());
        if (customer == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("客户不存在，无法添加跟进信息");
            return result;
        }
        List<Order> orders = orderService.selectByCusId(customer.getId());
        //如果是订单跟进(包括 订单/跟进/后续服务)
        if (Objects.equals(CustomerEnum.TaskFollowContent.DELIVERY_CAR.getCode(), taskFollowUp.getNextContent())
                || Objects.equals(CustomerEnum.TaskFollowContent.ORDER_FOLLOW.getCode(), taskFollowUp.getNextContent())
                || Objects.equals(CustomerEnum.TaskFollowContent.SERVICE.getCode(), taskFollowUp.getNextContent())) {
            if (orders.isEmpty()) {
                result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                result.setMessage("该客户不存在订单，无法进行订单跟进");
                return result;
            } else {
                taskFollowUp.setOrderId(orders.get(0).getId());
                taskFollowUp.setOrderStatus(orders.get(0).getStatus());
            }
        }

        //如果是新增，添加创建人
        if (taskFollowUp.getId() == null) {
            taskFollowUp.setCreateId(getMember(request) == null ? null : getMember(request).getId());
            taskFollowUp.setCreateTime(new Date());
        }
        taskFollowUpService.save(taskFollowUp);
        return result;
    }

    @ApiOperation(value = "客户跟进内容下拉框选项", notes = "客户跟进内容下拉框选项")
    @RequestMapping(value = "/options", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "customerId", value = "客户ID", required = true, dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> options(Integer customerId) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo();
        Map<String, Object> data = Maps.newHashMap();
        List<Map<String, Object>> content = Lists.newArrayList();
        List<Order> orders = Lists.newArrayList();
        if (customerId != null) {
            orders = orderService.getOrdersByCusAndDate(customerId, null);
        }
        if (orders != null && !orders.isEmpty()) {
            content.add(new HashMap<String, Object>() {{
                put("key", CustomerEnum.TaskFollowContent.ORDER_FOLLOW.getCode());
                put("value", CustomerEnum.TaskFollowContent.ORDER_FOLLOW.getDesc());
                ;
            }});
            content.add(new HashMap<String, Object>() {{
                put("key", CustomerEnum.TaskFollowContent.DELIVERY_CAR.getCode());
                put("value", CustomerEnum.TaskFollowContent.DELIVERY_CAR.getDesc());
                ;
            }});
            content.add(new HashMap<String, Object>() {{
                put("key", CustomerEnum.TaskFollowContent.SERVICE.getCode());
                put("value", CustomerEnum.TaskFollowContent.SERVICE.getDesc());
                ;
            }});
        } else {
            content.add(new HashMap<String, Object>() {{
                put("key", CustomerEnum.TaskFollowContent.CUS_FOLLOW.getCode());
                put("value", CustomerEnum.TaskFollowContent.CUS_FOLLOW.getDesc());
                ;
            }});
            content.add(new HashMap<String, Object>() {{
                put("key", CustomerEnum.TaskFollowContent.CUS_INVITE.getCode());
                put("value", CustomerEnum.TaskFollowContent.CUS_INVITE.getDesc());
                ;
            }});
        }
        //跟进内容
        data.put("content", content);
        //跟进方式
        data.put("way", pcDictionaryService.getSelectOptions(DictionaryType.CUSTOMER_FOLLOW_UP_WAY.toString()).get(DictionaryType.CUSTOMER_FOLLOW_UP_WAY));
        result.setData(data);
        return result;
    }
}
