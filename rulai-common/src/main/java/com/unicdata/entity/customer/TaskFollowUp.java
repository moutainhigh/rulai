package com.unicdata.entity.customer;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TaskFollowUp {

	private Integer id;

    private Integer orderId;

    private Integer orderStatus;

    private Integer customerId;

    private Integer chennel;

    private Integer content;

    private String remark;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date thisDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date nextDate;

    private Integer nextChennel;

    private Integer nextContent;

	private Integer nextServiceItem;

    private String nextRemark;

    private Integer createId;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    
    private Integer dataStatus;

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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getChennel() {
        return chennel;
    }

    public void setChennel(Integer chennel) {
        this.chennel = chennel;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getThisDate() {
        return thisDate;
    }

    public void setThisDate(Date thisDate) {
        this.thisDate = thisDate;
    }

    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    public Integer getNextChennel() {
        return nextChennel;
    }

    public void setNextChennel(Integer nextChennel) {
        this.nextChennel = nextChennel;
    }

    public Integer getNextContent() {
        return nextContent;
    }

    public void setNextContent(Integer nextContent) {
        this.nextContent = nextContent;
    }

    public String getNextRemark() {
        return nextRemark;
    }

    public void setNextRemark(String nextRemark) {
        this.nextRemark = nextRemark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Integer getNextServiceItem() {
		return nextServiceItem;
	}

	public void setNextServiceItem(Integer nextServiceItem) {
		this.nextServiceItem = nextServiceItem;
	}

	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}