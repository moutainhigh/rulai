package com.unicdata.service.order.impl;

import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.entity.car.CarInterestRule;
import com.unicdata.service.car.CarInterestRuleService;
import com.unicdata.service.order.OrderCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@Service
public class OrderCarServiceImpl implements OrderCarService {

    @Autowired
    private CarGoodInfoMapper carGoodInfoMapper;

    @Autowired
    private CarInterestRuleService carInterestRuleService;

    @Override
    public List<Map<String, Object>> getOrderCarList(Map<String, Object> map) {
        List<Map<String, Object>> carList = carGoodInfoMapper.carList(map);
        for (Map<String, Object> car : carList) {
            car.put("level", 0);
            if ((Integer) car.get("fundProperty") == 1) {
                Integer familyId = (Integer) car.get("familyId");
                Integer purchaseDay = (Integer) car.get("purchaseDay");
                List<CarInterestRule> ruleList = carInterestRuleService.selectListByFamily(familyId);
                for (int i = 0; i < ruleList.size(); i++) {
                    CarInterestRule carInterestRule = ruleList.get(i);
                    if (i == ruleList.size() - 1) {
                        car.put("level", i + 1);
                        break;
                    }
                    if (purchaseDay >= carInterestRule.getMinNum() && purchaseDay < carInterestRule.getMaxNum()) {
                        car.put("level", i + 1);
                        break;
                    }
                }
            }
        }
        return carList;
    }
}
