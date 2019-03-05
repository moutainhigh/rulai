package com.unicdata.entity.order;

import java.util.Date;

public class DeliverCar {
    private Integer id;

	private Integer orderId;

    private Integer cusId;

	private Integer carId;

	private String deliverImg;

	private Date createTime;

	private Integer serviceEmpId;

	private Integer createId;

	private Integer storeId;

	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getDeliverImg() {
		return deliverImg;
	}

	public void setDeliverImg(String deliverImg) {
		this.deliverImg = deliverImg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getServiceEmpId() {
		return serviceEmpId;
	}

	public void setServiceEmpId(Integer serviceEmpId) {
		this.serviceEmpId = serviceEmpId;
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}