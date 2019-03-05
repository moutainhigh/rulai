package com.unicdata.service.product;

import com.unicdata.entity.product.InsuranceExtensionFamily;

import java.util.List;

public interface InsuranceExtensionFamilyService {

    /**
     * 根据延保套餐ID获取关联车系
     * @param insuranceExtensionId
     * @return
     */
    List<InsuranceExtensionFamily> getListByExtensionInsuranceId(Integer insuranceExtensionId);
}
