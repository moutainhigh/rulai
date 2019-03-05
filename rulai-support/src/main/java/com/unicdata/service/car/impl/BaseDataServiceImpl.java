package com.unicdata.service.car.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.conditon.FamilyCondition;
import com.unicdata.constant.CarEnum;
import com.unicdata.entity.car.CarBrand;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.car.CarInterestRule;
import com.unicdata.entity.car.CarStorage;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.car.CarWarehouse;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.BaseDataService;
import com.unicdata.service.car.CarBrandService;
import com.unicdata.service.car.CarFamilyService;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.CarInterestRuleService;
import com.unicdata.service.car.CarStorageService;
import com.unicdata.service.car.CarVehicleConfService;
import com.unicdata.service.car.CarWarehouseService;

/**
 * 车辆基础数据service
 * 
 * @author wxn
 * @date 2018年6月20日
 */
@Service
public class BaseDataServiceImpl implements BaseDataService {

	@Autowired
	private CarBrandService carBrandService;
	@Autowired
	private CarFamilyService carFamilyService;
	@Autowired
	private CarVehicleConfService carVehicleConfService;
	@Autowired
	private CarWarehouseService carWarehouseService;
	@Autowired
	private CarStorageService carStorageService;
	@Autowired
	private CarInterestRuleService carInterestRuleService;
	@Autowired
	private CarGoodInfoService carGoodInfoService;

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<String> updateBrand(Employee employee, CarBrand carBrand) {
		ApiReturnInfo<String> result = new ApiReturnInfo<>();
		// 验证空值
		int num = 0;
		if (null == carBrand.getStatus() || carBrand.getStatus() == 1) {
			if (StringUtil.isBlank(carBrand.getName()) || StringUtil.isBlank(carBrand.getFactoryName())) {
				result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
				result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
				return result;
			}
			if (null != carBrand.getId() && carBrand.getId() > 0) {
				num = carBrandService.updateByPrimaryKeySelective(carBrand);
				// 更新车辆表中品牌名称
				carGoodInfoService.updateBrandNameByBrandId(carBrand.getId(), carBrand.getName());
			} else {
				CarBrand ifexist = carBrandService.selectByName(employee.getStoreId(), carBrand.getName(),
						carBrand.getFactoryName());
				if (null != ifexist) {
					result.setCode(ConstantEnumStatus.Exist.getCode());
					result.setMessage("该品牌已存在");
					return result;
				}
				carBrand.setDistributorStoreId(employee.getStoreId());
				carBrand.setOperatorId(employee.getId());
				num = carBrandService.insertSelective(carBrand);
			}
		} else {
			num = carBrandService.updateByPrimaryKeySelective(carBrand);
		}
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<String> updateFamily(Employee employee, FamilyCondition familyCondition) {
		CarFamily carFamily = familyCondition.getCarFamily();
		List<CarInterestRule> ruleList = familyCondition.getRuleList();
		ApiReturnInfo<String> result = new ApiReturnInfo<>();
		if (null == carFamily) {
			result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
			result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
			return result;
		}
		// 验证空值
		int num = 0;
		if (null == carFamily.getStatus() || carFamily.getStatus() == 1) {
			if (null == ruleList || StringUtil.isBlank(carFamily.getName()) || null == carFamily.getFinanceCompanyId()
					|| null == carFamily.getInterestFreeDay()) {
				result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
				result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
				return result;
			}
			if (null != carFamily.getId() && carFamily.getId() > 0) {
				num = carFamilyService.updateByPrimaryKeySelective(carFamily);
				// 更新车辆表中车系名称 免息天数
				carGoodInfoService.updateInfoByFamilyId(carFamily);
			} else {
				CarFamily ifexist = carFamilyService.selectByName(employee.getStoreId(), carFamily.getName(),
						carFamily.getBrandId());
				if (null != ifexist) {
					result.setCode(ConstantEnumStatus.Exist.getCode());
					result.setMessage("该车系已存在");
					return result;
				}
				carFamily.setDistributorStoreId(employee.getStoreId());
				carFamily.setOperatorId(employee.getId());
				num = carFamilyService.insertSelective(carFamily);
			}
			if (num > 0) {
				// 此次删除的利息规则
				if (StringUtil.isNotBlank(familyCondition.getRuleIds())) {
					List<String> ruleIdList = Arrays.asList(familyCondition.getRuleIds().split(","));
					for (int i = 0; i < ruleIdList.size(); i++) {
						if (StringUtil.isBlank(ruleIdList.get(i))) {
							continue;
						}
						int ruleId = Integer.valueOf(ruleIdList.get(i));
						CarInterestRule carInterestRule = new CarInterestRule();
						carInterestRule.setId(ruleId);
						carInterestRule.setStatus(CarEnum.DataStatus.DELETED.getCode());
						carInterestRuleService.updateByPrimaryKeySelective(carInterestRule);
					}
				}
				// 修改以及新增的利息规则
				for (int i = 0; i < ruleList.size(); i++) {
					CarInterestRule carInterestRule = ruleList.get(i);
					carInterestRule.setDistributorStoreId(employee.getStoreId());
					carInterestRule.setFamilyId(carFamily.getId());
					carInterestRule.setStatus(CarEnum.DataStatus.NORMAL.getCode());
					if (null == carInterestRule.getMinNum() || null == carInterestRule.getCoefficient()) {
						result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
						result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
						return result;
					}
					if (null != carInterestRule.getId() && carInterestRule.getId() > 0) {
						carInterestRuleService.updateByPrimaryKey(carInterestRule);
					} else {
						carInterestRuleService.insertSelective(carInterestRule);
					}
				}
			}
		} else {
			num = carFamilyService.updateByPrimaryKeySelective(carFamily);
		}
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<String> updateVehicle(Employee employee, CarVehicleConf carVehicleConf) {
		ApiReturnInfo<String> result = new ApiReturnInfo<>();
		// 验证空值
		int num = 0;
		if (null == carVehicleConf.getStatus() || carVehicleConf.getStatus() == 1) {
			if (StringUtil.isBlank(carVehicleConf.getName()) || StringUtil.isBlank(carVehicleConf.getYear())
					|| null == carVehicleConf.getExtendWarrantyYear()
					|| null == carVehicleConf.getExtendWarrantyMile()) {
				result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
				result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
				return result;
			}
			CarFamily carFamily = carFamilyService.selectByPrimaryKey(carVehicleConf.getFamilyId());
			carVehicleConf.setBrandId(carFamily.getBrandId());
			if (null != carVehicleConf.getId() && carVehicleConf.getId() > 0) {
				num = carVehicleConfService.updateByPrimaryKeySelective(carVehicleConf);
				// 更新车辆表中 车型名称 指导价格 采购价 年款
				carGoodInfoService.updateInfoByVehicleId(carVehicleConf);
			} else {
				CarVehicleConf ifexist = carVehicleConfService.selectByNameAndYear(employee.getStoreId(),
						carVehicleConf.getFamilyId(), carVehicleConf.getName(), carVehicleConf.getYear());
				if (null != ifexist) {
					result.setCode(ConstantEnumStatus.Exist.getCode());
					result.setMessage("该车型已存在");
					return result;
				}
				carVehicleConf.setDistributorStoreId(employee.getStoreId());
				carVehicleConf.setOperatorId(employee.getId());
				num = carVehicleConfService.insertSelective(carVehicleConf);
			}
		} else {
			num = carVehicleConfService.updateByPrimaryKeySelective(carVehicleConf);
		}
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<String> updateWarehouse(Employee employee, CarWarehouse carWarehouse) {
		ApiReturnInfo<String> result = new ApiReturnInfo<>();
		// 验证空值
		if (null == carWarehouse.getStatus() || carWarehouse.getStatus() == 1) {
			if (StringUtil.isBlank(carWarehouse.getName())) {
				result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
				result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
				return result;
			}
		}
		int num = 0;
		if (null != carWarehouse.getId() && carWarehouse.getId() > 0) {
			num = carWarehouseService.updateByPrimaryKeySelective(carWarehouse);
		} else {
			carWarehouse.setDistributorStoreId(employee.getStoreId());
			num = carWarehouseService.insertSelective(carWarehouse);
		}
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<String> updateStorage(Employee employee, CarStorage carStorage) {
		ApiReturnInfo<String> result = new ApiReturnInfo<>();
		// 验证空值
		if (null == carStorage.getStatus() || carStorage.getStatus() == 1) {
			if (StringUtil.isBlank(carStorage.getName())) {
				result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
				result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
				return result;
			}
		}
		int num = 0;
		if (null != carStorage.getId() && carStorage.getId() > 0) {
			num = carStorageService.updateByPrimaryKeySelective(carStorage);
		} else {
			carStorage.setDistributorStoreId(employee.getStoreId());
			num = carStorageService.insertSelective(carStorage);
		}
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

}
