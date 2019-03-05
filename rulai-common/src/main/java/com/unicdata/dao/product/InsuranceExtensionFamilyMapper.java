package com.unicdata.dao.product;

import com.unicdata.entity.product.InsuranceExtensionFamily;
import com.unicdata.entity.product.InsuranceExtensionFamilyExample;
import java.util.List;

public interface InsuranceExtensionFamilyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceExtensionFamily record);

    int insertSelective(InsuranceExtensionFamily record);

    List<InsuranceExtensionFamily> selectByExample(InsuranceExtensionFamilyExample example);

    InsuranceExtensionFamily selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsuranceExtensionFamily record);

    int updateByPrimaryKey(InsuranceExtensionFamily record);

    /**
     * 根据延保套餐ID删除 延保套餐-车系关联信息
     * @param insuranceExtensionId
     */
    void deleteByInsuranceExtensionId(Integer insuranceExtensionId);
}