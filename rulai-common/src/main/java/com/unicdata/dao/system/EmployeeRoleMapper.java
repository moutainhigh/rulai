package com.unicdata.dao.system;

import com.unicdata.entity.system.EmployeeRole;
import com.unicdata.entity.system.EmployeeRoleExample;
import java.util.List;

public interface EmployeeRoleMapper {
    int insert(EmployeeRole record);

    int insertSelective(EmployeeRole record);

    List<EmployeeRole> selectByExample(EmployeeRoleExample example);
}