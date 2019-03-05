package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "目标设定")
public class BoutiqueTarget implements Serializable{

	private static final long serialVersionUID = 506545861317611770L;

	@ApiModelProperty(value = "目标设定Id")
    private Integer id;
	@ApiModelProperty(value = "部门id")
    private Integer employeeGroupId;
	@ApiModelProperty(value = "项目名称")
    private String project;
	@ApiModelProperty(value = "收入计划")
    private BigDecimal incomePlay;
	@ApiModelProperty(value = "毛利计划")
    private BigDecimal profitPlay;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;
	@ApiModelProperty(value = "来源(销售-0 ， 售后 - 1,零售 - 2)")
	private Integer source;
	@ApiModelProperty(value = "时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    private Integer typeLive;

	@ApiModelProperty(value = "时间戳")
    private String groupName;
    
    public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
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

    public Integer getEmployeeGroupId() {
        return employeeGroupId;
    }

    public void setEmployeeGroupId(Integer employeeGroupId) {
        this.employeeGroupId = employeeGroupId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public BigDecimal getIncomePlay() {
        return incomePlay;
    }

    public void setIncomePlay(BigDecimal incomePlay) {
        this.incomePlay = incomePlay;
    }

    public BigDecimal getProfitPlay() {
        return profitPlay;
    }

    public void setProfitPlay(BigDecimal profitPlay) {
        this.profitPlay = profitPlay;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}