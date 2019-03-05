package com.unicdata.test;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.service.car.CarVehicleConfService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by myMsi on 2018/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@Transactional
public class LetPriceTest  {

    @Autowired
    private CarVehicleConfService carVehicleConfService;

    @Test
    public void test(){
        //限价编辑
        CarVehicleConf c = new CarVehicleConf();
        c.setId(2);
        c.setLevelOneAdjust(BigDecimal.valueOf(5000000));
        c.setLevelTwoAdjust(BigDecimal.valueOf(4800000));
        c.setLevelThreeAdjust(BigDecimal.valueOf(4600000));
        c.setAdjustStatus(1);
        c.setUpdateDate(new Date());
        ApiReturnInfo apiReturnInfo = carVehicleConfService.priceEdit(c);
        System.out.println(apiReturnInfo.getMessage());
        Assert.assertTrue(apiReturnInfo.getCode() == 200);
    }

    @Test
    public void test1(){
        //撤销
        ApiReturnInfo apiReturnInfo = carVehicleConfService.chageStatus(1, "6");
        System.out.println(apiReturnInfo.getMessage());
        Assert.assertTrue(apiReturnInfo.getCode() == 200);
    }

    @Test
    public void test2(){
        //全部报备
        ApiReturnInfo apiReturnInfo = carVehicleConfService.chageStatus(2, null);
        System.out.println(apiReturnInfo.getMessage());
        Assert.assertTrue(apiReturnInfo.getCode() == 200);
    }

    @Test
    public void test3(){
        //审批
        ApiReturnInfo apiReturnInfo = carVehicleConfService.chageStatus(3, "7,8");
        System.out.println(apiReturnInfo.getMessage());
        Assert.assertTrue(apiReturnInfo.getCode() == 200);
    }
    @Test
    public void test4(){
        //全部审批
        ApiReturnInfo apiReturnInfo = carVehicleConfService.chageStatus(4, null);
        System.out.println(apiReturnInfo.getMessage());
        Assert.assertTrue(apiReturnInfo.getCode() == 200);
    }

    @Test
    public void test5(){
        //驳回
        ApiReturnInfo apiReturnInfo = carVehicleConfService.chageStatus(5, null);
        System.out.println(apiReturnInfo.getMessage());
        Assert.assertTrue(apiReturnInfo.getCode() == 200);
    }
}

