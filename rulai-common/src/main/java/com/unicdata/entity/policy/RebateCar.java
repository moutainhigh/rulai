package com.unicdata.entity.policy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicdata.entity.BaseEntity;
import com.unicdata.entity.car.CarGoodInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "返利车辆关联表")
public class RebateCar extends BaseEntity{

    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "商务政策id")
    private Integer policyId;
    @ApiModelProperty(value = "返利项目表id")
    private Integer rebateProjectId;
    @ApiModelProperty(value = "门店id")
    private Integer storeId;
    @ApiModelProperty(value = "车辆id")
    private Integer carId;
    @ApiModelProperty(value = "vin")
    private String vin;
    @ApiModelProperty(value = "首次预估返利")
    private BigDecimal firstEstimateRebate;
    @ApiModelProperty(value = "预估调整")
    private BigDecimal estimateAdjust;
    @ApiModelProperty(value = "计提金额")
    private BigDecimal planExtraction;
    @ApiModelProperty(value = "计提调整")
    private BigDecimal planExtractionAdjust;
    @ApiModelProperty(value = "财务是否确定计提 0待确认，1已确认")
    private Integer isPlanExtraction;
    @ApiModelProperty(value = "计提时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date planExtractionDate;
    @ApiModelProperty(value = "核对单id")
    private Integer proofreaderId;
    @ApiModelProperty(value = "核对金额")
    private BigDecimal proofreaderMoney;
    @ApiModelProperty(value = "核对时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date proofreaderDate;
    @ApiModelProperty(value = "到账单id")
    private Integer arriveBillId;
    @ApiModelProperty(value = "到账金额")
    private BigDecimal arriveBillMoney;
    @ApiModelProperty(value = "到账时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date arriveBillDate;
    @ApiModelProperty(value = "操作人")
    private Integer employeeId;
    @ApiModelProperty(value = "数据创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @ApiModelProperty(value = "数据修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    private CarGoodInfo carGoodInfo;
    @ApiModelProperty(value = "差异")
    private BigDecimal diffMoney;
    @ApiModelProperty(value = "返利项目")
    private RebateProject rebateProject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public Integer getRebateProjectId() {
        return rebateProjectId;
    }

    public void setRebateProjectId(Integer rebateProjectId) {
        this.rebateProjectId = rebateProjectId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public BigDecimal getFirstEstimateRebate() {
        return firstEstimateRebate;
    }

    public void setFirstEstimateRebate(BigDecimal firstEstimateRebate) {
        this.firstEstimateRebate = firstEstimateRebate;
    }

    public BigDecimal getEstimateAdjust() {
        return estimateAdjust;
    }

    public void setEstimateAdjust(BigDecimal estimateAdjust) {
        this.estimateAdjust = estimateAdjust;
    }

    public BigDecimal getPlanExtraction() {
        return planExtraction;
    }

    public void setPlanExtraction(BigDecimal planExtraction) {
        this.planExtraction = planExtraction;
    }

    public BigDecimal getPlanExtractionAdjust() {
        return planExtractionAdjust;
    }

    public void setPlanExtractionAdjust(BigDecimal planExtractionAdjust) {
        this.planExtractionAdjust = planExtractionAdjust;
    }

    public Integer getIsPlanExtraction() {
        return isPlanExtraction;
    }

    public void setIsPlanExtraction(Integer isPlanExtraction) {
        this.isPlanExtraction = isPlanExtraction;
    }

    public Date getPlanExtractionDate() {
        return planExtractionDate;
    }

    public void setPlanExtractionDate(Date planExtractionDate) {
        this.planExtractionDate = planExtractionDate;
    }

    public Integer getProofreaderId() {
        return proofreaderId;
    }

    public void setProofreaderId(Integer proofreaderId) {
        this.proofreaderId = proofreaderId;
    }

    public BigDecimal getProofreaderMoney() {
        return proofreaderMoney;
    }

    public void setProofreaderMoney(BigDecimal proofreaderMoney) {
        this.proofreaderMoney = proofreaderMoney;
    }

    public Date getProofreaderDate() {
        return proofreaderDate;
    }

    public void setProofreaderDate(Date proofreaderDate) {
        this.proofreaderDate = proofreaderDate;
    }

    public Integer getArriveBillId() {
        return arriveBillId;
    }

    public void setArriveBillId(Integer arriveBillId) {
        this.arriveBillId = arriveBillId;
    }

    public BigDecimal getArriveBillMoney() {
        return arriveBillMoney;
    }

    public void setArriveBillMoney(BigDecimal arriveBillMoney) {
        this.arriveBillMoney = arriveBillMoney;
    }

    public Date getArriveBillDate() {
        return arriveBillDate;
    }

    public void setArriveBillDate(Date arriveBillDate) {
        this.arriveBillDate = arriveBillDate;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public CarGoodInfo getCarGoodInfo() {
        return carGoodInfo;
    }

    public void setCarGoodInfo(CarGoodInfo carGoodInfo) {
        this.carGoodInfo = carGoodInfo;
    }

    public BigDecimal getDiffMoney() {
        return diffMoney;
    }

    public void setDiffMoney(BigDecimal diffMoney) {
        this.diffMoney = diffMoney;
    }

    public RebateProject getRebateProject() {
        return rebateProject;
    }

    public void setRebateProject(RebateProject rebateProject) {
        this.rebateProject = rebateProject;
    }
}