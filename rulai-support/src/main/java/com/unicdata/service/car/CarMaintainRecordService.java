package com.unicdata.service.car;

import java.util.List;

import com.unicdata.entity.car.CarMaintainRecord;

/**
 * 试驾车维修记录
 * 
 * @author wxn
 * @date 2018年6月3日
 */
public interface CarMaintainRecordService {
	int insertSelective(CarMaintainRecord record);

	CarMaintainRecord selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarMaintainRecord record);
	
	List<CarMaintainRecord> selectListByTestCar(Integer testCarId);
}
