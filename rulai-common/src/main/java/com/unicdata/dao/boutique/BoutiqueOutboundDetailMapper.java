package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueOutboundDetail;
import com.unicdata.entity.boutique.BoutiqueOutboundDetailExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BoutiqueOutboundDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueOutboundDetail record);

    int insertSelective(BoutiqueOutboundDetail record);

    List<BoutiqueOutboundDetail> selectByExample(BoutiqueOutboundDetailExample example);

    BoutiqueOutboundDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueOutboundDetail record);

    int updateByPrimaryKey(BoutiqueOutboundDetail record);

	List<BoutiqueOutboundDetail> detialPickingByOutboundId(Integer id);

	int updateStatus(@Param("id")Integer id);

	Map<String, Integer> selectCountOutbound(@Param("outboundId")Integer outboundId);

	void insertBatch(List<BoutiqueOutboundDetail> allDetail);
}