package com.unicdata.service.car.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.condition.CarCheckConditon;
import com.unicdata.dao.car.CarDepotCheckMapper;
import com.unicdata.service.car.CarDepotCheckService;

@Service
public class CarDepotCheckServiceImpl implements CarDepotCheckService {

	@Autowired
	private CarDepotCheckMapper carDepotCheckMapper;

	@Override
	public PageInfo<Map<String, Object>> selectListByStore(CarCheckConditon carCheckConditon) {
		PageHelper.startPage(carCheckConditon.getPageNum(), carCheckConditon.getPageSize());
		return carDepotCheckMapper.selectListByStore(carCheckConditon).toPageInfo();
	}

	@Override
	public List<String> selectWarehouseByNumber(String number) {
		return carDepotCheckMapper.selectWarehouseByNumber(number);
	}

	@Override
	public List<Map<String, Object>> selectCarByNumber(Integer storeId, String number) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("number", number);
		return carDepotCheckMapper.selectCarByNumber(params);
	}

}
