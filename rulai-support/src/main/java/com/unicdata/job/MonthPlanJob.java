package com.unicdata.job;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.entity.letprice.MonthPlan;
import com.unicdata.entity.letprice.MonthPlanExample;
import com.unicdata.entity.letprice.MonthPlanExt;
import com.unicdata.service.letprice.MonthPlanDetailService;
import com.unicdata.service.letprice.MonthPlanService;
import com.unicdata.shrio.MyAuthorizationFilter;
import com.unicdata.util.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


/**
 * 计提 定时任务
 * @author shenyong
 */
@Component
public class MonthPlanJob {

	private static final Logger log = LoggerFactory.getLogger(MonthPlanJob.class);

	@Value("${spring.profiles.active}")
	private String springProfilesActive;
	@Value("${server.port}")
	private String port;
	@Value("${jobIp}")
	private String jobIp;

	@Autowired
	private MonthPlanDetailService monthPlanDetailService;
	@Autowired
	private MonthPlanService monthPlanService;

	/**
	 * 月度计划保存快照
	 * 每月第一天执行操作上一个月的数据
	 */
	@Scheduled(cron = "0 30 0 1 * ?")
//	@Scheduled(cron = "0/10 * * * * ?")
	public void executor(){
		try {
			log.warn("月度计划保存快照 ==============开始=============");
			if (IPUtil.isLocalIp(jobIp) && !springProfilesActive.equals("dev")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				MonthPlanExample ex = new MonthPlanExample();
				//这里减去1小时的原因是因为@Scheduled 不支持 L 方式 所以在每月第一天 零点30分 减去一小时 获取上一个月最后一天的月份
				ex.createCriteria().andPlanMonthEqualTo(sdf.format(System.currentTimeMillis()-(1000*60*60*1)));
				List<MonthPlan> monthPlen = monthPlanService.selectByExample(ex);
				monthPlen.forEach(m -> {
					Map monthPlanMap = monthPlanDetailService.selectByMonthPlanId(m.getId());
					MonthPlanExt mpe = new MonthPlanExt();
					mpe.setMonthPlanId(m.getId());
					mpe.setMonthPlanSnapshot(JSONObject.toJSONString(monthPlanMap));
					monthPlanService.replaceIntoSnapshot(mpe);
				});
			}
			log.warn("月度计划保存快照 ==============结束=============");
		}catch (Exception ex){
			ex.printStackTrace();
			log.warn("月度计划保存快照 ==============异常============="+ex.getMessage());
		}finally {

		}
	}
}