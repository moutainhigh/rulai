package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品订单审批记录")
public class BoutiqueRetailRecord implements Serializable{

	private static final long serialVersionUID = -4450360433719410344L;

	@ApiModelProperty(value = "精品订单审批记录Id")
    private Integer id;
	@ApiModelProperty(value = "订单id")
    private Integer orderId;
	@ApiModelProperty(value = "精品订单id")
    private Integer retailId;
	@ApiModelProperty(value = "审批人id")
    private Integer employeeId;
	@ApiModelProperty(value = "审批状态(0 - 待审批 ； 1 - 审批不通过 ； 2 - 审批通过)")
    private Integer type;
	@ApiModelProperty(value = "备注")
    private String note;
	@ApiModelProperty(value = "时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timeStamp;
	@ApiModelProperty(value = "")
    private Integer createId;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;
	@ApiModelProperty(value = "是否划价( 0 - 未划分 ； 1 - 已划分)")
    private Integer isDivision;
	
    private Integer typeLive;
    
    public Integer getIsDivision() {
		return isDivision;
	}

	public void setIsDivision(Integer isDivision) {
		this.isDivision = isDivision;
	}

	public Integer getTypeLive() {
		return typeLive;
	}

	public void setTypeLive(Integer typeLive) {
		this.typeLive = typeLive;
	}
	
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

    public Integer getRetailId() {
        return retailId;
    }

    public void setRetailId(Integer retailId) {
        this.retailId = retailId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
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
}