package com.unicdata.service.customer;

import com.unicdata.entity.customer.TestDrive;

import java.util.List;
import java.util.Map;

public interface TestDriveService {
    /**
     * 获取客户最后一次试驾车型名称
     * @return
     */
    String getLastDrive(Integer customerId);

    /**
     * 获取客户的所有试驾信息
     * @param customerId
     * @return
     */
    List<TestDrive> getTestDrivesByCusId(Integer customerId);

    /**
     * 保存试驾信息
     * @param testDrive
     */
    void save(TestDrive testDrive);

    /**
     * 获取员工本月试驾数
     * @param params
     * @return
     */
    int getCurrentMothTestDrive(Map<String,Object> params);
    
    /**
	 * 获取试驾车的试驾记录
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selectByCarId(Integer testCarId);

    /**
     * 获取客户某天的试驾信息
     * @param cusId
     * @param Date(2018-7-16)
     * @return
     */
	Map<String,Object> getTestInfoToday(Integer cusId , String date);
}
