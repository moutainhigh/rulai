package com.unicdata.service.product.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.product.FinanceCompanyMapper;
import com.unicdata.entity.product.FinanceCompany;
import com.unicdata.entity.product.FinanceCompanyExample;
import com.unicdata.service.product.FinanceCompanyService;

@Service
@Transactional(readOnly = true)
public class FinanceCompanyServiceImpl implements FinanceCompanyService {

    @Autowired
    private FinanceCompanyMapper financeCompanyMapper;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return financeCompanyMapper.selectListByParams(params).toPageInfo();
    }

    @Transactional(readOnly = false)
    @Override
    public void save(FinanceCompany financeCompany) {
        if (financeCompany.getId() == null) {//新增
            if (this.selectByName(financeCompany.getStoreId(), financeCompany.getName()) != null) {
                throw new RuntimeException("该金融公司已存在，请勿重复添加");
            }
            financeCompany.setCreateTime(new Date());
            financeCompany.setModifyTime(new Date());
            financeCompanyMapper.insertSelective(financeCompany);
        } else {//修改
            financeCompany.setModifyTime(new Date());
            financeCompanyMapper.updateByPrimaryKeySelective(financeCompany);
        }
    }

    @Override
    public List<FinanceCompany> getListByStoreId(Integer storeId) {
        if (storeId == null) {
            return Lists.newArrayList();
        }
        FinanceCompanyExample example = new FinanceCompanyExample();
        FinanceCompanyExample.Criteria criteria = example.createCriteria();
        criteria.andStoreIdEqualTo(storeId);
        return financeCompanyMapper.selectByExample(example);
    }

    @Override
    public FinanceCompany selectByName(Integer storeId, String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("storeId", storeId);
        params.put("name", name);
        return financeCompanyMapper.selectByName(params);
    }
}
