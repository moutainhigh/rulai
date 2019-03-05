package com.unicdata.entity.boutique.home;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品经理首页-精品库存")
public class BoutiqueStock {

	@ApiModelProperty(value = "不安全库存个数")
	private Integer notSafetyCount;
	@ApiModelProperty(value = "不安全库存集合")
	private List<NotSafetyStock> notSafetyList;

	public Integer getNotSafetyCount() {
		return notSafetyCount;
	}

	public void setNotSafetyCount(Integer notSafetyCount) {
		this.notSafetyCount = notSafetyCount;
	}

	public List<NotSafetyStock> getNotSafetyList() {
		return notSafetyList;
	}

	public void setNotSafetyList(List<NotSafetyStock> notSafetyList) {
		this.notSafetyList = notSafetyList;
	}
	
}

