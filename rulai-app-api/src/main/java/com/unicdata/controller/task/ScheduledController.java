package com.unicdata.controller.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unicdata.base.constant.Constant;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.MessageCode;
import com.unicdata.entity.customer.PassengerFlow;
import com.unicdata.service.employee.AppEmployeeService;
import com.unicdata.service.passengerflow.PassengerFlowService;
import com.unicdata.service.system.AppPushMessageService;
import com.unicdata.util.IPUtil;
import com.unicdata.util.JPushUtils;

@Component
public class ScheduledController {
	private static final Log log = LogFactory.getLog(ScheduledController.class);
	
	@Value("${SALES_CONSULTANT_POSITION}")
	public String SALES_CONSULTANT_POSITION;
	@Value("${spring.profiles.active}")
	private String springProfilesActive;
	@Value("${jobIp}")
	private String jobIp;
	
	@Autowired
    private AppEmployeeService employeeService;
	@Autowired
    private PassengerFlowService passengerFlowService;
	@Autowired
    private AppPushMessageService appPushMessageService;
	
	/**
	 * 定时批量发送短信问候
	 */
	@Scheduled(cron = "0 0/2 * * * ?")
	public void pushDataScheduled(){
		try {
			if (IPUtil.isLocalIp(jobIp) && !springProfilesActive.equals("dev")){
				log.info("定时任务开始----------------------------");
			    Date date = new Date();
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String formatDataStr = sdf.format(date);
		        System.out.println("当前时间："+formatDataStr);
			    log.info("定时任务结束----------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将所有员工状态置空
	 */
	@Scheduled(cron = "0 30 23 * * ?")
	public void updateEmployeeStatus(){
		try {
			if (IPUtil.isLocalIp(jobIp) && !springProfilesActive.equals("dev")){
			    log.info("修改员工状态定时任务开始----------------------------");
			    int res = employeeService.updateEmpStatusByPostName(SALES_CONSULTANT_POSITION);
			    if(res>0){
				    log.info("success-----------------------------------------");
			    }
			    log.info("修改员工状态定时任务结束----------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改替岗数据员工id
	 */
	@Scheduled(cron = "0 30 23 * * ?")
	public void updateReplacePostData(){
		try {
			if (IPUtil.isLocalIp(jobIp) && !springProfilesActive.equals("dev")){
			    log.info("修改替岗数据定时任务开始----------------------------");
			    PassengerFlow record = new PassengerFlow();
			    record.setReplaceEmployeeId(0);
			    record.setCreateTime(new Date());
			    List<PassengerFlow> list = passengerFlowService.selectPassengerFlowMes(record);
			    for(PassengerFlow pf:list){
			    	int res = passengerFlowService.updateReplacePostData(pf);
			    	log.info("updateReplacePostData result:"+res+",客流id："+pf.getId());
			    }
			    log.info("修改替岗数据定时任务结束----------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 推送极光消息
	 */
	@Scheduled(cron = "0/10 * * * * ?")
	public void pushMessage(){
		try {
			if (IPUtil.isLocalIp(jobIp) && !springProfilesActive.equals("dev")){
			    log.info("推送极光消息定时任务开始----------------------------");
			    List<Map<String, Object>> list = appPushMessageService.getPushMessageList();
			    for(Map<String, Object> map:list){
			    	String messageId = String.valueOf(map.get("id"));
			    	String employeeId = String.valueOf(map.get("employeeId"));
			    	String content = String.valueOf(map.get("content"));
			    	String type = String.valueOf(map.get("type"));
			    	//测试极光推送
			        Map<String, String> msgType = new HashMap<String, String>();
			        msgType.put("type", type);
			        msgType.put("messageId", messageId);
			        msgType.put("message", content);
			        String alias = StringUtil.md5(Constant.APP_ALIAS + employeeId);
			        //推送消息
			        JPushUtils.sendAlias(content, msgType, alias);
			    }
			    if(list!=null && list.size()>0){
			    	appPushMessageService.updateBatch(list);
			    }
			    log.info("推送极光消息定时任务结束----------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
