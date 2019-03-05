package com.unicdata.controller.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.RepaintManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unicdata.base.constant.Constant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.MessageCode;
import com.unicdata.constant.PushEnum;
import com.unicdata.constant.ConstantEnum.PassengerFloweType;
import com.unicdata.constant.ConstantEnum.enumPassengerFlowStatus;
import com.unicdata.constant.PushEnum.PushTerminal;
import com.unicdata.constant.PushEnum.PushType;
import com.unicdata.constant.MessageCode;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.EntranceGuardRemind;
import com.unicdata.entity.customer.PassengerFlow;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.entity.system.EmployeeStatus;
import com.unicdata.entity.system.EmployeeStatusExample;
import com.unicdata.entity.system.EmployeeTarget;
import com.unicdata.service.car.AppCarStoreService;
import com.unicdata.service.car.AppDeliverCarService;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.customer.TaskFollowUpService;
import com.unicdata.service.employee.AppEmployeeService;
import com.unicdata.service.employee.EmployeeTargetService;
import com.unicdata.service.order.OrderService;
import com.unicdata.service.passengerflow.PassengerFlowService;
import com.unicdata.service.push.PushMessageService;
import com.unicdata.service.system.EmployeeStatusService;
import com.unicdata.util.JPushUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 客流相关操作
 *
 * @author admin
 */
@Controller
@RequestMapping("/app/passengerFlow")
@Api(value = "客流相关接口", tags = {"销售顾问客流相关接口"})
public class PassengerFlowController extends HomeBaseController {

    @Autowired
    private PassengerFlowService passengerFlowService;
    @Autowired
    private EmployeeTargetService employeeTargetService;
    @Autowired
    private TaskFollowUpService taskFollowUpService;
    @Autowired
    private AppEmployeeService appEmployeeService;
    @Autowired
    private EmployeeStatusService employeeStatusService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AppDeliverCarService deliverCarService;
    @Autowired
    private AppCarStoreService appCarStoreService;
    @Autowired
    private PushMessageService pushMessageService;

    @ApiOperation(value = "客流首页接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页最大数量，默认30", required = true, dataType = "Integer")
    })
    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.POST)
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
        ari.setData(map);
        return ari;
    }

    @ApiOperation(value = "客流列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页最大数量，默认30", required = true, dataType = "Integer")
    })
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiReturnInfo list(HttpServletRequest request, Integer pageNum, Integer pageSize) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        //客流列表
        PassengerFlow record = new PassengerFlow();
        //测试修改员工
