package com.unicdata.service.car;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarAllot;

/**
 * 车辆调拨信息
 * 
 * @author wxn
 * @date 2018年6月4日
 */
public interface CarAllotService {
	int insertSelective(CarAllot record);

	CarAllot selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarAllot record);
	
	List<Map<String, Object>> selectListByApplication(Integer applicationId);
}
