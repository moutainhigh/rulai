package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品订单 详情")
public class BoutiqueRetailInclude implements Serializable{

	private static final long serialVersionUID = 8464378989465102223L;

	@ApiModelProperty(value = "精品订单 详情Id")
    private Integer id;
	@ApiModelProperty(value = "精品订单id")
    private Integer retailId;
	@ApiModelProperty(value = "精品单品id")
    private Integer informationId;
	@ApiModelProperty(value = "精品礼包id")
    private Integer packId;
	@ApiModelProperty(value = "数量")
    private Integer informationNum;
	@ApiModelProperty(value = "字段废弃，不使用")
    private Integer packNum;
	
	@ApiModelProperty(value = "精品销售单价")
    private BigDecimal saleValue;
	@ApiModelProperty(value = "精品申请单价")
    private BigDecimal applyValue;
	@ApiModelProperty(value = "划分价格(该精品在订单中总的划分价格)")
    private BigDecimal divisionValue;
	@ApiModelProperty(value = "是否赠送( 0 - 否 ； 1 - 是)")
    private Integer isGift;
	@ApiModelProperty(value = "是否是精品礼包 ( 0 - 不是 ； 1 - 是)")
    private Integer isPackage;
	@ApiModelProperty(value = "状态(0 - 删除 ； 1- 正常)")
    private Integer status;
	@ApiModelProperty(value = "施工节点（ 1 - 交车前 ； 2 - 交车后 ； 3 - 不施工）")
	private Integer constructionNode;
	
    private Integer typeLive;

	@ApiModelProperty(value = "精品名称")
    private String informationName;
	@ApiModelProperty(value = "精品编号")
    private String informationCode;
	@ApiModelProperty(value = "是否原装(0 - 不是原装 ； 1- 是原装)")
    private Integer isHost;
    
	@ApiModelProperty(value = "如果是精品礼包，礼包中包含的精品信息")
	private List<BoutiquePackageInclude> packContains;
	
    public List<BoutiquePackageInclude> getPackContains() {
		return packContains;
	}

	public void setPackContains(List<BoutiquePackageInclude> packContains) {
		this.packContains = packContains;
	}

	public BigDecimal getDivisionValue() {
		return divisionValue;
	}

	public void setDivisionValue(BigDecimal divisionValue) {
		this.divisionValue = divisionValue;
	}

	public String getInformationName() {
		return informationName;
	}

	public void setInformationName(String informationName) {
		this.informationName = informationName;
	}

	public String getInformationCode() {
		return informationCode;
	}

	public void setInformationCode(String informationCode) {
		this.informationCode = informationCode;
	}

	public Integer getIsHost() {
		return isHost;
	}

	public void setIsHost(Integer isHost) {
		this.isHost = isHost;
	}

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

    public Integer getRetailId() {
        return retailId;
    }

    public void setRetailId(Integer retailId) {
        this.retailId = retailId;
    }

    public Integer getInformationId() {
		return informationId;
	}

	public void setInformationId(Integer informationId) {
		this.informationId = informationId;
	}

	public Integer getPackId() {
		return packId;
	}

	public void setPackId(Integer packId) {
		this.packId = packId;
	}

	public Integer getInformationNum() {
		return informationNum;
	}

	public void setInformationNum(Integer informationNum) {
		this.informationNum = informationNum;
	}

	public Integer getPackNum() {
		return packNum;
	}

	public void setPackNum(Integer packNum) {
		this.packNum = packNum;
	}

	public BigDecimal getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
    }

    public BigDecimal getApplyValue() {
        return applyValue;
    }

    public void setApplyValue(BigDecimal applyValue) {
        this.applyValue = applyValue;
    }

    public Integer getIsPackage() {
        return isPackage;
    }

    public void setIsPackage(Integer isPackage) {
        this.isPackage = isPackage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public Integer getIsGift() {
		return isGift;
	}

	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}

	public Integer getConstructionNode() {
		return constructionNode;
	}

	public void setConstructionNode(Integer constructionNode) {
		this.constructionNode = constructionNode;
	}
}