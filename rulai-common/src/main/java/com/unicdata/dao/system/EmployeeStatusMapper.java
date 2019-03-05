package com.unicdata.dao.system;

import com.unicdata.entity.system.EmployeeStatus;
import com.unicdata.entity.system.EmployeeStatusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeStatusMapper {
    int countByExample(EmployeeStatusExample example);

    int deleteByExample(EmployeeStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeStatus record);

    int insertSelective(EmployeeStatus record);

    List<EmployeeStatus> selectByExample(EmployeeStatusExample example);

    EmployeeStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeStatus record, @Param("example") EmployeeStatusExample example);

    int updateByExample(@Param("record") EmployeeStatus record, @Param("example") EmployeeStatusExample example);

    int updateByPrimaryKeySelective(EmployeeStatus record);

    int updateByPrimaryKey(EmployeeStatus record);
}