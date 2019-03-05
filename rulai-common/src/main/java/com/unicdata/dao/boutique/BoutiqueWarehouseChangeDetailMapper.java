package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueWarehouseChangeDetail;
import com.unicdata.entity.boutique.BoutiqueWarehouseChangeDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoutiqueWarehouseChangeDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueWarehouseChangeDetail record);

    int insertSelective(BoutiqueWarehouseChangeDetail record);

    List<BoutiqueWarehouseChangeDetail> selectByExample(BoutiqueWarehouseChangeDetailExample example);

    BoutiqueWarehouseChangeDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueWarehouseChangeDetail record);

    int updateByPrimaryKey(BoutiqueWarehouseChangeDetail record);

    /**
     * 批量插入
     * @param detailList
     */
	void insertBatch(List<BoutiqueWarehouseChangeDetail> detailList);

	List<BoutiqueWarehouseChangeDetail> selectDetailByChangeId(@Param("changeId")Integer changeId);
}