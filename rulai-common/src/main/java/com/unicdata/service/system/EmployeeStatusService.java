package com.unicdata.service.system;

import com.unicdata.entity.system.EmployeeStatus;
import com.unicdata.entity.system.EmployeeStatusExample;

import java.util.List;

/**
 * Created by lenovo on 2018/6/3.
 */
public interface EmployeeStatusService {
    int updateByPrimaryKey(EmployeeStatus record);

    EmployeeStatus selectByPrimaryKey(Integer id);

    List<EmployeeStatus> selectByExample(EmployeeStatusExample example);

    int insertSelective(EmployeeStatus record);
}
