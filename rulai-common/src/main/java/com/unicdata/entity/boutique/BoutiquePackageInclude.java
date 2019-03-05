package com.unicdata.entity.boutique;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "精品礼包中的精品及精品数量")
public class BoutiquePackageInclude implements Serializable{

	private static final long serialVersionUID = -5002997203903348943L;
	@ApiModelProperty(value = "Id")
    private Integer id;
	@ApiModelProperty(value = "精品礼包id")
    private Integer packageId;
	@ApiModelProperty(value = "精品id")
    private Integer informationId;
	@ApiModelProperty(value = "精品数量")
    private Integer informationNum;
	@ApiModelProperty(value = "精品详细信息")
	private BoutiqueInformation boutiqueInfo;
	
    public BoutiqueInformation getBoutiqueInfo() {
		return boutiqueInfo;
	}

	public void setBoutiqueInfo(BoutiqueInformation boutiqueInfo) {
		this.boutiqueInfo = boutiqueInfo;
	}

	private Integer typeLive;

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

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public Integer getInformationNum() {
        return informationNum;
    }

    public void setInformationNum(Integer informationNum) {
        this.informationNum = informationNum;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((informationId == null) ? 0 : informationId.hashCode());
		result = prime * result + ((packageId == null) ? 0 : packageId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoutiquePackageInclude other = (BoutiquePackageInclude) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (informationId == null) {
			if (other.informationId != null)
				return false;
		} else if (!informationId.equals(other.informationId))
			return false;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
			return false;
		return true;
	}
    
    
    
}