package com.unicdata.service.car.impl;

import com.unicdata.dao.car.CarColorMapper;
import com.unicdata.entity.car.CarColor;
import com.unicdata.service.car.AppCarColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/4.
 */
@Service
public class AppCarColorServiceImpl implements AppCarColorService {
    @Autowired
    CarColorMapper carColorMapper;

    @Override
    public List<CarColor> selectByFamilyId(Integer familyId) {
        ArrayList<CarColor> carColors1 = new ArrayList<>();
        CarColor carColor = new CarColor();
        carColor.setName("默认");
        carColors1.add(0, carColor);
        List<CarColor> carColors = carColorMapper.selectColorByFamily(familyId);
        carColors1.addAll(carColors);
        return carColors1;
    }

    /**
     * 查颜色
     */
	@Override
	public List<Map<String, Object>> selectColorOutIn(Map<String, Object> map) {
		return carColorMapper.selectColorOutIn(map);
		
	}
}
