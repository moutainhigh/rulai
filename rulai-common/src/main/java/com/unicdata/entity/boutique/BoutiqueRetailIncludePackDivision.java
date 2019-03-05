package com.unicdata.entity.boutique;

import java.math.BigDecimal;
import java.util.Date;

public class BoutiqueRetailIncludePackDivision {
    private Integer id;

    private Integer retialIncludeId;

    private Integer packId;

    private Integer boutiqueId;

    private Integer num;

    private BigDecimal divisionValue;

    private Integer typeLive;

    private Date timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRetialIncludeId() {
        return retialIncludeId;
    }

    public void setRetialIncludeId(Integer retialIncludeId) {
        this.retialIncludeId = retialIncludeId;
    }

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    public Integer getBoutiqueId() {
        return boutiqueId;
    }

    public void setBoutiqueId(Integer boutiqueId) {
        this.boutiqueId = boutiqueId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getDivisionValue() {
        return divisionValue;
    }

    public void setDivisionValue(BigDecimal divisionValue) {
        this.divisionValue = divisionValue;
    }

    public Integer getTypeLive() {
        return typeLive;
    }

    public void setTypeLive(Integer typeLive) {
        this.typeLive = typeLive;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}