package com.unicdata.service.car.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.car.CarInterestRuleMapper;
import com.unicdata.entity.car.CarInterestRule;
import com.unicdata.service.car.CarInterestRuleService;

@Service
public class CarInterestRuleServiceImpl implements CarInterestRuleService {

	@Autowired
	private CarInterestRuleMapper carInterestRuleMapper;

	public int insertSelective(CarInterestRule record) {
		return carInterestRuleMapper.insertSelective(record);
	}

	public CarInterestRule selectByPrimaryKey(Integer id) {
		return carInterestRuleMapper.selectByPrimaryKey(id);
	}
	
	public int updateByPrimaryKey(CarInterestRule record) {
		return carInterestRuleMapper.updateByPrimaryKey(record);
	}

	public int updateByPrimaryKeySelective(CarInterestRule record) {
		return carInterestRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<CarInterestRule> selectListByFamily(Integer familyId) {
		return carInterestRuleMapper.selectListByFamily(familyId);
	}
}
