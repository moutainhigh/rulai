package com.unicdata.service.car;

import java.util.List;

import com.unicdata.entity.car.CarRefuelRecord;

/**
 * 试驾车加油记录
 * 
 * @author wxn
 * @date 2018年6月3日
 */
public interface CarRefuelRecordService {
	int insertSelective(CarRefuelRecord record);

	CarRefuelRecord selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarRefuelRecord record);
	
	List<CarRefuelRecord> selectListByTestCar(Integer testCarId);
}
