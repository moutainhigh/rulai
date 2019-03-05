package com.unicdata.service.car;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarWarehouse;

/**
 * 车辆仓库
 * 
 * @author wxn
 * @date 2018年6月1日
 */
public interface CarWarehouseService {
	int insertSelective(CarWarehouse record);

	CarWarehouse selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarWarehouse record);

	/**
	 * 根据门店id获取仓库列表
	 * 
	 * @param storeId
	 * @return
	 */
	PageInfo<CarWarehouse> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum);
}
