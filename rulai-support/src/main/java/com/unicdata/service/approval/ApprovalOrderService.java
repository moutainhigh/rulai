package com.unicdata.service.approval;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.approval.ApprovalOrder;

import java.util.Map;

public interface ApprovalOrderService {

    /**
     * 根据参数获取点订单审批列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 根据参数获取点退订审批列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams2(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 更新审批表状态
     *
     * @param approvalOrder
     */
    void updateApprovalOrder(ApprovalOrder approvalOrder);

    /**
     * 通过id获取审批单
     *
     * @param approvalId
     * @return
     */
    ApprovalOrder selectApprovalOrder(Integer approvalId);

    /**
     * 判断是否已经审核通过
     *
     * @param approvalId
     * @return
     */
    boolean ifPass(Integer approvalId);

    /**
     * 精品经理审批通过orderId查找审批单
     * @param orderId
     * @return
     */
	ApprovalOrder selectApprovalByOrderId(Integer orderId);
}
