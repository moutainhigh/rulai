package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品信息")
public class BoutiqueInformation implements Serializable{

	private static final long serialVersionUID = 8329729396036765070L;

	@ApiModelProperty(value = "精品Id")
    private Integer id;
	@ApiModelProperty(value = "精品编号")
    private String code;
	@ApiModelProperty(value = "精品名称")
    private String name;
	@ApiModelProperty(value = "仓库id")
    private Integer warehouseId;
	@ApiModelProperty(value = "库位id")
    private Integer positionId;
	@ApiModelProperty(value = "精品分类id组合 （父级id - 子级id- 子级id- 子级id）")
    private String classify;
	@ApiModelProperty(value = "精品分类")
	private String classifyStr;
	@ApiModelProperty(value = "精品分类id")
	private Integer classifyId;
	@ApiModelProperty(value = "车系分类id")
    private String carClassifyId;
	@ApiModelProperty(value = "精品品牌id")
    private Integer brandId;
	@ApiModelProperty(value = "单位")
    private String company;
	@ApiModelProperty(value = "施工节点（ 1 - 交车前 ； 2 - 交车后 ； 3 - 不施工）")
    private Integer constructionNode;
	@ApiModelProperty(value = "施工节点字符串")
	private String constructionNodeStr;
	@ApiModelProperty(value = "供应商id")
    private Integer supplierId;
	@ApiModelProperty(value = "是否原装( 0 - 不是原装 ； 1 - 是原装)")
	private Integer isHost;
	@ApiModelProperty(value = "含税单价")
    private BigDecimal taxPrice;
	@ApiModelProperty(value = "含税成本")
    private BigDecimal taxCost;
	@ApiModelProperty(value = "精品系数")
    private BigDecimal coefficient;
	@ApiModelProperty(value = "销售单价")
    private BigDecimal unitprice;
	@ApiModelProperty(value = "工时")
    private Double workinghours;
	
	private Double laborCost;
	@ApiModelProperty(value = "预计完成时长")
	private Double expectWorkinghours;
	@ApiModelProperty(value = "安全库存")
    private Integer safetyStock;
	@ApiModelProperty(value = "库存")
    private Integer stock;
	@ApiModelProperty(value = "图片位置")
    private String picture;
	@ApiModelProperty(value = "状态(0 下架； 1 上架)")
    private Integer status;
	@ApiModelProperty(value = "是否上架( 0 - 未上架 ， 1- 上架)")
    private Integer isShelf;
	@ApiModelProperty(value = "售卖类型")
    private String saleType;
	@ApiModelProperty(value = "最近入库时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastPushTime;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;
	@ApiModelProperty(value = "")
    private Integer type;
	@ApiModelProperty(value = "时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timestamp;
	@ApiModelProperty(value = "备注")
    private String remark;
	@ApiModelProperty(value = "状态( 0 - 删除 ； 1 - 正常)")
    private Integer typeLive;
	@ApiModelProperty(value = "原厂精品编号")
	private String originalCode;
	@ApiModelProperty(value = "仓库名称")
    private String warehouse;
	@ApiModelProperty(value = "库位名称")
    private String position;
	@ApiModelProperty(value = "车系名称")
    private String carClassify;
	@ApiModelProperty(value = "精品品牌名称")
    private String brand;
	@ApiModelProperty(value = "精品供应商名称")
    private String supplier;
	@ApiModelProperty(value = "在库天数")
	private String stayWareHouseDate;
	@ApiModelProperty(value = "警戒天数")
	private String cautionDate;
	@ApiModelProperty(value = "序号")
	private Integer no;
	
	public String getOriginalCode() {
		return originalCode;
	}

	public void setOriginalCode(String originalCode) {
		this.originalCode = originalCode;
	}

	public Double getLaborCost() {
		return laborCost;
	}

	public void setLaborCost(Double laborCost) {
		this.laborCost = laborCost;
	}

	public String getConstructionNodeStr() {
		return constructionNodeStr;
	}

	public void setConstructionNodeStr(String constructionNodeStr) {
		this.constructionNodeStr = constructionNodeStr;
	}

	public String getClassifyStr() {
		return classifyStr;
	}

	public void setClassifyStr(String classifyStr) {
		this.classifyStr = classifyStr;
	}

	public Double getExpectWorkinghours() {
		return expectWorkinghours;
	}

	public void setExpectWorkinghours(Double expectWorkinghours) {
		this.expectWorkinghours = expectWorkinghours;
	}

	public Integer getIsHost() {
		return isHost;
	}

	public void setIsHost(Integer isHost) {
		this.isHost = isHost;
	}

	public String getCautionDate() {
		return cautionDate;
	}

	public void setCautionDate(String cautionDate) {
		this.cautionDate = cautionDate;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	private Integer version;
	
    public String getStayWareHouseDate() {
		return stayWareHouseDate;
	}

	public void setStayWareHouseDate(String stayWareHouseDate) {
		this.stayWareHouseDate = stayWareHouseDate;
	}

	public Integer getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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

	public String getCarClassify() {
		return carClassify;
	}

	public void setCarClassify(String carClassify) {
		this.carClassify = carClassify;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String barnd) {
		this.brand = barnd;
	}

	public Integer getTypeLive() {
		return typeLive;
	}

	public void setTypeLive(Integer typeLive) {
		this.typeLive = typeLive;
	}
    
    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getCarClassifyId() {
        return carClassifyId;
    }

    public void setCarClassifyId(String carClassifyId) {
        this.carClassifyId = carClassifyId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getConstructionNode() {
        return constructionNode;
    }

    public void setConstructionNode(Integer constructionNode) {
        this.constructionNode = constructionNode;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Double getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(Double workinghours) {
        this.workinghours = workinghours;
    }

    public Integer getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(Integer safetyStock) {
        this.safetyStock = safetyStock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsShelf() {
        return isShelf;
    }

    public void setIsShelf(Integer isShelf) {
        this.isShelf = isShelf;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public Date getLastPushTime() {
        return lastPushTime;
    }

    public void setLastPushTime(Date lastPushTime) {
        this.lastPushTime = lastPushTime;
        if(lastPushTime != null){
        	long stay = System.currentTimeMillis() - lastPushTime.getTime();
        	int date = Long.valueOf(stay / 86400000).intValue();
        	this.stayWareHouseDate =  (date + 1) + "天";
        }
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}