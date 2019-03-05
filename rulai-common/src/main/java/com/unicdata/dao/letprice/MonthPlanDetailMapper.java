package com.unicdata.dao.letprice;

import com.unicdata.entity.letprice.MonthPlanCarDto;
import com.unicdata.entity.letprice.MonthPlanDetail;
import com.unicdata.entity.letprice.MonthPlanDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MonthPlanDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonthPlanDetail record);

    int insertSelective(MonthPlanDetail record);

    List<MonthPlanDetail> selectByExample(MonthPlanDetailExample example);

    MonthPlanDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonthPlanDetail record);

    int updateByPrimaryKey(MonthPlanDetail record);

    List<MonthPlanCarDto> selectCarGoodInfoByMonthPlanId(@Param("monthPlanId") Integer monthPlanId);

    List<MonthPlanCarDto> selectMonthPlanDetailByMonthPlanId(@Param("monthPlanId") Integer monthPlanId);

    List<MonthPlanCarDto> selectCarStockInfo(@Param("monthPlanId") Integer monthPlanId , @Param("planMonth") String planMonth, @Param("storeId") Integer storeId);

    /**
     * 查询月度计划中已经全款的车辆信息
     * @param id
     * @return
     */
    List<MonthPlanDetail> selectMonthPlanAndCarInfo(@Param("id") Integer id , @Param("planMonth") String planMonth , @Param("storeId") Integer storeId);

    List<MonthPlanDetail> selectMonthPlanAims(Integer id);


    List<Map> selectVehicleMonthPlanDetail(@Param("carId") Integer carId);
}