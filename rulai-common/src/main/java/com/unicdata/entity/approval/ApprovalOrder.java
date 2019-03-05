package com.unicdata.entity.approval;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ApprovalOrder {

    private Integer id;
    @ApiModelProperty(value = "订单号")
    private Integer orderId;
    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;
    @ApiModelProperty(value = "客户id")
    private Integer cusId;
    @ApiModelProperty(value = "订单审批类型 1:订单审批 2:退订审批")
    private Integer approvalType;
    @ApiModelProperty(value = "审批状态 0:待审批 1:通过 2:不通过")
    private Integer approvalStatus;
    @ApiModelProperty(value = "退订原因，订单审批为空")
    private String unsubscribeReason;
    @ApiModelProperty(value = "创建时间")
    private Date applyTime;
    @ApiModelProperty(value = "状态: 0:删除 1:正常")
    private Integer dataStatus;
    @ApiModelProperty(value = "创建人id")
    private Integer employeeId;
    @ApiModelProperty(value = "销售经理是否审批 0否1是")
    private Integer ifSaleApproval;
    @ApiModelProperty(value = "销售经理id")
    private Integer saleApproveId;
    @ApiModelProperty(value = "销售经理审批时间")
    private Date saleApprovalTime;
    @ApiModelProperty(value = "精品经理是否审批 0否1是")
    private Integer ifBoutiqueApproval;
    @ApiModelProperty(value = "精品经理id")
    private Integer boutiqueApproveId;
    @ApiModelProperty(value = "精品经理审批时间")
    private Date boutiqueApprovalTime;
    @ApiModelProperty(value = "销售经理审批结果")
    private Integer saleApprovalResult;
    @ApiModelProperty(value = "精品经理审批结果")
    private Integer boutiqueApprovalResult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(Integer approvalType) {
        this.approvalType = approvalType;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getUnsubscribeReason() {
        return unsubscribeReason;
    }

    public void setUnsubscribeReason(String unsubscribeReason) {
        this.unsubscribeReason = unsubscribeReason;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Integer getIfSaleApproval() {
        return ifSaleApproval;
    }

    public void setIfSaleApproval(Integer ifSaleApproval) {
        this.ifSaleApproval = ifSaleApproval;
    }

    public Integer getSaleApproveId() {
        return saleApproveId;
    }

    public void setSaleApproveId(Integer saleApproveId) {
        this.saleApproveId = saleApproveId;
    }

    public Date getSaleApprovalTime() {
        return saleApprovalTime;
    }

    public void setSaleApprovalTime(Date saleApprovalTime) {
        this.saleApprovalTime = saleApprovalTime;
    }

    public Integer getSaleApprovalResult() {
        return saleApprovalResult;
    }

    public void setSaleApprovalResult(Integer saleApprovalResult) {
        this.saleApprovalResult = saleApprovalResult;
    }

    public Integer getIfBoutiqueApproval() {
        return ifBoutiqueApproval;
    }

    public void setIfBoutiqueApproval(Integer ifBoutiqueApproval) {
        this.ifBoutiqueApproval = ifBoutiqueApproval;
    }

    public Integer getBoutiqueApproveId() {
        return boutiqueApproveId;
    }

    public void setBoutiqueApproveId(Integer boutiqueApproveId) {
        this.boutiqueApproveId = boutiqueApproveId;
    }

    public Date getBoutiqueApprovalTime() {
        return boutiqueApprovalTime;
    }

    public void setBoutiqueApprovalTime(Date boutiqueApprovalTime) {
        this.boutiqueApprovalTime = boutiqueApprovalTime;
    }

    public Integer getBoutiqueApprovalResult() {
        return boutiqueApprovalResult;
    }

    public void setBoutiqueApprovalResult(Integer boutiqueApprovalResult) {
        this.boutiqueApprovalResult = boutiqueApprovalResult;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}