package com.unicdata.entity.product;

import java.math.BigDecimal;

public class InsuranceConnection {
    private Integer id;

    private Integer insurerId;

    private Integer insuranceId;

    private BigDecimal taxRemovalRatio;

    private String insuranceName;

    private String insurerName;

    private BigDecimal rebateRatio;

    private BigDecimal cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(Integer insurerId) {
        this.insurerId = insurerId;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public BigDecimal getTaxRemovalRatio() {
        return taxRemovalRatio;
    }

    public void setTaxRemovalRatio(BigDecimal taxRemovalRatio) {
        this.taxRemovalRatio = taxRemovalRatio;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public BigDecimal getRebateRatio() {
        return rebateRatio;
    }

    public void setRebateRatio(BigDecimal rebateRatio) {
        this.rebateRatio = rebateRatio;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}