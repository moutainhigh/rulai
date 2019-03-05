package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicdata.base.util.DateUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "仓库和库位变更记录")
public class BoutiqueWarehouseChange implements Serializable{

	private static final long serialVersionUID = 6042239951735634366L;

	@ApiModelProperty(value = "Id")
    private Integer id;
	@ApiModelProperty(value = "员工id")
    private Integer emplyoeeId;
	@ApiModelProperty(value = "申请名称")
    private String applyName;
	@ApiModelProperty(value = "申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applyDate;
	@ApiModelProperty(value = "申请时间")
	private String applyDateStr;
	@ApiModelProperty(value = "备注")
    private String note;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;

	@ApiModelProperty(value = "时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timeStamp;

    private Integer typeLive;

    @ApiModelProperty(value = "精品集合")
	private List<BoutiqueInformation> list;
	
    public String getApplyDateStr() {
		return applyDateStr;
	}

	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
		this.applyDate = DateUtil.stringToDate(applyDateStr, "yyyy-MM-dd HH:mm");
	}

	public List<BoutiqueInformation> getList() {
		return list;
	}

	public void setList(List<BoutiqueInformation> list) {
		this.list = list;
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

    public Integer getEmplyoeeId() {
        return emplyoeeId;
    }

    public void setEmplyoeeId(Integer emplyoeeId) {
        this.emplyoeeId = emplyoeeId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}