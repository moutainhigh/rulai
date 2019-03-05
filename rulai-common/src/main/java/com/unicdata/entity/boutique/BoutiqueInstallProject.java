package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品加装排程施工项目")
public class BoutiqueInstallProject implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "精品加装排程施工项目Id")
    private Integer id;
	@ApiModelProperty(value = "精品加装排程id")
    private Integer installId;
	
	private Integer boutiqueId;
	
	private Integer includeId;
	
	@ApiModelProperty(value = "精品施工项目(精品名称)")
    private String boutiqueProject;
	@ApiModelProperty(value = "施工节点（ 1 - 交车前 ； 2 - 交车后 ； 3 - 不施工）")
    private Integer constructionNode;
	@ApiModelProperty(value = "施工节点字符串")
	private String constructionNodeStr;
	@ApiModelProperty(value = "标准工时")
    private Double workinghours;
	@ApiModelProperty(value = "预计完成时长")
	private Double expectWorkinghours;
	@ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
	@ApiModelProperty(value = "完成时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
	@ApiModelProperty(value = "实际工时")
    private Double workinghoursUse;
	@ApiModelProperty(value = "项目负责人")
    private String principal;
	@ApiModelProperty(value = "状态( 0 - 未开始 ； 1- 已开始 ； 2 - 已完成)")
    private Integer status;

	@ApiModelProperty(value = "状态字符串")
	private String statusStr;
	
	
	private Integer isGift;
	
    private Integer typeLive;
    
    
    private BigDecimal divisionValue;//划价
    
    public BigDecimal getDivisionValue() {
		return divisionValue;
	}

	public void setDivisionValue(BigDecimal divisionValue) {
		this.divisionValue = divisionValue;
	}

	public Integer getIncludeId() {
		return includeId;
	}

	public void setIncludeId(Integer includeId) {
		this.includeId = includeId;
	}

	public Integer getBoutiqueId() {
		return boutiqueId;
	}

	public void setBoutiqueId(Integer boutiqueId) {
		this.boutiqueId = boutiqueId;
	}

	public Integer getIsGift() {
		return isGift;
	}

	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}

	public String getConstructionNodeStr() {
		return constructionNodeStr;
	}

	public void setConstructionNodeStr(String constructionNodeStr) {
		this.constructionNodeStr = constructionNodeStr;
	}

	public Integer getConstructionNode() {
		return constructionNode;
	}

	public void setConstructionNode(Integer constructionNode) {
		this.constructionNode = constructionNode;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public Double getExpectWorkinghours() {
		return expectWorkinghours;
	}

	public void setExpectWorkinghours(Double expectWorkinghours) {
		this.expectWorkinghours = expectWorkinghours;
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

    public Integer getInstallId() {
        return installId;
    }

    public void setInstallId(Integer installId) {
        this.installId = installId;
    }

    public String getBoutiqueProject() {
        return boutiqueProject;
    }

    public void setBoutiqueProject(String boutiqueProject) {
        this.boutiqueProject = boutiqueProject;
    }

    public Double getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(Double workinghours) {
        this.workinghours = workinghours;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getWorkinghoursUse() {
        return workinghoursUse;
    }

    public void setWorkinghoursUse(Double workinghoursUse) {
        this.workinghoursUse = workinghoursUse;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}