package com.unicdata.service.system.impl;

import com.unicdata.dao.system.ShowroomManagerRoleMapper;
import com.unicdata.entity.system.ShowroomManagerRole;
import com.unicdata.entity.system.ShowroomManagerRoleExample;
import com.unicdata.service.system.ShowroomManagerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/6/4.
 */
@Service
public class ShowroomManagerRoleServiceImpl implements ShowroomManagerRoleService {
    @Autowired
    private ShowroomManagerRoleMapper showroomManagerRoleMapper;

    @Override
    public int insertSelective(ShowroomManagerRole record) {
        return showroomManagerRoleMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(ShowroomManagerRole record) {
        return showroomManagerRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<ShowroomManagerRole> selectByExample(ShowroomManagerRoleExample example) {
        return showroomManagerRoleMapper.selectByExample(example);
    }
}
