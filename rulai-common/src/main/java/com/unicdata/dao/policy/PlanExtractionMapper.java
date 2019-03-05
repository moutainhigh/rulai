package com.unicdata.dao.policy;

import com.unicdata.entity.policy.PlanExtraction;
import com.unicdata.entity.policy.PlanExtractionExample;
import java.util.List;

public interface PlanExtractionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanExtraction record);

    int insertSelective(PlanExtraction record);

    List<PlanExtraction> selectByExample(PlanExtractionExample example);

    PlanExtraction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanExtraction record);

    int updateByPrimaryKey(PlanExtraction record);
}