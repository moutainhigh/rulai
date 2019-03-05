package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class OrderServiceItem {

	private Integer id;

	private Integer orderServiceId;

	private Integer serviceId;

	private BigDecimal servicePrice;

	private Integer isGift;

	private String remark;

	private String brand;

	private BigDecimal donationAmount;

	private Date createTime;

	private Integer status;
	
	private String licensePlate;

	private Integer licensePlateProvince;

	private Integer licensePlateCity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderServiceId() {
		return orderServiceId;
	}

	public void setOrderServiceId(Integer orderServiceId) {
		this.orderServiceId = orderServiceId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public BigDecimal getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(BigDecimal servicePrice) {
		this.servicePrice = servicePrice;
	}

	public Integer getIsGift() {
		return isGift;
	}

	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(BigDecimal donationAmount) {
		this.donationAmount = donationAmount;
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

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Integer getLicensePlateProvince() {
		return licensePlateProvince;
	}

	public void setLicensePlateProvince(Integer licensePlateProvince) {
		this.licensePlateProvince = licensePlateProvince;
	}

	public Integer getLicensePlateCity() {
		return licensePlateCity;
	}

	public void setLicensePlateCity(Integer licensePlateCity) {
		this.licensePlateCity = licensePlateCity;
	}
	
}