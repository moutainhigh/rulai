package com.unicdata.entity.car;

import java.util.Date;

public class CarOutstorgeRecord {
    private Integer id;

    private Integer carId;

    private Integer operatorId;

    private Date outstoreTime;

    private Integer outstoreType;

    private Integer status;
    
    private Integer storeId;

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

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Date getOutstoreTime() {
        return outstoreTime;
    }

    public void setOutstoreTime(Date outstoreTime) {
        this.outstoreTime = outstoreTime;
    }

    public Integer getOutstoreType() {
        return outstoreType;
    }

    public void setOutstoreType(Integer outstoreType) {
        this.outstoreType = outstoreType;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}