package com.unicdata.controller.car;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.controller.HomeBaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 单据相关基础信息
 * 
 * @author wxn
 * @date 2018年6月11日
 */
@Controller
@RequestMapping("/rulai/invoice")
@Api(value = "单据相关基础信息", tags = { "单据相关基础信息相关接口" })
public class InvoiceInfoController extends HomeBaseController {

	@ApiOperation(value = "获取数据（操作人 操作时间）")
	@RequestMapping(value = "/getBaseData", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<Map<String, Object>> getDataIncludeCode(HttpServletRequest request, String codePrefix) {
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
		Map<String, Object> map = new HashMap<>();
		map.put("member", getMember(request));
		map.put("date", DateUtil.dateFormat(new Date(), DateUtil.sdf1));
		result.setData(map);
		return result;
	}

}
