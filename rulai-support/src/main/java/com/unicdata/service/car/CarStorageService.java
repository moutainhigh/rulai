package com.unicdata.service.car;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarStorage;

/**
 * 车辆库位
 * 
 * @author wxn
 * @date 2018年6月1日
 */
public interface CarStorageService {
	int insertSelective(CarStorage record);

	CarStorage selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarStorage record);

	/**
	 * 根据仓库id获取库位列表
	 * 
	 * @param storeId
	 * @return
	 */
	PageInfo<CarStorage> selectListByWareHouse(Integer warehouseId, Integer pageSize, Integer pageNum);

	/**
	 * 根据仓库id获取库位列表 排除外出车辆已占用库位
	 * 
	 * @param warehouseId
	 * @return
	 */
	List<CarStorage> selectListExceptOut(Integer warehouseId);
}
