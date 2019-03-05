package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarAllotApplication;

public interface CarAllotApplicationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarAllotApplication record);

    int insertSelective(CarAllotApplication record);

    CarAllotApplication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarAllotApplication record);

    int updateByPrimaryKeyWithBLOBs(CarAllotApplication record);

    int updateByPrimaryKey(CarAllotApplication record);

	Page<Map<String, Object>> selectListByStore(Integer distributorStoreId);
	//调拨申请单列表 wp
	List<Map<String, Object>> selectAllotApplication(Map<String, Object> map);
	//调拨申请单下的汽车 wp
	List<Map<String, Object>> selectCarListByAllot(Map<String , Object> map); 
}