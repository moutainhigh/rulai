package com.unicdata.service.car.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.car.CarBoutiqueBindingMapper;
import com.unicdata.entity.car.CarBoutiqueBinding;
import com.unicdata.service.car.CarBoutiqueBindingService;

@Service
public class CarBoutiqueBindingServiceImpl implements CarBoutiqueBindingService {

	@Autowired
	private CarBoutiqueBindingMapper carBoutiqueBindingMapper;

	public int insertSelective(CarBoutiqueBinding record) {
		return carBoutiqueBindingMapper.insertSelective(record);
	}

	public CarBoutiqueBinding selectByPrimaryKey(Integer id) {
		return carBoutiqueBindingMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CarBoutiqueBinding record) {
		return carBoutiqueBindingMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> selectByCarId(Integer carId) {
		return carBoutiqueBindingMapper.selectByCarId(carId);
	}

}
