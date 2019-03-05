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
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.conditon.CarAllotCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.service.car.CarAllotApplicationService;
import com.unicdata.service.car.CarAllotService;
import com.unicdata.service.car.GoodsCarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 车辆调拨
 * 
 * @author wxn
 * @date 2018年6月4日
 */
@Controller
@RequestMapping("/rulai/carAllot")
@Api(value = "车辆管理-车辆调拨", tags = { "车辆调拨相关接口" })
public class CarAllotController extends HomeBaseController {

	@Autowired
	private CarAllotService carAllotService;
	@Autowired
	private CarAllotApplicationService carAllotApplicationService;
	@Autowired
	private GoodsCarService goodsCarService;

	@ApiOperation(value = "车辆调拨列表")
	@RequestMapping(value = "/getAllotList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> getAllotList(HttpServletRequest request, Integer pageSize,
			Integer pageNum) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(
				carAllotApplicationService.selectListByStore(getMember(request).getStoreId(), pageSize, pageNum));
		return result;
	}

	@ApiOperation(value = "车辆调拨单详情")
	@RequestMapping(value = "/getAllotInfo", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> getAllotInfo(HttpServletRequest request, Integer applicationId) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		Map<String, Object> map = new HashMap<>();
		map.put("info", carAllotApplicationService.selectByPrimaryKey(applicationId));
		map.put("list", carAllotService.selectListByApplication(applicationId));
		result.setData(map);
		return result;
	}

	@ApiOperation(value = "车辆调拨新增")
	@ApiImplicitParams({ @ApiImplicitParam(name = "carBrand", value = "品牌信息", required = true, dataType = "CarBrand"),
			@ApiImplicitParam(name = "carIds", value = "车辆ids 多个id逗号分隔", required = true, dataType = "String") })
	@RequestMapping(value = "/addAllot", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<String> addAllot(HttpServletRequest request, @RequestBody CarAllotCondition carAllotCondition) {
		return goodsCarService.addAllot(getMember(request), carAllotCondition);
	}
}
