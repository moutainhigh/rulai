package com.unicdata.entity.boutique.home;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品经理首页-精品在库天数")
public class BoutiqueStay {
	@ApiModelProperty(value = "超过安全天数的精品个数")
	private Integer count;
	@ApiModelProperty(value = "超过安全天数的精品集合")
	private List<StayLong> list;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<StayLong> getList() {
		return list;
	}

	public void setList(List<StayLong> list) {
		this.list = list;
	}
	
	
	
	
}
