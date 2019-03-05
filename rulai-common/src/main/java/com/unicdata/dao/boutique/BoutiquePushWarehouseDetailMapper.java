package com.unicdata.dao.boutique;

import com.unicdata.condition.PushWareHouseCondition;
import com.unicdata.entity.boutique.BoutiquePushWarehouseDetail;
import com.unicdata.entity.boutique.BoutiquePushWarehouseDetailExample;
import java.util.List;

public interface BoutiquePushWarehouseDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiquePushWarehouseDetail record);

    int insertSelective(BoutiquePushWarehouseDetail record);

    List<BoutiquePushWarehouseDetail> selectByExample(BoutiquePushWarehouseDetailExample example);

    BoutiquePushWarehouseDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiquePushWarehouseDetail record);

    int updateByPrimaryKey(BoutiquePushWarehouseDetail record);

	List<BoutiquePushWarehouseDetail> selectPushWarehouseById(PushWareHouseCondition condition);
}