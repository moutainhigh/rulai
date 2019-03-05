package com.unicdata.service.car.impl;

import com.unicdata.dao.boutique.CarWashMapper;
import com.unicdata.entity.boutique.CarWash;
import com.unicdata.entity.boutique.CarWashExample;
import com.unicdata.service.car.AppCarWashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/7.
 */
@Service
public class AppCarWashServiceImpl implements AppCarWashService {
    @Autowired
    private CarWashMapper carWashMapper;

    @Override
    public List<CarWash> selectByExample(CarWashExample example) {
        return carWashMapper.selectByExample(example);
    }

    @Override
    public List<Map<String, Object>> selectCarWashList(Map<String, Object> map) {
        List<Map<String, Object>> mapList = carWashMapper.selectCarWashList(map);
        for (Map<String, Object> objectMap : mapList) {
            Object o = objectMap.get("begin_time");
            if (o != null) {
                String format1 = o.toString();
                objectMap.put("begin_time", format1.substring(0, 10));
            } else {
                objectMap.put("begin_time", "");
            }
            Object a = objectMap.get("apply_time");
            if (a != null) {
                String format2 = a.toString();
                objectMap.put("apply_time", format2.substring(0, 10));
            } else {
                objectMap.put("apply_time", "");
            }
            Object b = objectMap.get("end_time");
            if (b != null) {
                String format3 = b.toString();
                objectMap.put("end_time", format3.substring(0, 10));
            } else {
                objectMap.put("end_time", "");
            }
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> selectMouthCarWashSum(Map<String, Object> map) {
        return carWashMapper.selectMouthCarWashSum(map);
    }

    @Override
    public int countByExample(CarWashExample example) {
        return carWashMapper.countByExample(example);
    }

    @Override
    public int countByToDay(CarWash record) {
        return carWashMapper.countByToDay(record);
    }
}
