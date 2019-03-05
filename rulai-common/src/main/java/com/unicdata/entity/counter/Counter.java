package com.unicdata.entity.counter;

import com.unicdata.entity.BaseEntity;

/**
 * code生成器entity
 */
public class Counter extends BaseEntity{
    public static final String COMMERCE_POLICY_CODE = "ZC"; // 商务政策code
    public static final String REBATE_PORJECT_CODE = "FL"; // 返利项目code

    
    public static final String BOUTIQUE_CODE = "JP"; //精品编号
    public static final String BOUTIQUE_RETAIL = "JPPO"; //精品订单编号
    public static final String BOUTIQUE_INSTALL = "JPPC"; //精品排程编号
    public static final String BOUTIQUE_WAREHOUSE = "JPCK"; //精品仓库编号
    public static final String BOUTIQUE_CLASSIFY_PRE = "JPCLASS"; //精品分类前缀

    public static final String SYSTEM_EMPLOYEE_CODE = "SU"; //系统用户编号前缀

    private String codePrefix;

    private Integer counter;

    public String getCodePrefix() {
        return codePrefix;
    }

    public void setCodePrefix(String codePrefix) {
        this.codePrefix = codePrefix;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}