package com.unicdata.dao.approval;

import com.github.pagehelper.Page;
import com.unicdata.entity.approval.ApprovalCus;

import java.util.List;
import java.util.Map;

public interface ApprovalCusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApprovalCus record);

    int insertSelective(ApprovalCus record);

    ApprovalCus selectByPrimaryKey(Integer id);

    List<ApprovalCus> selectByCusId(Integer id);

    int updateByPrimaryKeySelective(ApprovalCus record);

    int updateByPrimaryKey(ApprovalCus record);

    List<Map<String, Object>>  selectByCodeNum( Map<String, Object> map);

    Map<String, Object>  selectApprovalDetailsById(Map<String, Object> map);
    
    int getApprovalCusNum(ApprovalCus record);

    /**
     * 根据参数获取休眠/战败审批分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);
}