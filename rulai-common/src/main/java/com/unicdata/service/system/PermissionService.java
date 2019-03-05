package com.unicdata.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.system.Permissions;
import com.unicdata.entity.system.PermissionsExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by myMsi on 2018/6/1.
 */
 public interface PermissionService {


    int deleteByPrimaryKey(Integer id);

    /**
     * 逻辑删除权限
     * 传入的id以及id的子权限
     * @param id
     * @return
     */
     int deleteByKey(Integer id);

     int insert(Permissions record);

     int insertSelective(Permissions record);


     List<Permissions> selectByExample(PermissionsExample example) ;

     Permissions selectByPrimaryKey(Integer id);

     int updateByPrimaryKeySelective(Permissions record);

     int updateByPrimaryKey(Permissions record) ;

    /**
     * 查询
     * @param resp
     * @param pageNo
     * @param pageSize
     * @param permissions
     */
     PageInfo permissionList(ApiReturnInfo resp, Integer pageNo, Integer pageSize, Permissions permissions);

    /**
     * 保存
     * @param record
     * @return
     */
     ApiReturnInfo save(Permissions record) ;

     List<Permissions> selectPermissionsByUserId(Integer employeeId);

}
