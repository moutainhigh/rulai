package com.unicdata.service.boutique.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.base.util.DateUtil;
import com.unicdata.dao.boutique.BoutiqueWarehouseMapper;
import com.unicdata.dao.counter.CounterMapper;
import com.unicdata.entity.boutique.BoutiqueWarehouse;
import com.unicdata.entity.counter.Counter;
import com.unicdata.service.CounterService;
import com.unicdata.service.boutique.BoutiqueWarehouseService;
@Service
public class BoutiqueWarehouseServiceImpl implements BoutiqueWarehouseService {

	@Autowired
	private BoutiqueWarehouseMapper warehouseMapper;
	
	@Autowired
	private CounterMapper counterMapper;
	
	@Autowired
	private CounterService counterService;
	
	@Override
	public int add(BoutiqueWarehouse warehouse) {
//		Integer code = counterMapper.findCounterCode("JPCK");
//		warehouse.setNum("JPCK-" + code);
//		counterMapper.updCounterCode("JPCK");
		
		String code = counterService.generateCode(Counter.BOUTIQUE_WAREHOUSE, null, 1);
		warehouse.setNum(code);
		int insert = warehouseMapper.insert(warehouse);
		return insert;
	}

	@Override
	public int deleteById(Integer id) {
		return	warehouseMapper.deleteById(id);
	}

	@Override
	public int update(BoutiqueWarehouse warehouse) {
		return warehouseMapper.updateByPrimaryKeySelective(warehouse);
	}

	@Override
	public List<BoutiqueWarehouse> findAll(Integer storeId) {
		List<BoutiqueWarehouse> list = warehouseMapper.findAll(storeId);
		return list;
	}

	@Override
	public BoutiqueWarehouse selectByPrimaryKey(Integer id) {
		BoutiqueWarehouse warehouse = null;
		if(id != null && id > 0){
			warehouse = warehouseMapper.selectByPrimaryKey(id);
		}
		return warehouse;
	}

}
