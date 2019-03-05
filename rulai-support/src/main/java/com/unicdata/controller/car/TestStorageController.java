package com.unicdata.controller.car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarMaintainRecord;
import com.unicdata.entity.car.CarRefuelRecord;
import com.unicdata.entity.car.CarTestInfo;
import com.unicdata.service.car.CarInsuranceRecordService;
import com.unicdata.service.car.CarMaintainRecordService;
import com.unicdata.service.car.CarRefuelRecordService;
import com.unicdata.service.car.CarTestInfoService;
import com.unicdata.service.car.TestCarService;
import com.unicdata.service.customer.TestDriveService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 试驾车库存
 * 
 * @author wxn
 * @date 2018年6月3日
 */
@Controller
@RequestMapping("/rulai/carTest")
@Api(value = "车辆管理-试驾车库存", tags = { "试驾车库存相关接口" })
public class TestStorageController extends HomeBaseController {

	// 文件访问路径
	@Value("${upload.access.path}")
	private String uploadAccessPath;

	@Autowired
	private CarTestInfoService carTestInfoService;
	@Autowired
	private CarMaintainRecordService carMaintainRecordService;
	@Autowired
	private CarRefuelRecordService carRefuelRecordService;
	@Autowired
	private CarInsuranceRecordService carInsuranceRecordService;
	@Autowired
	private TestCarService testCarService;
	@Autowired
	private TestDriveService testDriveService;

	@ApiOperation(value = "试驾车列表")
	@RequestMapping(value = "/getTestList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> getTestList(HttpServletRequest request, Integer pageSize,
			Integer pageNum) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(carTestInfoService.selectListByStore(getMember(request).getStoreId(), pageSize, pageNum));
		return result;
	}

	@ApiOperation(value = "试驾车加油维修保险记录")
	@RequestMapping(value = "/getRecords", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> getRecords(HttpServletRequest request, Integer testCarId) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> insuranceList = carInsuranceRecordService.selectListByTestCar(testCarId);
		List<CarRefuelRecord> refuelList = carRefuelRecordService.selectListByTestCar(testCarId);
		List<CarMaintainRecord> maintainList = carMaintainRecordService.selectListByTestCar(testCarId);
		// 拼接图片地址
		for (int i = 0; i < insuranceList.size(); i++) {
			Map<String, Object> insuranceMap = insuranceList.get(i);
			if (StringUtil.isNotBlank(insuranceMap.get("saliPic") + "")
					&& !StringUtil.equals("null", insuranceMap.get("saliPic") + "")) {
				insuranceMap.put("saliPic", uploadAccessPath + insuranceMap.get("saliPic"));
			}
			if (StringUtil.isNotBlank(insuranceMap.get("commercialPic") + "")
					&& !StringUtil.equals("null", insuranceMap.get("commercialPic") + "")) {
				insuranceMap.put("commercialPic", uploadAccessPath + insuranceMap.get("commercialPic"));
			}
			insuranceList.set(i, insuranceMap);
		}
		// 拼接图片地址
		for (int i = 0; i < refuelList.size(); i++) {
			CarRefuelRecord carRefuelRecord = refuelList.get(i);
			if (StringUtil.isNotBlank(carRefuelRecord.getGasolineCoupon())) {
				carRefuelRecord.setGasolineCoupon(uploadAccessPath + carRefuelRecord.getGasolineCoupon());
			}
			if (StringUtil.isNotBlank(carRefuelRecord.getOilCard())) {
				carRefuelRecord.setOilCard(uploadAccessPath + carRefuelRecord.getOilCard());
			}
			refuelList.set(i, carRefuelRecord);
		}
		// 拼接图片地址
		for (int i = 0; i < maintainList.size(); i++) {
			CarMaintainRecord carMaintainRecord = maintainList.get(i);
			if (StringUtil.isNotBlank(carMaintainRecord.getMaintainPage())) {
				carMaintainRecord.setMaintainPage(uploadAccessPath + carMaintainRecord.getMaintainPage());
			}
			maintainList.set(i, carMaintainRecord);
		}
		map.put("insuranceList", insuranceList);
		map.put("refuelList", refuelList);
		map.put("maintainList", maintainList);
		result.setData(map);
		return result;
	}
	
	@ApiOperation(value = "试驾车试驾记录")
	@RequestMapping(value = "/getDriveRecords", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<Map<String, Object>>> getDriveRecords(HttpServletRequest request, Integer testCarId) {
		ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(testDriveService.selectByCarId(testCarId));
		return result;
	}

	@ApiOperation(value = "试驾车新增/修改")
	@ApiImplicitParam(name = "carTestInfo", value = "试驾车信息", required = true, dataType = "CarTestInfo")
	@RequestMapping(value = "/updateStorage", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<String> updateStorage(HttpServletRequest request, CarTestInfo carTestInfo) {
		return testCarService.updateStorage(getMember(request), carTestInfo);
	}

}
