package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicdata.base.util.DateUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品入库")
public class BoutiquePushWarehouse implements Serializable{
	@ApiModelProperty(value = "入库id")
    private Integer id;
	@ApiModelProperty(value = "入库编号")
    private String code;
	@ApiModelProperty(value = "入库名称")
    private String name;
	@ApiModelProperty(value = "操作时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date operationTime;
	@ApiModelProperty(value = "供应商Id")
    private Integer suppilerId;
	@ApiModelProperty(value = "供应商")
	private String suppilerIdStr;
	@ApiModelProperty(value = "入库时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date pushTime;
	@ApiModelProperty(value = "入库数量")
    private Integer num;
	@ApiModelProperty(value = "备注")
    private String note;

    private Integer storeId;

    private Integer typeLive;

    private String operationTimeStr;
    
    private String pushTimeStr;
    
    public String getSuppilerIdStr() {
		return suppilerIdStr;
	}

	public void setSuppilerIdStr(String suppilerIdStr) {
		this.suppilerIdStr = suppilerIdStr;
	}

	public String getOperationTimeStr() {
		return operationTimeStr;
	}

	public void setOperationTimeStr(String operationTimeStr) {
		if(StringUtils.isNotBlank(operationTimeStr)){
			this.operationTime = DateUtil.stringToDate(operationTimeStr, DateUtil.sdf3);
		}
		this.operationTimeStr = operationTimeStr;
	}

	public String getPushTimeStr() {
		return pushTimeStr;
	}

	public void setPushTimeStr(String pushTimeStr) {
		if(StringUtils.isNotBlank(pushTimeStr)){
			this.pushTime = DateUtil.stringToDate(pushTimeStr, DateUtil.sdf3);
		}
		this.pushTimeStr = pushTimeStr;
	}

	private List<BoutiquePushWarehouseDetail> list;
    
    public List<BoutiquePushWarehouseDetail> getList() {
		return list;
	}

	public void setList(List<BoutiquePushWarehouseDetail> list) {
		this.list = list;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
        if(operationTime != null){
        	this.operationTimeStr = DateUtil.dateFormat(operationTime, DateUtil.sdf3);
        }
        
    }

    public Integer getSuppilerId() {
        return suppilerId;
    }

    public void setSuppilerId(Integer suppilerId) {
        this.suppilerId = suppilerId;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
        if(pushTime != null){
        	this.pushTimeStr = DateUtil.dateFormat(pushTime, DateUtil.sdf3);
        }
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public Integer getTypeLive() {
        return typeLive;
    }

    public void setTypeLive(Integer typeLive) {
        this.typeLive = typeLive;
    }
}