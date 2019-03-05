package com.unicdata.dao.system;

import com.unicdata.entity.system.Employee;
import com.unicdata.entity.system.EmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    int userDeleteRole(Integer employeeId);

    int delRoleByUser(Integer roleId);

    int distributionRole(@Param("employeeId") Integer employeeId , @Param("roleId") Integer roleId);

    Employee findEmployeeRole(Integer employeeId);

    List<Employee> selectByEmployeeIds(Employee record);

    Employee selectByLoginName(String loginNanme);
    //获取前台销售人员 wp
    List<Map<String, Object>> selectEmployeAndGroup(Map<String, Object> map);

    //根据岗位名称获取销售顾问 wp
    List<Map<String, Object>> selectEmployeByPostName(Map<String, Object> map);

    //根据角色获取工作人员信息
    List<Employee> selectCustomersByRoleId(Map<String,Object> map);

	List<Employee> selectAllUserByPerName(@Param("storeId")Integer storeId, @Param("perName")String perName);
	//获取盘点人员列表 wp
	List<Employee> selectPanDianEmps(Map<String, Object> map);
	//变更员工状态 wp
	int updateEmpStatus(Map<String, Object> map);

    int updateByPostId(@Param("postId") Integer postId, @Param("postName") String postName);
    //我的信息 wp
    Map<String, Object> myInfo(Map<String, Object> map);
    
    int updateEmpStatusByPostName(String postName);

    List<Employee> selectByParam(Map map);
}