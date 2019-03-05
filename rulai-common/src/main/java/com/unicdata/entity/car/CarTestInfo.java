package com.unicdata.entity.car;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CarTestInfo {
    private Integer id;
    @ApiModelProperty(value = "门店id")
    private Integer distributorStoreId;
    @ApiModelProperty(value = "车架号")
    private String vin;
    @ApiModelProperty(value = "品牌id")
    private Integer brandId;
    @ApiModelProperty(value = "车系id")
    private Integer familyId;
    @ApiModelProperty(value = "车型id")
    private Integer vehicleId;
    @ApiModelProperty(value = "车身颜色id")
    private Integer decorationsOutId;
    @ApiModelProperty(value = "车身颜色名称")
    private String decorationsOutName;
    @ApiModelProperty(value = "内饰颜色id")
    private Integer decorationsInId;
    @ApiModelProperty(value = "内饰颜色名称")
    private String decorationsInName;
    @ApiModelProperty(value = "发动机号")
    private String engineNum;
    @ApiModelProperty(value = "试驾车状态")
    private Integer testCarStatus;
    @ApiModelProperty(value = "公里数")
    private Integer miles;
    @ApiModelProperty(value = "车牌号")
    private String licenseNum;
    @ApiModelProperty(value = "操作人id")
    private Integer operatorId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistributorStoreId() {
        return distributorStoreId;
    }

    public void setDistributorStoreId(Integer distributorStoreId) {
        this.distributorStoreId = distributorStoreId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getDecorationsOutId() {
        return decorationsOutId;
    }

    public void setDecorationsOutId(Integer decorationsOutId) {
        this.decorationsOutId = decorationsOutId;
    }

    public String getDecorationsOutName() {
        return decorationsOutName;
    }

    public void setDecorationsOutName(String decorationsOutName) {
        this.decorationsOutName = decorationsOutName;
    }

    public Integer getDecorationsInId() {
        return decorationsInId;
    }

    public void setDecorationsInId(Integer decorationsInId) {
        this.decorationsInId = decorationsInId;
    }

    public String getDecorationsInName() {
        return decorationsInName;
    }

    public void setDecorationsInName(String decorationsInName) {
        this.decorationsInName = decorationsInName;
    }

    public String getEngineNum() {
        return engineNum;
    }

    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }

    public Integer getTestCarStatus() {
        return testCarStatus;
    }

    public void setTestCarStatus(Integer testCarStatus) {
        this.testCarStatus = testCarStatus;
    }

    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}