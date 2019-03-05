package com.unicdata.controller.car;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.conditon.CarPurchaseCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.CarPurchaseOrderService;
import com.unicdata.service.car.PurchaseCarService;
import com.unicdata.service.model.DownloadService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 车辆管理-整车采购
 * 
 * @author wxn
 * @date 2018年5月31日
 */
@Controller
@RequestMapping("/rulai/carPurchase")
@Api(value = "车辆管理-整车采购", tags = { "整车采购相关接口" })
public class CarPurchaseController extends HomeBaseController {

	@Autowired
	private CarPurchaseOrderService carPurchaseOrderService;
	@Autowired
	private CarGoodInfoService carGoodInfoService;
	@Autowired
	private DownloadService downloadService;
	@Autowired
	private PurchaseCarService purchaseCarService;

	// 文件访问路径
	@Value("${upload.access.path}")
	private String uploadAccessPath;
	// 车辆模板保存路径
	@Value("${car.file.url}")
	private String carFileUrl;
	// 车辆模板保存名称
	@Value("${car.file.name}")
	private String carFileName;
	// 选装包模板保存路径
	@Value("${optional.file.url}")
	private String optionalFileUrl;
	// 选装包模板保存名称
	@Value("${optional.file.name}")
	private String optionalFileName;

	@ApiOperation(value = "采购单列表")
	@RequestMapping(value = "/getOrderList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> getOrderList(HttpServletRequest request, Integer pageSize,
			Integer pageNum) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(carPurchaseOrderService.selectListByStore(getMember(request).getStoreId(), pageSize, pageNum));
		return result;
	}

	@ApiOperation(value = "采购单采购车辆")
	@RequestMapping(value = "/getOrderCarList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<Map<String, Object>>> getOrderCarList(HttpServletRequest request, Integer carOrderId) {
		ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(carGoodInfoService.selectByPurchaseOrder(carOrderId));
		return result;
	}

	@ApiOperation(value = "新增采购单")
	@RequestMapping(value = "/addOrder", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<String> addOrder(HttpServletRequest request,
			@RequestBody CarPurchaseCondition carPurchaseCondition) {
		return purchaseCarService.addOrder(getMember(request), carPurchaseCondition);
	}

	@ApiOperation(value = "导出车辆模板")
	@RequestMapping(value = "/downloadCarModel", method = { RequestMethod.GET })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> downloadCarModel(HttpServletRequest request,
			HttpServletResponse response) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		downloadService.saveUrlAs(response, uploadAccessPath + carFileUrl, carFileName);
		return result;
	}

	@ApiOperation(value = "导出选装包模板")
	@RequestMapping(value = "/downloadOptionalModel", method = { RequestMethod.GET })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> downloadOptionalModel(HttpServletRequest request,
			HttpServletResponse response) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		downloadService.saveUrlAs(response, uploadAccessPath + optionalFileUrl, optionalFileName);
		return result;
	}

	@ApiOperation(value = "导入车辆")
	@RequestMapping(value = "/importCar", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<Map<String, Object>>> importCar(HttpServletRequest request,
			@RequestParam(value = "mfile", required = false) MultipartFile mfile) {
		return purchaseCarService.importCar(request, getMember(request), mfile);
	}

	@ApiOperation(value = "导入选装包")
	@RequestMapping(value = "/importOptional", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<Map<String, Object>>> importOptional(HttpServletRequest request,
			@RequestParam(value = "mfile", required = false) MultipartFile mfile) {
		return purchaseCarService.importOptional(request, getMember(request), mfile);
	}

}
