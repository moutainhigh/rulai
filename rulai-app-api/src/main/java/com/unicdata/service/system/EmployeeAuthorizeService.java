package com.unicdata.service.system;

import com.unicdata.entity.system.EmployeeAuthorize;
import com.unicdata.entity.system.EmployeeAuthorizeExample;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/27.
 */
public interface EmployeeAuthorizeService {
    int insert(EmployeeAuthorize record);

    int insertSelective(EmployeeAuthorize record);

    List<EmployeeAuthorize> selectByExample(EmployeeAuthorizeExample example);

    EmployeeAuthorize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeAuthorize record);

    /**
     * 通过授权人和被授权人id查询
     * @param map
     * @return
     */
    List<EmployeeAuthorize> selectByEmployeeId(Map<String,Object> map);
}
