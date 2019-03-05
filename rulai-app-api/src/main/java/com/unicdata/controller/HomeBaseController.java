package com.unicdata.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.Constant;
import com.unicdata.base.util.StringUtil;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.system.EmployeeService;
import com.unicdata.util.PageResult;
import com.unicdata.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前台控制器
 */
public class HomeBaseController extends BaseController {
	
	@Value("${spring.profiles.active}")
	private String springProfilesActive;
	/**
	 * 前台
	 */
	@Value("${RECEPTION_POSITION}")
	public String RECEPTION_POSITION;
	/**
	 * 库管
	 */
	@Value("${STOREHOUSE}")
	public String STOREHOUSE;
	/**
	 * 销售顾问
	 */
	@Value("${SALES_CONSULTANT_POSITION}")
	public String SALES_CONSULTANT_POSITION;
	/**
	 * 销售经理
	 */
	@Value("${SALES_MANAGER_POSITION}")
	public String SALES_MANAGER_POSITION;
	/**
	 * 展厅经理
	 */
	@Value("${SHOWROOM_MANAGER_POSITION}")
	public String SHOWROOM_MANAGER_POSITION;
	/**
	 * 精品经理
	 */
	@Value("${BOUTIQUE_MANAGER_POSITION}")
	public String BOUTIQUE_MANAGER_POSITION;
	/**
	 * 总经理
	 */
	@Value("${TOP_MANAGER}")
	public String TOP_MANAGER;
	/**
	 * 销售服务
	 */
	@Value("${SALES_SERVICE}")
	public String SALES_SERVICE;
	/**
	 * 财务部经理
	 */
	@Value("${FINANCIAL_MANAGER}")
	public String FINANCIAL_MANAGER;
	/**
	 * 销售信息员
	 */
	@Value("${SALES_INFORMATION_OFFICER}")
	public String SALES_INFORMATION_OFFICER;
	/**
	 * 精品信息员
	 */
	@Value("${BOUTIQUE_INFORMATION_OFFICER}")
	public String BOUTIQUE_INFORMATION_OFFICER;

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 返回后台用户信息
	 * @return
	 */
	public Employee getMember(HttpServletRequest request){
		Object object = request.getSession().getAttribute(Constant.EMPLOYEE_INFO);
		if(null == object){
			if(StringUtils.equals(springProfilesActive, "dev")){
				Employee employee = employeeService.selectByPrimaryKey(2);
				employee.setPwd(null);
				request.getSession().setAttribute(Constant.EMPLOYEE_INFO, employee);
				return employee;
			}else{
				return null;
			}
		}
		Employee employee = null;
		if(object instanceof Employee){
			employee = (Employee) object;
		}else{
			JSONObject json = JSON.parseObject(object.toString());
			employee = JSONObject.toJavaObject(json,Employee.class);
		}
		return employee;
	}
	
	/**
	 * 设置信息
	 */
	public void setMember(HttpServletRequest request,Employee employee,String token){
		request.getSession().setAttribute("token", token);
		request.getSession().setAttribute(Constant.EMPLOYEE_INFO, JSONObject.toJSONString(employee, Constant.FEATURES));
		RedisUtil.setex(token, JSONObject.toJSONString(employee, Constant.FEATURES), 18000);
	}

	/**
	 * 清除缓存
	 */
	public void clearMember(HttpServletRequest request){
		request.getSession().removeAttribute(Constant.EMPLOYEE_INFO);//清空session信息
		request.getSession().removeAttribute("token");
	}
	
	/**
	 * 校验token
	 */
	public boolean tokenValid(HttpServletRequest request,String token){
		/*Object object = request.getSession().getAttribute(Constant.EMPLOYEE_INFO);
		String valid = request.getSession().getAttribute("token")!=null?request.getSession().getAttribute("token").toString():"";
		if(StringUtils.isBlank(valid) || null == object){
			return false;
		}*/
		String str = RedisUtil.get(token);
		JSONObject jsonObj = JSON.parseObject(str);
		Employee employee = JSONObject.toJavaObject(jsonObj,Employee.class);
		/*Employee employee = new Employee();
		BeanUtils.copyProperties(employee,str);*/
//		Employee employee = (Employee)object;
		if(/*StringUtils.equals(token, valid) &&*/ employee != null){
			setMember(request, employee, token);
		}else{
			return false;
		}
		return true;
	}
	//分页信息
	public static PageResult getPageResult(PageInfo pageInfo) {
		PageResult page = new PageResult();
		BeanUtils.copyProperties(pageInfo,page);
		return page;
	}
	
	public Map<String,Object> getPostMap(){
		//岗位
		Map<String,Object> postMap = new HashMap<String,Object>();
		postMap.put("reception", RECEPTION_POSITION);
		postMap.put("storeHouse", STOREHOUSE);
		postMap.put("salesConsultant", SALES_CONSULTANT_POSITION);
		postMap.put("salesManager", SALES_MANAGER_POSITION);
		postMap.put("showroomManager", SHOWROOM_MANAGER_POSITION);
		postMap.put("boutiqueManager", BOUTIQUE_MANAGER_POSITION);
		postMap.put("topManager", TOP_MANAGER);
		return postMap;
	}
	/**
	 * 获取数据字典名称
	 * @param dictionaryMap
	 * @param type
	 * @param key
	 * @return
	 */
	public String getDictionaryName(Map<Integer, List<Map<String, Object>>> dictionaryMap, Integer type, String key) {
		if(StringUtil.isNotBlank(key)){
			List<Map<String, Object>> dicList = dictionaryMap.get(type);
	        for (Map<String, Object> dic : dicList) {
	            String dicKey = String.valueOf(dic.get("key"));
	            if (dicKey.equals(key)) {
	                return String.valueOf(dic.get("value"));
	            }
	        }
		}
        return "";
    }
}
