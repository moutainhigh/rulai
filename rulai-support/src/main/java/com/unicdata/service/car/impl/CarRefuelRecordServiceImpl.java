package com.unicdata.service.car.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.car.CarRefuelRecordMapper;
import com.unicdata.entity.car.CarRefuelRecord;
import com.unicdata.service.car.CarRefuelRecordService;

@Service
public class CarRefuelRecordServiceImpl implements CarRefuelRecordService {

	@Autowired
	private CarRefuelRecordMapper carRefuelRecordMapper;

	@Override
	public int insertSelective(CarRefuelRecord record) {
		return carRefuelRecordMapper.insertSelective(record);
	}

	@Override
	public CarRefuelRecord selectByPrimaryKey(Integer id) {
		return carRefuelRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CarRefuelRecord record) {
		return carRefuelRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<CarRefuelRecord> selectListByTestCar(Integer testCarId) {
		return carRefuelRecordMapper.selectListByTestCar(testCarId);
	}

}
