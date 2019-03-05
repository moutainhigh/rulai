package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueTargetGroup;
import com.unicdata.entity.boutique.BoutiqueTargetGroupExample;
import java.util.List;

public interface BoutiqueTargetGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueTargetGroup record);

    int insertSelective(BoutiqueTargetGroup record);

    List<BoutiqueTargetGroup> selectByExample(BoutiqueTargetGroupExample example);

    BoutiqueTargetGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueTargetGroup record);

    int updateByPrimaryKey(BoutiqueTargetGroup record);

	List<BoutiqueTargetGroup> selectAllGroup();
}