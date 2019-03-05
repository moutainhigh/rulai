package com.unicdata.base.enu;

/**
 * 精品施工节点
 * @author Admin
 * 
 */
public enum ConstructionEnum {

	BEFORE(1,"交车前"),
	AFTER(2,"交车后"),
	NO(3,"不施工");

	/**
     * 
     */
    private Integer code;
    /**
     * 
     */
    private String node;
    
    ConstructionEnum(Integer code, String node) {
		this.code = code;
		this.node = node;
	}
    
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
    
    
	
}
