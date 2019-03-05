package com.unicdata.service.carInfo;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.car.CarVehicleConfExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 获取车辆限价
 * @author shenyong
 * @date 2018年7月18日
 */
public interface CarVehicleService {

	/**
	 *  获取车辆限价
	 * @param carId 车辆id
	 * @return [销售顾问，销售经理，总经理]
     */
	BigDecimal[] selectCarLimitPrice(Integer carId);

}
