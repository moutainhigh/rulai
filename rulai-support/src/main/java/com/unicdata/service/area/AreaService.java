package com.unicdata.service.area;

import com.unicdata.entity.basedata.City;
import com.unicdata.entity.basedata.District;
import com.unicdata.entity.basedata.Province;

import java.util.List;

public interface AreaService {


    /**
     * 根据省市区获取地址
     * @param provinceId
     * @param cityId
     * @param districtId
     * @return
     */
    String getAddressBy(Integer provinceId, Integer cityId, Integer districtId);
}
