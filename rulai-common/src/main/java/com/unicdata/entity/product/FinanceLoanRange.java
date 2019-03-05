package com.unicdata.entity.product;

import org.assertj.core.util.Lists;

import java.math.BigDecimal;
import java.util.List;

public class FinanceLoanRange {
    private Integer id;

    private Integer financeId;

    private BigDecimal loanAmountLow;

    private BigDecimal loanAmountHign;

    /**
     * 用于接收前端参数(数据库中不存在)
     */
    private List<FinanceRangYear> rangYears = Lists.newArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public BigDecimal getLoanAmountLow() {
        return loanAmountLow;
    }

    public void setLoanAmountLow(BigDecimal loanAmountLow) {
        this.loanAmountLow = loanAmountLow;
    }

    public BigDecimal getLoanAmountHign() {
        return loanAmountHign;
    }

    public void setLoanAmountHign(BigDecimal loanAmountHign) {
        this.loanAmountHign = loanAmountHign;
    }

    public List<FinanceRangYear> getRangYears() {
        return rangYears;
    }

    public void setRangYears(List<FinanceRangYear> rangYears) {
        this.rangYears = rangYears;
    }
}