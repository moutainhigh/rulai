package com.unicdata.service.policy;

import com.unicdata.entity.policy.PlanExtractionRebate;
import com.unicdata.entity.policy.PlanExtractionRebateExample;

import java.util.List;

/**
 * 计提表service
 * Created by shenyong on 2018/6/3.
 */
public interface PlanExtractionRebateService {

    int deleteByPrimaryKey(Integer id);

    int insert(PlanExtractionRebate record);

    int insertSelective(PlanExtractionRebate record);

    List<PlanExtractionRebate> selectByExample(PlanExtractionRebateExample example);

    PlanExtractionRebate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanExtractionRebate record);

    int updateByPrimaryKey(PlanExtractionRebate record);

    List<PlanExtractionRebate> selectRebateMonthPlan(String startDate ,String endDate,Integer storeId);
}
