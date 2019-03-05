package com.unicdata.constant;

/**
 * Created by lenovo on 2018/6/16.
 */
public class OrderEnum {
    /**
     * 审批类型
     *
     * @author lwb
     * @date 2018年6月4日
     */
    public enum ApprovalType {

        APPROVAL_CUS(0, "人员审批"),
        APPROVAL_ORDER(1, "订单审批");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        ApprovalType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 订单审批类型
     *
     * @author lwb
     * @date 2018年6月4日
     */
    public enum ApprovalOrderType {

        ORDER(1, "订单审批"),
        ORDEROUT(2, "退订审批");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        ApprovalOrderType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 精品订单审批记录状态
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum approvalStatus {
        APPROVAL_WAIT(0, "待审批"),
        APPROVAL_REFUSE(1, "审批通过"),
        EARNEST_WAIT(2, "审批不通过");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        approvalStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 销售经理赋予展厅经理权限枚举
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum EmployeeAuthorizeType {
        ONE(1, "销售经理-展厅经理"),
        TWO(2, "销售经理-销售顾问"),
        THREE(3, "展厅经理-销售顾问");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        EmployeeAuthorizeType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 销售经理赋予展厅经理权限枚举
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum EmployeePostNameType {
        ONE(1, "展厅经理"),
        TWO(2, "销售顾问"),
        THREE(3, "销售经理");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        EmployeePostNameType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 销售经理赋予展厅经理权限枚举,审批类型
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum showroomManagerRoleApprovalyType {
        ONE(1, "价格审批"),
        TWO(2, "退订审批"),
        SAN(3, "换车审批");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        showroomManagerRoleApprovalyType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 客户审批类型
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum ApprovalyCusType {
        ONE(1, "休眠审批"),
        TWO(2, "战败审批");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        ApprovalyCusType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }
}
