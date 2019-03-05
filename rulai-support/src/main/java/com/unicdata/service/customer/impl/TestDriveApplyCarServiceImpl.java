package com.unicdata.service.customer.impl;

import com.unicdata.dao.customer.TestDriveApplyCarMapper;
import com.unicdata.entity.customer.TestDriveApplyCar;
import com.unicdata.entity.customer.TestDriveApplyCarExample;
import com.unicdata.service.customer.TestDriveApplyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@Service
public class TestDriveApplyCarServiceImpl implements TestDriveApplyCarService {

    @Autowired
    private TestDriveApplyCarMapper testDriveApplyCarMapper;

    @Override
    public List selectByApplyId(Integer applyId) {
        List<Map<String, Object>> testDriveApplyCars = testDriveApplyCarMapper.selectByApplyId(applyId);
        return testDriveApplyCars;
    }

    @Override
    public int insertTestDriveApplyCar(TestDriveApplyCar testDriveApplyCar) {
        return testDriveApplyCarMapper.insertSelective(testDriveApplyCar);
    }
}
