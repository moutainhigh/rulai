package com.unicdata.dao.carInfo;

import com.unicdata.entity.carInfo.UnicdataBrand;
import com.unicdata.entity.carInfo.UnicdataBrandExample;
import java.util.List;

public interface UnicdataBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UnicdataBrand record);

    int insertSelective(UnicdataBrand record);

    List<UnicdataBrand> selectByExample(UnicdataBrandExample example);

    UnicdataBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UnicdataBrand record);

    int updateByPrimaryKey(UnicdataBrand record);
}