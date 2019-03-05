package com.unicdata.entity.boutique;

import java.math.BigDecimal;

public class CheckItem {
    private Integer id;

    private Integer checkId;

    private Integer boutiqueId;

    private BigDecimal physicalCountQuantity;

    private BigDecimal physicalInventory;

    private BigDecimal differenceQuantity;

    private BigDecimal differenceMoney;

    private BigDecimal cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getBoutiqueId() {
        return boutiqueId;
    }

    public void setBoutiqueId(Integer boutiqueId) {
        this.boutiqueId = boutiqueId;
    }

    public BigDecimal getPhysicalCountQuantity() {
        return physicalCountQuantity;
    }

    public void setPhysicalCountQuantity(BigDecimal physicalCountQuantity) {
        this.physicalCountQuantity = physicalCountQuantity;
    }

    public BigDecimal getPhysicalInventory() {
        return physicalInventory;
    }

    public void setPhysicalInventory(BigDecimal physicalInventory) {
        this.physicalInventory = physicalInventory;
    }

    public BigDecimal getDifferenceQuantity() {
        return differenceQuantity;
    }

    public void setDifferenceQuantity(BigDecimal differenceQuantity) {
        this.differenceQuantity = differenceQuantity;
    }

    public BigDecimal getDifferenceMoney() {
        return differenceMoney;
    }

    public void setDifferenceMoney(BigDecimal differenceMoney) {
        this.differenceMoney = differenceMoney;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}