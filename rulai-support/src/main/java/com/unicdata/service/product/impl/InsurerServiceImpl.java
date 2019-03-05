package com.unicdata.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.product.InsuranceConnectionMapper;
import com.unicdata.dao.product.InsurerMapper;
import com.unicdata.entity.product.*;
import com.unicdata.service.product.InsurerService;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("insurerService")
@Transactional(readOnly = true)
public class InsurerServiceImpl implements InsurerService {

    @Autowired
    private InsurerMapper insurerMapper;

    @Autowired
    private InsuranceConnectionMapper insuranceConnectionMapper;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return insurerMapper.selectListByParams(params).toPageInfo();
    }

    @Transactional(readOnly = false)
    @Override
    public void save(Insurer insurer) {
        Integer insurerId = insurer.getId();
        List<InsuranceConnection> connections = insurer.getConnections();
        if (insurer.getId() == null) {//新增
            if (this.selectByNameAndStoreId(insurer.getStoreId(), insurer.getName()) != null) {
                throw new RuntimeException("该保险公司已存在，请勿重复添加");
            }
            insurer.setCreateTime(new Date());
            insurer.setModifyTime(new Date());
            insurerMapper.insertSelective(insurer);
            insurerId = insurer.getId();
        } else {//修改
            insurer.setModifyTime(new Date());
            insurerMapper.updateByPrimaryKeySelective(insurer);
            //删除之前保存的险种关联
            insuranceConnectionMapper.deleteByInsurerId(insurer.getId());
        }
        for (InsuranceConnection connection : connections) {
            //插入保险公司ID
            connection.setInsurerId(insurerId);
            //保险公司名称
            connection.setInsurerName(insurer.getName());
            insuranceConnectionMapper.insert(connection);
        }
    }

    @Override
    public Insurer getInsurerById(Integer insurerId) {
        //保险公司详情
        Insurer insurer = insurerMapper.selectByPrimaryKey(insurerId);
        //保险公司险种详情
        InsuranceConnectionExample example = new InsuranceConnectionExample();
        InsuranceConnectionExample.Criteria criteria = example.createCriteria();
        criteria.andInsurerIdEqualTo(insurerId);
        List<InsuranceConnection> list = insuranceConnectionMapper.selectByExample(example);
        insurer.setConnections(list);
        return insurer;
    }

    @Override
    public Insurer selectByNameAndStoreId(Integer storeId, String name) {
        InsurerExample example = new InsurerExample();
        InsurerExample.Criteria criteria = example.createCriteria();
        criteria.andStoreIdEqualTo(storeId);
        criteria.andNameEqualTo(name);
        List<Insurer> insurers = insurerMapper.selectByExample(example);
        if (insurers == null || insurers.isEmpty()) {
            return null;
        } else {
            return insurers.get(0);
        }
    }
}
