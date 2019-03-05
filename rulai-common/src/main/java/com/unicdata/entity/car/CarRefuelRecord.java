package com.unicdata.entity.car;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CarRefuelRecord {
    private Integer id;
    @ApiModelProperty(value = "试驾车id")
    private Integer testCarId;
    @ApiModelProperty(value = "油量")
    private Double fuelCapacity;
    @ApiModelProperty(value = "价格")
    private BigDecimal price;
    @ApiModelProperty(value = "油票")
    private String gasolineCoupon;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "操作人id")
    private Integer operatorId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    private Integer status;
    @ApiModelProperty(value = "油卡登记")
    private String oilCard;
    

    public String getOilCard() {
		return oilCard;
	}

	public void setOilCard(String oilCard) {
		this.oilCard = oilCard;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestCarId() {
        return testCarId;
    }

    public void setTestCarId(Integer testCarId) {
        this.testCarId = testCarId;
    }

    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGasolineCoupon() {
        return gasolineCoupon;
    }

    public void setGasolineCoupon(String gasolineCoupon) {
        this.gasolineCoupon = gasolineCoupon;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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