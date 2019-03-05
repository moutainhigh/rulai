package com.unicdata.service.car.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarTestInfoMapper;
import com.unicdata.entity.car.CarTestInfo;
import com.unicdata.service.car.AppCarTestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AppCarTestInfoServiceImpl implements AppCarTestInfoService {

    @Autowired
    private CarTestInfoMapper carTestInfoMapper;

    public int insertSelective(CarTestInfo record) {
        return carTestInfoMapper.insertSelective(record);
    }

    public CarTestInfo selectByPrimaryKey(Integer id) {
        return carTestInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(CarTestInfo record) {
        return carTestInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<Map<String, Object>> selectListByStore(Integer distributorId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return carTestInfoMapper.selectListByStore(distributorId).toPageInfo();
    }

    @Override
    public Page<Map<String, Object>> selectTestCarList(Map<String, Object> map) {
        return carTestInfoMapper.selectTestCarList(map);
    }
}
