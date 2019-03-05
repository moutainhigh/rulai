package com.unicdata.service.boutique.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.boutique.BoutiqueWarehousePositionMapper;
import com.unicdata.entity.boutique.BoutiqueWarehousePosition;
import com.unicdata.service.boutique.BoutiqueWarehousePositionService;
@Service
public class BoutiqueWarehousePositionServiceImpl implements BoutiqueWarehousePositionService {

	@Autowired
	private BoutiqueWarehousePositionMapper  warehousePositionMapper;
	
	@Override
	public int add(BoutiqueWarehousePosition warehousePosition) {
		return warehousePositionMapper.insert(warehousePosition);
	}

	@Override
	public int deleteById(Integer id) {
		return warehousePositionMapper.deleteById(id);
	}

	@Override
	public int deleteByWarehouseId(Integer warehouseId) {
		return warehousePositionMapper.deleteByWarehouseId(warehouseId);
	}

	@Override
	public int update(BoutiqueWarehousePosition warehousePosition) {
		return warehousePositionMapper.updateByPrimaryKeySelective(warehousePosition);
	}

	@Override
	public List<BoutiqueWarehousePosition> findAllByWarehouseId(Integer warehouseId,Integer storeId) {
		return warehousePositionMapper.findAllByWarehouseId(warehouseId,storeId);
	}

	@Override
	public PageInfo<Map<String, Object>> selectWarehousePositionAllPage(Integer warehouseId, Integer storeId,Integer pageSize,Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		return warehousePositionMapper.selectWarehousePositionAllPage(warehouseId,storeId).toPageInfo();
	}

}
