package com.unicdata.service.car;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarOutApplication;

import java.util.List;
import java.util.Map;

/**
 * 车辆外车申请
 *
 * @author wxn
 * @date 2018年6月3日
 */
public interface CarOutApplicationService {
    int insertSelective(CarOutApplication record);

    CarOutApplication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarOutApplication record);

    int updateByPrimaryKeyWithBLOBs(CarOutApplication record);

    PageInfo<CarOutApplication> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum);

    PageInfo<Map<String, Object>> listCreateBy(Map<String, Object> param, Integer pageSize, Integer pageNum);

    PageInfo<CarOutApplication> selectListByParam(Map param, Integer pageSize, Integer pageNum);
}
