package com.unicdata.entity.carInfo;

public class UnicdataFamily {
    private Integer id;

    private Integer familyId;

    private String familyName;

    private String familyAlias;

    private Integer brandId;

    private Integer factoryId;

    private String picture;

    private Byte vehicleType;

    private Byte vehicleTypeExt;

    private Byte vehicleTypeGrade;

    private Byte rank;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyAlias() {
        return familyAlias;
    }

    public void setFamilyAlias(String familyAlias) {
        this.familyAlias = familyAlias;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Byte getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Byte vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Byte getVehicleTypeExt() {
        return vehicleTypeExt;
    }

    public void setVehicleTypeExt(Byte vehicleTypeExt) {
        this.vehicleTypeExt = vehicleTypeExt;
    }

    public Byte getVehicleTypeGrade() {
        return vehicleTypeGrade;
    }

    public void setVehicleTypeGrade(Byte vehicleTypeGrade) {
        this.vehicleTypeGrade = vehicleTypeGrade;
    }

    public Byte getRank() {
        return rank;
    }

    public void setRank(Byte rank) {
        this.rank = rank;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}