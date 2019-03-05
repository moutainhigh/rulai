package com.unicdata.service.letprice;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.letprice.MonthPlanCarDto;
import com.unicdata.entity.letprice.MonthPlanDetail;
import com.unicdata.entity.letprice.MonthPlanDetailExample;
import com.unicdata.entity.letprice.MonthPlanSaveDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by shenyong on 2018/6/12.
 */
public interface MonthPlanDetailService {

    int deleteByPrimaryKey(Integer id);

    int insert(MonthPlanDetail record);

    int insertSelective(MonthPlanDetail record);

    List<MonthPlanDetail> selectByExample(MonthPlanDetailExample example);

    MonthPlanDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonthPlanDetail record);

    int updateByPrimaryKey(MonthPlanDetail record);

    /**
     * 查询月度计划关联库存信息列表
     * @param monthPlanId
     * @return
     */
    Map selectByMonthPlanId(Integer monthPlanId);

    /**
     * 查询月度计划无订单的库存
     * @param monthPlanId
     * @return
     */
    List<MonthPlanCarDto> selectCarGoodInfoByMonthPlanId(Integer monthPlanId);

    /**
     * 查询月度计划已经选中的数据
     * @param monthPlanId
     * @return
     */
    List<MonthPlanCarDto> selectMonthPlanDetailByMonthPlanId( Integer monthPlanId);


    /**
     * 查询月度计划已经全款的车辆信息 (计划内达成 ，计划外达成等 整车毛利信息)
     * @param id
     * @return
     */
    List<MonthPlanDetail> selectCompleteSalesInfo(Integer id , String planMonth,Integer storeId);

    /**
     * 保存
     * @param mp
     * @param employeeId
     */
    ApiReturnInfo save(List<MonthPlanSaveDTO> mp, Integer employeeId);

    /**
     * 计算月度计划调整之后的目标
     * @param monthPlanId
     */
    void calcMonthPlanData(Integer monthPlanId);

    /**
     * 月度计划关联库存详情
     * @param monthPlanId
     * @return
     */
    Map selectMonthPlanDetail(Integer monthPlanId);

    /**
     * 审批
     * @param monthPlanId 月度计划id
     * @param status 1 审核通过，2驳回
     * @param remark 备注
     */
    void approve(Integer monthPlanId, Integer status, String remark);

    /**
     * 查询车型在月度计划详情中的数据
     * @param carId
     * @return 返回所有查到的月度计划详情id
     */
    List<Map> selectVehicleMonthPlanDetail(Integer carId);

}
