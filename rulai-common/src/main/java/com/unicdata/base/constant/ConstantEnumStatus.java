package com.unicdata.base.constant;

/**
 * 状态码说明
 *
 * @author 许兵
 * @date 2017年6月21日
 */
public enum ConstantEnumStatus {

    /**
     * -1:验证未通过
     */
    validate(-1, "验证未通过"),

    /**
     * 200：服务器成功返回
     */
    OK(200, "成功"),

    /**
     * 404：未找到
     */
    NOT_FOUND(404, "请求的网页不存在"),

    /**
     * 500:错误代码
     */
    INTERNAL_SERVER_ERROR(500, "系统错误"),
    /**
     * 300:数据为空
     */
    NO_EMPTY(300, "数据为空"),
    /**
     * 301:输入参数不全
     */
    PARAM_NULL(301, "输入参数不全"),
    /**
	 * 
	 */
	Exist(302, "已存在"),
    /**
     * 1000:未登陆
     */
    NO_LOGIN(1000, "未登陆"),

    /**
     * 10100：token为空
     */
    TOKEN_NULL(10100, "token为空"),

    /**
     * 10200：token失效
     */
    TOKEN_INVALID(10200, "token失效"),

    /**
     * 10300：操作失败
     */
    FAIL(10300, "操作失败"),

    /**
     * 10301：密码错误
     */
    PASSWORD_ERROR(10301, "密码错误"),
    /**
     * 2001
     */
    FULL_ORDER(2001, "订单已经全款"),
    /**
     * 2002
     */
    HAVE_PAY(2002, "有业务已经付过款");
	

    //状态码
    private final int code;
    //状态原因
    private final String reason;

    private ConstantEnumStatus(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
