package com.unicdata.condition;

import io.swagger.annotations.ApiModelProperty;

/**
 * 精品零售查询条件
 * 
 * @author wxn
 * @date 2018年6月4日
 */
public class RetailSettleCondition {

	@ApiModelProperty(value = "门店id")
	private Integer storeId;
	@ApiModelProperty(value = "精品订单code")
	private String code;
	@ApiModelProperty(value = "客户/企业名称")
	private String name;
	@ApiModelProperty(value = "手机号码")
	private String phone;
	@ApiModelProperty(value = "员工名称")
	private String employeeName;
	@ApiModelProperty(value = "精品订单状态((0,'无')(1,'待审批'),(2,'审批不通过'),(3,'待付款'),(4,'已收讫')， 5 已退单,')")
	private Byte type;

	private Integer pageSize;

	private Integer pageNum;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

}
