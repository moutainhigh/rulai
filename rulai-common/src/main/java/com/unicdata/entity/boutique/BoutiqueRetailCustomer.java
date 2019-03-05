package com.unicdata.entity.boutique;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品零售客户")
public class BoutiqueRetailCustomer implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5460583694189856874L;

	@ApiModelProperty(value = "精品零售客户Id")
    private Integer id;
	@ApiModelProperty(value = "精品零售客户/企业名称")
    private String name;
	@ApiModelProperty(value = "手机号码")
    private String phone;
	@ApiModelProperty(value = "备注")
    private String note;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;

    private Integer typeLive;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}