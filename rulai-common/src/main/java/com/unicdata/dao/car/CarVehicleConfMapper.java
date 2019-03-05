package com.unicdata.dao.car;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.car.CarVehicleConfExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CarVehicleConfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarVehicleConf record);

    int insertSelective(CarVehicleConf record);

    List<CarVehicleConf> selectByExample(CarVehicleConfExample example);

    CarVehicleConf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarVehicleConf record);

    int updateByPrimaryKey(CarVehicleConf record);

	Page<Map<String, Object>> selectListByStore(Integer distributorStoreId);

	Page<Map<String, Object>> selectListByBrandId(Map<String, Object> params);

	List<CarVehicleConf> selectVehicleByBrand(Integer familyId);

	CarVehicleConf selectByNameAndYear(Map<String, Object> params);

	List<String> selectYearByVehicle(Map<String, Object> params);
	//查车型By车系
	List<Map<String, Object>> selectCarConfByFamily(Map<String, Object> map);

    /**
     * 根据车辆id集合查询车辆车型
     * @param carIds
     * @return
     */
	List<Map<String,Object>> selectNameBycarIds(List<Integer> carIds);

    Map selectVehicleRebateAvgPrice(@Param("vehicleId") Integer vehicleId);

}