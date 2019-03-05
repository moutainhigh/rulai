package com.unicdata.service.car;

import java.util.List;

import com.unicdata.entity.car.CarColor;

/**
 * 车 颜色
 * 
 * @author wxn
 * @date 2018年6月6日
 */
public interface CarColorService {

	int insertSelective(CarColor record);

	CarColor selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarColor record);

	CarColor selectByFamilyAndName(Integer familyId, String name, Integer locationStatus);

	List<CarColor> selectColorByFamily(Integer familyId);

}
