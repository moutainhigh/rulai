package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueRetailIncludePackDivision;
import com.unicdata.entity.boutique.BoutiqueRetailIncludePackDivisionExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoutiqueRetailIncludePackDivisionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueRetailIncludePackDivision record);

    int insertSelective(BoutiqueRetailIncludePackDivision record);

    List<BoutiqueRetailIncludePackDivision> selectByExample(BoutiqueRetailIncludePackDivisionExample example);

    BoutiqueRetailIncludePackDivision selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueRetailIncludePackDivision record);

    int updateByPrimaryKey(BoutiqueRetailIncludePackDivision record);

	BoutiqueRetailIncludePackDivision selectByIncludeIdAndBoutiqueId(@Param("retailId")Integer retailId, @Param("boutiqueId")Integer boutiqueId);
}