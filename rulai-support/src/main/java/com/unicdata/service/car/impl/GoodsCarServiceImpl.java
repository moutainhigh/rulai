package com.unicdata.service.car.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.base.util.StringUtil;
import com.unicdata.conditon.CarAllotCondition;
import com.unicdata.conditon.CarOutApplicationCondition;
import com.unicdata.conditon.CarWarehouseCondition;
import com.unicdata.conditon.GoodsStorageCondition;
import com.unicdata.constant.CarEnum;
import com.unicdata.entity.car.CarAllot;
import com.unicdata.entity.car.CarAllotApplication;
import com.unicdata.entity.car.CarBoutiqueBinding;
import com.unicdata.entity.car.CarColor;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.car.CarOut;
import com.unicdata.entity.car.CarWarehouseChange;
import com.unicdata.entity.car.CarWarehouseChangeRecord;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.CounterService;
import com.unicdata.service.car.CarAllotApplicationService;
import com.unicdata.service.car.CarAllotService;
import com.unicdata.service.car.CarBoutiqueBindingService;
import com.unicdata.service.car.CarColorService;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.CarOutApplicationService;
import com.unicdata.service.car.CarOutService;
import com.unicdata.service.car.CarWarehouseChangeRecordService;
import com.unicdata.service.car.CarWarehouseChangeService;
import com.unicdata.service.car.GoodsCarService;
import com.unicdata.util.NumberUtil;

@Service
public class GoodsCarServiceImpl implements GoodsCarService {

	@Autowired
	private CarGoodInfoService carGoodInfoService;
	@Autowired
	private CarBoutiqueBindingService carBoutiqueBindingService;
	@Autowired
	private CarColorService carColorService;
	@Autowired
	private CarAllotService carAllotService;
	@Autowired
	private CarAllotApplicationService carAllotApplicationService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private CarOutService carOutService;
	@Autowired
	private CarOutApplicationService carOutApplicationService;
	@Autowired
	private CarWarehouseChangeService carWarehouseChangeService;
	@Autowired
	private CarWarehouseChangeRecordService carWarehouseChangeRecordService;

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<Map<String, Object>> saveCar(Employee employee, GoodsStorageCondition goodsStorageCondition) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		List<CarBoutiqueBinding> carBoutiqueList = goodsStorageCondition.getCarBoutiqueList();
		CarGoodInfoWithBLOBs carGoodInfo = goodsStorageCondition.getCarGoodInfo();

