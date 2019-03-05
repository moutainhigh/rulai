package com.unicdata.configuration;

import com.alibaba.druid.util.StringUtils;
import com.unicdata.interceptors.LoginInterceptors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * 拦截器配置
 * @author 申勇
 * @date 2017年8月4日
 */
@Configuration
public class InterceptorsConfigurer extends WebMvcConfigurationSupport {

    @Value("${spring.profiles.active}")
    private String springProfilesActive;

    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }


	@Override
    public void addInterceptors(InterceptorRegistry registry) {
//        if(!StringUtils.equals(springProfilesActive, "pro")) {
        if(!StringUtils.equals(springProfilesActive, "dev")) {
            // 多个拦截器组成一个拦截器链
            // addPathPatterns 用于添加拦截规则
            // excludePathPatterns 用户排除拦截
            //前台登录
            registry.addInterceptor(new LoginInterceptors())
                    .addPathPatterns("/**").excludePathPatterns("/app/login");
            super.addInterceptors(registry);
        }
    }
}
