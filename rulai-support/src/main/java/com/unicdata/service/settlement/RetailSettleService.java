package com.unicdata.service.settlement;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.boutique.BoutiqueProceedsRecord;
import com.unicdata.entity.system.Employee;

/**
 * 精品零售service
 * 
 * @author wxn
 * @date 2018年6月23日
 */
public interface RetailSettleService {

	ApiReturnInfo<String> addRecord(Employee employee, BoutiqueProceedsRecord boutiqueProceedsRecord);

}
