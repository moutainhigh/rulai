package com.unicdata.dao.car;

import com.github.pagehelper.Page;
import com.unicdata.condition.CarGoodsCondition;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.car.CarGoodInfoExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CarGoodInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(CarGoodInfoWithBLOBs record);

	int insertSelective(CarGoodInfoWithBLOBs record);

	CarGoodInfoWithBLOBs selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarGoodInfoWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(CarGoodInfoWithBLOBs record);

	int updateByPrimaryKey(CarGoodInfo record);

	List<Map<String, Object>> selectByPurchaseOrder(Integer carOrderId);

	Page<Map<String, Object>> selectListByStore(CarGoodsCondition carGoodsCondition);

	List<Map<String, Object>> selectByManyConditions(Map<String, Object> map);

	Page<Map<String, Object>> selectListByStoreSimplify(CarGoodsCondition carGoodsCondition);

	int updateByOutApplication(Map<String, Object> params);

	// 车型 wp
	List<Map<String, Object>> selectCarConf(Map<String, Object> map);

	List<Map<String, Object>> carList(Map<String, Object> map);

	List<CarGoodInfoWithBLOBs> selectByExampleWithBLOBs(CarGoodInfoExample example);

	List<CarGoodInfo> selectByExample(CarGoodInfoExample example);

	// 车列表wp
	Page<Map<String, Object>> selectCarList(Map<String, Object> map);

	// 车详情wp
	Map<String, Object> carDetailInfo(Map<String, Object> map);

	CarGoodInfoWithBLOBs selectByVin(String vin);

	// 扫一扫wp
	Map<String, Object> carScan(String vin);

	// 入库录单 wp
	List<Map<String, Object>> carRukuList(Map<String, Object> map);

	// 变更汽车在库、整理状态 wp
	int updateCarInfoSelective(CarGoodInfo carGoodInfo);

	// 仓库下的汽车 wp
	List<Map<String, Object>> selectCarInStore(Map<String, Object> map);

	int updateBrandNameByBrandId(Map<String, Object> params);

	int updateInfoByFamilyId(CarFamily carFamily);

	int updateInfoByVehicleId(CarVehicleConf carVehicleConf);
	
	Map<String, Object> getCarDetailById(Integer carId);
	
	int updateByAllotApplication(Map<String, Object> params);

	Page<Map<String, Object>> selectPageByManyConditions(Map<String, Object> map);

	Map<String, Object> selectById(Integer carId);
	//汽车调拨变更汽车在库状态 wp
	int updateCarStoregStatusByAllot(Map<String, Object> map);
	//检测后返回汽车信息 wp
	Map<String, Object> selectCheckAfterCarInfo(Map<String, Object> map);
	//根据车型id查询可销售的车辆
	public List<CarGoodInfo> getCarListByVehicleId(Integer vehicleId);
	//是否在试驾中 wp
	Map<String, Object> isDrive(Map<String, Object> map);

	/**
	 * 修改计划让价
	 * @param carId
	 * @return
	 */
	Integer updatePlanAllowPrice(@Param("carId") Integer carId , @Param("price") BigDecimal price);
}