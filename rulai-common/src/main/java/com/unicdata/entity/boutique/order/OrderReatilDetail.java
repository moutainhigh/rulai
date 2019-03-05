package com.unicdata.entity.boutique.order;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "销售明细 -- 精品项目")
public class OrderReatilDetail {
	
	@ApiModelProperty(value = "精品金额")
	private BigDecimal allCount = new BigDecimal(0);//精品金额
	@ApiModelProperty(value = "已施工金额")
	private BigDecimal alreadyCount = new BigDecimal(0);//已施工金额
	@ApiModelProperty(value = "已施工材料成本金额")
	private BigDecimal alreadyMaterial = new BigDecimal(0);//已施工材料成本金额
	@ApiModelProperty(value = "已施工人工成本金额")
	private BigDecimal alreadyPeople  = new BigDecimal(0);//已施工人工成本金额
	@ApiModelProperty(value = "已施工毛利金额")
	private BigDecimal alreadyProfit  = new BigDecimal(0);//已施工毛利金额
	@ApiModelProperty(value = "已施工赠送金额")
	private BigDecimal alreadyGift  = new BigDecimal(0);//已施工赠送金额
	@ApiModelProperty(value = "未施工金额")
	private BigDecimal notCount = new BigDecimal(0);//未施工金额
	@ApiModelProperty(value = "未施工材料成本金额")
	private BigDecimal notMaterial = new BigDecimal(0);//未施工材料成本金额
	@ApiModelProperty(value = "未施工人工成本金额")
	private BigDecimal notPeople  = new BigDecimal(0); //未施工人工成本金额
	@ApiModelProperty(value = "未施工毛利金额")
	private BigDecimal notProfit  = new BigDecimal(0);//未施工毛利金额
	@ApiModelProperty(value = "未施工赠送金额")
	private BigDecimal notGift = new BigDecimal(0);//未施工赠送金额
	@ApiModelProperty(value = "总预估毛利")
	private BigDecimal allProfit = new BigDecimal(0);//总预估毛利

	public BigDecimal getAllCount() {
		return allCount;
	}

	public void setAllCount(BigDecimal allCount) {
		this.allCount = allCount;
	}

	public BigDecimal getAlreadyCount() {
		return alreadyCount;
	}

	public void setAlreadyCount(BigDecimal alreadyCount) {
		this.alreadyCount = alreadyCount;
	}

	public BigDecimal getAlreadyMaterial() {
		return alreadyMaterial;
	}

	public void setAlreadyMaterial(BigDecimal alreadyMaterial) {
		this.alreadyMaterial = alreadyMaterial;
	}

	public BigDecimal getAlreadyPeople() {
		return alreadyPeople;
	}

	public void setAlreadyPeople(BigDecimal alreadyPeople) {
		this.alreadyPeople = alreadyPeople;
	}

	public BigDecimal getAlreadyProfit() {
		return alreadyProfit;
	}

	public void setAlreadyProfit(BigDecimal alreadyProfit) {
		this.alreadyProfit = alreadyProfit;
	}

	public BigDecimal getAlreadyGift() {
		return alreadyGift;
	}

	public void setAlreadyGift(BigDecimal alreadyGift) {
		this.alreadyGift = alreadyGift;
	}

	public BigDecimal getNotCount() {
		return notCount;
	}

	public void setNotCount(BigDecimal notCount) {
		this.notCount = notCount;
	}

	public BigDecimal getNotMaterial() {
		return notMaterial;
	}

	public void setNotMaterial(BigDecimal notMaterial) {
		this.notMaterial = notMaterial;
	}

	public BigDecimal getNotPeople() {
		return notPeople;
	}

	public void setNotPeople(BigDecimal notPeople) {
		this.notPeople = notPeople;
	}

	public BigDecimal getNotProfit() {
		return notProfit;
	}

	public void setNotProfit(BigDecimal notProfit) {
		this.notProfit = notProfit;
	}

	public BigDecimal getNotGift() {
		return notGift;
	}

	public void setNotGift(BigDecimal notGift) {
		this.notGift = notGift;
	}

	public BigDecimal getAllProfit() {
		return allProfit;
	}

	public void setAllProfit(BigDecimal allProfit) {
		this.allProfit = allProfit;
	}
	
}
