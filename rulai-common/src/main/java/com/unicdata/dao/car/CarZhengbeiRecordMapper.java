package com.unicdata.dao.car;

import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarZhengbeiRecord;

public interface CarZhengbeiRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarZhengbeiRecord record);

    int insertSelective(CarZhengbeiRecord record);

    CarZhengbeiRecord selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(CarZhengbeiRecord record);
    
    int updateByPrimaryKey(CarZhengbeiRecord record);
	// 整备列wp
	Page<Map<String, Object>> detectionCarList(Map<String, Object> map);
	//完善整备列表 wp
	int updateZhengbeiInfo(CarZhengbeiRecord carZhengbeiRecord);
	//暂收整备处理状态 wp
	Map<String, Object> zanshouZhengbeiStatus(Map<String, Object> map);
}