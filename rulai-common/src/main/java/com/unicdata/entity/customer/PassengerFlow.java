package com.unicdata.entity.customer;

import java.util.Date;

public class PassengerFlow {
    
	private Integer id;

	private Integer storeId;

	private Integer employeeId;

	private Integer replaceEmployeeId;

	private Integer cusId;

	private Integer type;

	private Integer ownedCar;

	private String licensePlate;

	private Date leaveTime;

	private Date createTime;

	private Integer isArchives;

	private Integer status;

	private Integer dataStatus;
	
	private Integer createEmployeeId;

	public Integer getCreateEmployeeId() {
		return createEmployeeId;
	}

	public void setCreateEmployeeId(Integer createEmployeeId) {
		this.createEmployeeId = createEmployeeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getReplaceEmployeeId() {
		return replaceEmployeeId;
	}

	public void setReplaceEmployeeId(Integer replaceEmployeeId) {
		this.replaceEmployeeId = replaceEmployeeId;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOwnedCar() {
		return ownedCar;
	}

	public void setOwnedCar(Integer ownedCar) {
		this.ownedCar = ownedCar;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsArchives() {
		return isArchives;
	}

	public void setIsArchives(Integer isArchives) {
		this.isArchives = isArchives;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
}