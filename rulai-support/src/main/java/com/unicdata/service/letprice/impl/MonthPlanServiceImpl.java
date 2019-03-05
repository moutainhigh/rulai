package com.unicdata.service.letprice.impl;

import com.unicdata.base.util.CalculateUtils;
import com.unicdata.dao.letprice.MonthPlanExtMapper;
import com.unicdata.dao.letprice.MonthPlanMapper;
import com.unicdata.entity.letprice.*;
import com.unicdata.service.letprice.MonthPlanDetailService;
import com.unicdata.service.letprice.MonthPlanService;
import com.unicdata.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by shenyong on 2018/6/12.
 */
@Service
public class MonthPlanServiceImpl implements MonthPlanService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    private SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private MonthPlanMapper monthPlanMapper;
    @Autowired
    private MonthPlanDetailService monthPlanDetailService;
    @Autowired
    private MonthPlanExtMapper monthPlanExtMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return monthPlanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MonthPlan record) {
        return monthPlanMapper.insert(record);
    }

    @Override
    public int insertSelective(MonthPlan record) {
        return monthPlanMapper.insertSelective(record);
    }

    @Override
    public List<MonthPlan> selectByExample(MonthPlanExample example) {
        return monthPlanMapper.selectByExample(example);
    }

    @Override
    public MonthPlan selectByPrimaryKey(Integer id) {
        return monthPlanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MonthPlan record) {
        return monthPlanMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MonthPlan record) {
        return monthPlanMapper.updateByPrimaryKey(record);
    }

    /**
     * 新增新年份数据
     * @param year
     * @param storeId
     */
    void insertInitThisYear(Integer year,Integer storeId,Integer employeeId){
        for(int i = 1 ;i<=12 ;i++){
            String monthPlan = year+"-"+String.format("%02d",i);
            MonthPlan mp = new MonthPlan();
            mp.setPlanYear(year);
            mp.setPlanMonth(monthPlan);
            mp.setStatus(0);
            mp.setStoreId(storeId);
            mp.setEmployeeId(employeeId);
            mp.setUpdateDate(new Date());
            mp.setCreateDate(new Date());
            this.insertSelective(mp);
        }
    }

    @Override
    public Integer save(MonthPlan mp) {
        MonthPlan monthPlan = this.selectByPrimaryKey(mp.getId());
        MonthPlanDetailExample ex = new MonthPlanDetailExample();
        ex.createCriteria().andMonthPlanIdEqualTo(mp.getId());
        List<MonthPlanDetail> monthPlanDetails = monthPlanDetailService.selectByExample(ex);
        if(monthPlan != null && (monthPlanDetails == null || monthPlanDetails.size() <= 0)){
            mp.setStatus(0);
            if(sdf.format(System.currentTimeMillis()).equals(monthPlan.getPlanMonth())){
                mp.setStatus(1);
            }
            mp.setUpdateDate(new Date());
            return monthPlanMapper.updateGoal(mp.getId(),mp.getGoalSalesVolume(), mp.getGoalGrossProfit());
        }
        return 0;
    }

    @Override
    public List<MonthPlan> selectByExampleAndSaveYear(MonthPlan mp) {
        String currentMonth = sdf.format(System.currentTimeMillis());
        MonthPlanExample ex = new MonthPlanExample();
        MonthPlanExample.Criteria criteria = ex.createCriteria();
        criteria.andPlanYearEqualTo(mp.getPlanYear()) ;
        if(mp.getStoreId() != null && mp.getStoreId() > 0){
            criteria.andStoreIdEqualTo(mp.getStoreId());
        }
        ex.setOrderByClause(" plan_month asc ");
        List<MonthPlan> monthPlens =  monthPlanMapper.selectByExample(ex);
        if(monthPlens == null || monthPlens.size() <= 0 ){
            insertInitThisYear(mp.getPlanYear(),mp.getStoreId(),mp.getEmployeeId());
            return selectByExampleAndSaveYear(mp);
        }
        MonthPlan sumMp = new MonthPlan();
        for(MonthPlan i : monthPlens){
            if(i.getPlanMonth().equals(currentMonth)){
                MonthPlan monthPlan = this.calcMonthDate(i.getId());
                i.setCompleteSalesVolume(monthPlan.getCompleteSalesVolume()==null?0: monthPlan.getCompleteSalesVolume());
                i.setCompleteGrossProfit(monthPlan.getCompleteGrossProfit()==null?BigDecimal.ZERO:monthPlan.getCompleteGrossProfit());
                i.setDifferenceSalesVolume(monthPlan.getDifferenceSalesVolume()==null?0:monthPlan.getDifferenceSalesVolume());
                i.setDifferenceGrossProfit(monthPlan.getDifferenceGrossProfit()==null?BigDecimal.ZERO:monthPlan.getDifferenceGrossProfit());
            }
            i.setIsShowArchiving(2);
            try {
                if(sd.parse(i.getPlanMonth()+"-01").getTime() < System.currentTimeMillis() && !i.getPlanMonth().equals(currentMonth)){
                    i.setIsShowArchiving(1);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sumMp.setPlanYear(i.getPlanYear());
            sumMp.setBudgetVolume((sumMp.getBudgetVolume()==null?0:sumMp.getBudgetVolume())+ (i.getBudgetVolume()==null?0:i.getBudgetVolume()));
            sumMp.setBudgetGrossProfit(sumMp.getBudgetGrossProfit()==null?BigDecimal.ZERO:sumMp.getBudgetGrossProfit().add(i.getBudgetGrossProfit()==null?BigDecimal.ZERO:i.getBudgetGrossProfit()));
            sumMp.setGoalSalesVolume((sumMp.getGoalSalesVolume()==null?0:sumMp.getGoalSalesVolume())+ (i.getGoalSalesVolume()==null?0:i.getGoalSalesVolume()));
            sumMp.setGoalGrossProfit(sumMp.getGoalGrossProfit()==null?BigDecimal.ZERO:sumMp.getGoalGrossProfit().add(i.getGoalGrossProfit()==null?BigDecimal.ZERO:i.getGoalGrossProfit()));
            sumMp.setPlanSalesVolume((sumMp.getPlanSalesVolume()==null?0:sumMp.getPlanSalesVolume()) + (i.getPlanSalesVolume()==null?0:i.getPlanSalesVolume()));
            sumMp.setPlanGrossProfit(sumMp.getPlanGrossProfit()==null?BigDecimal.ZERO:sumMp.getPlanGrossProfit().add(i.getPlanGrossProfit()==null?BigDecimal.ZERO:i.getPlanGrossProfit()));
            sumMp.setCompleteSalesVolume((sumMp.getCompleteSalesVolume()==null?0: sumMp.getCompleteSalesVolume())  + (i.getCompleteSalesVolume()==null?0:i.getCompleteSalesVolume()));
            sumMp.setCompleteGrossProfit(sumMp.getCompleteGrossProfit()==null?BigDecimal.ZERO:sumMp.getCompleteGrossProfit().add(i.getCompleteGrossProfit()==null?BigDecimal.ZERO:i.getCompleteGrossProfit()));
            sumMp.setDifferenceSalesVolume((sumMp.getDifferenceSalesVolume()==null?0:sumMp.getDifferenceSalesVolume())  + (i.getDifferenceSalesVolume()==null?0: i.getDifferenceSalesVolume()));
            sumMp.setDifferenceGrossProfit(sumMp.getDifferenceGrossProfit()==null?BigDecimal.ZERO:sumMp.getDifferenceGrossProfit().add(i.getDifferenceGrossProfit()==null?BigDecimal.ZERO:i.getDifferenceGrossProfit()));
        }
        sumMp.setPlanMonth("合计");
        monthPlens.add(sumMp);
        return monthPlens;
    }

    @Override
    public void archiving(Integer id , Integer employeeId) throws ParseException {
        MonthPlan monthPlan = calcMonthDate(id);
        Integer archivingMonth = Integer.valueOf( monthPlan.getPlanMonth().replaceAll("-",""));
        Integer thisMonth = Integer.valueOf(new SimpleDateFormat("yyyyMM").format(System.currentTimeMillis()));
        //"归档"操作,只有当当前月份超过该月度计划才能进行归档操作
        if(archivingMonth < thisMonth){
            MonthPlan mp = new MonthPlan();
            mp.setId(id);
            mp.setCompleteGrossProfit(monthPlan.getCompleteGrossProfit());
            mp.setCompleteSalesVolume(monthPlan.getCompleteSalesVolume());
            mp.setDifferenceGrossProfit(monthPlan.getDifferenceGrossProfit());
            mp.setDifferenceSalesVolume(monthPlan.getDifferenceSalesVolume());
            mp.setStatus(4);
            mp.setEmployeeId(employeeId);
            mp.setUpdateDate(new Date());
            int x = monthPlanMapper.updateByPrimaryKeySelective(mp);
            if(x > 0){
                Date archivingNextMonth = DateUtil.addMonths(sdf.parse(monthPlan.getPlanMonth()), 1);
                Integer nextYear = Integer.valueOf(new SimpleDateFormat("yyyy").format(archivingNextMonth)); //归档月份+1之后的年份
                String nextMonth = sdf.format(archivingNextMonth);//归档月份+1之后的月份
                MonthPlanExample ex = new MonthPlanExample();
                MonthPlanExample.Criteria criteria = ex.createCriteria();
                criteria.andPlanMonthEqualTo(nextMonth).andStoreIdEqualTo(monthPlan.getStoreId());
                List<MonthPlan> monthPlens =  monthPlanMapper.selectByExample(ex);
                //判断当 归档月份+1之后的月份 没有查询到数据时说明 归档月份+1之后的年份 没有数据需要新建
                if(monthPlens == null || monthPlens.size() <= 0 ){
                    MonthPlan findMp = new MonthPlan();
                    findMp.setStoreId(monthPlan.getStoreId());
                    findMp.setPlanYear(nextYear);
                    findMp.setEmployeeId(employeeId);
                    List<MonthPlan> monthPlanList = selectByExampleAndSaveYear(findMp);
                    for(MonthPlan mplan : monthPlanList){
                        if(mplan.getPlanMonth().equals(nextMonth)){
                            mplan.setStatus(1);
                            mplan.setEmployeeId(employeeId);
                            mplan.setUpdateDate(new Date());
                            this.updateByPrimaryKeySelective(mplan);
                            break;
                        }
                    }
                }else{
                    MonthPlan plan = monthPlens.get(0);
                    plan.setStatus(1);
                    plan.setEmployeeId(employeeId);
                    plan.setUpdateDate(new Date());
                    this.updateByPrimaryKeySelective(plan);
                }
            }
        }
    }

    /**
     *  这里统计当前id关联库存的车辆销售达成、差异等数据
     * @param id
     * @return
     */
    public MonthPlan calcMonthDate(Integer id){
        MonthPlan monthPlan = this.selectByPrimaryKey(id);
        List<MonthPlanDetail> monthPlanDetails = monthPlanDetailService.selectCompleteSalesInfo(id,monthPlan.getPlanMonth(),monthPlan.getStoreId());
        BigDecimal completeGrossProfit = BigDecimal.ZERO;
        for(MonthPlanDetail m :monthPlanDetails){
            BigDecimal purchasePrice = m.getPurchasePrice()== null ? BigDecimal.ZERO :  m.getPurchasePrice();
            BigDecimal forecastProfit = m.getForecastProfit()== null ? BigDecimal.ZERO : m.getForecastProfit();
            BigDecimal salePrice = m.getSalePrice() == null ? BigDecimal.ZERO:m.getSalePrice();
            BigDecimal donationAmount = m.getDonationAmount() == null ? BigDecimal.ZERO : m.getDonationAmount();
            completeGrossProfit = completeGrossProfit.add(CalculateUtils.calcCarGrossProfit(salePrice,purchasePrice,forecastProfit,donationAmount));
        }
        monthPlan.setGoalGrossProfit(monthPlan.getGoalGrossProfit() == null ? BigDecimal.ZERO : monthPlan.getGoalGrossProfit());
        monthPlan.setCompleteSalesVolume(monthPlanDetails.size());
        monthPlan.setCompleteGrossProfit(completeGrossProfit);
        monthPlan.setDifferenceSalesVolume((monthPlan.getGoalSalesVolume() == null ? 0 : monthPlan.getGoalSalesVolume()) -monthPlanDetails.size());
        monthPlan.setDifferenceGrossProfit(monthPlan.getGoalGrossProfit().subtract(completeGrossProfit));
        return monthPlan;
    }

    /**
     * 保存预算
     * @param mp
     * @return
     */
    @Override
    public Integer saveBudget(MonthPlan mp) {
        MonthPlan monthPlan = this.selectByPrimaryKey(mp.getId());
        if(monthPlan != null && (monthPlan.getBudgetVolume() == null || monthPlan.getBudgetVolume() <= 0 || monthPlan.getBudgetGrossProfit() == null || monthPlan.getBudgetGrossProfit().compareTo(BigDecimal.ZERO) <= 0 )){
            mp.setUpdateDate(new Date());
            return monthPlanMapper.updateBudget(mp.getId(),mp.getBudgetVolume(),mp.getBudgetGrossProfit());
        }
        return -1;
    }

    @Override
    public Integer replaceIntoSnapshot(MonthPlanExt ex) {
        return monthPlanExtMapper.replaceInto(ex);
    }

    @Override
    public MonthPlanExt selectMonthPlanSnapshot(Integer monthPlanId) {
        return monthPlanExtMapper.selectByPrimaryKey(monthPlanId);
    }

}
