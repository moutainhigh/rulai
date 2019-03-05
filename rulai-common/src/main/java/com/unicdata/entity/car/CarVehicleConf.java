package com.unicdata.entity.car;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CarVehicleConf {
	private Integer id;
	@ApiModelProperty(value = "门店id")
	private Integer distributorStoreId;
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "品牌id")
	private Integer brandId;

	private Integer factoryId;
	@ApiModelProperty(value = "车系id")
	private Integer familyId;
	@ApiModelProperty(value = "图片地址")
	private String picture;
	@ApiModelProperty(value = "指导价格")
	private BigDecimal guidePrice;
	@ApiModelProperty(value = "采购价")
	private BigDecimal purchasePrice;
	@ApiModelProperty(value = "延保年限")
	private Integer extendWarrantyYear;
	@ApiModelProperty(value = "延保公里数")
	private Integer extendWarrantyMile;
	@ApiModelProperty(value = "第一级别报价")
	private BigDecimal levelOne;
	@ApiModelProperty(value = "第二级别报价")
	private BigDecimal levelTwo;
	@ApiModelProperty(value = "第三级别报价")
	private BigDecimal levelThree;
	@ApiModelProperty(value = "操作人id")
	private Integer operatorId;
	@ApiModelProperty(value = "年款")
	private String year;
	@ApiModelProperty(value = "销售状态 1 可售 2 不可售")
	private Integer sellStatus;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;

	private Integer status;

	@ApiModelProperty(value = "第一级别报价调整")
	private BigDecimal levelOneAdjust;
	@ApiModelProperty(value = "第二级别报价调整")
	private BigDecimal levelTwoAdjust;
	@ApiModelProperty(value = "第三级别报价调整")
	private BigDecimal levelThreeAdjust;
	@ApiModelProperty(value = "调整状态 0未报备，1待报备，2待审批，3已审批，4驳回")
	private Integer adjustStatus;

	@ApiModelProperty(value = "平均返利预估")
	private BigDecimal avgForecastProfit;
	@ApiModelProperty(value = "平均毛利预估")
	private BigDecimal avgGrossProfit;
	@ApiModelProperty(value = "整车毛利总额")
	private BigDecimal vehicleGrossProfit;
	@ApiModelProperty(value = "库存数量")
	private Long stockQuantity;

	@ApiModelProperty(value = "车系")
	private CarFamily carFamily;

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

	public Integer getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Integer factoryId) {
		this.factoryId = factoryId;
	}

	public Integer getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public BigDecimal getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(BigDecimal guidePrice) {
		this.guidePrice = guidePrice;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getLevelOne() {
		return levelOne;
	}

	public void setLevelOne(BigDecimal levelOne) {
		this.levelOne = levelOne;
	}

	public BigDecimal getLevelTwo() {
		return levelTwo;
	}

	public void setLevelTwo(BigDecimal levelTwo) {
		this.levelTwo = levelTwo;
	}

	public BigDecimal getLevelThree() {
		return levelThree;
	}

	public void setLevelThree(BigDecimal levelThree) {
		this.levelThree = levelThree;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getSellStatus() {
		return sellStatus;
	}

	public void setSellStatus(Integer sellStatus) {
		this.sellStatus = sellStatus;
	}

	public BigDecimal getLevelOneAdjust() {
		return levelOneAdjust;
	}

	public void setLevelOneAdjust(BigDecimal levelOneAdjust) {
		this.levelOneAdjust = levelOneAdjust;
	}

	public BigDecimal getLevelTwoAdjust() {
		return levelTwoAdjust;
	}

	public void setLevelTwoAdjust(BigDecimal levelTwoAdjust) {
		this.levelTwoAdjust = levelTwoAdjust;
	}

	public BigDecimal getLevelThreeAdjust() {
		return levelThreeAdjust;
	}

	public void setLevelThreeAdjust(BigDecimal levelThreeAdjust) {
		this.levelThreeAdjust = levelThreeAdjust;
	}

	public Integer getAdjustStatus() {
		return adjustStatus;
	}

	public void setAdjustStatus(Integer adjustStatus) {
		this.adjustStatus = adjustStatus;
	}

	public Integer getExtendWarrantyYear() {
		return extendWarrantyYear;
	}

	public Integer getExtendWarrantyMile() {
		return extendWarrantyMile;
	}

	public void setExtendWarrantyYear(Integer extendWarrantyYear) {
		this.extendWarrantyYear = extendWarrantyYear;
	}

	public void setExtendWarrantyMile(Integer extendWarrantyMile) {
		this.extendWarrantyMile = extendWarrantyMile;
	}

	public BigDecimal getAvgForecastProfit() {
		return avgForecastProfit;
	}

	public void setAvgForecastProfit(BigDecimal avgForecastProfit) {
		this.avgForecastProfit = avgForecastProfit;
	}

	public BigDecimal getAvgGrossProfit() {
		return avgGrossProfit;
	}

	public void setAvgGrossProfit(BigDecimal avgGrossProfit) {
		this.avgGrossProfit = avgGrossProfit;
	}

	public BigDecimal getVehicleGrossProfit() {
		return vehicleGrossProfit;
	}

	public void setVehicleGrossProfit(BigDecimal vehicleGrossProfit) {
		this.vehicleGrossProfit = vehicleGrossProfit;
	}

	public Long getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public CarFamily getCarFamily() {
		return carFamily;
	}

	public void setCarFamily(CarFamily carFamily) {
		this.carFamily = carFamily;
	}
}