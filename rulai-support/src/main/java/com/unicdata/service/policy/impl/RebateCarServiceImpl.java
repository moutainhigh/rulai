package com.unicdata.service.policy.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.util.BigDecimalUtils;
import com.unicdata.dao.policy.RebateCarMapper;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoExample;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.policy.RebateCar;
import com.unicdata.entity.policy.RebateCarExample;
import com.unicdata.entity.policy.RebateProject;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.policy.RebateCarService;
import com.unicdata.service.policy.RebateProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by myMsi on 2018/5/28.
 */
@Service
public class RebateCarServiceImpl implements RebateCarService {

    @Autowired
    private RebateCarMapper rebateCarMapper;
    @Autowired
    private CarGoodInfoService carGoodInfoService;
    @Autowired
    private RebateProjectService rebateProjectService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return rebateCarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RebateCar record) {
        return rebateCarMapper.insert(record);
    }

    @Override
    public int insertSelective(RebateCar record) {
        return rebateCarMapper.insertSelective(record);
    }

    @Override
    public List<RebateCar> selectByExample(RebateCarExample example) {
        return rebateCarMapper.selectByExample(example);
    }

    @Override
    public RebateCar selectByPrimaryKey(Integer id) {
        return rebateCarMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RebateCar record) {
        return rebateCarMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RebateCar record) {
        return rebateCarMapper.updateByPrimaryKey(record);
    }

    public RebateCar insertRebateCar(RebateProject rp , CarGoodInfo car){
        RebateCar rc = new RebateCar();
        rc.setPolicyId(rp.getPolicyId());
        rc.setRebateProjectId(rp.getId());
        rc.setStoreId(rp.getStoreId());
        rc.setCarId(car.getId());
        rc.setVin(car.getVin());
        rc.setFirstEstimateRebate(rp.getRebateTypeValue());
        if (rp.getRebateType() == 1) {//百分比
            //按厂商指导价*页面输入的百分比
            BigDecimal firstEstimateRebate = BigDecimalUtils.mul(car.getStandardPrice(), BigDecimalUtils.div(rp.getRebateTypeValue(), new BigDecimal(100), 4));
            rc.setFirstEstimateRebate(firstEstimateRebate);
        }
        rc.setEstimateAdjust(BigDecimal.ZERO);
        rc.setPlanExtraction(BigDecimal.ZERO);
        rc.setPlanExtractionAdjust(BigDecimal.ZERO);
        if(car.getFirstDmsDate()!= null || car.getFullPayDate() != null) {
            rc.setPlanExtraction(rc.getFirstEstimateRebate());
        }
        rc.setIsPlanExtraction(0);
        rc.setEmployeeId(rp.getEmployeeId());
        rc.setUpdateDate(new Date());
        rc.setCreateDate(new Date());
        RebateCarExample rce = new RebateCarExample();
        rce.createCriteria().andCarIdEqualTo(car.getId()).andRebateProjectIdEqualTo(rp.getId());
        List<RebateCar> rebateCars = this.selectByExample(rce);
        if(rebateCars == null || rebateCars.size() <= 0 ) {
            this.insertSelective(rc);
        }else {
            rc.setId(rebateCars.get(0).getId());
            this.updateByPrimaryKeySelective(rc);
        }
        return rc;
    }

    public BigDecimal updateRebateCar(RebateCar rc){

        return null;
    }

    @Override
    public int deleteByKeyAndRebate(Integer id ,Integer rebateId) {
        return rebateCarMapper.deleteByKeyAndRebate(id,rebateId);
    }

    @Override
    public RebateCar selectSumProofreaderArriveBillByPolicyId(Integer policyId) {
        return rebateCarMapper.selectSumProofreaderArriveBillByPolicyId(policyId);
    }

    @Override
    public RebateCar selectSumProofreaderArriveBillByRebateId(Integer rebateId) {
        return rebateCarMapper.selectSumProofreaderArriveBillByRebateId(rebateId);
    }

    @Override
    public List<RebateCar> selectRebateCarByRebateId(Integer rebateId) {

        RebateCarExample ex = new RebateCarExample();
        ex.createCriteria().andRebateProjectIdEqualTo(rebateId);
        List<RebateCar> rebateCars = this.selectByExample(ex);
        for(RebateCar rc : rebateCars){
            CarGoodInfoWithBLOBs car = carGoodInfoService.selectByPrimaryKey(rc.getCarId());
            rc.setCarGoodInfo(car);
        }

        return rebateCars;
    }

    @Override
    public RebateCar selectSumPlanAndArriveBillProofreader(Integer storeId ,Date startDate,Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String carIds = "0";
        CarGoodInfoExample ex = new CarGoodInfoExample();
        CarGoodInfoExample.Criteria criteria = ex.createCriteria();
        criteria.andDistributorStoreIdEqualTo(storeId);
        criteria.andFullPayDateBetweenOrFirstDmsDateBetween(sdf.format(startDate), sdf.format(endDate));
        List<CarGoodInfo> carGoodInfos = carGoodInfoService.selectByExample(ex);
        for (CarGoodInfo car : carGoodInfos) {
            //查询出首次DMS时间或者全款时间在当月第一天和最后一天之间的车辆id
            carIds+=","+car.getId();
        }
        RebateCar rebateCar = rebateCarMapper.selectSumPlanAndArriveBillProofreader(carIds);
        return rebateCar;
    }

    @Override
    public RebateCar selectSumplanExtractionAdjust(String carIds) {
        return rebateCarMapper.selectSumplanExtractionAdjust(carIds);
    }

    @Override
    public Map selectCarRebate(Integer carId) {
        return rebateCarMapper.selectCarRebate(carId);
    }

    @Override
    public Map selectYearSumPlanAndAdjustByRebateId(String yearStartDate, String yearEndDate, Integer rebateId ) {
        return  rebateCarMapper.selectYearSumPlanAndAdjustByRebateId(yearStartDate,yearEndDate,rebateId);
    }

    /**
     * 查询单个车辆所有返利项目的各种金额求和
     * @param carId
     * @return
     */
    public RebateCar selectSumRebateCarDataByCarId(Integer carId){
        return rebateCarMapper.selectSumRebateCarDataByCarId(carId);
    }

    @Override
    public PageInfo<CarGoodInfoWithBLOBs> selectRebateProjectByCar(Integer carId, Integer pageNum, Integer pageSize) {
        pageNum = (null == pageNum || pageNum < 1 ? 1 : pageNum);
        pageSize = null == pageSize || pageSize.intValue() > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);

        CarGoodInfoWithBLOBs car = carGoodInfoService.selectByPrimaryKey(carId);
        RebateCar rebateCar = this.selectSumRebateCarDataByCarId(carId);
        RebateCarExample ex = new RebateCarExample();
        ex.createCriteria().andCarIdEqualTo(carId);
        List<RebateCar> rebateCars = rebateCarMapper.selectByExample(ex);
        rebateCars.forEach(rc ->{
            RebateProject rebateProject = rebateProjectService.selectByPrimaryKey(rc.getRebateProjectId());
            rc.setRebateProject(rebateProject);
        });
        car.setRebateCar(rebateCar);
        car.setRebateCars(rebateCars);
        return new PageInfo<>(new ArrayList(){{add(car);}});
    }
}
