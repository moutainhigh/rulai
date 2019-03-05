package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarWarehouseChangeRecord;

public interface CarWarehouseChangeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarWarehouseChangeRecord record);

    int insertSelective(CarWarehouseChangeRecord record);

    CarWarehouseChangeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarWarehouseChangeRecord record);

    int updateByPrimaryKeyWithBLOBs(CarWarehouseChangeRecord record);

    int updateByPrimaryKey(CarWarehouseChangeRecord record);

	Page<Map<String, Object>> selectListByStore(Integer distributorStoreId);

	List<Map<String, Object>> selectByRecordId(Integer id);
}