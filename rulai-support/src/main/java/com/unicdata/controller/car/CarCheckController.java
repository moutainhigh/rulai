package com.unicdata.controller.car;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.condition.CarCheckConditon;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.service.car.CarDepotCheckService;
import com.unicdata.service.system.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 车辆盘点
 * 
 * @author wxn
 * @date 2018年6月21日
 */
@Controller
@RequestMapping("/rulai/carCheck")
@Api(value = "车辆管理-车辆盘点", tags = { "车辆盘点相关接口" })
public class CarCheckController extends HomeBaseController{

	@Autowired
	private CarDepotCheckService carDepotCheckService;
	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "盘点列表")
	@RequestMapping(value = "/getCheckList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<PageInfo<Map<String, Object>>> getCheckList(HttpServletRequest request,
			CarCheckConditon carCheckConditon) {
		carCheckConditon.setStoreId(getMember(request).getStoreId());
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		PageInfo<Map<String, Object>> page = carDepotCheckService.selectListByStore(carCheckConditon);
		for (int i = 0; i < page.getList().size(); i++) {
			Map<String, Object> map = page.getList().get(i);
			List<String> idList = Arrays.asList((map.get("checker") + "").split(","));
			StringBuilder sb = new StringBuilder();
			// 盘点人名称
			for (int j = 0; j < idList.size(); j++) {
				if (StringUtil.isNotBlank(sb.toString())) {
					sb.append("/");
				}
				sb.append(employeeService.selectByPrimaryKey(Integer.valueOf(idList.get(j))).getFullName());
			}
			map.put("checkerNames", sb.toString());
			// 仓库名称
			List<String> warehouseList = carDepotCheckService.selectWarehouseByNumber(map.get("number") + "");
			map.put("wareHouseNames", StringUtil.join(warehouseList.toArray(), "/"));
		}
		result.setData(page);
		return result;
	}

	@ApiOperation(value = "盘点单车辆列表")
	@RequestMapping(value = "/getCarList", method = { RequestMethod.POST })
	@ResponseBody
	public ApiReturnInfo<List<Map<String, Object>>> getCarList(HttpServletRequest request, String number) {
		ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<>();
		result.setData(carDepotCheckService.selectCarByNumber(getMember(request).getStoreId(), number));
		return result;
	}

}
