package com.unicdata.condition;

import io.swagger.annotations.ApiModelProperty;

/**
 * 商品车查询条件
 * 
 * @author wxn
 * @date 2018年6月2日
 */
public class CarGoodsCondition {

	@ApiModelProperty(value = "所属整车采购订单id")
	private Integer carOrderId;
	@ApiModelProperty(value = "门店id")
	private Integer distributorStoreId;
	@ApiModelProperty(value = "车架号")
	private String vin;
	@ApiModelProperty(value = "车系来源")
	private Integer sourceId;
	@ApiModelProperty(value = "车系id")
	private Integer familyId;
	@ApiModelProperty(value = "车型配置id")
	private Integer vehicleId;
	@ApiModelProperty(value = "库存状态")
	private Integer storageStatus;
	@ApiModelProperty(value = "处理状态")
	private Integer disposeStatus;
	@ApiModelProperty(value = "订单状态")
	private Integer orderStatus;
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
	@ApiModelProperty(value = "是否远期车")
	private Integer forwardCarStatus;
	@ApiModelProperty(value = "查询类型 1 在库 整车 无订单状态  2 库存状态为在途、在库、外出、整备出库，处理状态为正常、待整备、整备中、暂收，订单状态为无、已预订 3 库存状态为在库、外出、整备出库，处理状态为正常、待整备、整备中、暂收，订单状态为无、已预订")
	private Integer type;
	@ApiModelProperty(value = "在库天数")
	private Integer inStorageDay;
	@ApiModelProperty(value = "采购来源")
	private Integer source;

	private Integer pageSize;

	private Integer pageNum;

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

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
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

	public Integer getStorageStatus() {
		return storageStatus;
	}

	public void setStorageStatus(Integer storageStatus) {
		this.storageStatus = storageStatus;
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

	public Integer getForwardCarStatus() {
		return forwardCarStatus;
	}

	public void setForwardCarStatus(Integer forwardCarStatus) {
		this.forwardCarStatus = forwardCarStatus;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getInStorageDay() {
		return inStorageDay;
	}

	public void setInStorageDay(Integer inStorageDay) {
		this.inStorageDay = inStorageDay;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

}
