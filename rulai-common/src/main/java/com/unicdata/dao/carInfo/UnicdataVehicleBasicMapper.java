package com.unicdata.dao.carInfo;

import com.unicdata.entity.carInfo.UnicdataVehicleBasic;
import com.unicdata.entity.carInfo.UnicdataVehicleBasicExample;
import java.util.List;

public interface UnicdataVehicleBasicMapper {
    int deleteByPrimaryKey(Integer rowNames);

    int insert(UnicdataVehicleBasic record);

    int insertSelective(UnicdataVehicleBasic record);

    List<UnicdataVehicleBasic> selectByExample(UnicdataVehicleBasicExample example);

    UnicdataVehicleBasic selectByPrimaryKey(Integer rowNames);

    int updateByPrimaryKeySelective(UnicdataVehicleBasic record);

    int updateByPrimaryKey(UnicdataVehicleBasic record);
}