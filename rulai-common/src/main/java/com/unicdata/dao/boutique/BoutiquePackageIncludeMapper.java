package com.unicdata.dao.boutique;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.unicdata.entity.boutique.BoutiquePackageInclude;
import com.unicdata.entity.boutique.BoutiquePackageIncludeExample;

public interface BoutiquePackageIncludeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiquePackageInclude record);

    int insertSelective(BoutiquePackageInclude record);

    List<BoutiquePackageInclude> selectByExample(BoutiquePackageIncludeExample example);

    BoutiquePackageInclude selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiquePackageInclude record);

    int updateByPrimaryKey(BoutiquePackageInclude record);
    
    List<Map<String,Object>> selectBoutiquePackageDetailByPid(Integer packageId);

	List<BoutiquePackageInclude> selectByPackageId(@Param("packageId")Integer packageId);

	BigDecimal sumPackageCountValue(@Param("packageId")Integer packageId);
}