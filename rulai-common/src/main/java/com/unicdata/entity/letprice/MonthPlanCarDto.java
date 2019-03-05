package com.unicdata.entity.letprice;

import com.unicdata.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by myMsi on 2018/6/13.
 */
@ApiModel(value = "库存信息列表DTO")
public class MonthPlanCarDto extends BaseEntity{

    @ApiModelProperty(value = "车辆id")
    private Integer carId ;
    @ApiModelProperty(value = "品牌名称")
    private String brandName ;
    @ApiModelProperty(value = "车系名称")
    private String familyName ;
    @ApiModelProperty(value = "车型名称")
    private String vehicleName ;
    @ApiModelProperty(value = "车型id")
    private Integer vehicleId ;
    @ApiModelProperty(value = "年款")
    private Integer year;
    @ApiModelProperty(value = "车身颜色")
    private String decorationsOutName ;
    @ApiModelProperty(value = "厂商指导价")
    private BigDecimal standardPrice ;
    @ApiModelProperty(value = "实际采购价")
    private BigDecimal purchasePrice ;
    @ApiModelProperty(value = "预估返利")
    private BigDecimal forecastProfit ;
    @ApiModelProperty(value = "计划让价")
    private BigDecimal planAllowPrice ;
    @ApiModelProperty(value = "订单状态 1 无 2 已预订 3 已付全款")
    private Integer orderStatus;
    @ApiModelProperty(value = "毛利第一级别报价调整")
    private BigDecimal grossProfitOne;
    @ApiModelProperty(value = "毛利第二级别报价调整")
    private BigDecimal grossProfitTwo;
    @ApiModelProperty(value = "毛利第三级别报价调整")
    private BigDecimal grossProfitThree;
    @ApiModelProperty(value = "车型第一级别报价调整" ,hidden = true)
    private BigDecimal vehicleLevelOne;
    @ApiModelProperty(value = "车型第二级别报价调整" ,hidden = true)
    private BigDecimal vehicleLevelTwo;
    @ApiModelProperty(value = "车型第三级别报价调整" ,hidden = true)
    private BigDecimal vehicleLevelThree ;
    @ApiModelProperty(value = "第一级别报价调整")
    private BigDecimal levelOne ;
    @ApiModelProperty(value = "第二级别报价调整")
    private BigDecimal levelTwo ;
    @ApiModelProperty(value = "第三级别报价调整")
    private BigDecimal levelThree;
    @ApiModelProperty(value = "是否选中 1未选中，2已选中")
    private Integer isSelect;
    @ApiModelProperty(value = "状态 1初始状态，2待审核，3正常，5驳回")
    private Integer status;
    @ApiModelProperty(value = "实际整车毛利")
    private BigDecimal carGrossProfit;
    @ApiModelProperty(value = "在库天数")
    private Integer inStorageDay;


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDecorationsOutName() {
        return decorationsOutName;
    }

    public void setDecorationsOutName(String decorationsOutName) {
        this.decorationsOutName = decorationsOutName;
    }

    public BigDecimal getStandardPrice() {
        return standardPrice == null ? BigDecimal.ZERO : standardPrice;
    }

    public void setStandardPrice(BigDecimal standardPrice) {
        this.standardPrice = standardPrice;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice == null ? BigDecimal.ZERO : purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getForecastProfit() {
        return forecastProfit == null ? BigDecimal.ZERO : forecastProfit;
    }

    public void setForecastProfit(BigDecimal forecastProfit) {
        this.forecastProfit = forecastProfit;
    }

    public BigDecimal getPlanAllowPrice() {
        return planAllowPrice == null ? BigDecimal.ZERO : planAllowPrice;
    }

    public void setPlanAllowPrice(BigDecimal planAllowPrice) {
        this.planAllowPrice = planAllowPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getVehicleLevelOne() {
        return vehicleLevelOne == null ? BigDecimal.ZERO : vehicleLevelOne;
    }

    public void setVehicleLevelOne(BigDecimal vehicleLevelOne) {
        this.vehicleLevelOne = vehicleLevelOne;
    }

    public BigDecimal getVehicleLevelTwo() {
        return vehicleLevelTwo == null ? BigDecimal.ZERO : vehicleLevelTwo;
    }

    public void setVehicleLevelTwo(BigDecimal vehicleLevelOne) {
        this.vehicleLevelTwo = vehicleLevelOne;
    }

    public BigDecimal getVehicleLevelThree() {
        return vehicleLevelThree == null ? BigDecimal.ZERO : vehicleLevelThree;
    }

    public void setVehicleLevelThree(BigDecimal vehicleLevelThree) {
        this.vehicleLevelThree = vehicleLevelThree;
    }

    public BigDecimal getLevelOne() {
        return levelOne == null ? BigDecimal.ZERO : levelOne;
    }

    public void setLevelOne(BigDecimal levelOne) {
        this.levelOne = levelOne;
    }

    public BigDecimal getLevelTwo() {
        return levelTwo == null ? BigDecimal.ZERO : levelTwo;
    }

    public void setLevelTwo(BigDecimal levelTwo) {
        this.levelTwo = levelTwo;
    }

    public BigDecimal getLevelThree() {
        return levelThree  == null ? BigDecimal.ZERO : levelThree;
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

    public BigDecimal getGrossProfitOne() {
        return grossProfitOne == null ? BigDecimal.ZERO : grossProfitOne;
    }

    public void setGrossProfitOne(BigDecimal grossProfitOne) {
        this.grossProfitOne = grossProfitOne;
    }

    public BigDecimal getGrossProfitTwo() {
        return grossProfitTwo == null ? BigDecimal.ZERO : grossProfitTwo;
    }

    public void setGrossProfitTwo(BigDecimal grossProfitTwo) {
        this.grossProfitTwo = grossProfitTwo;
    }

    public BigDecimal getGrossProfitThree() {
        return grossProfitThree == null ? BigDecimal.ZERO : grossProfitThree;
    }

    public void setGrossProfitThree(BigDecimal grossProfitThree) {
        this.grossProfitThree = grossProfitThree;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public BigDecimal getCarGrossProfit() {
        return carGrossProfit;
    }

    public void setCarGrossProfit(BigDecimal carGrossProfit) {
        this.carGrossProfit = carGrossProfit;
    }

    public Integer getInStorageDay() {
        return inStorageDay;
    }

    public void setInStorageDay(Integer inStorageDay) {
        this.inStorageDay = inStorageDay;
    }
}