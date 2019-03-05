package com.unicdata.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "门店实体类")
public class DistributorStoreInfo {

    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "集团id")
    private Integer distributorId;
    @ApiModelProperty(value = "门店名称")
    private String name;
    @ApiModelProperty(value = "门店code")
    private String code;
    @ApiModelProperty(value = "门店简称")
    private String abbreviation;
    @ApiModelProperty(value = "门店图片")
    private String pictureUrl;
    @ApiModelProperty(value = "门店省份")
    private String province;
    @ApiModelProperty(value = "门店省份id")
    private Integer provinceId;
    @ApiModelProperty(value = "门店城市")
    private String city;
    @ApiModelProperty(value = "门店城市id")
    private Integer cityId;
    @ApiModelProperty(value = "门店街道地址")
    private String street;
    @ApiModelProperty(value = "经度")
    private String longitude;
    @ApiModelProperty(value = "纬度")
    private String latitude;
    @ApiModelProperty(value = "门店号码")
    private String landline;
    @ApiModelProperty(value = "门店手机号码(暂时废置)")
    private String iphone;
    @ApiModelProperty(value = "门店简介")
    private String summary;
    @ApiModelProperty(value = "特殊服务")
    private String service;
    @ApiModelProperty(value = "营业开始时间")
    private String businessStartDate;
    @ApiModelProperty(value = "营业结束时间")
    private String businessStopDate;
    @ApiModelProperty(value = "门店店长")
    private Integer shopowner;
    @ApiModelProperty(value = "门店状态  1:上架  2:下架")
    private Byte storeStatus;
    @ApiModelProperty(value = "数据状态 0:已删除  1:正常")
    private Byte dataStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getBusinessStartDate() {
        return businessStartDate;
    }

    public void setBusinessStartDate(String businessStartDate) {
        this.businessStartDate = businessStartDate;
    }

    public String getBusinessStopDate() {
        return businessStopDate;
    }

    public void setBusinessStopDate(String businessStopDate) {
        this.businessStopDate = businessStopDate;
    }

    public Integer getShopowner() {
        return shopowner;
    }

    public void setShopowner(Integer shopowner) {
        this.shopowner = shopowner;
    }

    public Byte getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Byte storeStatus) {
        this.storeStatus = storeStatus;
    }

    public Byte getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Byte dataStatus) {
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
}