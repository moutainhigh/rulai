package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarWeihuRecord;

public interface CarWeihuRecordMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(CarWeihuRecord record);

    int insertSelective(CarWeihuRecord record);

    
    CarWeihuRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarWeihuRecord record);
    int updateByPrimaryKey(CarWeihuRecord record);
    //维护记录 wp
    List<Map<String , Object>> selectByCarId(Integer carId);
}