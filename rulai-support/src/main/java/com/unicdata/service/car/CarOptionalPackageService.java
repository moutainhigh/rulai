package com.unicdata.service.car;

import java.math.BigDecimal;
import java.util.List;

import com.unicdata.entity.car.CarOptionalPackage;

/**
 * 选装件
 * 
 * @author wxn
 * @date 2018年6月2日
 */
public interface CarOptionalPackageService {
	int insertSelective(CarOptionalPackage record);

	CarOptionalPackage selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarOptionalPackage record);
	
	List<CarOptionalPackage> selectByVin(String vin);

	BigDecimal selectSumByVin(String vin);
}
