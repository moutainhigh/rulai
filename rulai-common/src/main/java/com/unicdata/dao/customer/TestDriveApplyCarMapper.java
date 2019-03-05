package com.unicdata.dao.customer;

import com.unicdata.entity.customer.TestDriveApplyCar;
import com.unicdata.entity.customer.TestDriveApplyCarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TestDriveApplyCarMapper {
    int countByExample(TestDriveApplyCarExample example);

    int deleteByExample(TestDriveApplyCarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestDriveApplyCar record);

    int insertSelective(TestDriveApplyCar record);

    List<TestDriveApplyCar> selectByExample(TestDriveApplyCarExample example);

    TestDriveApplyCar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestDriveApplyCar record, @Param("example") TestDriveApplyCarExample example);

    int updateByExample(@Param("record") TestDriveApplyCar record, @Param("example") TestDriveApplyCarExample example);

    int updateByPrimaryKeySelective(TestDriveApplyCar record);

    int updateByPrimaryKey(TestDriveApplyCar record);

    List<Map<String, Object>> selectByApplyId(Integer applyId);


}