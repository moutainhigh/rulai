package com.unicdata.entity.carInfo;

public class UnicdataVehicleConfig {
    private Integer rowNames;

    private String unicdatakey;

    private String value;

    private Long nameId;

    public Integer getRowNames() {
        return rowNames;
    }

    public void setRowNames(Integer rowNames) {
        this.rowNames = rowNames;
    }

    public String getUnicdatakey() {
        return unicdatakey;
    }

    public void setUnicdatakey(String unicdatakey) {
        this.unicdatakey = unicdatakey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getNameId() {
        return nameId;
    }

    public void setNameId(Long nameId) {
        this.nameId = nameId;
    }
}