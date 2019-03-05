package com.unicdata.service.product.impl;

import com.google.common.collect.Maps;
import com.unicdata.dao.product.FinanceCompanyMapper;
import com.unicdata.dao.product.FinanceLoanRangeMapper;
import com.unicdata.dao.product.FinanceLoanYearMapper;
import com.unicdata.dao.product.FinanceRangYearMapper;
import com.unicdata.entity.product.*;
import com.unicdata.service.product.FinanceLoanYearService;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Transactional(readOnly = true)
@Service
public class FinanceLoanYearServiceImpl implements FinanceLoanYearService {

    @Autowired
    private FinanceLoanYearMapper financeLoanYearMapper;

    @Autowired
    private FinanceRangYearMapper financeRangYearMapper;

    @Autowired
    private FinanceLoanRangeMapper financeLoanRangeMapper;

    @Autowired
    private FinanceCompanyMapper financeCompanyMapper;

    @Override
    public List<FinanceLoanYear> getListByStoreId(Integer storeId) {
        FinanceLoanYearExample example = new FinanceLoanYearExample();
        FinanceLoanYearExample.Criteria criteria = example.createCriteria();
        criteria.andStoreIdEqualTo(storeId);
        example.setOrderByClause("year ASC");
        List<FinanceLoanYear> result = financeLoanYearMapper.selectByExample(example);
        return result == null ? Lists.newArrayList() : result;
    }

    @Transactional(readOnly = false)
    @Override
    public void saveYears(List<FinanceLoanYear> years, Integer storeId) {
        //需要删除的年限
        List<Integer> needDeleteIds = Lists.newArrayList();
        //需要新增的年限
        List<FinanceLoanYear> needAddYears = Lists.newArrayList();
        Map<Integer, FinanceLoanYear> oldMap = Maps.newHashMap();
        Map<Integer, FinanceLoanYear> newMap = Maps.newHashMap();
        //获取之前的年限
        List<FinanceLoanYear> oldYears = this.getListByStoreId(storeId);
        for (FinanceLoanYear year : oldYears) {
            oldMap.put(year.getYear(), year);
        }
        Set<Integer> yearsOld = oldMap.keySet();
        for (FinanceLoanYear year : years) {
            newMap.put(year.getYear(), year);
        }
        Set<Integer> yearsNew = newMap.keySet();
        for (Integer year : yearsOld) {
            //如果现在不含有之前的(需要删除之前的)
            if (!yearsNew.contains(year)) {
                needDeleteIds.add(oldMap.get(year).getId());
            }
        }
        for (Integer year : yearsNew) {
            //如果之前的不含有现在的(需要新增)
            if (!yearsOld.contains(year)) {
                needAddYears.add(newMap.get(year));
            }
        }
        if (needDeleteIds != null && !needDeleteIds.isEmpty()) {
            //删除需要删除的年限
            for (Integer id : needDeleteIds) {
                financeLoanYearMapper.deleteByPrimaryKey(id);
            }
            //删除 贷款范围-年限中间表 中和此年限ID相关的数据
            FinanceRangYearExample example = new FinanceRangYearExample();
            FinanceRangYearExample.Criteria criteria = example.createCriteria();
            criteria.andYearIdIn(needDeleteIds);
            List<FinanceRangYear> rangYears = financeRangYearMapper.selectByExample(example);
            if (rangYears != null) {
                for (FinanceRangYear rangYear : rangYears) {
                    financeRangYearMapper.deleteByPrimaryKey(rangYear.getId());
                }
            }
        }

        //找到店铺下所有的保险公司
        FinanceCompanyExample companyExample = new FinanceCompanyExample();
        FinanceCompanyExample.Criteria companyCriteria = companyExample.createCriteria();
        companyCriteria.andStoreIdEqualTo(storeId);
        List<FinanceCompany> companies = financeCompanyMapper.selectByExample(companyExample);
        List<Integer> rangeIds = Lists.newArrayList();
        if (companies != null && !companies.isEmpty()) {
            List<Integer> companyIds = Lists.newArrayList();
            for (FinanceCompany company : companies) {
                companyIds.add(company.getId());
            }
            //找到所有的贷款额
            FinanceLoanRangeExample rangeExample = new FinanceLoanRangeExample();
            FinanceLoanRangeExample.Criteria criteria = rangeExample.createCriteria();
            criteria.andFinanceIdIn(companyIds);
            List<FinanceLoanRange> ranges = financeLoanRangeMapper.selectByExample(rangeExample);
            if (ranges != null) {
                for (FinanceLoanRange range : ranges) {
                    rangeIds.add(range.getId());
                }
            }
        }
        //添加需要新增的年限
        for (FinanceLoanYear year : needAddYears) {
            year.setStoreId(storeId);
            financeLoanYearMapper.insertSelective(year);
            Integer yearId = year.getId();
            //为该店铺下的所有金融公司的所有贷款额添加设置，利率为null
            for (Integer rangeId : rangeIds) {
                FinanceRangYear rangeYear = new FinanceRangYear();
                rangeYear.setYearId(yearId);
                rangeYear.setRangeId(rangeId);
                financeRangYearMapper.insertSelective(rangeYear);
            }
        }
    }
}
