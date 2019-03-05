package com.unicdata.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.entity.system.Role;
import com.unicdata.entity.system.RoleExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by shenyong on 2018/6/1.
 */
public interface RoleService {

     int deleteByPrimaryKey(Integer id) ;

     int insert(Role record);

     int insertSelective(Role record);

     List<Role> selectByExample(RoleExample example);

     Role selectByPrimaryKey(Integer id) ;

     int updateByPrimaryKeySelective(Role record);

     int updateByPrimaryKey(Role record);

    /**
     * 查询
     * @param resp
     * @param pageNo
     * @param pageSize
     * @param role
     */
     PageInfo roluList(ApiReturnInfo resp, Integer pageNo, Integer pageSize, Role role);

    /**
     * 保存
     * @param record
     * @return
     */
     ApiReturnInfo save(Role record) ;
    /**
     * 查询角色对应的权限
     * @param roleId
     * @return
     */
     Role findRolePermissions(Integer roleId) ;

    /**
     * 角色分配权限保存
     * @param roleId
     * @param permissions
     * @return
     */
     int distributionPermission(Integer roleId, String permissions) ;

    /**
     * 删除权限角色关系表关系  by permissionId及其下级权限
     * @param permissionId
     * @return
     */
    int delPermissionRole(Integer permissionId);


}
