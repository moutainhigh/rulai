package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品礼包")
public class BoutiquePackage implements Serializable{

	private static final long serialVersionUID = -2703128121809114765L;

	@ApiModelProperty(value = "精品礼包Id")
    private Integer id;
	@ApiModelProperty(value = "礼包套餐名称")
    private String name;
	@ApiModelProperty(value = "销售价格")
    private BigDecimal salveValue;
	@ApiModelProperty(value = "适用车系ids")
    private String carIds;
	@ApiModelProperty(value = "适用车系名称")
	private String carIdStr;
	@ApiModelProperty(value = "礼包套餐图片位置")
    private String picture;
	@ApiModelProperty(value = "礼包包含精品件数")
    private Integer includeNum;
	@ApiModelProperty(value = "是否上架(0-下架 ； 1 -上架)")
    private Integer status;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;

	@ApiModelProperty(value = "时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timeStamp;

    private Integer typeLive;

    private Integer no;
    
    public String getCarIdStr() {
		return carIdStr;
	}

	public void setCarIdStr(String carIdStr) {
		this.carIdStr = carIdStr;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	private List<BoutiquePackageInclude> list;
    
    public List<BoutiquePackageInclude> getList() {
		return list;
	}

	public void setList(List<BoutiquePackageInclude> list) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalveValue() {
		return salveValue;
	}

	public void setSalveValue(BigDecimal salveValue) {
		this.salveValue = salveValue;
	}

	public String getCarIds() {
		return carIds;
	}

	public void setCarIds(String carIds) {
		this.carIds = carIds;
	}

	public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getIncludeNum() {
        return includeNum;
    }

    public void setIncludeNum(Integer includeNum) {
        this.includeNum = includeNum;
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}