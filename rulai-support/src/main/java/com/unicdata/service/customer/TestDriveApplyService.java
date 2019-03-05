package com.unicdata.service.customer;

import com.unicdata.entity.customer.TestDriveApply;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
public interface TestDriveApplyService {
    /**
     * 获取试驾车申请列表
     *
     * @param storeId
     * @return
     */
    List<Map<String, Object>> testCarApprovalList(Map param);

    /**
     * 获取试驾车申请车辆列表
     *
     * @param applyId
     * @return
     */
    List<Map<String, Object>> testCarApprovalCars(Integer applyId);

    /**
     * 修改审批记录
     */
    int updatetestCarApproval(TestDriveApply testDriveApply);

    /**
     * 根据审批id获取审批单详情
     *
     * @param id
     * @return
     */
    TestDriveApply selectByPrimaryKey(Integer id);

    /**
     * 插入试驾车申请数据
     */
    int insertTestCarApproval(TestDriveApply testDriveApply);

    /**
     * 根据发起人id获取申请列表
     */
    List listByCreateId(Integer createId);
}
