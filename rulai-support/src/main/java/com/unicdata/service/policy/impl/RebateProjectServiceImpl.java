package com.unicdata.service.policy.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.util.BigDecimalUtils;
import com.unicdata.base.util.StringUtil;
import com.unicdata.conditon.RebateProjectCondition;
import com.unicdata.dao.policy.RebateProjectMapper;
import com.unicdata.entity.car.*;
import com.unicdata.entity.counter.Counter;
import com.unicdata.entity.policy.*;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.CounterService;
import com.unicdata.service.car.CarBrandService;
import com.unicdata.service.car.CarFamilyService;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.CarVehicleConfService;
import com.unicdata.service.policy.ArriveBillListService;
import com.unicdata.service.policy.ProofreaderListService;
import com.unicdata.service.policy.RebateCarService;
import com.unicdata.service.policy.RebateProjectService;
import com.unicdata.service.system.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by myMsi on 2018/5/28.
 */
@Service
public class RebateProjectServiceImpl implements RebateProjectService {

    @Autowired
    private RebateProjectMapper rebateProjectMapper;
    @Autowired
    private CarGoodInfoService carGoodInfoService;
    @Autowired
    private RebateCarService rebateCarService;
    @Autowired
    private CounterService counterService;
    @Autowired
    private ProofreaderListService proofreaderListService;
    @Autowired
    private ArriveBillListService arriveBillListService;
    @Autowired
    private CarBrandService carBrandService;
    @Autowired
    private CarFamilyService carFamilyService;
    @Autowired
    private CarVehicleConfService carVehicleConfService;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return rebateProjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RebateProject record) {
        return rebateProjectMapper.insert(record);
    }

    @Override
    public int insertSelective(RebateProject record) {
        return rebateProjectMapper.insertSelective(record);
    }

    @Override
    public List<RebateProject> selectByExample(RebateProjectExample example) {
        return rebateProjectMapper.selectByExample(example);
    }

    @Override
    public RebateProject selectByPrimaryKey(Integer id) {
        return rebateProjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RebateProject record) {
        return rebateProjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RebateProject record) {
        return rebateProjectMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<RebateProject> selectRebate(Integer policyId) {
        RebateProjectExample cpe = new RebateProjectExample();
        RebateProjectExample.Criteria criteria = cpe.createCriteria();
        criteria.andPolicyIdEqualTo(policyId);
        cpe.setOrderByClause( " id desc ");
        List<RebateProject> rebateProjects = rebateProjectMapper.selectByExample(cpe);
        for(RebateProject rp : rebateProjects){
            ProofreaderListExample pe = new ProofreaderListExample();
            pe.createCriteria().andRebateProjectIdEqualTo(rp.getId());
            pe.setOrderByClause(" create_date desc");
            List<ProofreaderList> proofreaderLists = proofreaderListService.selectByExample(pe);
            rp.setProofreaderLists(proofreaderLists);

            ArriveBillListExample ae = new ArriveBillListExample();
            ae.createCriteria().andRebateProjectIdEqualTo(rp.getId());
            ae.setOrderByClause(" create_date desc");
            List<ArriveBillList> arriveBillLists = arriveBillListService.selectByExample(ae);
            rp.setArriveBillLists(arriveBillLists);

            Integer involvedTotal = rebateProjectMapper.selectInvolvedTotal(rp.getId());
            rp.setInvolvedTotal(involvedTotal == null ? BigDecimal.ZERO : BigDecimal.valueOf(involvedTotal));//涉及台数
            Integer reachTotal = rebateProjectMapper.selectReachTotal(rp.getId(), rp.getRebateProjectType());
            rp.setReachTotal(reachTotal == null ? BigDecimal.ZERO : BigDecimal.valueOf(reachTotal));//达成台数
            Integer virtualRecordTotal = 0 ;//虚报台数
            if(rp.getRebateProjectType() != 1){
                virtualRecordTotal = rebateProjectMapper.selectVirtualRecordTotal(rp.getId());
            }
            rp.setVirtualRecordTotal(virtualRecordTotal == null ? BigDecimal.ZERO : BigDecimal.valueOf(virtualRecordTotal));//虚报台数
            //拼接返现对象描述
            findRebateProjectDesc(rp);

        }

        return rebateProjects;
    }

    @Override
    @Transactional
    public Integer saveRebate(RebateProject rp) throws ParseException {
        String code = counterService.generateCode(Counter.REBATE_PORJECT_CODE, "yyyy", 4);
        rp.setRebateCode(code);
        rp.setRebateStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(rp.getRebateStartDateStr()));
        rp.setRebateEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(rp.getRebateEndDateStr()));
        rp.setUpdateDate(new Date());
        rp.setCreateDate(new Date());
        rebateProjectMapper.insertSelective(rp);
        //返利台数上限大于0 表示有固定数量，需要选择返利车辆 小于等于0表示所有
        if(rp.getRebateNumber() != null && rp.getRebateNumber() > 0) {
            //当carIds不为空表示前端有调整返利对象需要按照调整之后的车辆进行绑定
            if (StringUtil.isNotBlank(rp.getCarIds())) {
                String[] split = rp.getCarIds().split(",");
                for (int i = 0; i < split.length; i++) {
                    if(i >= rp.getRebateNumber())
                        break;
                    String s = split[i];
                    if (StringUtil.isNotBlank(s)) {
                        CarGoodInfoWithBLOBs car = carGoodInfoService.selectByPrimaryKey(Integer.valueOf(s));
                        rebateCarService.insertRebateCar(rp, car);
                        calcCarRebateMoney(car.getId());
                    }
                }
            }
        }else{
            // 返利对象的车辆需要按照库存天数倒序进行绑定
            List<CarGoodInfo> carGoodInfos = this.selectCarInfo(rp);
            carGoodInfos.forEach(car ->{
                rebateCarService.insertRebateCar(rp, car);
                calcCarRebateMoney(car.getId());
            });
        }
        rebateProjectMapper.updateByPrimaryKeySelective(rp);
        return this.calcRebateTotalMoney(rp.getId());
    }

    public Integer calcCarRebateMoney(Integer carId){
        Map rebateCar = rebateCarService.selectCarRebate(carId);
        if(rebateCar!=null) {
            BigDecimal forecast_profit = (BigDecimal) rebateCar.getOrDefault("forecast_profit", 0);
            BigDecimal count_profit = (BigDecimal) rebateCar.get("count_profit");
            CarGoodInfoWithBLOBs carGoodInfo = new CarGoodInfoWithBLOBs();
            carGoodInfo.setId(carId);
            carGoodInfo.setForecastProfit(forecast_profit);
            carGoodInfo.setCountProfit(count_profit);
//            carGoodInfo.setPlanAllowPrice();
            return carGoodInfoService.updateByPrimaryKeySelective(carGoodInfo);
        }
        return 0;
    }

    public Integer updateRebate(RebateProject rp){
        RebateProject rebateProject = this.selectByPrimaryKey(rp.getId());
        Long s = System.currentTimeMillis();
        // 默认调整类型
        if(rp.getAdjustType() == 1){
            //返利项目包含的车辆id list
            List<Integer> carIdLists = new ArrayList<>();
            //返利项目包含的车辆对象 map
            Map<Integer ,CarGoodInfo> carMaps = new HashMap<>();
            //查询返利项目的车辆
            RebateCarExample ex = new RebateCarExample();
            ex.createCriteria().andRebateProjectIdEqualTo(rp.getId());
            List<RebateCar> rebateCars = rebateCarService.selectByExample(ex);
            for(RebateCar rc : rebateCars) {
                carIdLists.add(rc.getCarId());
            }
            CarGoodInfoExample carex = new CarGoodInfoExample();
            carex.createCriteria().andIdIn(carIdLists);
            List<CarGoodInfo> carGoodInfos = carGoodInfoService.selectByExample(carex);
            //查询车辆
            carGoodInfos.forEach(car ->carMaps.put(car.getId(),car));
            System.out.println("查询车辆 "+(System.currentTimeMillis() - s ));
            for(RebateCar rebateCar : rebateCars) {
                RebateCar rc = new RebateCar();
                rc.setId(rebateCar.getId());
//                CarGoodInfoWithBLOBs car = carGoodInfoService.selectByPrimaryKey(rebateCar.getCarId());
                CarGoodInfo car = carMaps.get(rebateCar.getCarId());
                if (rebateProject.getRebateType() == 1) {//百分比
                    //按厂商指导价*页面输入的百分比
                    BigDecimal estimateAdjust = BigDecimalUtils.mul(car.getStandardPrice(), BigDecimalUtils.div(rp.getRebateTypeValue()==null ?rebateProject.getRebateTypeValue():rp.getRebateTypeValue(), new BigDecimal(100), 4));//新返利调整后的返利预估金额
                    BigDecimal sub = BigDecimalUtils.sub(estimateAdjust,rebateCar.getFirstEstimateRebate());//算出和原来返利预估的差值，做为這次的返利调整字段值
                    rc.setEstimateAdjust(sub);//赋值给返利调整字段
                    if(car.getFullPayDate() != null) {
                        this.calcPlanExtraction(rc,rebateCar, sub);
                    }
                }else{//金额
                    BigDecimal sub = BigDecimalUtils.sub(rp.getRebateTypeValue()==null ?rebateProject.getRebateTypeValue():rp.getRebateTypeValue(),rebateCar.getFirstEstimateRebate());
                    rc.setEstimateAdjust(sub);
                    if(car.getFullPayDate() != null) {
                        this.calcPlanExtraction(rc,rebateCar, sub);
                    }
                }
                rc.setEmployeeId(rp.getEmployeeId());
                rc.setUpdateDate(new Date());
                System.out.println("计算 "+(System.currentTimeMillis() - s ));
                rebateCarService.updateByPrimaryKeySelective(rc);
                calcCarRebateMoney(car.getId());
                System.out.println("结束 "+(System.currentTimeMillis() - s ));
            }

        }else{
            //具体库存
            JSONArray list = JSON.parseArray(rp.getCarMap());
            for(int i = 0 ; i < list.size() ; i++) {
                Map map = (Map) list.get(i);
                Integer carId = Integer.valueOf(map.get("carId")+"");
                BigDecimal adjust = new BigDecimal(map.get("adjust")+"");
                Integer type = Integer.valueOf( map.get("type")+"");
                CarGoodInfoWithBLOBs car = carGoodInfoService.selectByPrimaryKey(carId);
                if(type.equals(0)){ //调整预估金额
                    RebateCarExample ex = new RebateCarExample();
                    ex.createCriteria().andRebateProjectIdEqualTo(rp.getId()).andCarIdEqualTo(carId);
                    List<RebateCar> rebateCar = rebateCarService.selectByExample(ex);
                    RebateCar rc = rebateCar.get(0);
                    //再按页面调整的金额进行修改
                    this.calcRebateCarData(rp, adjust, car, rc);
                }else if(type.equals(1)) {//新增库存
                    //先按原来的返利项目新增返利车辆数据

                    RebateCar rc = rebateCarService.insertRebateCar(rebateProject, car);
                    //再按页面调整的金额进行修改
                    this.calcRebateCarData(rp, adjust, car, rc);
                }else if(type.equals(2)){//删除
                    //直接删除该车辆再该返利项目中的数据
                    rebateCarService.deleteByKeyAndRebate(carId ,rp.getId());
                }
                calcCarRebateMoney(carId);
            }
        }
        rp.setStatus(1);
        //修改返利项目数据
        rebateProjectMapper.updateByPrimaryKeySelective(rp);
        //最后计算返利项目各个总计金额
        return this.calcRebateTotalMoney(rp.getId());

    }
    /**
     * 计算单台车辆的某个返利项目的金额
     */
    private void calcRebateCarData(RebateProject rp, BigDecimal adjust, CarGoodInfoWithBLOBs car, RebateCar rc) {
        rc.setEstimateAdjust(adjust);
        BigDecimal sub = BigDecimalUtils.add(rc.getFirstEstimateRebate(), adjust);
        if(car.getFullPayDate() != null) {
            if (rc.getIsPlanExtraction() == 0) { //财务没有提交计提审核，计提字段跟着返利预估一起修改
                rc.setPlanExtraction(sub);
            } else {
                BigDecimal planExtractionAdjust = BigDecimalUtils.sub(BigDecimalUtils.add(rc.getFirstEstimateRebate(), sub), rc.getPlanExtraction());
                rc.setPlanExtractionAdjust(planExtractionAdjust);
            }
        }
        rc.setEmployeeId(rp.getEmployeeId());
        rc.setUpdateDate(new Date());
        rebateCarService.updateByPrimaryKeySelective(rc);
    }

    /**
     * 按照是否财务已审核状态字段来计算计提和计提调整金额
     * @param rc
     * @param sub
     */
    private void calcPlanExtraction(RebateCar rc,RebateCar rebateCar, BigDecimal sub) {
        if(rebateCar.getIsPlanExtraction() == 0) {
            //财务没有提交计提审核，计提字段跟着返利预估一起修改
            rc.setPlanExtraction(BigDecimalUtils.add(rebateCar.getFirstEstimateRebate(),sub));
            rc.setPlanExtractionAdjust(BigDecimal.ZERO);
        }else{
            //财务已经提交计提审核，计提字段不动，但是需要修改计提调整字段，
            BigDecimal decimal = BigDecimalUtils.sub(BigDecimalUtils.add(rebateCar.getFirstEstimateRebate(), sub),rebateCar.getPlanExtraction());
            rc.setPlanExtractionAdjust(decimal);
        }
    }

    /**
     * 计算返利项目各个需要求和的值
     * @param rebateId
     * @return
     */
    public int calcRebateTotalMoney(Integer rebateId){
        BigDecimal firstEstimateTotal = BigDecimal.ZERO;
        BigDecimal estimateAdjustTotal = BigDecimal.ZERO;
        BigDecimal planExtractionTotal = BigDecimal.ZERO;
        BigDecimal planExtractionAdjustTotal = BigDecimal.ZERO;
        RebateCarExample ex = new RebateCarExample();
        ex.createCriteria().andRebateProjectIdEqualTo(rebateId);
        List<RebateCar> rebateCars = rebateCarService.selectByExample(ex);
        for(RebateCar rc : rebateCars) {
            firstEstimateTotal = firstEstimateTotal.add(rc.getFirstEstimateRebate());
            estimateAdjustTotal = estimateAdjustTotal.add(rc.getEstimateAdjust());
            planExtractionTotal = planExtractionTotal.add(rc.getPlanExtraction());
            planExtractionAdjustTotal = planExtractionAdjustTotal.add(rc.getPlanExtractionAdjust());
        }
        RebateProject rp = new RebateProject();
        rp.setId(rebateId);
        rp.setFirstEstimateTotal(firstEstimateTotal);
        rp.setEstimateAdjustTotal(estimateAdjustTotal);
        //新增返利项目时 计提总额=首次预估返利总额
        rp.setPlanExtractionTotal(planExtractionTotal);
        rp.setPlanExtractionAdjustTotal(planExtractionAdjustTotal);

        rp.setInvolvedTotal(BigDecimal.ZERO);//涉及台数
        rp.setReachTotal(BigDecimal.ZERO);//达成台数
        rp.setVirtualRecordTotal(BigDecimal.ZERO);//虚报台数

        int x = rebateProjectMapper.updateByPrimaryKeySelective(rp);
        rebateProjectMapper.insertHistoryById(rebateId);//修改前记录历史记录
        return x;
    }

    @Override
    public RebateProject selectRebateById(Integer id) {
        RebateProject rebateProject = this.selectByPrimaryKey(id);
        findRebateProjectDesc(rebateProject);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        rebateProject.setRebateStartDateStr(dateFormat.format(rebateProject.getRebateStartDate()));
        rebateProject.setRebateEndDateStr(dateFormat.format(rebateProject.getRebateEndDate()));
        List<CarGoodInfo> cars = this.selectCarInfo(rebateProject);
        rebateProject.setCarGoodInfos(cars);
        return rebateProject;
    }

    /**
     * 根据返利项目选择的条件 按倒序查询库存车辆
     * @param rp
     * @return
     */
    @Override
    public List<CarGoodInfo> selectCarInfo(RebateProject rp){
        CarGoodInfoExample ex = new CarGoodInfoExample();
        CarGoodInfoExample.Criteria criteria = ex.createCriteria();
        criteria.andDistributorStoreIdEqualTo(rp.getStoreId());
        if (rp.getRebateProjectType() != null && rp.getRebateProjectType() == 1) { //批售
            criteria.andFirstDmsDateBetweenOrIsNull(rp.getRebateStartDateStr(), rp.getRebateEndDateStr()).andBatchRebateEqualTo(1);
        } else if (rp.getRebateProjectType() != null && rp.getRebateProjectType() == 2) { //零售
            criteria.andCreateDateBetween(rp.getRebateStartDateStr(), rp.getRebateEndDateStr()).andRetailRebateEqualTo(1);
        }
        if (rp.getBrandId() != null && rp.getBrandId() > 0) {
            criteria.andBrandIdEqualTo(rp.getBrandId());
        }
        if (rp.getFamilyId() != null && rp.getFamilyId() > 0) {
            criteria.andFamilyIdEqualTo(rp.getFamilyId());
        }
        if (rp.getVehicleId() != null && rp.getVehicleId() > 0) {
            criteria.andVehicleIdEqualTo(rp.getVehicleId());
        }
        if (StringUtil.isNotBlank(rp.getYear())) {
            criteria.andYearEqualTo(rp.getYear());
        }
        if (rp.getDecorationsOutId()!=null && rp.getDecorationsOutId() > 0) {
            criteria.andDecorationsOutIdEqualTo(rp.getDecorationsOutId());
        }
        ex.setOrderByClause(" in_storage_date asc ");
        List<CarGoodInfo> carGoodInfos = carGoodInfoService.selectByExample(ex);
        if(rp.getId() != null && rp.getId() > 0) {
            for (CarGoodInfo car : carGoodInfos) {
                RebateCarExample ex1 = new RebateCarExample();
                ex1.createCriteria().andRebateProjectIdEqualTo(rp.getId()).andCarIdEqualTo(car.getId());
                List<RebateCar> rebateCars1 = rebateCarService.selectByExample(ex1);
                if (rebateCars1 != null && rebateCars1.size() > 0) {
                    car.setRebateCar(rebateCars1.get(0));
                }
            }
        }
        return carGoodInfos;
    }

    @Override
    public PageInfo<List<CarGoodInfo>> selectCarInfoPage(RebateProject rp ,Integer pageNum, Integer pageSize) {
        pageNum = (null == pageNum || pageNum < 1 ? 1 : pageNum);
        pageSize = null == pageSize || pageSize.intValue() > 100 ? Integer.MAX_VALUE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<CarGoodInfo> carGoodInfos = this.selectCarInfo(rp);
        return new PageInfo(carGoodInfos);
    }

    @Override
    public int executeCarPlanExtraction(Integer carId) {
        CarGoodInfoWithBLOBs car = carGoodInfoService.selectByPrimaryKey(carId);
//        if(car != null && (car.getFirstDmsDate()!= null || car.getFullPayDate() != null)) {
        //全款是才计算计提 （上报DMS不计算）
        if(car != null && car.getFullPayDate() != null) {
            RebateCarExample ex1 = new RebateCarExample();
            ex1.createCriteria().andCarIdEqualTo(carId);
            List<RebateCar> rebateCars = rebateCarService.selectByExample(ex1);
            for(RebateCar rc : rebateCars){
                BigDecimal sub = rc.getFirstEstimateRebate().add(rc.getEstimateAdjust());
                if (rc.getIsPlanExtraction() == 0) { //财务没有提交计提审核，计提字段跟着返利预估一起修改
                    rc.setPlanExtraction(sub);
                    rc.setPlanExtractionAdjust(BigDecimal.ZERO);
                } else {
                    BigDecimal planExtractionAdjust = BigDecimalUtils.sub(BigDecimalUtils.add(rc.getFirstEstimateRebate(), sub), rc.getPlanExtraction());
                    rc.setPlanExtractionAdjust(planExtractionAdjust);
                }
                rc.setUpdateDate(new Date());
                rebateCarService.updateByPrimaryKeySelective(rc);
                this.calcRebateTotalMoney(rc.getRebateProjectId());
            }
            calcCarRebateMoney(car.getId());
            return 1;
        }
        return 0;
    }

    /**
     * 采购单入库时 计算车辆适合的返利项目并加入到返利项目中
     * @param carId
     * @return
     */
    @Override
    public void inStorageCarRebateProject(Integer carId) {
        CarGoodInfoWithBLOBs car = carGoodInfoService.selectByPrimaryKey(carId);
        RebateProjectExample ex = new RebateProjectExample();
        //返利项目开始时间早于车辆入库时间，结束时间晚于车辆入库时间，状态为暂存和有效，门店为车辆所在门店
        ex.createCriteria().andRebateStartDateLessThanOrEqualTo(car.getCreateDate()).andRebateEndDateGreaterThanOrEqualTo(car.getCreateDate()).andStatusNotEqualTo(2).andStoreIdEqualTo(car.getDistributorStoreId());
        List<RebateProject> rebateProjects = rebateProjectMapper.selectByExample(ex);
        for(RebateProject rp : rebateProjects){
            if(StringUtil.isBlank(rp.getDecorationsOutName()) || rp.getDecorationsOutName().equals(car.getDecorationsOutName()) ){
                if(StringUtil.isBlank(rp.getYear()) || rp.getYear().equals(car.getYear())){
                    if(rp.getVehicleId() == null || rp.getVehicleId() == 0 || rp.getVehicleId().equals(car.getVehicleId())){
                        if(rp.getFamilyId() == null || rp.getFamilyId() == 0 || rp.getFamilyId().equals(car.getFamilyId())){
                            if(rp.getBrandId() == null || rp.getBrandId() == 0 || rp.getBrandId().equals(car.getBrandId())){
                                if(rp.getRebateProjectType() == 1 && car.getBatchRebate() == 1){ //1批售返利
                                    rebateCarService.insertRebateCar(rp, car);
                                    calcCarRebateMoney(car.getId());
                                }else if(rp.getRebateProjectType() == 2 && car.getRetailRebate() == 1){ //2零售返利
                                    // 返利台数大于当前返利项目已有的车辆
                                    RebateCarExample rce = new RebateCarExample();
                                    rce.createCriteria().andRebateProjectIdEqualTo(1);
                                    List<RebateCar> rebateCars = rebateCarService.selectByExample(rce);
                                    if(rebateCars.size() < rp.getRebateNumber()){
                                        rebateCarService.insertRebateCar(rp, car);
                                        calcCarRebateMoney(car.getId());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public RebateProjectCondition selectDetail(Integer rebateId) {
        RebateProjectCondition rpc = new RebateProjectCondition();

        ProofreaderListExample proex = new ProofreaderListExample();
        proex.createCriteria().andRebateProjectIdEqualTo(rebateId);
        proex.setOrderByClause(" create_date desc ");
        List<ProofreaderList> proofreaderLists = proofreaderListService.selectByExample(proex);
        proofreaderLists.forEach(p ->{
            Employee employee = employeeService.selectByPrimaryKey(p.getEmployeeId());
            p.setEmployeeName(employee!=null ?employee.getFullName():"");
        });

        ArriveBillListExample abex = new ArriveBillListExample();
        abex.createCriteria().andRebateProjectIdEqualTo(rebateId);
        abex.setOrderByClause(" create_date desc");
        List<ArriveBillList> arriveBillLists = arriveBillListService.selectByExample(abex);
        arriveBillLists.forEach(p ->{
            Employee employee = employeeService.selectByPrimaryKey(p.getEmployeeId());
            p.setEmployeeName(employee!=null ?employee.getFullName():"");
        });

        List<RebateProject> rebateProject = rebateProjectMapper.selectHistoryById(rebateId);
        rebateProject.forEach(p ->{
            Employee employee = employeeService.selectByPrimaryKey(p.getEmployeeId());
            p.setEmployeeName(employee!=null ?employee.getFullName():"");
            findRebateProjectDesc(p);
        });

        rpc.setProofreaderLists(proofreaderLists);
        rpc.setArriveBillLists(arriveBillLists);
        rpc.setRebateProject(rebateProject);
        return rpc;
    }

    /**
     * 拼接返现对象描述
     * @param p
     */
    private void findRebateProjectDesc(RebateProject p) {
        if(p != null) {
            p.setRebateProjectDesc("所有");
            if (p.getBrandId() != null && p.getBrandId() > 0) {
                CarBrand carBrand = carBrandService.selectByPrimaryKey(p.getBrandId());
                if (carBrand != null) {
                    p.setRebateProjectDesc(carBrand.getName());
                }
            }
            if (p.getFamilyId() != null && p.getFamilyId() > 0) {
                CarFamily carFamily = carFamilyService.selectByPrimaryKey(p.getFamilyId());
                if (carFamily != null) {
                    p.setRebateProjectDesc(p.getRebateProjectDesc() + " " + carFamily.getName());
                }
            }
            if (p.getVehicleId() != null && p.getVehicleId() > 0) {
                CarVehicleConf carVehicleConf = carVehicleConfService.selectByPrimaryKey(p.getFamilyId());
                if (carVehicleConf != null) {
                    p.setRebateProjectDesc(p.getRebateProjectDesc() + " " + carVehicleConf.getName());
                }
            }
            if (p.getYear() != null && !"".equals(p.getYear())) {
                p.setRebateProjectDesc(p.getRebateProjectDesc() + " " + p.getYear() + " 款");
            }
        }
    }

}
