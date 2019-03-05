package com.unicdata.conditon;

import java.util.List;

import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.car.CarOptionalPackage;
import com.unicdata.entity.car.CarPurchaseOrder;

/**
 * 新增车辆采购单传参
 * 
 * @author wxn
 * @date 2018年6月12日
 */
public class CarPurchaseCondition {
	private CarPurchaseOrder carPurchaseOrder;

	private List<CarGoodInfoWithBLOBs> carList;

	private List<CarOptionalPackage> optionalList;

	public CarPurchaseOrder getCarPurchaseOrder() {
		return carPurchaseOrder;
	}

	public void setCarPurchaseOrder(CarPurchaseOrder carPurchaseOrder) {
		this.carPurchaseOrder = carPurchaseOrder;
	}

	public List<CarGoodInfoWithBLOBs> getCarList() {
		return carList;
	}

	public void setCarList(List<CarGoodInfoWithBLOBs> carList) {
		this.carList = carList;
	}

	public List<CarOptionalPackage> getOptionalList() {
		return optionalList;
	}

	public void setOptionalList(List<CarOptionalPackage> optionalList) {
		this.optionalList = optionalList;
	}

}
