package com.unicdata.constant;

public class InsuranceEnum {

    /**
     *延保套餐类型枚举
     */
    public enum ExtensionType {
        STORE_EXT(1, "自店延保"),
        FACTORY_EXT(2,"厂家延保"),
        COMPANY_CUS(3, "延保公司延保");

        private Integer code;

        private String desc;

        ExtensionType(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static ExtensionType getByCode(Integer code) {
            for (ExtensionType item : ExtensionType.values()) {
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
