package com.unicdata.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品分页查询条件")
public class BoutiqueInfoCondition {
	@ApiModelProperty(value = "精品id")
	private Integer id;
	@ApiModelProperty(value = "精品编号")
	private String code;
	@ApiModelProperty(value = "精品名称")
	private String name;
	@ApiModelProperty(value = "供应商id")
	private Integer supplierId;
	@ApiModelProperty(value = "仓库id")
	private Integer warehouseId;
	@ApiModelProperty(value = "库位id")
	private Integer positionId;
	@ApiModelProperty(value = "售卖类型")
	private String saleType;
	@ApiModelProperty(value = "页面大小")
	private Integer pageSize;
	@ApiModelProperty(value = "页码")
	private Integer pageNum;
	
	private Integer storeId;
	
	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	
	
	
}
