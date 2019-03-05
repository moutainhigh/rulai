package com.unicdata.dao.policy;

import com.unicdata.entity.policy.RebateCar;
import com.unicdata.entity.policy.RebateCarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RebateCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RebateCar record);

    int insertSelective(RebateCar record);

    List<RebateCar> selectByExample(RebateCarExample example);

    RebateCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RebateCar record);

    int updateByPrimaryKey(RebateCar record);

    int deleteByKeyAndRebate(@Param("id") Integer id, @Param("rebateId") Integer rebateId);

    RebateCar selectSumProofreaderArriveBillByPolicyId(Integer policyId);

    RebateCar selectSumProofreaderArriveBillByRebateId(Integer rebateId);

    RebateCar selectSumPlanAndArriveBillProofreader(@Param(value = "carIds") String carIds);

    RebateCar selectSumplanExtractionAdjust(@Param(value = "carIds") String carIds);

    Map selectCarRebate(Integer carId);

    Map selectYearSumPlanAndAdjustByRebateId(@Param("yearStartDate") String yearStartDate, @Param("yearEndDate") String yearEndDate, @Param("rebateId") Integer rebateId);

    RebateCar selectSumRebateCarDataByCarId(@Param("carId") Integer carId);
}