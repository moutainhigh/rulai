package com.unicdata.conditon;

import java.util.List;

import com.unicdata.entity.car.CarWarehouseChange;
import com.unicdata.entity.car.CarWarehouseChangeRecord;

/**
 * 车辆移库参数
 * 
 * @author wxn
 * @date 2018年6月4日
 */
public class CarWarehouseCondition {

	private CarWarehouseChangeRecord carWarehouseChangeRecord;

	private List<CarWarehouseChange> changeList;

	public CarWarehouseChangeRecord getCarWarehouseChangeRecord() {
		return carWarehouseChangeRecord;
	}

	public void setCarWarehouseChangeRecord(CarWarehouseChangeRecord carWarehouseChangeRecord) {
		this.carWarehouseChangeRecord = carWarehouseChangeRecord;
	}

	public List<CarWarehouseChange> getChangeList() {
		return changeList;
	}

	public void setChangeList(List<CarWarehouseChange> changeList) {
		this.changeList = changeList;
	}

}
