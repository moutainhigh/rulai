package com.unicdata.entity.system;

import java.io.Serializable;
import java.util.Date;

public class EmployeeStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4158827504929157063L;
	private Integer id;
	private Integer employeeId;
	private Integer type;
	private Date contactTime;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * @return the contactTime
	 */
	public Date getContactTime() {
		return contactTime;
	}
	/**
	 * @param contactTime the contactTime to set
	 */
	public void setContactTime(Date contactTime) {
		this.contactTime = contactTime;
	}
	
}
