package com.unicdata.dao.carInfo;

import com.unicdata.entity.carInfo.UnicdataFactory;
import com.unicdata.entity.carInfo.UnicdataFactoryExample;
import java.util.List;

public interface UnicdataFactoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UnicdataFactory record);

    int insertSelective(UnicdataFactory record);

    List<UnicdataFactory> selectByExample(UnicdataFactoryExample example);

    UnicdataFactory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UnicdataFactory record);

    int updateByPrimaryKey(UnicdataFactory record);
}