package com.unicdata.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.util.StringUtils;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * 极光推送
 */
public class JPushUtils {
	private static transient final Logger log = LoggerFactory.getLogger(JPushUtils.class);

	private static JPushClient jpushClient = SpringContextUtil.getBean("jpushClient", JPushClient.class);

	/**
	 * 全平台发送,不区分ios，android
	 * 
	 * @param msg
	 *            信息
	 * @param msgType
	 *            类型(扩展用)
	 * @param alias
	 *            别名
	 */
	public static void sendAlias(String msg, Map<String,String> msgType,String... alias) {
		PushPayload payload = buildPushObject_all_alias_alert(msg, msgType,alias);
		PushResult result = null;
		try {
			result = jpushClient.sendPush(payload);
		} catch (Exception e) {
			log.error("send failed", e);
		}
		log.info("send result - " + result);
	}

	/**
	 * 全平台发送,不区分ios，android
	 * 
	 * @param msg
	 *            信息
	 * @param msgType
	 *            类型(扩展用)
	 * @param alias
	 *            别名
	 */
	private static PushPayload buildPushObject_all_alias_alert(String msg, Map<String,String> msgType,String... alias) {
		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(alias))
				.setNotification(Notification.newBuilder()
						.addPlatformNotification(AndroidNotification.newBuilder().setAlert(msg).setTitle(msg)
								// 此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
								.addExtras(msgType).build())
						.addPlatformNotification(IosNotification.newBuilder()
								// 传一个IosAlert对象，指定apns title、title、subtitle等
								.setAlert(msg)
								// 直接传alert
								// 此项是指定此推送的badge自动加1
								.incrBadge(1)
								// 此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
								.addExtras(msgType).build())
						.build())
				.setOptions(Options.newBuilder().setApnsProduction(false).build()).build();
	}
	
	/**
	 * 全平台发送,不区分ios，android
	 * 
	 * @param msg
	 *            信息
	 * @param msgType
	 *            类型(扩展用)
	 * @param tag
	 *            组别
	 */
	public static void sendTag(String msg, Map<String,String> msgType,String... tag) {
		PushPayload payload = buildPushObject_all_tag_alert(msg, msgType,tag);
		PushResult result = null;
		try {
			result = jpushClient.sendPush(payload);
		} catch (Exception e) {
			log.error("send failed", e);
		}
		log.info("send result - " + result);
	}
	
	/**
	 * 全平台发送,不区分ios，android
	 * 
	 * @param msg
	 *            信息
	 * @param msgType
	 *            类型(扩展用)
	 * @param tag
	 *            组别
	 */
	private static PushPayload buildPushObject_all_tag_alert(String msg, Map<String,String> msgType,String... tag) {
		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.tag(tag))
				.setNotification(Notification.newBuilder()
						.addPlatformNotification(AndroidNotification.newBuilder().setAlert(msg).setTitle(msg)
								// 此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
								.addExtras(msgType).build())
						.addPlatformNotification(IosNotification.newBuilder()
								// 传一个IosAlert对象，指定apns title、title、subtitle等
								.setAlert(msg)
								// 直接传alert
								// 此项是指定此推送的badge自动加1
								.incrBadge(1)
								// 此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
								.addExtras(msgType).build())
						.build())
				.setOptions(Options.newBuilder().setApnsProduction(false).build()).build();
	}
}
