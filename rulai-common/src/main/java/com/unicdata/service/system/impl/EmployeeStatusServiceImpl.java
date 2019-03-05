package com.unicdata.service.system.impl;

import com.unicdata.dao.system.EmployeeStatusMapper;
import com.unicdata.entity.system.EmployeeStatus;
import com.unicdata.entity.system.EmployeeStatusExample;
import com.unicdata.service.system.EmployeeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/6/3.
 */
@Service
public class EmployeeStatusServiceImpl implements EmployeeStatusService {
    @Autowired
    private EmployeeStatusMapper employeeStatusMapper;
    @Override
    public int updateByPrimaryKey(EmployeeStatus record) {
        return employeeStatusMapper.updateByPrimaryKey(record);
    }

    @Override
    public EmployeeStatus selectByPrimaryKey(Integer id) {
        return employeeStatusMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<EmployeeStatus> selectByExample(EmployeeStatusExample example) {
        return employeeStatusMapper.selectByExample(example);
    }

    @Override
    public int insertSelective(EmployeeStatus record) {
        return employeeStatusMapper.insertSelective(record);
    }
}
