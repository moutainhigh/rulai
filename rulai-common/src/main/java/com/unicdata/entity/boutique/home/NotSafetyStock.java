package com.unicdata.entity.boutique.home;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品经理首页-不安全库存")
public class NotSafetyStock {
	
	@ApiModelProperty(value = "精品名称")
	private String iName;
	@ApiModelProperty(value = "销售价格")
	private BigDecimal unitprice;
	@ApiModelProperty(value = "供应商名称")
	private String bsName;
	@ApiModelProperty(value = "精品品牌名称")
	private String bbName;
	@ApiModelProperty(value = "安全库存")
	private Integer safety_stock;
	@ApiModelProperty(value = "库存")
	private Integer stock;
	@ApiModelProperty(value = "仓库")
	private String bwName;
	@ApiModelProperty(value = "库位")
	private String wpName;
	
	
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public BigDecimal getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}
	public String getBsName() {
		return bsName;
	}
	public void setBsName(String bsName) {
		this.bsName = bsName;
	}
	public String getBbName() {
		return bbName;
	}
	public void setBbName(String bbName) {
		this.bbName = bbName;
	}
	public Integer getSafety_stock() {
		return safety_stock;
	}
	public void setSafety_stock(Integer safety_stock) {
		this.safety_stock = safety_stock;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getBwName() {
		return bwName;
	}
	public void setBwName(String bwName) {
		this.bwName = bwName;
	}
	public String getWpName() {
		return wpName;
	}
	public void setWpName(String wpName) {
		this.wpName = wpName;
	}
	
	
	
	
}
