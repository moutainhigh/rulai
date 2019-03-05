package com.unicdata.service.car.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarOutApplicationMapper;
import com.unicdata.entity.car.CarOutApplication;
import com.unicdata.service.car.CarOutApplicationService;

import java.util.List;
import java.util.Map;

@Service
public class CarOutApplicationServiceImpl implements CarOutApplicationService {
    @Autowired
    private CarOutApplicationMapper carOutApplicationMapper;

    @Override
    public int insertSelective(CarOutApplication record) {
        return carOutApplicationMapper.insertSelective(record);
    }

    @Override
    public CarOutApplication selectByPrimaryKey(Integer id) {
        return carOutApplicationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CarOutApplication record) {
        return carOutApplicationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(CarOutApplication record) {
        return carOutApplicationMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public PageInfo<CarOutApplication> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return carOutApplicationMapper.selectListByStore(distributorStoreId).toPageInfo();
    }

    @Override
    public PageInfo<CarOutApplication> selectListByParam(Map param, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return carOutApplicationMapper.selectListByParam(param).toPageInfo();
    }

    @Override
    public PageInfo<Map<String, Object>> listCreateBy(Map param, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return carOutApplicationMapper.listCreateBy(param).toPageInfo();
    }

}
