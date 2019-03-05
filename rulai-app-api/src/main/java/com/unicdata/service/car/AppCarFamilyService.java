package com.unicdata.service.car;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarFamily;

import java.util.List;
import java.util.Map;

/**
 * 车系
 * 
 * @author wxn
 * @date 2018年6月1日
 */
public interface AppCarFamilyService {

	int insertSelective(CarFamily record);

	CarFamily selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarFamily record);

	/**
	 * 根据门店id获取车系列表
	 * 
	 * @param storeId
	 * @return
	 */
	PageInfo<Map<String, Object>> selectListByBrandId(Map<String, Object> map, Integer pageSize, Integer pageNum);
	/**
	 * 根据门店id获取车系列表
	 * 
	 * @param storeId
	 * @return
	 */
	List<Map<String, Object>> selectListByStoreId(Integer storeId);
	
	String getUnicdataFamilyById(Integer id);
}