//        passengerFlowService.updateReplacePostData(record);
        if (emp.getPostName().equals(SHOWROOM_MANAGER_POSITION)) {
            record.setStoreId(emp.getStoreId());
        } else {
            record.setEmployeeId(emp.getId());
            record.setCreateTime(new Date());
        }
        Map<String, Object> pfMap = passengerFlowService.getPassengerFlowList(pageNum, pageSize, record);
        //返回客流数据
        ari.setData(pfMap);
        return ari;
    }

    @ApiOperation(value = "客流首页审批列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/approvalList", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo approvalList(String account, String password) {
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        //审批列表
        List<String> plist = new ArrayList<String>();
        plist.add("审批订单信息");
        map.put("approvalList", plist);
        ari.setData(map);
        return ari;
    }

    /**
     * 迎宾前台首页接口 wp
     */
    @RequestMapping(value = "/getIndex", method = {RequestMethod.POST})
    @ApiOperation(value = "首页客流数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "", required = true, dataType = "String")
    })
    @ResponseBody
    public ApiReturnInfo indexs(
    		HttpServletRequest requst,
    		Integer pageNum, 
    		Integer pageSize
    		) {
        //当前用户
        Employee emp = getMember(requst);
        Integer storeId = emp.getStoreId();
        System.out.println(storeId);
        Map<String, Object> map = new HashMap<String, Object>();
        PassengerFlow passengerFlow = new PassengerFlow();
        passengerFlow.setCreateTime(new Date());
        //获取客流信息
        List<PassengerFlow> list = passengerFlowService.selectPassengerFlowMes(passengerFlow);
        //统计客流条数
        int finishNum = 0;
        int undoNum = 0;
        for (PassengerFlow pf : list) {
            if (pf.getStatus() == enumPassengerFlowStatus.接待中.getId() ||
        		pf.getStatus() == enumPassengerFlowStatus.离店.getId()
        		) {
                finishNum++;
            } else {
                undoNum++;
            }
        }
        map.put("finishNum", finishNum);
        map.put("undoNum", undoNum);
        map.put("total", finishNum + undoNum);
        //获取首页销售
        Map<String, Object> mapc = new HashMap<>();
        List<Integer> typeList = new ArrayList<>();
        typeList.add(0);
        typeList.add(2);
        typeList.add(3);
        mapc.put("storeId", storeId);
        mapc.put("postName", SALES_CONSULTANT_POSITION);//销售顾问
        mapc.put("typeList", typeList);//空闲 培训 休假
        List<Map<String, Object>> list2 = appEmployeeService.selectEmployeAndGroup(mapc);
        //二次到店状态 arrive_type
        Map<String, Object> mapcd=new HashMap<>();
        mapcd.put("storeId", storeId);
        List<Map<String, Object>> list3 = passengerFlowService.selectDoorRemindMes(mapcd);
        for (Map<String, Object> map2 : list2) {//销售人员
        	boolean flag=false;
			Integer eid=(Integer) map2.get("eid");
			for (Map<String, Object> map3 : list3) {//循环门禁信息获取对应的销售顾问
				Integer eidd=(Integer) map3.get("eid");
				if (eid == eidd) {
					flag=true;
					break;
				}
			}
			if (flag) {
				map2.put("arrive_status", 2);
			}else {
				map2.put("arrive_status", 1);	
			}
		}
        //获取未接待、正接待的客流(左右侧显示)
        Map<String, Object> mapc1 = new HashMap<>();
        mapc1.put("storeId", storeId);
        mapc1.put("createTime", DateUtil.dateFormat(new Date(), DateUtil.sdf2));
        List<Map<String, Object>> listp = passengerFlowService.selectDoingPassengerFlow(mapc1);
        //根据到店类型 分左右显示
        List<Map<String, Object>> lists = new ArrayList<>();
        List<Map<String, Object>> listz = new ArrayList<>();
        for (Map<String, Object> map2 : listp) {
        	 Map<String, Object> tdMap=null;//试驾状态
        	//试驾状态处理
        	Map<String, Object> mapc2 = new HashMap<>();
        	Integer cusId=(Integer) map2.get("cus_id");
        	Integer tdstatus=null;
        	if (cusId !=null) {
        		mapc2.put("cusid", cusId);
                tdMap=passengerFlowService.testStatus(mapc2);
                if (tdMap !=null) {
            		tdstatus=(Integer) tdMap.get("tdstatus");
    			}
			}
        	if (tdstatus==null) {
        		map2.put("tdstatus", 1);
			}else if (tdstatus==1) {
				map2.put("tdstatus", 2);
			}else if (tdstatus==2) {
				map2.put("tdstatus", 3);
			}
        	//销售顾问名称显示处理
        	Integer empInteger=(Integer) map2.get("replace_employee_id");//替岗人员ID
			Integer empInteger2=(Integer) map2.get("employee_id");//销售人员ID
			if (empInteger !=null) {
				Employee employee=appEmployeeService.selectEmployee(empInteger);
				map2.put("full_name", employee.getFullName());
			}else {
				Employee employee=appEmployeeService.selectEmployee(empInteger2);
				map2.put("full_name", employee.getFullName());
			}
            if ((Integer) map2.get("pftype") == PassengerFloweType.首次到店1.getCode()) {//到店次数 1:首次 2:再次,
                lists.add(map2);
            } else {
                listz.add(map2);
            }
        }
        //通过试驾状态排序 升序
        Collections.sort(lists, new Comparator<Map<String, Object>>(){
        	   public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        		Integer tdstatus1 =(Integer)o1.get("tdstatus");//tdstatus1是从你list里面拿出来的一个
        		Integer tdstatus2= (Integer)o2.get("tdstatus"); //tdstatus1是从你list里面拿出来的第二个    
        	    return tdstatus1.compareTo(tdstatus2);  
        	   }
        });
        Collections.sort(listz, new Comparator<Map<String, Object>>(){
     	   public int compare(Map<String, Object> o1, Map<String, Object> o2) {
     		Integer tdstatus1 =(Integer)o1.get("tdstatus");//tdstatus1是从你list里面拿出来的一个
     		Integer tdstatus2= (Integer)o2.get("tdstatus"); //tdstatus1是从你list里面拿出来的第二个    
     	    return tdstatus1.compareTo(tdstatus2);  
     	   }
     });
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> mapr = new HashMap<>();
        map.put("freeWorker", list2);//首页销售
        map.put("lists", lists);//首次到店客流列
        map.put("listz", listz);//再次到店客流列
        ar.setData(map);
        return ar;
    }

    /**
     * 生成新建客流 wp
     * @param requst
     * @param employeeId
     * @param type       到店类型 1首次 2再次
     * @return
     */
    @ApiOperation(value = "新增客流")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeId", value = "销售ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/addPassengerFlow", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo addPassengerFlow(
            HttpServletRequest requst,
            Integer employeeId,
            Integer type
            ) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        //获取当前用户
        Employee emp = getMember(requst);
        Integer storeId = emp.getStoreId();
        PassengerFlow passengerFlow = new PassengerFlow();
        passengerFlow.setEmployeeId(employeeId);
        passengerFlow.setType(type);
        passengerFlow.setStoreId(storeId);
        passengerFlow.setCreateEmployeeId(emp.getId());
        //生成客流信息
        try {
            int i = passengerFlowService.addPassengerFlow(passengerFlow);
            //改变工作人员为忙碌状态
            Map<String, Object> map = new HashMap<>();
            map.put("employeeId", employeeId);
            map.put("type", 1);
            int i2 = appEmployeeService.updateEmpStatus(map);
           /* //极光推送至销售顾问
            Map<String, String> msgType = new HashMap<String, String>();
            msgType.put("code", MessageCode.MESSAGE_NEW_PASSENGER);//前台发起新客流
            msgType.put("message", MessageCode.resultCodeMap.get(MessageCode.MESSAGE_NEW_PASSENGER));
            String alias = StringUtil.md5(Constant.APP_ALIAS + passengerFlow.getEmployeeId());
            String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_NEW_PASSENGER);
            //推送消息
            JPushUtils.sendAlias(content, msgType, alias);*/
            //将推送消息存入消息列表 
            String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_NEW_PASSENGER);
            String title=PushType.PASSENGERFLOW_FIRST_SHOP.getDesc();
            Integer types=PushType.PASSENGERFLOW_FIRST_SHOP.getCode();//??
            Integer createId=emp.getId();
            List<Map<String, Object>> receivers=new ArrayList<>();//发送对象
            Map<String, Object> puempMap=new HashMap<>();
            puempMap.put("employeeId", employeeId);
