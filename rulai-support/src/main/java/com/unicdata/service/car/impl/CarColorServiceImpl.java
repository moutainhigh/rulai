package com.unicdata.service.car.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.car.CarColorMapper;
import com.unicdata.entity.car.CarColor;
import com.unicdata.service.car.CarColorService;

@Service
public class CarColorServiceImpl implements CarColorService {

	@Autowired
	private CarColorMapper carColorMapper;

	@Override
	public CarColor selectByFamilyAndName(Integer familyId, String name, Integer locationStatus) {
		Map<String, Object> param = new HashMap<>();
		param.put("familyId", familyId);
		param.put("name", name);
		param.put("locationStatus", locationStatus);
		return carColorMapper.selectByFamilyAndName(param);
	}

	@Override
	public int insertSelective(CarColor record) {
		return carColorMapper.insertSelective(record);
	}

	@Override
	public CarColor selectByPrimaryKey(Integer id) {
		return carColorMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CarColor record) {
		return carColorMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<CarColor> selectColorByFamily(Integer familyId) {
		return carColorMapper.selectColorByFamily(familyId);
	}

}
