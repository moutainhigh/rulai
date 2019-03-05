package com.unicdata.dao.carInfo;

import com.unicdata.entity.carInfo.UnicdataFamily;
import com.unicdata.entity.carInfo.UnicdataFamilyExample;

import java.util.List;
import java.util.Map;

public interface UnicdataFamilyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UnicdataFamily record);

    int insertSelective(UnicdataFamily record);

    List<UnicdataFamily> selectByExample(UnicdataFamilyExample example);

    UnicdataFamily selectByPrimaryKey(Integer id);

    Map<String, Object> selectBFNameByFamilyId(Integer id);

    int updateByPrimaryKeySelective(UnicdataFamily record);

    int updateByPrimaryKey(UnicdataFamily record);

    UnicdataFamily selectByFamilyId(Integer familyId);
}