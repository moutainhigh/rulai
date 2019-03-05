package com.unicdata.entity.car;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CarBoutiqueBinding {
	private Integer id;

	private Integer carId;

	private Integer boutiqueId;
	@ApiModelProperty(value = "数量")
	private Integer boutiqueNum;

	private Integer operatorId;

	private Integer status;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getBoutiqueId() {
		return boutiqueId;
	}

	public void setBoutiqueId(Integer boutiqueId) {
		this.boutiqueId = boutiqueId;
	}

	public Integer getBoutiqueNum() {
		return boutiqueNum;
	}

	public void setBoutiqueNum(Integer boutiqueNum) {
		this.boutiqueNum = boutiqueNum;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
}