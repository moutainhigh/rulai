package com.unicdata.service.customer.impl;

import com.google.common.collect.Maps;
import com.unicdata.dao.customer.TestDriveMapper;
import com.unicdata.entity.customer.TestDrive;
import com.unicdata.entity.customer.TestDriveExample;
import com.unicdata.service.customer.TestDriveService;
import com.unicdata.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Transactional(readOnly = true)
@Service
public class TestDriveServiceImpl implements TestDriveService {

    @Autowired
    private TestDriveMapper testDriveMapper;

    @Override
    public String getLastDrive(Integer customerId) {
        List<TestDrive> list = getTestDrivesByCusId(customerId);
        if (list == null || list.isEmpty()) {
            return "";
        }
        TestDrive testDrive = list.get(0);
        return testDrive.getVehicleName();
    }

    @Override
    public List<TestDrive> getTestDrivesByCusId(Integer customerId) {
        TestDriveExample example = new TestDriveExample();
        TestDriveExample.Criteria criteria = example.createCriteria();
        criteria.andCusIdEqualTo(customerId);
        example.setOrderByClause("id desc");
        List<TestDrive> testDrives = testDriveMapper.selectByExample(example);
        return testDrives;
    }

    @Transactional(readOnly = false)
    @Override
    public void save(TestDrive testDrive) {
        testDriveMapper.updateByPrimaryKeySelective(testDrive);
    }

    @Override
    public int getCurrentMothTestDrive(Map<String, Object> params) {
        return testDriveMapper.getCurrentMothTestDrive(params);
    }

    @Override
    public List<Map<String, Object>> selectByCarId(Integer testCarId) {
        return testDriveMapper.selectByCarId(testCarId);
    }

    @Override
    public Map<String, Object> getTestInfoToday(Integer cusId, String date) {
        Map<String, Object> result = Maps.newHashMap();
        //试驾开始时间
        Date driveBeginTime = null;
        //试驾结束时间
        Date driveEndTime = null;
        Long driveTime = null;
        Date todayBegin = DateUtil.stringToDate(date + " 00:00:00", DateUtil.sdf1);
        Date todayEnd = DateUtil.stringToDate(date + " 23:59:59", DateUtil.sdf1);
        TestDriveExample example1 = new TestDriveExample();
        TestDriveExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andCusIdEqualTo(cusId);
        criteria1.andCreateTimeGreaterThanOrEqualTo(todayBegin);
        criteria1.andCreateTimeLessThanOrEqualTo(todayEnd);
        example1.setOrderByClause("create_time ASC");
        List<TestDrive> drives1 = testDriveMapper.selectByExample(example1);
        TestDriveExample example2 = new TestDriveExample();
        TestDriveExample.Criteria criteria2 = example1.createCriteria();
        criteria2.andCusIdEqualTo(cusId);
        criteria2.andCreateTimeGreaterThanOrEqualTo(todayBegin);
        criteria2.andCreateTimeLessThanOrEqualTo(todayEnd);
        example2.setOrderByClause("end_time DESC");
        List<TestDrive> drives2 = testDriveMapper.selectByExample(example2);
        //试驾车型名称集合
        List<String> names = Lists.newArrayList();
        if (drives1 != null && !drives1.isEmpty()) {
            driveBeginTime = drives1.get(0).getCreateTime();
            driveEndTime = drives2.get(0).getEndTime();
            for (TestDrive drive : drives1) {
                names.add(drive.getVehicleName());
            }
        }
        String driveCars = StringUtils.join(names, ",");
        result.put("driveBeginTime", driveBeginTime);
        result.put("driveEndTime", driveEndTime);
        result.put("driveCars", driveCars);
        result.put("driveTime", (driveBeginTime != null && driveEndTime != null) ? DateUtil.howLong("m", driveBeginTime, driveEndTime) : null);
        result.put("doTestDrive", (drives1 == null || drives1.isEmpty()) ? "否" : "是");
        return result;
    }
}
