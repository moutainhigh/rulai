package com.unicdata.constant;

/**
 * 消息推送类型枚举
 */
public enum PushMessageEnum {

    CUS_BOND_PAID(1, "客户保证金已付提醒"),
    ORDER_SETTLED(2, "销售单已结算提醒"),
    CUS_DEPOSIT_PAID(3, "客户订金已付提醒");

    private Integer code;

    private String desc;

    PushMessageEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PushMessageEnum getByCode(Integer code) {
        for (PushMessageEnum item : PushMessageEnum.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
