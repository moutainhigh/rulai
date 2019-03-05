package com.unicdata.entity.boutique.outbound;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "出库提示")
public class OutboundPrompt {

	@ApiModelProperty(value = "精品品牌名称")
    private String name;
	
	
	@ApiModelProperty(value = "出库失败原因")
	private String reason;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
