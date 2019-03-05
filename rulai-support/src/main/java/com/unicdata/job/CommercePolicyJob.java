package com.unicdata.job;

import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoExample;
import com.unicdata.entity.policy.*;
import com.unicdata.entity.system.DistributorStoreInfo;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.policy.PlanExtractionRebateService;
import com.unicdata.service.policy.PlanExtractionService;
import com.unicdata.service.policy.RebateCarService;
import com.unicdata.service.policy.RebateProjectService;
import com.unicdata.service.system.DistributorStoreInfoService;
import com.unicdata.util.DateUtil;
import com.unicdata.util.IPUtil;
import com.unicdata.util.RedisUtil;
import io.netty.util.internal.MacAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.net.util.IPAddressUtil;

import java.math.BigDecimal;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 计提 定时任务
 * @author shenyong
 */
@Component
public class CommercePolicyJob {

	private static final String  REBATEPROJECTINVALID = "COMMERCEPOLICYJOB_REDIS_KEY_REBATEPROJECTINVALID";
	private static final String  CALCPLANEXTRACTION = "COMMERCEPOLICYJOB_REDIS_KEY_CALCPLANEXTRACTION";

	@Value("${spring.profiles.active}")
	private String springProfilesActive;
	@Value("${server.port}")
	private String port;
	@Value("${jobIp}")
	private String jobIp;

