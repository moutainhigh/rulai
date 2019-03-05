package com.unicdata.dao.product;

import com.unicdata.entity.product.FinanceRangYear;
import com.unicdata.entity.product.FinanceRangYearExample;

import java.util.List;

public interface FinanceRangYearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinanceRangYear record);

    int insertSelective(FinanceRangYear record);

    List<FinanceRangYear> selectByExample(FinanceRangYearExample example);

    FinanceRangYear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinanceRangYear record);

    int updateByPrimaryKey(FinanceRangYear record);

    /**
     * 根据贷款金额范围集合删除中间表数据
     * @param rangIds
     */
    void deleteByRangeIds(List<Integer> rangIds);

    /**
     * 根据贷款额度ID获取不同年限下的贷款利率
     * @param RangeId
     * @return
     */
    List<FinanceRangYear> selectById(Integer RangeId);
}