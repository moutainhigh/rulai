package com.unicdata.dao.system;

import com.unicdata.entity.system.EmployeePost;
import com.unicdata.entity.system.EmployeePostExample;
import java.util.List;

public interface EmployeePostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeePost record);

    int insertSelective(EmployeePost record);

    List<EmployeePost> selectByExample(EmployeePostExample example);

    EmployeePost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeePost record);

    int updateByPrimaryKey(EmployeePost record);
}