package com.unicdata.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.EncryptionUtil;
import com.unicdata.base.util.StringUtil;
import com.unicdata.dao.system.EmployeeMapper;
import com.unicdata.dao.system.EmployeeStatusMapper;
import com.unicdata.entity.counter.Counter;
import com.unicdata.entity.system.*;
import com.unicdata.service.CounterService;
import com.unicdata.service.system.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private RoleService roleService;
	@Autowired
	private EmployeeGroupService employeeGroupService;
	@Autowired
	private EmployeePostService employeePostService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private DistributorStoreInfoService distributorStoreInfoService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private EmployeeStatusService employeeStatusService;

	/**
	 * 校验用户（通过用户名查找）
	 * @param loginNanme
	 * @return
	 */
	public Employee selectByLoginName(String loginNanme){
		return employeeMapper.selectByLoginName(loginNanme);
	}

	public int deleteByPrimaryKey(Integer id) {
		return employeeMapper.deleteByPrimaryKey(id);
	}

	public int insert(Employee record) {
		return employeeMapper.insert(record);
	}

	public int insertSelective(Employee record) {
		return employeeMapper.insertSelective(record);
	}

	public Employee selectByPrimaryKey(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Employee record) {
		return employeeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Employee record) {
		return employeeMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPostId(Integer postId, String postName) {
		return employeeMapper.updateByPostId(postId,postName);
	}

	public PageInfo employeeList(Integer pageNum, Integer pageSize, Employee employee) {
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		EmployeeExample pe = new EmployeeExample();
		EmployeeExample.Criteria criteria = pe.createCriteria();
		criteria.andDataStatusEqualTo(1);
		if(employee.getSubjectionType() == 2 && employee.getStoreId() != null && employee.getStoreId() > 0){
			criteria.andStoreIdEqualTo(employee.getStoreId());
		}
		if(StringUtil.isNotBlank(employee.getFullName())){
			criteria.andFullNameLike(employee.getFullName());
		}
		if(StringUtil.isNotBlank(employee.getPhoneNum())){
			criteria.andPhoneNumLike(employee.getPhoneNum());
		}
		List<Employee> employeees = employeeMapper.selectByExample(pe);
		for(Employee e:employeees){
			if(e.getDepartmentId() != null  && e.getDepartmentId() > 0) {
				EmployeeGroup employeeGroup = employeeGroupService.selectByPrimaryKey(e.getDepartmentId());
				e.setEmployeeGroup(employeeGroup);
			}
			ApiReturnInfo apiReturnInfo = this.userRoles(e.getId());
			if(apiReturnInfo.getCode() == 200 && apiReturnInfo.getData() != null) {
				Employee em = (Employee) apiReturnInfo.getData();
				if(null != em.getRoles() && em.getRoles().size() > 0) {
					e.setRoles(em.getRoles());
				}
			}
			e.setPwd(null);
		}
		//封装分页信息
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(employeees);
		return pageInfo;
	}

	/**
	 * 查询用户信息
	 * @param employeeId
     * @return
     */
	public Employee employeeById(Integer employeeId) {
		EmployeeExample pe = new EmployeeExample();
		EmployeeExample.Criteria criteria = pe.createCriteria();
		criteria.andDataStatusEqualTo(1);
		criteria.andIdEqualTo(employeeId);
		List<Employee> employeees = employeeMapper.selectByExample(pe);
		for(Employee e:employeees){
			if(e.getGroupId() != null  && e.getGroupId() > 0) {
				EmployeeGroup employeeGroup = employeeGroupService.selectByPrimaryKey(e.getDepartmentId());
				e.setEmployeeGroup(employeeGroup);
			}
			ApiReturnInfo apiReturnInfo = this.userRoles(e.getId());
			if(apiReturnInfo.getCode() == 200 && apiReturnInfo.getData() != null) {
				Employee em = (Employee) apiReturnInfo.getData();
				if(null != em.getRoles() && em.getRoles().size() > 0) {
					e.setRoles(em.getRoles());
				}
			}
			e.setPwd(null);
		}
		return employeees != null && employeees.size() > 0 ? employeees.get(0):null;
	}

	/**
	 * 保存/修改
	 * @param record
	 * @return
	 */
	public ApiReturnInfo save(Employee record) {
		ApiReturnInfo ar = new ApiReturnInfo();
		int num = 0;
		try {
			if(record.getPwd() != null) {
				record.setPwd(EncryptionUtil.base64Encrypt(record.getPwd()));
			}
			if(record.getGroupId() == null && record.getStoreId()!= null ){
				DistributorStoreInfo distributorStoreInfo = distributorStoreInfoService.getById(record.getStoreId());
				if(distributorStoreInfo != null){
					record.setGroupId(distributorStoreInfo.getDistributorId());
				}
			}
			EmployeeGroup employeeGroup = employeeGroupService.selectByPrimaryKey(record.getDepartmentId());
			if(employeeGroup != null) {
				record.setDepartmentDesc(employeeGroup.getGroupName());
			}
			EmployeePost employeePost = employeePostService.selectByPrimaryKey(record.getPostId());
			if(employeePost != null){
				record.setPostName(employeePost.getPostName());
			}
			record.setUpdateDate(new Date());
			if (record.getId() != null &&  record.getId() > 0) {
				num = this.updateByPrimaryKeySelective(record);
			} else {
				Employee loginName = employeeMapper.selectByLoginName(record.getLoginName());
				if(loginName != null){
					ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
					ar.setMessage("用户名已存在！");
					return ar;
				}
				String code = counterService.generateCode(Counter.SYSTEM_EMPLOYEE_CODE,"yyyyMM",4);
				record.setCodeNum(code);
				record.setCreateDate(new Date());
				num = this.insertSelective(record);
				//新建员工时初始化员工状态
				EmployeeStatus es = new EmployeeStatus();
				es.setEmployeeId(record.getId());
				es.setType(0);
				es.setContactTime(new Date());
				employeeStatusService.insertSelective(es);
			}
		}catch(Exception ex){ex.printStackTrace();}
		ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
		ar.setMessage("操作成功！");
		ar.setData(record.getId());
		if(num == 0){
			ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ar.setMessage("操作失败！");
		}
		return ar;
	}


	public ApiReturnInfo distributionRole(Integer employeeId, String roles) {
		ApiReturnInfo ar = new ApiReturnInfo();
		if(employeeId == null || employeeId <= 0|| "".equals(roles)){
			ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
			return ar;
		}
		//删除角色对应的权限
		employeeMapper.userDeleteRole(employeeId);
		//把新选中的权限新增到角色权限表中
		for (String role : roles.split(",")) {
			try {
				employeeMapper.distributionRole(employeeId, Integer.parseInt(role));
			}catch (Exception ex){ ex.printStackTrace(); }
		}
		ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
		ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
		return ar;
	}

	/**
	 * 查询用户拥有的角色
	 * @param employeeId
     * @return
     */
	public ApiReturnInfo userRoles(Integer employeeId) {
		ApiReturnInfo ar = new ApiReturnInfo();
		try {
			ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
			ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
			if (employeeId == null || employeeId <= 0) {
				ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
				ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
				return ar;
			}
			Employee employeeRole = employeeMapper.findEmployeeRole(employeeId);
			if (employeeRole != null && StringUtil.isNotEmpty(employeeRole.getRoleIds())) {
				employeeRole.setPwd(null);
				List list = new ArrayList();
				for (String x : employeeRole.getRoleIds().split(",")) {
					list.add(Integer.parseInt(x));
				}
				RoleExample re = new RoleExample();
				re.createCriteria().andIdIn(list).andStatusEqualTo(0);
				List<Role> roles = roleService.selectByExample(re);
				employeeRole.setRoles(roles);
			}
			ar.setData(employeeRole);
		}catch (Exception ex){
			ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ar.setMessage("查询失败！"+ex.getMessage());
			ar.setData(null);
		}
		return ar;
	}

	/**
	 *  查询用户拥有的权限
	 * @param employeeId
     * @return
     */
	public ApiReturnInfo<Employee> userPermission(Integer employeeId) {
		ApiReturnInfo apiReturnInfo = new ApiReturnInfo();
		Employee employee = employeeMapper.findEmployeeRole(employeeId);
		List<Permissions> permissionses = permissionService.selectPermissionsByUserId(employeeId);
		employee.setPermissionses(permissionses);
		apiReturnInfo.setData(employee);
		return apiReturnInfo;
	}

	@Override
	public List<Employee> findEmployeeByName(String name) {
		EmployeeExample ex = new EmployeeExample();
		ex.createCriteria().andFullNameLike(name);
		List<Employee> employees = employeeMapper.selectByExample(ex);
		return employees;
	}

	@Override
	public List<Employee> selectByParam(Map map) {
		return employeeMapper.selectByParam(map);
	}

	/**
	 * 删除用户角色关系表 by roleId
	 * @param roleId
     * @return
     */
	public int delRoleByUser(Integer roleId){
		return employeeMapper.delRoleByUser(roleId);
	}

	@Override
	public int distributionRole(@Param("employeeId") Integer employeeId, @Param("roleId") Integer roleId) {
		return employeeMapper.distributionRole(employeeId, roleId);
	}

	@Override
	public Employee findEmployeeRole(Integer employeeId) {
		return employeeMapper.findEmployeeRole(employeeId);
	}

	@Override
	public List<Employee> selectByEmployeeIds(Employee record) {
		return employeeMapper.selectByEmployeeIds(record);
	}


	public List<Employee> selectByEmpl(Employee employee) {
		EmployeeExample pe = new EmployeeExample();
		EmployeeExample.Criteria criteria = pe.createCriteria();
		criteria.andDataStatusEqualTo(1);
		criteria.andDepartmentIdEqualTo(employee.getDepartmentId()).andSubjectionTypeEqualTo(employee.getSubjectionType());
		List<Employee> employeees = employeeMapper.selectByExample(pe);
		for(Employee e : employeees){
			EmployeeGroup employeeGroup = employeeGroupService.selectByPrimaryKey(e.getDepartmentId());
			if(null != employeeGroup){
				e.setEmployeeGroup(employeeGroup);
			}
		}
		return employeees;
	}

	public List<Employee> selectByExample(EmployeeExample pe) {
		return employeeMapper.selectByExample(pe);
	}

	@Override
	public List<Employee> selectAllUserByPerName(Integer storeId, String perName) {
		return employeeMapper.selectAllUserByPerName(storeId,perName);
	}
}


