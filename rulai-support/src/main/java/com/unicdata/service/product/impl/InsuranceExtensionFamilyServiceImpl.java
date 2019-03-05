package com.unicdata.service.product.impl;

import com.unicdata.dao.product.InsuranceExtensionFamilyMapper;
import com.unicdata.entity.product.InsuranceExtensionFamily;
import com.unicdata.entity.product.InsuranceExtensionFamilyExample;
import com.unicdata.service.product.InsuranceExtensionFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class InsuranceExtensionFamilyServiceImpl implements InsuranceExtensionFamilyService {

    @Autowired
    private InsuranceExtensionFamilyMapper insuranceExtensionFamilyMapper;

    @Override
    public List<InsuranceExtensionFamily> getListByExtensionInsuranceId(Integer insuranceExtensionId) {
        InsuranceExtensionFamilyExample example = new InsuranceExtensionFamilyExample();
        InsuranceExtensionFamilyExample.Criteria criteria = example.createCriteria();
        criteria.andInsuranceExtensionIdEqualTo(insuranceExtensionId);
        return insuranceExtensionFamilyMapper.selectByExample(example);
    }
}
