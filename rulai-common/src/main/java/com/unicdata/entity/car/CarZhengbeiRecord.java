package com.unicdata.entity.car;

import java.util.Date;

public class CarZhengbeiRecord {
    private Integer id;

    private Integer carId;

    private int detectStatus;

    private Date expectStartTime;

    private Date expectEndTime;

    private Integer storeId;

    private Date createTime;

    private Date updateTime;

    private String workPage;

    private Date expectTime;

    private Integer zhengbeiType;
    
    private String vin;
    
    public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Integer getZhengbeiType() {
		return zhengbeiType;
	}

	public void setZhengbeiType(Integer zhengbeiType) {
		this.zhengbeiType = zhengbeiType;
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

    public int getDetectStatus() {
		return detectStatus;
	}

	public void setDetectStatus(int detectStatus) {
		this.detectStatus = detectStatus;
	}

	public Date getExpectStartTime() {
        return expectStartTime;
    }

    public void setExpectStartTime(Date expectStartTime) {
        this.expectStartTime = expectStartTime;
    }

    public Date getExpectEndTime() {
        return expectEndTime;
    }

    public void setExpectEndTime(Date expectEndTime) {
        this.expectEndTime = expectEndTime;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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

    public String getWorkPage() {
        return workPage;
    }

    public void setWorkPage(String workPage) {
        this.workPage = workPage == null ? null : workPage.trim();
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Date expectTime) {
        this.expectTime = expectTime;
    }
}