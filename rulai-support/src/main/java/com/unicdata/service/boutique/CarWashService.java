package com.unicdata.service.boutique;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.CarWash;
import com.unicdata.entity.boutique.CarWashExample;

import java.util.List;
import java.util.Map;

public interface CarWashService {

    /**
     * 根据条件查看洗车服务列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 洗车状态改变
     * @param carWash
     */
    void stateChange(CarWash carWash);

    /**
     * 根据ID获取洗车服务
     * @param id
     * @return
     */
    CarWash getCarWashById(Integer id);

    /**
     * 优先
     * @param carWash
     */
    void prior(CarWash carWash);

	List<CarWash> selectByExample(CarWashExample map);
}
