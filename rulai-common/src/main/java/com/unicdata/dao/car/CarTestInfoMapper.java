package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarTestInfo;

public interface CarTestInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarTestInfo record);

    int insertSelective(CarTestInfo record);

    CarTestInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarTestInfo record);

    int updateByPrimaryKey(CarTestInfo record);

	Page<Map<String, Object>> selectListByStore(Integer distributorId);
	//试驾车列 wp
	Page<Map<String, Object>> selectTestCarList(Map<String, Object> map);
	//试驾车详情 wp
	Map<String, Object> carTestDetailInfo(Map<String, Object> map);
	//试驾车车型列 wp
	List<Map<String, Object>> carTestConf(Map<String, Object> map);
	//扫一扫 wp
	Map<String, Object> carTestScan(String vin);
	
}