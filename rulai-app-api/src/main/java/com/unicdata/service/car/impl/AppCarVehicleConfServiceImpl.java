package com.unicdata.service.car.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarVehicleConfMapper;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.service.car.AppCarVehicleConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AppCarVehicleConfServiceImpl implements AppCarVehicleConfService {

    @Autowired
    private CarVehicleConfMapper carVehicleConfMapper;

    public int insertSelective(CarVehicleConf record) {
        return carVehicleConfMapper.insertSelective(record);
    }

    public CarVehicleConf selectByPrimaryKey(Integer id) {
        return carVehicleConfMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(CarVehicleConf record) {
        return carVehicleConfMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Map<String, Object>> selectListByBrandId(Map<String, Object> params, Integer pageSize, Integer pageNum) {
        if (null != pageSize && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Page<Map<String, Object>> maps1 = new Page<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("carVehicleName", "默认");
        objectHashMap.put("id", "0");
        maps1.add(0, objectHashMap);
        Page<Map<String, Object>> maps = carVehicleConfMapper.selectListByBrandId(params);
        maps1.addAll(maps);
        return maps1.toPageInfo();
    }

}
