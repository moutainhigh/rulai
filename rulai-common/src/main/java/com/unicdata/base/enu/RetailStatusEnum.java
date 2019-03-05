package com.unicdata.base.enu;

/**
 *订单状态
 */
public enum RetailStatusEnum {
	
    PENDING(0,"待审批"),
    NOT_PASS(1,"审批不通过"),
    PAYABLE(2,"待付定金"),
    PAY(3,"待全款"),
    RECEIVED(4,"已收讫"),
    CHARGEBACK(5,"已退单");
	
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;

    RetailStatusEnum(Integer code, String message) {
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
