package com.unicdata.service.car;

import com.unicdata.entity.car.CarWarehouseChange;

/**
 * 车辆移库信息
 * 
 * @author wxn
 * @date 2018年6月3日
 */
public interface CarWarehouseChangeService {
	int insertSelective(CarWarehouseChange record);

	CarWarehouseChange selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarWarehouseChange record);

}
