package com.unicdata.configuration;

import com.alibaba.druid.util.StringUtils;
import com.unicdata.interceptors.TokenInterceptors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * 拦截器配置
 *
 */
@Configuration
public class InterceptorsConfigurer extends WebMvcConfigurationSupport {
	
	@Value("${spring.profiles.active}")
	private String springProfilesActive;

	@Bean
	public TokenInterceptors tokenInterceptors() {
		return new TokenInterceptors();
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
		if(!StringUtils.equals(springProfilesActive, "dev")){
			// 所有访问请求
			 registry.addInterceptor(tokenInterceptors()).addPathPatterns("/**");
			 // 不拦截以下
//			 .excludePathPatterns("/");

			super.addInterceptors(registry);
		}
	}
}
