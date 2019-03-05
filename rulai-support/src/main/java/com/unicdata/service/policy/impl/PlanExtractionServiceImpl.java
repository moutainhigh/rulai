package com.unicdata.service.policy.impl;

import com.unicdata.dao.policy.PlanExtractionMapper;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoExample;
import com.unicdata.entity.policy.*;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.policy.PlanExtractionService;
import com.unicdata.service.policy.RebateCarService;
import com.unicdata.service.policy.RebateProjectService;
import com.unicdata.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by myMsi on 2018/5/28.
 */
@Service
public class PlanExtractionServiceImpl implements PlanExtractionService {

    @Autowired
    private PlanExtractionMapper planExtractionMapper;
    @Autowired
    private RebateProjectService rebateProjectService;
    @Autowired
    private RebateCarService rebateCarService;
    @Autowired
    private CarGoodInfoService carGoodInfoService;



    @Override
    public int deleteByPrimaryKey(Integer id) {
        return planExtractionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PlanExtraction record) {
        return planExtractionMapper.insert(record);
    }

    @Override
    public int insertSelective(PlanExtraction record) {
        return planExtractionMapper.insertSelective(record);
    }

    @Override
    public List<PlanExtraction> selectByExample(PlanExtractionExample example) {
        return planExtractionMapper.selectByExample(example);
    }

    @Override
    public PlanExtraction selectByPrimaryKey(Integer id) {
        return planExtractionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PlanExtraction record) {
        return planExtractionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PlanExtraction record) {
        return planExtractionMapper.updateByPrimaryKey(record);
    }

    @Override
    public void selectPlan(Integer month) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String startDate = month+"01";
        Date endDate = DateUtil.getLastDayOfMonth(new SimpleDateFormat("yyyyMMdd").parse(startDate));
        RebateProjectExample ex = new RebateProjectExample();
        ex.createCriteria().andRebateStartDateLessThanOrEqualTo(endDate).andRebateEndDateGreaterThanOrEqualTo(df.parse(startDate)).andStatusEqualTo(1);
        List<RebateProject> rebateProjects = rebateProjectService.selectByExample(ex);

    }

    @Override
    public Integer planCheck(Integer id ,Integer employeeId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PlanExtraction planExtraction = this.selectByPrimaryKey(id);
            Date planMonth = new SimpleDateFormat("yyyyMMdd").parse(planExtraction.getPlanExtractionDate() + "01");
            Date monthStartDate = DateUtil.getFirstDayOfMonth(planMonth);
            Date monthEndDate = DateUtil.getLastDayOfMonth(planMonth);
            List carIdList = new ArrayList<>();
            CarGoodInfoExample ex = new CarGoodInfoExample();
            CarGoodInfoExample.Criteria criteria = ex.createCriteria();
            criteria.andDistributorStoreIdEqualTo(planExtraction.getStoreId());
            criteria.andFullPayDateBetweenOrFirstDmsDateBetween(sdf.format(monthStartDate), sdf.format(monthEndDate));
            List<CarGoodInfo> carGoodInfos = carGoodInfoService.selectByExample(ex);
            for (CarGoodInfo car : carGoodInfos) {
                //查询出首次DMS时间或者全款时间在当月第一天和最后一天之间的车辆id
                carIdList.add(car.getId());
            }
            RebateCarExample rce = new RebateCarExample();
            rce.createCriteria().andCarIdIn(carIdList);
            List<RebateCar> rebateCars = rebateCarService.selectByExample(rce);
            for (RebateCar rc : rebateCars){
                rc.setIsPlanExtraction(1);
                rc.setUpdateDate(new Date());
                rc.setEmployeeId(employeeId);
                rebateCarService.updateByPrimaryKeySelective(rc);
            }
            planExtraction.setEmployeeId(employeeId);
            planExtraction.setStatus(1);
            planExtraction.setUpdateDate(new Date());
            return this.updateByPrimaryKeySelective(planExtraction);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
