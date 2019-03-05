package com.unicdata.service.car;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarVehicleConf;

import java.util.Map;

/**
 * 车型
 * 
 * @author wxn
 * @date 2018年6月1日
 */
public interface AppCarVehicleConfService {
	int insertSelective(CarVehicleConf record);

	CarVehicleConf selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarVehicleConf record);

	/**
	 * 根据门店id获取车型列表
	 * @param pageNum 
	 * @param pageSize 
	 * 
	 * @param storeId
	 * @return
	 */
	PageInfo<Map<String, Object>> selectListByBrandId(Map<String, Object> params, Integer pageSize, Integer pageNum);
}
