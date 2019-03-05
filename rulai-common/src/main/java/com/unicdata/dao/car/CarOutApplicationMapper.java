package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarOutApplication;

public interface CarOutApplicationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarOutApplication record);

    int insertSelective(CarOutApplication record);

    CarOutApplication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarOutApplication record);

    int updateByPrimaryKeyWithBLOBs(CarOutApplication record);

    int updateByPrimaryKey(CarOutApplication record);

    Page<CarOutApplication> selectListByStore(Integer distributorStoreId);

    //查外出申请单 wp
    List<Map<String, Object>> selectCarOutApply(Map<String, Object> map);

    //外出单下的汽车列 wp
    List<Map<String, Object>> selectCarListByApply(Map<String, Object> map);

    Page listCreateBy(Map<String, Object> param);

    Page<CarOutApplication> selectListByParam(Map param);
}