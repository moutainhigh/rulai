package com.unicdata.controller.settlement;

import java.util.HashMap;
import java.util.List;
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
import com.unicdata.condition.RetailSettleCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.BoutiqueProceedsRecord;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.service.boutique.ProceedsRecordSupportService;
import com.unicdata.service.boutique.RetailIncludeSupportService;
import com.unicdata.service.boutique.RetailSupportService;
import com.unicdata.service.settlement.RetailSettleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 财务管理-独立精品结算管理
 * 
 * @author wxn
 * @date 2018年6月4日
 */
@Controller
@RequestMapping("rulai/settleRetail")
@Api(value = "财务管理-独立精品结算管理", tags = { "财务管理-独立精品结算管理相关接口" })
public class RetailSettleController extends HomeBaseController {

	@Autowired
	private ProceedsRecordSupportService proceedsRecordSupportService;

	@Autowired
	private RetailSupportService retailSupportService;

	@Autowired
	private RetailIncludeSupportService retailIncludeSupportService;

	@Autowired
	private RetailSettleService retailSettleService;

	@ApiOperation(value = "订单列表")
	@ApiImplicitParam(name = "retailSettleCondition", value = "查询条件", required = true, dataType = "RetailSettleCondition")
	@RequestMapping(value = "/getRetailList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> getRetailList(HttpServletRequest request,
			@RequestBody RetailSettleCondition retailSettleCondition) {
		retailSettleCondition.setStoreId(getMember(request).getStoreId());
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(retailSupportService.selectListByCondition(retailSettleCondition));
		return result;
	}

	@ApiOperation(value = "订单绑定精品列表")
	@ApiImplicitParam(name = "retailId", value = "订单id", required = true, dataType = "Integer")
	@RequestMapping(value = "/getBoutique", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> getBoutique(HttpServletRequest request, Integer retailId) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		List<Map<String, Object>> list = retailIncludeSupportService.selectListByRetail(retailId);
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("list", list);
		BoutiqueRetail boutiqueRetail = retailSupportService.selectBoutiqueRetailDetailById(retailId);
		returnMap.put("saleCount", boutiqueRetail.getSaleCount());
		returnMap.put("applyCount", boutiqueRetail.getApplyCount());
		result.setData(returnMap);
		return result;
	}

	@ApiOperation(value = "订单收款退款记录")
	@ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer")
	@RequestMapping(value = "/getRecord", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> getRecord(HttpServletRequest request, Integer orderId, Integer type) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		result.setData(proceedsRecordSupportService.selectByRetail(orderId, type));
		return result;
	}

	@ApiOperation(value = "收款/退款")
	@ApiImplicitParam(name = "boutiqueProceedsRecord", value = "信息", required = true, dataType = "BoutiqueProceedsRecord")
	@RequestMapping(value = "/addRecord", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<String> addRecord(HttpServletRequest request,
			@RequestBody BoutiqueProceedsRecord boutiqueProceedsRecord) {
		return retailSettleService.addRecord(getMember(request), boutiqueProceedsRecord);
	}

}
