package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueRetailInclude;
import com.unicdata.entity.boutique.BoutiqueRetailIncludeExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BoutiqueRetailIncludeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueRetailInclude record);

    int insertSelective(BoutiqueRetailInclude record);

    List<BoutiqueRetailInclude> selectByExample(BoutiqueRetailIncludeExample example);

    BoutiqueRetailInclude selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueRetailInclude record);

    int updateByPrimaryKey(BoutiqueRetailInclude record);

	List<Map<String, Object>> selectListByRetail(Integer retailId);
	
	int insertBatch(List<Map<String, Object>> list);
	int updateBatch(List<Map<String, Object>> list);
	int updateRetailInclude(BoutiqueRetailInclude record);

	List<BoutiqueRetailInclude> selectListByRetailId(@Param("retailId")Integer retailId);

	List<BoutiqueRetailInclude> selectAllByRetailId(@Param("retailId")Integer retailId);

	void updateRetailDivisionById(@Param("id")Integer id, @Param("divisionValue")BigDecimal divisionValue);
	
	int deleteByMap(Map<String, Object> params);
	
	List<Map<String, Object>> getBoutiquePackageByMap(Map<String, Object> params);
	
	BigDecimal calcBoutiqueSumByRetailId(Map<String, Object> params);

	List<Integer> selectRetailPackageId(@Param("retailId")Integer retailId);

}