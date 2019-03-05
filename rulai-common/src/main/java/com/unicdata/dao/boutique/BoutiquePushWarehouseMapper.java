package com.unicdata.dao.boutique;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.condition.PushWareHouseCondition;
import com.unicdata.entity.boutique.BoutiquePushWarehouse;
import com.unicdata.entity.boutique.BoutiquePushWarehouseExample;

public interface BoutiquePushWarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiquePushWarehouse record);

    int insertSelective(BoutiquePushWarehouse record);

    List<BoutiquePushWarehouse> selectByExample(BoutiquePushWarehouseExample example);

    BoutiquePushWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiquePushWarehouse record);

    int updateByPrimaryKey(BoutiquePushWarehouse record);
    
    /**
     * 添加并返回id
     * @param info
     * @return
     */
	int insertuseGeneratedKeys(BoutiquePushWarehouse info);

	Page<Map<String, Object>> selectPushWarehouseByCondition(PushWareHouseCondition condition);
}