//            puempMap.put("urlId", "");
            puempMap.put("terminal", PushTerminal.MOBILE.getCode());
            receivers.add(puempMap);
            pushMessageService.createPushMessage(types, title, content, createId, receivers);
        } catch (Exception e) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        ar.setData(passengerFlow.getId());//返回客流ID
        return ar;
    }

    @ApiOperation(value = "首页展厅经理、销售经理客流分配---销售顾问")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "passengerFlowId", value = "客流ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "employeeId", value = "员工ID", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/distributionSale", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo distributionSale(HttpServletRequest requst, Integer passengerFlowId, Integer employeeId) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        try {
            PassengerFlow passengerFlow = new PassengerFlow();
            passengerFlow.setId(passengerFlowId);
            passengerFlow.setEmployeeId(employeeId);
            //客流未接待
            passengerFlow.setStatus(1);
            //更新客流表
            int i1 = passengerFlowService.updateByPrimaryKey(passengerFlow);
            //更新销售顾问状态
            EmployeeStatusExample example = new EmployeeStatusExample();
            EmployeeStatusExample.Criteria criteria = example.createCriteria();
            criteria.andEmployeeIdEqualTo(employeeId);
            List<EmployeeStatus> employeeStatuses = employeeStatusService.selectByExample(example);
            if (employeeStatuses.size() > 0) {
                EmployeeStatus state = employeeStatuses.get(0);
                state.setContactTime(new Date());
                state.setType(1);
                int i = employeeStatusService.updateByPrimaryKey(state);
                if (i <= 0 || i1 <= 0) {
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

    /**
     * 替岗换销售 wp
     * @param replaceEmployeeId
     * @param employeeId
     * @param id
     * @return
     */
    @ApiOperation(value = "替岗换销售提交")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "replaceEmployeeId", value = "替岗ID", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "employeeId", value = "换销售ID", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "id", value = "客流ID", required = true, dataType = "integer")
    })
    @ResponseBody
    @RequestMapping(value = "/changeSellMan", method = {RequestMethod.POST})
    public ApiReturnInfo changeSellMan(
    		HttpServletRequest requst,
            Integer replaceEmployeeId,//替岗
            Integer newEmployeeId,//换销售
            Integer id
            ) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        Employee emp = getMember(requst);
        //判断再次换销售
        //想通过ID查相应的记录
        PassengerFlow passengerFlow2 = passengerFlowService.getPassengerFlowById(id);
            if (passengerFlow2 != null) {
            	Integer replaceEmp = passengerFlow2.getReplaceEmployeeId();
                //替岗后 再次进行替岗/换销售
                if (replaceEmp != null) {
                    if (newEmployeeId != null) {//换销售
                        //进行员工状态改变
                        Map<String, Object> map = new HashMap<>();
                        map.put("employeeId", passengerFlow2.getReplaceEmployeeId());
                        map.put("type", 0);//状态0空闲（1忙碌）2休假3培训
                        appCarStoreService.updateEmpStatus(map);//替换下来的改为空闲
                        Map<String, Object> map1 = new HashMap<>();
                        map1.put("employeeId", newEmployeeId);
                        map1.put("type", 1);//状态0空闲（1忙碌）2休假3培训
                        appCarStoreService.updateEmpStatus(map1);//替换上去的改为忙碌
                        PassengerFlow passengerFlow = new PassengerFlow();
                        passengerFlow.setId(id);
                        passengerFlow.setEmployeeId(newEmployeeId);
                        int n = passengerFlowService.changeSellMan(passengerFlow);
                        int c = passengerFlowService.changeRepalceNull(passengerFlow);
                        //将客户的员工ID 变为换销售后的员工ID
                        Integer cusid=passengerFlow2.getCusId();
                        if (cusid!=null) {
                        	 Customer customer=new Customer();
                             customer.setId(cusid);
                             customer.setEmployeeId(newEmployeeId);//新销售顾问
                             passengerFlowService.updateCustomerEmp(customer);
						}
                       /* //测试极光推送
                    	String alias = StringUtil.md5(Constant.APP_ALIAS + passengerFlow2.getEmployeeId());//给原销售推消息
                        String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_EXCHANGE_SALEMAN2);
                        Map<String, String> msgType = new HashMap<String, String>();
                        msgType.put("code", MessageCode.MESSAGE_EXCHANGE_SALEMAN2);
                        msgType.put("message", content);
                        //推送消息
                        JPushUtils.sendAlias(content, msgType, alias);
                        //测试极光推送
                    	String alias1 = StringUtil.md5(Constant.APP_ALIAS + newEmployeeId);//给新销售推消息
                        String content1 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_EXCHANGE_SALEMAN);
                        Map<String, String> msgType1 = new HashMap<String, String>();
                        msgType1.put("code", MessageCode.MESSAGE_EXCHANGE_SALEMAN);
                        msgType1.put("message", content1);
                        //推送消息
                        JPushUtils.sendAlias(content1, msgType1, alias1);*/
                        if (n>0 && c>0) {
                        	 //推送消息存入消息表(原销售顾问)
                        	 String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_EXCHANGE_SALEMAN2);
                             String title=PushType.REPLACE_SALES.getDesc();
                             Integer type=PushType.REPLACE_SALES.getCode();//业务类型？？
                             Integer createId=emp.getId();
                             List<Map<String, Object>> receivers=new ArrayList<>();//发送对象
                             Map<String, Object> puempMap=new HashMap<>();
                             puempMap.put("employeeId", passengerFlow2.getEmployeeId());
//                             puempMap.put("urlId", "");
                             puempMap.put("terminal", PushTerminal.MOBILE.getCode());
                             receivers.add(puempMap);
                             pushMessageService.createPushMessage(type, title, content, createId, receivers);
                             //推送消息存入消息表(新销售顾问)
                             String content1 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_EXCHANGE_SALEMAN);
                             String title1=PushType.REPLACE_SALES.getDesc();
                             Integer type1=PushType.REPLACE_SALES.getCode();//业务类型？？
                             Integer createId1=emp.getId();
                             List<Map<String, Object>> receivers1=new ArrayList<>();//发送对象
                             Map<String, Object> puempMap1=new HashMap<>();
                             puempMap1.put("employeeId", newEmployeeId);
//                             puempMap1.put("urlId", "");
                             puempMap1.put("terminal", PushTerminal.MOBILE.getCode());
                             receivers1.add(puempMap1);
                             pushMessageService.createPushMessage(type1, title1, content1, createId1, receivers1);
						}else {
							 ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
					         ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
						}
                    }
                    if (replaceEmployeeId != null) {//替岗
                        Map<String, Object> map2 = new HashMap<>();
                        map2.put("employeeId", passengerFlow2.getReplaceEmployeeId());
                        map2.put("type", 0);//状态0空闲（1忙碌）2休假3培训
                        appCarStoreService.updateEmpStatus(map2);//替换下来的改为空闲
                        Map<String, Object> map3 = new HashMap<>();
                        map3.put("employeeId", replaceEmployeeId);
                        map3.put("type", 1);//状态0空闲（1忙碌）2休假3培训
                        appCarStoreService.updateEmpStatus(map3);//替换上去的改为忙碌
                        PassengerFlow passengerFlow = new PassengerFlow();
                        passengerFlow.setId(id);
                        passengerFlow.setReplaceEmployeeId(replaceEmployeeId);
                        int r = passengerFlowService.changeSellMan(passengerFlow);
                        //将客户的员工ID 变为换销售后的员工ID
                        Integer cusid=passengerFlow2.getCusId();
                        if (cusid!=null) {
                        	 Customer customer=new Customer();
                             customer.setId(cusid);
                             customer.setEmployeeId(replaceEmployeeId);//替岗销售顾问
                             passengerFlowService.updateCustomerEmp(customer);
						}
                       /* //测试极光推送
                    	String alias = StringUtil.md5(Constant.APP_ALIAS + passengerFlow2.getReplaceEmployeeId());//给原销售推消息
                        String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_REPLACE_SALEMAN2);
                        content=content.replace("XXX","");//客户名字
                        content=content.replace("YYY", appEmployeeService.selectEmployee(replaceEmp).getFullName());
                        Map<String, String> msgType = new HashMap<String, String>();
                        msgType.put("code", MessageCode.MESSAGE_REPLACE_SALEMAN2);
                        msgType.put("message", content);
                        //推送消息
                        JPushUtils.sendAlias(content, msgType, alias);
                       //测试极光推送
                    	String alias1 = StringUtil.md5(Constant.APP_ALIAS + replaceEmployeeId);//给新销售推消息
                        String content1 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_REPLACE_SALEMAN);
                        content1=content1.replace("XXX",appEmployeeService.selectEmployee(passengerFlow2.getReplaceEmployeeId()).getFullName());//原顾问
                        Map<String, String> msgType1 = new HashMap<String, String>();
                        msgType1.put("code", MessageCode.MESSAGE_REPLACE_SALEMAN);
                        msgType1.put("message", content1);
                        //推送消息
                        JPushUtils.sendAlias(content1, msgType1, alias1);*/
                        if (r>0) {
                        	//推送消息存入消息表(原销售顾问)
                            String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_REPLACE_SALEMAN2);
                            content=content.replace("XXX","");//客户名字
                            content=content.replace("YYY", appEmployeeService.selectEmployee(replaceEmp).getFullName());
                            String title=PushType.REPLACE_POST.getDesc();
                            Integer type=PushType.REPLACE_POST.getCode();//业务类型？？
                            Integer createId=emp.getId();
                            List<Map<String, Object>> receivers=new ArrayList<>();//发送对象
                            Map<String, Object> puempMap=new HashMap<>();
                            puempMap.put("employeeId", passengerFlow2.getReplaceEmployeeId());
//                            puempMap.put("urlId", "");
                            puempMap.put("terminal", PushTerminal.MOBILE.getCode());
                            receivers.add(puempMap);
                            pushMessageService.createPushMessage(type, title, content, createId, receivers);
                            //推送消息存入消息表(新销售顾问)
                            String content1 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_REPLACE_SALEMAN);
                            content1=content1.replace("XXX",appEmployeeService.selectEmployee(passengerFlow2.getReplaceEmployeeId()).getFullName());//原顾问
                            String title1=PushType.REPLACE_POST.getDesc();
                            Integer type1=PushType.REPLACE_POST.getCode();//业务类型？？
                            Integer createId1=emp.getId();
                            List<Map<String, Object>> receivers1=new ArrayList<>();//发送对象
                            Map<String, Object> puempMap1=new HashMap<>();
                            puempMap1.put("employeeId", replaceEmployeeId);
