package com.unicdata.service.customer.impl;

import com.unicdata.dao.customer.TestDriveApplyMapper;
import com.unicdata.entity.customer.TestDriveApply;
import com.unicdata.service.customer.TestDriveApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@Service
public class TestDriveApplyServiceImpl implements TestDriveApplyService {
    @Autowired
    private TestDriveApplyMapper testDriveApplyMapper;

    @Override
    public List<Map<String, Object>> testCarApprovalList(Map param) {
        return testDriveApplyMapper.testCarApprovalList(param);
    }

    @Override
    public List<Map<String, Object>> testCarApprovalCars(Integer applyId) {
        return testDriveApplyMapper.testCarApprovalCars(applyId);
    }

    @Override
    public int updatetestCarApproval(TestDriveApply testDriveApply) {
        return testDriveApplyMapper.updateByPrimaryKeySelective(testDriveApply);
    }

    @Override
    public TestDriveApply selectByPrimaryKey(Integer id) {
        return testDriveApplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertTestCarApproval(TestDriveApply testDriveApply) {
        testDriveApplyMapper.insertSelective(testDriveApply);
        return testDriveApply.getId();
    }

    @Override
    public List listByCreateId(Integer createId) {
        return testDriveApplyMapper.listByCreateId(createId);
    }
}
