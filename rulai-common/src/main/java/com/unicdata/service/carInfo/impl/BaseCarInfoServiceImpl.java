package com.unicdata.service.carInfo.impl;

import com.unicdata.dao.carInfo.UnicdataBrandMapper;
import com.unicdata.dao.carInfo.UnicdataFamilyMapper;
import com.unicdata.entity.carInfo.UnicdataBrand;
import com.unicdata.entity.carInfo.UnicdataBrandExample;
import com.unicdata.entity.carInfo.UnicdataFamily;
import com.unicdata.entity.carInfo.UnicdataFamilyExample;
import com.unicdata.service.carInfo.BaseCarInfoService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BaseCarInfoServiceImpl implements BaseCarInfoService {

    @Autowired
    private UnicdataBrandMapper unicdataBrandMapper;

    @Autowired
    private UnicdataFamilyMapper unicdataFamilyMapper;

    @Override
    public List<UnicdataBrand> allBrand() {
        UnicdataBrandExample example = new UnicdataBrandExample();
        UnicdataBrandExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo((byte) 1);
        example.setOrderByClause("rank ASC");
        List<UnicdataBrand> brands = unicdataBrandMapper.selectByExample(example);
        return brands;
    }

    @Override
    public List<UnicdataFamily> familiesByBrandId(Integer brandId) {
        UnicdataFamilyExample example = new UnicdataFamilyExample();
        UnicdataFamilyExample.Criteria criteria = example.createCriteria();
        criteria.andBrandIdEqualTo(brandId);
        criteria.andStatusEqualTo((byte) 1);
        example.setOrderByClause("rank ASC");
        List<UnicdataFamily> families = unicdataFamilyMapper.selectByExample(example);
        return families;
    }

    @Override
    public UnicdataFamily getFamilyByFamilyId(Integer familyId) {
        UnicdataFamilyExample example = new UnicdataFamilyExample();
        UnicdataFamilyExample.Criteria criteria = example.createCriteria();
        criteria.andFamilyIdEqualTo(familyId);
        List<UnicdataFamily> families = unicdataFamilyMapper.selectByExample(example);
        return (families == null || families.isEmpty()) ? null : families.get(0);
    }

    @Override
    public List<String> getFamilyNamesByFamilyIds(List<Integer> familyIds) {
        if (familyIds == null || familyIds.isEmpty()) {
            return Lists.newArrayList();
        }
        List<String> result = Lists.newArrayList();
        for (Integer familyId : familyIds) {
            UnicdataFamily family = this.getFamilyByFamilyId(familyId);
            if (family != null) {
                result.add(family.getFamilyName());
            }
        }
        return result;
    }
}
