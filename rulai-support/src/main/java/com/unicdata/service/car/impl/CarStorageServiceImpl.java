package com.unicdata.service.car.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarStorageMapper;
import com.unicdata.entity.car.CarStorage;
import com.unicdata.service.car.CarStorageService;

@Service
public class CarStorageServiceImpl implements CarStorageService {

	@Autowired
	private CarStorageMapper carStorageMapper;

	public int insertSelective(CarStorage record) {
		return carStorageMapper.insertSelective(record);
	}

	public CarStorage selectByPrimaryKey(Integer id) {
		return carStorageMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CarStorage record) {
		return carStorageMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public PageInfo<CarStorage> selectListByWareHouse(Integer warehouseId, Integer pageSize, Integer pageNum) {
		if (null != pageSize && null != pageSize) {
			PageHelper.startPage(pageNum, pageSize);
		}
		return carStorageMapper.selectListByWareHouse(warehouseId).toPageInfo();
	}

	@Override
	public List<CarStorage> selectListExceptOut(Integer warehouseId) {
		return carStorageMapper.selectListExceptOut(warehouseId);
	}
}
