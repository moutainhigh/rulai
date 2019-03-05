package com.unicdata.service.car.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarTestInfoMapper;
import com.unicdata.entity.car.CarTestInfo;
import com.unicdata.service.car.CarTestInfoService;

@Service
public class CarTestInfoServiceImpl implements CarTestInfoService {

	@Autowired
	private CarTestInfoMapper carTestInfoMapper;

	public int insertSelective(CarTestInfo record){
		return carTestInfoMapper.insertSelective(record);
	}

	public CarTestInfo selectByPrimaryKey(Integer id){
		return carTestInfoMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CarTestInfo record){
		return carTestInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public PageInfo<Map<String, Object>> selectListByStore(Integer distributorId, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		return carTestInfoMapper.selectListByStore(distributorId).toPageInfo();
	}
}