//                            puempMap1.put("urlId", "");
                            puempMap1.put("terminal", PushTerminal.MOBILE.getCode());
                            receivers1.add(puempMap1);
                            pushMessageService.createPushMessage(type1, title1, content1, createId1, receivers1);
						}else {
							 ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
					         ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
						}
                    }
                } else {//首次替岗换销售
                	if (replaceEmployeeId!=null) {//替岗
                		 Map<String, Object> map3 = new HashMap<>();
                		 map3.put("type", 1);//状态0空闲（1忙碌）2休假3培训
                		 map3.put("employeeId", replaceEmployeeId);
                         appCarStoreService.updateEmpStatus(map3);//替换上去的改为忙碌
                         Map<String, Object> map2=new HashMap<>();
                         map2.put("type", 0);
                         map2.put("employeeId", passengerFlow2.getEmployeeId());
                         appCarStoreService.updateEmpStatus(map2);//替换下来的改为空闲
                         PassengerFlow passengerFlow = new PassengerFlow();
                         passengerFlow.setId(id);
                         passengerFlow.setReplaceEmployeeId(replaceEmployeeId);
                         int i = passengerFlowService.changeSellMan(passengerFlow);
                         //将客户的员工ID 变为换销售后的员工ID
                         Integer cusid=passengerFlow2.getCusId();
                         if (cusid!=null) {
                         	 Customer customer=new Customer();
                              customer.setId(cusid);
                              customer.setEmployeeId(replaceEmployeeId);//替岗销售顾问
                              passengerFlowService.updateCustomerEmp(customer);
 						 }
                         if (i>0) {
                        	//推送消息存入消息表(原销售顾问)
                             String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_REPLACE_SALEMAN2);
                             content=content.replace("XXX","");//客户名字
                             content=content.replace("YYY", appEmployeeService.selectEmployee(replaceEmp).getFullName());//新顾问名字
                             String title=PushType.REPLACE_POST.getDesc();
                             Integer type=PushType.REPLACE_POST.getCode();//业务类型？？
                             Integer createId=emp.getId();
                             List<Map<String, Object>> receivers=new ArrayList<>();//发送对象
                             Map<String, Object> puempMap=new HashMap<>();
                             puempMap.put("employeeId", passengerFlow2.getEmployeeId());
//                             puempMap.put("urlId", "");
                             puempMap.put("terminal", PushTerminal.MOBILE.getCode());
                             receivers.add(puempMap);
                             pushMessageService.createPushMessage(type, title, content, createId, receivers);
                             //推送消息存入消息表(新销售顾问)
                             String content1 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_REPLACE_SALEMAN);
                             content1=content1.replace("XXX",appEmployeeService.selectEmployee(passengerFlow2.getEmployeeId()).getFullName());//销售顾问
                             String title1=PushType.REPLACE_POST.getDesc();
                             Integer type1=PushType.REPLACE_POST.getCode();//业务类型？？
                             Integer createId1=emp.getId();
                             List<Map<String, Object>> receivers1=new ArrayList<>();//发送对象
                             Map<String, Object> puempMap1=new HashMap<>();
                             puempMap1.put("employeeId", replaceEmployeeId);
//                             puempMap1.put("urlId", "");
                             puempMap1.put("terminal", PushTerminal.MOBILE.getCode());
                             receivers1.add(puempMap1);
                             pushMessageService.createPushMessage(type1, title1, content1, createId1, receivers1);
						}else {
							 ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
					         ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
						}
                         /*//测试极光推送
                     	 String alias = StringUtil.md5(Constant.APP_ALIAS + passengerFlow2.getEmployeeId());//给原销售推消息
                         String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_REPLACE_SALEMAN2);
                         content=content.replace("XXX","");//客户名字
                         content=content.replace("YYY", appEmployeeService.selectEmployee(replaceEmp).getFullName());//新顾问名字
                         Map<String, String> msgType = new HashMap<String, String>();
                         msgType.put("code", MessageCode.MESSAGE_REPLACE_SALEMAN2);
                         msgType.put("message", content);
                         //推送消息
                         JPushUtils.sendAlias(content, msgType, alias);
                        //测试极光推送
                     	 String alias1 = StringUtil.md5(Constant.APP_ALIAS + replaceEmployeeId);//给新销售推消息
                         String content1 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_REPLACE_SALEMAN);
                         content1=content1.replace("XXX",appEmployeeService.selectEmployee(passengerFlow2.getEmployeeId()).getFullName());//销售顾问
                         Map<String, String> msgType1 = new HashMap<String, String>();
                         msgType1.put("code", MessageCode.MESSAGE_REPLACE_SALEMAN);
                         msgType1.put("message", content1);
                         //推送消息
                         JPushUtils.sendAlias(content1, msgType1, alias1);*/
					}
                	if (newEmployeeId!=null) {//换销售
               		 Map<String, Object> map3 = new HashMap<>();
            		 map3.put("type", 1);//状态0空闲（1忙碌）2休假3培训
            		 map3.put("employeeId", newEmployeeId);
                     appCarStoreService.updateEmpStatus(map3);//替换上去的改为忙碌
                     Map<String, Object> map2=new HashMap<>();
                     map2.put("type", 0);
                     map2.put("employeeId", passengerFlow2.getEmployeeId());
                     appCarStoreService.updateEmpStatus(map2);//替换下来的改为空闲
                     PassengerFlow passengerFlow = new PassengerFlow();
                     passengerFlow.setId(id);
                     passengerFlow.setEmployeeId(newEmployeeId);
                     int i = passengerFlowService.changeSellMan(passengerFlow);
                     //将客户的员工ID 变为换销售后的员工ID
                     Integer cusid=passengerFlow2.getCusId();
                     if (cusid!=null) {
                     	 Customer customer=new Customer();
                          customer.setId(cusid);
                          customer.setEmployeeId(newEmployeeId);//新销售顾问
                          passengerFlowService.updateCustomerEmp(customer);
					 }
                     if (i>0) {
                    	//推送消息存入消息表(原销售顾问)
                    	 String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_EXCHANGE_SALEMAN2);
                         String title=PushType.REPLACE_SALES.getDesc();
                         Integer type=PushType.REPLACE_SALES.getCode();//业务类型？？
                         Integer createId=emp.getId();
                         List<Map<String, Object>> receivers=new ArrayList<>();//发送对象
                         Map<String, Object> puempMap=new HashMap<>();
                         puempMap.put("employeeId", passengerFlow2.getEmployeeId());
//                         puempMap.put("urlId", "");
                         puempMap.put("terminal", PushTerminal.MOBILE.getCode());
                         receivers.add(puempMap);
                         pushMessageService.createPushMessage(type, title, content, createId, receivers);
                         //推送消息存入消息表(新销售顾问)
                         String content1 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_EXCHANGE_SALEMAN);
                         String title1=PushType.REPLACE_SALES.getDesc();
                         Integer type1=PushType.REPLACE_SALES.getCode();//业务类型？？
                         Integer createId1=emp.getId();
                         List<Map<String, Object>> receivers1=new ArrayList<>();//发送对象
                         Map<String, Object> puempMap1=new HashMap<>();
                         puempMap1.put("employeeId", newEmployeeId);
