package com.unicdata.service.product;

import com.unicdata.entity.product.FinanceLoanRange;

import java.util.List;
import java.util.Map;

public interface FinanceLoanRangeService {

    /**
     * 根据金融公司ID获取贷款范围列表
     * @param financeId
     * @return
     */
    List<FinanceLoanRange> getListByFinanceId(Integer financeId);

    /**
     * 保存贷款范围（不同年限贷款利率）
     * @param ranges
     */
    void saveRanges(List<FinanceLoanRange> ranges);
}
