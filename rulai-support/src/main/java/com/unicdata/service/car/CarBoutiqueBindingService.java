package com.unicdata.service.car;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarBoutiqueBinding;

/**
 * 车辆精品绑定表
 * 
 * @author wxn
 * @date 2018年6月2日
 */
public interface CarBoutiqueBindingService {
	int insertSelective(CarBoutiqueBinding record);

	CarBoutiqueBinding selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarBoutiqueBinding record);
	
	List<Map<String, Object>> selectByCarId(Integer carId);
}
