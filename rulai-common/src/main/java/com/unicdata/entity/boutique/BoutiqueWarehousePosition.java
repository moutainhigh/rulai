package com.unicdata.entity.boutique;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品库 库位表")
public class BoutiqueWarehousePosition implements Serializable{

	private static final long serialVersionUID = 8357339978423121818L;

	@ApiModelProperty(value = "精品库 库位Id")
    private Integer id;
	@ApiModelProperty(value = "库位编号")
    private Integer num;
	@ApiModelProperty(value = "库位名称")
    private String name;
	@ApiModelProperty(value = "仓库id")
    private Integer warehouseId;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;

    private Integer typeLive;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}