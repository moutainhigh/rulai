package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品出库订单")
public class BoutiqueOutbound implements Serializable{

	private static final long serialVersionUID = -5870740939998492919L;

	@ApiModelProperty(value = "精品出库订单Id")
    private Integer id;
	@ApiModelProperty(value = "精品加装排程Id")
	private Integer installId;
	@ApiModelProperty(value = "销售订单号")
    private String salveNo;
	@ApiModelProperty(value = "精品单号")
    private String boutiqueNo;
	@ApiModelProperty(value = "VIN码")
    private String vin;
	@ApiModelProperty(value = "车型Id")
    private Integer vehicleId;
	@ApiModelProperty(value = "车型")
	private String vehicle;
	@ApiModelProperty(value = "员工姓名")
    private String employeeName;
	@ApiModelProperty(value = "客户姓名")
    private String customerName;
	@ApiModelProperty(value = "申请日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applyDate;
	@ApiModelProperty(value = "单据状态（ 0 - 未出料 ； 1 - 部分出料 ； 2- 全部出料）")
    private Integer status;
	@ApiModelProperty(value = "单据状态")
	private String statusStr;
	@ApiModelProperty(value = "来源(销售出库 - 0 , 维修出库 - 1，精品零售 - 2)")
    private Integer type;

	@ApiModelProperty(value = "门店id")
    private Integer storeId;

	@ApiModelProperty(value = "时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timeStamp;

    private Integer typeLive;

	@ApiModelProperty(value = "不施工集合")
    private List<BoutiqueOutboundDetail> notConstruction;
	@ApiModelProperty(value = "交车前施工集合")
    private List<BoutiqueOutboundDetail> beforeConstruction;
	@ApiModelProperty(value = "交车后施工集合")
    private List<BoutiqueOutboundDetail> afterConstruction;
	
	@ApiModelProperty(value = "序号")
	private Integer no;
	
	private List<BoutiqueOutboundDetail> list;
	
    public Integer getInstallId() {
		return installId;
	}

	public void setInstallId(Integer installId) {
		this.installId = installId;
	}

	public List<BoutiqueOutboundDetail> getList() {
		return list;
	}

	public void setList(List<BoutiqueOutboundDetail> list) {
		this.list = list;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public List<BoutiqueOutboundDetail> getNotConstruction() {
		return notConstruction;
	}

	public void setNotConstruction(List<BoutiqueOutboundDetail> notConstruction) {
		this.notConstruction = notConstruction;
	}

	public List<BoutiqueOutboundDetail> getBeforeConstruction() {
		return beforeConstruction;
	}

	public void setBeforeConstruction(List<BoutiqueOutboundDetail> beforeConstruction) {
		this.beforeConstruction = beforeConstruction;
	}

	public List<BoutiqueOutboundDetail> getAfterConstruction() {
		return afterConstruction;
	}

	public void setAfterConstruction(List<BoutiqueOutboundDetail> afterConstruction) {
		this.afterConstruction = afterConstruction;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
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

    public String getSalveNo() {
        return salveNo;
    }

    public void setSalveNo(String salveNo) {
        this.salveNo = salveNo;
    }

    public String getBoutiqueNo() {
        return boutiqueNo;
    }

    public void setBoutiqueNo(String boutiqueNo) {
        this.boutiqueNo = boutiqueNo;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
        switch(status){
	        case(0):{this.statusStr = "未出料";break;}
	        case(1):{this.statusStr = "部分出料";break;}
	        case(2):{this.statusStr = "全部出料";break;}
        }
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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