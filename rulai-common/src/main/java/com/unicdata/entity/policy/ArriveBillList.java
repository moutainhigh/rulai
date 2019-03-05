package com.unicdata.entity.policy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicdata.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "到账单实体")
public class ArriveBillList extends BaseEntity{
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "返利项目id")
    private Integer rebateProjectId;
    @ApiModelProperty(value = "总差额")
    private BigDecimal totalDifference;
    @ApiModelProperty(value = "总金额")
    private BigDecimal totalMoney;
    @ApiModelProperty(value = "未匹配台数")
    private Integer unmatchedNum;
    @ApiModelProperty(value = "未匹配金额")
    private BigDecimal unmatchedMoney;
    @ApiModelProperty(value = "操作人")
    private Integer employeeId;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @ApiModelProperty(value = "操作人名称")
    private String employeeName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRebateProjectId() {
        return rebateProjectId;
    }

    public void setRebateProjectId(Integer rebateProjectId) {
        this.rebateProjectId = rebateProjectId;
    }

    public BigDecimal getTotalDifference() {
        return totalDifference;
    }

    public void setTotalDifference(BigDecimal totalDifference) {
        this.totalDifference = totalDifference;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getUnmatchedNum() {
        return unmatchedNum;
    }

    public void setUnmatchedNum(Integer unmatchedNum) {
        this.unmatchedNum = unmatchedNum;
    }

    public BigDecimal getUnmatchedMoney() {
        return unmatchedMoney;
    }

    public void setUnmatchedMoney(BigDecimal unmatchedMoney) {
        this.unmatchedMoney = unmatchedMoney;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}