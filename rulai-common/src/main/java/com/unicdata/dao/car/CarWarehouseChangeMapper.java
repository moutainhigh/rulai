package com.unicdata.dao.car;

import com.unicdata.entity.car.CarWarehouseChange;

public interface CarWarehouseChangeMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(CarWarehouseChange record);

	int insertSelective(CarWarehouseChange record);

	CarWarehouseChange selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarWarehouseChange record);

	int updateByPrimaryKey(CarWarehouseChange record);

}