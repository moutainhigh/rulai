package com.unicdata.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.dao.system.PermissionsMapper;
import com.unicdata.entity.system.Permissions;
import com.unicdata.entity.system.PermissionsExample;
import com.unicdata.service.system.PermissionService;
import com.unicdata.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by shenyong on 2018/6/1.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionsMapper permissionsMapper;
    @Autowired
    private RoleService roleService;

    public int deleteByPrimaryKey(Integer id) {
        return permissionsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 逻辑删除权限
     * 传入的id以及id的子权限
     * @param id
     * @return
     */
    public int deleteByKey(Integer id) {
        int x = permissionsMapper.deleteByKey(id);
        if(x > 0)
            x += roleService.delPermissionRole(id);
        return x;
    }

    public int insert(Permissions record) {
        return permissionsMapper.insert(record);
    }

    public int insertSelective(Permissions record) {
        return permissionsMapper.insertSelective(record);
    }

    @Override
    public List<Permissions> selectByExample(PermissionsExample example) {
        return permissionsMapper.selectByExample(example);
    }

    public Permissions selectByPrimaryKey(Integer id) {
        return permissionsMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Permissions record) {
        return permissionsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Permissions record) {
        return permissionsMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询
     * @param resp
     * @param pageNo
     * @param pageSize
     * @param permissions
     */
    public PageInfo permissionList(ApiReturnInfo resp, Integer pageNo, Integer pageSize, Permissions permissions) {
        pageNo = null == pageNo || pageNo < 1 ? pageNo = 1 : pageNo;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? Integer.MAX_VALUE : pageSize;

        PageHelper.startPage(pageNo, pageSize);
        PermissionsExample pe = new PermissionsExample();
        PermissionsExample.Criteria criteria = pe.createCriteria();
        if(permissions.getStatus() != null){
            criteria.andStatusEqualTo(permissions.getStatus());
        }
        criteria.andDataStatusEqualTo(1);
        pe.setOrderByClause(" parent_id asc , sort_no asc");
        List<Permissions> permissionses = permissionsMapper.selectByExample(pe);
        //封装分页信息
        PageInfo<Permissions> pageInfo = new PageInfo<Permissions>(permissionses);
        resp.setData(pageInfo);
        return pageInfo;
    }

    /**
     * 保存
     * @param record
     * @return
     */
    public ApiReturnInfo save(Permissions record) {
        int num = 0;
        if(record.getId() == null || record.getId()<=0){
            record.setCreateDate(new Date());
            num = this.insertSelective(record);
        }else{
            record.setUpdateDate(new Date());
            num = this.updateByPrimaryKeySelective(record);
        }
        ApiReturnInfo ar = new ApiReturnInfo();
        if (num > 0) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        } else {
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;

    }

    public List<Permissions> selectPermissionsByUserId(Integer employeeId) {
        return permissionsMapper.selectPermissionsByUserId(employeeId) ;
    }
}

