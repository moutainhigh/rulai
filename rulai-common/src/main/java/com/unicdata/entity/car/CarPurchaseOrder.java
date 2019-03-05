package com.unicdata.entity.car;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CarPurchaseOrder {
	private Integer id;
	@ApiModelProperty(value = "门店id")
	private Integer distributorStoreId;
	@ApiModelProperty(value = "清单编号")
	private String code;
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "品牌id")
	private Integer brandId;
	@ApiModelProperty(value = "操作人id")
	private Integer operatorId;
	@ApiModelProperty(value = "资金属性(1 金融 2 自采)")
	private Integer fundProperty;
	@ApiModelProperty(value = "供应商名称")
	private String engineName;
	@ApiModelProperty(value = "操作时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date operateDate;
	@ApiModelProperty(value = "指导价总金额")
	private BigDecimal standardPrice;
	@ApiModelProperty(value = "实际购买总金额")
	private BigDecimal perchasePrice;
	@ApiModelProperty(value = "单据状态")
	private Integer orderStatus;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;

	private Integer status;
	@ApiModelProperty(value = "采购来源 1 主机厂商 2 供应商")
	private Integer source;
	@ApiModelProperty(value = "批售返利 1 有 2 没有")
    private Integer batchRebate;
	@ApiModelProperty(value = "零售返利 1 有 2 没有")
    private Integer retailRebate;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getFundProperty() {
		return fundProperty;
	}

	public void setFundProperty(Integer fundProperty) {
		this.fundProperty = fundProperty;
	}

	public String getEngineName() {
		return engineName;
	}

	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public BigDecimal getStandardPrice() {
		return standardPrice;
	}

	public void setStandardPrice(BigDecimal standardPrice) {
		this.standardPrice = standardPrice;
	}

	public BigDecimal getPerchasePrice() {
		return perchasePrice;
	}

	public void setPerchasePrice(BigDecimal perchasePrice) {
		this.perchasePrice = perchasePrice;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
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

	public Integer getSource() {
		return source;
	}

	public Integer getBatchRebate() {
		return batchRebate;
	}

	public Integer getRetailRebate() {
		return retailRebate;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public void setBatchRebate(Integer batchRebate) {
		this.batchRebate = batchRebate;
	}

	public void setRetailRebate(Integer retailRebate) {
		this.retailRebate = retailRebate;
	}
}