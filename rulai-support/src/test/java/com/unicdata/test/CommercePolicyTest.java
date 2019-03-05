package com.unicdata.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicdata.entity.policy.CommercePolicy;
import com.unicdata.entity.policy.RebateProject;
import com.unicdata.job.CommercePolicyJob;
import com.unicdata.service.policy.CommercePolicyService;
import com.unicdata.service.policy.RebateProjectService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by shenyong on 2018/6/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@Transactional
public class CommercePolicyTest {

    @Autowired
    CommercePolicyService commercePolicyService;
    @Autowired
    RebateProjectService rebateProjectService;
    @Autowired
    CommercePolicyJob commercePolicyJob;

    @Test
    public void test() {
        CommercePolicy cp = new CommercePolicy();
        cp.setId(1);
        cp.setPolicyName("测试商务政策1");
        cp.setPolicyCreateDate(new Date());
        cp.setStoreId(1);
        cp.setEmployeeId(1);
        cp.setCreateDate(new Date());
        cp.setUpdateDate(new Date());
        int x = commercePolicyService.save(cp);
        System.out.println("-=====- " + cp.getId());
        Assert.assertTrue(x > 0);
    }

    @Test
    public void test1() throws ParseException {
        RebateProject rp = new RebateProject();
        rp.setPolicyId(1);
        rp.setRebateName("测试返利项目");
        rp.setRebateProjectType(1);
        rp.setRebateNumber(-1);
        rp.setReportMaterialRequirements(1);
        rp.setRebateStartDateStr("2018-06-07");
        rp.setRebateEndDateStr("2018-06-14");
        rp.setRebateType(1);
        rp.setRebateTypeValue(BigDecimal.valueOf(6));
        rp.setRebateStandardNumber(4);
        rp.setStatus(0);
        rp.setStoreId(1);
        rp.setEmployeeId(1);
        rp.setUpdateDate(new Date());
        rp.setCreateDate(new Date());
        int x = rebateProjectService.saveRebate(rp);
        System.out.println("-=====- " + rp.getId());
        Assert.assertTrue(x > 0);
    }

    /**
     * 修改返利项目 调整类型 1 默认类型
     * @throws ParseException
     */
    @Test
    public void test2() throws ParseException {
        RebateProject rp = new RebateProject();
        rp.setId(21);
        rp.setAdjustType(1);
        rp.setRebateTypeValue(BigDecimal.valueOf(5.5));
        rp.setStatus(0);
        rp.setUpdateDate(new Date());
        rp.setEmployeeId(1);
        Integer x = rebateProjectService.updateRebate(rp);
        System.out.println("-=====- " + x);
        Assert.assertTrue(x > 0);
    }

    /**
     * 修改返利项目 调整类型 2具体库存
     * @throws ParseException
     */
    @Test
    public void test3() throws ParseException {
        JSONObject map = new JSONObject();
        map.put("carId","9");
        map.put("adjust","-1000");
        map.put("type","0");
        JSONObject map1 = new JSONObject();
        map1.put("carId","10");
        map1.put("adjust","-1800");
        map1.put("type","0");
        JSONObject map2 = new JSONObject();
        map2.put("carId","12");
        map2.put("adjust","-1000");
        map2.put("type","1");

        JSONArray list = new JSONArray();
        list.add(map);
        list.add(map1);
        list.add(map2);
        RebateProject rp = new RebateProject();
        rp.setId(5);
        rp.setAdjustType(2);
        rp.setCarMap(list.toJSONString());
        rp.setStatus(1);
        rp.setUpdateDate(new Date());
        rp.setEmployeeId(1);
        Integer x = rebateProjectService.updateRebate(rp);
        System.out.println("-=====- " + x);
        Assert.assertTrue(x > 0);
    }

    @Test
    public void test4() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy01");
        System.out.println(df.format(new Date()));
    }
    @Test
    public void test5() throws ParseException {
        rebateProjectService.inStorageCarRebateProject(15);
    }


    @Test
    public void test6() throws ParseException {
        rebateProjectService.executeCarPlanExtraction(99);
    }

    @Test
    public void test7() throws ParseException {
        commercePolicyJob.calcPlanExtraction();
    }

}
