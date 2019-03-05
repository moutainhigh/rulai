package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarAllot;

public interface CarAllotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarAllot record);

    int insertSelective(CarAllot record);

    CarAllot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarAllot record);

    int updateByPrimaryKey(CarAllot record);

	List<Map<String, Object>> selectListByApplication(Integer applicationId);
	//今日调拨 wp
	List<Map<String, Object>> carAllotList(Map<String, Object> map);
}