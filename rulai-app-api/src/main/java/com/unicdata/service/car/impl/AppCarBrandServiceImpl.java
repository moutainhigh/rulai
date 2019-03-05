package com.unicdata.service.car.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarBrandMapper;
import com.unicdata.entity.car.CarBrand;
import com.unicdata.service.car.AppCarBrandService;

@Service
public class AppCarBrandServiceImpl implements AppCarBrandService {

    @Autowired
    private CarBrandMapper carBrandMapper;

	@Override
	public PageInfo<CarBrand> selectListByStore(Integer storeId, Integer pageSize, Integer pageNum) {
		if(null != pageSize && null != pageSize){
			PageHelper.startPage(pageNum, pageSize);
		}
		return carBrandMapper.selectListByStore(storeId).toPageInfo();
	}

}
