package com.unicdata.condition;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 车辆盘点查询条件
 * 
 * @author wxn
 * @date 2018年6月21日
 */
public class CarCheckConditon {

	private Integer storeId;
	private String number;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date beginTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;
	private Integer warehouseId;
	private Integer checkStatus;
	private Integer pageSize;
	private Integer pageNum;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getNumber() {
		return number;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

}
