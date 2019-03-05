package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueTarget;
import com.unicdata.entity.boutique.BoutiqueTargetExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BoutiqueTargetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueTarget record);

    int insertSelective(BoutiqueTarget record);

    List<BoutiqueTarget> selectByExample(BoutiqueTargetExample example);

    BoutiqueTarget selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueTarget record);

    int updateByPrimaryKey(BoutiqueTarget record);

    List<BoutiqueTarget> getBoutiqueTargetByStoreId(Map<String,Object> map);

    List<BoutiqueTarget> selectBoutiqueTargetSum(Map<String,Object> map);

	List<BoutiqueTarget> selectTargetByYear(@Param("year")String year, @Param("storeId")Integer storeId);

	void insertBatch(@Param("list")List<BoutiqueTarget> list);

	void updateBatch(@Param("list")List<BoutiqueTarget> list);

	int deleteTargetById(@Param("id")Integer id);
}