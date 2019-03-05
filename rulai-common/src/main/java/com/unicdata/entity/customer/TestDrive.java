package com.unicdata.entity.customer;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TestDrive {

	private Integer id;

	private Integer cusId;

	private Integer employeeId;

	private Integer salesmanId;

	private Integer driveTime;

	private String purpose;

	private Integer driveMileage;

	private Integer endMileage;

	private Date endTime;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;

	private Integer status;

	private String driversLicense;

	private String agreement;

	private Integer vehicleId;

	private String vehicleName;

	private Integer perfectState;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getDriveTime() {
		return driveTime;
	}

	public void setDriveTime(Integer driveTime) {
		this.driveTime = driveTime;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Integer getDriveMileage() {
		return driveMileage;
	}

	public void setDriveMileage(Integer driveMileage) {
		this.driveMileage = driveMileage;
	}

	public Integer getEndMileage() {
		return endMileage;
	}

	public void setEndMileage(Integer endMileage) {
		this.endMileage = endMileage;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDriversLicense() {
		return driversLicense;
	}

	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Integer getPerfectState() {
		return perfectState;
	}

	public void setPerfectState(Integer perfectState) {
		this.perfectState = perfectState;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	private Integer testCarId;

	public Integer getTestCarId() {
		return testCarId;
	}

	public void setTestCarId(Integer testCarId) {
		this.testCarId = testCarId;
	}

	public Integer getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}
}