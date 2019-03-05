package com.unicdata.controller.car;

import java.util.Date;
import java.util.HashMap;
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
import com.unicdata.base.util.DateUtil;
import com.unicdata.base.util.StringUtil;
import com.unicdata.condition.CarGoodsCondition;
import com.unicdata.conditon.GoodsStorageCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarOptionalPackage;
import com.unicdata.service.car.CarBoutiqueBindingService;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.CarOptionalPackageService;
import com.unicdata.service.car.GoodsCarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 车辆管理-商品车库存
 * 
 * @author wxn
 * @date 2018年6月2日
 */
@Controller
@RequestMapping("/rulai/carGoods")
@Api(value = "车辆管理-商品车库存", tags = { "商品车库存相关接口" })
public class GoodsStorageController extends HomeBaseController {

	// 文件访问路径
	@Value("${upload.access.path}")
	private String uploadAccessPath;

	@Autowired
	private CarGoodInfoService carGoodInfoService;
	@Autowired
	private CarOptionalPackageService carOptionalPackageService;
	@Autowired
	private CarBoutiqueBindingService carBoutiqueBindingService;
	@Autowired
	private GoodsCarService goodsCarService;

	@ApiOperation(value = "商品车列表")
	@ApiImplicitParam(name = "carGoodsCondition", value = "查询条件", required = true, dataType = "CarGoodsCondition")
	@RequestMapping(value = "/getStorageList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> getStorageList(HttpServletRequest request,
			@RequestBody CarGoodsCondition carGoodsCondition) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		carGoodsCondition.setDistributorStoreId(getMember(request).getStoreId());
		PageInfo<Map<String, Object>> page = carGoodInfoService.selectListByStore(carGoodsCondition);
		for (int i = 0; i < page.getList().size(); i++) {
			Map<String, Object> map = page.getList().get(i);
			if (StringUtil.isNotBlank(map.get("warehousePicture") + "")
					&& !StringUtil.equals("null", map.get("warehousePicture") + "")) {
				map.put("warehousePicture", uploadAccessPath + map.get("warehousePicture"));
			}
			page.getList().set(i, map);

		}
		result.setData(page);
		return result;
	}

	@ApiOperation(value = "商品车选装件信息")
	@ApiImplicitParam(name = "carId", value = "车辆id", required = true, dataType = "Integer")
	@RequestMapping(value = "/getOptional", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<CarOptionalPackage>> getOptional(HttpServletRequest request, Integer carId) {
		ApiReturnInfo<List<CarOptionalPackage>> result = new ApiReturnInfo<>();
		CarGoodInfo carGoodInfo = carGoodInfoService.selectByPrimaryKey(carId);
		result.setData(carOptionalPackageService.selectByVin(carGoodInfo.getVin()));
		return result;
	}

	@ApiOperation(value = "商品车精品信息")
	@ApiImplicitParam(name = "carId", value = "车辆id", required = true, dataType = "Integer")
	@RequestMapping(value = "/getBoutique", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<Map<String, Object>>> getBoutique(HttpServletRequest request, Integer carId) {
		ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(carBoutiqueBindingService.selectByCarId(carId));
		return result;
	}

	@ApiOperation(value = "商品车全部信息")
	@ApiImplicitParam(name = "carId", value = "车辆id", required = true, dataType = "Integer")
	@RequestMapping(value = "/getInfo", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> getInfo(HttpServletRequest request, Integer carId) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> carGoodInfo = carGoodInfoService.selectById(carId);
		// 拼接图片地址
		if (StringUtil.isNotBlank(carGoodInfo.get("warehousePicture") + "")
				&& !StringUtil.equals("null", carGoodInfo.get("warehousePicture") + "")) {
			carGoodInfo.put("warehousePicture", uploadAccessPath + carGoodInfo.get("warehousePicture"));
		}
		map.put("carInfo", carGoodInfo);
		if (null != carGoodInfo && null != carGoodInfo.get("vin")) {
			map.put("optionalList", carOptionalPackageService.selectByVin(carGoodInfo.get("vin") + ""));
		}
		List<Map<String, Object>> list = carBoutiqueBindingService.selectByCarId(carId);
		// 计算精品在库天数
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> boutique = list.get(i);
			String time = boutique.get("lastPushTime") + "";
			long carStayDay = 0;
			if (StringUtil.isNotBlank(time) && !StringUtil.equals(time, "null")) {
				carStayDay = DateUtil.howLong("d", DateUtil.stringToDate(time, DateUtil.sdf1), new Date());
			}
			boutique.put("carStayDay", carStayDay);
			list.set(i, boutique);
		}
		map.put("boutiqueList", list);
		result.setData(map);
		return result;
	}

	@ApiOperation(value = "保存商品车信息")
	@RequestMapping(value = "/saveCar", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> saveCar(HttpServletRequest request,
			@RequestBody GoodsStorageCondition goodsStorageCondition) {
		return goodsCarService.saveCar(getMember(request), goodsStorageCondition);
	}

}
