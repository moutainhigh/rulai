package com.unicdata.service.area.impl;

import com.unicdata.dao.basedata.CityMapper;
import com.unicdata.dao.basedata.DistrictMapper;
import com.unicdata.dao.basedata.ProvinceMapper;
import com.unicdata.entity.basedata.*;
import com.unicdata.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AreaServiceImpl implements AreaService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public String getAddressBy(Integer provinceId, Integer cityId, Integer districtId) {
        String provinceName = "";
        if (provinceId != null) {
            Province province = provinceMapper.selectByPrimaryKey(provinceId);
            provinceName = (province == null ? "" : (province.getProvinceName() == null ? "" : province.getProvinceName()));
        }
        String cityName = "";
        if (cityId != null) {
            City city = cityMapper.selectByPrimaryKey(cityId);
            cityName = (city == null ? "" : (city.getCityName() == null ? "" : city.getCityName()));
        }
        String districtName = "";
        if (districtId != null) {
            District district = districtMapper.selectByPrimaryKey(districtId);
            districtName = (district == null ? "" : (district.getDistrictName() == null ? "" : district.getDistrictName()));
        }
        return provinceName + cityName + districtName;
    }
}
