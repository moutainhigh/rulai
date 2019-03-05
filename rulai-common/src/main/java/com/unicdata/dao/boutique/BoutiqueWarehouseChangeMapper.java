package com.unicdata.dao.boutique;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.condition.WareHouseChangeCondition;
import com.unicdata.entity.boutique.BoutiqueWarehouseChange;
import com.unicdata.entity.boutique.BoutiqueWarehouseChangeExample;

public interface BoutiqueWarehouseChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueWarehouseChange record);

    int insertSelective(BoutiqueWarehouseChange record);

    List<BoutiqueWarehouseChange> selectByExample(BoutiqueWarehouseChangeExample example);

    BoutiqueWarehouseChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueWarehouseChange record);

    int updateByPrimaryKey(BoutiqueWarehouseChange record);

	int insertUseGeneratedKeys(BoutiqueWarehouseChange wareHouseChange);

	Page<Map<String, Object>> selectBoutiqueWareHouseChangePage(WareHouseChangeCondition condition);
}