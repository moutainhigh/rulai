package com.unicdata.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.dao.system.RoleMapper;
import com.unicdata.entity.system.Permissions;
import com.unicdata.entity.system.PermissionsExample;
import com.unicdata.entity.system.Role;
import com.unicdata.entity.system.RoleExample;
import com.unicdata.service.system.EmployeeService;
import com.unicdata.service.system.PermissionService;
import com.unicdata.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by shenyong on 2018/6/1.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private EmployeeService employeeService;


    @Autowired
    private PermissionService permissionService;

    public int deleteByPrimaryKey(Integer id) {
        int x = roleMapper.deleteByPrimaryKey(id);
        if(x>0)
            //删除角色对应的权限
            x = roleMapper.roleDeletePermission(id);
        if(x > 0 )
            x = employeeService.delRoleByUser(id);
        return x;
    }

    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }


    public List<Role> selectByExample(RoleExample example) {
        return roleMapper.selectByExample(example);
    }

    public Role selectByPrimaryKey(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询
     * @param resp
     * @param pageNo
     * @param pageSize
     * @param role
     */
    public PageInfo roluList(ApiReturnInfo resp, Integer pageNo, Integer pageSize, Role role) {
        pageNo = null == pageNo || pageNo < 1 ? pageNo = 1 : pageNo;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE: pageSize;

        PageHelper.startPage(pageNo, pageSize);
        RoleExample pe = new RoleExample();
        RoleExample.Criteria criteria = pe.createCriteria();
        if(role.getStatus() != null ){
            criteria.andStatusEqualTo(role.getStatus());
        }
        List<Role> Rolees = roleMapper.selectByExample(pe);
        //封装分页信息
        PageInfo<Role> pageInfo = new PageInfo<Role>(Rolees);
        resp.setData(pageInfo);
        return pageInfo;
    }

    /**
     * 保存
     * @param record
     * @return
     */
    public ApiReturnInfo save(Role record) {
        ApiReturnInfo ar = new ApiReturnInfo();
        int num = 0;
        if(record.getId() == null || record.getId()<=0){
            record.setCreateDate(new Date());
            num = this.insertSelective(record);
        }else{
            record.setUpdateDate(new Date());
            num = this.updateByPrimaryKeySelective(record);
        }
        Map json = new HashMap();
        if (num > 0) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
            ar.setMessage(record.getId()+"");
        } else {
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage("操作失败！ ");
        }
        return ar;

    }

    /**
     * 查询角色对应的权限
     * @param roleId
     * @return
     */
    public Role findRolePermissions(Integer roleId) {
        Role rolePermissions =  roleMapper.findRolePermissions(roleId);
        if(rolePermissions != null && StringUtil.isNotEmpty(rolePermissions.getRpPerminsionIds())){
            List list = new ArrayList();
            for(String x : rolePermissions.getRpPerminsionIds().split(",")){
                list.add(Integer.parseInt(x));
            }
            PermissionsExample pe = new PermissionsExample();
            PermissionsExample.Criteria criteria = pe.createCriteria();
            criteria.andIdIn(list);
            criteria.andStatusEqualTo(0);
            criteria.andDataStatusEqualTo(1);
            List<Permissions> permissionses = permissionService.selectByExample(pe);
            rolePermissions.setPermissions(permissionses);
        }
        return rolePermissions;
    }

    /**
     * 角色分配权限保存
     * @param roleId
     * @param permissions
     * @return
     */
    public int distributionPermission(Integer roleId, String permissions) {
        int v = 1;
        try {
            if (!"".equals(permissions)) {
                //删除角色对应的权限
                roleMapper.roleDeletePermission(roleId);
                //把新选中的权限新增到角色权限表中
                for (String permission : permissions.split(",")) {
                    roleMapper.distributionPermission(roleId, Integer.parseInt(permission));
                }
            }
        }catch (Exception ex){v = 0 ;}
        return v;
    }

    /**
     * 删除权限角色关系表关系  by permissionId及其下级权限
     * @param permissionId
     * @return
     */
    public int delPermissionRole(Integer permissionId){
        return roleMapper.delPermissionRole(permissionId);
    }

}
