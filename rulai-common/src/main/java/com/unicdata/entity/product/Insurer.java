package com.unicdata.entity.product;

import org.assertj.core.util.Lists;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Insurer {
    private Integer id;

    private String name;

    private Boolean enabled;

    private String contactor;

    private String phone;

    private String address;

    private String remark;

    private Date createTime;

    private Date modifyTime;

    private Integer operatorId;

    private Integer storeId;

    private BigDecimal rebateRatio;

    private BigDecimal taxRemovalRatio;

    private Integer state;

    private BigDecimal cost;

    private List<InsuranceConnection> connections = Lists.newArrayList();

    private List<InsuranceType> insuranceType = Lists.newArrayList();

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

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public BigDecimal getRebateRatio() {
        return rebateRatio;
    }

    public void setRebateRatio(BigDecimal rebateRatio) {
        this.rebateRatio = rebateRatio;
    }

    public BigDecimal getTaxRemovalRatio() {
        return taxRemovalRatio;
    }

    public void setTaxRemovalRatio(BigDecimal taxRemovalRatio) {
        this.taxRemovalRatio = taxRemovalRatio;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<InsuranceConnection> getConnections() {
        return connections;
    }

    public void setConnections(List<InsuranceConnection> connections) {
        this.connections = connections;
    }

    public List<InsuranceType> getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(List<InsuranceType> insuranceType) {
        this.insuranceType = insuranceType;
    }
}