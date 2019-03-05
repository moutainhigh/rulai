package com.unicdata.service.car;

import com.unicdata.entity.car.CarGoodInfoWithBLOBs;

/**
 * 车辆各个天数及利息计算方法
 * 
 * @author wxn
 * @date 2018年7月21日
 */
public interface CarTimerService {
	public CarGoodInfoWithBLOBs carTimerCaculate(CarGoodInfoWithBLOBs car);
}
