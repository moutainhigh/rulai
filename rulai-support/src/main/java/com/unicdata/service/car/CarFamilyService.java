package com.unicdata.service.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarFamily;

/**
 * 车系
 * 
 * @author wxn
 * @date 2018年6月1日
 */
public interface CarFamilyService {

	int insertSelective(CarFamily record);

	CarFamily selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarFamily record);

	/**
	 * 根据门店id获取车系列表
	 * 
	 * @param storeId
	 * @return
	 */
	PageInfo<Map<String, Object>> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum);

	List<CarFamily> selectListByBrand(Integer brandId);

	CarFamily selectByName(Integer storeId, String name, Integer brandId);

	/**
	 * 根据ID字符串获取车系名字符串
	 * @param idStrs(id1,id2...)
	 * @return
	 */
	String getNamesByIds(String idStrs);
}
