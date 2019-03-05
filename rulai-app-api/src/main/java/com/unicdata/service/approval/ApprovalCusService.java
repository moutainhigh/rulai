package com.unicdata.service.approval;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.approval.ApprovalCus;
import com.unicdata.entity.system.Employee;

import java.util.List;
import java.util.Map;

/**
 * 人员审批和订单审批
 * Created by lenovo on 2018/6/1.
 */
public interface ApprovalCusService {
    PageInfo selectByCodeNum(Map<String, Object> map, Integer pageNum, Integer pageSize);

    Map<String, Object> selectApprovalDetailsById(Employee emp,Integer codeNum);
    
    /**
     * 发起休眠或战败审批
     * @param record
     * @return
     */
    int createApprovalCustomer(ApprovalCus record);

    int updateByPrimaryKeySelective(ApprovalCus record);

    ApprovalCus selectByPrimaryKey(Integer id);
    
    /**
     * 获取客户审批条数
     * @param employeeId
     * @return
     */
    int getApprovalCusNum(Integer employeeId);

    /**
     * 通过客户id获取审批
     * @param id
     * @return
     */
    List<ApprovalCus> selectByCusId(Integer id);
}
