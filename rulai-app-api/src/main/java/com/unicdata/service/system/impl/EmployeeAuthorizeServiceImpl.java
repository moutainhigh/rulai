package com.unicdata.service.system.impl;

import com.unicdata.dao.system.EmployeeAuthorizeMapper;
import com.unicdata.entity.system.EmployeeAuthorize;
import com.unicdata.entity.system.EmployeeAuthorizeExample;
import com.unicdata.service.system.EmployeeAuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/27.
 */
@Service
public class EmployeeAuthorizeServiceImpl implements EmployeeAuthorizeService {
    @Autowired
    private EmployeeAuthorizeMapper employeeAuthorizeMapper;

    @Override
    public int insert(EmployeeAuthorize record) {
        return employeeAuthorizeMapper.insert(record);
    }

    @Override
    public int insertSelective(EmployeeAuthorize record) {
        return employeeAuthorizeMapper.insertSelective(record);
    }

    @Override
    public List<EmployeeAuthorize> selectByExample(EmployeeAuthorizeExample example) {
        return employeeAuthorizeMapper.selectByExample(example);
    }

    @Override
    public EmployeeAuthorize selectByPrimaryKey(Integer id) {
        return employeeAuthorizeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(EmployeeAuthorize record) {
        return employeeAuthorizeMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 通过授权人和被授权人id查询
     *
     * @param map
     * @return
     */
    @Override
    public List<EmployeeAuthorize> selectByEmployeeId(Map<String, Object> map) {
        return employeeAuthorizeMapper.selectByEmployeeId(map);
    }
}
