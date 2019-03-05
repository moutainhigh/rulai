package com.unicdata.dao.car;

import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarBrand;

public interface CarBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarBrand record);

    int insertSelective(CarBrand record);

    CarBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarBrand record);

    int updateByPrimaryKey(CarBrand record);

	Page<CarBrand> selectListByStore(Integer distributorStoreId);

	CarBrand selectByName(Map<String, Object> params);
}