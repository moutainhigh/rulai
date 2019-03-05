package com.unicdata.entity.basedata;

public class Province {
    private Integer id;

    private String provinceName;

    private String pinyin;

    private String orderBy;

    private Short status;

    private String shortProvinceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getShortProvinceName() {
        return shortProvinceName;
    }

    public void setShortProvinceName(String shortProvinceName) {
        this.shortProvinceName = shortProvinceName;
    }
}