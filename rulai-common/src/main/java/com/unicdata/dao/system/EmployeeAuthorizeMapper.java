package com.unicdata.dao.system;

import com.unicdata.entity.system.EmployeeAuthorize;
import com.unicdata.entity.system.EmployeeAuthorizeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface EmployeeAuthorizeMapper {
    int countByExample(EmployeeAuthorizeExample example);

    int deleteByExample(EmployeeAuthorizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeAuthorize record);

    int insertSelective(EmployeeAuthorize record);

    List<EmployeeAuthorize> selectByExample(EmployeeAuthorizeExample example);

    List<EmployeeAuthorize> selectByEmployeeId(Map<String,Object> map);

    EmployeeAuthorize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeAuthorize record, @Param("example") EmployeeAuthorizeExample example);

    int updateByExample(@Param("record") EmployeeAuthorize record, @Param("example") EmployeeAuthorizeExample example);

    int updateByPrimaryKeySelective(EmployeeAuthorize record);

    int updateByPrimaryKey(EmployeeAuthorize record);
}