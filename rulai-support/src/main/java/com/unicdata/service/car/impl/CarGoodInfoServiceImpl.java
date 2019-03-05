package com.unicdata.service.car.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.condition.CarGoodsCondition;
import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoExample;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.policy.RebateCar;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.policy.RebateCarService;

@Service
public class CarGoodInfoServiceImpl implements CarGoodInfoService {

	@Autowired
	private CarGoodInfoMapper carGoodInfoMapper;
	@Autowired
	private RebateCarService rebateCarService;

	public int insertSelective(CarGoodInfoWithBLOBs record) {
		return carGoodInfoMapper.insertSelective(record);
	}

	public CarGoodInfoWithBLOBs selectByPrimaryKey(Integer id) {
		return carGoodInfoMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CarGoodInfoWithBLOBs record) {
		return carGoodInfoMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(CarGoodInfoWithBLOBs record) {
		return carGoodInfoMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public List<Map<String, Object>> selectByPurchaseOrder(Integer carOrderId) {
		return carGoodInfoMapper.selectByPurchaseOrder(carOrderId);
	}

	@Override
	public PageInfo<Map<String, Object>> selectListByStore(CarGoodsCondition carGoodsCondition) {
		PageHelper.startPage(carGoodsCondition.getPageNum(), carGoodsCondition.getPageSize());
		return carGoodInfoMapper.selectListByStore(carGoodsCondition).toPageInfo();
	}

	@Override
	public PageInfo<Map<String, Object>> selectListByStoreSimplify(CarGoodsCondition carGoodsCondition) {
		if(null != carGoodsCondition.getPageNum() && null != carGoodsCondition.getPageSize()){
			PageHelper.startPage(carGoodsCondition.getPageNum(), carGoodsCondition.getPageSize());
		}
		return carGoodInfoMapper.selectListByStoreSimplify(carGoodsCondition).toPageInfo();
	}

	@Override
	public int updateByOutApplication(Integer storageStatus, Integer applicationId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storageStatus", storageStatus);
		params.put("applicationId", applicationId);
		return carGoodInfoMapper.updateByOutApplication(params);
	}

	@Override
	public List<CarGoodInfoWithBLOBs> selectByExampleWithBLOBs(CarGoodInfoExample example) {
		return carGoodInfoMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<CarGoodInfo> selectByExample(CarGoodInfoExample example) {
		return carGoodInfoMapper.selectByExample(example);
	}

	@Override
	public CarGoodInfoWithBLOBs selectByVin(String vin) {
		return carGoodInfoMapper.selectByVin(vin);
	}

	@Override
	public int updateBrandNameByBrandId(Integer brandId, String brandName) {
		Map<String, Object> params = new HashMap<>();
		params.put("brandId", brandId);
		params.put("brandName", brandName);
		return carGoodInfoMapper.updateBrandNameByBrandId(params);
	}

	@Override
	public int updateInfoByFamilyId(CarFamily carFamily) {
		return carGoodInfoMapper.updateInfoByFamilyId(carFamily);
	}

	@Override
	public int updateInfoByVehicleId(CarVehicleConf carVehicleConf) {
		return carGoodInfoMapper.updateInfoByVehicleId(carVehicleConf);
	}

	@Override
	public PageInfo<CarGoodInfo> selectFalseSubmissionPage(String dmsStartDate, String dmsEndDate, Integer orderStatus,
			Integer storeId, Integer pageNum, Integer pageSize) {
		pageNum = (null == pageNum || pageNum < 1 ? 1 : pageNum);
		pageSize = null == pageSize || pageSize.intValue() > 100 ? 100 : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		CarGoodInfoExample carex = new CarGoodInfoExample();
		CarGoodInfoExample.Criteria criteria = carex.createCriteria();
		criteria.andVirtualRecordStatusEqualTo(1).andDistributorStoreIdEqualTo(storeId);
		if (orderStatus != null) {
			criteria.andOrderStatusEqualTo(orderStatus);
		}
		if (StringUtil.isNotBlank(dmsStartDate)) {
			criteria.andFirstDmsDateGreaterThanOrEqualTo(dmsStartDate);
		}
		if (StringUtil.isNotBlank(dmsEndDate)) {
			criteria.andFirstDmsDateLessThanOrEqualTo(dmsEndDate);
		}
		List<CarGoodInfo> carGoodInfos = this.selectByExample(carex);
		for (CarGoodInfo car : carGoodInfos) {
			RebateCar rcs = rebateCarService.selectSumRebateCarDataByCarId(car.getId());
			car.setRebateCar(rcs);
		}
		return new PageInfo<>(carGoodInfos);
	}

	@Override
	public int updateByAllotApplication(Integer orderStatus, Integer applicationId) {
		Map<String, Object> params = new HashMap<>();
		params.put("orderStatus", orderStatus);
		params.put("applicationId", applicationId);
		return carGoodInfoMapper.updateByAllotApplication(params);
	}

	@Override
	public List<Map<String, Object>> selectByManyConditions(Map<String, Object> map) {
		return carGoodInfoMapper.selectByManyConditions(map);
	}

	@Override
	public PageInfo<Map<String, Object>> selectPageByManyConditions(Map<String, Object> map, Integer pageSize,
			Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		return carGoodInfoMapper.selectPageByManyConditions(map).toPageInfo();
	}

	@Override
	public Map<String, Object> selectById(Integer carId) {
		return carGoodInfoMapper.selectById(carId);
	}
	/**
	 * 修改计划让价
	 * @param carId
	 * @return
	 */
	@Override
	public Integer updatePlanAllowPrice(Integer carId, BigDecimal price) {
		return carGoodInfoMapper.updatePlanAllowPrice(carId,price);
	}

}
