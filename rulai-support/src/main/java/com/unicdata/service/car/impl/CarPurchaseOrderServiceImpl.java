package com.unicdata.service.car.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarPurchaseOrderMapper;
import com.unicdata.entity.car.CarPurchaseOrder;
import com.unicdata.service.car.CarPurchaseOrderService;

@Service
public class CarPurchaseOrderServiceImpl implements CarPurchaseOrderService{

	@Autowired
	private CarPurchaseOrderMapper carPurchaseOrderMapper;
	
	public int insertSelective(CarPurchaseOrder record){
		return carPurchaseOrderMapper.insertSelective(record);
	}

    public CarPurchaseOrder selectByPrimaryKey(Integer id){
		return carPurchaseOrderMapper.selectByPrimaryKey(id);
	}

    public int updateByPrimaryKeySelective(CarPurchaseOrder record){
		return carPurchaseOrderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public PageInfo<Map<String, Object>> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		return carPurchaseOrderMapper.selectListByStore(distributorStoreId).toPageInfo();
	}
}
