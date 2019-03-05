package com.unicdata.entity.customer;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Customer {
    private Integer id;

    private Integer passengerId;

    private Integer category;

    private Integer type;

    private String name;

    private String phone;

    private Integer sex;

    private String number;

    private Integer ownedCar;

    private String licensePlate;

    private Integer provinceId;

    private Integer cityId;

    private Integer districtId;

    private Integer channel;

    private Integer level;

    private Integer contactTime;

    private Integer relationCustomer;

    private Integer cusInfoSources;

    private Integer origin;

    private Integer intentionFamilyId;

    private Integer usage;

    private Integer user;

    private Integer userSex;

    private String attentionPoint;

    private Integer budget;

    private Date expectBuyTime;

    private Integer buyType;

    private Integer attentionCarOne;

    private Integer attentionCarTwo;

    private Integer attentionCarThree;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    private Date modifyTime;

    private Integer employeeId;

    private Integer storeId;

    private Integer userStatus;

    private String industry;

    private Double integrity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getOwnedCar() {
        return ownedCar;
    }

    public void setOwnedCar(Integer ownedCar) {
        this.ownedCar = ownedCar;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getContactTime() {
        return contactTime;
    }

    public void setContactTime(Integer contactTime) {
        this.contactTime = contactTime;
    }

    public Integer getRelationCustomer() {
        return relationCustomer;
    }

    public void setRelationCustomer(Integer relationCustomer) {
        this.relationCustomer = relationCustomer;
    }

    public Integer getCusInfoSources() {
        return cusInfoSources;
    }

    public void setCusInfoSources(Integer cusInfoSources) {
        this.cusInfoSources = cusInfoSources;
    }

    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public Integer getIntentionFamilyId() {
        return intentionFamilyId;
    }

    public void setIntentionFamilyId(Integer intentionFamilyId) {
        this.intentionFamilyId = intentionFamilyId;
    }

    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getAttentionPoint() {
        return attentionPoint;
    }

    public void setAttentionPoint(String attentionPoint) {
        this.attentionPoint = attentionPoint;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Date getExpectBuyTime() {
        return expectBuyTime;
    }

    public void setExpectBuyTime(Date expectBuyTime) {
        this.expectBuyTime = expectBuyTime;
    }

    public Integer getBuyType() {
        return buyType;
    }

    public void setBuyType(Integer buyType) {
        this.buyType = buyType;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Double getIntegrity() {
        return integrity;
    }

    public void setIntegrity(Double integrity) {
        this.integrity = integrity;
    }
}