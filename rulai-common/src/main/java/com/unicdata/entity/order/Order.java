package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

public class Order {
	private Integer id;
    @ApiModelProperty(value = "单据�?")
    private String orderNum;
    @ApiModelProperty(value = "客户id")
    private Integer cusId;
    @ApiModelProperty(value = "客户姓名")
    private String cusName;
    @ApiModelProperty(value = "客户手机")
    private String cusIphone;
    @ApiModelProperty(value = "使用�?")
    private String useName;
    @ApiModelProperty(value = "使用人手�?")
    private String useIphone;
    @ApiModelProperty(value = "使用人类�? 1:个人 2公司")
    private Integer useType;
    @ApiModelProperty(value = "证件类型")
    private Integer cardType;
    @ApiModelProperty(value = "号码")
    private String number;
    @ApiModelProperty(value = "预计交车日期")
    private Date deliveryDate;
    @ApiModelProperty(value = "车辆id")
    private Integer carId;
    @ApiModelProperty(value = "分配车辆id")
    private Integer matchingCarId;
    @ApiModelProperty(value = "车辆�?售价")
    private BigDecimal salePrice;
    @ApiModelProperty(value = "车辆实际采购�?")
    private BigDecimal purchasePrice;
    @ApiModelProperty(value = "订单总额")
    private BigDecimal amount;
    @ApiModelProperty(value = "定金")
    private BigDecimal deposit;
    @ApiModelProperty(value = "订单状�??")
    private Integer status;
    @ApiModelProperty(value = "车辆价格审批状�??")
    private Integer carPriceStatus;
    @ApiModelProperty(value = "精品价格审批状�??")
    private Integer boutiquePriceStatus;
    @ApiModelProperty(value = "整车状�??")
    private Integer carStatus;
    @ApiModelProperty(value = "精品状�??")
    private Integer boutiqueStatus;
    @ApiModelProperty(value = "保险状�??")
    private Integer insurerStatus;
    @ApiModelProperty(value = "延保状�??")
    private Integer extensionStatus;
    @ApiModelProperty(value = "金融状�??")
    private Integer financeStatus;
    @ApiModelProperty(value = "其他状�??")
    private Integer otherStatus;
    @ApiModelProperty(value = "订单毛利")
    private BigDecimal margin;
    @ApiModelProperty(value = "售后服务人员id")
    private Integer serviceId;
    @ApiModelProperty(value = "�?售顾问id")
    private Integer createId;
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer storeId;
    private Integer orderType;

    private BigDecimal loanAmount;

    private Date doneTime;
    private BigDecimal donationAmount;
	private Integer ifEquipment;
	private Date equipmentTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusIphone() {
        return cusIphone;
    }

    public void setCusIphone(String cusIphone) {
        this.cusIphone = cusIphone;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getUseIphone() {
        return useIphone;
    }

    public void setUseIphone(String useIphone) {
        this.useIphone = useIphone;
    }

    public Integer getUseType() {
        return useType;
    }

    public void setUseType(Integer useType) {
        this.useType = useType;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    public Integer getBoutiqueStatus() {
        return boutiqueStatus;
    }

    public void setBoutiqueStatus(Integer boutiqueStatus) {
        this.boutiqueStatus = boutiqueStatus;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }

    public Integer getInsurerStatus() {
        return insurerStatus;
    }

    public void setInsurerStatus(Integer insurerStatus) {
        this.insurerStatus = insurerStatus;
    }

    public Integer getExtensionStatus() {
        return extensionStatus;
    }

    public void setExtensionStatus(Integer extensionStatus) {
        this.extensionStatus = extensionStatus;
    }

    public Integer getFinanceStatus() {
        return financeStatus;
    }

    public void setFinanceStatus(Integer financeStatus) {
        this.financeStatus = financeStatus;
    }

    public Integer getOtherStatus() {
        return otherStatus;
    }

    public void setOtherStatus(Integer otherStatus) {
        this.otherStatus = otherStatus;
    }

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getCarPriceStatus() {
		return carPriceStatus;
	}

	public void setCarPriceStatus(Integer carPriceStatus) {
		this.carPriceStatus = carPriceStatus;
	}

	public Integer getBoutiquePriceStatus() {
		return boutiquePriceStatus;
	}

	public void setBoutiquePriceStatus(Integer boutiquePriceStatus) {
		this.boutiquePriceStatus = boutiquePriceStatus;
	}

	public Integer getMatchingCarId() {
		return matchingCarId;
	}

	public void setMatchingCarId(Integer matchingCarId) {
		this.matchingCarId = matchingCarId;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(BigDecimal donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Integer getIfEquipment() {
		return ifEquipment;
	}

	public void setIfEquipment(Integer ifEquipment) {
		this.ifEquipment = ifEquipment;
	}

	public Date getEquipmentTime() {
		return equipmentTime;
	}

	public void setEquipmentTime(Date equipmentTime) {
		this.equipmentTime = equipmentTime;
	}
}