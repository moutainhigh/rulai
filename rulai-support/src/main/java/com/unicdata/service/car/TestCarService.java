package com.unicdata.service.car;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.car.CarTestInfo;
import com.unicdata.entity.system.Employee;

/**
 * 试驾车service
 * 
 * @author wxn
 * @date 2018年6月20日
 */
public interface TestCarService {
	
	ApiReturnInfo<String> updateStorage(Employee employee, CarTestInfo carTestInfo);

}
