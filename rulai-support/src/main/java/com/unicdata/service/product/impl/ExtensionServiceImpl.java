package com.unicdata.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.product.ExtensionInsuranceCompanyMapper;
import com.unicdata.entity.product.ExtensionInsuranceCompany;
import com.unicdata.entity.product.ExtensionInsuranceCompanyExample;
import com.unicdata.service.product.ExtensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Transactional(readOnly = true)
@Service
public class ExtensionServiceImpl implements ExtensionService {

    @Autowired
    private ExtensionInsuranceCompanyMapper extensionMapper;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return extensionMapper.selectListByParams(params).toPageInfo();
    }

    @Transactional(readOnly = false)
    @Override
    public void save(ExtensionInsuranceCompany extension) {
        if (extension.getId() == null) {
            if(this.selectByNameAndStoreId(extension.getStoreId(),extension.getName()) != null){
                throw new RuntimeException("该延保公司已存在，请勿重复添加");
            }
            extension.setCreateTime(new Date());
            extension.setModifyTime(new Date());
            extensionMapper.insertSelective(extension);
        }else{
            extension.setModifyTime(new Date());
            extensionMapper.updateByPrimaryKeySelective(extension);
        }
    }

    @Override
    public ExtensionInsuranceCompany getExtensionById(Integer extensionId) {
        return extensionMapper.selectByPrimaryKey(extensionId);
    }

    @Override
    public ExtensionInsuranceCompany selectByNameAndStoreId(Integer storeId, String name) {
        ExtensionInsuranceCompanyExample example = new ExtensionInsuranceCompanyExample();
        ExtensionInsuranceCompanyExample.Criteria criteria = example.createCriteria();
        criteria.andStoreIdEqualTo(storeId);
        criteria.andNameEqualTo(name);
        List<ExtensionInsuranceCompany> companies = extensionMapper.selectByExample(example);
        if (companies == null || companies.isEmpty()) {
            return null;
        } else {
            return companies.get(0);
        }
    }

    @Override
    public List<ExtensionInsuranceCompany> getAll(Integer storeId) {
        ExtensionInsuranceCompanyExample example = new ExtensionInsuranceCompanyExample();
        ExtensionInsuranceCompanyExample.Criteria criteria = example.createCriteria();
        criteria.andStoreIdEqualTo(storeId);
        List<ExtensionInsuranceCompany> companies = extensionMapper.selectByExample(example);
        return companies;
    }
}
