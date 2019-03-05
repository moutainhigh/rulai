package com.unicdata.service.policy.impl;

import com.unicdata.dao.policy.PlanExtractionRebateMapper;
import com.unicdata.entity.policy.PlanExtractionRebate;
import com.unicdata.entity.policy.PlanExtractionRebateExample;
import com.unicdata.service.policy.PlanExtractionRebateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shenyong on 2018/5/28.
 */
@Service
public class PlanExtractionRebateServiceImpl implements PlanExtractionRebateService {

    @Autowired
    private PlanExtractionRebateMapper planExtractionMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return planExtractionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PlanExtractionRebate record) {
        return planExtractionMapper.insert(record);
    }

    @Override
    public int insertSelective(PlanExtractionRebate record) {
        return planExtractionMapper.insertSelective(record);
    }

    @Override
    public List<PlanExtractionRebate> selectByExample(PlanExtractionRebateExample example) {
        return planExtractionMapper.selectByExample(example);
    }

    @Override
    public PlanExtractionRebate selectByPrimaryKey(Integer id) {
        return planExtractionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PlanExtractionRebate record) {
        return planExtractionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PlanExtractionRebate record) {
        return planExtractionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PlanExtractionRebate> selectRebateMonthPlan(String startDate, String endDate,Integer storeId) {
        return planExtractionMapper.selectRebateMonthPlan(startDate,endDate,storeId);
    }


}
