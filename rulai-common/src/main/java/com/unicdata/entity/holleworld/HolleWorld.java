package com.unicdata.entity.holleworld;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "HolleWorld实体类")
public class HolleWorld implements Serializable {
    private static final long serialVersionUID = 11253575365124365L;

    @ApiModelProperty(value = "HolleWorld Id字段")
    private Integer id;
    @ApiModelProperty(value = "HolleWorld context字段")
    private String context;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}