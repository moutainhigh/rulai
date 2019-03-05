package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueReconciliation;
import com.unicdata.entity.boutique.BoutiqueReconciliationExample;
import java.util.List;

public interface BoutiqueReconciliationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueReconciliation record);

    int insertSelective(BoutiqueReconciliation record);

    List<BoutiqueReconciliation> selectByExample(BoutiqueReconciliationExample example);

    BoutiqueReconciliation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueReconciliation record);

    int updateByPrimaryKey(BoutiqueReconciliation record);
}