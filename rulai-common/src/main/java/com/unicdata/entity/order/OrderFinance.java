package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class OrderFinance {
    
	private Integer id;

    private Integer orderId;

    private Integer financeId;

    private BigDecimal loanAmount;

    private BigDecimal paymentRatio;

    private BigDecimal downPayment;

    private BigDecimal loanRate;

    private BigDecimal interest;

    private Integer loanTerm;

    private BigDecimal monthlySupply;

    private Integer isSubsidy;

    private Long subsidyInterest;

    private BigDecimal bond;

    private BigDecimal charge;

    private Date createTime;

    private Integer loanStatus;

    private Date loanDate;

    private Date applyDate;

    private BigDecimal mortgageCost;

    private BigDecimal mortgageCharge;

    private BigDecimal sumFinancePrice;

    private BigDecimal donationAmount;

    private BigDecimal totalAmount;

    private BigDecimal margin;

    private Integer isGps;

    private BigDecimal financeCharge;
    
    private Integer chargeType;

	private BigDecimal chargeRatio;

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

    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getPaymentRatio() {
        return paymentRatio;
    }

    public void setPaymentRatio(BigDecimal paymentRatio) {
        this.paymentRatio = paymentRatio;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(BigDecimal loanRate) {
        this.loanRate = loanRate;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public Integer getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(Integer loanTerm) {
        this.loanTerm = loanTerm;
    }

    public BigDecimal getMonthlySupply() {
        return monthlySupply;
    }

    public void setMonthlySupply(BigDecimal monthlySupply) {
        this.monthlySupply = monthlySupply;
    }

    public Integer getIsSubsidy() {
        return isSubsidy;
    }

    public void setIsSubsidy(Integer isSubsidy) {
        this.isSubsidy = isSubsidy;
    }

    public Long getSubsidyInterest() {
        return subsidyInterest;
    }

    public void setSubsidyInterest(Long subsidyInterest) {
        this.subsidyInterest = subsidyInterest;
    }

    public BigDecimal getBond() {
        return bond;
    }

    public void setBond(BigDecimal bond) {
        this.bond = bond;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public BigDecimal getMortgageCost() {
        return mortgageCost;
    }

    public void setMortgageCost(BigDecimal mortgageCost) {
        this.mortgageCost = mortgageCost;
    }

    public BigDecimal getMortgageCharge() {
        return mortgageCharge;
    }

    public void setMortgageCharge(BigDecimal mortgageCharge) {
        this.mortgageCharge = mortgageCharge;
    }

    public BigDecimal getSumFinancePrice() {
        return sumFinancePrice;
    }

    public void setSumFinancePrice(BigDecimal sumFinancePrice) {
        this.sumFinancePrice = sumFinancePrice;
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

    public Integer getIsGps() {
        return isGps;
    }

    public void setIsGps(Integer isGps) {
        this.isGps = isGps;
    }

    public BigDecimal getFinanceCharge() {
        return financeCharge;
    }

    public void setFinanceCharge(BigDecimal financeCharge) {
        this.financeCharge = financeCharge;
    }

	public Integer getChargeType() {
		return chargeType;
	}

	public void setChargeType(Integer chargeType) {
		this.chargeType = chargeType;
	}

	public BigDecimal getChargeRatio() {
		return chargeRatio;
	}

	public void setChargeRatio(BigDecimal chargeRatio) {
		this.chargeRatio = chargeRatio;
	}
}