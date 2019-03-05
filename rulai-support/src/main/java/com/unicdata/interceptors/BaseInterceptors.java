package com.unicdata.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.unicdata.base.constant.Constant;

/**
 * 登录监听器
 * @author 申勇
 * 
 * 2015年8月6日 下午3:31:41
 */
public class BaseInterceptors implements HandlerInterceptor{
	
	//当request处理完成后被调用
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception arg3)throws Exception {
	}

	//在handler被执行后被调用
	public void postHandle(HttpServletRequest request, HttpServletResponse response,Object arg2, ModelAndView arg3) throws Exception {
		request.setAttribute(Constant.BASE_PATH, request.getContextPath());
	}

	//在实际的handler被执行前被调用
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object arg2) throws Exception {
		return true;
	}
}
