package com.unicdata.service.car.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.CarEnum;
import com.unicdata.entity.car.CarColor;
import com.unicdata.entity.car.CarTestInfo;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.CarColorService;
import com.unicdata.service.car.CarTestInfoService;
import com.unicdata.service.car.TestCarService;

@Service
public class TestCarServiceImpl implements TestCarService {

	@Autowired
	private CarTestInfoService carTestInfoService;
	@Autowired
	private CarColorService carColorService;

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<String> updateStorage(Employee employee, CarTestInfo carTestInfo) {
		ApiReturnInfo<String> result = new ApiReturnInfo<>();
		// 验证空值
		if (StringUtil.isBlank(carTestInfo.getVin()) || null == carTestInfo.getBrandId()
				|| null == carTestInfo.getFamilyId() || null == carTestInfo.getVehicleId()
				|| null == carTestInfo.getDecorationsOutName() || null == carTestInfo.getDecorationsInName()
				|| StringUtil.isBlank(carTestInfo.getEngineNum()) || null == carTestInfo.getMiles()) {
			result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
			result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
			return result;
		}
		// 颜色
		if (StringUtil.isNotBlank(carTestInfo.getDecorationsOutName())) {
			String outColor = carTestInfo.getDecorationsOutName().replace("色", "");
			// 车身颜色
			CarColor carColor = carColorService.selectByFamilyAndName(carTestInfo.getFamilyId(), outColor,
					CarEnum.ColorStatus.OUT.getCode());
			if (null == carColor) {
				carColor = new CarColor();
				carColor.setFamilyId(carTestInfo.getFamilyId());
				carColor.setLocationStatus(CarEnum.ColorStatus.OUT.getCode());
				carColor.setName(outColor);
				carColorService.insertSelective(carColor);
			}
			carTestInfo.setDecorationsOutId(carColor.getId());
		}
		if (StringUtil.isNotBlank(carTestInfo.getDecorationsInName())) {
			String inColor = carTestInfo.getDecorationsInName().replace("色", "");
			// 内饰
			CarColor carColor = carColorService.selectByFamilyAndName(carTestInfo.getFamilyId(), inColor,
					CarEnum.ColorStatus.IN.getCode());
			if (null == carColor) {
				carColor = new CarColor();
				carColor.setFamilyId(carTestInfo.getFamilyId());
				carColor.setLocationStatus(CarEnum.ColorStatus.IN.getCode());
				carColor.setName(inColor);
				carColorService.insertSelective(carColor);
			}
			carTestInfo.setDecorationsInId(carColor.getId());
		}
		int num = 0;
		if (null != carTestInfo.getId() && carTestInfo.getId() > 0) {
			num = carTestInfoService.updateByPrimaryKeySelective(carTestInfo);
		} else {
			carTestInfo.setDistributorStoreId(employee.getStoreId());
			carTestInfo.setOperatorId(employee.getId());
			num = carTestInfoService.insertSelective(carTestInfo);
		}
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

}
