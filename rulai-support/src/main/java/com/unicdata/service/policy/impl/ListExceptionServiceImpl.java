package com.unicdata.service.policy.impl;

import com.unicdata.dao.policy.ListExceptionMapper;
import com.unicdata.entity.policy.ListException;
import com.unicdata.entity.policy.ListExceptionExample;
import com.unicdata.service.policy.ListExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by myMsi on 2018/5/28.
 */
@Service
public class ListExceptionServiceImpl implements ListExceptionService {

    @Autowired
    private ListExceptionMapper listExceptionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return listExceptionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ListException record) {
        return listExceptionMapper.insert(record);
    }

    @Override
    public int insertSelective(ListException record) {
        return listExceptionMapper.insertSelective(record);
    }

    @Override
    public List<ListException> selectByExample(ListExceptionExample example) {
        return listExceptionMapper.selectByExample(example);
    }

    @Override
    public ListException selectByPrimaryKey(Integer id) {
        return listExceptionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ListException record) {
        return listExceptionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ListException record) {
        return listExceptionMapper.updateByPrimaryKey(record);
    }
}
