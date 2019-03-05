package com.unicdata.service.carInfo;

import com.unicdata.entity.carInfo.UnicdataBrand;
import com.unicdata.entity.carInfo.UnicdataFamily;

import java.util.List;

public interface BaseCarInfoService {

    /**
     * 获取所有品牌
     * @return
     */
    List<UnicdataBrand> allBrand();

    /**
     * 根据品牌ID获取下面所有车系
     * @param brandId
     * @return
     */
    List<UnicdataFamily> familiesByBrandId(Integer brandId);

    /**
     * 根据车系ID获取
     * @param familyId
     * @return
     */
    UnicdataFamily getFamilyByFamilyId(Integer familyId);

    /**
     * 根据车系名称集合获取车系名字
     * @param familyIds
     * @return
     */
    List<String> getFamilyNamesByFamilyIds(List<Integer> familyIds);
}
