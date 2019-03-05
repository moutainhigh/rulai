package com.unicdata.entity.car;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CarInsuranceRecord {
	private Integer id;
	@ApiModelProperty(value = "试驾车id")
	private Integer testCarId;
	@ApiModelProperty(value = "保险公司id")
	private Integer insurerId;
	@ApiModelProperty(value = "险种id")
	private Integer insuranceTypeId;
	@ApiModelProperty(value = "金额")
	private Double price;

	private Integer operatorId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;

	private Integer status;
	@ApiModelProperty(value = "保险到期日")
	private Date endTime;
	@ApiModelProperty(value = "保额")
	private Double insuranceMoney;
	@ApiModelProperty(value = "交强险图片地址")
	private String saliPic;
	@ApiModelProperty(value = "商业险图片地址")
	private String commercialPic;

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

	public Integer getInsurerId() {
		return insurerId;
	}

	public void setInsurerId(Integer insurerId) {
		this.insurerId = insurerId;
	}

	public Integer getInsuranceTypeId() {
		return insuranceTypeId;
	}

	public void setInsuranceTypeId(Integer insuranceTypeId) {
		this.insuranceTypeId = insuranceTypeId;
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

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getInsuranceMoney() {
		return insuranceMoney;
	}

	public void setInsuranceMoney(Double insuranceMoney) {
		this.insuranceMoney = insuranceMoney;
	}

	public String getSaliPic() {
		return saliPic;
	}

	public String getCommercialPic() {
		return commercialPic;
	}

	public void setSaliPic(String saliPic) {
		this.saliPic = saliPic;
	}

	public void setCommercialPic(String commercialPic) {
		this.commercialPic = commercialPic;
	}

}