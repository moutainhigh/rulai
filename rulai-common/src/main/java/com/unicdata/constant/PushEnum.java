package com.unicdata.constant;

/**
 * 消息推送枚举
 */
public class PushEnum {

    /**
     * 推送类型
     */
    public enum PushType {
        ORDER_AUDITED(1, "订单通过审核"),
        ORDER_LOAN(2, "订单贷款到账"),
        ORDER_REFUND(3, "订单退订通过审核"),
        ORDER_SUBMIT(4, "订单提交审核"),
        ORDER_NO_PASS(5, "订单审核驳回"),
        ORDER_PAY_ALL(6, "订单已付全款"),
        ORDER_PAY_FIRST(7, "订单已付定金"),
        ORDER_BOUTIQUE_PASS(8, "精品订单通过审批"),
        ORDER_BOUTIQUE_REJECT(9, "精品订单不通过审批"),
        ORDER_CUSXM_FIRST(10, "人员休眠不通过审批"),
        ORDER_CUSXM_PASS(11, "人员休眠通过审批"),
        ORDER_CUSZB_FIRST(12, "人员战败不通过审批"),
        ORDER_CUSZB_PASS(13, "人员战败通过审批"),
        ORDER_AUDITED_FIRST(14, "订单不通过审核"),
        ORDER_REFUND_FIRST(15, "订单退订不通过审核"),
        PASSENGERFLOW_NEW(16, "新客流提醒"),
        CUSTOMER_LEAVE(17, "客户离店"),
        CUSTOMER_INFO_INTEGRITY(18, "顾问首次完善档案"),
        PASSENGERFLOW_FIRST_SHOP(19, "客流首次到店"),
        PASSENGERFLOW_AGAIN_SHOP(20, "客流再次到店"),
        REPLACE_POST(21, "替岗"),
        REPLACE_SALES(22, "换销售"),
        CUSTOMER_DORMANCY(23, "休眠申请"),
        CUSTOMER_DEFEAT(24, "战败申请"),
        //订单已付定金推送延保信息
        ORDER_PAY_FIRST_EXTENSION(25, "订单已付定金"),
        //订单已付定金推送保险信息
        ORDER_PAY_FIRST_INSURANCE(26, "订单已付定金"),
        CUSTOMER_TEST_DRIVE(27, "试驾时"),
        ORDER_NEW_APPLY(28, "新订单申请"),
        ORDER_REFUND_APPLY(29, "新退订申请");

        PushType(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static PushType getByCode(Integer code) {
            for (PushType item : PushType.values()) {
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
     * 推送端
     */
    public enum PushTerminal {
        PC(1, "PC端"),
        MOBILE(2, "移动端"),
        BOTH(3, "PC和移动端");

        PushTerminal(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static PushTerminal getByCode(Integer code) {
            for (PushTerminal item : PushTerminal.values()) {
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
     * 是否查看
     */
    public enum ViewStates {
        NO_VIEW(1, "未看"),
        VIEWED(2, "已看");

        ViewStates(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static ViewStates getByCode(Integer code) {
            for (ViewStates item : ViewStates.values()) {
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
     * 是否查看
     */
    public enum SendStates {
        NO_SEND(1, "未发送"),
        SENT(2, "已发送");

        SendStates(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static SendStates getByCode(Integer code) {
            for (SendStates item : SendStates.values()) {
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
     * 链接地址,PC端使用
     */
    public enum UrlWeb {
        ORDER_AUDITED_FINANCE(0, "财务-订单通过审核"),
        ORDER_AUDITED_FINANCE_BOUTIQUE(1, "财务-精品订单通过审核"),
        ORDER_LOAN_FINANCE(2, "财务-订单贷款到账"),
        ORDER_REFUND_FINANCE(3, "财务-订单退订通过审核"),
        ORDER_SUBMIT_INFO(4, "信息员-订单提交审核"),
        ORDER_PASS_INFO(5, "信息员-订单审核通过"),
        ORDER_PAY_ALL_INFO(6, "信息员-订单已付全款"),
        ORDER_PAY_FIRST_INSURANCE(7, "保险专员-订单已付定金-保险"),
        ORDER_PAY_FIRST_EXTENSION(8, "保险专员-订单已付定金-延保"),
        ORDER_PAY_FIRST_LOAN(9, "金融专员-订单已付定金"),
        ORDER_SALE_OFFICER_REJECT(10, "销售顾问-订单审核驳回"),
        ORDER_SALE_APPLYCUS_REJECT(11, "销售顾问-人员休眠审核不通过"),
        ORDER_SALE_BOUTIQUE_PASS(12, "销售顾问-精品订单审核通过"),
        ORDER_SALE_BOUTIQUE_REJECT(13, "销售顾问-精品订单审核不通过"),
        ORDER_SALE_OFFICER_PASS(14, "销售顾问-订单审核通过"),
        ORDER_SALE_APPLYCUS_YESPASS(16, "销售顾问-人员战败审核通过"),
        ORDER_SALE_APPLYCUS_NOREJECT(17, "销售顾问-人员战败审核不通过"),
        ORDER_SALE_REFUND_FINANCE_PASS(18, "销售顾问-订单退订审核通过"),
        ORDER_SALE_REFUND_FINANCE_REJECT(19, "销售顾问-订单退订审核不通过"),
        ORDER_SALE_APPLYCUS_XIUMIAN(20, "展厅经理-人员休眠提交审核"),
        ORDER_SALE_APPLYCUS_ZHANBAI(21, "展厅经理-人员战败提交审核"),
        ORDER_PASS_INFO_BOUTIQUE(22, "信息员-精品订单审核通过"),
        ORDER_SALE_APPLYCUS_PASS(23, "销售顾问-人员休眠审核通过");

        UrlWeb(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static UrlWeb getByCode(Integer code) {
            for (UrlWeb item : UrlWeb.values()) {
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
}
