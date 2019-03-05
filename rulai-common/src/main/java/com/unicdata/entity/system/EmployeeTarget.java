package com.unicdata.entity.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("员工目标")
public class EmployeeTarget {
    private Integer id;
    @ApiModelProperty("员工id")
    private Integer employeeId;
    @ApiModelProperty("订单目标")
    private Integer targetOrder;
    @ApiModelProperty("交车目标")
    private Integer targetDeliver;
    @ApiModelProperty("客流目标")
    private Integer targetCus;
    @ApiModelProperty("建档目标")
    private Integer targetRecord;
    @ApiModelProperty("目标周期")
    private String targetTime;
    @ApiModelProperty("试驾目标")
    private Integer targetDrive;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("数据状态")
    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getTargetOrder() {
        return targetOrder;
    }

    public void setTargetOrder(Integer targetOrder) {
        this.targetOrder = targetOrder;
    }

    public Integer getTargetDeliver() {
        return targetDeliver;
    }

    public void setTargetDeliver(Integer targetDeliver) {
        this.targetDeliver = targetDeliver;
    }

    public Integer getTargetCus() {
        return targetCus;
    }

    public void setTargetCus(Integer targetCus) {
        this.targetCus = targetCus;
    }

    public Integer getTargetRecord() {
        return targetRecord;
    }

    public void setTargetRecord(Integer targetRecord) {
        this.targetRecord = targetRecord;
    }

    public String getTargetTime() {
        return targetTime;
    }

    public void setTargetTime(String targetTime) {
        this.targetTime = targetTime;
    }

    public Integer getTargetDrive() {
        return targetDrive;
    }

    public void setTargetDrive(Integer targetDrive) {
        this.targetDrive = targetDrive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}