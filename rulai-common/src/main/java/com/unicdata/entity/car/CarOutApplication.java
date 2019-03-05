package com.unicdata.entity.car;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CarOutApplication {
    private Integer id;
    @ApiModelProperty(value = "门店id")
    private Integer distributorStoreId;
    @ApiModelProperty(value = "申请单号")
    private String code;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "申请数量")
    private Integer applicateNum;
    @ApiModelProperty(value = "申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applicateDate;
    @ApiModelProperty(value = "计划外出时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date planOutDate;
    @ApiModelProperty(value = "计划返回时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date planReturnDate;
    @ApiModelProperty(value = "目的地")
    private String destination;
    @ApiModelProperty(value = "类型")
    private Integer type;
    @ApiModelProperty(value = "申请状态 1 外出中 2 已入库")
    private Integer applicateStatus;
    @ApiModelProperty(value = "申请人id")
    private Integer operatorId;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    @ApiModelProperty(value = "数据状态 1 正常 2 删除")
    private Integer status;
    @ApiModelProperty(value = "审批状态")
    private Byte approvalStatus;
    @ApiModelProperty(value = "审批人id")
    private Integer employeeId;
    @ApiModelProperty(value = "审批时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date approvalTime;
    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "标识符,1可操作2不可操作")
    private Integer flg;

    public Integer getFlg() {
        return flg;
    }

    public void setFlg(Integer flg) {
        this.flg = flg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistributorStoreId() {
        return distributorStoreId;
    }

    public void setDistributorStoreId(Integer distributorStoreId) {
        this.distributorStoreId = distributorStoreId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getApplicateNum() {
        return applicateNum;
    }

    public void setApplicateNum(Integer applicateNum) {
        this.applicateNum = applicateNum;
    }

    public Date getApplicateDate() {
        return applicateDate;
    }

    public void setApplicateDate(Date applicateDate) {
        this.applicateDate = applicateDate;
    }

    public Date getPlanOutDate() {
        return planOutDate;
    }

    public void setPlanOutDate(Date planOutDate) {
        this.planOutDate = planOutDate;
    }

    public Date getPlanReturnDate() {
        return planReturnDate;
    }

    public void setPlanReturnDate(Date planReturnDate) {
        this.planReturnDate = planReturnDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getApplicateStatus() {
        return applicateStatus;
    }

    public void setApplicateStatus(Integer applicateStatus) {
        this.applicateStatus = applicateStatus;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Byte approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}