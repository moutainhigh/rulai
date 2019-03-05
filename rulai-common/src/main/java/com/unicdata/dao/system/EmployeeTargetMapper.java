package com.unicdata.dao.system;

import com.unicdata.entity.system.EmployeeTarget;

import java.util.List;
import java.util.Map;

public interface EmployeeTargetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeTarget record);

    int insertSelective(EmployeeTarget record);

    EmployeeTarget selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeTarget record);

    int updateByPrimaryKey(EmployeeTarget record);

    EmployeeTarget selectEmployeeTarget(EmployeeTarget record);

    List<EmployeeTarget> selectEmployeeTargetByStoreId(Map<String, Object> map);

    Map<String, Object> getMothTargetNumByStoreId(Map<String, Object> map);

    List<Map<String, Object>> saleManTarget(Map param);

    EmployeeTarget employeeIdTarget(Map param);
}