package com.unicdata.service.car;

import com.unicdata.entity.boutique.CarWash;
import com.unicdata.entity.boutique.CarWashExample;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/7.
 */
public interface AppCarWashService {
    List<CarWash> selectByExample(CarWashExample example);

    /**
     * 洗车分页
     * @param map
     * @return
     */
    List<Map<String, Object>> selectCarWashList(Map<String,Object> map);

    /**
     * 洗车数统计
     * @param map
     * @return
     */
    List<Map<String, Object>> selectMouthCarWashSum(Map<String,Object> map);

    int countByExample(CarWashExample example);

    int countByToDay(CarWash record);
}
