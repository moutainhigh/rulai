package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarRefuelRecord;

public interface CarRefuelRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarRefuelRecord record);

    int insertSelective(CarRefuelRecord record);

    CarRefuelRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarRefuelRecord record);

    int updateByPrimaryKey(CarRefuelRecord record);

	List<CarRefuelRecord> selectListByTestCar(Integer testCarId);
	//库管加油记录 wp
	List<CarRefuelRecord> selectRefuleListByOperator(Map<String, Object> map);
}