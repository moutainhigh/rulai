package com.unicdata.service.car.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarAllotApplicationMapper;
import com.unicdata.entity.car.CarAllotApplication;
import com.unicdata.service.car.CarAllotApplicationService;

@Service
public class CarAllotApplicationServiceImpl implements CarAllotApplicationService {

	@Autowired
	private CarAllotApplicationMapper allotApplicationMapper;

	@Override
	public int insertSelective(CarAllotApplication record) {
		return allotApplicationMapper.insertSelective(record);
	}

	@Override
	public CarAllotApplication selectByPrimaryKey(Integer id) {
		return allotApplicationMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CarAllotApplication record) {
		return allotApplicationMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(CarAllotApplication record) {
		return allotApplicationMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public PageInfo<Map<String, Object>> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		return allotApplicationMapper.selectListByStore(distributorStoreId).toPageInfo();
	}

}
