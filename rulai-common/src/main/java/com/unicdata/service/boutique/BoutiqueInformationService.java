package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.condition.BoutiqueInfoCondition;
import com.unicdata.entity.boutique.BoutiqueInformation;

public interface BoutiqueInformationService {

    public int insert(BoutiqueInformation record);

    public int insertSelective(BoutiqueInformation record);
    
    /**
     * 根据id删除精品基础信息 。 将type_live设置为0
     * @param id
     * @return
     */
    public int deleteById(Integer id);
    
	/**
	 * 修改信息
	 * @param info
	 * @return
	 */
    public int update(BoutiqueInformation info);
    
    /**
     * 条件分页查询精品信息
     * @param code
     * @param name
     * @param pageSize
     * @param pageNum
     * @return
     */
    public PageInfo<Map<String, Object>> selectBoutiqueInfoByConditionPage(BoutiqueInfoCondition condition,Integer storeId);
	
    /**
     * 根据id查询精品信息
     * @param id
     * @param storeId
     * @return
     */
    public BoutiqueInformation selectBoutiqueInfoById(Integer id, Integer storeId);
    
    /**
     * 精品上架、下架
     * @param info
     * @return
     */
    public int updateBoutiqueStatus(BoutiqueInformation info);
    
    public List<BoutiqueInformation> selectBoutiqueInfoListByCondition(BoutiqueInfoCondition condition, Integer storeId);
}
