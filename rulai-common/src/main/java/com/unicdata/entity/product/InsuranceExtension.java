package com.unicdata.entity.product;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InsuranceExtension {
    private Integer id;

    private Integer extensionId;

    private Boolean enabled;

    private String name;

    private BigDecimal price;

    private Integer state;

    private String items;

    private Date modifyTime;

    private Date createTime;

    private Integer operatorId;

    private String remark;

    private Integer storeId;

    private Integer type;

    private BigDecimal cost;

    private BigDecimal rebate;

    /**
     * 仅用于前端接收参数，数据库中没有此字段
     */
    private List<Map<String,Object>> itemsList = Lists.newArrayList();

    /**
     * 关联车系
     */
    private List<InsuranceExtensionFamily> insuranceExtensionFamilies = Lists.newArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(Integer extensionId) {
        this.extensionId = extensionId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public List<Map<String, Object>> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Map<String, Object>> itemsList) {
        this.itemsList = itemsList;
    }

    public List<InsuranceExtensionFamily> getInsuranceExtensionFamilies() {
        return insuranceExtensionFamilies;
    }

    public void setInsuranceExtensionFamilies(List<InsuranceExtensionFamily> insuranceExtensionFamilies) {
        this.insuranceExtensionFamilies = insuranceExtensionFamilies;
    }
}