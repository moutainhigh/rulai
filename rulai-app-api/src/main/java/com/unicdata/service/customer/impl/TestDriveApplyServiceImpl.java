package com.unicdata.service.customer.impl;

import com.unicdata.dao.customer.TestDriveApplyMapper;
import com.unicdata.entity.customer.TestDriveApply;
import com.unicdata.service.customer.TestDriveApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/15.
 */
@Service
public class TestDriveApplyServiceImpl implements TestDriveApplyService {
    @Autowired
    private TestDriveApplyMapper testDriveApplyMapper;

    @Override
    public List<Map<String, Object>> testDriveApplyList(Map<String, Object> params) {
        return testDriveApplyMapper.testDriveApplyList(params);
    }

    @Override
    public int insertSelective(TestDriveApply record) {
        return testDriveApplyMapper.insertSelective(record);
    }
}
