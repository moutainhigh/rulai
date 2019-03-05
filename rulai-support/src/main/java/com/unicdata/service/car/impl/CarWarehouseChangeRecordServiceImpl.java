package com.unicdata.service.car.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarWarehouseChangeRecordMapper;
import com.unicdata.entity.car.CarWarehouseChangeRecord;
import com.unicdata.service.car.CarWarehouseChangeRecordService;

@Service
public class CarWarehouseChangeRecordServiceImpl implements CarWarehouseChangeRecordService {

	@Autowired
	private CarWarehouseChangeRecordMapper carWarehouseChangeRecordMapper;

	@Override
	public int insertSelective(CarWarehouseChangeRecord record) {
		return carWarehouseChangeRecordMapper.insertSelective(record);
	}

	@Override
	public CarWarehouseChangeRecord selectByPrimaryKey(Integer id) {
		return carWarehouseChangeRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CarWarehouseChangeRecord record) {
		return carWarehouseChangeRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(CarWarehouseChangeRecord record) {
		return carWarehouseChangeRecordMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public PageInfo<Map<String, Object>> selectListByStore(Integer distributorStoreId, Integer pageSize,
			Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		return carWarehouseChangeRecordMapper.selectListByStore(distributorStoreId).toPageInfo();
	}

	@Override
	public List<Map<String, Object>> selectByRecordId(Integer id) {
		return carWarehouseChangeRecordMapper.selectByRecordId(id);
	}
}
