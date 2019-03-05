package com.unicdata.service.policy.impl;

import com.unicdata.dao.policy.ProofreaderListMapper;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.policy.*;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.CarOptionalPackageService;
import com.unicdata.service.policy.ListExceptionService;
import com.unicdata.service.policy.ProofreaderListService;
import com.unicdata.service.policy.RebateCarService;
import com.unicdata.util.ExcelTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by myMsi on 2018/5/28.
 */
@Service
public class ProofreaderListServiceImpl implements ProofreaderListService {

    @Autowired
    private ProofreaderListMapper proofreaderListMapper;
    @Autowired
    private RebateCarService rebateCarService;
    @Autowired
    private ListExceptionService listExceptionService;
    @Autowired
    private CarGoodInfoService carGoodInfoService;
    @Autowired
    private CarOptionalPackageService carOptionalPackageService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return proofreaderListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProofreaderList record) {
        return proofreaderListMapper.insert(record);
    }

    @Override
    public int insertSelective(ProofreaderList record) {
        return proofreaderListMapper.insertSelective(record);
    }

    @Override
    public List<ProofreaderList> selectByExample(ProofreaderListExample example) {
        return proofreaderListMapper.selectByExample(example);
    }

    @Override
    public ProofreaderList selectByPrimaryKey(Integer id) {
        return proofreaderListMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProofreaderList record) {
        return proofreaderListMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProofreaderList record) {
        return proofreaderListMapper.updateByPrimaryKey(record);
    }

    @Override
    public Map importProofreader(Employee employee, MultipartFile mfile, Integer rebateId){
        Map resultMap = new HashMap<>();
        List<Map<String, String>> failureCarList = new ArrayList<>();
//        List<CarGoodInfo> successCarList = new ArrayList<>();
        BigDecimal failureMoneyTotal = BigDecimal.ZERO, totalMoney = BigDecimal.ZERO, totalDifference = BigDecimal.ZERO;
        //查询传入返利项目对应的所有车辆信息
        Map<String, RebateCar> rebateCarMap = new HashMap<>();
        RebateCarExample ex = new RebateCarExample();
        ex.createCriteria().andRebateProjectIdEqualTo(rebateId);
        List<RebateCar> rebateCars = rebateCarService.selectByExample(ex);
        for (RebateCar rc : rebateCars) {
            totalDifference = totalDifference.add(rc.getPlanExtraction());
            rebateCarMap.put(rc.getVin(), rc);
        }
        //新增核对单数据
        ProofreaderList pl = new ProofreaderList();
        pl.setRebateProjectId(rebateId);
        pl.setEmployeeId(employee.getId());
        pl.setCreateDate(new Date());
        this.insertSelective(pl);
        //将导入文件转换成 list
        List<Map<String, String>> importMapList = ExcelTemplateUtil.readExcelValue(mfile);
        for (Map<String, String> map : importMapList) {
            String vin = map.get("vin");
            RebateCar rebateCar = rebateCarMap.get(vin);
            BigDecimal money = new BigDecimal(map.get("money"));
            totalMoney = totalMoney.add(money);
            if (rebateCar == null) {
                ListException le = new ListException();
                le.setRebateProjectId(rebateId);
                le.setListId(pl.getId());
                le.setListType(2);
                le.setVin(map.get("vin"));
                le.setMoney(money);
                le.setCreateDate(new Date());
                listExceptionService.insertSelective(le);
                failureCarList.add(map);
//                failureMoneyTotal = failureMoneyTotal.add(money);
            } else {
                rebateCar.setProofreaderId(pl.getId());
                rebateCar.setProofreaderMoney(money);
                rebateCar.setProofreaderDate(new Date());
                rebateCar.setEmployeeId(employee.getId());
                rebateCar.setUpdateDate(new Date());
                rebateCarService.updateByPrimaryKeySelective(rebateCar);
//                CarGoodInfoWithBLOBs car = carGoodInfoService.selectByVin(vin);
//                if(car != null) {
//                    car.setRebateCar(rebateCar);
//                    successCarList.add(car);
//                }
            }
        }
        pl.setTotalDifference(totalMoney.subtract(totalDifference));
        pl.setTotalMoney(totalMoney);
        pl.setUnmatchedMoney(failureMoneyTotal);
        pl.setUnmatchedNum(failureCarList.size());
        this.updateByPrimaryKeySelective(pl);
//        resultMap.put("successCarList", successCarList);
//        resultMap.put("failureCarList", failureCarList);
//        resultMap.put("failureMoneyTotal", failureMoneyTotal);
        return resultMap;
    }

    public Map selectImportProofreader(MultipartFile mfile, Integer rebateId){
        Map resultMap = new HashMap<>();
        List<Map<String, String>> failureCarList = new ArrayList<>();
        List<CarGoodInfo> successCarList = new ArrayList<>();
        BigDecimal failureMoneyTotal = BigDecimal.ZERO, totalMoney = BigDecimal.ZERO, totalDifference = BigDecimal.ZERO;
        //查询传入返利项目对应的所有车辆信息
        Map<String, RebateCar> rebateCarMap = new HashMap<>();
        RebateCarExample ex = new RebateCarExample();
        ex.createCriteria().andRebateProjectIdEqualTo(rebateId);
        List<RebateCar> rebateCars = rebateCarService.selectByExample(ex);
        for (RebateCar rc : rebateCars) {
            totalDifference = totalDifference.add(rc.getPlanExtraction());
            rebateCarMap.put(rc.getVin(), rc);
        }
        //将导入文件转换成 list
        List<Map<String, String>> importMapList = ExcelTemplateUtil.readExcelValue(mfile);
        for (Map<String, String> map : importMapList) {
            String vin = map.get("vin");
            RebateCar rebateCar = rebateCarMap.get(vin);
            BigDecimal money = new BigDecimal(map.get("money"));
            if (rebateCar == null) {
                failureCarList.add(map);
                failureMoneyTotal = failureMoneyTotal.add(money);
            } else {
                rebateCar.setProofreaderMoney(money);
                rebateCar.setDiffMoney(money.subtract(rebateCar.getPlanExtraction() != null ? rebateCar.getPlanExtraction() : BigDecimal.ZERO));
                CarGoodInfoWithBLOBs car = carGoodInfoService.selectByVin(vin);
                if(car != null) {
                    BigDecimal optionalPackageMoney = carOptionalPackageService.selectSumByVin(car.getVin());
                    car.setOptionalPackageMoney(optionalPackageMoney);
                    car.setRebateCar(rebateCar);
                    successCarList.add(car);
                }
            }
        }
        resultMap.put("successCarList", successCarList);
        resultMap.put("failureCarList", failureCarList);
        resultMap.put("failureMoneyTotal", failureMoneyTotal);
        return resultMap;
    }
}
