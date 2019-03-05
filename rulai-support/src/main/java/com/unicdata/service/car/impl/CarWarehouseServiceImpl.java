package com.unicdata.service.car.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarWarehouseMapper;
import com.unicdata.entity.car.CarWarehouse;
import com.unicdata.service.car.CarWarehouseService;

@Service
public class CarWarehouseServiceImpl implements CarWarehouseService {

	@Autowired
	private CarWarehouseMapper carWarehouseMapper;

	public int insertSelective(CarWarehouse record) {
		return carWarehouseMapper.insertSelective(record);
	}

	public CarWarehouse selectByPrimaryKey(Integer id) {
		return carWarehouseMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CarWarehouse record) {
		return carWarehouseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public PageInfo<CarWarehouse> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum) {
		if (null != pageSize && null != pageSize) {
			PageHelper.startPage(pageNum, pageSize);
		}
		return carWarehouseMapper.selectListByStore(distributorStoreId).toPageInfo();
	}
}
