package com.unicdata.dao.car;

import java.util.List;

import com.unicdata.entity.car.CarInsuranceRecord;
import com.unicdata.entity.car.CarInterestRule;

public interface CarInterestRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarInterestRule record);

    int insertSelective(CarInterestRule record);

    CarInterestRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarInterestRule record);

    int updateByPrimaryKey(CarInterestRule record);
    
    List<CarInterestRule> selectListByFamily(Integer familyId);
}