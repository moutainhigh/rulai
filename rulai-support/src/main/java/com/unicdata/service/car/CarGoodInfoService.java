package com.unicdata.service.car;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.condition.CarGoodsCondition;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoExample;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.car.CarVehicleConf;

/**
 * 采购车商品车
 * 
 * @author wxn
 * @date 2018年6月2日
 */
public interface CarGoodInfoService {
	int insertSelective(CarGoodInfoWithBLOBs record);

	CarGoodInfoWithBLOBs selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarGoodInfoWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(CarGoodInfoWithBLOBs record);

	List<Map<String, Object>> selectByPurchaseOrder(Integer carOrderId);

	/**
	 * 商品车库存列表 详细信息
	 * 
	 * @param carGoodsCondition
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	PageInfo<Map<String, Object>> selectListByStore(CarGoodsCondition carGoodsCondition);

	/**
	 * 商品车在库车列表 部分信息
	 * 
	 * @param carGoodsCondition
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	PageInfo<Map<String, Object>> selectListByStoreSimplify(CarGoodsCondition carGoodsCondition);

	/**
	 * 更改外出申请单车辆库存状态
	 * 
	 * @param storageStatus
	 * @param applicationId
	 * @return
	 */
	int updateByOutApplication(Integer storageStatus, Integer applicationId);

	List<CarGoodInfoWithBLOBs> selectByExampleWithBLOBs(CarGoodInfoExample example);

	List<CarGoodInfo> selectByExample(CarGoodInfoExample example);

	/**
	 * 通过vin码查找车辆
	 * 
	 * @param id
	 * @return
	 */
	CarGoodInfoWithBLOBs selectByVin(String vin);

	/**
	 * 根据品牌id更新车型名称
	 * 
	 * @param brandId
	 * @param brandName
	 * @return
	 */
	int updateBrandNameByBrandId(Integer brandId, String brandName);

	/**
	 * 根据车系id更新车系名称 免息天数
	 * 
	 * @param carFamily
	 * @return
	 */
	int updateInfoByFamilyId(CarFamily carFamily);

	/**
	 * 根据车型id更新车型名称年款采购金额指导价
	 * 
	 * @param carVehicleConf
	 * @return
	 */
	int updateInfoByVehicleId(CarVehicleConf carVehicleConf);

	/**
	 * 虚报列表
	 * 
	 * @param dmsStartDate
	 * @param dmsEndDate
	 * @param orderStatus
	 * @param storeId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<CarGoodInfo> selectFalseSubmissionPage(String dmsStartDate, String dmsEndDate, Integer orderStatus,
			Integer storeId, Integer pageNum, Integer pageSize);

	/**
	 * 更改调拨申请单车辆库存状态
	 * 
	 * @param storageStatus
	 * @param applicationId
	 * @return
	 */
	int updateByAllotApplication(Integer storageStatus, Integer applicationId);

	List<Map<String, Object>> selectByManyConditions(Map<String, Object> map);

	PageInfo<Map<String, Object>> selectPageByManyConditions(Map<String, Object> map, Integer pageSize,
			Integer pageNum);

	Map<String, Object> selectById(Integer carId);

	/**
	 * 修改计划让价
	 * @param carId
	 * @return
	 */
	Integer updatePlanAllowPrice(Integer carId, BigDecimal price);

}
