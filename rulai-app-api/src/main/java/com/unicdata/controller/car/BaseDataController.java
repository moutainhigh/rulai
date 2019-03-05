package com.unicdata.controller.car;

import java.util.HashMap;
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
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarBrand;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.AppCarBrandService;
import com.unicdata.service.car.AppCarFamilyService;
import com.unicdata.service.car.AppCarVehicleConfService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 车辆管理基础数据接口 品牌、车系、车型、仓库
 * 
 * @author wxn
 * @date 2018年5月31日
 */
@Controller
@RequestMapping("/app/carData")
@Api(value = "车辆管理-基础数据", tags = { "品牌、车系、车型、仓库相关接口" })
public class BaseDataController extends HomeBaseController {

	// 文件访问路径
	@Value("${upload.access.path}")
	private String uploadAccessPath;

	@Autowired
	private AppCarBrandService carBrandService;
	@Autowired
	private AppCarFamilyService carFamilyService;
	@Autowired
	private AppCarVehicleConfService carVehicleConfService;
	

	@ApiOperation(value = "品牌列表")
	@RequestMapping(value = "/getBrandList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo getBrandList(HttpServletRequest request, Integer pageSize,
			Integer pageNum) {
		ApiReturnInfo result = new ApiReturnInfo();
		Map<String,Object> map = new HashMap<String, Object>();
		PageInfo pageInfo = carBrandService.selectListByStore(getMember(request).getStoreId(), pageSize, pageNum);
		map.put("brandList",pageInfo.getList());
		map.put("pageResult", getPageResult(pageInfo));
		result.setData(map);
		return result;
	}

	@ApiOperation(value = "通过品牌id获取车系列表(下拉)")
	@RequestMapping(value = "/getFamilyByBrand", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo getFamilyByBrand(HttpServletRequest request, Integer brandId) {
		ApiReturnInfo result = new ApiReturnInfo<>();
		//当前用户
        Employee emp = getMember(request);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("storeId", emp.getStoreId());
		params.put("brandId", brandId);
		PageInfo pageInfo = carFamilyService.selectListByBrandId(params,null,null);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("familyList",pageInfo.getList());
		map.put("pageResult", getPageResult(pageInfo));
		result.setData(map);
		return result;
	}

	@ApiOperation(value = "通过车系id获取车型列表(下拉)")
	@RequestMapping(value = "/getVehicleByFamily", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo getVehicleByBrand(HttpServletRequest request, Integer familyId) {
		ApiReturnInfo result = new ApiReturnInfo<>();
		//当前用户
        Employee emp = getMember(request);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("storeId", emp.getStoreId());
		params.put("familyId", familyId);
		PageInfo pageInfo = carVehicleConfService.selectListByBrandId(params,null,null);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("vehicleList",pageInfo.getList());
		map.put("pageResult", getPageResult(pageInfo));
		result.setData(map);
		return result;
	}
}
