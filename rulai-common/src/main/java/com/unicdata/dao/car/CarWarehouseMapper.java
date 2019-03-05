package com.unicdata.dao.car;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarWarehouse;

public interface CarWarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarWarehouse record);

    int insertSelective(CarWarehouse record);

    CarWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarWarehouse record);

    int updateByPrimaryKey(CarWarehouse record);

	Page<CarWarehouse> selectListByStore(Integer distributorStoreId);
}