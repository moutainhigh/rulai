package com.unicdata.conditon;

import java.util.List;

import com.unicdata.entity.car.CarBoutiqueBinding;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;

/**
 * 商品车保存用
 * 
 * @author wxn
 * @date 2018年6月5日
 */
public class GoodsStorageCondition {

	private List<CarBoutiqueBinding> carBoutiqueList;

	private CarGoodInfoWithBLOBs carGoodInfo;
	
	private String boutuqueIds;

	public List<CarBoutiqueBinding> getCarBoutiqueList() {
		return carBoutiqueList;
	}

	public void setCarBoutiqueList(List<CarBoutiqueBinding> carBoutiqueList) {
		this.carBoutiqueList = carBoutiqueList;
	}

	public CarGoodInfoWithBLOBs getCarGoodInfo() {
		return carGoodInfo;
	}

	public void setCarGoodInfo(CarGoodInfoWithBLOBs carGoodInfo) {
		this.carGoodInfo = carGoodInfo;
	}

	public String getBoutuqueIds() {
		return boutuqueIds;
	}

	public void setBoutuqueIds(String boutuqueIds) {
		this.boutuqueIds = boutuqueIds;
	}

}
