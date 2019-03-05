package com.unicdata.entity.letprice;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "月度计划车辆关联表")
public class MonthPlanDetail {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "月度计划管理表id")
    private Integer monthPlanId;
    @ApiModelProperty(value = "车辆id")
    private Integer carId;
    @ApiModelProperty(value = "第一级别报价")
    private BigDecimal levelOne;
    @ApiModelProperty(value = "第二级别报价")
    private BigDecimal levelTwo;
    @ApiModelProperty(value = "第三级别报价")
    private BigDecimal levelThree;
    @ApiModelProperty(value = "第一级别报价调整")
    private BigDecimal levelOneAdjust;
    @ApiModelProperty(value = "第二级别报价调整")
    private BigDecimal levelTwoAdjust;
    @ApiModelProperty(value = "第三级别报价调整")
    private BigDecimal levelThreeAdjust;
    @ApiModelProperty(value = "状态 1初始状态，2待审核，3正常，5驳回")
    private Integer status;
    @ApiModelProperty(value = "是否修改 1未修改，2已修改")
    private Integer isModify;
    @ApiModelProperty(value = "是否选中/取消 1选中，2取消选中")
    private Integer isSelect;
    @ApiModelProperty(value = "操作人")
    private Integer employeeId;
    @ApiModelProperty(value = "数据修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    @ApiModelProperty(value = "数据创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    @ApiModelProperty(value = "车辆实际采购价")
    private BigDecimal purchasePrice;
    @ApiModelProperty(value = "预估返利")
    private BigDecimal forecastProfit;
    @ApiModelProperty(value = "计划内达成  1在，2不在")
    private Integer insideThePlan;
    private BigDecimal donationAmount ;
    private BigDecimal salePrice ;


    private String carMap;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonthPlanId() {
        return monthPlanId;
    }

    public void setMonthPlanId(Integer monthPlanId) {
        this.monthPlanId = monthPlanId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public BigDecimal getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(BigDecimal levelOne) {
        this.levelOne = levelOne;
    }

    public BigDecimal getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(BigDecimal levelTwo) {
        this.levelTwo = levelTwo;
    }

    public BigDecimal getLevelThree() {
        return levelThree;
    }

    public void setLevelThree(BigDecimal levelThree) {
        this.levelThree = levelThree;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getIsModify() {
        return isModify;
    }

    public void setIsModify(Integer isModify) {
        this.isModify = isModify;
    }

    public String getCarMap() {
        return carMap;
    }

    public void setCarMap(String carMap) {
        this.carMap = carMap;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getForecastProfit() {
        return forecastProfit;
    }

    public void setForecastProfit(BigDecimal forecastProfit) {
        this.forecastProfit = forecastProfit;
    }

    public BigDecimal getLevelOneAdjust() {
        return levelOneAdjust;
    }

    public void setLevelOneAdjust(BigDecimal levelOneAdjust) {
        this.levelOneAdjust = levelOneAdjust;
    }

    public BigDecimal getLevelTwoAdjust() {
        return levelTwoAdjust;
    }

    public void setLevelTwoAdjust(BigDecimal levelTwoAdjust) {
        this.levelTwoAdjust = levelTwoAdjust;
    }

    public BigDecimal getLevelThreeAdjust() {
        return levelThreeAdjust;
    }

    public void setLevelThreeAdjust(BigDecimal levelThreeAdjust) {
        this.levelThreeAdjust = levelThreeAdjust;
    }

    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }

    public Integer getInsideThePlan() {
        return insideThePlan;
    }

    public void setInsideThePlan(Integer insideThePlan) {
        this.insideThePlan = insideThePlan;
    }

    public BigDecimal getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(BigDecimal donationAmount) {
        this.donationAmount = donationAmount;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
}
