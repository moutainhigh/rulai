package com.unicdata.controller.customer;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.ConstantEnum.enumPassengerFlowStatus;
import com.unicdata.constant.CustomerEnum.CustomerCategory;
import com.unicdata.constant.OrderEnum.ApprovalOrderType;
import com.unicdata.constant.OrderEnum.ApprovalyCusType;
import com.unicdata.constant.DictionaryType;
import com.unicdata.constant.MessageCode;
import com.unicdata.constant.OrderEnum;
import com.unicdata.constant.PushEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.approval.ApprovalCus;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.PassengerFlow;
import com.unicdata.entity.customer.TransactCustomer;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.approval.ApprovalCusService;
import com.unicdata.service.car.AppCarFamilyService;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.dictionary.DictionaryService;
import com.unicdata.service.employee.AppEmployeeService;
import com.unicdata.service.passengerflow.PassengerFlowService;
import com.unicdata.service.push.PushMessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 潜客管理
 *
 * @author admin
 */
@Controller
@RequestMapping("/app/customer")
@Api(value = "潜客管理相关接口", tags = {"潜客相关接口"})
public class CustomerController extends HomeBaseController {

    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ApprovalCusService approvalCusService;
    @Autowired
    private PassengerFlowService passengerFlowService;
    @Autowired
    private AppCarFamilyService carFamilyService;
    @Autowired
    private AppEmployeeService appEmployeeService;
    @Autowired
    private PushMessageService pushMessageService;


