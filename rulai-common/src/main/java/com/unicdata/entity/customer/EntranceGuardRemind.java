package com.unicdata.entity.customer;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class EntranceGuardRemind {
    private Integer id;

    private String carPlateNumber;

    private Date createTime;

    private Integer status;

    private Integer storeId;

    private Integer arriveType;

    private Integer cusId;

    private String carPlatePhoto;

    private Integer doStatus;
    
	public Integer getDoStatus() {
		return doStatus;
	}

	public void setDoStatus(Integer doStatus) {
		this.doStatus = doStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarPlateNumber() {
		return carPlateNumber;
	}

	public void setCarPlateNumber(String carPlateNumber) {
		this.carPlateNumber = carPlateNumber;
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

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getArriveType() {
		return arriveType;
	}

	public void setArriveType(Integer arriveType) {
		this.arriveType = arriveType;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getCarPlatePhoto() {
		return carPlatePhoto;
	}

	public void setCarPlatePhoto(String carPlatePhoto) {
		this.carPlatePhoto = carPlatePhoto;
	}
    

}