package com.unicdata.entity.policy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicdata.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "到账单/收款单异常数据")
public class ListException extends BaseEntity {
    private Integer id;

    @ApiModelProperty(value = "返利项目id")
    private Integer rebateProjectId;

    @ApiModelProperty(value = "1到账单 ，2核对单 限制list_id关联不同的表")
    private Integer listType;

    @ApiModelProperty(value = "到账单或者核对单的id")
    private Integer listId;

    @ApiModelProperty(value = "vin")
    private String vin;

    @ApiModelProperty(value = "到账单或者核对单的金额")
    private BigDecimal money;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRebateProjectId() {
        return rebateProjectId;
    }

    public void setRebateProjectId(Integer rebateProjectId) {
        this.rebateProjectId = rebateProjectId;
    }

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}