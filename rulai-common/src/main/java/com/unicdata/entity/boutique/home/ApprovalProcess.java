package com.unicdata.entity.boutique.home;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品经理首页-审批处理")
public class ApprovalProcess {
	@ApiModelProperty(value = "订单id")
	private Integer id;
	@ApiModelProperty(value = "订单code")
	private String code;
	@ApiModelProperty(value = "来源(销售-0 ， 售后 - 1,零售 - 2)")
	private Integer source;
	@ApiModelProperty(value = "来源字符串")
	private String sourceStr;
	@ApiModelProperty(value = "销售总价")
	private BigDecimal sale_count;
	@ApiModelProperty(value = "申请总价")
	private BigDecimal apply_count;
	@ApiModelProperty(value = "顾问名称")
	private String full_name;


	@ApiModelProperty(value = "折扣比例")
	private String proportion;
	@ApiModelProperty(value = "申请备注")
	private String note;
	


	@ApiModelProperty(value = "客户名称")
	private String cusName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getSourceStr() {
		return sourceStr;
	}

	public void setSourceStr(String sourceStr) {
		this.sourceStr = sourceStr;
	}

	public BigDecimal getSale_count() {
		return sale_count;
	}

	public void setSale_count(BigDecimal sale_count) {
		this.sale_count = sale_count;
	}

	public BigDecimal getApply_count() {
		return apply_count;
	}

	public void setApply_count(BigDecimal apply_count) {
		this.apply_count = apply_count;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

}
