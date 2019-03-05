package com.unicdata.entity.letprice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "月度计划扩展表")
public class MonthPlanExt {

    private Integer monthPlanId;

    @ApiModelProperty(value = "月度计划快照" ,hidden = true)
    private String monthPlanSnapshot;

    public Integer getMonthPlanId() {
        return monthPlanId;
    }

    public void setMonthPlanId(Integer monthPlanId) {
        this.monthPlanId = monthPlanId;
    }

    public String getMonthPlanSnapshot() {
        return monthPlanSnapshot;
    }

    public void setMonthPlanSnapshot(String monthPlanSnapshot) {
        this.monthPlanSnapshot = monthPlanSnapshot;
    }
}