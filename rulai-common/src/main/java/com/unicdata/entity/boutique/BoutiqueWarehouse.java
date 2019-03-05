package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品仓库表")
public class BoutiqueWarehouse implements Serializable{

	private static final long serialVersionUID = 5234316127820422922L;

	@ApiModelProperty(value = "精品仓库Id")
    private Integer id;
	@ApiModelProperty(value = "仓库编号")
    private String num;
	@ApiModelProperty(value = "仓库名称")
    private String name;
	
    private Integer storeId;

    private Integer typeLive;

    
    private List<BoutiqueWarehousePosition> list = new ArrayList<BoutiqueWarehousePosition>();
    
    private Map<String, BoutiqueWarehousePosition> posMap = new HashMap<String, BoutiqueWarehousePosition>();
    
    public Map<String, BoutiqueWarehousePosition> getPosMap() {
		return posMap;
	}

	public void setPosMap(Map<String, BoutiqueWarehousePosition> posMap) {
		this.posMap = posMap;
	}

	public List<BoutiqueWarehousePosition> getList() {
		return list;
	}

	public void setList(List<BoutiqueWarehousePosition> list) {
		this.list = list;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}