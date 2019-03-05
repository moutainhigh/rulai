package com.unicdata.conditon;

import java.util.List;

import com.unicdata.entity.car.CarAllot;
import com.unicdata.entity.car.CarAllotApplication;

/**
 * 车辆调拨传参
 * 
 * @author wxn
 * @date 2018年6月17日
 */
public class CarAllotCondition {
	
	private CarAllotApplication carAllotApplication;
	private List<CarAllot> carList;

	public CarAllotApplication getCarAllotApplication() {
		return carAllotApplication;
	}

	public List<CarAllot> getCarList() {
		return carList;
	}

	public void setCarAllotApplication(CarAllotApplication carAllotApplication) {
		this.carAllotApplication = carAllotApplication;
	}

	public void setCarList(List<CarAllot> carList) {
		this.carList = carList;
	}

}
