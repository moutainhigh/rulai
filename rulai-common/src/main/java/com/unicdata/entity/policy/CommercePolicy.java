package com.unicdata.entity.policy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicdata.base.util.BigDecimalUtils;
import com.unicdata.entity.BaseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(value = "商务政策实体")
public class CommercePolicy extends BaseEntity {
    private Integer id;

    @ApiModelProperty(value = "商务政策Code")
    private String policyCode;

    @ApiModelProperty(value = "商务政策名称")
    private String policyName;

    @ApiModelProperty(value = "商务政策创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date policyCreateDate;

    private Integer storeId;

    private Integer employeeId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    @ApiModelProperty(value = "查询年份" ,hidden = true)
    private Integer year;

    @ApiModelProperty(value = "虚报台数")
    private BigDecimal virtualRecordTotal;
    @ApiModelProperty(value = "首次预估返利总计（计算改返利项目下所有车的首次预估返利）")
    private BigDecimal firstEstimateTotal;
    @ApiModelProperty(value = "预估调整总计")
    private BigDecimal estimateAdjustTotal;
    @ApiModelProperty(value = "计提金额总计")
    private BigDecimal planExtractionTotal;
    @ApiModelProperty(value = "计提调整总计")
    private BigDecimal planExtractionAdjustTotal;
    @ApiModelProperty(value = "核对日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date proofreaderDate;
    @ApiModelProperty(value = "到账日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date arriveBillDate;
    @ApiModelProperty(value = "核对总额")
    private BigDecimal proofreaderMoney;
    @ApiModelProperty(value = "到账总额")
    private BigDecimal arriveBillMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Date getPolicyCreateDate() {
        return policyCreateDate;
    }

    public void setPolicyCreateDate(Date policyCreateDate) {
        this.policyCreateDate = policyCreateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getFirstEstimateTotal() {
        return firstEstimateTotal;
    }

    public void setFirstEstimateTotal(BigDecimal firstEstimateTotal) {
        this.firstEstimateTotal = firstEstimateTotal;
    }

    public BigDecimal getEstimateAdjustTotal() {
        return estimateAdjustTotal;
    }

    public void setEstimateAdjustTotal(BigDecimal estimateAdjustTotal) {
        this.estimateAdjustTotal = estimateAdjustTotal;
    }

    public BigDecimal getPlanExtractionTotal() {
        return planExtractionTotal;
    }

    public void setPlanExtractionTotal(BigDecimal planExtractionTotal) {
        this.planExtractionTotal = planExtractionTotal;
    }

    public BigDecimal getPlanExtractionAdjustTotal() {
        return planExtractionAdjustTotal;
    }

    public void setPlanExtractionAdjustTotal(BigDecimal planExtractionAdjustTotal) {
        this.planExtractionAdjustTotal = planExtractionAdjustTotal;
    }

    public Date getProofreaderDate() {
        return proofreaderDate;
    }

    public void setProofreaderDate(Date proofreaderDate) {
        this.proofreaderDate = proofreaderDate;
    }

    public Date getArriveBillDate() {
        return arriveBillDate;
    }

    public void setArriveBillDate(Date arriveBillDate) {
        this.arriveBillDate = arriveBillDate;
    }

    public BigDecimal getArriveBillMoney() {
        return arriveBillMoney;
    }

    public void setArriveBillMoney(BigDecimal arriveBillMoney) {
        this.arriveBillMoney = arriveBillMoney;
    }

    public BigDecimal getProofreaderMoney() {
        return proofreaderMoney;
    }

    public void setProofreaderMoney(BigDecimal proofreaderMoney) {
        this.proofreaderMoney = proofreaderMoney;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getVirtualRecordTotal() {
        return virtualRecordTotal;
    }

    public void setVirtualRecordTotal(BigDecimal virtualRecordTotal) {
        this.virtualRecordTotal = virtualRecordTotal;
    }

}