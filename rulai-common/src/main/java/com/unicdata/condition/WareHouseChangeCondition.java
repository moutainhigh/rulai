package com.unicdata.condition;

import java.util.Date;

import com.unicdata.base.util.DateUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品仓库库位变更分页查询条件")
public class WareHouseChangeCondition {

	@ApiModelProperty(value = "id")
	private Integer id;
	@ApiModelProperty(value = "申请日期")
	private Date applyDate;
	@ApiModelProperty(value = "申请名称")
	private String applyName;
	
	@ApiModelProperty(value = "页面大小")
	private Integer pageSize;
	@ApiModelProperty(value = "页码")
	private Integer pageNum;
	
	private Integer storeId;
	
	private Date beginTime;
	
	private Date endTime;
	
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
		String dateFormat = DateUtil.dateFormat(applyDate, DateUtil.sdf2);
		this.beginTime = DateUtil.stringToDate(dateFormat+ " 00:00:00", DateUtil.sdf1);
		this.beginTime = DateUtil.stringToDate(dateFormat+ " 23:59:59", DateUtil.sdf1);
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
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
