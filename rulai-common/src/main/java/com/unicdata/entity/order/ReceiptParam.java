package com.unicdata.entity.order;

import java.math.BigDecimal;

/**
 * Create by zhang
 */
public class ReceiptParam extends Receipt {
    private BigDecimal receivable;
    private BigDecimal payAmount;
    private String payTime;

    public BigDecimal getReceivable() {
        return receivable;
    }

    public void setReceivable(BigDecimal receivable) {
        this.receivable = receivable;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }
}
