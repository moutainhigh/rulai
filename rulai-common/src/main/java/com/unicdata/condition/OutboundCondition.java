package com.unicdata.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品出库分页查询条件")
public class OutboundCondition {
	@ApiModelProperty(value = "出库id")
	private Integer id ; 
	@ApiModelProperty(value = "销售出库 - 0 , 维修出库 - 1 ，精品零售 - 2)")
	private Integer type ; 
	
	@ApiModelProperty(value = "销售订单号")
	private String salveNo;
	@ApiModelProperty(value = "员工姓名")
	private String employeeName;
	@ApiModelProperty(value = "客户姓名")
	private String customerName;
	@ApiModelProperty(value = "精品单号")
	private String boutiqueNo;
	@ApiModelProperty(value = "单据状态（ 0 - 未出料 ； 1 - 部分出料 ； 2- 全部出料）")
	private Integer status;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getSalveNo() {
		return salveNo;
	}
	public void setSalveNo(String salveNo) {
		this.salveNo = salveNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBoutiqueNo() {
		return boutiqueNo;
	}
	public void setBoutiqueNo(String boutiqueNo) {
		this.boutiqueNo = boutiqueNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	
}
