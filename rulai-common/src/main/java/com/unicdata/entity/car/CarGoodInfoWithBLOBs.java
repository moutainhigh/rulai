package com.unicdata.entity.car;

import io.swagger.annotations.ApiModelProperty;

public class CarGoodInfoWithBLOBs extends CarGoodInfo {
	@ApiModelProperty(value = "随车资料")
	private String carData;
	@ApiModelProperty(value = "备注")
    private String remark;

    public String getCarData() {
        return carData;
    }

    public void setCarData(String carData) {
        this.carData = carData;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}