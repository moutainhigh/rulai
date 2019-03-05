package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class OrderQuotedPrice {
    private Integer id;

	private Integer orderId;

	private Integer boutiqueOrderId;

	private String number;

	private String vehicleName;

	private BigDecimal vehiclePrice;

	private BigDecimal boutiquePrice;

	private BigDecimal orderSumPrice;

	private BigDecimal payFirst;

	private BigDecimal profit;

	private Date applyTime;

	private Integer state;

	private Integer employeeId;

	private Date creatTime;

	private Integer vehicleId;

	private Integer cusId;

	private Integer quotedStatus;
	
	private String stateDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getBoutiqueOrderId() {
		return boutiqueOrderId;
	}

	public void setBoutiqueOrderId(Integer boutiqueOrderId) {
		this.boutiqueOrderId = boutiqueOrderId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public BigDecimal getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(BigDecimal vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public BigDecimal getBoutiquePrice() {
		return boutiquePrice;
	}

	public void setBoutiquePrice(BigDecimal boutiquePrice) {
		this.boutiquePrice = boutiquePrice;
	}

	public BigDecimal getOrderSumPrice() {
		return orderSumPrice;
	}

	public void setOrderSumPrice(BigDecimal orderSumPrice) {
		this.orderSumPrice = orderSumPrice;
	}

	public BigDecimal getPayFirst() {
		return payFirst;
	}

	public void setPayFirst(BigDecimal payFirst) {
		this.payFirst = payFirst;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public Integer getQuotedStatus() {
		return quotedStatus;
	}

	public void setQuotedStatus(Integer quotedStatus) {
		this.quotedStatus = quotedStatus;
	}

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }
}