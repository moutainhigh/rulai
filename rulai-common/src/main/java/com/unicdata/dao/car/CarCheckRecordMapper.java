package com.unicdata.dao.car;

import com.unicdata.entity.car.CarCheckRecord;

public interface CarCheckRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarCheckRecord record);

    int insertSelective(CarCheckRecord record);

    CarCheckRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarCheckRecord record);

    int updateByPrimaryKey(CarCheckRecord record);
    //暂收入库检测完善检测信息
    int updateCheckStatus(CarCheckRecord carCheckRecord);
}