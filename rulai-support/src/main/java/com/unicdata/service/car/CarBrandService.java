package com.unicdata.service.car;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarBrand;

/**
 * 品牌
 * 
 * @author wxn
 * @date 2018年6月1日
 */
public interface CarBrandService {

	int insertSelective(CarBrand record);

	CarBrand selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarBrand record);

	/**
	 * 根据门店id获取品牌列表
	 * 
	 * @param storeId
	 * @return
	 */
	PageInfo<CarBrand> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum);

	CarBrand selectByName(Integer storeId, String name, String factoryName);

}
