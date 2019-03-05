package com.unicdata.entity.letprice;

import com.unicdata.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by shenyong on 2018/6/14.
 */
@ApiModel(value = "月度计划关联库存保存DTO")
public class MonthPlanSaveDTO extends BaseEntity {

    @ApiModelProperty(value = "月度计划id")
    private Integer monthPlanId;
    @ApiModelProperty(value = "车辆id")
    private Integer carId ;
    @ApiModelProperty(value = "车型id")
    private Integer vehicleId ;
    @ApiModelProperty(value = "第一级别报价调整")
    private BigDecimal levelOne ;
    @ApiModelProperty(value = "第二级别报价调整")
    private BigDecimal levelTwo ;
    @ApiModelProperty(value = "第三级别报价调整")
    private BigDecimal levelThree;
    @ApiModelProperty(value = "是否选中/取消 1选中，2取消选中")
    private Integer isSelect;
    @ApiModelProperty(value = "是否修改 1无修改，2有修改")
    private Integer isModify;
    @ApiModelProperty(value = "员工id")
    private Integer employeeId;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
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

    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }

    public Integer getIsModify() {
        return isModify == null ? 1 : isModify;
    }

    public void setIsModify(Integer isModify) {
        this.isModify = isModify;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getMonthPlanId() {
        return monthPlanId;
    }

    public void setMonthPlanId(Integer monthPlanId) {
        this.monthPlanId = monthPlanId;
    }
}
