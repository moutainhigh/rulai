package com.unicdata.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品礼包查询条件")
public class BoutiquePackageCondition {
	@ApiModelProperty(value = "礼包名称")
	private String name;
	@ApiModelProperty(value = "页面大小")
	private Integer pageSize;
	@ApiModelProperty(value = "页码")
	private Integer pageNum;

	private Integer storeId;
	
	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
