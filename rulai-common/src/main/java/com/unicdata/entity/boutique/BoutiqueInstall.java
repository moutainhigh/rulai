package com.unicdata.entity.boutique;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@ApiModel(value = "精品加装排程")
public class BoutiqueInstall implements Serializable {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "精品详细信息库Id")
	private Integer id;
	@ApiModelProperty(value = "订单ID")
    private Integer orderId;
	@ApiModelProperty(value = "精品订单ID")
	private Integer retailId;
	@ApiModelProperty(value = "预计交车时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date expectedDelivery;
	@ApiModelProperty(value = "后续加装时间")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date followUp;
	@ApiModelProperty(value = "安排施工时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date expectedComplete;
	@ApiModelProperty(value = "实际开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date begin;
	@ApiModelProperty(value = "实际完成时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date actualDelivery;
	@ApiModelProperty(value = "状态( 0 - 未开始 ； 1- 已开始 ； 2 - 已完成)")
    private Integer status;
	@ApiModelProperty(value = "状态字符串")
	private String statusStr;
	@ApiModelProperty(value = "排程单号")
    private String code;
	@ApiModelProperty(value = "员工id")
    private Integer employeeId;
	@ApiModelProperty(value = "客户姓名")
    private String customerName;
	@ApiModelProperty(value = "VIN码")
    private String vin;
	@ApiModelProperty(value = "车牌")
    private String licensePlate;
	@ApiModelProperty(value = "车型")
    private String model;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;
	@ApiModelProperty(value = "来源(销售出库 - 0 , 维修出库 - 1，精品零售 - 2)")
    private Integer source;
	@ApiModelProperty(value = "员工姓名")
	private String fullName;
	@ApiModelProperty(value = "部门名称")
	private String groupName;
	
    private Integer typeLive;
    private Integer constructionNode;
    private Integer constructionType;
    
    private Date updateTime;

    private Date timestamp;
    
	@ApiModelProperty(value = "加装项目包含的具体项目")
    private List<BoutiqueInstallProject> list;
    
    public Integer getConstructionNode() {
		return constructionNode;
	}

	public void setConstructionNode(Integer constructionNode) {
		this.constructionNode = constructionNode;
	}

	public Integer getConstructionType() {
		return constructionType;
	}

	public void setConstructionType(Integer constructionType) {
		this.constructionType = constructionType;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getFollowUp() {
		return followUp;
	}

	public void setFollowUp(Date followUp) {
		this.followUp = followUp;
	}

	public Integer getRetailId() {
		return retailId;
	}

	public void setRetailId(Integer retailId) {
		this.retailId = retailId;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public List<BoutiqueInstallProject> getList() {
		return list;
	}

	public void setList(List<BoutiqueInstallProject> list) {
		this.list = list;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
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

    public Date getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(Date expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public Date getExpectedComplete() {
        return expectedComplete;
    }

    public void setExpectedComplete(Date expectedComplete) {
        this.expectedComplete = expectedComplete;
    }

    public Date getActualDelivery() {
        return actualDelivery;
    }

    public void setActualDelivery(Date actualDelivery) {
        this.actualDelivery = actualDelivery;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}