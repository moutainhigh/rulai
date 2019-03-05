package com.unicdata.service.car.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.car.CarMaintainRecordMapper;
import com.unicdata.entity.car.CarMaintainRecord;
import com.unicdata.service.car.CarMaintainRecordService;

@Service
public class CarMaintainRecordServiceImpl implements CarMaintainRecordService {

	@Autowired
	private CarMaintainRecordMapper carMaintainRecordMapper;

	@Override
	public int insertSelective(CarMaintainRecord record) {
		return carMaintainRecordMapper.insertSelective(record);
	}

	@Override
	public CarMaintainRecord selectByPrimaryKey(Integer id) {
		return carMaintainRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CarMaintainRecord record) {
		return carMaintainRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<CarMaintainRecord> selectListByTestCar(Integer testCarId) {
		return carMaintainRecordMapper.selectListByTestCar(testCarId);
	}

}
