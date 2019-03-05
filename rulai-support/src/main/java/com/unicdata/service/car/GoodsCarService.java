package com.unicdata.service.car;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.conditon.CarAllotCondition;
import com.unicdata.conditon.CarOutApplicationCondition;
import com.unicdata.conditon.CarWarehouseCondition;
import com.unicdata.conditon.GoodsStorageCondition;
import com.unicdata.entity.system.Employee;

/**
 * 商品车service 包含商品车事务 外出 移库 调拨等
 * 
 * @author wxn
 * @date 2018年6月20日
 */
public interface GoodsCarService {

	ApiReturnInfo<Map<String, Object>> saveCar(Employee employee, GoodsStorageCondition goodsStorageCondition);

	ApiReturnInfo<String> addAllot(Employee employee, CarAllotCondition carAllotCondition);

	ApiReturnInfo<String> addOut(Employee employee, CarOutApplicationCondition carOutApplication);

	ApiReturnInfo<PageInfo<Map<String, Object>>> addWareChange(Employee employee,
			CarWarehouseCondition carWarehouseCondition);

}
