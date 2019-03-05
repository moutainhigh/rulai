package com.unicdata.service.system;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.system.EmployeePost;
import com.unicdata.entity.system.EmployeePostExample;

import java.util.List;

/**
 * Created by myMsi on 2018/6/1.
 */
public interface EmployeePostService {

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeePost record);

    int insertSelective(EmployeePost record);

    List<EmployeePost> selectByExample(EmployeePostExample example);

    EmployeePost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeePost record);

    int updateByPrimaryKey(EmployeePost record);

    ApiReturnInfo save(EmployeePost employeePost);

}
