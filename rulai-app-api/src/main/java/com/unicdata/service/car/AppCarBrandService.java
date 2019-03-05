package com.unicdata.service.car;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarBrand;

public interface AppCarBrandService {
	/**
	 * 根据门店id获取品牌列表
	 * 
	 * @param storeId
	 * @return
	 */
	PageInfo<CarBrand> selectListByStore(Integer storeId, Integer pageSize, Integer pageNum);
}
