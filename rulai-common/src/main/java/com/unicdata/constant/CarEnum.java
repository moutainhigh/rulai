package com.unicdata.constant;

/**
 * 车辆相关枚举信息
 *
 * @author wxn
 * @date 2018年6月3日
 */
public class CarEnum {
	
	/**
	 * 车辆资金属性
	 * 
	 * @author wxn
	 * @date 2018年7月14日
	 */
    public enum FundProperty {

        FINANCE(1, "金融"),
        PURCHASE(2, "自采");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        FundProperty(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }
	
	/**
	 * 车辆采购来源
	 * 
	 * @author wxn
	 * @date 2018年7月14日
	 */
    public enum SourceStatus {

        FACTORY(1, "主机厂商"),
        ENGINE(2, "供应商");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        SourceStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 车辆外出申请单状态
     *
     * @author wxn
     * @date 2018年6月16日
     */
    public enum OutStatus {

        OUT(1, "外出中"),
        IN(2, "已入库");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        OutStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 车辆配车状态
     *
     * @author wxn
     * @date 2018年6月17日
     */
    public enum SupplyStatus {

        NO_SUPPLY(1, "未配车"),
        SUPPLY_ING(2, "已配车"),
        SUPPLY_FINISHED(3, "已交车");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        SupplyStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 车辆颜色位置状态
     *
     * @author wxn
     * @date 2018年6月6日
     */
    public enum ColorStatus {

        OUT(1, "车身颜色"),
        IN(2, "内饰");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        ColorStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 车辆状态（导入判断）
     *
     * @author wxn
     * @date 2018年6月6日
     */
    public enum CarStatus {

        YES(1, "是"),
        NO(2, "否");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        CarStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 有无
     *
     * @author wxn
     * @date 2018年6月6日
     */
    public enum ExistStatus {

        EXIST(1, "有"),
        NOT_EXIST(2, "无");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        ExistStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 数据状态
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum DataStatus {

        NORMAL(1, "正常"),
        DELETED(2, "已删除");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        DataStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 车辆库存状态
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum CarStorageStatus {

        ON_WAY(1, "在途"),
        IN_STORAGE(2, "在库"),
        REPAIR_OUT(3, "整备出库"),
        SELL_OUT(4, "销售出库"),
        OUT(5, "外出"),
        REFUSE(6, "拒收");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        CarStorageStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 车辆处理状态
     *
     * @author wxn
     * @date 2018年6月8日
     */
    public enum CarDisposeStatus {

        NORMAL(1, "正常"),
        REPAIR_WAIT(2, "待整备"),
        REPAIRING(3, "整备中"),
        IN_TEMPORARY(4, "暂收"),
        REFULSE(5, "拒收");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        CarDisposeStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 车辆订单状态
     *
     * @author wxn
     * @date 2018年6月8日
     */
    public enum CarOrderStatus {

        NO_STATUS(1, "无"),
        RESERVED(2, "已预订"),
        FULL_PAY(3, "已付全款");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        CarOrderStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }


    //洗车状态枚举
    public enum CarWashStates {

        WASHING(0, "洗车中"),
        NO_WASHING(1, "未洗车"),
        FINISHED(2, "已完成");

        CarWashStates(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static CarWashStates getByCode(Integer code) {
            for (CarWashStates item : CarWashStates.values()) {
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

    //车辆性质枚举
    public enum CarCharacters {

        PRIVATE_NO_SERVICE(1, "私人非营运"),
        ENTERPRISE_NO_SERVICE(2, "企业非营运"),
        RENT(3, "租赁"),
        RENT_PASSENGER_TRANSPORT(4, "出租客运");

        CarCharacters(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static CarCharacters getByCode(Integer code) {
            for (CarCharacters item : CarCharacters.values()) {
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
     * 试驾车申请审批状态
     */
    public enum testDriveApplyStatus {
        APPROVAL_WAIT(0, "待审批"),
        APPROVAL_REFUSE(1, "审批通过"),
        EARNEST_WAIT(2, "审批不通过");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        testDriveApplyStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }
}
