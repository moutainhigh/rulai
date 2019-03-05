package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInsurance {

	private Integer id;

    private Integer orderId;

    private Integer insuranceCompanyId;

    private Integer insuranceId;

    private String remarks;

    private BigDecimal sumMoney;
    
    private BigDecimal donationAmount;

	private BigDecimal totalAmount;

	private BigDecimal margin;
    
    private Integer renewalYears;
    
    private Integer isRenewal;

	private BigDecimal renewalBalance;

    private BigDecimal mortgage;

    private Integer isGift;

    private Date createTime;

    private Integer state;

    private Date deadline;

    private String number;

    private Integer carCharacter;

    private String insuranceImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getInsuranceCompanyId() {
        return insuranceCompanyId;
    }

    public void setInsuranceCompanyId(Integer insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCarCharacter() {
        return carCharacter;
    }

    public void setCarCharacter(Integer carCharacter) {
        this.carCharacter = carCharacter;
    }

    public String getInsuranceImg() {
        return insuranceImg;
    }

    public void setInsuranceImg(String insuranceImg) {
        this.insuranceImg = insuranceImg;
    }

	public Integer getRenewalYears() {
		return renewalYears;
	}

	public void setRenewalYears(Integer renewalYears) {
		this.renewalYears = renewalYears;
	}

	public BigDecimal getMortgage() {
		return mortgage;
	}

	public void setMortgage(BigDecimal mortgage) {
		this.mortgage = mortgage;
	}

	public Integer getIsGift() {
		return isGift;
	}

	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}

	public BigDecimal getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(BigDecimal donationAmount) {
		this.donationAmount = donationAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	public Integer getIsRenewal() {
		return isRenewal;
	}

	public void setIsRenewal(Integer isRenewal) {
		this.isRenewal = isRenewal;
	}

	public BigDecimal getRenewalBalance() {
		return renewalBalance;
	}

	public void setRenewalBalance(BigDecimal renewalBalance) {
		this.renewalBalance = renewalBalance;
	}
}