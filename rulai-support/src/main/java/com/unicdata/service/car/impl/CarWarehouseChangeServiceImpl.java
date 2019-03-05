package com.unicdata.service.car.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarWarehouseChangeMapper;
import com.unicdata.entity.car.CarWarehouseChange;
import com.unicdata.service.car.CarWarehouseChangeService;

@Service
public class CarWarehouseChangeServiceImpl implements CarWarehouseChangeService {

	@Autowired
	private CarWarehouseChangeMapper carWarehouseChangeMapper;

	@Override
	public int insertSelective(CarWarehouseChange record) {
		return carWarehouseChangeMapper.insertSelective(record);
	}

	@Override
	public CarWarehouseChange selectByPrimaryKey(Integer id) {
		return carWarehouseChangeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CarWarehouseChange record) {
		return carWarehouseChangeMapper.updateByPrimaryKeySelective(record);
	}

}
