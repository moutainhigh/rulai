package com.unicdata.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by shenyong on 2018/5/29.
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig{

}
