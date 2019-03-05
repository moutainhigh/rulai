package com.unicdata.dao.system;

import com.unicdata.entity.system.RolePermission;
import com.unicdata.entity.system.RolePermissionExample;
import java.util.List;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionExample example);
}