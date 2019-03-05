package com.unicdata.service.car.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.base.util.DateUtil;
import com.unicdata.constant.CarEnum;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.car.CarInterestRule;
import com.unicdata.service.car.CarInterestRuleService;
import com.unicdata.service.car.CarTimerService;

@Service
public class CarTimerServiceImpl implements CarTimerService {

	@Autowired
	private CarInterestRuleService carInterestRuleService;

	public CarGoodInfoWithBLOBs carTimerCaculate(CarGoodInfoWithBLOBs car) {
		// 生产天数
		car.setProduceDay(null == car.getProduceDate() ? 0
				: Integer.valueOf(DateUtil.howLong("d", car.getProduceDate(), new Date()) + ""));
		// 到店天数 在库天数
		int arriveDay = null == car.getInStorageDate() ? 0
				: Integer.valueOf(DateUtil.howLong("d", car.getInStorageDate(), new Date()) + "");
		car.setArriveDay(arriveDay);
		car.setInStorageDay(arriveDay);
		// 采购天数
		int purchaseDay = null == car.getPurchaseDate() ? 0
				: Integer.valueOf(DateUtil.howLong("d", car.getPurchaseDate(), new Date()) + "");
		car.setPurchaseDay(purchaseDay);
		// 计息天数
		int interestDay = purchaseDay - car.getInterestFreeDay();
		car.setInterestAccrualDay(interestDay);
		// 剩余还款天数
		car.setResidueRepaymentDay(180 - interestDay);
		// 计息金额 车辆为金融采购
		if (car.getFundProperty() == CarEnum.FundProperty.FINANCE.getCode()) {
			BigDecimal interestPrice = new BigDecimal(0);
			List<CarInterestRule> ruleList = carInterestRuleService.selectListByFamily(car.getFamilyId());
			for (int j = 0; j < ruleList.size(); j++) {
				if (interestDay <= 0) {
					break;
				}
				CarInterestRule rule = ruleList.get(j);
				// 是否有上限天数
				if (null != rule.getMaxNum()) {
					int day = rule.getMaxNum() - rule.getMinNum() + 1;
					if (interestDay <= day) {
						interestPrice = interestPrice.add(car.getPurchasePrice().multiply(new BigDecimal(interestDay))
								.multiply(new BigDecimal(rule.getCoefficient())).divide(new BigDecimal(100)));
					} else {
						interestPrice = interestPrice.add(car.getPurchasePrice().multiply(new BigDecimal(day))
								.multiply(new BigDecimal(rule.getCoefficient())).divide(new BigDecimal(100)));
					}
					interestDay -= day;
				} else {
					interestPrice = interestPrice.add(car.getPurchasePrice().multiply(new BigDecimal(interestDay))
							.multiply(new BigDecimal(rule.getCoefficient())).divide(new BigDecimal(100)));
				}
			}
			car.setInterestPrice(interestPrice);
		}
		return car;
	}
}
