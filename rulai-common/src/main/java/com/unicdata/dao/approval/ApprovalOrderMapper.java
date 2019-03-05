package com.unicdata.dao.approval;

import com.github.pagehelper.Page;
import com.unicdata.entity.approval.ApprovalOrder;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ApprovalOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApprovalOrder record);

    int insertSelective(ApprovalOrder record);

    ApprovalOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApprovalOrder record);

    int updateByPrimaryKey(ApprovalOrder record);

    List<Map<String, Object>> selectByCodeNum(Map<String, Object> map);

    /**
     *通过order和type查询
     * @param map
     * @return
     */
    List<ApprovalOrder> selectByOrderId(Map<String, Object> map);

    Map<String, Object> selectApprovvalOrderDetailsByOrderId(Integer orderId);

    ApprovalOrder selectByCusId(Integer orderId);

    int getApprovalOrderNum(ApprovalOrder record);

    /**
     * 根据参数获取订单审批分页列表
     *
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String, Object> params);

    /**
     * 根据参数获取退订审批分页列表
     *
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams2(Map<String, Object> params);

	ApprovalOrder selectApprovalByOrderId(@Param("orderId")Integer orderId);
}