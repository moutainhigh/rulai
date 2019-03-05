package com.unicdata.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "部门表实体类")
public class EmployeeGroup implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2362954687425873581L;
	@ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "部门名称")
    private String groupName;
    @ApiModelProperty(value = "上级id")
    private Integer parentId;
    @ApiModelProperty(value = "排序")
    private Integer sortno;
    @ApiModelProperty(value = "类型 1集团 2门店")
    private Integer groupType;
    @ApiModelProperty(value = "数据状态 1在用 0删除")
    private Integer dataStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    @ApiModelProperty(value = "该部门下的岗位集合")
    private List<EmployeePost> employeePosts ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
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

    public List<EmployeePost> getEmployeePosts() {
        return employeePosts;
    }

    public void setEmployeePosts(List<EmployeePost> employeePosts) {
        this.employeePosts = employeePosts;
    }
}