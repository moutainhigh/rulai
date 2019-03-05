package com.unicdata.service.policy;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.policy.RebateCar;
import com.unicdata.entity.policy.RebateCarExample;
import com.unicdata.entity.policy.RebateProject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 返利项目车辆关联service
 * Created by shenyong on 2018/6/3.
 */
public interface RebateCarService {

    int deleteByPrimaryKey(Integer id);

    int insert(RebateCar record);

    int insertSelective(RebateCar record);

    List<RebateCar> selectByExample(RebateCarExample example);

    RebateCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RebateCar record);

    int updateByPrimaryKey(RebateCar record);

    /**
     * 新增返利车俩关系表数据
     * @param rp 返利项目
     * @param car 车辆信息
     * @return
     */
    RebateCar insertRebateCar(RebateProject rp , CarGoodInfo car);

    /**
     * 修改返利项目对应的车辆数据
     * @param rc
     * @return
     */
    BigDecimal updateRebateCar(RebateCar rc);

    /**
     * 删除该返利项目下的指定车辆数据
     * @param id
     * @param rebateId
     * @return
     */
    int deleteByKeyAndRebate(Integer id ,Integer rebateId);

    /**
     * 按政策统计核对总额和到账总额
     * @param policyId
     * @return
     */
    RebateCar selectSumProofreaderArriveBillByPolicyId(Integer policyId);

    RebateCar selectSumProofreaderArriveBillByRebateId(Integer rebateId);

    List<RebateCar> selectRebateCarByRebateId(Integer rebateId);

    /**
     * 统计carIds车辆的 计提总金额、核对总金额、到账总金额
     * @return
     */
    RebateCar selectSumPlanAndArriveBillProofreader(Integer storeId , Date startDate, Date endDate);

    RebateCar selectSumplanExtractionAdjust(String carIds);

    Map selectCarRebate(Integer carId);

    Map selectYearSumPlanAndAdjustByRebateId(String yearStartDate,String yearEndDate ,Integer rebateId);

    /**
     * 查询单个车辆所有返利项目的各种金额求和
     * @param carId
     * @return
     */
    RebateCar selectSumRebateCarDataByCarId(Integer carId);

    PageInfo<CarGoodInfoWithBLOBs> selectRebateProjectByCar(Integer carId, Integer pageNum, Integer pageSize);
}
