package com.unicdata.service.car.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.car.CarOutMapper;
import com.unicdata.entity.car.CarOut;
import com.unicdata.service.car.CarOutService;

@Service
public class CarOutServiceImpl implements CarOutService{

	@Autowired
	private CarOutMapper carOutMapper;

	@Override
	public int insertSelective(CarOut record) {
		return carOutMapper.insertSelective(record);
	}

	@Override
	public CarOut selectByPrimaryKey(Integer id) {
		return carOutMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CarOut record) {
		return carOutMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> selectListByApplicationId(Integer carOutId) {
		return carOutMapper.selectListByApplicationId(carOutId);
	}
	
	
}
