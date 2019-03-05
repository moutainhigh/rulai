package com.unicdata.dao.letprice;

import com.unicdata.entity.letprice.MonthPlan;
import com.unicdata.entity.letprice.MonthPlanExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface MonthPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonthPlan record);

    int insertSelective(MonthPlan record);

    List<MonthPlan> selectByExample(MonthPlanExample example);

    MonthPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonthPlan record);

    int updateByPrimaryKey(MonthPlan record);

    int updateBudget(@Param("id") Integer id , @Param("budgetVolume") Integer budgetVolume , @Param("budgetGrossProfit") BigDecimal budgetGrossProfit);

    int updateGoal(@Param("id") Integer id , @Param("goalSalesVolume") Integer goalSalesVolume , @Param("goalGrossProfit") BigDecimal goalGrossProfit);
}