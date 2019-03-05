package com.unicdata.dao.boutique;

import com.github.pagehelper.Page;
import com.unicdata.condition.OutboundCondition;
import com.unicdata.entity.boutique.BoutiqueOutbound;
import com.unicdata.entity.boutique.BoutiqueOutboundExample;
import java.util.List;
import java.util.Map;

public interface BoutiqueOutboundMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueOutbound record);

    int insertSelective(BoutiqueOutbound record);

    List<BoutiqueOutbound> selectByExample(BoutiqueOutboundExample example);

    BoutiqueOutbound selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueOutbound record);

    int updateByPrimaryKey(BoutiqueOutbound record);

	Page<Map<String, Object>> selectOutboundByCondition(OutboundCondition condition);

	BoutiqueOutbound outboundPickingById(Integer id);

	int insertUseGeneratedKeys(BoutiqueOutbound outbound);
}