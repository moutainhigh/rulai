package com.unicdata.dao.carInfo;

import com.unicdata.entity.carInfo.UnicdataZiduanbiao;
import com.unicdata.entity.carInfo.UnicdataZiduanbiaoExample;
import java.util.List;

public interface UnicdataZiduanbiaoMapper {
    int deleteByPrimaryKey(Integer nameId);

    int insert(UnicdataZiduanbiao record);

    int insertSelective(UnicdataZiduanbiao record);

    List<UnicdataZiduanbiao> selectByExample(UnicdataZiduanbiaoExample example);

    UnicdataZiduanbiao selectByPrimaryKey(Integer nameId);

    int updateByPrimaryKeySelective(UnicdataZiduanbiao record);

    int updateByPrimaryKey(UnicdataZiduanbiao record);
}