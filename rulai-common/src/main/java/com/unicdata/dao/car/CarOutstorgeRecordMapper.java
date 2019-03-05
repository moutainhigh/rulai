package com.unicdata.dao.car;

import com.unicdata.entity.car.CarOutstorgeRecord;

public interface CarOutstorgeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarOutstorgeRecord record);

    int insertSelective(CarOutstorgeRecord record);

    CarOutstorgeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarOutstorgeRecord record);

    int updateByPrimaryKey(CarOutstorgeRecord record);
}