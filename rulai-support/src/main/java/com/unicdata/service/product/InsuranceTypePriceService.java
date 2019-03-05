package com.unicdata.service.product;

import com.unicdata.entity.product.InsuranceTypePrice;

import java.util.List;
import java.util.Map;

public interface InsuranceTypePriceService {

    /**
     * 保存险种费率
     * @param prices
     */
    void savePrices(List<InsuranceTypePrice> prices ,Integer storeId);

    /**
     * 根据店鋪ID和险种ID获取下面的费率
     * @param insuranceId
     * @return
     */
    Map<String,List> pricesByInsuranceId(Integer insuranceId , Integer storeId);
}
