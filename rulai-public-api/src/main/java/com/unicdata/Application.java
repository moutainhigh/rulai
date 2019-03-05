package com.unicdata;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.unicdata.base.constant.Constant;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.nio.charset.Charset;

/**
 * 启动类
 * @author 申勇
 * @date 2017年8月4日
 */
@SpringBootApplication
@MapperScan(basePackages="com.unicdata.dao")//扫描Mapper文件
@EnableTransactionManagement//开启注解式事务
public class Application{
    /**
     * Bean注解 注入第三方的json解析框架
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        //1、需要先定义一个 convert 转换消息对象；
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        fastConverter.setFeatures(Constant.FEATURES);
        fastConverter.setCharset(Charset.forName("UTF-8"));
        return new HttpMessageConverters(fastConverter);
    }
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}