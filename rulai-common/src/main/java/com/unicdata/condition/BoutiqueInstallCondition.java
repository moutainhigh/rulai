package com.unicdata.condition;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.unicdata.base.util.DateUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品加装排程分页查询条件")
public class BoutiqueInstallCondition {

	private Integer id;
	@ApiModelProperty(value = "项目负责人名称")
	private String name;
	@ApiModelProperty(value = "项目负责人名称")
	private String code;
	@ApiModelProperty(value = "部门ID")
	private Integer departmentId;
	@ApiModelProperty(value = "工作状态")
	private Integer status;
	@ApiModelProperty(value = "实际完成时间")
	private String actualDelivery;
	@ApiModelProperty(value = "安排施工时间")
	private String expectedComplete;

	@ApiModelProperty(value = "页面大小")
	private Integer pageSize;
	@ApiModelProperty(value = "页码")
	private Integer pageNum;
	
	private Integer storeId;
	
	
	private Date actualBeginTime;
	
	private Date actualEndTime;
	
	private Date expectedBeginTime;
	
	private Date expectedEndTime;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getActualBeginTime() {
		return actualBeginTime;
	}

	public void setActualBeginTime(Date actualBeginTime) {
		this.actualBeginTime = actualBeginTime;
	}

	public Date getActualEndTime() {
		return actualEndTime;
	}

	public void setActualEndTime(Date actualEndTime) {
		this.actualEndTime = actualEndTime;
	}

	public Date getExpectedBeginTime() {
		return expectedBeginTime;
	}

	public void setExpectedBeginTime(Date expectedBeginTime) {
		this.expectedBeginTime = expectedBeginTime;
	}

	public Date getExpectedEndTime() {
		return expectedEndTime;
	}

	public void setExpectedEndTime(Date expectedEndTime) {
		this.expectedEndTime = expectedEndTime;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
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

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getActualDelivery() {
		return actualDelivery;
	}

	public void setActualDelivery(String actualDelivery) {
		this.actualDelivery = actualDelivery;
		
		if(StringUtils.isNotBlank(actualDelivery)){
			this.actualBeginTime = DateUtil.stringToDate(actualDelivery + " 00:00:00", DateUtil.sdf1);
			this.actualEndTime = DateUtil.stringToDate(actualDelivery + " 23:59:59", DateUtil.sdf1);
		}
	}

	public String getExpectedComplete() {
		return expectedComplete;
	}

	public void setExpectedComplete(String expectedComplete) {
		this.expectedComplete = expectedComplete;
		if(StringUtils.isNotBlank(expectedComplete)){
			this.expectedBeginTime = DateUtil.stringToDate(expectedComplete + " 00:00:00", DateUtil.sdf1);
			this.expectedEndTime = DateUtil.stringToDate(expectedComplete + " 23:59:59", DateUtil.sdf1);
		}
	}
	
}
