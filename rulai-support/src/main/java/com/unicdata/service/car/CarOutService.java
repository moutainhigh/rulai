package com.unicdata.service.car;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarOut;

/**
 * 车辆外出详情
 * 
 * @author wxn
 * @date 2018年6月3日
 */
public interface CarOutService {
	int insertSelective(CarOut record);

	CarOut selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarOut record);

	List<Map<String, Object>> selectListByApplicationId(Integer carOutId);
}
