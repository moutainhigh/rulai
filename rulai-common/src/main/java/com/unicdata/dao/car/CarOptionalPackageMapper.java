package com.unicdata.dao.car;

import java.math.BigDecimal;
import java.util.List;

import com.unicdata.entity.car.CarOptionalPackage;

public interface CarOptionalPackageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarOptionalPackage record);

    int insertSelective(CarOptionalPackage record);

    CarOptionalPackage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarOptionalPackage record);

    int updateByPrimaryKey(CarOptionalPackage record);

	List<CarOptionalPackage> selectByVin(String vin);

	BigDecimal selectSumByVin(String vin);
}