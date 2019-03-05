package com.unicdata.service.customer;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.TestDrive;

/**
 * 潜客试驾service
 *
 * @author admin
 */
public interface TestDriveService {
    /**
     * 试驾开始 wp
     *
     * @param record
     * @return
     */
    int startTestDrive(TestDrive record);

    /**
     * 试驾生成客户信息 wp
     *
     * @param record
     * @return
     */
    int insertCustomerByTestDrive(Customer record);

    /**
     * 修改试驾信息
     *
     * @param record
     * @return
     */
    int updateTestDrive(TestDrive record);


    /**
     * 添加试驾车信息
     *
     * @param record
     * @return
     */
    int insertSelective(TestDrive record);

    /**
     * 通过客户id后去最后一次试驾信息
     *
     * @param customerId
     * @return
     */
    public TestDrive getTestDrivesByCusId(Integer customerId);
    /**
     * 根据map条件查询
     * @param params
     * @return
     */
    public TestDrive getTestDrivesByMap(Map<String,Object> params);
    //选ID
    Map<String, Object> selectTestDriveId(Map<String, Object> map);
    
    public List<TestDrive> getTestDriveListByMap(Map<String,Object> params);
}
