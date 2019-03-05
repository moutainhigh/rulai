package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "供应商")
public class BoutiqueSupplier implements Serializable{

	private static final long serialVersionUID = -1131098574718156412L;

	@ApiModelProperty(value = "供应商Id")
    private Integer id;
	@ApiModelProperty(value = "供应商名称")
    private String name;
	@ApiModelProperty(value = "精品品牌id")
    private String fineBrandIds;
	@ApiModelProperty(value = "精品品牌名称")
	private String fineBrandName;
	@ApiModelProperty(value = "是否是主机厂( 0 - 不是主机厂 ； 1 - 是主机厂)")
	private Integer isHost;
	@ApiModelProperty(value = "公司电话")
    private String companyTel;
	@ApiModelProperty(value = "联系人1名字")
    private String contactsOne;
	@ApiModelProperty(value = "联系人1手机号码")
    private String contactsOnePhone;
	@ApiModelProperty(value = "联系人2名字")
    private String contactsTwo;
	@ApiModelProperty(value = "联系人2电话")
    private String contactsTwoPhone;
	@ApiModelProperty(value = "供应商地址")
    private String address;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;

	@ApiModelProperty(value = "时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timeStamp;

    private Integer typeLive;

    public String getFineBrandName() {
		return fineBrandName;
	}

	public void setFineBrandName(String fineBrandName) {
		this.fineBrandName = fineBrandName;
	}

	public Integer getIsHost() {
		return isHost;
	}

	public void setIsHost(Integer isHost) {
		this.isHost = isHost;
	}

	public Integer getTypeLive() {
		return typeLive;
	}

	public void setTypeLive(Integer typeLive) {
		this.typeLive = typeLive;
	}
	
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

    public String getFineBrandIds() {
		return fineBrandIds;
	}

	public void setFineBrandIds(String fineBrandIds) {
		this.fineBrandIds = fineBrandIds;
	}

	public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getContactsOne() {
        return contactsOne;
    }

    public void setContactsOne(String contactsOne) {
        this.contactsOne = contactsOne;
    }

    public String getContactsOnePhone() {
        return contactsOnePhone;
    }

    public void setContactsOnePhone(String contactsOnePhone) {
        this.contactsOnePhone = contactsOnePhone;
    }

    public String getContactsTwo() {
        return contactsTwo;
    }

    public void setContactsTwo(String contactsTwo) {
        this.contactsTwo = contactsTwo;
    }

    public String getContactsTwoPhone() {
        return contactsTwoPhone;
    }

    public void setContactsTwoPhone(String contactsTwoPhone) {
        this.contactsTwoPhone = contactsTwoPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}