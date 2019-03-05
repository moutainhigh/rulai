package com.unicdata.service.car;

import com.unicdata.entity.car.CarOptionalPackage;

import java.util.List;

/**
 * 选装件
 * 
 * @author wxn
 * @date 2018年6月2日
 */
public interface AppCarOptionalPackageService {
	int insertSelective(CarOptionalPackage record);

	CarOptionalPackage selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarOptionalPackage record);
	
	List<CarOptionalPackage> selectByVin(String vin);
}
