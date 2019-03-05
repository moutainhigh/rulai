package com.unicdata.service.car;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarTestInfo;

import java.util.Map;

/**
 * 试驾车库存
 * 
 * @author wxn
 * @date 2018年6月3日
 */
public interface AppCarTestInfoService {
	int insertSelective(CarTestInfo record);

	CarTestInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarTestInfo record);
	
	PageInfo<Map<String, Object>> selectListByStore(Integer distributorId, Integer pageSize, Integer pageNum);
	//试驾车列 wp
	Page<Map<String, Object>> selectTestCarList(Map<String, Object> map);
}
