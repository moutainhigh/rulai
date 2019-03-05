package com.unicdata.dao.system;

import com.unicdata.entity.system.Role;
import com.unicdata.entity.system.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);


    Role findRolePermissions(Integer roleId);

    int distributionPermission(@Param("roleId") Integer roleId , @Param("permissionId") Integer permissionId);

    /**
     * 删除权限角色关系表关系  by roleId
     * @param roleId
     * @return
     */
    int roleDeletePermission(Integer roleId );

    /**
     * 删除权限角色关系表关系  by permissionId及其下级权限
     * @param permissionId
     * @return
     */
    int delPermissionRole(Integer permissionId);
}