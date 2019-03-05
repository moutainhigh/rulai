package com.unicdata.service.system;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.system.Employee;
import com.unicdata.entity.system.EmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by shenyong on 2018/6/1.
 */
public interface EmployeeService {

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    /**
     * 按岗位id修改对应员工的岗位名称
     * @param postId
     * @param postName
     * @return
     */
    int updateByPostId(Integer postId,String postName);

    int delRoleByUser(Integer roleId);

    int distributionRole(@Param("employeeId") Integer employeeId , @Param("roleId") Integer roleId);

    ApiReturnInfo distributionRole(Integer employeeId, String roles);

    Employee findEmployeeRole(Integer employeeId);

    List<Employee> selectByEmployeeIds(Employee record);

    Employee selectByLoginName(String loginNanme);

    PageInfo employeeList(Integer pageNum, Integer pageSize, Employee employee);

    Employee employeeById(Integer employeeId);

    ApiReturnInfo save(Employee record);

    ApiReturnInfo userRoles(Integer employeeId);

    ApiReturnInfo<Employee> userPermission(Integer employeeId);

	List<Employee> selectAllUserByPerName(Integer storeId, String perName);


    List<Employee> findEmployeeByName(String name);

    List<Employee> selectByParam(Map map);
}
