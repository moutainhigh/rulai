package com.unicdata.configaration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * 配置swagger页面不被拦截器拦截
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.druid.util.StringUtils;
import com.unicdata.interceptors.BaseInterceptors;

/**
 * 拦截器配置
 */
@Configuration
public class InterceptorsConfigurer extends WebMvcConfigurationSupport {
	
	@Value("${spring.profiles.active}")
	private String springProfilesActive;

	@Bean
	public BaseInterceptors baseInterceptors() {
		return new BaseInterceptors();
	}

	/**
	 * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
	 * 
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if(!StringUtils.equals(springProfilesActive, "pro")) {
			registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
			registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
			super.addResourceHandlers(registry);
		}
	}

	/**
	 * 配置servlet处理
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		if(!StringUtils.equals(springProfilesActive, "dev")){
			// 多个拦截器组成一个拦截器链
			// addPathPatterns 用于添加拦截规则
			// excludePathPatterns 用户排除拦截
//			registry.addInterceptor(baseInterceptors()).addPathPatterns("/**");

			// 所有访问请求
//			 registry.addInterceptor(tokenInterceptors())
//			 .addPathPatterns("/**")
			 // 不拦截地址
//			 .excludePathPatterns("/**");
			// 登录
			// .excludePathPatterns("/bms/login");
			 
//			super.addInterceptors(registry);
//		}
	}
}
