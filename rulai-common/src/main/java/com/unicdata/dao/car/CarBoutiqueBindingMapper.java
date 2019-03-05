package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarBoutiqueBinding;

public interface CarBoutiqueBindingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarBoutiqueBinding record);

    int insertSelective(CarBoutiqueBinding record);

    CarBoutiqueBinding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarBoutiqueBinding record);

    int updateByPrimaryKey(CarBoutiqueBinding record);

	List<Map<String, Object>> selectByCarId(Integer carId);
}