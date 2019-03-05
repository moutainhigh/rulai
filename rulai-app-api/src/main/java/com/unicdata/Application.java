package com.unicdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 启动类
 * @author 申勇
 * @date 2017年8月4日
 */
@SpringBootApplication
@MapperScan(basePackages="com.unicdata.dao")//扫描Mapper文件
@EnableTransactionManagement//开启注解式事务
public class Application{

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