    @ApiOperation(value = "下拉框基础数据获取接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "基础数据类型 1:客户类型 2:关系客户", required = true, dataType = "String")
    })
    @RequestMapping(value = "/dictionaryList", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo dictionaryList(String type) {
        ApiReturnInfo ari = new ApiReturnInfo();
        //基础数据
        Map<Integer, List<Map<String, Object>>> dictionaryMap = dictionaryService.getSelectOptions(type);
        //建档列表
        ari.setData(dictionaryMap);
        return ari;
    }

    @ApiOperation(value = "建档保存接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/createArchives", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo createArchives(HttpServletRequest request, Customer customer) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        customer.setEmployeeId(emp.getId());
        customer.setStoreId(emp.getStoreId());
        int res = customerService.updateCustomer(customer, null);
        if (res == 0) {
            ari.setCode(ResultCodeEnum.RESULT_CODE_SUBMIT_FAIL.getCode());
            ari.setMessage(ResultCodeEnum.RESULT_CODE_SUBMIT_FAIL.getMessage());
        } else if (res == -1) {
            ari.setCode(ResultCodeEnum.RESULT_CODE_PHONE_EXISTENT.getCode());
            ari.setMessage(ResultCodeEnum.RESULT_CODE_PHONE_EXISTENT.getMessage());
        }
        ari.setData(null);
        return ari;
    }

    @ApiOperation(value = "查看潜客明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "passengerId", value = "客流id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "customerId", value = "潜客id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "phone", value = "潜客手机号码,校验手机号码时必填", required = true, dataType = "String")
    })
    @RequestMapping(value = "/customerDetail", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo customerDetail(HttpServletRequest request, Integer passengerId, Integer customerId, String phone) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        //手机号码不为空时验证
    	if(StringUtil.isNotBlank(phone)){
    		Customer record = new Customer();
            record.setPhone(phone);
            Map<String, Object> customer = customerService.selectCustomerMap(record);
            if (null != customer) {
            	PassengerFlow pf = passengerFlowService.selectByPrimaryKey(passengerId);
                if(pf != null && pf.getReplaceEmployeeId()!=null){//替岗
                	record.setEmployeeId(pf.getReplaceEmployeeId());
            	}else{
                	record.setEmployeeId(emp.getId());
            	}
            	Customer tempCustomer = customerService.selectCustomer(record);
            	if(tempCustomer!=null){//存在自身原有客户
            		ari.setCode(ResultCodeEnum.RESULT_CODE_PHONE_EXISTENT.getCode());
            		ari.setMessage(ResultCodeEnum.RESULT_CODE_PHONE_EXISTENT.getMessage());
            	}else{
            		String fullName = String.valueOf(customer.get("fullName"));
            		String message = ResultCodeEnum.RESULT_CODE_PHONE_OTHER_EXISTENT.getMessage();
            		ari.setCode(ResultCodeEnum.RESULT_CODE_PHONE_OTHER_EXISTENT.getCode());
            		ari.setMessage(message.replace("XXX", fullName));
            	}
            	ari.setData(customerToMap(customer));
            }else {
                ari.setData(new HashMap<String, Object>());
            }
            
    	}else{
    		//根据客流或客户id查询
            Customer record = new Customer();
        	record.setPassengerId(passengerId);
        	record.setId(customerId);
        	Map<String, Object> customer = customerService.selectCustomerMap(record);
            if (null != customer) {
                ari.setData(customerToMap(customer));
            } else {
                ari.setData(new HashMap<String, Object>());
            }
    	}
        return ari;
    }

    public Map<String, Object> customerToMap(Map<String, Object> customer) {
        //基础数据
        Map<Integer, List<Map<String, Object>>> dictionaryMap = dictionaryService.getSelectOptions("");
        String category = String.valueOf(customer.get("category"));
        customer.put("categoryStr", CustomerCategory.getByCode(Integer.valueOf(category)).getDesc());
        customer.put("typeStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_TYPE, String.valueOf(customer.get("type"))));
        customer.put("channelStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_CHANNEL, String.valueOf(customer.get("channel"))));
        customer.put("levelStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_LEVEL, String.valueOf(customer.get("level"))));
        customer.put("contactTimeStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_CONTACT_TIME, String.valueOf(customer.get("contactTime"))));
        customer.put("relationCustomerStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_RELATION_CUSTOMER, String.valueOf(customer.get("relationCustomer"))));
        customer.put("originStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_ORIGIN, String.valueOf(customer.get("origin"))));
        customer.put("cusInfoSourcesStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_MESSAGE_ORIGIN, String.valueOf(customer.get("cusInfoSources"))));
        customer.put("usageStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_CAR_USAGE, String.valueOf(customer.get("usage"))));
        String attentionPoint = String.valueOf(customer.get("attentionPoint"));
        String attentionPointStr = "";
        if (StringUtil.isNotBlank(attentionPoint)) {
            String strArr[] = attentionPoint.split(",");
            for (String ap : strArr) {
                attentionPointStr += "," + getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_ATTENTION_POINT, ap);
            }
            attentionPointStr = attentionPointStr.substring(1);
        }
        customer.put("attentionPointStr", attentionPointStr);
        customer.put("buyTypeStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_BUY_TYPE, String.valueOf(customer.get("buyType"))));
        customer.put("userStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_CAR_USER, String.valueOf(customer.get("user"))));
        customer.put("budgetStr", getDictionaryName(dictionaryMap, DictionaryType.CUSTOMER_BUDGET, String.valueOf(customer.get("budget"))));
        if(customer.get("ownedCar")!=null)
        	customer.put("ownedCarStr", carFamilyService.getUnicdataFamilyById(Integer.valueOf(String.valueOf(customer.get("ownedCar")))));
        if(customer.get("attentionCarOne")!=null)
        	customer.put("attentionCarOneStr", carFamilyService.getUnicdataFamilyById(Integer.valueOf(String.valueOf(customer.get("attentionCarOne")))));
        if(customer.get("attentionCarTwo")!=null)
        	customer.put("attentionCarTwoStr", carFamilyService.getUnicdataFamilyById(Integer.valueOf(String.valueOf(customer.get("attentionCarTwo")))));
        if(customer.get("attentionCarThree")!=null)
        	customer.put("attentionCarThreeStr", carFamilyService.getUnicdataFamilyById(Integer.valueOf(String.valueOf(customer.get("attentionCarThree")))));
        return customer;
    }

    /**
     * 客户列表
     *
     * @param request
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/customersList", method = {RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "客户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer")
    })
    public ApiReturnInfo selectCustomersList(HttpServletRequest request,
                                             Integer pageSize, Integer pageNum, Customer customer) {
        //当前用户
        Employee emp = getMember(request);
        /*Map<String, Object> params = new HashMap<String, Object>();
        params.put("storeId", emp.getStoreId());
        params.put("employeeId", customer.getEmployeeId());
        params.put("name", customer.getName());
        params.put("phone", customer.getPhone());*/
        customer.setEmployeeId(emp.getId());
        customer.setStoreId(emp.getStoreId());
        //封装分页信息
        PageInfo pageInfo = customerService.selectCustomersList(pageNum, pageSize, customer);
        List<Customer> list = pageInfo.getList();
        //当前用户接待客流
        PassengerFlow passengerFlow = new PassengerFlow();
        passengerFlow.setEmployeeId(emp.getId());
        passengerFlow.setType(1);
        passengerFlow.setStatus(enumPassengerFlowStatus.未接待.getId());
        Map<String, Object> pfMap = passengerFlowService.selectByCondition(passengerFlow);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageResult", getPageResult(pageInfo));
        map.put("list", list);
        map.put("passengerFlow", pfMap);
        ApiReturnInfo ar = new ApiReturnInfo<>();
        ar.setData(map);
        return ar;
    }


    /**
     * @param request
     * @param pageSize
     * @param pageNum
     * @param type     1,潜客2，休眠，3，战败4，订单，5，交车
     * @return ---------------待修改，用户类型字段为：category
     */
    @RequestMapping(value = "/managerCusList", method = {RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "展厅经理、销售经理，客户菜单（1潜客，2订单，3交车，4休眠，5战败）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "category", value = "类型", required = true, dataType = "Integer")
    })
    public ApiReturnInfo managerCusList(HttpServletRequest request,
                                        Integer pageSize, Integer pageNum, Integer category, String serviceId, String dateRange, String nextDate) {
        //当前用户
        Employee emp = getMember(request);
        Customer customer = new Customer();
        customer.setStoreId(emp.getStoreId());
        customer.setCategory(category);
        //订单查询用
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("storeId", emp.getStoreId());
        params.put("category", category);
        //如果是销售顾问只查看自己的
        if (emp.getPostName().equals(SALES_CONSULTANT_POSITION)) {
            customer.setEmployeeId(emp.getId());
            params.put("employeeId", emp.getId());
        }
        PageInfo pageInfo = new PageInfo();
        //暂定潜客，休眠，战败
        if (category == 1 || category == 4 || category == 5) {
            pageInfo = customerService.selectCusByStatus(pageNum, pageSize, customer);
        }
        //暂定，订单交车
        if (category == 2 || category == 3) {
            params.put("serviceId", serviceId);
            params.put("dateRange", dateRange);
            if (nextDate == null || nextDate == "") {
                params.put("nextDate", new Date());
            } else {
                params.put("nextDate", nextDate);
            }
            pageInfo = customerService.selectOrderCusByParams(pageNum, pageSize, params);
        }

        List<Customer> list = pageInfo.getList();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageResult", getPageResult(pageInfo));
        map.put("list", list);
        ApiReturnInfo ar = new ApiReturnInfo<>();
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "提交休眠或战败审批")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cusId", value = "客户id必填", required = true, dataType = "String"),
            @ApiImplicitParam(name = "approvalType", value = "申请类型必填", required = true, dataType = "String"),
            @ApiImplicitParam(name = "applyReason", value = "申请原因必填", required = true, dataType = "String")
    })
    @RequestMapping(value = "/submitApprovalCus", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo approvalCus(HttpServletRequest request, ApprovalCus record) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        //发起潜客休眠或战败审批
        record.setEmployeeId(emp.getId());
        int res = approvalCusService.createApprovalCustomer(record);
        if(res>0){
        	//保存极光推送消息
    		Map<String, Object> mapc = new HashMap<>();
            mapc.put("storeId", emp.getStoreId());
            ArrayList<String> strings = new ArrayList<>();
            strings.add(SHOWROOM_MANAGER_POSITION);
            //展厅经理
            mapc.put("postNameList", strings);
            //推送标识
            mapc.put("n", 3);
    		List<Map<String, Object>> mapList = appEmployeeService.selectEmployeIdByPostName(mapc);
    		if(record.getApprovalType() == ApprovalyCusType.TWO.getCode()){//战败
    			String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_NEW_DEFEAT);
    			pushMessageService.createPushMessage(PushEnum.PushType.CUSTOMER_DEFEAT.getCode(), PushEnum.PushType.CUSTOMER_DEFEAT.getDesc(), content, emp.getId(), mapList);
    		}else{
    			String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_NEW_DORMANCY);
    			pushMessageService.createPushMessage(PushEnum.PushType.CUSTOMER_DORMANCY.getCode(), PushEnum.PushType.CUSTOMER_DORMANCY.getDesc(), content, emp.getId(), mapList);
    		}
        }
        ari.setData(null);
        return ari;
    }

    /**
     * 办事人员列表 wp
     *
     * @param request
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "办事人员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "createDate", value = "创建日期", required = true, dataType = "date")
    })
    @RequestMapping(value = "/selectTransactCustomer", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo selectTransactCustomer(
            HttpServletRequest request,
            String name,
            String createDate,
            Integer pageNum,
            Integer pageSize) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        Employee emp = getMember(request);
        Integer storeId = emp.getStoreId();
        Map<String, Object> transactCustomer = new HashMap<String, Object>();
        transactCustomer.put("name", name);
        transactCustomer.put("storeId", storeId);
        if (createDate == null || createDate.length() == 0) {
            transactCustomer.put("createDate", new Date());
        } else {
            transactCustomer.put("createDate", DateUtil.stringToDate(createDate, DateUtil.sdf2));
        }
        //查询
        PageInfo<Map<String, Object>> pageInfo = customerService.selectTransactCustomer(pageNum, pageSize, transactCustomer);
        List<Map<String, Object>> list = pageInfo.getList();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("pageResult", getPageResult(pageInfo));
        int num = 0;//登记数
        for (Map<String, Object> tr : list) {
            num++;
        }
        map.put("num", num);
        ar.setData(map);
        return ar;
    }

    /**
     * 新增办事人员 wp
     * @param name
     * @param tel
     * @param dutyName
     * @param carNumber
     * @param reason
     * @param request
     * @return
     */
    @RequestMapping(value = "/addTransactCustomer", method = {RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "办事人员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "", value = "申请类型必填", required = true, dataType = "String"),
            @ApiImplicitParam(name = "", value = "申请原因必填", required = true, dataType = "String")
    })
    public ApiReturnInfo insertTransactCustomer(
            String name,
            String tel,
            String dutyName,
            String carNumber,
            String reason,
            HttpServletRequest request) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        Employee emp = getMember(request);
        Integer storeId = emp.getStoreId();
        Integer groupId = emp.getGroupId();
        TransactCustomer transactCustomer = new TransactCustomer();
        transactCustomer.setCause(reason);
        transactCustomer.setCreateDate(new Date());
        transactCustomer.setDutyName(dutyName);
        transactCustomer.setLicensePlate(carNumber);
        transactCustomer.setPhoneNum(tel);
        transactCustomer.setGroupId(groupId);
        transactCustomer.setName(name);
        transactCustomer.setStoreId(storeId);
        int i = customerService.insertSelective(transactCustomer);
        if (i <= 0) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;
    }

    @ApiOperation(value = "客户photo上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "客户id必填", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "file", value = "个人照片", required = true, dataType = "file")
    })
    @RequestMapping(value = "/uploadPhoto", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo addDeliverCar(HttpServletRequest request, Customer record,
                                       @RequestParam(value = "file", required = false) MultipartFile file) {
        ApiReturnInfo ari = new ApiReturnInfo();
        //修改客户图像信息
        customerService.updateCustomer(record, file);
        ari.setData(null);
        return ari;
    }

    /**
     * 条件查询客户列表 wp
     *
     * @param request
     * @param pageSize
     * @param pageNum
     * @param customer
     * @return
     */
    @RequestMapping(value = "/selectCustomers")
    @ResponseBody
    @ApiOperation(value = "客户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer")
    })
    public ApiReturnInfo selectCustomers(
            HttpServletRequest request,
            Integer pageSize,
            Integer pageNum,
            String createTime,
            String name
    ) {
        //当前用户
        Employee emp = getMember(request);
        Integer storeId = emp.getStoreId();
        Date date = null;
        Map<String, Object> mapc = new HashMap<String, Object>();
        mapc.put("storeId", storeId);
        if (createTime == null || createTime.length() == 0) {
            mapc.put("createTime", new Date());
            date = new Date();
        } else {
            date = DateUtil.stringToDate(createTime, DateUtil.sdf2);
            mapc.put("createTime", DateUtil.stringToDate(createTime, DateUtil.sdf2));
        }
        if (StringUtil.isNotBlank(name)) {
            mapc.put("name", name);
        }
        PageInfo pageInfo = customerService.selectCustomers(pageNum, pageSize, mapc);
        List<Map<String, Object>> list = pageInfo.getList();
        if (list != null) {
            for (Map<String, Object> map : list) {
                //意向车型处理
                Integer cfid = (Integer) map.get("intention_family_id");
                Map<String, Object> cf = null;
                if (cfid != null) {
                    Map<String, Object> map2 = new HashMap<>();
                    map2.put("cfid", cfid);
                    cf = passengerFlowService.selectAttentionCarFamily(map2);
                }
                String cbname = null;
                String cfname = null;
                if (cf != null) {
                    cbname = (String) cf.get("cbname");
                    cfname = (String) cf.get("cfname");
                }
                map.put("cbname", cbname);
                map.put("cfname", cfname);
                //试驾信息处理
                Integer cusid = (Integer) map.get("cus_id");
                if (cusid != null) {
                    Map<String, Object> map2 = new HashMap<>();
                    map2.put("cusid", cusid);
                    Map<String, Object> testinfo = customerService.testInfo(map2);
                    //试驾时间处理
                    if (testinfo != null) {
                        Integer testStatus = (Integer) testinfo.get("tdstatus");
                        String startTime = (String) testinfo.get("tdcreat_time");
                        String endTime = (String) testinfo.get("end_time");
                        if (testStatus == null) {
                            map.put("test_time", "未试驾");
                        } else if (endTime == null) {
                            map.put("test_time", startTime + "-");
                        } else {
                            map.put("test_time", startTime + "-" + endTime);
                        }
                    }
                }
            }
        }
        PassengerFlow passengerFlow = new PassengerFlow();
        passengerFlow.setCreateTime(date);
        //获取客流信息
        List<PassengerFlow> listk = passengerFlowService.selectPassengerFlowMes(passengerFlow);
        //统计客流条数
        int finishNum = 0;
        int undoNum = 0;
        if (listk != null) {
            for (PassengerFlow pf : listk) {
                if (pf.getStatus() == enumPassengerFlowStatus.接待中.getId() ||
                        pf.getStatus() == enumPassengerFlowStatus.离店.getId()
                        ) {
                    finishNum++;
                } else {
                    undoNum++;
                }
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("finishNum", finishNum);
        map.put("undoNum", undoNum);
        map.put("total", finishNum + undoNum);
        map.put("pageResult", getPageResult(pageInfo));
        map.put("list", list);
        ApiReturnInfo ar = new ApiReturnInfo<>();
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "查询建档时所有意向车型")
    @RequestMapping(value = "/getCarFamily", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo getCarFamily(HttpServletRequest request) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        //门店所有车系
        List<Map<String, Object>> list = carFamilyService.selectListByStoreId(emp.getStoreId());
        ari.setData(list);
        return ari;
    }

}
