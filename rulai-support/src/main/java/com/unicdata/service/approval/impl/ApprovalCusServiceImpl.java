package com.unicdata.service.approval.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.approval.ApprovalCusMapper;
import com.unicdata.entity.approval.ApprovalCus;
import com.unicdata.service.approval.ApprovalCusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional(readOnly = false)
@Service
public class ApprovalCusServiceImpl implements ApprovalCusService {

    @Autowired
    private ApprovalCusMapper approvalCusMapper;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return approvalCusMapper.selectListByParams(params).toPageInfo();
    }

    @Override
    public ApprovalCus selectByPrimaryKey(Integer id) {
        return approvalCusMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ApprovalCus record) {
        return approvalCusMapper.updateByPrimaryKeySelective(record);
    }
}
