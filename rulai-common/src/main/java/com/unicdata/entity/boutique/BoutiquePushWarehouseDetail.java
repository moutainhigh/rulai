package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品入库详情")
public class BoutiquePushWarehouseDetail implements Serializable{
	@ApiModelProperty(value = "精品入库详情id")
    private Integer id;
	@ApiModelProperty(value = "精品入库id")
    private Integer pushId;
	@ApiModelProperty(value = "精品id")
    private Integer boutiqueId;
	@ApiModelProperty(value = "精品编号")
    private String boutiqueCode;
	@ApiModelProperty(value = "精品名称")
    private String boutiqueName;
	@ApiModelProperty(value = "入库数量")
    private Integer stock;
	@ApiModelProperty(value = "含税单价")
    private BigDecimal taxUnitPrice;
	@ApiModelProperty(value = "含税成本")
    private BigDecimal taxCost;
	@ApiModelProperty(value = "销售单价")
    private BigDecimal salesCost;
	@ApiModelProperty(value = "售卖类型")
    private String salesType;

    private Integer storeId;

    private Date timestamp;

    private Integer typeLive;

    private Integer rowRed;
    
    private Integer nameRed;
    
    private Integer stockRed ;
    
    private Integer taxUnitPriceRed ;
    
    
    public Integer getRowRed() {
		return rowRed;
	}

	public void setRowRed(Integer rowRed) {
		this.rowRed = rowRed;
	}

	public Integer getNameRed() {
		return nameRed;
	}

	public void setNameRed(Integer nameRed) {
		this.nameRed = nameRed;
	}

	public Integer getStockRed() {
		return stockRed;
	}

	public void setStockRed(Integer stockRed) {
		this.stockRed = stockRed;
	}

	public Integer getTaxUnitPriceRed() {
		return taxUnitPriceRed;
	}

	public void setTaxUnitPriceRed(Integer taxUnitPriceRed) {
		this.taxUnitPriceRed = taxUnitPriceRed;
	}

	public String getBoutiqueCode() {
		return boutiqueCode;
	}

	public void setBoutiqueCode(String boutiqueCode) {
		this.boutiqueCode = boutiqueCode;
	}

	public String getBoutiqueName() {
		return boutiqueName;
	}

	public void setBoutiqueName(String boutiqueName) {
		this.boutiqueName = boutiqueName;
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

    public Integer getPushId() {
        return pushId;
    }

    public void setPushId(Integer pushId) {
        this.pushId = pushId;
    }

    public Integer getBoutiqueId() {
        return boutiqueId;
    }

    public void setBoutiqueId(Integer boutiqueId) {
        this.boutiqueId = boutiqueId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getTaxUnitPrice() {
        return taxUnitPrice;
    }

    public void setTaxUnitPrice(BigDecimal taxUnitPrice) {
        this.taxUnitPrice = taxUnitPrice;
    }

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public BigDecimal getSalesCost() {
        return salesCost;
    }

    public void setSalesCost(BigDecimal salesCost) {
        this.salesCost = salesCost;
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}