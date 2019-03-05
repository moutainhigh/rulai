package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品出库订单详情  ")
// 需出库的不同施工节点精品。\r\n同一订单下的精品都未出库时，订单为未出料状态(0)，；\r\n同一订单下有部分精品出库，订单为部分出料状态(1)；\r\n同一订单下所有精品出库，订单为全部出料状态(2);
public class BoutiqueOutboundDetail implements Serializable{

	private static final long serialVersionUID = -2532503441960509539L;

	@ApiModelProperty(value = "精品出库订单详情Id")
    private Integer id;
	@ApiModelProperty(value = "精品订单id")
    private Integer boutiqueOrderId;
	@ApiModelProperty(value = "施工节点( 0 不施工 ； 1-交车前施工 ； 2 - 交车后施工)")
    private Integer boutiqueConstruction;
	@ApiModelProperty(value = "精品id")
    private Integer boutiqueId;
	@ApiModelProperty(value = "精品数量")
    private Integer numer;
	@ApiModelProperty(value = "当前库存")
	private Integer nowStock;
	@ApiModelProperty(value = "领料人Id")
    private Integer pickerId;
	@ApiModelProperty(value = "领料人")
	private String pickerIdStr;
	@ApiModelProperty(value = "出库时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date outboundDate;
	@ApiModelProperty(value = "是否出库,默认未出库( 0 - 未出库 ; 1- 出库)")
    private Integer status;
	@ApiModelProperty(value = "时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timeStamp;
	@ApiModelProperty(value = "出库单id")
    private Integer outboundId;

    private Integer typeLive;
    
	@ApiModelProperty(value = "精品编号")
  	private String code;
	@ApiModelProperty(value = "精品名称")
  	private String name;
	@ApiModelProperty(value = "仓库名称")
  	private String warehouse;
	@ApiModelProperty(value = "库位")
  	private String position;
	@ApiModelProperty(value = "含税单价")
  	private BigDecimal taxPrice;
	@ApiModelProperty(value = "含税成本")
  	private BigDecimal taxCost;
	@ApiModelProperty(value = "销售价")
  	private BigDecimal unitprice;
	@ApiModelProperty(value = "是否是原装( 0 - 不是原装 ； 1 - 原装)")
  	private Integer isHost;
    
	@ApiModelProperty(value = "序号")
	private Integer no;
	
	public Integer getNowStock() {
		return nowStock;
	}

	public void setNowStock(Integer nowStock) {
		this.nowStock = nowStock;
	}

	public String getPickerIdStr() {
		return pickerIdStr;
	}

	public void setPickerIdStr(String pickerIdStr) {
		this.pickerIdStr = pickerIdStr;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public BigDecimal getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}

	public BigDecimal getTaxCost() {
		return taxCost;
	}

	public void setTaxCost(BigDecimal taxCost) {
		this.taxCost = taxCost;
	}

	public BigDecimal getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
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

    public Integer getOutboundId() {
        return outboundId;
    }

    public void setOutboundId(Integer outboundId) {
        this.outboundId = outboundId;
    }

    public Integer getBoutiqueOrderId() {
        return boutiqueOrderId;
    }

    public void setBoutiqueOrderId(Integer boutiqueOrderId) {
        this.boutiqueOrderId = boutiqueOrderId;
    }

    public Integer getBoutiqueConstruction() {
        return boutiqueConstruction;
    }

    public void setBoutiqueConstruction(Integer boutiqueConstruction) {
        this.boutiqueConstruction = boutiqueConstruction;
    }

    public Integer getBoutiqueId() {
        return boutiqueId;
    }

    public void setBoutiqueId(Integer boutiqueId) {
        this.boutiqueId = boutiqueId;
    }

    public Integer getNumer() {
        return numer;
    }

    public void setNumer(Integer numer) {
        this.numer = numer;
    }

    public Integer getPickerId() {
		return pickerId;
	}

	public void setPickerId(Integer pickerId) {
		this.pickerId = pickerId;
	}

	public Date getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(Date outboundDate) {
        this.outboundDate = outboundDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}