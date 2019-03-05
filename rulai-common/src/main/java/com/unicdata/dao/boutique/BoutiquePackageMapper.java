package com.unicdata.dao.boutique;

import com.github.pagehelper.Page;
import com.unicdata.condition.BoutiquePackageCondition;
import com.unicdata.entity.boutique.BoutiquePackage;
import com.unicdata.entity.boutique.BoutiquePackageExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BoutiquePackageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiquePackage record);

    int insertSelective(BoutiquePackage record);

    List<BoutiquePackage> selectByExample(BoutiquePackageExample example);

    BoutiquePackage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiquePackage record);

    int updateByPrimaryKey(BoutiquePackage record);

	int insertUseGeneratedKeys(BoutiquePackage packageInfo);

	Page<Map<String, Object>> selectPackageByCondition(BoutiquePackageCondition condition);

	int updatePackageInfoDrop(@Param("id")Integer id,@Param("status")Integer status);
	
	List<Map<String, Object>> selectPackageByMap(Map<String, Object> params);
}