package com.unicdata.service.car.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.car.CarOptionalPackageMapper;
import com.unicdata.entity.car.CarOptionalPackage;
import com.unicdata.service.car.CarOptionalPackageService;

@Service
public class CarOptionalPackageServiceImpl implements CarOptionalPackageService {

	@Autowired
	private CarOptionalPackageMapper carOptionalPackageMapper;

	public int insertSelective(CarOptionalPackage record) {
		return carOptionalPackageMapper.insertSelective(record);
	}

	public CarOptionalPackage selectByPrimaryKey(Integer id) {
		return carOptionalPackageMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CarOptionalPackage record) {
		return carOptionalPackageMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<CarOptionalPackage> selectByVin(String vin) {
		return carOptionalPackageMapper.selectByVin(vin);
	}

	@Override
	public BigDecimal selectSumByVin(String vin) {
		return carOptionalPackageMapper.selectSumByVin(vin);
	}

}
