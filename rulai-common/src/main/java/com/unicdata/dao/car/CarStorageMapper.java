package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarStorage;

public interface CarStorageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarStorage record);

    int insertSelective(CarStorage record);

    CarStorage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarStorage record);

    int updateByPrimaryKey(CarStorage record);

	Page<CarStorage> selectListByWareHouse(Integer warehouseId);

	List<CarStorage> selectListExceptOut(Integer warehouseId);
	//仓库下的库位 过滤被占用的库位 wp
	List<Map<String, Object>> selectListByWareHouseS(Integer warehouseId);
}