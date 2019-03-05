package com.unicdata.condition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.unicdata.base.util.DateUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品入库查询条件")
public class PushWareHouseCondition implements Serializable{
	
	private static final long serialVersionUID = -7190248375364757526L;
	
	@ApiModelProperty(value = "入库id")
	private Integer id;
	@ApiModelProperty(value = "入库编号")
	private String code;
	@ApiModelProperty(value = "入库名称")
	private String name;
	@ApiModelProperty(value = "供应商Id")
	private Integer supplierId;
	@ApiModelProperty(value = "供应商Ids(以逗号隔开)")
	private String supplierIds;
	@ApiModelProperty(value = "开始时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String beginTime;
	@ApiModelProperty(value = "结束时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String endTime;
	@ApiModelProperty(value = "页面大小")
	private Integer pageSize;
	@ApiModelProperty(value = "页码")
	private Integer pageNum;
	
	private Integer storeId;
	
	private List<Integer> supplierIdList;
	
	public List<Integer> getSupplierIdList() {
		return supplierIdList;
	}
	public void setSupplierIdList(List<Integer> supplierIdList) {
		this.supplierIdList = supplierIdList;
	}
	public String getSupplierIds() {
		return supplierIds;
	}
	public void setSupplierIds(String supplierIds) {
		List<Integer> list = new ArrayList<Integer>();
		if(supplierIds.indexOf(",") >=0){
			String[] split = supplierIds.split(",");
			for (String id : split) {
				list.add(Integer.parseInt(id));
			}
		}else{
			list.add(Integer.parseInt(supplierIds));
		}
		supplierIdList = list;
		this.supplierIds = supplierIds;
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
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public Date getBeginTime() {
		if(this.beginTime == null){
			return null;
		}
		return DateUtil.stringToDate(this.beginTime, DateUtil.sdf2);
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		if(this.endTime == null){
			return null;
		}
		return DateUtil.stringToDate(this.endTime, DateUtil.sdf2);
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
}
