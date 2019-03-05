package com.unicdata.service.customer.impl;

import com.unicdata.dao.car.CarTestInfoMapper;
import com.unicdata.dao.customer.CustomerMapper;
import com.unicdata.dao.customer.TestDriveMapper;
import com.unicdata.entity.car.CarTestInfo;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.TestDrive;
import com.unicdata.entity.customer.TestDriveExample;
import com.unicdata.service.customer.TestDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class TestDriveServieceImpl implements TestDriveService {

    @Autowired
    private TestDriveMapper testDriveMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CarTestInfoMapper carTestInfoMapper;

    /**
     * 开始试乘添加信息wp
     */
    @Override
    public int startTestDrive(TestDrive record) {
        return testDriveMapper.insertSelective(record);
    }

    /**
     * 试乘添加客户信息wp
     */
    @Override
    public int insertCustomerByTestDrive(Customer record) {
        return customerMapper.insertSelective(record);
    }

    @Transactional
    public int updateTestDrive(TestDrive record) {
    	int res = testDriveMapper.updateByPrimaryKeySelective(record);
    	if(res>0){
    		if(record.getEndMileage()!=null && record.getEndMileage()>0){
    			TestDrive testDrive = testDriveMapper.selectByPrimaryKey(record.getId());
//    			CarTestInfo temp = carTestInfoMapper.selectByPrimaryKey(testDrive.getTestCarId());
    			CarTestInfo testInfo = new CarTestInfo();
        		testInfo.setId(testDrive.getTestCarId());
        		testInfo.setMiles(record.getEndMileage());
        		carTestInfoMapper.updateByPrimaryKeySelective(testInfo);
    		}
    	}
        return res;
    }

    @Override
    public int insertSelective(TestDrive record) {
        return testDriveMapper.insertSelective(record);
    }

    @Override
    public TestDrive getTestDrivesByCusId(Integer customerId) {
        TestDriveExample example = new TestDriveExample();
        TestDriveExample.Criteria criteria = example.createCriteria();
        criteria.andCusIdEqualTo(customerId);
        example.setOrderByClause("id desc");
        List<TestDrive> list = testDriveMapper.selectByExample(example);
        if (list == null || list.isEmpty()) {
            return null;
        }
        TestDrive testDrive = list.get(0);
        return testDrive;
    }
    
	@Override
	public TestDrive getTestDrivesByMap(Map<String, Object> params) {
		return testDriveMapper.getTestDrivesByMap(params);
	}
	//选ID wp
	@Override
	public Map<String, Object> selectTestDriveId(Map<String, Object> map) {
		return testDriveMapper.selectTestDriveId(map);
	}

	@Override
	public List<TestDrive> getTestDriveListByMap(Map<String, Object> params) {
		return testDriveMapper.getTestDriveListByMap(params);
	}
}
