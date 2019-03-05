package com.unicdata.controller.car;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.conditon.FamilyCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarBrand;
import com.unicdata.entity.car.CarColor;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.car.CarInterestRule;
import com.unicdata.entity.car.CarStorage;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.car.CarWarehouse;
import com.unicdata.service.car.BaseDataService;
import com.unicdata.service.car.CarBrandService;
import com.unicdata.service.car.CarColorService;
import com.unicdata.service.car.CarFamilyService;
import com.unicdata.service.car.CarInterestRuleService;
import com.unicdata.service.car.CarStorageService;
import com.unicdata.service.car.CarVehicleConfService;
import com.unicdata.service.car.CarWarehouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 车辆管理基础数据接口 品牌、车系、车型、仓库
 * 
 * @author wxn
 * @date 2018年5月31日
 */
@Controller
@RequestMapping("/rulai/carData")
@Api(value = "车辆管理-基础数据", tags = { "品牌、车系、车型、仓库相关接口" })
public class BaseDataController extends HomeBaseController {

	// 文件访问路径
	@Value("${upload.access.path}")
	private String uploadAccessPath;

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
	private CarColorService carColorService;
	@Autowired
	private BaseDataService baseDataService;

	@ApiOperation(value = "品牌列表")
	@RequestMapping(value = "/getBrandList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<CarBrand>> getBrandList(HttpServletRequest request, Integer pageSize,
			Integer pageNum) {
		ApiReturnInfo<PageInfo<CarBrand>> result = new ApiReturnInfo<>();
		result.setData(carBrandService.selectListByStore(getMember(request).getStoreId(), pageSize, pageNum));
		return result;
	}

