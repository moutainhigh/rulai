package com.unicdata.entity.boutique.home;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品经理首页-本月收入、毛利、交车、台次")
public class HomeAllMonthData {
	@ApiModelProperty(value = "本月收入达成")
	private String incomeSum;//

	@ApiModelProperty(value = "本月收入进度")
	private String incomeProcess;
	
	@ApiModelProperty(value = "本月毛利达成")
	private String marginSum;
	
	@ApiModelProperty(value = "本月毛利进度")
	private String marginSumProcess;
	
	@ApiModelProperty(value = "本月交车计划单产")
	private String deliverSum;
	
	@ApiModelProperty(value = "本月交车实际单产")
	private String actualSum;
	
	public String getActualSum() {
		return actualSum;
	}

	public void setActualSum(String actualSum) {
		this.actualSum = actualSum;
	}

	public String getDeliverSum() {
		return deliverSum;
	}

	public void setDeliverSum(String deliverSum) {
		this.deliverSum = deliverSum;
	}

	public String getMarginSumProcess() {
		return marginSumProcess;
	}

	public void setMarginSumProcess(String marginSumProcess) {
		this.marginSumProcess = marginSumProcess;
	}

	public String getMarginSum() {
		return marginSum;
	}

	public void setMarginSum(String marginSum) {
		this.marginSum = marginSum;
	}

	public String getIncomeProcess() {
		return incomeProcess;
	}

	public void setIncomeProcess(String incomeProcess) {
		this.incomeProcess = incomeProcess;
	}

	public String getIncomeSum() {
		return incomeSum;
	}

	public void setIncomeSum(String incomeSum) {
		this.incomeSum = incomeSum;
	}
	
	
	
	
	
}
