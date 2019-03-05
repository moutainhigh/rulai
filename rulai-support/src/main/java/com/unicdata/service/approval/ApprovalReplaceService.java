package com.unicdata.service.approval;

import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface ApprovalReplaceService {

    /**
     * 根据参数获取点换车审批列表
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);
}
