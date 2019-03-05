package com.unicdata.service.car;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarPurchaseOrder;

/**
 * 车辆采购单
 * 
 * @author wxn
 * @date 2018年6月1日
 */
public interface CarPurchaseOrderService {
	int insertSelective(CarPurchaseOrder record);

	CarPurchaseOrder selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarPurchaseOrder record);

	PageInfo<Map<String, Object>> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum);
}
