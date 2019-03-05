package com.unicdata.service.car.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarBrandMapper;
import com.unicdata.entity.car.CarBrand;
import com.unicdata.service.car.CarBrandService;

@Service
public class CarBrandServiceImpl implements CarBrandService {

	@Autowired
	private CarBrandMapper carBrandMapper;

	public int insertSelective(CarBrand record) {
		return carBrandMapper.insertSelective(record);
	}

	public CarBrand selectByPrimaryKey(Integer id) {
		return carBrandMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CarBrand record) {
		return carBrandMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public PageInfo<CarBrand> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum) {
		if(null != pageSize && null != pageSize){
			PageHelper.startPage(pageNum, pageSize);
		}
		return carBrandMapper.selectListByStore(distributorStoreId).toPageInfo();
	}

	@Override
	public CarBrand selectByName(Integer storeId, String name, String factoryName) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("name", name);
		params.put("factoryName", factoryName);
		return carBrandMapper.selectByName(params);
	}

}