//                         puempMap1.put("urlId", "");
                         puempMap1.put("terminal", PushTerminal.MOBILE.getCode());
                         receivers1.add(puempMap1);
                         pushMessageService.createPushMessage(type1, title1, content1, createId1, receivers1);
					}else {
						 ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
				         ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
					}
                    /* //测试极光推送
                 	 String alias = StringUtil.md5(Constant.APP_ALIAS + passengerFlow2.getEmployeeId());//给原销售推消息
                     String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_EXCHANGE_SALEMAN2);
                     Map<String, String> msgType = new HashMap<String, String>();
                     msgType.put("code", MessageCode.MESSAGE_EXCHANGE_SALEMAN2);
                     msgType.put("message", content);
                     //推送消息
                     JPushUtils.sendAlias(content, msgType, alias);
                     //测试极光推送
                 	 String alias1 = StringUtil.md5(Constant.APP_ALIAS +newEmployeeId);//给新销售推消息
                     String content1 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_EXCHANGE_SALEMAN);
                     Map<String, String> msgType1 = new HashMap<String, String>();
                     msgType1.put("code", MessageCode.MESSAGE_EXCHANGE_SALEMAN);
                     msgType1.put("message", content1);
                     //推送消息
                     JPushUtils.sendAlias(content1, msgType1, alias1);*/
					}
                }
            }
        return ar;
    }

    @ApiOperation(value = "匹配客户提交")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "客户ID", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "id", value = "客流ID", required = true, dataType = "integer")
    })
    @ResponseBody
    @RequestMapping(value = "/matchingCustomer", method = RequestMethod.POST)
    public ApiReturnInfo matchingCustomer(HttpServletRequest requst,Integer customerId, Integer id) {
    	//获取当前用户
        Employee emp = getMember(requst);
    	ApiReturnInfo ari = new ApiReturnInfo<>();
        PassengerFlow passengerFlow = new PassengerFlow();
        passengerFlow.setId(id);
        passengerFlow.setCusId(customerId);
        passengerFlow.setIsArchives(1);
        passengerFlow.setStatus(enumPassengerFlowStatus.接待中.getId());
        //更新客流表
        int res = passengerFlowService.updateByPrimaryKey(passengerFlow);
        if(res>0){
        	Customer customer = new Customer();
        	customer.setId(customerId);
        	customer.setPassengerId(id);
        	customerService.updateByPrimaryKeySelective(customer);
        	//通知前台已处理
        	PassengerFlow tempPassengerFlow = passengerFlowService.selectByPrimaryKey(id);
        	//保存极光推送消息
    		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<>();
//            map.put("urlId", "");
            map.put("employeeId", tempPassengerFlow.getCreateEmployeeId());
            map.put("terminal", 2);
            mapList.add(map);
            String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_PASSENGER_CREATEARCHIVES);
            content = content.replace("XXX", emp.getFullName());
            pushMessageService.createPushMessage(PushEnum.PushType.CUSTOMER_INFO_INTEGRITY.getCode(), PushEnum.PushType.CUSTOMER_INFO_INTEGRITY.getDesc(), content, emp.getId(), mapList);
        }
        ari.setData(null);
        return ari;
    }

    /**
     * 空闲销售人员 wp
     *
     * @return
     */
    @RequestMapping(value = "/selectEmployeAndGroup", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo selectEmployeAndGroup(HttpServletRequest requst) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        Employee emp = getMember(requst);
        Integer storeId = emp.getStoreId();
        Map<String, Object> mapc = new HashMap<>();
        List<Integer> typeList = new ArrayList<>();
        typeList.add(0);
        mapc.put("typeList", typeList);//空闲
        mapc.put("storeId", storeId);
        mapc.put("postName", SALES_CONSULTANT_POSITION);//销售顾问
//	   mapc.put("roleId1", 2);//DCC
        List<Map<String, Object>> list = appEmployeeService.selectEmployeAndGroup(mapc);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        ar.setData(map);
        return ar;
    }

    /**
     * 通过类型，名字或者状态获取销售顾问或者服务顾问 wp
     *
     * @return
     */
    @RequestMapping(value = "/selectEmployeByName", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "1获取销售顾问，2获取服务顾问", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "通过名字搜索", required = true, dataType = "String"),
            @ApiImplicitParam(name = "status", value = "状态0空闲1忙碌", required = true, dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo selectEmployeByName(HttpServletRequest requst, String name, Integer type, Integer status) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        Employee emp = getMember(requst);
        Map<String, Object> mapc = new HashMap<>();
        mapc.put("storeId", emp.getStoreId());
        if (type != null && type == 1) {
            //销售顾问
            mapc.put("postName", SALES_CONSULTANT_POSITION);
            if (status != null && status == 0) {
                mapc.put("status", 0);
            } else if (status != null && status == 1) {
                mapc.put("status", 1);
            }
        } else if (type != null && type == 2) {
            //销售顾问服务顾问
            mapc.put("postName", SALES_SERVICE);
        }
        if (name != null && name != "") {
            mapc.put("name", name);
        }
        List<Map<String, Object>> list = appEmployeeService.selectEmployeByPostName(mapc);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "客流离店提交")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cusId", value = "客户ID", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "id", value = "客流ID", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "leaveTime", value = "离店时间", required = true, dataType = "date"),
            @ApiImplicitParam(name = "licensePlate", value = "车牌号", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "ownedCar", value = "客户车辆", required = true, dataType = "integer")
    })
    @ResponseBody
    @RequestMapping(value = "/leaveShop", method = RequestMethod.POST)
    public ApiReturnInfo changeSellMan(HttpServletRequest requst, PassengerFlow passengerFlow) {
        Employee emp = getMember(requst);
        ApiReturnInfo ari = new ApiReturnInfo<>();
        passengerFlow.setStatus(enumPassengerFlowStatus.离店.getId());
        //更新客流表
        passengerFlow.setEmployeeId(emp.getId());
        int res = passengerFlowService.updateLeaveShop(passengerFlow);
        if(res>0){//通知前台已离店
        	//
    		PassengerFlow pf = passengerFlowService.selectByPrimaryKey(passengerFlow.getId());
        	//保存极光推送消息
    		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<>();
//            map.put("urlId", "");
            map.put("employeeId", pf.getCreateEmployeeId());
            map.put("terminal", 2);
            mapList.add(map);
            String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_PASSENGER_LEAVE);
            content = content.replace("XXX", emp.getFullName());
            pushMessageService.createPushMessage(PushEnum.PushType.CUSTOMER_LEAVE.getCode(), PushEnum.PushType.CUSTOMER_LEAVE.getDesc(), content, emp.getId(), mapList);
        }
        ari.setData(null);
        return ari;
    }

    /**
     * 通过车牌查客户信息 wp
     * @param requst
     * @param licensePlate
     * @return
     */
    @ApiOperation(value = "门禁提醒")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "客户ID", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "id", value = "客流ID", required = true, dataType = "integer")
    })
    @ResponseBody
    @RequestMapping(value = "/doorRemind")
    public ApiReturnInfo selectCustomerByLicencePlate(
		   String licensePlate,
           HttpServletRequest requst
    ) {
       ApiReturnInfo ar = new ApiReturnInfo<>();
       Employee emp = getMember(requst);
	   Integer storeId=emp.getStoreId();
       Map<String, Object> map=new HashMap<>();
       map.put("licensePlate", licensePlate);
       map.put("storeId", storeId);
       //二次到店的客户信息
	   Map<String, Object> cusmessage=passengerFlowService.selectCustomerByLicensePlate(map);
	   Integer employeeId=(Integer) cusmessage.get("employee_id");//对应销售顾问ID
	   Integer cusId=(Integer) cusmessage.get("id");
	   //将二次到店的顾客信息存入门禁表
	   EntranceGuardRemind entranceGuardRemind=new EntranceGuardRemind();
	   entranceGuardRemind.setArriveType(2);//二次到店
	   entranceGuardRemind.setCarPlateNumber(licensePlate);
	   entranceGuardRemind.setCreateTime(new Date());
	   entranceGuardRemind.setCusId(cusId);
	   entranceGuardRemind.setDoStatus(1);//未处理
	   entranceGuardRemind.setStoreId(storeId);
	   try {
		   passengerFlowService.insertDoorRemindMes(entranceGuardRemind);
		} catch (Exception e) {
		   ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
           ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		}
	   /*//测试极光推送
       Map<String, String> msgType = new HashMap<String, String>();
       msgType.put("code", MessageCode.ENTRANCE_GUARD_REMIND);
       msgType.put("message", MessageCode.resultCodeMap.get(MessageCode.ENTRANCE_GUARD_REMIND));
       String alias = StringUtil.md5(Constant.APP_ALIAS + emp.getId());
       String content = MessageCode.resultCodeMap.get(MessageCode.ENTRANCE_GUARD_REMIND)+",车牌："+licensePlate;
       //推送消息
       JPushUtils.sendAlias(content, msgType, alias);*/
       
       Map<String, Object> mapr=new HashMap<String, Object>();
	   mapr.put("employeeId", employeeId);//销售顾问ID
	   ar.setData(mapr);
        return ar;
    }
    /**
     * 获取未接待、正接待的客流 wp
     * @param requst
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "replaceEmployeeId", value = "替岗ID", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "employeeId", value = "换销售ID", required = true, dataType = "integer"),
    })
    @RequestMapping(value = "/selectDoingPassengerFlow")
    @ResponseBody
    public ApiReturnInfo selectDoingPassengerFlow(HttpServletRequest requst) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        Employee emp = getMember(requst);
        Integer storeId = emp.getStoreId();
        Map<String, Object> mapc = new HashMap<>();
        mapc.put("storeId", storeId);
        List<Map<String, Object>> list = passengerFlowService.selectDoingPassengerFlow(mapc);
        if (list!=null) {
	        for (Map<String, Object> map : list) {
				Integer cusid=(Integer) map.get("cus_id");
				Integer empInteger=(Integer) map.get("replace_employee_id");//替岗人员ID
				Integer empInteger2=(Integer) map.get("employee_id");//销售人员ID
				//最新试驾记录处理
				if (cusid!=null) {
					Map<String, Object> map2=new HashMap<>();
					map2.put("cusid", cusid);
					Map<String, Object> testMap=customerService.testInfo(map2);
					if (testMap !=null) {
					Integer tdstatus=(Integer) testMap.get("tdstatus");
					String endtime=(String) testMap.get("end_time");
					String createtime=(String) testMap.get("tdcreat_time");
					if (tdstatus == null) {
						map.put("tdstatus", 1);
					}else if (tdstatus==1) {
						map.put("tdstatus", 2);
					}else {
						map.put("tdstatus", 3);
					}
				 }
				}
				//销售顾问名称显示处理
				if (empInteger !=null) {
					Employee employee=appEmployeeService.selectEmployee(empInteger);
					map.put("full_name", employee.getFullName());
				}else {
					Employee employee=appEmployeeService.selectEmployee(empInteger2);
					map.put("full_name", employee.getFullName());
				}
			}
    	}
        ar.setData(list);
        return ar;
    }
    /**
     * 变更二次到店处理状态 wp
     * @param requst
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "replaceEmployeeId", value = "替岗ID", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "employeeId", value = "换销售ID", required = true, dataType = "integer"),
    })
    @RequestMapping(value = "/changeDoStatus")
    @ResponseBody
    public ApiReturnInfo changeDoStatus(
    		HttpServletRequest requst,
    		Integer cudId
    		) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        Employee emp = getMember(requst);
        Integer storeId = emp.getStoreId();
        Map<String, Object> mapc = new HashMap<>();
        mapc.put("storeId", storeId);
        return ar;
    }
}
