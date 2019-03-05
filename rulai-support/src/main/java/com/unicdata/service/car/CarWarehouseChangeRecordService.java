package com.unicdata.service.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarWarehouseChangeRecord;

/**
 * 车辆库存更改操作表
 * 
 * @author wxn
 * @date 2018年6月3日
 */
public interface CarWarehouseChangeRecordService {
	int insertSelective(CarWarehouseChangeRecord record);

	CarWarehouseChangeRecord selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarWarehouseChangeRecord record);

	int updateByPrimaryKeyWithBLOBs(CarWarehouseChangeRecord record);

	PageInfo<Map<String, Object>> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum);

	List<Map<String, Object>> selectByRecordId(Integer id);
}
