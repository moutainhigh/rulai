package com.unicdata.entity.boutique;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "仓库和库位变更操作明细")
public class BoutiqueWarehouseChangeDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4483373663645839008L;

	@ApiModelProperty(value = "仓库和库位变更操作明细Id")
    private Integer id;
	@ApiModelProperty(value = "操作节点(  0 - 变更前 ; 1 - 变更后 )")
	private Integer type;
	
	@ApiModelProperty(value = "变更id")
	private Integer changeId;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;
	@ApiModelProperty(value = "精品id")
    private Integer boutiqueId;
	@ApiModelProperty(value = "精品仓库id")
    private Integer warehouseId;
	@ApiModelProperty(value = "精品仓库库位id")
    private Integer positionId;
	@ApiModelProperty(value = "库存数")
    private Integer stock;

    private Integer typeLive;

    
	@ApiModelProperty(value = "精品编号")
    private String code;
	@ApiModelProperty(value = "精品名称")
    private String name;
    
	@ApiModelProperty(value = "精品仓库名称")
    private String warehouseIdStr;
	@ApiModelProperty(value = "精品仓库库位名称")
    private String positionIdStr;
	
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

	public String getWarehouseIdStr() {
		return warehouseIdStr;
	}

	public void setWarehouseIdStr(String warehouseIdStr) {
		this.warehouseIdStr = warehouseIdStr;
	}

	public String getPositionIdStr() {
		return positionIdStr;
	}

	public void setPositionIdStr(String positionIdStr) {
		this.positionIdStr = positionIdStr;
	}

	public Integer getTypeLive() {
		return typeLive;
	}

	public void setTypeLive(Integer typeLive) {
		this.typeLive = typeLive;
	}
	
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChangeId() {
        return changeId;
    }

    public void setChangeId(Integer changeId) {
        this.changeId = changeId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBoutiqueId() {
        return boutiqueId;
    }

    public void setBoutiqueId(Integer boutiqueId) {
        this.boutiqueId = boutiqueId;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}