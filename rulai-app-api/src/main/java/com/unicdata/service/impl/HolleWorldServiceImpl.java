package com.unicdata.service.impl;

import com.unicdata.dao.holleworld.HolleWorldMapper;
import com.unicdata.entity.holleworld.HolleWorld;
import com.unicdata.entity.holleworld.HolleWorldExample;
import com.unicdata.service.HolleWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by myMsi on 2018/5/28.
 */
@Service
public class HolleWorldServiceImpl implements HolleWorldService {

    @Autowired
    private HolleWorldMapper holleWorldMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return holleWorldMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HolleWorld record) {
        return holleWorldMapper.insert(record);
    }

    @Override
    public int insertSelective(HolleWorld record) {
        return holleWorldMapper.insertSelective(record);
    }

    @Override
    public List<HolleWorld> selectByExample(HolleWorldExample example) {
        return holleWorldMapper.selectByExample(example);
    }

    @Override
    public HolleWorld selectByPrimaryKey(Integer id) {
        return holleWorldMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HolleWorld record) {
        return holleWorldMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HolleWorld record) {
        return holleWorldMapper.updateByPrimaryKey(record);
    }
}
