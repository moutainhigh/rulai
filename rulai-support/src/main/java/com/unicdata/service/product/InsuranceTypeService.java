package com.unicdata.service.product;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.product.InsuranceType;

import java.util.List;
import java.util.Map;

public interface InsuranceTypeService {


    /**
     * 获取不同级别的险种
     * @return
     */
    List<InsuranceType> getInsuranceTypes(Integer level);

    /**
     * 获取交强险和车船税id集合
     */
    List<Integer> getIds();
}
