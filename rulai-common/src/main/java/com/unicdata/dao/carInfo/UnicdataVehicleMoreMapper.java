package com.unicdata.dao.carInfo;

import com.unicdata.entity.carInfo.UnicdataVehicleMore;
import com.unicdata.entity.carInfo.UnicdataVehicleMoreExample;
import java.util.List;

public interface UnicdataVehicleMoreMapper {
    int deleteByPrimaryKey(Integer rowNames);

    int insert(UnicdataVehicleMore record);

    int insertSelective(UnicdataVehicleMore record);

    List<UnicdataVehicleMore> selectByExample(UnicdataVehicleMoreExample example);

    UnicdataVehicleMore selectByPrimaryKey(Integer rowNames);

    int updateByPrimaryKeySelective(UnicdataVehicleMore record);

    int updateByPrimaryKey(UnicdataVehicleMore record);
}