	@ApiOperation(value = "通过品牌id获取车系列表(下拉)")
	@RequestMapping(value = "/getFamilyByBrand", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<CarFamily>> getFamilyByBrand(HttpServletRequest request, Integer brandId) {
		ApiReturnInfo<List<CarFamily>> result = new ApiReturnInfo<>();
		result.setData(carFamilyService.selectListByBrand(brandId));
		return result;
	}

	@ApiOperation(value = "通过车系id获取车型列表(下拉)")
	@RequestMapping(value = "/getVehicleByBrand", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<CarVehicleConf>> getVehicleByBrand(HttpServletRequest request, Integer familyId) {
		ApiReturnInfo<List<CarVehicleConf>> result = new ApiReturnInfo<>();
		result.setData(carVehicleConfService.selectVehicleByBrand(familyId));
		return result;
	}

	@ApiOperation(value = "年款下拉")
	@RequestMapping(value = "/getYearList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<String>> getYearList(HttpServletRequest request, Integer vehicleId) {
		ApiReturnInfo<List<String>> result = new ApiReturnInfo<>();
		result.setData(carVehicleConfService.selectYearByVehicle(getMember(request).getStoreId(), vehicleId));
		return result;
	}

	@ApiOperation(value = "颜色下拉")
	@RequestMapping(value = "/getColorList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<CarColor>> getBrandList(HttpServletRequest request, Integer familyId) {
		ApiReturnInfo<List<CarColor>> result = new ApiReturnInfo<>();
		result.setData(carColorService.selectColorByFamily(familyId));
		return result;
	}

	@ApiOperation(value = "品牌新增/修改/删除")
	@ApiImplicitParam(name = "carBrand", value = "品牌信息", required = true, dataType = "CarBrand")
	@RequestMapping(value = "/updateBrand", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<String> updateBrand(HttpServletRequest request, CarBrand carBrand) {
		return baseDataService.updateBrand(getMember(request), carBrand);
	}

	@ApiOperation(value = "车系列表")
	@RequestMapping(value = "/getFamilyList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> getFamilyList(HttpServletRequest request, Integer pageSize,
			Integer pageNum) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(carFamilyService.selectListByStore(getMember(request).getStoreId(), pageSize, pageNum));
		return result;
	}

	@ApiOperation(value = "车系利息规则")
	@RequestMapping(value = "/getRuleList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<CarInterestRule>> getRuleList(HttpServletRequest request, Integer familyId) {
		ApiReturnInfo<List<CarInterestRule>> result = new ApiReturnInfo<>();
		result.setData(carInterestRuleService.selectListByFamily(familyId));
		return result;
	}

	@ApiOperation(value = "车系新增/修改/删除")
	@ApiImplicitParam(name = "familyCondition", value = "车系信息", required = true, dataType = "FamilyCondition")
	@RequestMapping(value = "/updateFamily", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<String> updateFamily(HttpServletRequest request,
			@RequestBody FamilyCondition familyCondition) {
		return baseDataService.updateFamily(getMember(request), familyCondition);
	}

	@ApiOperation(value = "车型列表")
	@RequestMapping(value = "/getVehicleList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> getVehicleList(HttpServletRequest request, Integer pageSize,
			Integer pageNum) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(carVehicleConfService.selectListByStore(getMember(request).getStoreId(), pageSize, pageNum));
		return result;
	}

	@ApiOperation(value = "车型新增/修改/删除")
	@ApiImplicitParam(name = "carVehicleConf", value = "车型信息", required = true, dataType = "CarVehicleConf")
	@RequestMapping(value = "/updateVehicle", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<String> updateVehicle(HttpServletRequest request, CarVehicleConf carVehicleConf) {
		return baseDataService.updateVehicle(getMember(request), carVehicleConf);
	}

	@ApiOperation(value = "仓库列表")
	@RequestMapping(value = "/getWarehouseList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<CarWarehouse>> getWarehouseList(HttpServletRequest request, Integer pageSize,
			Integer pageNum) {
		ApiReturnInfo<PageInfo<CarWarehouse>> result = new ApiReturnInfo<>();
		PageInfo<CarWarehouse> page = carWarehouseService.selectListByStore(getMember(request).getStoreId(), pageSize,
				pageNum);
		// 拼接图片地址
		for (int i = 0; i < page.getList().size(); i++) {
			CarWarehouse carWarehouse = page.getList().get(i);
			if (StringUtil.isNotBlank(carWarehouse.getPicture())) {
				carWarehouse.setPicture(uploadAccessPath + carWarehouse.getPicture());
			}
			page.getList().set(i, carWarehouse);
		}
		result.setData(page);
		return result;
	}

	@ApiOperation(value = "仓库新增/修改/删除")
	@ApiImplicitParam(name = "carWarehouse", value = "仓库信息", required = true, dataType = "CarWarehouse")
	@RequestMapping(value = "/updateWarehouse", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<String> updateWarehouse(HttpServletRequest request, CarWarehouse carWarehouse) {
		return baseDataService.updateWarehouse(getMember(request), carWarehouse);
	}

	@ApiOperation(value = "通过仓库查找库位列表")
	@ApiImplicitParam(name = "warehouseId", value = "仓库id", required = true, dataType = "Integer")
	@RequestMapping(value = "/getStorageList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<CarStorage>> getStorageList(HttpServletRequest request, Integer warehouseId,
			Integer pageSize, Integer pageNum) {
		ApiReturnInfo<PageInfo<CarStorage>> result = new ApiReturnInfo<>();
		result.setData(carStorageService.selectListByWareHouse(warehouseId, pageSize, pageNum));
		return result;
	}

	@ApiOperation(value = "通过仓库查找库位列表(移库用)")
	@ApiImplicitParam(name = "warehouseId", value = "仓库id", required = true, dataType = "Integer")
	@RequestMapping(value = "/getStorageForMove", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<CarStorage>> getStorageForMove(HttpServletRequest request, Integer warehouseId) {
		ApiReturnInfo<List<CarStorage>> result = new ApiReturnInfo<>();
		result.setData(carStorageService.selectListExceptOut(warehouseId));
		return result;
	}

	@ApiOperation(value = "库位新增/修改/删除")
	@ApiImplicitParam(name = "carStorage", value = "库位信息", required = true, dataType = "CarStorage")
	@RequestMapping(value = "/updateStorage", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<String> updateStorage(HttpServletRequest request, CarStorage carStorage) {
		return baseDataService.updateStorage(getMember(request), carStorage);
	}
}
