package com.unicdata.entity.car;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CarWarehouseChange {
    private Integer id;
    @ApiModelProperty(value = "门店id")
    private Integer distributorStoreId;
    @ApiModelProperty(value = "商品车id")
    private Integer carGoodId;
    @ApiModelProperty(value = "车辆移库操作单id")
    private Integer changeApplicationId;
    @ApiModelProperty(value = "变更前仓库")
    private Integer beforeWarehouseId;
    @ApiModelProperty(value = "变更后仓库")
    private Integer afterWarehouseId;
    @ApiModelProperty(value = "变更前库位")
    private Integer beforeStorageId;
    @ApiModelProperty(value = "变更后库位")
    private Integer afterStorageId;
    @ApiModelProperty(value = "操作人id")
    private Integer operatorId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistributorStoreId() {
        return distributorStoreId;
    }

    public void setDistributorStoreId(Integer distributorStoreId) {
        this.distributorStoreId = distributorStoreId;
    }
    
    public Integer getCarGoodId() {
        return carGoodId;
    }

    public void setCarGoodId(Integer carGoodId) {
        this.carGoodId = carGoodId;
    }

    public Integer getChangeApplicationId() {
        return changeApplicationId;
    }

    public void setChangeApplicationId(Integer changeApplicationId) {
        this.changeApplicationId = changeApplicationId;
    }

    public Integer getBeforeWarehouseId() {
        return beforeWarehouseId;
    }

    public void setBeforeWarehouseId(Integer beforeWarehouseId) {
        this.beforeWarehouseId = beforeWarehouseId;
    }

    public Integer getAfterWarehouseId() {
        return afterWarehouseId;
    }

    public void setAfterWarehouseId(Integer afterWarehouseId) {
        this.afterWarehouseId = afterWarehouseId;
    }

    public Integer getBeforeStorageId() {
        return beforeStorageId;
    }

    public void setBeforeStorageId(Integer beforeStorageId) {
        this.beforeStorageId = beforeStorageId;
    }

    public Integer getAfterStorageId() {
        return afterStorageId;
    }

    public void setAfterStorageId(Integer afterStorageId) {
        this.afterStorageId = afterStorageId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}