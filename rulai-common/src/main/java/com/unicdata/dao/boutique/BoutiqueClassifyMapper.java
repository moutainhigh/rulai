package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueClassify;
import com.unicdata.entity.boutique.BoutiqueClassifyExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoutiqueClassifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueClassify record);

    int insertSelective(BoutiqueClassify record);

    List<BoutiqueClassify> selectByExample(BoutiqueClassifyExample example);

    BoutiqueClassify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueClassify record);

    int updateByPrimaryKey(BoutiqueClassify record);

	int updateParent(@Param("parentId")Integer parentId);

	List<BoutiqueClassify> selectBoutiqueClassifyAll(@Param("storeId")Integer storeId);

	int deleteById(@Param("id")Integer id);

	List<BoutiqueClassify> selectBoutiqueClassifyByLevel(@Param("level")Integer level, @Param("parentId")Integer parentId);

	List<BoutiqueClassify> selectBoutiqueClassifyAllType(@Param("storeId")Integer storeId);

	List<BoutiqueClassify> selectSonClassifyLiveByParentId(@Param("parentId")Integer parentId);

	void updateClassifyUse(@Param("id")Integer id);

	void updateClassifyNotUse(@Param("id")Integer id);

	BoutiqueClassify selectClassifyByCode(@Param("storeId")Integer storeId,@Param("code")String code,@Param("classify") String classify);

	Integer selectCountByLevelAndCode4Add(BoutiqueClassify classify);

	Integer selectCountByLevelAndCode4Update(BoutiqueClassify classify);
}