package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarMaintainRecord;

public interface CarMaintainRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarMaintainRecord record);

    int insertSelective(CarMaintainRecord record);

    CarMaintainRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarMaintainRecord record);

    int updateByPrimaryKey(CarMaintainRecord record);

	List<CarMaintainRecord> selectListByTestCar(Integer testCarId);
	//库管我的维修记录 wp
	List<CarMaintainRecord> selectMaintainListByOperator(Map<String, Object> map);
	
}