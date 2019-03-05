package com.unicdata.entity.product;

import java.math.BigDecimal;

public class FinanceRangYear {
    private Integer id;

    private Integer rangeId;

    private Integer yearId;

    private BigDecimal loanRatio;

    /**
     * 此字段数据库中没有，仅用于前端接收参数
     */
    private String year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRangeId() {
        return rangeId;
    }

    public void setRangeId(Integer rangeId) {
        this.rangeId = rangeId;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public BigDecimal getLoanRatio() {
        return loanRatio;
    }

    public void setLoanRatio(BigDecimal loanRatio) {
        this.loanRatio = loanRatio;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}