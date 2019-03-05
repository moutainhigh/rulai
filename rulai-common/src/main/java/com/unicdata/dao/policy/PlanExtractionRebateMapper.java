package com.unicdata.dao.policy;

import com.unicdata.entity.policy.PlanExtractionRebate;
import com.unicdata.entity.policy.PlanExtractionRebateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanExtractionRebateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanExtractionRebate record);

    int insertSelective(PlanExtractionRebate record);

    List<PlanExtractionRebate> selectByExample(PlanExtractionRebateExample example);

    PlanExtractionRebate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanExtractionRebate record);

    int updateByPrimaryKey(PlanExtractionRebate record);

    List<PlanExtractionRebate> selectRebateMonthPlan(@Param(value = "startDate") String startDate, @Param(value = "endDate")String endDate, @Param(value = "storeId")Integer storeId);
}