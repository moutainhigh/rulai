package com.unicdata.constant;

/**
 * 财务管理枚举类
 *
 * @author wxn
 * @date 2018年6月4日
 */
public class SettleEnum {

    /**
     * 财务结算类型
     *
     * @author wxn
     * @date 2018年6月5日
     */
    public enum ProceedsType {

        EARN(1, "收款"),
        BACK(2, "退款");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        ProceedsType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 付款方式
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum PayType {

        WECHAT(1, "微信"),
        ALIPAY(2, "支付宝"),
        POS(3, "POS"),
        CREDIT_CARD(4, "信用卡"),
        CHEQUE(5, "支票"),
        TRANSFER_ACCOUNTS(6, "转账"),
        CASH(7, "现金"),
        OTHER(8, "其他"),
        BANK(9, "现金");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        PayType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    public enum OrderStatus {
        NO_EFFECTIVE(1, "未生效"),
        EFFECTIVE(2, "已生效"),
        EARNEST(3, "已付定金"),
        TOTAL_PAYMENT(4, "全款到账"),
        PREPARE(5, "待交车"),
        DELIVER(6, "已交车"),
        REFUND_APPROVAL(7, "退单审批中"),
        WAIT_REFUND(8, "待退单"),
        REFUND(9, "已退单");

        private final int code;

        private final String reason;

        OrderStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public int getCode() {
            return code;
        }

        public String getReason() {
            return reason;
        }

        public static OrderStatus getByCode(Integer code) {
            for (OrderStatus item : OrderStatus.values()) {
                if (Integer.valueOf(item.getCode()).equals(code)) {
                    return item;
                }
            }
            return null;
        }
    }

    public enum ReceiptType {
        DEPOSIT(1, "定金"),
        CAR(2, "尾款"),
        BOUTIQUE(3, "精品"),
        INSURANCE(4, "保险"),
        EXTENSION(5, "延保"),
        LOAN(6, "金融"),
        OTHER(7, "其他"),
        CASHCOUPON(8, "代金券、保养套餐");

        private final int code;

        private final String reason;

        ReceiptType(int code, String reason) {
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

    public enum LoanPart {
        DOWN_PAY(1, "首付"),
        LOAN_AMOUNT(2, "贷款"),
        BOND(3, "保证金"),
        CHARGE(4, "服务费"),
        MORTGAGE(5, "抵押手续费");

        private final int code;

        private final String reason;

        LoanPart(int code, String reason) {
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

    //订单保险单/延保单状态枚举
    public enum OrderInsuranceStates {

        UNCOMMITTED(1, "未提交"),
        COMMITTED(2, "已提交"),
        CANCELED(3, "已取消");

        OrderInsuranceStates(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static OrderInsuranceStates getByCode(Integer code) {
            for (OrderInsuranceStates item : OrderInsuranceStates.values()) {
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

    //订单金融状态枚举
    public enum OrderFinanceStates {

        PENDING_APPLY(1, "待申请"),
        HAVE_APPLIED(2, "已申请"),
        HAVE_RELEASED(3, "已放款");

        OrderFinanceStates(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static OrderFinanceStates getByCode(Integer code) {
            for (OrderFinanceStates item : OrderFinanceStates.values()) {
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
     * 审批状态
     */
    public enum ApprovalStates {

        WAITAPPROVAL(0, "待审批"),
        PASS(1, "通过"),
        NOPASS(2, "不通过"),;

        ApprovalStates(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static ApprovalStates getByCode(Integer code) {
            for (ApprovalStates item : ApprovalStates.values()) {
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


