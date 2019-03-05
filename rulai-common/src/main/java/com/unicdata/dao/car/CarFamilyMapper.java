package com.unicdata.dao.car;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarFamily;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CarFamilyMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(CarFamily record);

	int insertSelective(CarFamily record);

	CarFamily selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarFamily record);

	int updateByPrimaryKey(CarFamily record);

	Page<Map<String, Object>> selectListByStore(Integer distributorStoreId);

	Page<Map<String, Object>> selectListByBrandId(Map<String, Object> map);

	List<CarFamily> selectListByBrand(Integer brandId);

	CarFamily selectByName(Map<String, Object> map);
	
	
	/**
	 * 根据店铺ID获取车系信息
	 * @param storeId
	 * @return
	 */
	List<Map<String, Object>> selectListByStoreId(Integer storeId);
	/**
	 * 查车系 wp
	 */
	List<Map<String, Object>> selectCarFamily(Map<String, Object> map);

	List<CarFamily> findAllFamilyByStoreId(@Param("storeId")Integer storeId);
	/**
	 * 根据ID字符串获取车系名字符串
	 * @param idStrs(id1,id2...)
	 * @return
	 */
	String getNamesByIds(String idStrs);
}