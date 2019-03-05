package com.unicdata.service.car;

import java.util.List;

import com.unicdata.entity.car.CarInterestRule;

/**
 * 利息规则
 * 
 * @author wxn
 * @date 2018年6月1日
 */
public interface CarInterestRuleService {
	int insertSelective(CarInterestRule record);

    CarInterestRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarInterestRule record);
	
	List<CarInterestRule> selectListByFamily(Integer familyId);

	int updateByPrimaryKey(CarInterestRule carInterestRule);
}
