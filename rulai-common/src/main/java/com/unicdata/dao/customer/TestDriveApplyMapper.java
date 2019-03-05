package com.unicdata.dao.customer;

import com.unicdata.entity.customer.TestDriveApply;
import com.unicdata.entity.customer.TestDriveApplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface TestDriveApplyMapper {
    int countByExample(TestDriveApplyExample example);

    int deleteByExample(TestDriveApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestDriveApply record);

    int insertSelective(TestDriveApply record);

    List<TestDriveApply> selectByExample(TestDriveApplyExample example);

    TestDriveApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestDriveApply record, @Param("example") TestDriveApplyExample example);

    int updateByExample(@Param("record") TestDriveApply record, @Param("example") TestDriveApplyExample example);

    int updateByPrimaryKeySelective(TestDriveApply record);

    int updateByPrimaryKey(TestDriveApply record);

    //试驾车申请分页查询
    List<Map<String, Object>> testDriveApplyList(Map<String, Object> params);

    List<Map<String, Object>> testCarApprovalList(Map param);

    List<Map<String, Object>> testCarApprovalCars(Integer applyId);

    List<Map<String, Object>> listByCreateId(Integer createId);
}