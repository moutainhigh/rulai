package com.unicdata.dao.carInfo;

import com.unicdata.entity.carInfo.UnicdataVehicleConfig;
import com.unicdata.entity.carInfo.UnicdataVehicleConfigExample;
import java.util.List;

public interface UnicdataVehicleConfigMapper {
    int deleteByPrimaryKey(Integer rowNames);

    int insert(UnicdataVehicleConfig record);

    int insertSelective(UnicdataVehicleConfig record);

    List<UnicdataVehicleConfig> selectByExample(UnicdataVehicleConfigExample example);

    UnicdataVehicleConfig selectByPrimaryKey(Integer rowNames);

    int updateByPrimaryKeySelective(UnicdataVehicleConfig record);

    int updateByPrimaryKey(UnicdataVehicleConfig record);
}