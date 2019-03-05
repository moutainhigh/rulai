package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarColor;

public interface CarColorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarColor record);

    int insertSelective(CarColor record);

    CarColor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarColor record);

    int updateByPrimaryKey(CarColor record);

	CarColor selectByFamilyAndName(Map<String, Object> param);

	List<CarColor> selectColorByFamily(Integer familyId);
	//查颜色 wp
	List<Map<String, Object>> selectColorOutIn(Map<String, Object> map);
}