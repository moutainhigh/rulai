package com.unicdata.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.base.constant.Constant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.controller.HomeBaseController;


/**
 * 登录监听器
 * @author 申勇
 * @date 2017年12月18日
 */
@Component
public class LoginInterceptors implements HandlerInterceptor{
	
	//当request处理完成后被调用
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception arg3)throws Exception {
	}

	//在handler被执行后被调用
	public void postHandle(HttpServletRequest request, HttpServletResponse response,Object arg2, ModelAndView arg3) throws Exception {
	}

	//在实际的handler被执行前被调用
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object arg2) throws Exception {
		// 设置session失效时间,单位秒
		request.getSession().setMaxInactiveInterval(18000);
		ApiReturnInfo ari = new ApiReturnInfo();
		//判断账号是否登录
		String token = request.getHeader("token");
		System.out.println("token=============================="+token);
		if(StringUtil.isBlank(token)){
			//返回信息
			ari.setCode(ResultCodeEnum.RESULT_CODE_PARAM_TOKEN_NULL.getCode());
			ari.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_TOKEN_NULL.getMessage());
			response.setContentType(Constant.RESPONSE_JSON);
			response.getWriter().write(JSONObject.toJSONString(ari));
			return false;
		}else{
			//验证token
			boolean flag = new HomeBaseController().tokenValid(request, token);
			if(!flag){
				ari.setCode(ResultCodeEnum.RESULT_CODE_PARAM_TOKEN_INVALID.getCode());
	    		ari.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_TOKEN_INVALID.getMessage());
	    		response.setContentType(Constant.RESPONSE_JSON);
				response.getWriter().write(JSONObject.toJSONString(ari));
	    		return false; 
			}
		}
		
//		//获取请求方法
//		String memberStr = CookieUtil.getValue(request, Constant.MEMBER_INFO);
//		if(StringUtils.isBlank(memberStr)){
//			String requested = request.getHeader("X-Requested-With");//获取异步请求参数
//			if(StringUtils.isBlank(requested)){//判断是否是异步请求
//				//获取请求地址
//				String url = request.getRequestURI();
//				if(StringUtils.startsWith(url, "/")){
//					url = request.getRequestURI().substring(1);
//				}
//				String queryString = request.getQueryString();
//				if(StringUtils.isNotBlank(queryString)){
//					url += "?"+request.getQueryString();
//				}
//				request.getSession().setAttribute(Constant.MEMBER_REDIRECT, url);
//				response.sendRedirect("/login");//重定向到login控制器去
//			}else{
//				response.setContentType(Constant.RESPONSE_JSON);
//				response.getWriter().write("1000");
//			}
//			return false;
//		}
		return true;
	}
}
