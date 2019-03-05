package com.unicdata.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unicdata.entity.car.CarGoodInfoExample;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.CarTimerService;
import com.unicdata.util.IPUtil;

/**
 * 车辆信息 定时器
 * 
 * @author wxn
 * @date 2018年6月25日
 */
@Component
public class CarTimer {

	@Autowired
	private CarGoodInfoService carGoodInfoService;
	@Autowired
	private CarTimerService carTimerService;

	@Value("${spring.profiles.active}")
	private String springProfilesActive;
	@Value("${jobIp}")
	private String jobIp;

	/**
	 * 每天凌晨计算 车辆相关信息
	 * 
	 * @see 如 车辆库存天数 等
	 */
	@Scheduled(cron = "1 1 1 * * ?")
	public void carUpdate() {
		try {
			if (IPUtil.isLocalIp(jobIp) && !springProfilesActive.equals("dev")) {
				CarGoodInfoExample example = new CarGoodInfoExample();
				List<CarGoodInfoWithBLOBs> carList = carGoodInfoService.selectByExampleWithBLOBs(example);
				for (int i = 0; i < carList.size(); i++) {
					CarGoodInfoWithBLOBs car = carTimerService.carTimerCaculate(carList.get(i));
					carGoodInfoService.updateByPrimaryKeySelective(car);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
	}
}
