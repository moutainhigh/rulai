package com.unicdata.service.car;

import com.unicdata.entity.car.CarColor;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/4.
 */
public interface AppCarColorService {
    /**
     * 通过车系id查询颜色
     * @param familyId
     * @return
     */
    List<CarColor> selectByFamilyId(Integer familyId);
    /**
     * 查颜色 wp
     * @param map
     * @return
     */
  	List<Map<String, Object>> selectColorOutIn(Map<String, Object> map);
    
}
