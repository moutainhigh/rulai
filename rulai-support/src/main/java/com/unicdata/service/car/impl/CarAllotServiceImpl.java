package com.unicdata.service.car.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.car.CarAllotMapper;
import com.unicdata.entity.car.CarAllot;
import com.unicdata.service.car.CarAllotService;

@Service
public class CarAllotServiceImpl implements CarAllotService{

	@Autowired
	private CarAllotMapper allotMapper;

	@Override
	public int insertSelective(CarAllot record) {
		return allotMapper.insertSelective(record);
	}

	@Override
	public CarAllot selectByPrimaryKey(Integer id) {
		return allotMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CarAllot record) {
		return allotMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> selectListByApplication(Integer applicationId) {
		return allotMapper.selectListByApplication(applicationId);
	}
	
	
}
