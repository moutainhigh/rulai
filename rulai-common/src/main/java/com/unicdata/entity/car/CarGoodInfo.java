package com.unicdata.entity.car;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.unicdata.entity.policy.RebateCar;
import io.swagger.annotations.ApiModelProperty;

public class CarGoodInfo {
	private Integer id;
	@ApiModelProperty(value = "所属整车采购订单id")
	private Integer carOrderId;
	@ApiModelProperty(value = "门店id")
	private Integer distributorStoreId;
	@ApiModelProperty(value = "车架号")
	private String vin;
	@ApiModelProperty(value = "年款")
	private String year;
	@ApiModelProperty(value = "品牌id")
	private Integer brandId;
	@ApiModelProperty(value = "车系id")
	private Integer familyId;
	@ApiModelProperty(value = "车型配置id")
	private Integer vehicleId;
	@ApiModelProperty(value = "资金属性(1 金融 2 自采)")
	private Integer fundProperty;
	@ApiModelProperty(value = "供应商名称")
	private String engineName;
	@ApiModelProperty(value = "车身颜色id")
	private Integer decorationsOutId;
	@ApiModelProperty(value = "车身颜色")
	private String decorationsOutName;
	@ApiModelProperty(value = "内饰颜色id")
	private Integer decorationsInId;
	@ApiModelProperty(value = "内饰颜色名称")
	private String decorationsInName;
	@ApiModelProperty(value = "发动机号")
	private String engineNum;
	@ApiModelProperty(value = "钥匙号")
	private String keyNum;
	@ApiModelProperty(value = "合格证号")
	private String certificationNum;
	@ApiModelProperty(value = "进口单号")
	private String importNum;
	@ApiModelProperty(value = "保修卡号")
	private String warrantyNum;
	@ApiModelProperty(value = "厂家商检号")
	private String inspectionNum;
	@ApiModelProperty(value = "标准指导价")
	private BigDecimal standardPrice;
	@ApiModelProperty(value = "实际采购价")
	private BigDecimal purchasePrice;
	@ApiModelProperty(value = "采购金额PIO")
	private BigDecimal purchasePricePio;
	@ApiModelProperty(value = "运费")
	private BigDecimal freightCharge;
	@ApiModelProperty(value = "整车采购价格(运费+采购+PIO）")
	private BigDecimal entirePurchasePrice;
	@ApiModelProperty(value = "含精品指导价")
	private BigDecimal includeBoutiquePrice;
	@ApiModelProperty(value = "采购付款日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date purchaseDate;
	@ApiModelProperty(value = "生产日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date produceDate;
	@ApiModelProperty(value = "下线日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date offlineDate;
	@ApiModelProperty(value = "免息天数")
	private Integer interestFreeDay;
	@ApiModelProperty(value = "是否有选装包（1 是 2 否）")
	private Integer optionalPackageStatus;
	@ApiModelProperty(value = "是否抵押（1 是 2 否）")
	private Integer guarantyStatus;
	@ApiModelProperty(value = "抵押金融公司id")
	private Integer financeCompanyId;
	@ApiModelProperty(value = "抵押金融公司名称")
	private String financeCompanyName;
	@ApiModelProperty(value = "入库时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date inStorageDate;
	@ApiModelProperty(value = "出库时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date outStorageDate;
	@ApiModelProperty(value = "仓库id")
	private Integer warehouseId;
	@ApiModelProperty(value = "库位id")
	private Integer storageId;
	@ApiModelProperty(value = "配车状态")
	private Integer carSupplyStatus;
	@ApiModelProperty(value = "厂家上报状态")
	private Integer factoryReportStatus;
	@ApiModelProperty(value = "是否虚录")
	private Integer virtualRecordStatus;
	@ApiModelProperty(value = "是否瞒报")
	private Integer deceiveReportStatus;
	@ApiModelProperty(value = "是否新增精品")
	private Integer newBoutiqueStatus;
	@ApiModelProperty(value = "冗余字段")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date sellDate;
	@ApiModelProperty(value = "预估返利")
	private BigDecimal forecastProfit;
	@ApiModelProperty(value = "计提返利")
	private BigDecimal countProfit;
	@ApiModelProperty(value = "是否热门车型")
	private Integer hotStatus;
	@ApiModelProperty(value = "是否远期车")
	private Integer forwardCarStatus;
	@ApiModelProperty(value = "首次dms时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date firstDmsDate;
	@ApiModelProperty(value = "实际dms时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date realDmsDate;
	@ApiModelProperty(value = "入库人id")
	private Integer operatorId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;

	private Integer status;
	@ApiModelProperty(value = "二维码地址(两张图片 逗号分隔)")
	private String twoDimensionalCode;
	@ApiModelProperty(value = "计划让价")
	private BigDecimal planAllowPrice;
	@ApiModelProperty(value = "全国统一指导价")
	private BigDecimal nationGuidePrice;
	@ApiModelProperty(value = "整车成本价")
	private BigDecimal costPrice;
	@ApiModelProperty(value = "生产天数")
	private Integer produceDay;
	@ApiModelProperty(value = "到店天数")
	private Integer arriveDay;
	@ApiModelProperty(value = "采购天数")
	private Integer purchaseDay;
	@ApiModelProperty(value = "计息天数")
	private Integer interestAccrualDay;
	@ApiModelProperty(value = "在库天数")
	private Integer inStorageDay;
	@ApiModelProperty(value = "利息金额")
	private BigDecimal interestPrice;
	@ApiModelProperty(value = "剩余还款天数")
	private Integer residueRepaymentDay;
	@ApiModelProperty(value = "全款时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fullPayDate;
	@ApiModelProperty(value = "库存状态 1 在途 2 在库 3 整备出库 4 销售出库 5 外出 6 拒收")
	private Integer storageStatus;
	@ApiModelProperty(value = "处理状态 1 正常 2 待整备 3 整备中 4 暂收")
	private Integer disposeStatus;
	@ApiModelProperty(value = "订单状态 1 无 2 已预订 3 已付全款")
	private Integer orderStatus;
	@ApiModelProperty(value = "销售渠道 1 店内直销 2 置换")
	private Integer salesChannel;
	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	@ApiModelProperty(value = "车系名称")
	private String familyName;
	@ApiModelProperty(value = "车型名称")
	private String vehicleName;
	@ApiModelProperty(value = "车辆盘点id")
	private Integer carCheckId;
	@ApiModelProperty(value = "车辆盘点状态 1未核 2已核")
	private Integer carCheckStatus;
	@ApiModelProperty(value = "汽车入库备注")
	private String instoreRemark;
	@ApiModelProperty(value = "采购来源 1 主机厂商 2 供应商")
	private Integer source;
	@ApiModelProperty(value = "批售返利 1 有 2 没有")
    private Integer batchRebate;
	@ApiModelProperty(value = "零售返利 1 有 2 没有")
    private Integer retailRebate;

	/**
	 * 返利项目度对应信息
	 */
	private RebateCar rebateCar;

	private List<RebateCar> rebateCars;
	@ApiModelProperty(value = "选装包金额")
	private BigDecimal optionalPackageMoney;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCarOrderId() {
		return carOrderId;
	}

	public void setCarOrderId(Integer carOrderId) {
		this.carOrderId = carOrderId;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public String getKeyNum() {
		return keyNum;
	}

	public void setKeyNum(String keyNum) {
		this.keyNum = keyNum;
	}

	public String getCertificationNum() {
		return certificationNum;
	}

	public void setCertificationNum(String certificationNum) {
		this.certificationNum = certificationNum;
	}

	public String getImportNum() {
		return importNum;
	}

	public void setImportNum(String importNum) {
		this.importNum = importNum;
	}

	public String getWarrantyNum() {
		return warrantyNum;
	}

	public void setWarrantyNum(String warrantyNum) {
		this.warrantyNum = warrantyNum;
	}

	public String getInspectionNum() {
		return inspectionNum;
	}

	public void setInspectionNum(String inspectionNum) {
		this.inspectionNum = inspectionNum;
	}

	public BigDecimal getStandardPrice() {
		return standardPrice;
	}

	public void setStandardPrice(BigDecimal standardPrice) {
		this.standardPrice = standardPrice;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getPurchasePricePio() {
		return purchasePricePio;
	}

	public void setPurchasePricePio(BigDecimal purchasePricePio) {
		this.purchasePricePio = purchasePricePio;
	}

	public BigDecimal getFreightCharge() {
		return freightCharge;
	}

	public void setFreightCharge(BigDecimal freightCharge) {
		this.freightCharge = freightCharge;
	}

	public BigDecimal getEntirePurchasePrice() {
		return entirePurchasePrice;
	}

	public void setEntirePurchasePrice(BigDecimal entirePurchasePrice) {
		this.entirePurchasePrice = entirePurchasePrice;
	}

	public BigDecimal getIncludeBoutiquePrice() {
		return includeBoutiquePrice;
	}

	public void setIncludeBoutiquePrice(BigDecimal includeBoutiquePrice) {
		this.includeBoutiquePrice = includeBoutiquePrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}

	public Date getOfflineDate() {
		return offlineDate;
	}

	public void setOfflineDate(Date offlineDate) {
		this.offlineDate = offlineDate;
	}

	public Integer getInterestFreeDay() {
		return interestFreeDay;
	}

	public void setInterestFreeDay(Integer interestFreeDay) {
		this.interestFreeDay = interestFreeDay;
	}

	public Integer getOptionalPackageStatus() {
		return optionalPackageStatus;
	}

	public void setOptionalPackageStatus(Integer optionalPackageStatus) {
		this.optionalPackageStatus = optionalPackageStatus;
	}

	public Integer getGuarantyStatus() {
		return guarantyStatus;
	}

	public void setGuarantyStatus(Integer guarantyStatus) {
		this.guarantyStatus = guarantyStatus;
	}

	public Integer getFinanceCompanyId() {
		return financeCompanyId;
	}

	public void setFinanceCompanyId(Integer financeCompanyId) {
		this.financeCompanyId = financeCompanyId;
	}

	public String getFinanceCompanyName() {
		return financeCompanyName;
	}

	public void setFinanceCompanyName(String financeCompanyName) {
		this.financeCompanyName = financeCompanyName;
	}

	public Integer getStorageStatus() {
		return storageStatus;
	}

	public void setStorageStatus(Integer storageStatus) {
		this.storageStatus = storageStatus;
	}

	public Date getInStorageDate() {
		return inStorageDate;
	}

	public void setInStorageDate(Date inStorageDate) {
		this.inStorageDate = inStorageDate;
	}

	public Date getOutStorageDate() {
		return outStorageDate;
	}

	public void setOutStorageDate(Date outStorageDate) {
		this.outStorageDate = outStorageDate;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getStorageId() {
		return storageId;
	}

	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	public Integer getCarSupplyStatus() {
		return carSupplyStatus;
	}

	public void setCarSupplyStatus(Integer carSupplyStatus) {
		this.carSupplyStatus = carSupplyStatus;
	}

	public Integer getFactoryReportStatus() {
		return factoryReportStatus;
	}

	public void setFactoryReportStatus(Integer factoryReportStatus) {
		this.factoryReportStatus = factoryReportStatus;
	}

	public Integer getVirtualRecordStatus() {
		return virtualRecordStatus;
	}

	public void setVirtualRecordStatus(Integer virtualRecordStatus) {
		this.virtualRecordStatus = virtualRecordStatus;
	}

	public Integer getDeceiveReportStatus() {
		return deceiveReportStatus;
	}

	public void setDeceiveReportStatus(Integer deceiveReportStatus) {
		this.deceiveReportStatus = deceiveReportStatus;
	}

	public Integer getNewBoutiqueStatus() {
		return newBoutiqueStatus;
	}

	public void setNewBoutiqueStatus(Integer newBoutiqueStatus) {
		this.newBoutiqueStatus = newBoutiqueStatus;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}

	public BigDecimal getForecastProfit() {
		return forecastProfit;
	}

	public void setForecastProfit(BigDecimal forecastProfit) {
		this.forecastProfit = forecastProfit;
	}

	public BigDecimal getCountProfit() {
		return countProfit;
	}

	public void setCountProfit(BigDecimal countProfit) {
		this.countProfit = countProfit;
	}

	public Integer getHotStatus() {
		return hotStatus;
	}

	public void setHotStatus(Integer hotStatus) {
		this.hotStatus = hotStatus;
	}

	public Date getFirstDmsDate() {
		return firstDmsDate;
	}

	public void setFirstDmsDate(Date firstDmsDate) {
		this.firstDmsDate = firstDmsDate;
	}

	public Date getRealDmsDate() {
		return realDmsDate;
	}

	public void setRealDmsDate(Date realDmsDate) {
		this.realDmsDate = realDmsDate;
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

	public String getTwoDimensionalCode() {
		return twoDimensionalCode;
	}

	public void setTwoDimensionalCode(String twoDimensionalCode) {
		this.twoDimensionalCode = twoDimensionalCode;
	}

	public Integer getForwardCarStatus() {
		return forwardCarStatus;
	}

	public void setForwardCarStatus(Integer forwardCarStatus) {
		this.forwardCarStatus = forwardCarStatus;
	}

	public BigDecimal getPlanAllowPrice() {
		return planAllowPrice;
	}

	public void setPlanAllowPrice(BigDecimal planAllowPrice) {
		this.planAllowPrice = planAllowPrice;
	}

	public BigDecimal getNationGuidePrice() {
		return nationGuidePrice;
	}

	public void setNationGuidePrice(BigDecimal nationGuidePrice) {
		this.nationGuidePrice = nationGuidePrice;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getProduceDay() {
		return produceDay;
	}

	public void setProduceDay(Integer produceDay) {
		this.produceDay = produceDay;
	}

	public Integer getArriveDay() {
		return arriveDay;
	}

	public void setArriveDay(Integer arriveDay) {
		this.arriveDay = arriveDay;
	}

	public Integer getPurchaseDay() {
		return purchaseDay;
	}

	public void setPurchaseDay(Integer purchaseDay) {
		this.purchaseDay = purchaseDay;
	}

	public Integer getInterestAccrualDay() {
		return interestAccrualDay;
	}

	public void setInterestAccrualDay(Integer interestAccrualDay) {
		this.interestAccrualDay = interestAccrualDay;
	}

	public BigDecimal getInterestPrice() {
		return interestPrice;
	}

	public void setInterestPrice(BigDecimal interestPrice) {
		this.interestPrice = interestPrice;
	}

	public Integer getResidueRepaymentDay() {
		return residueRepaymentDay;
	}

	public void setResidueRepaymentDay(Integer residueRepaymentDay) {
		this.residueRepaymentDay = residueRepaymentDay;
	}

	public Integer getInStorageDay() {
		return inStorageDay;
	}

	public void setInStorageDay(Integer inStorageDay) {
		this.inStorageDay = inStorageDay;
	}

	public RebateCar getRebateCar() {
		return rebateCar;
	}

	public void setRebateCar(RebateCar rebateCar) {
		this.rebateCar = rebateCar;
	}

	public Date getFullPayDate() {
		return fullPayDate;
	}

	public void setFullPayDate(Date fullPayDate) {
		this.fullPayDate = fullPayDate;
	}

	public Integer getDisposeStatus() {
		return disposeStatus;
	}

	public void setDisposeStatus(Integer disposeStatus) {
		this.disposeStatus = disposeStatus;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Integer getCarCheckId() {
		return carCheckId;
	}

	public void setCarCheckId(Integer carCheckId) {
		this.carCheckId = carCheckId;
	}

	public Integer getCarCheckStatus() {
		return carCheckStatus;
	}

	public void setCarCheckStatus(Integer carCheckStatus) {
		this.carCheckStatus = carCheckStatus;
	}

	public List<RebateCar> getRebateCars() {
		return rebateCars;
	}

	public void setRebateCars(List<RebateCar> rebateCars) {
		this.rebateCars = rebateCars;
	}

	public String getInstoreRemark() {
		return instoreRemark;
	}

	public void setInstoreRemark(String instoreRemark) {
		this.instoreRemark = instoreRemark;
	}

	public Integer getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(Integer salesChannel) {
		this.salesChannel = salesChannel;
	}

	public BigDecimal getOptionalPackageMoney() {
		return optionalPackageMoney;
	}

	public void setOptionalPackageMoney(BigDecimal optionalPackageMoney) {
		this.optionalPackageMoney = optionalPackageMoney;
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