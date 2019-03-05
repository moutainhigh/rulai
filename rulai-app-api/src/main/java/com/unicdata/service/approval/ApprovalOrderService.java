package com.unicdata.service.approval;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.approval.ApprovalOrder;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/1.
 */
public interface ApprovalOrderService {

    //订单审批分页
    PageInfo selectByCodeNum( Map<String, Object> map, Integer pageNum, Integer pageSize);

    //门店订单审批数
    List<Map<String, Object>> selectOrderByStoreId(Map<String, Object> map);

    Map<String, Object> approvvalOrderDetails(Integer orderId);
    
    /**
     * 发起订单状态审批
     * @param record
     * @return
     */
    int createApprovalOrder(ApprovalOrder record);

    ApprovalOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApprovalOrder record);
    
    /**
     * 获取订单审批条数
     * @param employeeId
     * @return
     */
    int getApprovalOrderNum(Integer employeeId);

    /**
     * 通过订单id,获取
     * @param orderId
     * @return
     */
    ApprovalOrder selectByCusId(Integer orderId);

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
     *通过order和type查询
     * @param map
     * @return
     */
    List<ApprovalOrder> selectByOrderId(Map<String, Object> map);
}
