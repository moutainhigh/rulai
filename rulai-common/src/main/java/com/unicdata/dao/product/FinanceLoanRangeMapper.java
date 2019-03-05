package com.unicdata.dao.product;

import com.unicdata.entity.product.FinanceLoanRange;
import com.unicdata.entity.product.FinanceLoanRangeExample;
import java.util.List;

public interface FinanceLoanRangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinanceLoanRange record);

    int insertSelective(FinanceLoanRange record);

    List<FinanceLoanRange> selectByExample(FinanceLoanRangeExample example);

    FinanceLoanRange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinanceLoanRange record);

    int updateByPrimaryKey(FinanceLoanRange record);

    /**
     *
     * 根据金融公司ID删除贷款金额范围
     * @param financeId
     */
    void deleteByFinanceId(Integer financeId);
}