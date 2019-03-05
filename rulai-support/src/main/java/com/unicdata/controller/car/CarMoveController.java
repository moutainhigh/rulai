package com.unicdata.controller.car;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.condition.CarGoodsCondition;
import com.unicdata.conditon.CarOutApplicationCondition;
import com.unicdata.conditon.CarWarehouseCondition;
import com.unicdata.constant.CarEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarOutApplication;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.CarOutApplicationService;
import com.unicdata.service.car.CarOutService;
import com.unicdata.service.car.CarWarehouseChangeRecordService;
import com.unicdata.service.car.GoodsCarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 车辆外出、移库
 * 
 * @author wxn
 * @date 2018年6月3日
 */
@Controller
@RequestMapping("/rulai/carMove")
@Api(value = "车辆管理-车辆外出、移库", tags = { "车辆管理-车辆外出、移库相关接口" })
public class CarMoveController extends HomeBaseController {

	@Autowired
	private CarGoodInfoService carGoodInfoService;
	@Autowired
	private CarOutService carOutService;
	@Autowired
	private CarOutApplicationService carOutApplicationService;
	@Autowired
	private CarWarehouseChangeRecordService carWarehouseChangeRecordService;
	@Autowired
	private GoodsCarService goodsCarService;

	@ApiOperation(value = "外出申请列表")
	@RequestMapping(value = "/getOutList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<CarOutApplication>> getOutList(HttpServletRequest request, Integer pageSize,
			Integer pageNum) {
		ApiReturnInfo<PageInfo<CarOutApplication>> result = new ApiReturnInfo<>();
		result.setData(carOutApplicationService.selectListByStore(getMember(request).getStoreId(), pageSize, pageNum));
		return result;
	}

	@ApiOperation(value = "外出申请单详情")
	@ApiImplicitParam(name = "carOutId", value = "外出申请单id", required = true, dataType = "Integer")
	@RequestMapping(value = "/getOutInfo", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> getOutInfo(HttpServletRequest request, Integer carOutId) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		Map<String, Object> map = new HashMap<>();
		map.put("info", carOutApplicationService.selectByPrimaryKey(carOutId));
		map.put("carList", carOutService.selectListByApplicationId(carOutId));
		result.setData(map);
		return result;
	}

	@ApiOperation(value = "商品车列表")
	@ApiImplicitParam(name = "carGoodsCondition", value = "查询条件", required = true, dataType = "CarGoodsCondition")
	@RequestMapping(value = "/getStorageList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> getStorageList(HttpServletRequest request,
			CarGoodsCondition carGoodsCondition) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		carGoodsCondition.setDistributorStoreId(getMember(request).getStoreId());
		result.setData(carGoodInfoService.selectListByStoreSimplify(carGoodsCondition));
		return result;
	}

	@ApiOperation(value = "车辆外出新增")
	@ApiImplicitParam(name = "carOutApplication", value = "外出申请", required = true, dataType = "CarOutApplicationCondition")
	@RequestMapping(value = "/addOut", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<String> addOut(HttpServletRequest request,
			@RequestBody CarOutApplicationCondition carOutApplication) {
		return goodsCarService.addOut(getMember(request), carOutApplication);
	}

	@ApiOperation(value = "外出车辆入库")
	@ApiImplicitParam(name = "applicationId", value = "外出申请id", required = true, dataType = "Integer")
	@RequestMapping(value = "/carsMoveIn", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> carsMoveIn(HttpServletRequest request, Integer applicationId) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		CarOutApplication carOutApplication = new CarOutApplication();
		carOutApplication.setId(applicationId);
		carOutApplication.setApplicateStatus(CarEnum.OutStatus.IN.getCode());
		carOutApplicationService.updateByPrimaryKeySelective(carOutApplication);
		int num = carGoodInfoService.updateByOutApplication(CarEnum.CarStorageStatus.IN_STORAGE.getCode(),
				applicationId);
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

	@ApiOperation(value = "车辆移库列表")
	@RequestMapping(value = "/getWareChangeList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> getWareChangeList(HttpServletRequest request, Integer pageSize,
			Integer pageNum) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(
				carWarehouseChangeRecordService.selectListByStore(getMember(request).getStoreId(), pageSize, pageNum));
		return result;
	}

	@ApiOperation(value = "车辆移库详情")
	@RequestMapping(value = "/getInfo", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> getInfo(HttpServletRequest request, Integer id) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		Map<String, Object> map = new HashMap<>();
		map.put("info", carWarehouseChangeRecordService.selectByPrimaryKey(id));
		map.put("list", carWarehouseChangeRecordService.selectByRecordId(id));
		result.setData(map);
		return result;
	}

	@ApiOperation(value = "车辆移库新增")
	@RequestMapping(value = "/addWareChange", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> addWareChange(HttpServletRequest request,
			@RequestBody CarWarehouseCondition carWarehouseCondition) {
		return goodsCarService.addWareChange(getMember(request), carWarehouseCondition);
	}
}