		// 颜色
		if (StringUtil.isNotBlank(carGoodInfo.getDecorationsOutName())) {
			String outColor = carGoodInfo.getDecorationsOutName().replace("色", "");
			// 车身颜色
			CarColor carColor = carColorService.selectByFamilyAndName(carGoodInfo.getFamilyId(), outColor,
					CarEnum.ColorStatus.OUT.getCode());
			if (null == carColor) {
				carColor = new CarColor();
				carColor.setFamilyId(carGoodInfo.getFamilyId());
				carColor.setLocationStatus(CarEnum.ColorStatus.OUT.getCode());
				carColor.setName(outColor);
				carColorService.insertSelective(carColor);
			}
			carGoodInfo.setDecorationsOutId(carColor.getId());
		}
		if (StringUtil.isNotBlank(carGoodInfo.getDecorationsInName())) {
			String inColor = carGoodInfo.getDecorationsInName().replace("色", "");
			// 内饰
			CarColor carColor = carColorService.selectByFamilyAndName(carGoodInfo.getFamilyId(), inColor,
					CarEnum.ColorStatus.IN.getCode());
			if (null == carColor) {
				carColor = new CarColor();
				carColor.setFamilyId(carGoodInfo.getFamilyId());
				carColor.setLocationStatus(CarEnum.ColorStatus.IN.getCode());
				carColor.setName(inColor);
				carColorService.insertSelective(carColor);
			}
			carGoodInfo.setDecorationsInId(carColor.getId());
		}
		if (null != carBoutiqueList && carBoutiqueList.size() > 0) {
			carGoodInfo.setNewBoutiqueStatus(CarEnum.ExistStatus.EXIST.getCode());
		} else {
			carGoodInfo.setNewBoutiqueStatus(CarEnum.ExistStatus.NOT_EXIST.getCode());
		}
		int num = carGoodInfoService.updateByPrimaryKeyWithBLOBs(carGoodInfo);
		if (num > 0) {
			// 删除精品信息
			if (StringUtil.isNotBlank(goodsStorageCondition.getBoutuqueIds())) {
				List<String> boutuqueIdList = Arrays.asList(goodsStorageCondition.getBoutuqueIds().split(","));
				for (int i = 0; i < boutuqueIdList.size(); i++) {
					if (StringUtil.isBlank(boutuqueIdList.get(i))) {
						continue;
					}
					int boutuqueId = Integer.valueOf(boutuqueIdList.get(i));
					CarBoutiqueBinding carBoutiqueBinding = new CarBoutiqueBinding();
					carBoutiqueBinding.setId(boutuqueId);
					carBoutiqueBinding.setStatus(CarEnum.DataStatus.DELETED.getCode());
					carBoutiqueBindingService.updateByPrimaryKeySelective(carBoutiqueBinding);
				}
			}

			// 保存精品信息
			for (int i = 0; i < carBoutiqueList.size(); i++) {
				CarBoutiqueBinding binding = carBoutiqueList.get(i);
				binding.setOperatorId(employee.getId());
				binding.setCarId(carGoodInfo.getId());
				if (null != binding.getId() && binding.getId() > 0) {
					carBoutiqueBindingService.updateByPrimaryKeySelective(binding);
				} else {
					carBoutiqueBindingService.insertSelective(binding);
				}
			}
		} else {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<String> addAllot(Employee employee, CarAllotCondition carAllotCondition) {
		ApiReturnInfo<String> result = new ApiReturnInfo<>();
		CarAllotApplication carAllotApplication = carAllotCondition.getCarAllotApplication();
		List<CarAllot> carList = carAllotCondition.getCarList();
		// 验证空值
		if (null == carAllotApplication || null == carList || StringUtil.isBlank(carAllotApplication.getName())
				|| null == carAllotApplication.getType() || StringUtil.isBlank(carAllotApplication.getToStoreName())
				|| StringUtil.isBlank(carAllotApplication.getLinkman())
				|| StringUtil.isBlank(carAllotApplication.getLinkPhone())) {
			result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
			result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
			return result;
		}
		if (!NumberUtil.isPhone(carAllotApplication.getLinkPhone())
				&& !NumberUtil.isMobileNO(carAllotApplication.getLinkPhone())) {
			result.setCode(ConstantEnumStatus.validate.getCode());
			result.setMessage("联系电话验证不通过");
			return result;
		}
		carAllotApplication.setDistributorStoreId(employee.getStoreId());
		carAllotApplication.setOperatorId(employee.getId());
		carAllotApplication.setAllotNum(carList.size());
		// 编号
		carAllotApplication.setCode(counterService.generateCode("CLDB", DateUtil.sdf5, null));
		int num = carAllotApplicationService.insertSelective(carAllotApplication);
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		} else {
			// 调拨车辆存表
			for (int i = 0; i < carList.size(); i++) {
				CarAllot carAllot = carList.get(i);
				carAllot.setDistributorStoreId(employee.getStoreId());
				carAllot.setApplicationId(carAllotApplication.getId());
				carAllotService.insertSelective(carAllot);
			}
			// 更改调拨车辆订单状态
			carGoodInfoService.updateByAllotApplication(CarEnum.CarOrderStatus.RESERVED.getCode(),
					carAllotApplication.getId());
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<String> addOut(Employee employee, CarOutApplicationCondition carOutApplication) {
		ApiReturnInfo<String> result = new ApiReturnInfo<>();
		// 验证空值
		if (StringUtil.isBlank(carOutApplication.getName()) || null == carOutApplication.getPlanOutDate()
				|| null == carOutApplication.getPlanReturnDate()
				|| StringUtil.isBlank(carOutApplication.getDestination())
				|| StringUtil.isBlank(carOutApplication.getCarIds())) {
			result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
			result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
			return result;
		}
		carOutApplication.setDistributorStoreId(employee.getStoreId());
		carOutApplication.setOperatorId(employee.getId());
		List<String> carIdList = Arrays.asList(carOutApplication.getCarIds().split(","));
		carOutApplication.setApplicateNum(carIdList.size());
		// 编号
		carOutApplication.setCode(counterService.generateCode("CLWC", DateUtil.sdf5, null));
		int num = carOutApplicationService.insertSelective(carOutApplication);
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		} else {
			// 外出车辆存表
			for (int i = 0; i < carIdList.size(); i++) {
				if (StringUtil.isBlank(carIdList.get(i))) {
					continue;
				}
				int carId = Integer.valueOf(carIdList.get(i));
				CarOut carOut = new CarOut();
				carOut.setDistributorStoreId(employee.getStoreId());
				carOut.setApplicationId(carOutApplication.getId());
				carOut.setCarGoodId(carId);
				carOutService.insertSelective(carOut);
			}
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<PageInfo<Map<String, Object>>> addWareChange(Employee employee,
			CarWarehouseCondition carWarehouseCondition) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		CarWarehouseChangeRecord carWarehouseChangeRecord = carWarehouseCondition.getCarWarehouseChangeRecord();
		List<CarWarehouseChange> changeList = carWarehouseCondition.getChangeList();
		// 验证空值
		if (StringUtil.isBlank(carWarehouseChangeRecord.getName()) || null == carWarehouseChangeRecord
				|| null == changeList) {
			result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
			result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
			return result;
		}
		carWarehouseChangeRecord.setDistributorStoreId(employee.getStoreId());
		carWarehouseChangeRecord.setOperatorId(employee.getId());
		carWarehouseChangeRecord.setCode(counterService.generateCode("CLYK", DateUtil.sdf5, null));
		int num = carWarehouseChangeRecordService.insertSelective(carWarehouseChangeRecord);
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		} else {
			for (int i = 0; i < changeList.size(); i++) {
				CarWarehouseChange carWarehouseChange = changeList.get(i);
				CarGoodInfoWithBLOBs carGoodInfo = carGoodInfoService
						.selectByPrimaryKey(carWarehouseChange.getCarGoodId());
				// 存移库信息
				carWarehouseChange.setChangeApplicationId(carWarehouseChangeRecord.getId());
				carWarehouseChange.setBeforeWarehouseId(carGoodInfo.getWarehouseId());
				carWarehouseChange.setBeforeStorageId(carGoodInfo.getStorageId());
				carWarehouseChange.setDistributorStoreId(employee.getStoreId());
				carWarehouseChange.setOperatorId(employee.getId());
				carWarehouseChangeService.insertSelective(carWarehouseChange);
				// 更改车辆信息
				carGoodInfo.setWarehouseId(carWarehouseChange.getAfterWarehouseId());
				carGoodInfo.setStorageId(carWarehouseChange.getAfterStorageId());
				carGoodInfo.setUpdateDate(new Date());
				carGoodInfoService.updateByPrimaryKeySelective(carGoodInfo);
			}
		}
		return result;
	}

}
