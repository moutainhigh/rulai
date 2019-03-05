package com.unicdata.dao.product;

import com.unicdata.entity.product.FinanceLoanYear;
import com.unicdata.entity.product.FinanceLoanYearExample;
import java.util.List;

public interface FinanceLoanYearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinanceLoanYear record);

    int insertSelective(FinanceLoanYear record);

    List<FinanceLoanYear> selectByExample(FinanceLoanYearExample example);

    FinanceLoanYear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinanceLoanYear record);

    int updateByPrimaryKey(FinanceLoanYear record);

    /**
     * 根据门店ID删除贷款年限
     * @param storeId
     */
    void deleteByStoreId(Integer storeId);
}