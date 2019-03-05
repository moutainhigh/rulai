package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueUnit;
import com.unicdata.entity.boutique.BoutiqueUnitExample;
import java.util.List;

public interface BoutiqueUnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueUnit record);

    int insertSelective(BoutiqueUnit record);

    List<BoutiqueUnit> selectByExample(BoutiqueUnitExample example);

    BoutiqueUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueUnit record);

    int updateByPrimaryKey(BoutiqueUnit record);

	List<BoutiqueUnit> selectBoutiqueUnitList();
}