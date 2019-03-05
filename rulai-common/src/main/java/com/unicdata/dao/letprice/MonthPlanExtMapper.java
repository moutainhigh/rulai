package com.unicdata.dao.letprice;

import com.unicdata.entity.letprice.MonthPlanExt;
import com.unicdata.entity.letprice.MonthPlanExtExample;
import java.util.List;

public interface MonthPlanExtMapper {
    int deleteByPrimaryKey(Integer monthPlanId);

    int insert(MonthPlanExt record);

    int insertSelective(MonthPlanExt record);

    List<MonthPlanExt> selectByExampleWithBLOBs(MonthPlanExtExample example);

    List<MonthPlanExt> selectByExample(MonthPlanExtExample example);

    MonthPlanExt selectByPrimaryKey(Integer monthPlanId);

    int updateByPrimaryKeySelective(MonthPlanExt record);

    int updateByPrimaryKeyWithBLOBs(MonthPlanExt record);

    int replaceInto(MonthPlanExt ex);
}