	@Autowired
	private CarGoodInfoService carGoodInfoService;
	@Autowired
	private RebateCarService rebateCarService;
	@Autowired
	private PlanExtractionService planExtractionService;
	@Autowired
	private DistributorStoreInfoService distributorStoreInfoService;
	@Autowired
	private RebateProjectService rebateProjectService;
	@Autowired
	private PlanExtractionRebateService planExtractionRebateService;
	/**
	 * 返利项目失效
	 */
	@Scheduled(cron = "1 1 0 * * ?")
//	@Scheduled(cron = "0/10 * * * * ?")
	public void rebateProjectInvalid(){
		try {
			if (IPUtil.isLocalIp(jobIp) && !springProfilesActive.equals("dev")){
				RebateProjectExample rpe = new RebateProjectExample();
				rpe.createCriteria().andRebateEndDateLessThanOrEqualTo(new Date()).andStatusEqualTo(1);
				List<RebateProject> rebateProjects = rebateProjectService.selectByExample(rpe);
				for(RebateProject rp : rebateProjects){
					RebateCarExample rce = new RebateCarExample();
					rce.createCriteria().andRebateProjectIdEqualTo(rp.getId()).andIsPlanExtractionEqualTo(0);
					List<RebateCar> rebateCars = rebateCarService.selectByExample(rce);
					for(RebateCar rc : rebateCars){
						if(rc.getPlanExtraction() == null || rc.getPlanExtraction().doubleValue() <= 0 ) {
							rc.setEstimateAdjust(new BigDecimal("-" + rc.getFirstEstimateRebate()));
							rc.setUpdateDate(new Date());
							rebateCarService.updateByPrimaryKeySelective(rc);
						}
					}
					rp.setStatus(2);//过期
					rp.setUpdateDate(new Date());
					rebateProjectService.updateByPrimaryKeySelective(rp);
				}
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}finally {

		}
	}

	/**
	 * 计算计提数据
	 */
	@Scheduled(cron = "1 1 0 * * ?")
//	@Scheduled(cron = "0/5 * * * * ?")
	public void calcPlanExtraction() {
		try {
			if (IPUtil.isLocalIp(jobIp) && !springProfilesActive.equals("dev")){
				System.out.println(System.currentTimeMillis()+"server port:"+port);
				String yearStartDate = DateUtil.getYear()+"-01-01";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				//计算当月所有门店的计提数据
				Date monthStartDate = DateUtil.getFirstDayOfMonth(new Date());
				Date monthEndDate = DateUtil.getLastDayOfMonth(new Date());
				Integer yearThisMonth = Integer.valueOf(new SimpleDateFormat("yyyyMM").format(System.currentTimeMillis()));
				List<DistributorStoreInfo> distributorStoreInfos = distributorStoreInfoService.selectByExample(null);
				for (DistributorStoreInfo storeInfo : distributorStoreInfos) {
					exec(monthStartDate, monthEndDate, yearThisMonth, storeInfo.getId());
				}

				// 计算财务待审核的计提数据
				PlanExtractionExample plane = new PlanExtractionExample();
				plane.createCriteria().andStatusEqualTo(0);
				List<PlanExtraction> pes = planExtractionService.selectByExample(plane);
				for (PlanExtraction p : pes) {
					if (!yearThisMonth.equals(p.getPlanExtractionDate())) {
						Date s = DateUtil.getFirstDayOfMonth(sdf.parse(p.getPlanExtractionDate() + "01"));
						Date e = DateUtil.getLastDayOfMonth(sdf.parse(p.getPlanExtractionDate() + "01"));
						exec(s, e, p.getPlanExtractionDate(), p.getStoreId());
					}
				}
				// 更新所有计提的到账金额和核对金额
				PlanExtractionExample pe = new PlanExtractionExample();
				pe.createCriteria().andStatusEqualTo(1);
				List<PlanExtraction> list = planExtractionService.selectByExample(pe);
				for (PlanExtraction p : list) {
					Date s = DateUtil.getFirstDayOfMonth(new SimpleDateFormat("yyyyMMdd").parse(p.getPlanExtractionDate() + "01"));
					Date e = DateUtil.getLastDayOfMonth(new SimpleDateFormat("yyyyMMdd").parse(p.getPlanExtractionDate() + "01"));
					RebateCar rebateCar = rebateCarService.selectSumPlanAndArriveBillProofreader(p.getStoreId(), s, e);
					if (rebateCar != null) {
						PlanExtraction planExtraction = new PlanExtraction();
						planExtraction.setProofreaderMoney(rebateCar.getProofreaderMoney());
						planExtraction.setArriveBillMoney(rebateCar.getArriveBillMoney());
						planExtraction.setUpdateDate(new Date());
						planExtraction.setId(p.getId());
						planExtractionService.updateByPrimaryKeySelective(planExtraction);
					}
				}
				// 更新计提的返利项目对应的月度总计
				List<PlanExtractionRebate> planExtractionRebates = planExtractionRebateService.selectByExample(null);
				for (PlanExtractionRebate p : planExtractionRebates) {
					//计算 当年 - 计提总额、当年 - 调整计提
					Map map = rebateCarService.selectYearSumPlanAndAdjustByRebateId(yearStartDate, sdf.format(monthEndDate), p.getRebateProjectId());
					if(map != null) {
						p.setYearPlanMoney((BigDecimal) map.getOrDefault("planExtractionTotal", 0));
						p.setYearPlanAbjustMoney((BigDecimal) map.getOrDefault("planExtractionAdjustTotal", 0));
					}
					p.setUpdateDate(new Date());
					planExtractionRebateService.updateByPrimaryKeySelective(p);

				}
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}finally {

		}
	}

	/**
	 * 计算指定月份的计提数据
	 * @param monthStartDate 当月开始日期 如：2018-06-01
	 * @param monthEndDate 当月结束日期 如：2018-06-30
	 * @param yearThisMonth 当年当前月份 如：201806
     * @param storeId 门店id
     */
	private void exec(Date monthStartDate, Date monthEndDate, Integer yearThisMonth, Integer storeId) {
		try {
			int thisYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(System.currentTimeMillis()));
			PlanExtractionExample plane = new PlanExtractionExample();
			plane.createCriteria().andPlanExtractionDateEqualTo(yearThisMonth).andStoreIdEqualTo(storeId);
			List<PlanExtraction> pes = planExtractionService.selectByExample(plane);
			//已审核的计提不需要重新跑
			if (pes == null || pes.size() <= 0 || pes.get(0).getStatus() == 0) {
				BigDecimal month_plan_money = BigDecimal.ZERO;//当月 - 计提总额
				BigDecimal year_plan_money = BigDecimal.ZERO;//当年 - 计提总额
				BigDecimal year_plan_abjust_money = BigDecimal.ZERO;//当年 - 调整计提
				BigDecimal proofreader_money = BigDecimal.ZERO;//核对金额
				BigDecimal arrive_bill_money = BigDecimal.ZERO;//到账总额
				//计算 当月 - 计提总额、 核对金额、 到账总额
				RebateCar rebateCar = rebateCarService.selectSumPlanAndArriveBillProofreader(storeId, monthStartDate, monthEndDate);
				if (rebateCar != null) {
					month_plan_money = rebateCar.getPlanExtraction();
					proofreader_money = rebateCar.getProofreaderMoney();
					arrive_bill_money = rebateCar.getArriveBillMoney();
					//当年计提总额默认等于当月的（后面的计算中会累加一月份到当前月减1 的月份金额）
					year_plan_money = rebateCar.getPlanExtraction();
				}
				//计算 当年 - 计提总额
				year_plan_money = year_plan_money.add(getYearPlanMoney(yearThisMonth, storeId));

				//计算 当年 - 调整计提
				year_plan_abjust_money = getYearPlanAdjustMoney(monthEndDate, storeId);

				PlanExtraction planExtraction = new PlanExtraction();
				planExtraction.setPlanYear(thisYear);
				planExtraction.setMonthPlanMoney(month_plan_money);
				planExtraction.setYearPlanMoney(year_plan_money);
				planExtraction.setYearPlanAbjustMoney(year_plan_abjust_money);
				planExtraction.setProofreaderMoney(proofreader_money);
				planExtraction.setArriveBillMoney(arrive_bill_money);
				planExtraction.setStoreId(storeId);
				planExtraction.setStatus(0);
				planExtraction.setPlanExtractionDate(yearThisMonth);
				planExtraction.setEmployeeId(1);
				planExtraction.setUpdateDate(new Date());
				if (pes == null || pes.size() <= 0) {
					planExtraction.setCreateDate(new Date());
					planExtractionService.insertSelective(planExtraction);
				} else {
					planExtraction.setId(pes.get(0).getId());
					planExtractionService.updateByPrimaryKeySelective(planExtraction);
				}
				this.calcRebateMonthPlanDetail(monthStartDate,monthEndDate,yearThisMonth,storeId,planExtraction.getId());
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * 计算返利月度计提明细
	 * @param monthStartDate
	 * @param monthEndDate
	 * @param yearThisMonth
	 * @param storeId
	 */
	private void calcRebateMonthPlanDetail(Date monthStartDate, Date monthEndDate, Integer yearThisMonth, Integer storeId, Integer planExtractionId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String , Integer> peMap = new HashMap<>();
		PlanExtractionRebateExample ex = new PlanExtractionRebateExample();
		ex.createCriteria().andPlanExtractionIdEqualTo(planExtractionId);
		List<PlanExtractionRebate> pes = planExtractionRebateService.selectByExample(ex);
		for(PlanExtractionRebate p : pes){
			peMap.put(p.getPlanExtractionDate()+"-"+p.getRebateProjectId() , p.getId());
		}
		int thisYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(System.currentTimeMillis()));

		//查询单个返利项目 当月 - 计提总额 、核对总额、到账总额
		List<PlanExtractionRebate> planExtractionRebates = planExtractionRebateService.selectRebateMonthPlan(sdf.format(monthStartDate), sdf.format(monthEndDate),storeId);
		for(PlanExtractionRebate plr : planExtractionRebates) {
			String yearStartDate = DateUtil.getYear()+"-01-01";
			//计算 当年 - 计提总额、当年 - 调整计提
			Map map = rebateCarService.selectYearSumPlanAndAdjustByRebateId(yearStartDate, sdf.format(monthEndDate), plr.getRebateProjectId());
			if(map != null) {
				plr.setYearPlanMoney((BigDecimal) map.getOrDefault("planExtractionTotal", 0));
				plr.setYearPlanAbjustMoney((BigDecimal) map.getOrDefault("planExtractionAdjustTotal", 0));
			}
			plr.setPlanYear(thisYear);
            plr.setPlanExtractionDate(yearThisMonth);
            plr.setPlanExtractionId(planExtractionId);
            plr.setEmployeeId(1);
            plr.setUpdateDate(new Date());
			if(peMap.get(yearThisMonth+"-"+plr.getRebateProjectId())!= null &&  peMap.get(yearThisMonth+"-"+plr.getRebateProjectId()) > 0) {
				plr.setId(peMap.get(yearThisMonth+"-"+plr.getRebateProjectId()));
				planExtractionRebateService.updateByPrimaryKeySelective(plr);
			}else{
				plr.setCreateDate(new Date());
				planExtractionRebateService.insertSelective(plr);
			}
        }
	}

	/**
	 * 计算 当年 - 计提总额
	 */
	private BigDecimal getYearPlanMoney( Integer yearThisMonth, Integer storeId) {
		//当年计提总额 = 一月份到当前月份的计提总额的和
		//这里先查询出来 一月到当前月的数据进行累加 赋值给 当年-计提总额
		Integer yearOneMonth = Integer.valueOf(new SimpleDateFormat("yyyy01").format(System.currentTimeMillis()));
		BigDecimal year_plan_money = BigDecimal.ZERO;
		PlanExtractionExample pee = new PlanExtractionExample();
		pee.createCriteria().andPlanExtractionDateBetween(yearOneMonth,yearThisMonth-1 ).andStoreIdEqualTo(storeId);
		List<PlanExtraction> planExtractions = planExtractionService.selectByExample(pee);
		for(PlanExtraction plan : planExtractions){
            year_plan_money = year_plan_money.add(plan.getMonthPlanMoney());
        }
		return year_plan_money;
	}

	/**
	 * 计算 当年 - 调整计提
	 * @param endDate
	 * @param storeId
     * @return
     */
	private BigDecimal getYearPlanAdjustMoney(Date endDate, Integer storeId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		String carIds ="0" ;
		//当年 - 调整计提 = 首次DMS时间或者全款时间在每年的第一天到当前月的第一天之间的车辆 计提审核通过的调整计提字段之和
		CarGoodInfoExample carEx = new CarGoodInfoExample();
		CarGoodInfoExample.Criteria carCri = carEx.createCriteria();
		carCri.andDistributorStoreIdEqualTo(storeId);
		carCri.andFullPayDateBetweenOrFirstDmsDateBetween(DateUtil.getYear()+"-01-01" , sdf.format(endDate));
		List<CarGoodInfo> planGoodInfos = carGoodInfoService.selectByExample(carEx);
		for (CarGoodInfo car : planGoodInfos) {
            //查询出首次DMS时间或者全款时间在当月第一天和最后一天之间的车辆id
            carIds+=","+car.getId();
        }
		//计算
		RebateCar year_plan = rebateCarService.selectSumplanExtractionAdjust(carIds);
		if(year_plan != null){
            return year_plan.getPlanExtractionAdjust();
        }
		return BigDecimal.ZERO;
	}

	public static void main(String[] args) {
		System.out.println(MacAddressUtil.bestAvailableMac());
		System.out.println(MacAddressUtil.defaultMachineId());
		System.out.println(MacAddressUtil.formatAddress(MacAddressUtil.bestAvailableMac()));
		System.out.println(MacAddressUtil.formatAddress(MacAddressUtil.defaultMachineId()));

		System.out.println(IPUtil.getLocalIPList());


	}




}





























