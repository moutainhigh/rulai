package com.unicdata.service.approval.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.approval.ApprovalReplaceMapper;
import com.unicdata.service.approval.ApprovalReplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional(readOnly = true)
@Service
public class ApprovalReplaceServiceImpl implements ApprovalReplaceService {

    @Autowired
    private ApprovalReplaceMapper approvalReplaceMapper;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return approvalReplaceMapper.selectListByParams(params).toPageInfo();
    }
}
