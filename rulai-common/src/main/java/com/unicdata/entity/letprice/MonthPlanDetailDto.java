package com.unicdata.entity.letprice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicdata.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(value = "月度计划库存关联DTO")
public class MonthPlanDetailDto extends BaseEntity {

    @ApiModelProperty(value = "车系名称")
    private String familyName;
    @ApiModelProperty(value = "数据")
    private List<MonthPlanCarDto> data;
    @ApiModelProperty(value = "达成计划内销量")
    private Integer insideThePlanVolume ;
    @ApiModelProperty(value = "计划内总额")
    private BigDecimal insideThePlanLumsum;
    @ApiModelProperty(value = "计划外销量")
    private Integer notInThePlanVolume;
    @ApiModelProperty(value = "计划外总额")
    private BigDecimal notInThePlanLumsum;
    @ApiModelProperty(value = "车系计划销量")
    private Integer planCount;
    @ApiModelProperty(value = "车系计划总额")
    private BigDecimal planLumsum;
    @ApiModelProperty(value = "达成合计")
    private Integer reachSum;
    @ApiModelProperty(value = "达成合计总额")
    private BigDecimal reachSumlumsum;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<MonthPlanCarDto> getData() {
        return data;
    }

    public void setData(List<MonthPlanCarDto> data) {
        this.data = data;
    }

    public Integer getInsideThePlanVolume() {
        return insideThePlanVolume;
    }

    public void setInsideThePlanVolume(Integer insideThePlanVolume) {
        this.insideThePlanVolume = insideThePlanVolume;
    }

    public BigDecimal getInsideThePlanLumsum() {
        return insideThePlanLumsum;
    }

    public void setInsideThePlanLumsum(BigDecimal insideThePlanLumsum) {
        this.insideThePlanLumsum = insideThePlanLumsum;
    }

    public Integer getNotInThePlanVolume() {
        return notInThePlanVolume;
    }

    public void setNotInThePlanVolume(Integer notInThePlanVolume) {
        this.notInThePlanVolume = notInThePlanVolume;
    }

    public BigDecimal getNotInThePlanLumsum() {
        return notInThePlanLumsum;
    }

    public void setNotInThePlanLumsum(BigDecimal notInThePlanLumsum) {
        this.notInThePlanLumsum = notInThePlanLumsum;
    }

    public Integer getPlanCount() {
        return planCount;
    }

    public void setPlanCount(Integer planCount) {
        this.planCount = planCount;
    }

    public BigDecimal getPlanLumsum() {
        return planLumsum;
    }

    public void setPlanLumsum(BigDecimal planLumsum) {
        this.planLumsum = planLumsum;
    }

    public Integer getReachSum() {
        return reachSum;
    }

    public void setReachSum(Integer reachSum) {
        this.reachSum = reachSum;
    }

    public BigDecimal getReachSumlumsum() {
        return reachSumlumsum;
    }

    public void setReachSumlumsum(BigDecimal reachSumlumsum) {
        this.reachSumlumsum = reachSumlumsum;
    }
}
