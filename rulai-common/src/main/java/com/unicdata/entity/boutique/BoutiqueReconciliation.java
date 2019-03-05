package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品对账")
public class BoutiqueReconciliation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8720217928896067371L;

	@ApiModelProperty(value = "精品对账Id")
    private Integer id;
	@ApiModelProperty(value = "精品供应商id")
    private Integer supplierId;
	@ApiModelProperty(value = "精品id")
    private Integer boutiqueId;
	@ApiModelProperty(value = "数量")
    private Integer num;
	@ApiModelProperty(value = "施工时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date constructionTime;
	@ApiModelProperty(value = "金额")
    private BigDecimal value;
	@ApiModelProperty(value = "状态( 0 - 未核对 ； 1 - 已核对)")
    private Integer status;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;

	@ApiModelProperty(value = "时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timestamp;

    private Integer typeLive;

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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getBoutiqueId() {
        return boutiqueId;
    }

    public void setBoutiqueId(Integer boutiqueId) {
        this.boutiqueId = boutiqueId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getConstructionTime() {
        return constructionTime;
    }

    public void setConstructionTime(Date constructionTime) {
        this.constructionTime = constructionTime;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}