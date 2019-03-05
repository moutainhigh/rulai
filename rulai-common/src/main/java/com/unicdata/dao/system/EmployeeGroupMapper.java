package com.unicdata.dao.system;

import com.unicdata.entity.system.EmployeeGroup;
import com.unicdata.entity.system.EmployeeGroupExample;
import java.util.List;

public interface EmployeeGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeGroup record);

    int insertSelective(EmployeeGroup record);

    List<EmployeeGroup> selectByExample(EmployeeGroupExample example);

    EmployeeGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeGroup record);

    int updateByPrimaryKey(EmployeeGroup record);
}