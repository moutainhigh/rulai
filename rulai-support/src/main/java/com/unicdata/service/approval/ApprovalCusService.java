package com.unicdata.service.approval;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.approval.ApprovalCus;

import java.util.Map;

public interface ApprovalCusService {

    /**
     * 根据参数获取休眠/战败审批列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 通过审批单id获取审批单
     *
     * @param id
     * @return
     */
    ApprovalCus selectByPrimaryKey(Integer id);

    /**
     * 更新审批单信息
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ApprovalCus record);
}
