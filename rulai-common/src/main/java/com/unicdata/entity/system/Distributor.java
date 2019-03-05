package com.unicdata.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "集团表实体类")
public class Distributor {
    private Integer id;

    @ApiModelProperty(value = "经销商名称")
    private String name;
    @ApiModelProperty(value = "logo图标")
    private String logoIcon;
    @ApiModelProperty(value = "地址")
    private String addresss;
    @ApiModelProperty(value = "电话")
    private String telephone;
    @ApiModelProperty(value = "微信公众号appid")
    private String appid;
    @ApiModelProperty(value = "微信公众号密钥")
    private String appsecret;
    @ApiModelProperty(value = "加密字符串")
    private String encryptStrings;
    @ApiModelProperty(value = "员工积分商城开关，1开2关")
    private Integer switchFlag;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoIcon() {
        return logoIcon;
    }

    public void setLogoIcon(String logoIcon) {
        this.logoIcon = logoIcon;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getEncryptStrings() {
        return encryptStrings;
    }

    public void setEncryptStrings(String encryptStrings) {
        this.encryptStrings = encryptStrings;
    }

    public Integer getSwitchFlag() {
        return switchFlag;
    }

    public void setSwitchFlag(Integer switchFlag) {
        this.switchFlag = switchFlag;
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