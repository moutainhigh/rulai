package com.unicdata.service.letprice.impl;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.CalculateUtils;
import com.unicdata.dao.letprice.MonthPlanDetailMapper;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.letprice.*;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.CarVehicleConfService;
import com.unicdata.service.letprice.MonthPlanDetailService;
import com.unicdata.service.letprice.MonthPlanService;
import com.unicdata.util.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by shenyong on 2018/6/12.
 */
@Service
public class MonthPlanDetailServiceImpl implements MonthPlanDetailService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

    @Autowired
    private MonthPlanDetailMapper monthPlanDetailMapper;
    @Autowired
    private MonthPlanService monthPlanService;
    @Autowired
    private CarGoodInfoService carGoodInfoService;
    @Autowired
    private CarVehicleConfService vehicleService;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return monthPlanDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MonthPlanDetail record) {
        return monthPlanDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(MonthPlanDetail record) {
        return monthPlanDetailMapper.insertSelective(record);
    }

    @Override
    public List<MonthPlanDetail> selectByExample(MonthPlanDetailExample example) {
        return monthPlanDetailMapper.selectByExample(example);
    }

    @Override
    public MonthPlanDetail selectByPrimaryKey(Integer id) {
        return monthPlanDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MonthPlanDetail record) {
        return monthPlanDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MonthPlanDetail record) {
        return monthPlanDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public Map selectByMonthPlanId(Integer monthPlanId) {
        MonthPlan monthPlan = monthPlanService.selectByPrimaryKey(monthPlanId);
        Map<String ,List<MonthPlanCarDto>> resultmap = new HashMap<>();
        //整车毛利map
        Map<Integer ,BigDecimal> carGrossProfitMap = new HashMap<>();
        //当月已全款车辆 是否在计划内 1 在 ，2不在
        Map<Integer ,Integer> insideThePlanMap = new HashMap<>();
        //计算整车毛利map ，当月已全款车辆map ，是否在计划内外等等
        selectInsideThePlan(monthPlanId, monthPlan, carGrossProfitMap, insideThePlanMap);
        //查询月度计划的数据（全款时间在当月和没有全款时间的数据）
        List<MonthPlanCarDto>  monthLists = monthPlanDetailMapper.selectCarStockInfo(monthPlanId,monthPlan.getPlanMonth(),monthPlan.getStoreId());
        for(MonthPlanCarDto c : monthLists){
            if(c.getIsSelect() == 2) {//月度计划已经选中的数据
                if (c.getStatus() != 3) {
                    c.setLevelOne(c.getVehicleLevelOne());
                    c.setLevelTwo(c.getVehicleLevelTwo());
                    c.setLevelThree(c.getVehicleLevelThree());
                }
                c.setGrossProfitOne(c.getLevelOne().subtract(c.getPurchasePrice()).add(c.getForecastProfit()));
                c.setGrossProfitTwo(c.getLevelTwo().subtract(c.getPurchasePrice()).add(c.getForecastProfit()));
                c.setGrossProfitThree(c.getLevelThree().subtract(c.getPurchasePrice()).add(c.getForecastProfit()));
            }else if(c.getIsSelect() == 1){//月度计划没有选中的数据
                c.setGrossProfitOne(c.getVehicleLevelOne().subtract(c.getPurchasePrice()).add(c.getForecastProfit()));
                c.setGrossProfitTwo(c.getVehicleLevelTwo().subtract(c.getPurchasePrice()).add(c.getForecastProfit()));
                c.setGrossProfitThree(c.getVehicleLevelThree().subtract(c.getPurchasePrice()).add(c.getForecastProfit()));
                c.setLevelOne(c.getVehicleLevelOne());
                c.setLevelTwo(c.getVehicleLevelTwo());
                c.setLevelThree(c.getVehicleLevelThree());
            }
            c.setCarGrossProfit(carGrossProfitMap.get(c.getCarId()));
            setResultMap(resultmap, c);
        }

        List<Map> resultList = new ArrayList<>();
        resultmap.forEach((k,v)->{
            Integer insideThePlanVolume = 0;//计划内销量
            BigDecimal insideThePlanLumsum = BigDecimal.ZERO ;//计划内总额
            Integer notInThePlanVolume = 0;//计划外销量
            BigDecimal notInThePlanLumsum = BigDecimal.ZERO ;//计划外总额
            Integer planCount = 0; // 车系计划销量
            BigDecimal planLumsum = BigDecimal.ZERO; //计划总额
            Integer reachSum = 0 ; //达成合计
            BigDecimal reachSumlumsum = BigDecimal.ZERO; //达成合计总额
            for(int i = 0 ; i < v.size() ; i++) {
                MonthPlanCarDto m = v.get(i);
                Integer insideThePlan = insideThePlanMap.get(m.getCarId());
                if(insideThePlan != null){
                    if(insideThePlan == 1){
                        insideThePlanVolume++;
                        insideThePlanLumsum = insideThePlanLumsum.add(carGrossProfitMap.getOrDefault(m.getCarId(),BigDecimal.ZERO));
                    } else {
                        notInThePlanVolume++;
                        notInThePlanLumsum = notInThePlanLumsum.add(carGrossProfitMap.getOrDefault(m.getCarId(),BigDecimal.ZERO));
                    }
                    reachSum++;
                    reachSumlumsum = reachSumlumsum.add(carGrossProfitMap.getOrDefault(m.getCarId(),BigDecimal.ZERO));
                }
                if(m.getIsSelect() == 2){
                    planCount++;
                    planLumsum = planLumsum.add(carGrossProfitMap.getOrDefault(m.getCarId(),BigDecimal.ZERO));
                }
            }

            Map map = new HashMap();
            map.put("insideThePlanVolume",insideThePlanVolume);
            map.put("insideThePlanLumsum",insideThePlanLumsum);
            map.put("notInThePlanVolume",notInThePlanVolume);
            map.put("notInThePlanLumsum",notInThePlanLumsum);
            map.put("planCount",planCount);
            map.put("planLumsum",planLumsum);
            map.put("reachSum",reachSum);
            map.put("reachSumlumsum",reachSumlumsum);
            map.put("familyName",k);
            map.put("data",v);
            resultList.add(map);
        });
        Map map = new HashMap();
        map.put("monthPlan",monthPlan);
        map.put("familyData",resultList);
//        resultList.add(map);
        return map;
    }

    /**
     * 计算是否计划内以及计划内外的总额
     * @param monthPlanId 月度计划id
     * @param monthPlan 月度计划月份
     * @param carGrossProfitMap 车辆对应的车辆毛利总额
     * @param insideThePlanMap 车辆对应的计划内外状态 1在 2不在
     */
    private void selectInsideThePlan(Integer monthPlanId, MonthPlan monthPlan, Map<Integer, BigDecimal> carGrossProfitMap, Map<Integer, Integer> insideThePlanMap) {
        Integer insideThePlanVolume = 0;//计划内销量
        BigDecimal insideThePlanLumpum = BigDecimal.ZERO ;//计划内总额
        Integer notInThePlanVolume = 0;//计划外销量
        BigDecimal notInThePlanLumpum = BigDecimal.ZERO ;//计划外总额
        List<MonthPlanDetail> monthPlanDetails = this.selectCompleteSalesInfo(monthPlanId,monthPlan.getPlanMonth(),monthPlan.getStoreId());
        for(MonthPlanDetail m :monthPlanDetails){
            BigDecimal purchasePrice = m.getPurchasePrice()== null ? BigDecimal.ZERO :  m.getPurchasePrice();
            BigDecimal forecastProfit = m.getForecastProfit()== null ? BigDecimal.ZERO : m.getForecastProfit();
            BigDecimal salePrice = m.getSalePrice() == null ? BigDecimal.ZERO:m.getSalePrice();
            BigDecimal donationAmount = m.getDonationAmount() == null ? BigDecimal.ZERO : m.getDonationAmount();
            BigDecimal carGrossProfit = CalculateUtils.calcCarGrossProfit(salePrice,purchasePrice,forecastProfit,donationAmount);
            carGrossProfitMap.put(m.getCarId() , carGrossProfit);
            insideThePlanMap.put(m.getCarId(),m.getInsideThePlan());
            if(m.getInsideThePlan() == 1){ //计划内
                insideThePlanVolume++;
                insideThePlanLumpum = insideThePlanLumpum.add(carGrossProfit);
            }else{//计划外
                notInThePlanVolume++;
                notInThePlanLumpum = notInThePlanLumpum.add(carGrossProfit);
            }
        }
        monthPlan.setInsideThePlanVolume(insideThePlanVolume);
        monthPlan.setInsideThePlanLumSum(insideThePlanLumpum);
        monthPlan.setNotInThePlanVolume(notInThePlanVolume);
        monthPlan.setNotInThePlanLumpum(notInThePlanLumpum);
    }

    /**
     * 设置
     * @param resultmap
     * @param c
     */
    private void setResultMap(Map<String, List<MonthPlanCarDto>> resultmap, MonthPlanCarDto c) {
        if(resultmap.containsKey(c.getFamilyName())){
            List<MonthPlanCarDto> list = resultmap.get(c.getFamilyName());
            list.add(c);
        }else{
            List<MonthPlanCarDto> list = new ArrayList<>();
            list.add(c);
            resultmap.put(c.getFamilyName() , list);
        }
    }

    /**
     * 查询月度计划无订单的库存
     * @param monthPlanId
     * @return
     */
    @Override
    public List<MonthPlanCarDto> selectCarGoodInfoByMonthPlanId(Integer monthPlanId) {
        return monthPlanDetailMapper.selectCarGoodInfoByMonthPlanId(monthPlanId);
    }

    /**
     * 查询月度计划已经选中的数据
     * @param monthPlanId
     * @return
     */
    @Override
    public List<MonthPlanCarDto> selectMonthPlanDetailByMonthPlanId(Integer monthPlanId) {
        return monthPlanDetailMapper.selectMonthPlanDetailByMonthPlanId(monthPlanId);
    }

    /**
     * 查询月度计划中已经全款的车辆信息
     * @param id
     * @return
     */
    @Override
    public List<MonthPlanDetail> selectCompleteSalesInfo(Integer id,String planMonth ,Integer storeId) {
        return monthPlanDetailMapper.selectMonthPlanAndCarInfo(id ,planMonth,storeId);
    }

    @Override
    public ApiReturnInfo save(List<MonthPlanSaveDTO> mp, Integer employeeId) {
        ApiReturnInfo ar = new ApiReturnInfo();
        if(mp != null && mp.size() > 0) {
            MonthPlan monthPlan = monthPlanService.selectByPrimaryKey(mp.get(0).getMonthPlanId());
            if(monthPlan != null){
                Integer modify = 1; // 1需要修改月度计划销量和毛利总额 ，2不需要计算
                for (MonthPlanSaveDTO m : mp) {
                    MonthPlanDetailExample ex = new MonthPlanDetailExample();
                    ex.createCriteria().andMonthPlanIdEqualTo(monthPlan.getId()).andCarIdEqualTo(m.getCarId());
                    List<MonthPlanDetail> monthPlanDetails = this.selectByExample(ex);
                    MonthPlanDetail mpd = new MonthPlanDetail();
                    mpd.setMonthPlanId(monthPlan.getId());
                    mpd.setCarId(m.getCarId());
                    mpd.setEmployeeId(employeeId);
                    mpd.setUpdateDate(new Date());
                    if(m.getIsSelect() == 1){ //选中
                        if (m.getIsModify() == 1) {//未修改报备价格 需要获取车型的报备价格
                            CarVehicleConf vehicle = vehicleService.selectByPrimaryKey(m.getVehicleId());
                            mpd.setLevelOne(vehicle.getLevelOne());
                            mpd.setLevelTwo(vehicle.getLevelTwo());
                            mpd.setLevelThree(vehicle.getLevelThree());
                            mpd.setStatus(3);
                            mpd.setEmployeeId(employeeId);
                            mpd.setCreateDate(new Date());
                            if(monthPlanDetails == null || monthPlanDetails.size() <= 0){
                                this.insertSelective(mpd);
                            }
                        }else if (m.getIsModify() == 2){ //  修改过报备价格需要审核
                            modify = 2;
                            mpd.setLevelOneAdjust(m.getLevelOne());
                            mpd.setLevelTwoAdjust(m.getLevelTwo());
                            mpd.setLevelThreeAdjust(m.getLevelThree());
                            mpd.setStatus(2);
                            if(monthPlanDetails == null || monthPlanDetails.size() <= 0){
                                mpd.setCreateDate(new Date());
                                this.insertSelective(mpd);
                            }else {
                                mpd.setId(monthPlanDetails.get(0).getId());
                                this.updateByPrimaryKeySelective(mpd);
                            }
                        }
                    }else if(m.getIsSelect() == 2){ // 取消选中  需要删除 月度计划对应的关联数据 并重新计算目标数据
                        monthPlanDetails.forEach(item -> this.deleteByPrimaryKey(item.getId()));
                    }
                }
                monthPlan.setStatus(2);
                if(modify == 1) {
                    monthPlan.setStatus(3);
                }
                monthPlan.setUpdateDate(new Date());
                monthPlanService.updateByPrimaryKeySelective(monthPlan);
                calcMonthPlanData(monthPlan.getId());
            }
        }
        return ar;
    }

    /**
     * 计算月度计划调整之后的目标
     * @param monthPlanId
     */
    public void calcMonthPlanData(Integer monthPlanId){
        int status = 0;
        BigDecimal planGrossProfit = BigDecimal.ZERO;
        List<MonthPlanDetail> monthPlanDetails = monthPlanDetailMapper.selectMonthPlanAims(monthPlanId);
        for(MonthPlanDetail i:monthPlanDetails){
            planGrossProfit = planGrossProfit.add(i.getLevelTwo()== null ? BigDecimal.ZERO:i.getLevelTwo().subtract(i.getPurchasePrice()== null ? BigDecimal.ZERO:i.getPurchasePrice()).add(i.getForecastProfit()==null?BigDecimal.ZERO:i.getForecastProfit()));
            if(i.getStatus() == 3){
                status++;
            }
        }
        MonthPlan monthPlan  = new MonthPlan();
        if(status >= monthPlanDetails.size()){
            monthPlan.setStatus(3);
        }
        monthPlan.setId(monthPlanId);
        monthPlan.setPlanGrossProfit(planGrossProfit);
        monthPlan.setPlanSalesVolume(monthPlanDetails.size());
        monthPlan.setUpdateDate(new Date());
        monthPlanService.updateByPrimaryKeySelective(monthPlan);

    }

    @Override
    public Map selectMonthPlanDetail(Integer monthPlanId) {
        Map resultList = this.selectByMonthPlanId(monthPlanId);
        return resultList;
    }

    /**
     * 审批
     * @param monthPlanId 月度计划id
     * @param status 1 审核通过，2驳回
     * @param remark 备注
     */
    @Override
    public void approve(Integer monthPlanId, Integer status, String remark) {
        MonthPlanDetailExample ex = new MonthPlanDetailExample();
        ex.createCriteria().andMonthPlanIdEqualTo(monthPlanId).andStatusEqualTo(2);
        List<MonthPlanDetail> monthPlanDetails = this.selectByExample(ex);
        monthPlanDetails.forEach(i -> {
            if(status == 2){
                i.setStatus(5);
            }else if(status == 1){
                i.setStatus(3);
                i.setLevelOne(i.getLevelOneAdjust());
                i.setLevelTwo(i.getLevelTwoAdjust());
                i.setLevelThree(i.getLevelThreeAdjust());
                i.setLevelOneAdjust(BigDecimal.ZERO);
                i.setLevelTwoAdjust(BigDecimal.ZERO);
                i.setLevelThreeAdjust(BigDecimal.ZERO);
                carGoodInfoService.updatePlanAllowPrice(i.getCarId(),i.getLevelTwo());
            }
            i.setUpdateDate(new Date());
            this.updateByPrimaryKeySelective(i);
        });
        MonthPlan mp = new MonthPlan();
        mp.setId(monthPlanId);
        mp.setStatus(3);
        if(status == 2){
            mp.setStatus(5);
        }
        mp.setRemark(remark);
        mp.setUpdateDate(new Date());
        monthPlanService.updateByPrimaryKeySelective(mp);
        this.calcMonthPlanData(monthPlanId);
    }

    @Override
    public List<Map> selectVehicleMonthPlanDetail(Integer carId) {
        List<Map> list = monthPlanDetailMapper.selectVehicleMonthPlanDetail(carId);
        return list;
    }


}
