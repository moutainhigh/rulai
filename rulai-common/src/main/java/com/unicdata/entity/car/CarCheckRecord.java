package com.unicdata.entity.car;

import java.util.Date;

public class CarCheckRecord {
    private Integer id;

    private Integer carId;
    private String checkPage;

    private String exceptionPhoto;

    private String exceptionExplain;

    private Date createTime;

    private Integer checkStatus;

    private Date updateTime;

    private Integer storeId;
    
    private Integer checkType;
    
    public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
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

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCheckPage() {
        return checkPage;
    }

    public void setCheckPage(String checkPage) {
        this.checkPage = checkPage == null ? null : checkPage.trim();
    }

    public String getExceptionPhoto() {
        return exceptionPhoto;
    }

    public void setExceptionPhoto(String exceptionPhoto) {
        this.exceptionPhoto = exceptionPhoto == null ? null : exceptionPhoto.trim();
    }

    public String getExceptionExplain() {
        return exceptionExplain;
    }

    
    public void setExceptionExplain(String exceptionExplain) {
        this.exceptionExplain = exceptionExplain == null ? null : exceptionExplain.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

   

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}