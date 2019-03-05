package com.unicdata.dao.boutique;

import com.github.pagehelper.Page;
import com.unicdata.entity.boutique.BoutiqueRetailRecord;
import com.unicdata.entity.boutique.BoutiqueRetailRecordExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BoutiqueRetailRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueRetailRecord record);

    int insertSelective(BoutiqueRetailRecord record);

    List<BoutiqueRetailRecord> selectByExample(BoutiqueRetailRecordExample example);

    BoutiqueRetailRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueRetailRecord record);

    int updateByPrimaryKey(BoutiqueRetailRecord record);

	int insertUseGeneratedKeys(BoutiqueRetailRecord record);
	
	/**
	 * 
	 * @param retailId 精品订单id
	 * @param isDivision 是否进行价格划分( 0 - 未划分 ； 1 - 已划分)
	 */
	void updateByRetailId(@Param("retailId")int retailId, @Param("isDivision")int isDivision);

	Page<Map<String, Object>> getBoutiqueRetailRecordByStoreIdPage(Map<String, Object> retail);

	List<BoutiqueRetailRecord> selectRecordByRetailId(@Param("retailId")Integer retailId);
}