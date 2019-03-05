package com.unicdata.controller.customer;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.ConstantEnum.nextTaskContent;
import com.unicdata.constant.DictionaryType;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.BoutiqueInstall;
import com.unicdata.entity.boutique.BoutiqueInstallExample;
import com.unicdata.entity.customer.TaskFollowUp;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderServiceItem;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.BoutiqueInstallService;
import com.unicdata.service.customer.TaskFollowUpService;
import com.unicdata.service.dictionary.DictionaryService;
import com.unicdata.service.order.OrderOtherService;
import com.unicdata.service.order.OrderService;
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
import java.util.*;

/**
 * Created by lenovo on 2018/6/1.
 */
@Controller
@RequestMapping("/app/taskFollowUp")
@Api(value = "跟进任务相关接口", tags = {"跟进任务相关接口"})
public class TaskFollowUpController extends HomeBaseController {

    @Autowired
    TaskFollowUpService taskFollowUpService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private OrderOtherService orderOtherService;
    @Autowired
    private BoutiqueInstallService boutiqueInstallService;
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "根据类型查询跟进任务列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数，默认30", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "taskType", value = "任务类型 1:潜客跟进 2:潜客邀约 3:订单跟进 4:今日交车 5:后续服务", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "nextDate", value = "查询日期", required = true, dataType = "String"),
            @ApiImplicitParam(name = "dateRange", value = "服务时间范围1:当天 30:30天内", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "serviceId", value = "服务项id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/queryTask", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo queryTask(HttpServletRequest request, Integer pageNum,
                                   Integer pageSize, Integer taskType, String nextDate, Integer serviceId, Integer dateRange) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //查询时间
        String currentDate = DateUtil.dateFormat(new Date(), "yyyy-MM-dd");
        if (StringUtil.isNotBlank(nextDate)) {
            int year = DateUtil.getYear();
            String tempDate = year + "-" + nextDate;
            int res = DateUtil.daysBetween(currentDate, tempDate);
            if (res < 0) {
                year++;
            }
            nextDate = year + "-" + nextDate;
        } else {
            if (taskType == nextTaskContent.后续服务.getCode()) {
                if (dateRange == 30) {
                    nextDate = DateUtil.dateFormat(DateUtil.addDays(new Date(), 30), "yyyy-MM-dd");
                }
            } else {
                nextDate = currentDate;
            }
        }
        //订单列表
        map.put("employeeId", emp.getId());
        map.put("nextContent", taskType);
        map.put("nextDate", nextDate);
        map.put("nextServiceItem", serviceId);
        map.put("dateRange", dateRange);
        PageInfo pageInfo = taskFollowUpService.selectTaskList(pageNum, pageSize, map);
        resultMap.put("list", pageInfo.getList());
        resultMap.put("pageResult", getPageResult(pageInfo));
        ari.setData(resultMap);
        return ari;
    }

    @ApiOperation(value = "获取30天内任务时间")
    @RequestMapping(value = "/getTaskDates", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo getTaskDates(HttpServletRequest request,
                                      Integer pageNum, Integer pageSize, Integer taskType, String nextDate) {
        ApiReturnInfo ari = new ApiReturnInfo();
        //当前日期往后加30天
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> dateMap = null;
        for (int i = 0; i < 29; i++) {
            dateMap = new HashMap<String, Object>();
            dateMap.put("date", DateUtil.dateFormat(DateUtil.addDays(new Date(), i), "MM-dd"));
            list.add(dateMap);
        }
        ari.setData(list);
        return ari;
    }

    @ApiOperation(value = "潜客详情-查询潜客跟进记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "customerId", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "dateStr", value = "查询日期", required = true, dataType = "String")
    })
    @RequestMapping(value = "/getTaskList", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo list(String dateStr, Integer customerId) {
        ApiReturnInfo ar = new ApiReturnInfo();
        //未来任务时间列表
        List<Map<String, Object>> list = taskFollowUpService.selectTaskDateList(customerId);
        if (null != list && list.size() > 0 && StringUtil.isBlank(dateStr)) {
            dateStr = String.valueOf(list.get(0).get("date"));
        }
        //查询时间
        String currentDate = DateUtil.dateFormat(new Date(), "yyyy-MM-dd");
        if (StringUtil.isNotBlank(dateStr)) {
            int year = DateUtil.getYear();
            String tempDate = year + "-" + dateStr;
            int res = DateUtil.daysBetween(currentDate, tempDate);
            if (res > 0) {
                year--;
            }
            dateStr = year + "-" + dateStr;
        } else {
            dateStr = currentDate;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("customerId", customerId);
        params.put("thisDate", dateStr);
//        params.put("status", 2);
        //客户跟进任务
        TaskFollowUp task = taskFollowUpService.selectTaskByMap(params);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("dateList", list);
        resultMap.put("task", taskToMap(task));
        ar.setData(resultMap);
        return ar;
    }

    public Map<String, Object> taskToMap(TaskFollowUp task) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (task != null) {
            map.put("id", task.getId());
            map.put("orderId", task.getOrderId());
            map.put("customerId", task.getCustomerId());
            map.put("remark", task.getRemark());
            map.put("nextRemark", task.getNextRemark());
            map.put("thisDate", DateUtil.dateFormat(task.getThisDate(), DateUtil.sdf2));
            map.put("nextDate", DateUtil.dateFormat(task.getNextDate(), DateUtil.sdf2));
            //基础数据
            Map<Integer, List<Map<String, Object>>> dictionaryMap = dictionaryService.getSelectOptions("");
            map.put("channelStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_FOLLOW_UP_WAY, task.getChennel().toString()));
            map.put("contentStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_FOLLOW_UP_CONTENT, task.getContent().toString()));
            map.put("nextChennelStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_FOLLOW_UP_WAY, task.getNextChennel().toString()));
            map.put("nextContentStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_FOLLOW_UP_CONTENT, task.getNextContent().toString()));
            map.put("nextServiceItemStr", getDictionaryName(dictionaryMap, DictionaryType.ORDER_SERVICE_TYPE, task.getNextServiceItem() != null ? task.getNextServiceItem().toString() : ""));
        }
        return map;
    }

    @ApiOperation(value = "任务跟进接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderStatus", value = "订单状态", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "customerId", value = "客户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "taskType", value = "任务类型", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "chennel", value = "本次跟进方式", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "content", value = "本次跟进内容", required = true, dataType = "Integer"),
//            @ApiImplicitParam(name = "arriveTime", value = "到店时间", required = true, dataType = "date"),
//            @ApiImplicitParam(name = "handOverTime", value = "交车时间", required = true, dataType = "date"),
            @ApiImplicitParam(name = "remark", value = "本次客户反馈", required = true, dataType = "String"),
            @ApiImplicitParam(name = "thisDate", value = "本次跟进时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "nextDate", value = "下次跟进时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "nextChennel", value = "下次跟进方式", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "nextContent", value = "下次跟进内容", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "serviceItem", value = "后续服务项", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "nextRemark", value = "计划备注", required = true, dataType = "String")
    })
    @RequestMapping(value = "/taskSubmit", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo taskFollowUp(HttpServletRequest request, TaskFollowUp taskFollowUp) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        //添加任务跟进记录
        taskFollowUp.setCreateId(emp.getId());
        Integer orderId = taskFollowUp.getOrderId();
        Integer customerId = taskFollowUp.getCustomerId();
        //修改精品排程订单状态
        if (taskFollowUp.getNextContent() == 5 && taskFollowUp.getNextServiceItem() != null && orderId != null && orderId != 0) {
            BoutiqueInstallExample example = new BoutiqueInstallExample();
            BoutiqueInstallExample.Criteria criteria = example.createCriteria();
            criteria.andOrderIdEqualTo(orderId);
            criteria.andTypeLiveEqualTo(Byte.valueOf("1"));
            for (BoutiqueInstall boutiqueInstall : boutiqueInstallService.selectByExample(example)) {
                //判断是轿车后的状态
                if (boutiqueInstall.getConstructionNode() == 2) {
                    boutiqueInstall.setConstructionType(1);
                    //后续跟进时间设置为接车后的排程安装时间
                    boutiqueInstall.setFollowUp(taskFollowUp.getNextDate());
                    boutiqueInstallService.updateByPrimaryKeySelective(boutiqueInstall);
                }
            }
        }
        //预计交车时间
        if (taskFollowUp.getNextContent() == 4 && taskFollowUp.getNextDate() != null && orderId != null && orderId != 0) {
            Order order = orderService.selectOrderbyId(orderId);
            order.setDeliveryDate(taskFollowUp.getNextDate());
            orderService.updateByPrimaryKeySelective(order);
        }

        if (((orderId != null && orderId != 0) || (customerId != null && customerId != 0))) {
            taskFollowUpService.addTaskFollowUpRecord(taskFollowUp);
        } else {
            ari.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ari.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
        }
        ari.setData(null);
        return ari;
    }

    @ApiOperation(value = "上牌代办完善提交")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderServiceItemId", value = "服务明细项id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "licensePlate", value = "车牌号码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "licensePlateProvince", value = "车牌省份", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "licensePlateCity", value = "车牌城市", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/agencyLicensePlate", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo agencyLicensePlate(HttpServletRequest request, OrderServiceItem record,
                                            Integer orderId, Integer orderServiceItemId) {
        ApiReturnInfo ari = new ApiReturnInfo();
        if (orderServiceItemId != null && orderServiceItemId != 0) {
            record.setId(orderServiceItemId);
            orderOtherService.updateOrderOtherServiceItem(record);
        }
        ari.setData(null);
        return ari;
    }

    public static void main(String[] args) {
        String nextDate = "06-14";
        int year = DateUtil.getYear();
        String tempDate = year + "-" + nextDate;
        String currentDate = DateUtil.dateFormat(new Date(), "yyyy-MM-dd");
        int res = DateUtil.daysBetween(currentDate, tempDate);
        if (res < 0) {
            year++;
        }
        nextDate = year + "-" + nextDate;
        System.out.println(nextDate);
    }
}
