package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarOut;

public interface CarOutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarOut record);

    int insertSelective(CarOut record);

    CarOut selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarOut record);

    int updateByPrimaryKey(CarOut record);

	List<Map<String, Object>> selectListByApplicationId(Integer carOutId);
	//汽车外出列表 wp
	Page<Map<String, Object>> selectCarOutList(Map<String, Object> map);
}