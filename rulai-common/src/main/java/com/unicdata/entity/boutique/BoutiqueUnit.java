package com.unicdata.entity.boutique;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品单位")
public class BoutiqueUnit {
	@ApiModelProperty(value = "id")
    private Integer id;
	@ApiModelProperty(value = "单位名称")
    private String unit;

	@ApiModelProperty(value = "门店id")
	private Integer storeId;
	
    public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}