package com.unicdata.service.car;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.conditon.CarPurchaseCondition;
import com.unicdata.entity.system.Employee;

/**
 * 车辆采购service
 * 
 * @author wxn
 * @date 2018年6月20日
 */
public interface PurchaseCarService {

	ApiReturnInfo<String> addOrder(Employee employee, CarPurchaseCondition carPurchaseCondition);

	ApiReturnInfo<List<Map<String, Object>>> importCar(HttpServletRequest request, Employee employee,
			MultipartFile mfile);

	ApiReturnInfo<List<Map<String, Object>>> importOptional(HttpServletRequest request, Employee employee,
			MultipartFile mfile);

}
