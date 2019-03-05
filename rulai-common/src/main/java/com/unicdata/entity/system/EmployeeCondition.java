package com.unicdata.entity.system;
/**
 * 查询员工条件
 * @author wp
 *
 */
public class EmployeeCondition {
	
	private Integer storeId;//门店ID
	private Integer type;//员工状态
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
