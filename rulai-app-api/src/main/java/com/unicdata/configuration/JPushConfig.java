package com.unicdata.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;

/**
 * 极光推送
 */
@Configuration
public class JPushConfig{

	@Value("${jPush.appKey}")
	private String jPushAppkey;

	@Value("${jPush.masterSecret}")
	private String jPushMasterSecret;
    
    @Bean(name = "jpushClient")
    public JPushClient jpushClientFactory() {
    	System.out.println("JPushClient key="+jPushAppkey);
    	ClientConfig clientConfig = ClientConfig.getInstance();
    	JPushClient jpushClient = new JPushClient(jPushMasterSecret, jPushAppkey, null, clientConfig);
        return jpushClient;
    }
}
