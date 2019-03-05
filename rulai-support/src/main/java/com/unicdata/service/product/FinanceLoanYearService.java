package com.unicdata.service.product;

import com.unicdata.entity.product.FinanceLoanYear;

import java.util.List;

public interface FinanceLoanYearService {

    /**
     * 根据店铺ID获取贷款年限列表
     * @param storeId
     * @return
     */
    List<FinanceLoanYear> getListByStoreId(Integer storeId);

    /**
     * 保存贷款年限
     * @param years
     */
    void saveYears(List<FinanceLoanYear> years,Integer storeId);
}
