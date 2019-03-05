package com.unicdata.service.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.car.CarVehicleConfExample;

/**
 * 车型
 * 
 * @author wxn
 * @date 2018年6月1日
 */
public interface CarVehicleConfService {
	int insertSelective(CarVehicleConf record);

	List<CarVehicleConf> selectByExample(CarVehicleConfExample example);

	CarVehicleConf selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarVehicleConf record);

	/**
	 * 根据门店id获取车型列表
	 * 
	 * @param pageNum
	 * @param pageSize
	 * 
	 * @param storeId
	 * @return
	 */
	PageInfo<Map<String, Object>> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum);

	List<CarVehicleConf> selectVehicleByBrand(Integer familyId);

	/**
	 * 通过名称查找车型
	 * @param familyId 
	 * 
	 * @param id
	 * @return
	 */
	CarVehicleConf selectByNameAndYear(Integer storeId, Integer familyId, String name, String year);

	/**
	 * 通过车型查找年款
	 * 
	 * @param storeId
	 * @param vehicleId
	 * @return
	 */
	List<String> selectYearByVehicle(Integer storeId, Integer vehicleId);

	PageInfo<CarVehicleConf> selectVehicleList(CarVehicleConf carVehicleConf, Integer pageSize, Integer pageNum);

	ApiReturnInfo priceEdit(CarVehicleConf vehicle);

	/**
	 * 操作让利状态
	 * 
	 * @param adjustStatus
	 *            对应功能 1撤销，2全部报备，3审批，4全部审批，5驳回
	 * @param ids
	 *            需要审批或者撤销的编号（adjustStatus = 1 时为单个id ，adjustStatus = 3
	 *            时为多个id，用半角逗号隔开）
	 * @return
	 */
	ApiReturnInfo chageStatus(Integer adjustStatus, String ids);
}
