package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarInsuranceRecord;

public interface CarInsuranceRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarInsuranceRecord record);

    int insertSelective(CarInsuranceRecord record);

    CarInsuranceRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarInsuranceRecord record);

    int updateByPrimaryKey(CarInsuranceRecord record);

	List<Map<String, Object>> selectListByTestCar(Integer testCarId);
	
	//试驾车保险登记记录 wp
	List<Map<String, Object>> selectInsurRecordList(Integer testCarId);
	//保险提醒wp
	List<Map<String, Object>> selectInsurerRemind(Integer storeId);
	//变更保险登记状态 wp
	int updateByCarIdSelective(CarInsuranceRecord record);
	//车辆是否存在登记记录 wp
	List<Map<String, Object>> selectExsitRecord(CarInsuranceRecord record);
	//变更保额(添加保额) wp
	int updateInsurerMoney(Map<String, Object> map);
	
	
}