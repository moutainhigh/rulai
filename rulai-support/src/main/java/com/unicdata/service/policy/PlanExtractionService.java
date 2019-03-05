package com.unicdata.service.policy;

import com.unicdata.entity.policy.PlanExtraction;
import com.unicdata.entity.policy.PlanExtractionExample;

import java.text.ParseException;
import java.util.List;

/**
 * 计提表service
 * Created by shenyong on 2018/6/3.
 */
public interface PlanExtractionService {

    int deleteByPrimaryKey(Integer id);

    int insert(PlanExtraction record);

    int insertSelective(PlanExtraction record);

    List<PlanExtraction> selectByExample(PlanExtractionExample example);

    PlanExtraction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanExtraction record);

    int updateByPrimaryKey(PlanExtraction record);

    void selectPlan(Integer month) throws ParseException;

    /**
     * 计提审核
     * @param id
     * @param employeeId
     * @return
     */
    Integer planCheck(Integer id,Integer employeeId);
}
