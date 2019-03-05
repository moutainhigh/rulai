package com.unicdata.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.product.InsuranceTypeMapper;
import com.unicdata.entity.product.InsuranceType;
import com.unicdata.entity.product.InsuranceTypeExample;
import com.unicdata.entity.product.Insurer;
import com.unicdata.entity.product.InsurerExample;
import com.unicdata.service.product.InsuranceTypeService;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class InsuranceTypeServiceImpl implements InsuranceTypeService {

    @Autowired
    private InsuranceTypeMapper insuranceTypeMapper;

    @Override
    public List<InsuranceType> getInsuranceTypes(Integer level) {
        InsuranceTypeExample example = new InsuranceTypeExample();
        InsuranceTypeExample.Criteria criteria = example.createCriteria();
        criteria.andLevelEqualTo(level);
        return insuranceTypeMapper.selectByExample(example);
    }

    @Override
    public List<Integer> getIds() {
        List<String> params = Lists.newArrayList();
        params.add("车船税");
        params.add("交强险");
        InsuranceTypeExample example = new InsuranceTypeExample();
        InsuranceTypeExample.Criteria criteria = example.createCriteria();
        criteria.andLevelEqualTo(1);
        criteria.andNameIn(params);
        List<InsuranceType> data = insuranceTypeMapper.selectByExample(example);
        if(data == null || data.isEmpty()){
            return Lists.newArrayList();
        }
        List<Integer> result = Lists.newArrayList();
        for(InsuranceType type:data){
            result.add(type.getId());
        }
        return result;
    }
}
