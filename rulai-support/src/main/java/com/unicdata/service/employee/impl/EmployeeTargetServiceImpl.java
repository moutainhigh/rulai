package com.unicdata.service.employee.impl;

import com.unicdata.base.util.DateUtil;
import com.unicdata.dao.system.EmployeeTargetMapper;
import com.unicdata.entity.system.EmployeeTarget;
import com.unicdata.service.employee.EmployeeTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 员工销售目标服务层
 *
 * @author admin
 */
@Service
public class EmployeeTargetServiceImpl implements EmployeeTargetService {

    @Autowired
    private EmployeeTargetMapper employeeTargetMapper;

    @Override
    public EmployeeTarget getCurrentMothTarget(Integer employeeId) {
        EmployeeTarget record = new EmployeeTarget();
        record.setEmployeeId(employeeId);
        String date = DateUtil.dateFormat(new Date(), DateUtil.sdf7);
        record.setTargetTime(date);
        return employeeTargetMapper.selectEmployeeTarget(record);
    }

    @Override
    public List<EmployeeTarget> selectEmployeeTargetByStoreId(Map<String, Object> map) {
        return employeeTargetMapper.selectEmployeeTargetByStoreId(map);
    }

    @Override
    public int insertSelective(EmployeeTarget record) {
        return employeeTargetMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(EmployeeTarget record) {
        return employeeTargetMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Map<String, Object> getMothTargetNumByStoreId(Map<String, Object> map) {
        return employeeTargetMapper.getMothTargetNumByStoreId(map);
    }

    @Override
    public List<Map<String, Object>> saleManTarget(Map param) {
        return employeeTargetMapper.saleManTarget(param);
    }

    @Override
    public EmployeeTarget employeeIdTarget(Map param) {
        return employeeTargetMapper.employeeIdTarget(param);
    }
}
