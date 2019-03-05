package com.unicdata.dao.system;

import com.unicdata.entity.system.Permissions;
import com.unicdata.entity.system.PermissionsExample;
import java.util.List;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    List<Permissions> selectByExample(PermissionsExample example);

    Permissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);

    int deleteByKey(Integer permissionId);

    List<Permissions> selectPermissionsByUserId(Integer employeeId);
}