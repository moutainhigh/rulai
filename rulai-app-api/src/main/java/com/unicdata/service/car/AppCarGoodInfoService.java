package com.unicdata.service.car;

import com.github.pagehelper.PageInfo;
import com.unicdata.condition.CarGoodsCondition;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoExample;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/2.
 */
public interface AppCarGoodInfoService {
    public PageInfo selectByManyConditions(Map<String, Object> map, Integer pageNum, Integer pageSize);

    //车型 wp
    List<Map<String, Object>> selectCarConf(Map<String, Object> map);

    //试驾车车型wp
    List<Map<String, Object>> carTestConf(Map<String, Object> map);

    List<Map<String, Object>> selectByManyConditions(Map<String, Object> map);
    /**
     * 根据车辆id查询明细
     * @param carId
     * @return
     */
    Map<String,Object> getCarDetailById(Integer carId);
    //根据车型id查询可销售的车辆  优先在库天数长的
    List<CarGoodInfo> getCarListByVehicleId(Integer vehicleId);
    
    int updateCarGoodInfo(CarGoodInfoWithBLOBs record);

    List<CarGoodInfo> selectByExample(CarGoodInfoExample example);

    int updateByPrimaryKey(CarGoodInfo record);
    //是否在试驾中 wp
  	Map<String, Object> isDrive(Map<String, Object> map);

    /**
     * 商品车在库车列表 部分信息
     *
     * @param carGoodsCondition
     * @param pageSize
     * @param pageNum
     * @return
     */
    PageInfo<Map<String, Object>> selectListByStoreSimplify(CarGoodsCondition carGoodsCondition);
}
