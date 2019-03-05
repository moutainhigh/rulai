package com.unicdata.service.product.impl;

import com.unicdata.dao.product.FinanceCompanyMapper;
import com.unicdata.dao.product.FinanceLoanRangeMapper;
import com.unicdata.dao.product.FinanceRangYearMapper;
import com.unicdata.entity.product.*;
import com.unicdata.service.product.FinanceLoanRangeService;
import com.unicdata.service.product.FinanceLoanYearService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FinanceLoanRangeServiceImpl implements FinanceLoanRangeService {

    @Autowired
    private FinanceCompanyMapper financeCompanyMapper;

    @Autowired
    private FinanceLoanRangeMapper financeLoanRangeMapper;

    @Autowired
    private FinanceRangYearMapper financeRangYearMapper;

    @Autowired
    private FinanceLoanYearService financeLoanYearService;

    @Override
    public List<FinanceLoanRange> getListByFinanceId(Integer financeId) {
        FinanceLoanRangeExample loanRangeExample = new FinanceLoanRangeExample();
        FinanceLoanRangeExample.Criteria criteria = loanRangeExample.createCriteria();
        criteria.andFinanceIdEqualTo(financeId);
        //查找贷款范围
        List<FinanceLoanRange> loanRanges = financeLoanRangeMapper.selectByExample(loanRangeExample);
        if (loanRanges == null || loanRanges.isEmpty()) {
            return Lists.newArrayList();
        }
        for (FinanceLoanRange loanRange : loanRanges) {
            List<FinanceRangYear> rangYears = financeRangYearMapper.selectById(loanRange.getId());
            loanRange.setRangYears(rangYears);
        }
        return loanRanges;
    }

    @Transactional(readOnly = false)
    @Override
    public void saveRanges(List<FinanceLoanRange> ranges) {
        //金融公司ID
        Integer financeId = ranges.get(0).getFinanceId();
        //需要删除的所有贷款范围的ID
        List<Integer> needDeleteRangeIds = Lists.newArrayList();
        if (financeId != null) {
            FinanceLoanRangeExample rangeExample = new FinanceLoanRangeExample();
            FinanceLoanRangeExample.Criteria criteria = rangeExample.createCriteria();
            criteria.andFinanceIdEqualTo(financeId);
            List<FinanceLoanRange> needDeleteRanges = financeLoanRangeMapper.selectByExample(rangeExample);
            if (needDeleteRanges != null) {
                for (FinanceLoanRange range : needDeleteRanges) {
                    needDeleteRangeIds.add(range.getId());
                }
            }
            //删除改金融公司的贷款金额范围
            financeLoanRangeMapper.deleteByFinanceId(financeId);
        }
        if (!needDeleteRangeIds.isEmpty()) {
            //删除该金融公司不同的贷款金额范围对应的利率
            financeRangYearMapper.deleteByRangeIds(needDeleteRangeIds);
        }
        for (FinanceLoanRange loanRange : ranges) {
            List<FinanceRangYear> rangYearList = loanRange.getRangYears();
            financeLoanRangeMapper.insertSelective(loanRange);
            Integer rangeId = loanRange.getId();
            for (FinanceRangYear rangeYear : rangYearList) {
                rangeYear.setRangeId(rangeId);
                financeRangYearMapper.insertSelective(rangeYear);
            }
        }
    }
}
