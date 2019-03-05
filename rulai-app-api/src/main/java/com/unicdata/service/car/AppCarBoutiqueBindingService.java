package com.unicdata.service.car;

import com.unicdata.entity.car.CarBoutiqueBinding;

import java.util.List;
import java.util.Map;

/**
 * 车辆精品绑定表
 * 
 * @author wxn
 * @date 2018年6月2日
 */
public interface AppCarBoutiqueBindingService {
	int insertSelective(CarBoutiqueBinding record);

	CarBoutiqueBinding selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarBoutiqueBinding record);
	
	List<Map<String, Object>> selectByCarId(Integer carId);
}
