package com.unicdata.service.letprice;

import com.unicdata.entity.letprice.MonthPlan;
import com.unicdata.entity.letprice.MonthPlanExample;
import com.unicdata.entity.letprice.MonthPlanExt;

import java.text.ParseException;
import java.util.List;

/**
 * Created by shenyong on 2018/6/12.
 */
public interface MonthPlanService {

    int deleteByPrimaryKey(Integer id);

    int insert(MonthPlan record);

    int insertSelective(MonthPlan record);

    List<MonthPlan> selectByExample(MonthPlanExample example);

    MonthPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonthPlan record);

    int updateByPrimaryKey(MonthPlan record);

    Integer save(MonthPlan mp);

    List<MonthPlan> selectByExampleAndSaveYear(MonthPlan mp);

    /**
     * 存档
     * @param id
     */
    void archiving(Integer id ,Integer employeeId) throws ParseException;

    /**
     * 计算月份 达成、差异数据
     * @param id
     * @return
     */
    MonthPlan calcMonthDate(Integer id);

    /**
     * 保存预算
     * @param mp
     * @return
     */
    Integer saveBudget(MonthPlan mp);

    Integer replaceIntoSnapshot(MonthPlanExt ex);

    MonthPlanExt selectMonthPlanSnapshot(Integer monthPlanId);

}
