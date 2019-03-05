package com.unicdata.base.constant;

import com.alibaba.fastjson.serializer.SerializerFeature;

/***
 * 系统全局常量
 * 
 * @author 许兵
 * @date 2013-03-05 19:17:14
 */
public interface Constant {

	// 网站基础路径
	public static final String BASE_PATH = "BASE_PATH";
	// 版本
	public static final String VERSION = "version";
	// 会员信息
	public static final String MEMBER_INFO = "member_info";
	// 选购车辆订单信息
	public static final String CHOOSE_BUY_CAR = "choose_buy_car";
	// 员工积分商城员工信息
	String STAFF_INFO = "staff_info";
	// 后台用户信息
	public static final String EMPLOYEE_INFO = "employee_info";
	// 会员重定向请求地址
	public static final String MEMBER_REDIRECT = "MEMBER_REDIRECT";
	// 微信会员信息
	public static final String MEMBER_WECHAT_INFO = "member_wechat_info";
	// 微信集团信息
	public static final String DISTRIBUTOR_WECHAT_INFO = "distributor_wechat_info";
	// 向客户端输出JSON格式
	public static final String RESPONSE_JSON = "text/json;charset=UTF-8";
	// 向客户端输出html格式
	public static final String RESPONSE_HTML = "text/html;charset=UTF-8";
	// 向客户端输入plain格式
	public static final String RESPONSE_PLAIN = "text/plain;charset=UTF-8";
	// 字符串格式 utf-8
	public static final String CHARSET_UTF_8 = "UTF-8";
	//日志名称
    public static final String LOGGER_NAME = "basedata";
    //app极光推送别名
    public static final String APP_ALIAS = "app_alias_";
	// JSON格式化
	public static final SerializerFeature[] FEATURES = { SerializerFeature.WriteMapNullValue, // 是否输出值为null的字段,默认为false
			SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null,输出为0,而非null
			SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null,输出为”“,而非null
			SerializerFeature.WriteNullListAsEmpty, // List字段如果为null,输出为[],而非null
			SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null,输出为false,而非null
			SerializerFeature.WriteDateUseDateFormat, // 日期格式化
			SerializerFeature.DisableCircularReferenceDetect }; // 禁止循环引用检测

	/************************************************* 正则表达式 ****************************************/
	// 邮箱正则表达式
	public static final String REG_EMAIL = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	// 账号正则表达式
	public static final String REG_ACCOUNT = "^\\w{4,20}$";
	// 密码正则表达式
	public static final String REG_PASSWORD = "^\\w{6,14}$";
	// 手机正则表达式
	public static final String REG_IPHONE = "^1\\d{10}$";
	// 数字类型正则表达式
	public static final String REG_NUMBER = "^\\d{0,10}";
	// 带小数点的数字
	public static final String REG_NUM = "^(0\\.[1-9]\\d*|[1-9]\\d*(\\.\\d+)?)$";
	// 正整数正则表达式
	public static final String REG_NUMBER_INT = "^$|0|[1-9]\\d{0,10}$";
	// 日期格式正则表达式 2016-04-04 12:59:59
	public static final String REG_DATE = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))"
			+ "[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))"
			+ "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|"
			+ "(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))\\s((1[0-9])|(2[0-3])):([0-5][0-9]):([0-5][0-9])$";

	public static final String REG_DATE_YYYY_MM_DD = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))"
			+ "[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))"
			+ "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|"
			+ "(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))$";
	/**
	 * 逗号分隔符
	 */
	String SPLIT_CHAR_COMMOA = ",";

	/**
	 * 冒号分隔符
	 */
	String SPLIT_CHAR_COLON = ":";

}
