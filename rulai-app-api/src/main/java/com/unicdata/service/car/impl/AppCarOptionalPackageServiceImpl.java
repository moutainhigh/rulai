package com.unicdata.service.car.impl;

import com.unicdata.dao.car.CarOptionalPackageMapper;
import com.unicdata.entity.car.CarOptionalPackage;
import com.unicdata.service.car.AppCarOptionalPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppCarOptionalPackageServiceImpl implements AppCarOptionalPackageService {

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

}
