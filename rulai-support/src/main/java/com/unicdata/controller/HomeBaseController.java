package com.unicdata.controller;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.base.constant.Constant;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.system.EmployeeService;
import com.unicdata.shrio.MyAuthorizationFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

/**
 * 前台控制器
 */
public class HomeBaseController extends BaseController {
	
	@Value("${spring.profiles.active}")
	private String springProfilesActive;
	/**
	 * 客服职位 ：销售顾问
	 */
	@Value("${SALES_CONSULTANT_POSITION}")
	public String SALES_CONSULTANT_POSITION;
	/**
	 * 客服职位 ：销售经理
	 */
	@Value("${SALES_MANAGER_POSITION}")
	public String SALES_MANAGER_POSITION;
	/**
	 * 客服职位 ：展厅经理
	 */
	@Value("${SHOWROOM_MANAGER_POSITION}")
	public String SHOWROOM_MANAGER_POSITION;
	/**
	 * 客服职位 ：总经理
	 */
	@Value("${TOP_MANAGER}")
	public String TOP_MANAGER;

	//财务
	@Value("${FINANCE_POSITION}")
	public String financePosition;
	//保险专员
	@Value("${INSURANCE_SPECIALIST_POSITION}")
	public String insuranceSpecialistPosition;
	//金融专员
	@Value("${FINANCE_POSITION}")
	public String financialSpecialistPosition;
	//信息员
	@Value("${FINANCE_POSITION}")
	public String informationMemberPosition;
	//销售库管
	@Value("${STOREHOUSE}")
	public String storehouse;
	/**
	 *财务部经理
	 */
	@Value("${FINANCE_MANAGER}")
	public String FINANCE_MANAGER;


	@Autowired
	private EmployeeService employeeService;

	private static final Logger logger = LoggerFactory.getLogger(MyAuthorizationFilter.class);
	
	/**
	 * 返回后台用户信息
	 * @return
	 */
	public Employee getMember(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		Object object = subject.getPrincipal();
		if(null == object){
			if(StringUtils.equals(springProfilesActive, "dev")){
				Employee employee = employeeService.selectByPrimaryKey(1);
				employee.setPwd(null);
				return employee;
			}else{
				return null;
			}
		}
		return (Employee) object;
	}

}
