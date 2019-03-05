package com.unicdata.service.car.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.car.CarInsuranceRecordMapper;
import com.unicdata.entity.car.CarInsuranceRecord;
import com.unicdata.service.car.CarInsuranceRecordService;

@Service
public class CarInsuranceRecordServiceImpl implements CarInsuranceRecordService{

	@Autowired
	private CarInsuranceRecordMapper carInsuranceRecordMapper;

	@Override
	public int insertSelective(CarInsuranceRecord record) {
		return carInsuranceRecordMapper.insertSelective(record);
	}

	@Override
	public CarInsuranceRecord selectByPrimaryKey(Integer id) {
		return carInsuranceRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CarInsuranceRecord record) {
		return carInsuranceRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> selectListByTestCar(Integer testCarId) {
		return carInsuranceRecordMapper.selectListByTestCar(testCarId);
	}
	
}
