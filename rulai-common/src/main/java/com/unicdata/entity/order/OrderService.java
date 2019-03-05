package com.unicdata.entity.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.math.BigDecimal;
@ApiModel("订单-其他服务")
public class OrderService {

	private Integer id;
    @ApiModelProperty("订单id")
	private Integer orderId;
    @ApiModelProperty("服务项id")
	private Integer serviceId;
	private BigDecimal servicePrice;
	private Integer isGift;
    @ApiModelProperty("创建时间")
	private Date createTime;
    private String remark;
	private Integer status;

	private String licensePlateRegion;
	private String licensePlate;
	private BigDecimal sumOtherPrice;
	private BigDecimal donationAmount;
	private BigDecimal totalAmount;
	private BigDecimal margin;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLicensePlateRegion() {
		return licensePlateRegion;
	}

	public void setLicensePlateRegion(String licensePlateRegion) {
		this.licensePlateRegion = licensePlateRegion;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public BigDecimal getSumOtherPrice() {
		return sumOtherPrice;
	}

	public void setSumOtherPrice(BigDecimal sumOtherPrice) {
		this.sumOtherPrice = sumOtherPrice;
	}

	public BigDecimal getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(BigDecimal donationAmount) {
		this.donationAmount = donationAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}
}