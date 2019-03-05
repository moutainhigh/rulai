package com.unicdata.conditon;

import java.util.List;

import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.car.CarInterestRule;
/**
 * 车系保存
 * @author wxn
 * @date 2018年6月11日
 */
public class FamilyCondition {
	
	private CarFamily carFamily;
	private List<CarInterestRule> ruleList;
	private String ruleIds;

	public CarFamily getCarFamily() {
		return carFamily;
	}

	public void setCarFamily(CarFamily carFamily) {
		this.carFamily = carFamily;
	}

	public List<CarInterestRule> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<CarInterestRule> ruleList) {
		this.ruleList = ruleList;
	}

	public String getRuleIds() {
		return ruleIds;
	}

	public void setRuleIds(String ruleIds) {
		this.ruleIds = ruleIds;
	}
}
