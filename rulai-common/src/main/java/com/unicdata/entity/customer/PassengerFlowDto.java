package com.unicdata.entity.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "客流列表DTO")
public class PassengerFlowDto {

    @ApiModelProperty(value = "客流ID")
    private Integer passengerId;

    private Integer type;

    @ApiModelProperty(value = "到店类型")
    private String typeDesc;

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    @ApiModelProperty(value = "到店时间")
    private Date arriveTime;

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    @ApiModelProperty(value = "离店时间")
    private Date leaveTime;

    @ApiModelProperty(value = "接待时长")
    private String receptionTime;

    @ApiModelProperty(value = "迎宾顾问")
    private String ybName;

    @ApiModelProperty(value = "销售顾问")
    private String xsName;

    @ApiModelProperty(value = "销售组")
    private String departmentName;

    private Integer cusId;

    @ApiModelProperty(value = "客户姓名")
    private String cusName;

    @ApiModelProperty(value = "客户手机号")
    private String cusPhone;

    private Integer cusSex;

    @ApiModelProperty(value = "客户性别")
    private String cusSexDesc;

    private Integer provinceId;

    private Integer cityId;

    private Integer districtId;

    @ApiModelProperty(value = "居住区域")
    private String address;

    private Integer ownedCar;

    @ApiModelProperty(value = "现有车系")
    private String ownedCarDesc;

    private Integer intentionFamilyId;

    @ApiModelProperty(value = "意向车系")
    private String intentionFamilyDesc;

    private Integer level;

    @ApiModelProperty(value = "客户级别")
    private String levelDesc;

    private Integer budget;

    @ApiModelProperty(value = "购车预算")
    private String budgetDesc;

    @ApiModelProperty(value = "预计购车时间")
    private String expectBuyTime;

    private Integer cusInfoSources;

    @ApiModelProperty(value = "客户信息来源")
    private String cusInfoSourcesDesc;

    @ApiModelProperty(value = "是否试驾")
    private String doTestDrive = "否";

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    @ApiModelProperty(value = "试驾开始时间")
    private Date driveStartTime;

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    @ApiModelProperty(value = "试驾结束时间")
    private Date driveEndTime;

    @ApiModelProperty(value = "试驾时长")
    private String driveTime;

    @ApiModelProperty(value = "试驾车型")
    private String testDriveCars;

    @ApiModelProperty(value = "是否订单")
    private String hasOrder = "否";

    @ApiModelProperty(value = "是否报价")
    private String hasQuotedPrice = "否";

    @ApiModelProperty(value = "是否邀约")
    private String isInvited = "否";

    @ApiModelProperty(value = "关系销售")
    private String relationSeller;

    @ApiModelProperty(value = "DMS序号")
    private String DmsCode;

    @ApiModelProperty(value = "对比车系")
    private String comparisonCar;

    @ApiModelProperty(value = "车身颜色")
    private String carColor;

    @ApiModelProperty(value = "内饰颜色")
    private String decorationColor;

    private Integer attentionCarOne;

    private Integer attentionCarTwo;

    private Integer attentionCarThree;

    public Integer getAttentionCarOne() {
        return attentionCarOne;
    }

    public void setAttentionCarOne(Integer attentionCarOne) {
        this.attentionCarOne = attentionCarOne;
    }

    public Integer getAttentionCarTwo() {
        return attentionCarTwo;
    }

    public void setAttentionCarTwo(Integer attentionCarTwo) {
        this.attentionCarTwo = attentionCarTwo;
    }

    public Integer getAttentionCarThree() {
        return attentionCarThree;
    }

    public void setAttentionCarThree(Integer attentionCarThree) {
        this.attentionCarThree = attentionCarThree;
    }

    public String getDoTestDrive() {
        return doTestDrive;
    }

    public void setDoTestDrive(String doTestDrive) {
        this.doTestDrive = doTestDrive;
    }

    public String getDriveTime() {
        return driveTime;
    }

