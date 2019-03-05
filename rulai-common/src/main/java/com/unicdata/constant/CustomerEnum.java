package com.unicdata.constant;

/**
 * 客户相关枚举
 */
public class CustomerEnum {

    /**
     * 客户跟进枚举
     */
    public enum TaskFollowContent {

        CUS_FOLLOW(1, "潜客跟进"),
        CUS_INVITE(2, "潜客邀约"),
        ORDER_FOLLOW(3, "订单跟进"),
        DELIVERY_CAR(4, "今日交车"),
        SERVICE(5, "后续服务");

        TaskFollowContent(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static TaskFollowContent getByCode(Integer code) {
            for (TaskFollowContent item : TaskFollowContent.values()) {
                if (item.getCode().equals(code)) {
                    return item;
                }
            }
            return null;
        }

        private Integer code;

        private String desc;

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

    /**
     * 客户级别
     */
    public enum Level {

        G(0, ""),//无用，为了方面取值
        O(1, "O"),
        H(2, "H"),
        A(3, "A"),
        B(4, "B"),
        C(5, "C"),
        W(6, "W"),
        D(7, "D");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        Level(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 用途
     */
    public enum Usage {

        USER(1, "自用"),
        CONPANYCAR(2, "公司配车"),
        COMPANY(3, "公司用车"),
        EMPLY(4, "奖励员工"),
        DAIGOU(5, "代购"),
        USECAR(6, "运营用车"),
        OTHER(5, "其他");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        Usage(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }


    /**
     * 客户分类枚举
     */
    public enum CustomerCategory {
        POTENTIAL_CUS(1, "潜客"),
        ORDER_CUS(2, "订单"),
        DELIVERY_CAR_CUS(3, "交车"),
        SLEEP_CUS(4, "休眠"),
        DIE_CUS(5, "战败");

        private Integer code;

        private String desc;

        CustomerCategory(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static CustomerCategory getByCode(Integer code) {
            for (CustomerCategory item : CustomerCategory.values()) {
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
}
