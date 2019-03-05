package com.unicdata.dao.product;

import com.github.pagehelper.Page;
import com.unicdata.entity.product.ExtensionInsuranceCompany;
import com.unicdata.entity.product.ExtensionInsuranceCompanyExample;
import java.util.List;
import java.util.Map;

public interface ExtensionInsuranceCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExtensionInsuranceCompany record);

    int insertSelective(ExtensionInsuranceCompany record);

    List<ExtensionInsuranceCompany> selectByExample(ExtensionInsuranceCompanyExample example);

    ExtensionInsuranceCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExtensionInsuranceCompany record);

    int updateByPrimaryKey(ExtensionInsuranceCompany record);

    /**
     * 根据参数获取分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);
}