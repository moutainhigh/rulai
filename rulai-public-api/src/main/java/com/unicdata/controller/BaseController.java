package com.unicdata.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.unicdata.base.constant.Constant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础Controller
 * @author shenyong
 * @date 2018-05-28
 */
public class BaseController {
	
	/**
	 * 获取request
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	/**
	 * 获得session
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		return getRequest().getSession(true);
	}

	/**
	 * 获得绝对路径
	 * 
	 * @param path
	 * @return
	 */
	public static String getRealPath(String path) {
		return getSession().getServletContext().getRealPath(path);
	}
	
	/**
	 * 获取spring配置
	 */
	public static ApplicationContext getSpringConfig(){
		ApplicationContext context = new FileSystemXmlApplicationContext(getRealPath("WEB-INF/classes/spring-servlet.xml")); 
		return context;
	}
	
	//改变autoGrowCollectionLimit值的大小，默认256  传入List大小是256
	@InitBinder  
    protected void initBinder(WebDataBinder binder) {  
        binder.setAutoGrowNestedPaths(true);  
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);  
    }
	
	/**
	 * 返回页面信息
	 **/
	public static<T> String toPageJson(Page<T> page) {
		Map<String,Object> json = new HashMap<String, Object>();
		json.put("list",page.getResult());
		json.put("currentPage",page.getPageNum());
		json.put("allPages",page.getPages());
		json.put("rows",page.getTotal());
		json.put("pageSize",page.getPageSize());
		json.put("total", page.getTotal());
		return JSON.toJSONString(json,Constant.FEATURES);
	}
}
