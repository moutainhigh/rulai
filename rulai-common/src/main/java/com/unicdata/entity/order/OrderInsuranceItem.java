package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInsuranceItem {
    private Integer id;

    private Integer orderInsuranceId;

    private Integer insuranceId;

    private String remarks;

    private BigDecimal insuredAmount;

    private Integer level;

    private Integer parentId;

    private Date createTime;

    private Integer status;

    private BigDecimal price;

    private Date deadline;

    private String number;

    private Integer carCharacter;

    private String insuranceImg;

    private Integer type;

    private BigDecimal vehicleVesselTax;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderInsuranceId() {
        return orderInsuranceId;
    }

    public void setOrderInsuranceId(Integer orderInsuranceId) {
        this.orderInsuranceId = orderInsuranceId;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(BigDecimal insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCarCharacter() {
        return carCharacter;
    }

    public void setCarCharacter(Integer carCharacter) {
        this.carCharacter = carCharacter;
    }

    public String getInsuranceImg() {
        return insuranceImg;
    }

    public void setInsuranceImg(String insuranceImg) {
        this.insuranceImg = insuranceImg;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getVehicleVesselTax() {
        return vehicleVesselTax;
    }

    public void setVehicleVesselTax(BigDecimal vehicleVesselTax) {
        this.vehicleVesselTax = vehicleVesselTax;
    }
}