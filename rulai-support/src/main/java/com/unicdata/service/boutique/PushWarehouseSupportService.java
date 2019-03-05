package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.condition.PushWareHouseCondition;
import com.unicdata.entity.boutique.BoutiquePushWarehouse;
import com.unicdata.entity.boutique.BoutiquePushWarehouseDetail;

public interface PushWarehouseSupportService extends BoutiquePushWarehouseService{

	public int insert(BoutiquePushWarehouse info);

	/**
	 * 分页条件查询精品入库
	 * @param condition
	 * @return
	 */
	public PageInfo<Map<String, Object>> selectPushWarehouseByCondition(PushWareHouseCondition condition);
	
	/**
	 * 根据入库id，查询入库精品详情
	 * @param condition
	 * @return
	 */
	public List<BoutiquePushWarehouseDetail> selectPushWarehouseById(PushWareHouseCondition condition);

}
