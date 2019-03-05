package com.unicdata.service.customer.impl;

import com.unicdata.dao.customer.TestDriveApplyCarMapper;
import com.unicdata.entity.customer.TestDriveApplyCar;
import com.unicdata.service.customer.TestDriveApplyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2018/6/15.
 */
@Service
public class TestDriveApplyCarServiceImpl implements TestDriveApplyCarService {
    @Autowired
    private TestDriveApplyCarMapper testDriveApplyCarMapper;

    @Override
    public int insertSelective(TestDriveApplyCar record) {
        return testDriveApplyCarMapper.insertSelective(record);
    }
}
