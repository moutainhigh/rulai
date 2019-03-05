package com.unicdata.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

@ApiModel(value = "用户实体类")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "用户编号")
    private Integer id;
    /**
     * 职工编号
     */
    @ApiModelProperty(value = "职工编号")
    private String codeNum;
    @ApiModelProperty(value = "用户名")
    private String loginName;

    private String pwd;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String fullName;
    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phoneNum;
    @ApiModelProperty(value = "性别 0未知 ，1男，2女")
    private Integer sex;
    @ApiModelProperty(value="邮箱")
    private String custMail;
    /**
     * 组织id
     */
    @ApiModelProperty(value = "组织id")
    private Integer groupId;
    /**
     * 门店id
     */
    @ApiModelProperty(value = "门店id")
    private Integer storeId;

    /**
     * 部门id或者叫岗位id更合适
     */
    @ApiModelProperty(value = "部门id")
    private Integer departmentId;
    @ApiModelProperty(value = "部门名称/职位名称")
    private String departmentDesc;

    @ApiModelProperty(value = "岗位id")
    private Integer postId;
    @ApiModelProperty(value = "岗位名称")
    private String postName;

    /**
     * 1启用 0 禁用
     */
    @ApiModelProperty(value = " 1启用 0 禁用")
    private Integer userStatus;
    /**
     * 数据状态 1在用 0删除
     */
    @ApiModelProperty(value = "数据状态 1在用 0删除")
    private Integer dataStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    /**
     * 旧密码 修改密码时使用
     */
    private String oldpwd;

    /**
     * 所拥有的角色
     */
    private String roleIds;
    @ApiModelProperty(value = "角色集合")
    private List<Role> roles;
    @ApiModelProperty(value = "权限集合")
    private List<Permissions> permissionses;
    /**
     * 部门
     */
    private EmployeeGroup employeeGroup;
    
    /**
     * 隶属 1集团 2门店
     */
    @ApiModelProperty(value = "隶属 1集团 2门店")
    private Integer subjectionType;
    
    /**
     * 员工状态
     */
    private EmployeeStatus employeeStatus;
    /**
     * 员工操作时间（客流离店） 用于销售顾问排序
     */
    @ApiModelProperty(value = "操作时间")
    private Date operationTime;
    
	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public Integer getId() {
        return id;
    }

    public EmployeeGroup getEmployeeGroup() {
		return employeeGroup;
	}

	public void setEmployeeGroup(EmployeeGroup employeeGroup) {
		this.employeeGroup = employeeGroup;
	}

	public EmployeeStatus getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(String codeNum) {
        this.codeNum = codeNum;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCustMail() {
        return custMail;
    }

    public void setCustMail(String custMail) {
        this.custMail = custMail;
    }


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getSubjectionType() {
        return subjectionType;
    }

    public void setSubjectionType(Integer subjectionType) {
        this.subjectionType = subjectionType;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public List<Permissions> getPermissionses() {
        return permissionses;
    }

    public void setPermissionses(List<Permissions> permissionses) {
        this.permissionses = permissionses;
    }

    public String getOldpwd() {
        return oldpwd;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }


    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}