package com.unicdata.entity.product;

import java.math.BigDecimal;

public class InsuranceTypePrice {
    private Integer id;

    private Integer storeId;

    private Integer insuranceId;

    private BigDecimal priceOne;

    private BigDecimal priceTwo;

    private Integer type;

    /**
     * 此字段数据库中没有，仅用于暂存数据
     */
    private String insuranceName;

    /**
     * 此字段数据库中没有，仅用于暂存数据
     */
    private Integer selfDefined;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public BigDecimal getPriceOne() {
        return priceOne;
    }

    public void setPriceOne(BigDecimal priceOne) {
        this.priceOne = priceOne;
    }

    public BigDecimal getPriceTwo() {
        return priceTwo;
    }

    public void setPriceTwo(BigDecimal priceTwo) {
        this.priceTwo = priceTwo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public Integer getSelfDefined() {
        return selfDefined;
    }

    public void setSelfDefined(Integer selfDefined) {
        this.selfDefined = selfDefined;
    }
}