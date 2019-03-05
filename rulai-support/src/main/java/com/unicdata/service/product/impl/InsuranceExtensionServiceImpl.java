package com.unicdata.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.constant.InsuranceEnum;
import com.unicdata.dao.car.CarFamilyMapper;
import com.unicdata.dao.product.InsuranceExtensionFamilyMapper;
import com.unicdata.dao.product.InsuranceExtensionMapper;
import com.unicdata.entity.product.InsuranceExtension;
import com.unicdata.entity.product.InsuranceExtensionExample;
import com.unicdata.entity.product.InsuranceExtensionFamily;
import com.unicdata.entity.product.InsuranceType;
import com.unicdata.service.product.InsuranceExtensionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Transactional(readOnly = true)
@Service
public class InsuranceExtensionServiceImpl implements InsuranceExtensionService {

    @Autowired
    private InsuranceExtensionMapper insuranceExtensionMapper;

    @Autowired
    private CarFamilyMapper carFamilyMapper;

    @Autowired
    private InsuranceExtensionFamilyMapper insuranceExtensionFamilyMapper;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return insuranceExtensionMapper.selectListByParams(params).toPageInfo();
    }

    @Transactional(readOnly = false)
    @Override
    public void save(InsuranceExtension insuranceExtension) {
        Integer id = insuranceExtension.getId();
        if (id == null) {
            if (this.selectByNameAndStoreId(insuranceExtension.getStoreId(), insuranceExtension.getName()) != null) {
                throw new RuntimeException("该延保套餐已存在，请勿重复添加");
            }
            insuranceExtension.setCreateTime(new Date());
            insuranceExtension.setModifyTime(new Date());
            insuranceExtensionMapper.insertSelective(insuranceExtension);
            id = insuranceExtension.getId();
        } else {
            insuranceExtension.setModifyTime(new Date());
            insuranceExtensionMapper.updateByPrimaryKeySelective(insuranceExtension);
            //删除之前的延保车系关联信息
            insuranceExtensionFamilyMapper.deleteByInsuranceExtensionId(id);
            //如果不是自店延保清空延保成本
            if (!Objects.equals(insuranceExtension.getType(), InsuranceEnum.ExtensionType.STORE_EXT.getCode())) {
                insuranceExtensionMapper.updateCostNull(insuranceExtension.getId());
            }
        }
        for (InsuranceExtensionFamily entity : insuranceExtension.getInsuranceExtensionFamilies()) {
            entity.setInsuranceExtensionId(id);
            insuranceExtensionFamilyMapper.insertSelective(entity);
        }
    }

    @Override
    public InsuranceExtension getInsuranceExtensionById(Integer insuranceExtensionId) {
        return insuranceExtensionMapper.selectByPrimaryKey(insuranceExtensionId);
    }

    @Override
    public List<Map<String, Object>> getCarFamilyByStoreId(Integer storeId) {
        return carFamilyMapper.selectListByStoreId(storeId);
    }

    @Override
    public InsuranceExtension selectByNameAndStoreId(Integer storeId, String name) {
        InsuranceExtensionExample example = new InsuranceExtensionExample();
        InsuranceExtensionExample.Criteria criteria = example.createCriteria();
        criteria.andStoreIdEqualTo(storeId);
        criteria.andNameEqualTo(name);
        List<InsuranceExtension> extensions = insuranceExtensionMapper.selectByExample(example);
        if (extensions == null || extensions.isEmpty()) {
            return null;
        } else {
            return extensions.get(0);
        }
    }
}
