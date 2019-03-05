package com.unicdata.service.car.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarFamilyMapper;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.service.car.CarFamilyService;

@Service
public class CarFamilyServiceImpl implements CarFamilyService {

    @Autowired
    private CarFamilyMapper carFamilyMapper;

    public int insertSelective(CarFamily record) {
        return carFamilyMapper.insertSelective(record);
    }

    public CarFamily selectByPrimaryKey(Integer id) {
        return carFamilyMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(CarFamily record) {
        return carFamilyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<Map<String, Object>> selectListByStore(Integer distributorStoreId, Integer pageSize,
                                                           Integer pageNum) {
        if (null != pageSize && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        return carFamilyMapper.selectListByStore(distributorStoreId).toPageInfo();
    }

    @Override
    public List<CarFamily> selectListByBrand(Integer brandId) {
        return carFamilyMapper.selectListByBrand(brandId);
    }

    @Override
    public CarFamily selectByName(Integer storeId, String name, Integer brandId) {
        Map<String, Object> params = new HashMap<>();
        params.put("storeId", storeId);
        params.put("name", name);
        params.put("brandId", brandId);
        return carFamilyMapper.selectByName(params);
    }

    @Override
    public String getNamesByIds(String idStrs) {
        return StringUtils.isBlank(idStrs) ? "" : carFamilyMapper.getNamesByIds(idStrs);
    }
}
