package com.unicdata.service.area;

import com.unicdata.entity.basedata.City;
import com.unicdata.entity.basedata.District;
import com.unicdata.entity.basedata.Province;

import java.util.List;

public interface AreaService {

    /**
     * 获取所有省份
     * @return
     */
    List<Province> provinces();


    /**
     * 根据省份ID获取所有市
     * @param provinceId
     * @return
     */
    List<City> CitiesByProvinceId(Integer provinceId);


    /**
     * 根据市ID获取地区
     * @param cityId
     * @return
     */
    List<District> DistrictsByCityId(Integer cityId);
    
    /**
     * 根据名称获取id
     * @param name
     * @param level
     * @param parentId
     * @return
     */
    Integer getIdByName(String name,int level,Integer parentId);
}
