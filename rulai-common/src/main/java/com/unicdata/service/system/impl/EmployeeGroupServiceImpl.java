package com.unicdata.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.dao.system.EmployeeGroupMapper;
import com.unicdata.entity.system.EmployeeGroup;
import com.unicdata.entity.system.EmployeeGroupExample;
import com.unicdata.entity.system.EmployeePost;
import com.unicdata.entity.system.EmployeePostExample;
import com.unicdata.service.system.EmployeeGroupService;
import com.unicdata.service.system.EmployeePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by myMsi on 2018/6/1.
 */
@Service
public class EmployeeGroupServiceImpl implements EmployeeGroupService {


    @Autowired
    private EmployeeGroupMapper employeeGroupMapper;
    @Autowired
    private EmployeePostService employeePostService;


    public int deleteByPrimaryKey(Integer id){
        return employeeGroupMapper.deleteByPrimaryKey(id);
    }

    public int insert(EmployeeGroup record){
        return employeeGroupMapper.insert(record);
    }

    public int insertSelective(EmployeeGroup record){
        return employeeGroupMapper.insertSelective(record);
    }

    public List<EmployeeGroup> selectByExample(EmployeeGroupExample example){
        return employeeGroupMapper.selectByExample(example);
    }

    public EmployeeGroup selectByPrimaryKey(Integer id){
        return employeeGroupMapper.selectByPrimaryKey(id);
    }

    public  int updateByPrimaryKeySelective(EmployeeGroup record){
        return employeeGroupMapper.updateByPrimaryKeySelective(record);
    }

    public  int updateByPrimaryKey(EmployeeGroup record){
        return employeeGroupMapper.updateByPrimaryKey(record);
    }

    public PageInfo storeList(Integer pageNum, Integer pageSize, EmployeeGroup employee) {

        pageNum = null == pageNum || pageNum < 1 ?  1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? Integer.MAX_VALUE : pageSize;

        PageHelper.startPage(pageNum, pageSize);
        EmployeeGroupExample pe = new EmployeeGroupExample();
        EmployeeGroupExample.Criteria criteria = pe.createCriteria();
        criteria.andGroupTypeEqualTo(employee.getGroupType());
        criteria.andDataStatusEqualTo(1);
        if(employee.getParentId() != null ){
            criteria.andParentIdEqualTo(employee.getParentId());
        }
        pe.setOrderByClause("  parent_id , sortno asc");
        List<EmployeeGroup> permissionses = employeeGroupMapper.selectByExample(pe);
        for (EmployeeGroup i : permissionses) {
            EmployeePostExample ex = new EmployeePostExample();
            EmployeePostExample.Criteria criteriax = ex.createCriteria();
            criteriax.andDataStatusEqualTo(1).andDepartmentIdEqualTo(i.getId());
            ex.setOrderByClause(" department_id ,sortno asc ");
            List<EmployeePost> employeePosts = employeePostService.selectByExample(ex);
            i.setEmployeePosts(employeePosts);
        }
        //封装分页信息
        PageInfo<EmployeeGroup> pageInfo = new PageInfo<EmployeeGroup>(permissionses);
        return pageInfo;
    }

    public ApiReturnInfo save(EmployeeGroup record) {
        ApiReturnInfo ar = new ApiReturnInfo();
        int num = 0;
        if(record.getId() == null || record.getId()<=0){
            record.setUpdateDate(new Date());
            record.setCreateDate(new Date());
            num = this.insertSelective(record);
        }else{
            record.setUpdateDate(new Date());
            num = this.updateByPrimaryKeySelective(record);
        }
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage("操作成功！");
        ar.setData(record.getId());
        if(num == 0){
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage("操作失败！");
        }
        return ar;
    }


}
