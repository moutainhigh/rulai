package com.unicdata.service.employee;

import com.unicdata.entity.holleworld.HolleWorldExample;
import com.unicdata.entity.system.Employee;

import java.util.List;
import java.util.Map;

/**
 * 员工service
 *
 * @author admin
 */
public interface AppEmployeeService {
    //根据条件获取客流列表
    List<Object> selectListByExample(HolleWorldExample example);

    //获取前台销售列表
    List<Map<String, Object>> selectEmployeAndGroup(Map<String, Object> map);

    //根据岗位名称获取销售顾问
    List<Map<String, Object>> selectEmployeByPostName(Map<String, Object> map);

    //根据岗位名称获取销售顾问
    List<Map<String, Object>> selectEmployeIdByPostName(Map<String, Object> map);

    //根据名字获取销售顾问
    List<Map<String, Object>> selectEmployeByName(Map<String, Object> map);

    int updateByPrimaryKeySelective(Employee record);

    Employee findEmployeeRole(Integer employeeId);

    //根据roleid和门店id获取工作人员
    List<Employee> selectCustomersByRoleId(Map<String, Object> map);

    //获取员工姓名 wp
    Employee selectEmployeeById(Integer cusId);

    //通过ID查员工姓名
    Employee selectEmployee(Integer id);

    //变更员工状态 wp
    int updateEmpStatus(Map<String, Object> map);

    int updateEmpStatusByPostName(String postName);
}
