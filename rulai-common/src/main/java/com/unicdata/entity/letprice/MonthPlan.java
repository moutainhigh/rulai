package com.unicdata.entity.letprice;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "月度计划")
public class MonthPlan {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "年度")
    private Integer planYear;
    @ApiModelProperty(value = "计提年月 yyyy-MM格式")
    private String planMonth;
    @ApiModelProperty(value = "目标销量")
    private Integer goalSalesVolume;
    @ApiModelProperty(value = "目标毛利总额")
    private BigDecimal goalGrossProfit;
    @ApiModelProperty(value = "计划销量")
    private Integer planSalesVolume;
    @ApiModelProperty(value = "计划毛利总额")
    private BigDecimal planGrossProfit;
    @ApiModelProperty(value = "销量达成")
    private Integer completeSalesVolume;
    @ApiModelProperty(value = "毛利总额达成")
    private BigDecimal completeGrossProfit;
    @ApiModelProperty(value = "销量差异")
    private Integer differenceSalesVolume;
    @ApiModelProperty(value = "毛利差异")
    private BigDecimal differenceGrossProfit;
    @ApiModelProperty(value = "门店id")
    private Integer storeId;
    @ApiModelProperty(value = "状态 0初始状态，1待关联库存，2待审核，3正常，4归档，5驳回")
    private Integer status;
    @ApiModelProperty(value = "备注")
    private String remark ;
    @ApiModelProperty(value = "操作人")
    private Integer employeeId;
    @ApiModelProperty(value = "数据修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    @ApiModelProperty(value = "数据创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @ApiModelProperty(value = "是否显示归档 1是，2否")
    public Integer isShowArchiving;
    @ApiModelProperty(value = "预算销量")
    public Integer budgetVolume;
    @ApiModelProperty(value = "预算毛利总额")
    public BigDecimal budgetGrossProfit;
    @ApiModelProperty(value = "计划内销量")
    public Integer insideThePlanVolume ;
    @ApiModelProperty(value = "计划内总额")
    public BigDecimal insideThePlanLumSum;
    @ApiModelProperty(value = "计划外销量")
    public Integer notInThePlanVolume;
    @ApiModelProperty(value = "计划外总额")
    public BigDecimal notInThePlanLumpum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanYear() {
        return planYear;
    }

    public void setPlanYear(Integer planYear) {
        this.planYear = planYear;
    }

    public String getPlanMonth() {
        return planMonth;
    }

    public void setPlanMonth(String planMonth) {
        this.planMonth = planMonth;
    }

    public Integer getGoalSalesVolume() {
        return goalSalesVolume;
    }

    public void setGoalSalesVolume(Integer goalSalesVolume) {
        this.goalSalesVolume = goalSalesVolume;
    }

    public BigDecimal getGoalGrossProfit() {
        return goalGrossProfit;
    }

    public void setGoalGrossProfit(BigDecimal goalGrossProfit) {
        this.goalGrossProfit = goalGrossProfit;
    }

    public Integer getPlanSalesVolume() {
        return planSalesVolume;
    }

    public void setPlanSalesVolume(Integer planSalesVolume) {
        this.planSalesVolume = planSalesVolume;
    }

    public BigDecimal getPlanGrossProfit() {
        return planGrossProfit ;
    }

    public void setPlanGrossProfit(BigDecimal planGrossProfit) {
        this.planGrossProfit = planGrossProfit;
    }

    public Integer getCompleteSalesVolume() {
        return completeSalesVolume;
    }

    public void setCompleteSalesVolume(Integer completeSalesVolume) {
        this.completeSalesVolume = completeSalesVolume;
    }

    public BigDecimal getCompleteGrossProfit() {
        return completeGrossProfit;
    }

    public void setCompleteGrossProfit(BigDecimal completeGrossProfit) {
        this.completeGrossProfit = completeGrossProfit;
    }

    public Integer getDifferenceSalesVolume() {
        return differenceSalesVolume;
    }

    public void setDifferenceSalesVolume(Integer differenceSalesVolume) {
        this.differenceSalesVolume = differenceSalesVolume;
    }

    public BigDecimal getDifferenceGrossProfit() {
        return differenceGrossProfit;
    }

    public void setDifferenceGrossProfit(BigDecimal differenceGrossProfit) {
        this.differenceGrossProfit = differenceGrossProfit;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsShowArchiving() {
        return isShowArchiving;
    }

    public void setIsShowArchiving(Integer isShowArchiving) {
        this.isShowArchiving = isShowArchiving;
    }

    public Integer getBudgetVolume() {
        return budgetVolume;
    }

    public void setBudgetVolume(Integer budgetVolume) {
        this.budgetVolume = budgetVolume;
    }

    public BigDecimal getBudgetGrossProfit() {
        return budgetGrossProfit;
    }

    public void setBudgetGrossProfit(BigDecimal budgetGrossProfit) {
        this.budgetGrossProfit = budgetGrossProfit;
    }

    public Integer getInsideThePlanVolume() {
        return insideThePlanVolume;
    }

    public void setInsideThePlanVolume(Integer insideThePlanVolume) {
        this.insideThePlanVolume = insideThePlanVolume;
    }

    public BigDecimal getInsideThePlanLumSum() {
        return insideThePlanLumSum;
    }

    public void setInsideThePlanLumSum(BigDecimal insideThePlanLumSum) {
        this.insideThePlanLumSum = insideThePlanLumSum;
    }

    public Integer getNotInThePlanVolume() {
        return notInThePlanVolume;
    }

    public void setNotInThePlanVolume(Integer notInThePlanVolume) {
        this.notInThePlanVolume = notInThePlanVolume;
    }

    public BigDecimal getNotInThePlanLumpum() {
        return notInThePlanLumpum;
    }

    public void setNotInThePlanLumpum(BigDecimal notInThePlanLumpum) {
        this.notInThePlanLumpum = notInThePlanLumpum;
    }
}