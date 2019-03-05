package com.unicdata.base.enu;
/**
 * 订单来源
 */
public enum RetailEnum {

    SALES(0,"销售订单"),
    SALES_AFTER(1,"售后订单"),
    RETAIL(2,"零售订单");
	
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;

    RetailEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
	
}
