package com.unicdata.service.car.impl;

import com.unicdata.dao.car.CarBoutiqueBindingMapper;
import com.unicdata.entity.car.CarBoutiqueBinding;
import com.unicdata.service.car.AppCarBoutiqueBindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AppCarBoutiqueBindingServiceImpl implements AppCarBoutiqueBindingService {

    @Autowired
    private CarBoutiqueBindingMapper carBoutiqueBindingMapper;

    public int insertSelective(CarBoutiqueBinding record) {
        return carBoutiqueBindingMapper.insertSelective(record);
    }

    public CarBoutiqueBinding selectByPrimaryKey(Integer id) {
        return carBoutiqueBindingMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(CarBoutiqueBinding record) {
        return carBoutiqueBindingMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Map<String, Object>> selectByCarId(Integer carId) {
        return carBoutiqueBindingMapper.selectByCarId(carId);
    }

}
