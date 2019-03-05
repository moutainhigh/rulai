package com.unicdata.service.system.impl;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.dao.system.EmployeePostMapper;
import com.unicdata.entity.system.EmployeePost;
import com.unicdata.entity.system.EmployeePostExample;
import com.unicdata.service.system.EmployeePostService;
import com.unicdata.service.system.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by shenyong on 2018/6/1.
 */
@Service
public class EmployeePostServiceImpl implements EmployeePostService {

    @Autowired
    private EmployeePostMapper employeePostMapper;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return employeePostMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(EmployeePost record) {
        return employeePostMapper.insert(record);
    }

    @Override
    public int insertSelective(EmployeePost record) {
        return employeePostMapper.insertSelective(record);
    }

    @Override
    public List<EmployeePost> selectByExample(EmployeePostExample example) {
        return employeePostMapper.selectByExample(example);
    }

    @Override
    public EmployeePost selectByPrimaryKey(Integer id) {
        return employeePostMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(EmployeePost record) {
        return employeePostMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(EmployeePost record) {
        return employeePostMapper.updateByPrimaryKey(record);
    }

    @Override
    public ApiReturnInfo save(EmployeePost ep) {
        ApiReturnInfo ar = new ApiReturnInfo();
        if(null == ep || StringUtil.isBlank(ep.getPostName()) || ep.getDepartmentId() == null || ep.getDepartmentId() <= 0 || ep.getGroupType() == null || ep.getGroupType()  <= 0) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
            return ar;
        }
        ar.setData(ep.getId());
        ep.setDataStatus(1);
        ep.setUpdateDate(new Date());
        if(ep.getId() == null || ep.getId() <= 0){
            ep.setCreateDate(new Date());
            int id = this.insertSelective(ep);
            ar.setData(id);
        }else{
            this.updateByPrimaryKeySelective(ep);
            employeeService.updateByPostId(ep.getId(),ep.getPostName());
        }
        return ar;
    }

}

