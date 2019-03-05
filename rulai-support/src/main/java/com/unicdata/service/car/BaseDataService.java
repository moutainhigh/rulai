package com.unicdata.service.car;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.conditon.FamilyCondition;
import com.unicdata.entity.car.CarBrand;
import com.unicdata.entity.car.CarStorage;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.car.CarWarehouse;
import com.unicdata.entity.system.Employee;

/**
 * 车辆基础数据service
 * 
 * @author wxn
 * @date 2018年6月20日
 */
public interface BaseDataService {

	ApiReturnInfo<String> updateBrand(Employee employee, CarBrand carBrand);

	ApiReturnInfo<String> updateFamily(Employee employee, FamilyCondition familyCondition);

	ApiReturnInfo<String> updateVehicle(Employee employee, CarVehicleConf carVehicleConf);

	ApiReturnInfo<String> updateWarehouse(Employee employee, CarWarehouse carWarehouse);

	ApiReturnInfo<String> updateStorage(Employee employee, CarStorage carStorage);
}
