package com.unicdata.entity.policy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicdata.entity.BaseEntity;
import com.unicdata.entity.car.CarGoodInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(value = "返利项目实体")
public class RebateProject extends BaseEntity {

    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "返利项目code")
    private String rebateCode;
    @ApiModelProperty(value = "政策id")
    private Integer policyId;
    @ApiModelProperty(value = "返利项目名称")
    private String rebateName;
    @ApiModelProperty(value = "返利项目类型 1批售返利 ，2零售返利")
    private Integer rebateProjectType;
    @ApiModelProperty(value = "上报材料要求 1 DMS日期/开票日期，2入库日期",hidden = true)
    private Integer reportMaterialRequirements;
    @ApiModelProperty(value = "返利开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date rebateStartDate;
    @ApiModelProperty(value = "返利结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date rebateEndDate;
    @ApiModelProperty(value = "返利开始时间str")
    private String rebateStartDateStr;
    @ApiModelProperty(value = "返利结束时间str")
    private String rebateEndDateStr;
    @ApiModelProperty(value = "返利类型 1百分比 ，2 金额")
    private Integer rebateType;
    @ApiModelProperty(value = "返利类型数值")
    private BigDecimal rebateTypeValue;
    @ApiModelProperty(value = "返利台数上限，小于等于0 表示无上限")
    private Integer rebateNumber;
    @ApiModelProperty(value = "返利达标台数要求")
    private Integer rebateStandardNumber;
    @ApiModelProperty(value = "品牌id")
    private Integer brandId;
    @ApiModelProperty(value = "车系id")
    private Integer familyId;
    @ApiModelProperty(value = "车型id")
    private Integer vehicleId;
    @ApiModelProperty(value = "年款")
    private String year;
    @ApiModelProperty(value = "车身颜色id")
    private Integer decorationsOutId;
    @ApiModelProperty(value = "车身颜色名称")
    private String decorationsOutName;
    @ApiModelProperty(value = "返利库存选取方式 1系统自动匹配 ，2手动选择")
    private Integer rebateStockSelectType;
    @ApiModelProperty(value = "首次预估返利总计（计算改返利项目下所有车的首次预估返利）")
    private BigDecimal firstEstimateTotal;
    @ApiModelProperty(value = "预估调整总计")
    private BigDecimal estimateAdjustTotal;
    @ApiModelProperty(value = "计提金额总计")
    private BigDecimal planExtractionTotal;
    @ApiModelProperty(value = "计提调整总计")
    private BigDecimal planExtractionAdjustTotal;
    @ApiModelProperty(value = "门店id")
    private Integer storeId;
    @ApiModelProperty(value = "状态  0暂存，1生效,2过期")
    private Integer status;
    @ApiModelProperty(value = "操作人")
    private Integer employeeId;
    @ApiModelProperty(value = "数据创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @ApiModelProperty(value = "数据修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    @ApiModelProperty(value = "操作人名称")
    private String employeeName;

    @ApiModelProperty(value = "该返利项目选择的车辆id")
    private String carIds;
    @ApiModelProperty(value = "调整类型 1 默认类型，2具体库存")
    private Integer adjustType;
    @ApiModelProperty(value = "修改返利项目，具体库存类型时传递")
    private String carMap;

    private List<ProofreaderList> proofreaderLists;
    private List<ArriveBillList> arriveBillLists;
    @ApiModelProperty(value = "核对总额")
    private BigDecimal proofreaderMoney;
    @ApiModelProperty(value = "到账总额")
    private BigDecimal arriveBillMoney;
    @ApiModelProperty(value = "返利项目包含的车辆集合")
    private List<RebateCar> rebateCars;
    @ApiModelProperty(value = "返利项目条件下所有车辆集合")
    private List<CarGoodInfo> carGoodInfos;
    @ApiModelProperty(value = "涉及台数")
    private BigDecimal involvedTotal;
    @ApiModelProperty(value = "达成台数")
    private BigDecimal reachTotal;
    @ApiModelProperty(value = "虚报台数")
    private BigDecimal virtualRecordTotal;
    @ApiModelProperty(value = "返利对象描述")
    private String rebateProjectDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRebateCode() {
        return rebateCode;
    }

    public void setRebateCode(String rebateCode) {
        this.rebateCode = rebateCode;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getRebateName() {
        return rebateName;
    }

    public void setRebateName(String rebateName) {
        this.rebateName = rebateName;
    }

    public Integer getRebateProjectType() {
        return rebateProjectType;
    }

    public void setRebateProjectType(Integer rebateProjectType) {
        this.rebateProjectType = rebateProjectType;
    }

    public Integer getReportMaterialRequirements() {
        return reportMaterialRequirements;
    }

    public void setReportMaterialRequirements(Integer reportMaterialRequirements) {
        this.reportMaterialRequirements = reportMaterialRequirements;
    }

    public Date getRebateStartDate() {
        return rebateStartDate;
    }

    public void setRebateStartDate(Date rebateStartDate) {
        this.rebateStartDate = rebateStartDate;
    }

    public Date getRebateEndDate() {
        return rebateEndDate;
    }

    public void setRebateEndDate(Date rebateEndDate) {
        this.rebateEndDate = rebateEndDate;
    }

    public Integer getRebateType() {
        return rebateType;
    }

    public void setRebateType(Integer rebateType) {
        this.rebateType = rebateType;
    }

    public BigDecimal getRebateTypeValue() {
        return rebateTypeValue;
    }

    public void setRebateTypeValue(BigDecimal rebateTypeValue) {
        this.rebateTypeValue = rebateTypeValue;
    }

    public Integer getRebateNumber() {
        return rebateNumber;
    }

    public void setRebateNumber(Integer rebateNumber) {
        this.rebateNumber = rebateNumber;
    }

    public Integer getRebateStandardNumber() {
        return rebateStandardNumber;
    }

    public void setRebateStandardNumber(Integer rebateStandardNumber) {
        this.rebateStandardNumber = rebateStandardNumber;
    }

    public Integer getRebateStockSelectType() {
        return rebateStockSelectType;
    }

    public void setRebateStockSelectType(Integer rebateStockSelectType) {
        this.rebateStockSelectType = rebateStockSelectType;
    }

    public BigDecimal getFirstEstimateTotal() {
        return firstEstimateTotal;
    }

    public void setFirstEstimateTotal(BigDecimal firstEstimateTotal) {
        this.firstEstimateTotal = firstEstimateTotal;
    }

    public BigDecimal getEstimateAdjustTotal() {
        return estimateAdjustTotal;
    }

    public void setEstimateAdjustTotal(BigDecimal estimateAdjustTotal) {
        this.estimateAdjustTotal = estimateAdjustTotal;
    }

    public BigDecimal getPlanExtractionTotal() {
        return planExtractionTotal;
    }

    public void setPlanExtractionTotal(BigDecimal planExtractionTotal) {
        this.planExtractionTotal = planExtractionTotal;
    }

    public BigDecimal getPlanExtractionAdjustTotal() {
        return planExtractionAdjustTotal;
    }

    public void setPlanExtractionAdjustTotal(BigDecimal planExtractionAdjustTotal) {
        this.planExtractionAdjustTotal = planExtractionAdjustTotal;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getCarIds() {
        return carIds;
    }

    public void setCarIds(String carIds) {
        this.carIds = carIds;
    }

    public String getRebateEndDateStr() {
        return rebateEndDateStr;
    }

    public void setRebateEndDateStr(String rebateEndDateStr) {
        this.rebateEndDateStr = rebateEndDateStr;
    }

    public String getRebateStartDateStr() {
        return rebateStartDateStr;
    }

    public void setRebateStartDateStr(String rebateStartDateStr) {
        this.rebateStartDateStr = rebateStartDateStr;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getDecorationsOutId() {
        return decorationsOutId;
    }

    public void setDecorationsOutId(Integer decorationsOutId) {
        this.decorationsOutId = decorationsOutId;
    }

    public String getDecorationsOutName() {
        return decorationsOutName;
    }

    public void setDecorationsOutName(String decorationsOutName) {
        this.decorationsOutName = decorationsOutName;
    }

    public Integer getAdjustType() {
        return adjustType;
    }

    public void setAdjustType(Integer adjustType) {
        this.adjustType = adjustType;
    }

    public String getCarMap() {
        return carMap;
    }

    public void setCarMap(String carMap) {
        this.carMap = carMap;
    }

    public List<ProofreaderList> getProofreaderLists() {
        return proofreaderLists;
    }

    public void setProofreaderLists(List<ProofreaderList> proofreaderLists) {
        this.proofreaderLists = proofreaderLists;
    }

    public List<ArriveBillList> getArriveBillLists() {
        return arriveBillLists;
    }

    public void setArriveBillLists(List<ArriveBillList> arriveBillLists) {
        this.arriveBillLists = arriveBillLists;
    }

    public BigDecimal getProofreaderMoney() {
        return proofreaderMoney;
    }

    public void setProofreaderMoney(BigDecimal proofreaderMoney) {
        this.proofreaderMoney = proofreaderMoney;
    }

    public BigDecimal getArriveBillMoney() {
        return arriveBillMoney;
    }

    public void setArriveBillMoney(BigDecimal arriveBillMoney) {
        this.arriveBillMoney = arriveBillMoney;
    }

    public List<RebateCar> getRebateCars() {
        return rebateCars;
    }

    public void setRebateCars(List<RebateCar> rebateCars) {
        this.rebateCars = rebateCars;
    }

    public List<CarGoodInfo> getCarGoodInfos() {
        return carGoodInfos;
    }

    public void setCarGoodInfos(List<CarGoodInfo> carGoodInfos) {
        this.carGoodInfos = carGoodInfos;
    }

    public BigDecimal getInvolvedTotal() {
        return involvedTotal;
    }

    public void setInvolvedTotal(BigDecimal involvedTotal) {
        this.involvedTotal = involvedTotal;
    }

    public BigDecimal getReachTotal() {
        return reachTotal;
    }

    public void setReachTotal(BigDecimal reachTotal) {
        this.reachTotal = reachTotal;
    }

    public BigDecimal getVirtualRecordTotal() {
        return virtualRecordTotal;
    }

    public void setVirtualRecordTotal(BigDecimal virtualRecordTotal) {
        this.virtualRecordTotal = virtualRecordTotal;
    }

    public String getRebateProjectDesc() {
        return rebateProjectDesc;
    }

    public void setRebateProjectDesc(String rebateProjectDesc) {
        this.rebateProjectDesc = rebateProjectDesc;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}