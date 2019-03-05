package com.unicdata.service.customer;

import com.unicdata.entity.customer.TestDriveApplyCar;

import java.util.List;

/**
 * Create by zhang
 */
public interface TestDriveApplyCarService {

    List selectByApplyId(Integer applyId);

    int insertTestDriveApplyCar(TestDriveApplyCar testDriveApplyCar);
}
