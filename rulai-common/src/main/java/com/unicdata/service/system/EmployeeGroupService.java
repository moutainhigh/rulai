package com.unicdata.service.system;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.system.EmployeeGroup;
import com.unicdata.entity.system.EmployeeGroupExample;

import java.util.List;

/**
 * Created by shenyong on 2018/6/1.
 */
public interface EmployeeGroupService {

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeGroup record);

    int insertSelective(EmployeeGroup record);

    List<EmployeeGroup> selectByExample(EmployeeGroupExample example);

    EmployeeGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeGroup record);

    int updateByPrimaryKey(EmployeeGroup record);

    PageInfo storeList(Integer pageNum, Integer pageSize, EmployeeGroup employee);

    ApiReturnInfo save(EmployeeGroup record);

}
