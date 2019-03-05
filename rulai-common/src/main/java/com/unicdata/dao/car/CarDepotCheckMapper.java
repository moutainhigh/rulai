package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.condition.CarCheckConditon;
import com.unicdata.entity.car.CarDepotCheck;

public interface CarDepotCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarDepotCheck record);

    int insertSelective(CarDepotCheck record);

    CarDepotCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarDepotCheck record);
    //历史盘点记录 wp
    List<Map<String, Object>> depotCheckHistory(Map<String, Object> map);
    //盘亏列表 wp
    List<Map<String, Object>> depotCheckLossList(Map<String, Object> map);
    //盘亏number下的汽车
    List<Map<String, Object>> depotCheckLossCars(Map<String, Object> map);
    //盘点单状态 wp
    List<Map<String, Object>> selectPanDianDanStatus(String number);

	Page<Map<String, Object>> selectListByStore(CarCheckConditon carCheckConditon);

	List<String> selectWarehouseByNumber(String number);

	List<Map<String, Object>> selectCarByNumber(Map<String, Object> params);
	//通过汽车ID查盘点记录
	Integer selectDepotByCarId(Integer carId);
	//提交实盘信息 wp
	int updateByNumberSelective(CarDepotCheck carDepotCheck);
	//是否存在车辆盘点信息 wp
	List<Map<String, Object>>selectIsExistCar(Map<String, Object> map);
}