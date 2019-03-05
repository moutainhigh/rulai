package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品分类")
public class BoutiqueClassify implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "精品分类Id")
	private Integer id;
	@ApiModelProperty(value = "分类名称")
    private String classify;
	@ApiModelProperty(value = "级别(第几级菜单）")
    private Integer level;
	@ApiModelProperty(value = "是否存在下级菜单( 0 不存在 ； 1 存在)")
    private Integer haveSon;
	@ApiModelProperty(value = "父级菜单id")
    private Integer parentId;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;
	@ApiModelProperty(value = "类别编码")
    private String code;
	
	private Integer classifyUse;
	@ApiModelProperty(value = "包含的子级菜单")
	private List<BoutiqueClassify> sons ;
    
    private Integer typeLive;

    
    private String parentCode;
    private String parentName;
    
    public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Integer getClassifyUse() {
		return classifyUse;
	}

	public void setClassifyUse(Integer classifyUse) {
		this.classifyUse = classifyUse;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getTypeLive() {
		return typeLive;
	}

	public void setTypeLive(Integer typeLive) {
		this.typeLive = typeLive;
	}
    public List<BoutiqueClassify> getSons() {
		return sons;
	}

	public void setSons(List<BoutiqueClassify> sons) {
		this.sons = sons;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getHaveSon() {
        return haveSon;
    }

    public void setHaveSon(Integer haveSon) {
        this.haveSon = haveSon;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}