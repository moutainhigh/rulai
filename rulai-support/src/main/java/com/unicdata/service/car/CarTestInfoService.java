package com.unicdata.service.car;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarTestInfo;

/**
 * 试驾车库存
 * 
 * @author wxn
 * @date 2018年6月3日
 */
public interface CarTestInfoService {
	int insertSelective(CarTestInfo record);

	CarTestInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarTestInfo record);
	
	PageInfo<Map<String, Object>> selectListByStore(Integer distributorId, Integer pageSize, Integer pageNum);
}
