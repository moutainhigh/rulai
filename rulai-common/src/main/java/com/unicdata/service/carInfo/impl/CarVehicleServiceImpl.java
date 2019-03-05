package com.unicdata.service.carInfo.impl;

import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.car.CarVehicleConfMapper;
import com.unicdata.dao.letprice.MonthPlanDetailMapper;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.letprice.MonthPlanDetail;
import com.unicdata.entity.letprice.MonthPlanDetailExample;
import com.unicdata.service.carInfo.CarVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CarVehicleServiceImpl implements CarVehicleService {

    @Autowired
    private CarVehicleConfMapper carVehicleConfMapper;
    @Autowired
    private MonthPlanDetailMapper monthPlanDetailMapper;
    @Autowired
    private CarGoodInfoMapper carGoodInfoMapper;

    @Override
    public BigDecimal[] selectCarLimitPrice(Integer carId) {
        BigDecimal[] resultData = new BigDecimal[3] ;
        MonthPlanDetailExample ex = new MonthPlanDetailExample();
        ex.createCriteria().andCarIdEqualTo(carId);
        ex.setOrderByClause(" id desc ");
        List<MonthPlanDetail> monthPlanDetails = monthPlanDetailMapper.selectByExample(ex);
        if(monthPlanDetails!=null && monthPlanDetails.size() > 0){
            MonthPlanDetail m = monthPlanDetails.get(0);
            resultData[0] = m.getLevelOne();
            resultData[1] = m.getLevelTwo();
            resultData[2] = m.getLevelThree();
        }else{
            CarGoodInfoWithBLOBs car = carGoodInfoMapper.selectByPrimaryKey(carId);
            if(car != null) {
                CarVehicleConf vehicle = carVehicleConfMapper.selectByPrimaryKey(car.getVehicleId());
                resultData[0] = vehicle.getLevelOne();
                resultData[1] = vehicle.getLevelTwo();
                resultData[2] = vehicle.getLevelThree();
            }
        }
        return resultData;
    }
}
