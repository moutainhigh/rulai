package com.unicdata.condition;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.unicdata.base.util.DateUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品订单分页查询条件")
public class BoutiqueRetailCondition {
	@ApiModelProperty(value = "精品订单id")
	private Integer id;
	@ApiModelProperty(value = "精品订单编号")
	private String code;
	@ApiModelProperty(value = "客户姓名")
	private String customerName;
	@ApiModelProperty(value = "销售日期")
	private String saleDate;
	@ApiModelProperty(value = "状态 (0,'待审批'),(1,'审批不通过'),(2,'待付定金'),(3,'待全款'),(4,'已收讫')，( 5 已退单'),(6,'无')")
	private Integer type;
	@ApiModelProperty(value = "页面大小")
	private Integer pageSize;
	@ApiModelProperty(value = "页码")
	private Integer pageNum;

	private Integer storeId;
	
	private Date beginDate;
	
	private Date endDate;
	
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
		if(StringUtils.isNotBlank(saleDate)){
			this.beginDate = DateUtil.stringToDate(saleDate + " 00:00:00", DateUtil.sdf1);
			this.endDate = DateUtil.stringToDate(saleDate + " 23:59:59", DateUtil.sdf1);
		}
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
