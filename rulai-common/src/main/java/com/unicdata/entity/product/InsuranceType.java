package com.unicdata.entity.product;

import java.util.Date;

public class InsuranceType {
    private Integer id;

    private String name;

    private Boolean enabled;

    private String remark;

    private Date createTime;

    private Integer selfDefined;

    private Integer level;

    private Integer parentId;

    private Integer hasBaseFee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSelfDefined() {
        return selfDefined;
    }

    public void setSelfDefined(Integer selfDefined) {
        this.selfDefined = selfDefined;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getHasBaseFee() {
        return hasBaseFee;
    }

    public void setHasBaseFee(Integer hasBaseFee) {
        this.hasBaseFee = hasBaseFee;
    }
}