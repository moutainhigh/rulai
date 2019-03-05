package com.unicdata.service.operation;

import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Create by zhang
 */
public interface OperationService {
    PageInfo<Map<String, Object>> orderOperation(Map<String, Object> param, Integer pageNum, Integer pageSize);
}
