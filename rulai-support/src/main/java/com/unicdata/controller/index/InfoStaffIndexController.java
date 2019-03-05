package com.unicdata.controller.index;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.condition.CarGoodsCondition;
import com.unicdata.constant.BaseEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.app.OrderService;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.DeliverCarService;
import com.unicdata.service.customer.PassengerFlowService;
import com.unicdata.service.customer.TaskFollowUpService;
import com.unicdata.service.employee.EmployeeTargetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 信息员首页
 * 
 * @author wxn
 * @date 2018年6月13日
 */
@Controller
@RequestMapping("/rulai/infoStaff")
@Api(value = "信息员首页", tags = { "信息员首页相关接口" })
public class InfoStaffIndexController extends HomeBaseController {

	@Autowired
	private EmployeeTargetService employeeTargetService;
	@Autowired
	private CarGoodInfoService carGoodInfoService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private DeliverCarService appDeliverCarService;
	@Autowired
	private PassengerFlowService passengerFlowService;
	@Autowired
	private TaskFollowUpService taskFollowUpService;

	@ApiOperation(value = "信息员首页")
	@ResponseBody
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ApiReturnInfo<Map<String, Object>> saleManagerIndex(HttpServletRequest request) {
		// 当前用户
		Employee emp = getMember(request);
		ApiReturnInfo<Map<String, Object>> ar = new ApiReturnInfo<>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		map.put("storeId", emp.getStoreId());
		map.put("targetTime", new Date());
		// 本月目标map
		Map<String, Object> stringObjectMap = employeeTargetService.getMothTargetNumByStoreId(map);

		// 创建一个数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(2);

		// 待定判断订单状态
		map.put("mouthTime", new Date());
		Map<String, Object> map1 = orderService.getMothOrderNumByStoreId(map);

		// 本月目标订单数
		hashMap.put("orderSum", Integer.valueOf(stringObjectMap.get("orderSum").toString()));

		// 本月订单实际总数
		hashMap.put("orderRealSum", map1.get("sum") != null ? map1.get("sum") : 0);
		// 计划毛利收入 暂时没有
		hashMap.put("marginSum", 0);
		// 实际毛利
		BigDecimal marginRealSum = map1.get("sumMargin") != null ? new BigDecimal(map1.get("sumMargin") + "")
				: new BigDecimal(0);
		hashMap.put("marginRealSum", marginRealSum);
		hashMap.put("marginRealSumShow", marginRealSum.divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP) + "万");
		// 本月待交车数
		map.put("deliverTime", new Date());
		hashMap.put("stayCarRealSum", taskFollowUpService.selectCountByStore(map));
		// 本月已交车数
		hashMap.put("alreadyCarRealSum", appDeliverCarService.getMothDeliverCarNumByStoreId(map));

		// 本月交车目标数
		hashMap.put("alreadyCarSum", Integer.valueOf(stringObjectMap.get("deliverSum").toString()));

		// 当日交车数
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("dayTime", new Date());
		map3.put("storeId", emp.getStoreId());
		hashMap.put("thisDayCarSum", appDeliverCarService.getMothDeliverCarNumByStoreId(map3));

		// 当日订单
		int allNum = orderService.getMothOrderNumByStoreId(map3) != null
				? Integer.valueOf(orderService.getMothOrderNumByStoreId(map3).get("sum") + "") : 0;
		map3.put("groupName", "客服部");
		int dccNum = orderService.getMothOrderNumByStoreId(map3) != null
				? Integer.valueOf(orderService.getMothOrderNumByStoreId(map3).get("sum") + "") : 0;
		map3.put("groupName", "销售部");
		int saleNum = orderService.getMothOrderNumByStoreId(map3) != null
				? Integer.valueOf(orderService.getMothOrderNumByStoreId(map3).get("sum") + "") : 0;
		hashMap.put("thisDayDcc", dccNum);
		hashMap.put("thisDaySale", saleNum);
		hashMap.put("thisDayOther", allNum - dccNum - saleNum);

		// 当日DCC 暂时不做

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("createTime", new Date());
		map2.put("storeId", emp.getStoreId());
		// 首次客流量
		map2.put("type", 1);
		int firstSum = passengerFlowService.getMouthPassengerFlowList(map2);
		hashMap.put("firstSum", firstSum);
		// 再次客流量
		map2.put("type", 2);
		int againSum = passengerFlowService.getMouthPassengerFlowList(map2);
		hashMap.put("againSum", againSum);

		// 库存总数
		CarGoodsCondition carGoodsCondition = new CarGoodsCondition();
		carGoodsCondition.setDistributorStoreId(emp.getStoreId());
		// 库存状态为在库、外出、整备出库，处理状态为正常、待整备、整备中、暂收，订单状态为无、已预订
		carGoodsCondition.setType(3);
		PageInfo<Map<String, Object>> maps1 = carGoodInfoService.selectListByStoreSimplify(carGoodsCondition);
		hashMap.put("storageSum", maps1.getList().size());
		// 利息总额
		BigDecimal bigDecimal = new BigDecimal(0);
		for (Map<String, Object> objectMap : maps1.getList()) {
			Object interestPrice = objectMap.get("interestPrice");
			if (interestPrice != null) {
				BigDecimal bigDecimal1 = new BigDecimal(interestPrice.toString());
				if (bigDecimal1 != null) {
					bigDecimal = bigDecimal.add(bigDecimal1);
				}
			}
		}
		// 库存利息总额 转换成万
		hashMap.put("interest", bigDecimal.divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP) + "万");
		// 警戒占比
		carGoodsCondition.setInStorageDay(BaseEnum.CAR_STORAGE_WARN);
		PageInfo<Map<String, Object>> maps2 = carGoodInfoService.selectListByStoreSimplify(carGoodsCondition);
		hashMap.put("carList", maps2.getList());
		if (maps1.getList().size() > 0 && maps2.getList().size() > 0) {
			String vigilancePercent = numberFormat
					.format((float) maps2.getList().size() * 100 / (float) maps1.getList().size() * 10000) + "%";
			hashMap.put("vigilancePercent", vigilancePercent);
		} else {
			hashMap.put("vigilancePercent", 0);
		}
		// 库存系数：现有库存总数除以未来3个月平均销量（手动录入未来3个月平均销量值）
		// 未来3个月平均销量值
		Integer integer = BaseEnum.CAR_AVERAGE_SALE;
		if (integer != 0) {
			hashMap.put("coefficient", numberFormat.format((float) maps1.getList().size() / (float) integer));
		}
		ar.setData(hashMap);
		return ar;
	}

	@ApiOperation(value = "库存警戒车辆")
	@ResponseBody
	@RequestMapping(value = "/carList", method = RequestMethod.POST)
	public ApiReturnInfo<PageInfo<Map<String, Object>>> carList(HttpServletRequest request,
			CarGoodsCondition carGoodsCondition) {
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
		// 警戒占比
		carGoodsCondition.setDistributorStoreId(getMember(request).getStoreId());
		carGoodsCondition.setInStorageDay(BaseEnum.CAR_STORAGE_WARN);
		PageInfo<Map<String, Object>> maps2 = carGoodInfoService.selectListByStoreSimplify(carGoodsCondition);
		result.setData(maps2);
		return result;
	}

}
