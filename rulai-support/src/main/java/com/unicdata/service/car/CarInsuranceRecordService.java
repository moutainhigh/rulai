package com.unicdata.service.car;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarInsuranceRecord;
/**
 * 试驾车保险记录
 * @author wxn
 * @date 2018年6月3日
 */
public interface CarInsuranceRecordService {
    int insertSelective(CarInsuranceRecord record);

    CarInsuranceRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarInsuranceRecord record);
    
    List<Map<String, Object>> selectListByTestCar(Integer testCarId);
}