    public void setDriveTime(String driveTime) {
        this.driveTime = driveTime;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getDecorationColor() {
        return decorationColor;
    }

    public void setDecorationColor(String decorationColor) {
        this.decorationColor = decorationColor;
    }

    public String getRelationSeller() {
        return relationSeller;
    }

    public void setRelationSeller(String relationSeller) {
        this.relationSeller = relationSeller;
    }

    public String getDmsCode() {
        return DmsCode;
    }

    public void setDmsCode(String dmsCode) {
        DmsCode = dmsCode;
    }

    public String getComparisonCar() {
        return comparisonCar;
    }

    public void setComparisonCar(String comparisonCar) {
        this.comparisonCar = comparisonCar;
    }

    public String getHasOrder() {
        return hasOrder;
    }

    public void setHasOrder(String hasOrder) {
        this.hasOrder = hasOrder;
    }

    public String getHasQuotedPrice() {
        return hasQuotedPrice;
    }

    public void setHasQuotedPrice(String hasQuotedPrice) {
        this.hasQuotedPrice = hasQuotedPrice;
    }

    public String getIsInvited() {
        return isInvited;
    }

    public void setIsInvited(String isInvited) {
        this.isInvited = isInvited;
    }

    public String getTestDriveCars() {
        return testDriveCars;
    }

    public void setTestDriveCars(String testDriveCars) {
        this.testDriveCars = testDriveCars;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getYbName() {
        return ybName;
    }

    public void setYbName(String ybName) {
        this.ybName = ybName;
    }

    public String getXsName() {
        return xsName;
    }

    public void setXsName(String xsName) {
        this.xsName = xsName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public Integer getCusSex() {
        return cusSex;
    }

    public void setCusSex(Integer cusSex) {
        this.cusSex = cusSex;
    }

    public String getCusSexDesc() {
        return cusSexDesc;
    }

    public void setCusSexDesc(String cusSexDesc) {
        this.cusSexDesc = cusSexDesc;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOwnedCar() {
        return ownedCar;
    }

    public void setOwnedCar(Integer ownedCar) {
        this.ownedCar = ownedCar;
    }

    public String getOwnedCarDesc() {
        return ownedCarDesc;
    }

    public void setOwnedCarDesc(String ownedCarDesc) {
        this.ownedCarDesc = ownedCarDesc;
    }

    public Integer getIntentionFamilyId() {
        return intentionFamilyId;
    }

    public void setIntentionFamilyId(Integer intentionFamilyId) {
        this.intentionFamilyId = intentionFamilyId;
    }

    public String getIntentionFamilyDesc() {
        return intentionFamilyDesc;
    }

    public void setIntentionFamilyDesc(String intentionFamilyDesc) {
        this.intentionFamilyDesc = intentionFamilyDesc;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelDesc() {
        return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getBudgetDesc() {
        return budgetDesc;
    }

    public void setBudgetDesc(String budgetDesc) {
        this.budgetDesc = budgetDesc;
    }

    public String getExpectBuyTime() {
        return expectBuyTime;
    }

    public void setExpectBuyTime(String expectBuyTime) {
        this.expectBuyTime = expectBuyTime;
    }

    public Integer getCusInfoSources() {
        return cusInfoSources;
    }

    public void setCusInfoSources(Integer cusInfoSources) {
        this.cusInfoSources = cusInfoSources;
    }

    public String getCusInfoSourcesDesc() {
        return cusInfoSourcesDesc;
    }

    public void setCusInfoSourcesDesc(String cusInfoSourcesDesc) {
        this.cusInfoSourcesDesc = cusInfoSourcesDesc;
    }

    public String getReceptionTime() {
        return receptionTime;
    }

    public void setReceptionTime(String receptionTime) {
        this.receptionTime = receptionTime;
    }

    public Date getDriveStartTime() {
        return driveStartTime;
    }

    public void setDriveStartTime(Date driveStartTime) {
        this.driveStartTime = driveStartTime;
    }

    public Date getDriveEndTime() {
        return driveEndTime;
    }

    public void setDriveEndTime(Date driveEndTime) {
        this.driveEndTime = driveEndTime;
    }
}
