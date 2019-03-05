package com.unicdata.interceptors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器拦截 token验证
 * @author Administrator
 *
 */
public class TokenInterceptors implements HandlerInterceptor {

	@Value("${URL_APPRAISE}")
	private String URL_APPRAISE;

	// 当request处理完成后被调用
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

	// 在handler被执行后被调用
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	// 在实际的handler被执行前被调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
//		String sign = request.getParameter("sign");
//		String path = request.getServletPath();
//		try {
//			if (StringUtils.isNotBlank(sign) && !"null".equals(sign)) {
//				long signMillis = HashIdsHelper.decode(sign,-1);
//				if( signMillis < 0){
//					logger.warn(path+":sign认证失败");
//					response.sendRedirect(URL_APPRAISE + "/api/error/security?tmpStr="+System.currentTimeMillis());
//					return false;
//				}
//				if (Math.abs(System.currentTimeMillis() - signMillis) <= 3*60*1000) {
//					return true;
//				}else{
//					logger.warn(path+":sign已过期");
//					response.sendRedirect(URL_APPRAISE + "/api/error/securityMillis?tmpStr="+System.currentTimeMillis());
//					return false;
//				}
//			} else {
//				logger.warn(path+":认证失败,没有传递sign");
//				response.sendRedirect(URL_APPRAISE + "/api/error/securitySign?tmpStr="+System.currentTimeMillis());
//				return false;
//			}
//		} catch (Exception e) {
//			logger.error(path+":"+sign+":",e);
//			response.sendRedirect(URL_APPRAISE + "/api/error/exception?tmpStr="+System.currentTimeMillis());
//			return false;
//		}
		return true;
	}

}
