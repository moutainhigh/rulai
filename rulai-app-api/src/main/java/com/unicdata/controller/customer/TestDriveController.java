package com.unicdata.controller.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unicdata.base.constant.Constant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.MessageCode;
import com.unicdata.constant.PushEnum.PushTerminal;
import com.unicdata.constant.PushEnum.PushType;
import com.unicdata.constant.ConstantEnum.TestDriveStatus;
import com.unicdata.constant.ConstantEnum.enumIsOrNoStatus;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.PassengerFlow;
import com.unicdata.entity.customer.TestDrive;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.customer.TestDriveService;
import com.unicdata.service.passengerflow.PassengerFlowService;
import com.unicdata.service.push.PushMessageService;
import com.unicdata.util.JPushUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Controller
@RequestMapping("/app/testDriver")
@Api(value = "试乘试驾接口", tags = { "试乘试驾接口" })
public class TestDriveController extends HomeBaseController{
	
	@Autowired
	private TestDriveService testDriveService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private PassengerFlowService passengerFlowService;
	// 文件上传路径
	@Value("${upload.file.path}")
	private String uploadFilePath;
	// 图片上传路后缀
	@Value("${upload.picture.type}")
	private String uploadPictureType;
	//图片上传大小
	private static final long  size=4194304;
	@Autowired
	private PushMessageService pushMessageService;
	/**
	 * 开始试驾wp
	 * @param request
	 * @param carType
	 * @param employeeId
	 * @param driversLicense
	 * @param agreement
	 * @param passengerId
	 * @return
	 */
	@RequestMapping(value="/startTestDrive",method = {RequestMethod.POST})
	@ResponseBody
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "", value = "", required = true, dataType = "integer"),
	     @ApiImplicitParam(name = "", value = "", required = true, dataType = "integer"),
	     @ApiImplicitParam(name = "", value = "", required = true, dataType = "integer"),
	     @ApiImplicitParam(name = "", value = "", required = true, dataType = "integer")
	})
	public ApiReturnInfo startTestDrive(
			HttpServletRequest request,
			Integer carType,//车系ID
			Integer testCarId,//？？
			Integer employeeId,
			String chexingName,//车牌号加车系名称
			Integer passengerId,//客流ID
			String driversLicense,
			String agreement
			){
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	Customer customer=new Customer();
    	TestDrive testDrive=new TestDrive();
    	//获取客流信息 判断是否存在cusid
    	PassengerFlow passengerFlowExist=passengerFlowService.getPassengerFlowById(passengerId);
    	Integer cusid=passengerFlowExist.getCusId();
    	testDrive.setEmployeeId(emp.getId());//创建试驾人ID
    	testDrive.setCreateTime(new Date());
    	testDrive.setStatus(TestDriveStatus.试驾中1.getCode());
    	testDrive.setVehicleId(carType);
    	testDrive.setVehicleName(chexingName);
    	testDrive.setDriversLicense(driversLicense);
    	testDrive.setAgreement(agreement);
    	testDrive.setTestCarId(testCarId);
    	testDrive.setSalesmanId(employeeId);//销售顾问ID
    	//添加试驾信息
    	int i=testDriveService.startTestDrive(testDrive);
    	 //极光推送至销售顾问
    	if (i>0) {
    		/*Map<String, String> msgType = new HashMap<String, String>();
	        msgType.put("code", MessageCode.MESSAGE_NEW_TESTDRIVE);//前台发起新客流
	        msgType.put("message", MessageCode.resultCodeMap.get(MessageCode.MESSAGE_NEW_TESTDRIVE));
	        String alias = StringUtil.md5(Constant.APP_ALIAS + employeeId);//发送至销售顾问
	        String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_NEW_TESTDRIVE);
	        //推送消息
	        JPushUtils.sendAlias(content, msgType, alias);*/
    		String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_NEW_TESTDRIVE);
             String title=PushType.CUSTOMER_TEST_DRIVE.getDesc();
             Integer types=PushType.CUSTOMER_TEST_DRIVE.getCode();//??
             Integer createId=emp.getId();
             List<Map<String, Object>> receivers=new ArrayList<>();//发送对象
             Map<String, Object> puempMap=new HashMap<>();
             puempMap.put("employeeId", employeeId);
//             puempMap.put("urlId", "");
             puempMap.put("terminal", PushTerminal.MOBILE.getCode());
             receivers.add(puempMap);
             pushMessageService.createPushMessage(types, title, content, createId, receivers);
		}
    	try {
    		if (cusid ==null) {//cusid为空时
        		//如果客户为空则生成客户
            	customer.setPassengerId(passengerId);
            	Integer empInteger=null; 
            	if (passengerFlowExist !=null) {
            		empInteger=passengerFlowExist.getReplaceEmployeeId();
				}
            	if (empInteger !=null) {
            		customer.setEmployeeId(empInteger);
				}else {
					customer.setEmployeeId(employeeId);
				}
            	String number="KH"+StringUtil.getSixCode();
            	customer.setNumber(number);
            	customer.setStoreId(storeId);
            	customer.setCreateTime(new Date());
            	//试驾生成客户
            	int i1=testDriveService.insertCustomerByTestDrive(customer);
            	Integer cusId=customer.getId();
            	Integer testId=testDrive.getId();
            	TestDrive testDrive2=new TestDrive();
            	testDrive2.setCusId(cusId);
            	testDrive2.setId(testId);
            	//将客户ID添加至试乘试驾(更新)
            	int i2=testDriveService.updateTestDrive(testDrive2);
            	//将客户id添加至客流列表
            	PassengerFlow passengerFlow=new PassengerFlow();
            	passengerFlow.setCusId(cusId);
            	passengerFlow.setId(passengerId);
            	passengerFlow.setStatus(2);//接待中
            	int i3=passengerFlowService.changeSellMan(passengerFlow);
    		}else {//客户ID不为空时
    			TestDrive testDrive2=new TestDrive();
            	testDrive2.setCusId(cusid);
            	testDrive2.setId(testDrive.getId());
            	//将客户ID添加至试乘试驾(更新)
            	int i2=testDriveService.updateTestDrive(testDrive2);
            	PassengerFlow passengerFlow=new PassengerFlow();
            	passengerFlow.setId(passengerId);
            	passengerFlow.setStatus(2);//接待中
            	//客户对应的销售顾问是否替岗
            	Integer empInteger=passengerFlowExist.getReplaceEmployeeId();
            	if (empInteger !=null) {
            		customer.setEmployeeId(empInteger);
            		//将客户表对应的销售顾问换为
            		customer.setId(cusid);
            		int k=customerService.updateByPrimaryKeySelective(customer);
				}
    		}
		} catch (Exception e) {
			ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		}
    	Map<String, Object> map=new HashMap<String, Object>();
    	map.put("status", testDrive.getStatus());//试驾状态
    	map.put("id", testDrive.getId());//试驾ID
    	map.put("cusId", customer.getId());//客户ID
    	ar.setData(map);
		return ar;
	}
	
	/**
	 * 试驾结束 wp
	 * @param request
	 * @return
	 */
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "", value = "替岗ID", required = true, dataType = "integer"),
	     @ApiImplicitParam(name = "", value = "换销售ID", required = true, dataType = "integer"),
	     @ApiImplicitParam(name = "", value = "换销售ID", required = true, dataType = "integer"),
	     @ApiImplicitParam(name = "", value = "客流ID", required = true, dataType = "integer")
	})
	@RequestMapping(value="/endTestDrive",method = {RequestMethod.POST})
	@ResponseBody
	public ApiReturnInfo endTestDrive(
			HttpServletRequest request,
			Integer cusid,
			Integer employeeId
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	TestDrive testDrive=new TestDrive();
    	testDrive.setStatus(TestDriveStatus.已试驾2.getCode());//已试驾
    	testDrive.setEndTime(new Date());
    	//通过cusid 和employeeId判断试驾ID
    	Map<String, Object> map=new HashMap<>();
    	map.put("cusid", cusid);
    	map.put("employeeId", employeeId);
    	Map<String, Object> testdMap=testDriveService.selectTestDriveId(map);
    	if (testdMap!=null) {
    		testDrive.setId((Integer) testdMap.get("id"));
		}
    	int i=testDriveService.updateTestDrive(testDrive);
    	if(i<=0) {
    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
    	}else {
    		/*//极光推送至销售顾问 提醒完善试驾信息
    		Map<String, String> msgType = new HashMap<String, String>();
 	        msgType.put("code", MessageCode.MESSAGE_END_TESTDRIVE);//前台发起新客流
 	        msgType.put("message", MessageCode.resultCodeMap.get(MessageCode.MESSAGE_END_TESTDRIVE));
 	        String alias = StringUtil.md5(Constant.APP_ALIAS + employeeId);//发送至销售顾问
 	        String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_END_TESTDRIVE);
 	        //推送消息
 	        JPushUtils.sendAlias(content, msgType, alias);*/
    		String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_END_TESTDRIVE);
            String title=PushType.CUSTOMER_TEST_DRIVE.getDesc();
            Integer types=PushType.CUSTOMER_TEST_DRIVE.getCode();//??
            Integer createId=emp.getId();
            List<Map<String, Object>> receivers=new ArrayList<>();//发送对象
            Map<String, Object> puempMap=new HashMap<>();
            puempMap.put("employeeId", employeeId);
//            puempMap.put("urlId", "");
            puempMap.put("terminal", PushTerminal.MOBILE.getCode());
            receivers.add(puempMap);
            pushMessageService.createPushMessage(types, title, content, createId, receivers);
		}
    	ar.setData(testDrive.getStatus());
    	return ar;
	}
	
	@ApiOperation(value = "试驾信息提交")
    @ApiImplicitParams({
        	@ApiImplicitParam(name = "testDriveId", value = "试驾记录id", required = true, dataType = "Integer"),
        	@ApiImplicitParam(name = "customerId", value = "客户id", required = true, dataType = "Integer"),
        	@ApiImplicitParam(name = "sex", value = "性别", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "客户姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "客户手机", required = true, dataType = "String"),
            @ApiImplicitParam(name = "driveMileage", value = "行驶里程", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "endMileage", value = "结束里程", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/submit",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo testDrive(Integer testDriveId,Integer customerId, 
    		Integer driveMileage,Integer endMileage, Customer customer) {
        ApiReturnInfo ari = new ApiReturnInfo();
        //修改试驾
        TestDrive testDrive = new TestDrive();
        if(null != testDriveId){
        	testDrive.setId(testDriveId);
        }/*else{
        	Map<String,Object> params = new HashMap<String,Object>();
            params.put("cusId", customerId);
            params.put("status", TestDriveStatus.试驾中1.getCode());
            params.put("perfect_state", enumIsOrNoStatus.否.getId());
            TestDrive td = testDriveService.getTestDrivesByMap(params);
            if(td!=null){
    	        testDrive.setId(td.getId());
    	        testDrive.setPerfectState(enumIsOrNoStatus.是.getId());
            }else{
            	ari.setCode(ResultCodeEnum.RESULT_CODE_TEST_DRIVER_NO_EXISTENT.getCode());
            	ari.setMessage(ResultCodeEnum.RESULT_CODE_TEST_DRIVER_NO_EXISTENT.getMessage());
            	ari.setData(null);
                return ari;
            }
        }*/
        testDrive.setCusId(customerId);
        testDrive.setDriveMileage(driveMileage);
        testDrive.setEndMileage(endMileage);
        testDrive.setPerfectState(enumIsOrNoStatus.是.getId());
        testDriveService.updateTestDrive(testDrive);
        //编辑用户档案
        customer.setId(customerId);
        Customer tempCustomer = customerService.selectByPrimaryKey(customerId);
        customer.setPassengerId(tempCustomer.getPassengerId());
        customerService.updateCustomer(customer,null);
        //完善客流是否留档状态
        PassengerFlow tempPf = new PassengerFlow();
        tempPf.setId(tempCustomer.getPassengerId());
        tempPf.setIsArchives(enumIsOrNoStatus.是.getId());
        passengerFlowService.updateByPrimaryKeySelective(tempPf);
        ari.setData(null);
        return ari;
    }
	
	@ApiOperation(value = "查询客户未完善资料的试驾记录")
    @ApiImplicitParams({
        	@ApiImplicitParam(name = "cusId", value = "客户id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/getTestDriveRecord",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo getTestDriveRecord(TestDrive record) {
        ApiReturnInfo ari = new ApiReturnInfo();
    	Map<String,Object> params = new HashMap<String,Object>();
        params.put("cusId", record.getCusId());
        params.put("perfect_state", enumIsOrNoStatus.否.getId());
        List<TestDrive> list = testDriveService.getTestDriveListByMap(params);
        //当前用户信息
        Customer temp = new Customer();
        temp.setId(record.getCusId());
        Customer customer = customerService.selectCustomer(temp);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", customer.getName());
        map.put("phone", customer.getPhone());
        map.put("sex", customer.getSex());
        map.put("testDriveList", list);
        ari.setData(map);
        return ari;
    }
	
}
