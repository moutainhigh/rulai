package com.unicdata.controller.boutique;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.unicdata.service.order.ReceiptService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.condition.BoutiqueAnalysisCondition;
import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.constant.BoutiqueEnum.BoutiqueSource;
import com.unicdata.constant.BoutiqueEnum.BoutiqueType;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.dao.boutique.BoutiquePackageMapper;
import com.unicdata.dao.customer.CustomerMapper;
import com.unicdata.dao.system.EmployeeMapper;
import com.unicdata.entity.boutique.*;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiquePackage;
import com.unicdata.entity.boutique.BoutiquePackageInclude;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.BoutiqueRetailInclude;
import com.unicdata.entity.boutique.BoutiqueRetailIncludePackDivision;
import com.unicdata.entity.boutique.BoutiqueRetailRecord;
import com.unicdata.entity.boutique.BoutiqueTarget;
import com.unicdata.entity.boutique.BoutiqueTargetGroup;
import com.unicdata.entity.boutique.CarWash;
import com.unicdata.entity.boutique.CarWashExample;
import com.unicdata.entity.boutique.home.ApprovalProcess;
import com.unicdata.entity.boutique.home.HomeAllMonthData;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.CarWashService;
import com.unicdata.service.boutique.InformationSupportService;
import com.unicdata.service.boutique.InstallSupportService;
import com.unicdata.service.boutique.PackageIncludeSupportService;
import com.unicdata.service.boutique.PackageSupportService;
import com.unicdata.service.boutique.RetailCustomerSupportService;
import com.unicdata.service.boutique.RetailIncludePackDivisionSupportService;
import com.unicdata.service.boutique.RetailRecordSupportService;
import com.unicdata.service.boutique.RetailSupportService;
import com.unicdata.service.boutique.TargetGroupSupportService;
import com.unicdata.service.boutique.TargetSupportService;
import com.unicdata.service.boutique.home.HomeDeliverCarService;
import com.unicdata.service.employee.EmployeeTargetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/rulai/boutiqueHome")
@Api(value = "精品经理首页、精品加装分析", tags = {"精品经理首页、精品加装分析相关接口"})
public class BoutiqueHomeController extends HomeBaseController {

    @Autowired
    private RetailSupportService retailSupportService;

    @Autowired
    private RetailRecordSupportService retailRecordSupportService;

    @Autowired
    private TargetSupportService targetSupportService;

    @Autowired
    private EmployeeTargetService employeeTargetService;

    @Autowired
    private HomeDeliverCarService deliverCarService;

    @Autowired
    private InformationSupportService informationSupportService;

    @Autowired
    private InstallSupportService installSupportService;

    @Autowired
    private CarWashService carWashService;

    @Autowired
    private PackageSupportService packageSupportService;
    
    @Autowired
    private PackageIncludeSupportService packageIncludeSupportService;

    @Autowired
    private RetailIncludePackDivisionSupportService divisionSupportService;

    @Autowired
    private TargetGroupSupportService targetGroupSupportService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RetailCustomerSupportService retailCustomerSupportService;


    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ReceiptService receiptService;

    
    /**
     * 精品经理首页-本月收入、毛利、交车、台次
     */
    @ApiOperation(value = "精品经理首页-本月收入、毛利、交车、台次", notes = "")
    @ResponseBody
    @RequestMapping(value = "/getAllMonthData", method = {RequestMethod.POST})
    public ApiReturnInfo<HomeAllMonthData> getAllMonthData(HttpServletRequest request) {
        ApiReturnInfo<HomeAllMonthData> result = new ApiReturnInfo<HomeAllMonthData>();
        HomeAllMonthData homeData = new HomeAllMonthData();
        // 当前用户
        Employee emp = getMember(request);

        Date saleDate = new Date(); // 统计日期
        Integer storeId = emp.getStoreId();// 门店id

        List<Map<String, Object>> boutiqueRetailByStoreId = retailSupportService
                .getMouthBoutiqueRetailByStoreId(saleDate, storeId, BoutiqueType.FINISHED, null);
        BigDecimal incomeSum = new BigDecimal("0");
        for (Map<String, Object> retail : boutiqueRetailByStoreId) {
            if (retail.get("apply_count") != null) {
                String string = retail.get("apply_count").toString();
                BigDecimal sumMargin = new BigDecimal(string).setScale(2);
                incomeSum = incomeSum.add(sumMargin).setScale(2);
            }
        }
        homeData.setIncomeSum(incomeSum.setScale(2).toString());// 本月收入达成

        List<BoutiqueTarget> targets = targetSupportService.getBoutiqueTargetByStoreId(saleDate, storeId, null);
        // 计划毛利
        BigDecimal profitPlay = new BigDecimal("0");
        // 计划收入
        BigDecimal incomePlay = new BigDecimal("0");
        for (BoutiqueTarget target : targets) {
            BigDecimal profitPlay1 = target.getProfitPlay();
            BigDecimal incomePlay1 = target.getIncomePlay();
            profitPlay = profitPlay.add(profitPlay1);
            incomePlay = incomePlay.add(incomePlay1);
        }
        // 本月收入进度
        BigDecimal s = new BigDecimal("100");
        if (!incomePlay.equals(BigDecimal.ZERO)) {
            String incomeProcess = incomeSum.divide(incomePlay, 4, BigDecimal.ROUND_HALF_DOWN).multiply(s).setScale(2)
                    + "%";
            homeData.setIncomeProcess(incomeProcess);// 本月收入进度
        }

        // 本月毛利成本
        // 本月单品成本
        Double sumByisPackage1 = retailSupportService.getMouthCostSumByisPackage(saleDate, storeId, 0,
                BoutiqueType.FINISHED);
        BigDecimal sumByisPackage2 = new BigDecimal(sumByisPackage1 + "");
        // 本月礼包成本
        Double sumByisPackage3 = retailSupportService.getMouthCostSumByisPackage(saleDate, storeId, 1,
                BoutiqueType.FINISHED);
        BigDecimal sumByisPackage4 = new BigDecimal(sumByisPackage3 + "");

        BigDecimal marginSum = incomeSum.subtract(sumByisPackage2).subtract(sumByisPackage4).setScale(2);
        homeData.setMarginSum(marginSum.toString());// 本月毛利达成 = 本月单品成本 + 本月礼包成本

        if (marginSum.compareTo(BigDecimal.ZERO) == 1 && !profitPlay.equals(BigDecimal.ZERO)) {
            BigDecimal multiply = marginSum.divide(profitPlay, 4, BigDecimal.ROUND_HALF_DOWN);
            String marginSumProcess = multiply.multiply(s).setScale(2) + "%";
            homeData.setMarginSumProcess(marginSumProcess);// 本月毛利进度 = 本月毛利达成 /
            // 计划收入·
        }

        // 计划单产=销售部精品销售月计划金额/月计划交车总数
        Map<String, Object> targetMap = new HashMap<>();
        targetMap.put("targetTime", saleDate);
        targetMap.put("storeId", storeId);

        // 本月交车目标总数
        Map<String, Object> stringObjectMap = employeeTargetService.getMothTargetNumByStoreId(targetMap);
        // 交车交车目标计划单产
        if (stringObjectMap.get("deliverSum") != null) {
            BigDecimal delivers = new BigDecimal(stringObjectMap.get("deliverSum").toString());
            List<BoutiqueTarget> byStoreId = targetSupportService.getBoutiqueTargetByStoreId(saleDate, storeId,
                    BoutiqueSource.SELL);// 销售部精品销售月计划金额
            if (byStoreId.size() > 0) {
                if (byStoreId.get(0) != null && !delivers.equals(BigDecimal.ZERO)) {
                    BigDecimal intValue = byStoreId.get(0).getIncomePlay();
                    if(intValue != null){
                    	homeData.setDeliverSum(intValue.divide(delivers, 2) + "");
                    }
                }
            }
        }

        if (StringUtils.isBlank(homeData.getDeliverSum())) {
            homeData.setDeliverSum("0.00");
        }

        // 实际单产=销售部实际精品收入合计/实际交车数量
        // 当前门店、本月实际交车数
        int numByStoreId = deliverCarService.getMothDeliverCarNumByStoreId(saleDate, storeId);

        // 当前门店、本月、销售部实际精品收入
        List<Map<String, Object>> boutiqueRetails = retailSupportService.getMouthBoutiqueRetailByStoreId(saleDate,
                storeId, BoutiqueType.FINISHED, BoutiqueSource.SELL);
        if (boutiqueRetails.size() > 0 && numByStoreId != 0) {
            Map<String, Object> objectMap2 = boutiqueRetails.get(0);
            Object apply_count = objectMap2.get("apply_count");
            BigDecimal num = new BigDecimal(numByStoreId);
            if (apply_count != null && !num.equals(BigDecimal.ZERO)) {
                BigDecimal bigDecimal = new BigDecimal(apply_count.toString());
                homeData.setActualSum(bigDecimal.divide(num, 2, BigDecimal.ROUND_HALF_EVEN) + "");
            }
        }

        String actualSum = homeData.getActualSum();
        if (StringUtils.isBlank(actualSum)) {
            homeData.setActualSum("0.00");
        }

        // 本月台次

        result.setData(homeData);
        return result;
    }

    @ApiOperation(value = "精品经理首页 - 精品提醒 - ", notes = "")
    @ResponseBody
    @RequestMapping(value = "/getReminderNumber", method = {RequestMethod.POST})
    public ApiReturnInfo<Map<String, Integer>> getReminderNumber(HttpServletRequest request) {
        ApiReturnInfo<Map<String, Integer>> result = new ApiReturnInfo<Map<String, Integer>>();

        Map<String, Integer> resultMap = new HashMap<>();

        // 当前用户
        Employee emp = getMember(request);
        Integer storeId = emp.getStoreId();

        Map<String, Object> retail = new HashMap<String, Object>();
        retail.put("storeId", emp.getStoreId());
        // 精品状态1,待审批
        retail.put("type", BoutiqueType.APPROVAL_WAIT.getCode());
        retail.put("saleDate", new Date());
        List<Map<String, Object>> boutiqueRetail = retailSupportService.getMouthBoutiqueRetailByStoreId(retail);
        resultMap.put("approvalReminderNum", boutiqueRetail.size()); // 审批处理提醒数值

        Map<String, Object> questMap = new HashMap<>();
        questMap.put("storeId", storeId);
        questMap.put("bl", 0);
        // 不安全库存 : 库存数 <= 安全库存数
        List<Map<String, Object>> list = informationSupportService.selectBoutiqueStockByStoreId(questMap);
        resultMap.put("insecureStockNum", list.size()); // 安全库存提醒数值

        Map<String, Object> questMap2 = new HashMap<>();
        questMap2.put("storeId", storeId);
        questMap2.put("stayDate", new Date());
        // 警戒天数 <= 在库天数
        List<Map<String, Object>> list2 = informationSupportService.selectBoutiqueStockByStoreId(questMap2);
        resultMap.put("insecureStayNum", list2.size()); // 在库天数 提醒数值

        resultMap.put("boutiqueBeminderNum", list.size() + list2.size()); // 精品处理提醒数值

        result.setData(resultMap);
        return result;
    }

    /**
     * 精品经理首页-安全库存
     */
    @ApiOperation(value = "精品经理首页 - 精品提醒 - 安全库存分页", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "Number"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Number")})
    @ResponseBody
    @RequestMapping(value = "/getSafetyStockPage", method = {RequestMethod.POST})
    public ApiReturnInfo<PageInfo<Map<String, Object>>> getSafetyStockPage(HttpServletRequest request, Integer pageSize,
                                                                           Integer pageNum) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();

        // 当前用户
        Employee emp = getMember(request);
        Integer storeId = emp.getStoreId();

        Map<String, Object> questMap = new HashMap<>();
        questMap.put("storeId", storeId);
        questMap.put("bl", 0);

        // 不安全库存 : 库存数 <= 安全库存数
        PageInfo<Map<String, Object>> page = informationSupportService.selectBoutiqueStockByStoreIdPage(questMap,
                pageSize, pageNum);

        result.setData(page);
        return result;
    }

    /**
     * 精品经理首页 - 精品提醒 - 在库天数
     */
    @ApiOperation(value = "精品经理首页 - 精品提醒 - 在库天数分页", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "Number"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Number")})
    @ResponseBody
    @RequestMapping(value = "/getStayDatesPage", method = {RequestMethod.POST})
    public ApiReturnInfo<PageInfo<Map<String, Object>>> getStayDatesPage(HttpServletRequest request, Integer pageSize,
                                                                         Integer pageNum) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
        // 当前用户
        Employee emp = getMember(request);
        Integer storeId = emp.getStoreId();
        Map<String, Object> questMap = new HashMap<>();
        questMap.put("storeId", storeId);
        questMap.put("stayDate", new Date());
        // 警戒天数 < 在库天数
        PageInfo<Map<String, Object>> page = informationSupportService.selectBoutiqueStockByStoreIdPage(questMap,
                pageSize, pageNum);

        result.setData(page);
        return result;
    }

    /**
     * 精品经理首页 - 审批处理分页条件查询
     */
    @ApiOperation(value = "精品经理首页 - 审批历史分页条件查询", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "startTime", value = "审批开始时间", required = false, dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "审批结束时间", required = false, dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "Number"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Number")})
    @ResponseBody
    @RequestMapping(value = "/getApprovalProcessPage", method = {RequestMethod.POST})
    public ApiReturnInfo<PageInfo<Map<String, Object>>> getApprovalProcessPage(HttpServletRequest request,
                                                                               String startTime, String endTime, Integer pageSize, Integer pageNum) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();

        Employee emp = getMember(request);

        Map<String, Object> retail = new HashMap<String, Object>();
        retail.put("storeId", emp.getStoreId());
        retail.put("startTime", startTime);
        retail.put("endTime", endTime);
        PageInfo<Map<String, Object>> page = retailRecordSupportService.getBoutiqueRetailRecordByStoreIdPage(retail,
                pageSize, pageNum);
        result.setData(page);
        return result;
    }

    /**
     * 精品经理首页 - 审批处理列表
     */
    @ApiOperation(value = "精品经理首页 - 审批处理列表", notes = "")
    @ResponseBody
    @RequestMapping(value = "/getApprovalProcessList", method = {RequestMethod.POST})
    public ApiReturnInfo<List<ApprovalProcess>> getApprovalProcessList(HttpServletRequest request, String code,
                                                                       String name) {
        ApiReturnInfo<List<ApprovalProcess>> result = new ApiReturnInfo<List<ApprovalProcess>>();

        Employee emp = getMember(request);

        Map<String, Object> retail = new HashMap<String, Object>();
        retail.put("storeId", emp.getStoreId());
        // 精品状态1,待审批
        retail.put("type", BoutiqueType.APPROVAL_WAIT.getCode());
        retail.put("saleDate", new Date());
        retail.put("code", code);
        retail.put("name", name);
        List<Map<String, Object>> boutiqueRetail = retailSupportService.getMouthBoutiqueRetailByStoreId(retail);

        List<ApprovalProcess> list = new ArrayList<>();
        for (Map<String, Object> map : boutiqueRetail) {
            ApprovalProcess approvalProcess = new ApprovalProcess();

            approvalProcess.setId(map.get("id") == null ? 0 : Integer.parseInt(map.get("id").toString()));
            approvalProcess.setCode(map.get("code") == null ? "" : map.get("code") + "");

            Integer source = map.get("id") == null ? 0 : Integer.parseInt(map.get("source").toString());
            approvalProcess.setSource(source);
            String sourceStr = BoutiqueSource.getReason(source) == null ? "" : BoutiqueSource.getReason(source);
            approvalProcess.setSourceStr(sourceStr + "单");

            BigDecimal sale_count = map.get("sale_count") == null ? new BigDecimal("0")
                    : new BigDecimal(map.get("sale_count").toString());
            BigDecimal apply_count = map.get("apply_count") == null ? new BigDecimal("0")
                    : new BigDecimal(map.get("apply_count").toString());
            approvalProcess.setSale_count(sale_count);
            approvalProcess.setApply_count(apply_count);
            
            if(sale_count.compareTo(BigDecimal.ZERO) > 0){
                approvalProcess.setProportion(apply_count.divide(sale_count, 4, BigDecimal.ROUND_HALF_DOWN)
                        .multiply(BigDecimal.valueOf(100)).setScale(2) + "%");
            }else{
            	approvalProcess.setProportion("0.00%");
            }

            approvalProcess.setFull_name(map.get("full_name") == null ? "" : map.get("full_name").toString());
            approvalProcess.setNote(map.get("reason") == null ? "" : map.get("reason").toString());
            if (Integer.valueOf(map.get("source") + "") == 0) {
                approvalProcess.setCusName(map.get("sellCusName") != null ? map.get("sellCusName") + "" : "");
            } else {
                approvalProcess.setCusName(map.get("retailCusName") != null ? map.get("retailCusName") + "" : "");
            }

            list.add(approvalProcess);
        }
        result.setData(list);
        return result;
    }

    @ApiOperation(value = "精品订单审批  -- 审批处理详情", notes = "")
    @ApiImplicitParam(name = "id", value = "精品订单Id", required = true, dataType = "BoutiqueInformation")
    @ResponseBody
    @RequestMapping(value = "/boutiqueApprovalDetail", method = {RequestMethod.POST})
    public ApiReturnInfo<Map<String, Object>> boutiqueApproval(HttpServletRequest request, Integer id) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<Map<String, Object>>();
        Employee emp = getMember(request);
        Map<String, Object> resultMap = new HashMap<>();

        BoutiqueRetail retail = retailSupportService.selectBoutiqueRetailDetailById(id);
        BigDecimal applyCount = retail.getApplyCount();
        
        resultMap.put("retailCode", retail.getCode()); // 单号
        resultMap.put("employeeName", retail.getEmployeeName()); // 销售顾问
        resultMap.put("note", retail.getReason()); // 申请备注
        BigDecimal retailCountValue = new BigDecimal(0);
        List<BoutiqueRetailInclude> list = retail.getList();
        for (BoutiqueRetailInclude include : list) {
			if(include.getIsPackage() == 0 && include.getIsGift() == 0){
				retailCountValue = retailCountValue.add(include.getSaleValue().multiply(BigDecimal.valueOf(include.getInformationNum())));
			}
		}
        
        List<Integer> allPackageIds = retailSupportService.selectRetailPackageId(id); //非赠品的礼包
        if(allPackageIds != null && allPackageIds.size() > 0){
        	for (Integer packageId : allPackageIds) {
        		BoutiquePackage selectPackageById = packageSupportService.selectPackageById(packageId);
        		retailCountValue = retailCountValue.add(selectPackageById.getSalveValue());
			}
        }
        
        List<Map<String, Object>> single = new ArrayList<>();
        List<Map<String, Object>> pack = new ArrayList<>();

        Map<Integer, List<Map<String, Object>>> packMap = new HashMap<>();
        Map<Integer, String> packMapId = new HashMap<>();
        Map<Integer, BigDecimal> packMapSalve = new HashMap<>();

        BigDecimal allTaxCost = new BigDecimal("0.00");
        
        int count = 0 ;
        BigDecimal alreadyDivisionValue = new BigDecimal(0);
        
        for (BoutiqueRetailInclude include : list) {
            Integer isPackage = include.getIsPackage();
            if (isPackage.equals(0)) {
                // 不是精品礼包
                Map<String, Object> singleInfo = new HashMap<>();
                BoutiqueInformation information = informationSupportService
                        .selectBoutiqueInfoById(include.getInformationId(), emp.getStoreId());
                singleInfo.put("informationId", information.getId());//
                singleInfo.put("informationName", information.getName());// 精品名称
                Integer num = include.getInformationNum();
                singleInfo.put("saleNum", include.getInformationNum());// 数量
                singleInfo.put("saleValue", information.getUnitprice());// 销售单价

                singleInfo.put("retailIncludeId", include.getId());// 订单详情id
                BigDecimal divisionValue = include.getDivisionValue();
                

                Integer isGift = include.getIsGift();

                if (isGift == 1) {
                    //是赠送
                    singleInfo.put("applyValue", 0);// 申请总价格--金额
                    divisionValue = new BigDecimal("0");
                } else {
                	BigDecimal applyValue = include.getApplyValue();
                	BigDecimal saleValue = include.getSaleValue().multiply(BigDecimal.valueOf(include.getInformationNum()));
                    singleInfo.put("applyValue", applyValue.multiply(new BigDecimal(num)));// 申请总价格--金额
                    
                    if(divisionValue == null || divisionValue.equals(BigDecimal.ZERO)){
                    	BigDecimal divide = saleValue.divide(retailCountValue, 7, BigDecimal.ROUND_HALF_UP);
                    	divisionValue = applyCount.multiply(divide).setScale(2, RoundingMode.HALF_UP);
                    	alreadyDivisionValue = alreadyDivisionValue.add(divisionValue);
                    } 
                    
//                    if(count == list.size() - 1){
//                    	if(divisionValue == null || divisionValue.equals(BigDecimal.ZERO)){
//                    		divisionValue = applyCount.subtract(alreadyDivisionValue);
//                    	}
//                    }else{
//                        if(divisionValue == null || divisionValue.equals(BigDecimal.ZERO)){
//                        	BigDecimal divide = saleValue.divide(retailCountValue, 7, BigDecimal.ROUND_HALF_UP);
//                        	divisionValue = applyCount.multiply(divide).setScale(2, RoundingMode.HALF_UP);
//                        	alreadyDivisionValue = alreadyDivisionValue.add(divisionValue);
//                        }                   	
//                    }

                }
                singleInfo.put("isGift", isGift);//是否是赠送
                singleInfo.put("divisionValue", divisionValue);// 划价价格
                single.add(singleInfo);
                BigDecimal multiply = information.getTaxPrice()
                        .multiply(new BigDecimal(include.getInformationNum() + ""));
                allTaxCost = allTaxCost.add(multiply);
            } else {
            	
                Integer packId = include.getPackId();

                List<Map<String, Object>> list2 = packMap.get(packId);

                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                Map<String, Object> packageIncludeMap = new HashMap<>();
                packageIncludeMap.put("packageId", packId); // 礼包ID
                Integer informationId = include.getInformationId();
                BoutiqueInformation information = informationSupportService.selectBoutiqueInfoById(informationId, emp.getStoreId());
                packageIncludeMap.put("informationId", informationId); // 精品ID
                packageIncludeMap.put("informationName", information.getName());// 精品名称
                Integer num = include.getInformationNum();
                packageIncludeMap.put("saleNum", num);// 销售数量
                BigDecimal unitprice = information.getUnitprice();
                packageIncludeMap.put("saleValue", unitprice);// 销售单价
                packageIncludeMap.put("applyValue", include.getSaleValue().multiply(new BigDecimal(num)));// 申请总价格--金额
                packageIncludeMap.put("retailIncludeId", include.getId());// 订单详情id
                
                unitprice = unitprice.multiply(new BigDecimal(num));
                BigDecimal divisionValue = include.getDivisionValue();
                

                
//            	if(count == list.size() - 1){
//            		BigDecimal packageCount = applyCount.subtract(alreadyDivisionValue);
//            		if(divisionValue == null || divisionValue.equals(BigDecimal.ZERO)){
//                        BigDecimal divide2 = unitprice.divide(packageCount, 2, BigDecimal.ROUND_HALF_UP);
//            			divisionValue = packageCount.multiply(divide2).setScale(2);
//            		}
//            	}else{
//                    if(divisionValue == null || divisionValue.equals(BigDecimal.ZERO)){
//                        BoutiquePackage boutiquePackage = packageSupportService.selectPackageById(packId);
//                        BigDecimal salveValue = boutiquePackage.getSalveValue();
//                        BigDecimal packageCount =  packageIncludeSupportService.sumPackageCountValue(packId);
//                        BigDecimal divide = salveValue.divide(applyCount, 2, BigDecimal.ROUND_HALF_UP);
//                        BigDecimal divide2 = unitprice.divide(packageCount, 7, BigDecimal.ROUND_HALF_UP);
//                        divisionValue = salveValue.multiply(divide2).setScale(2, RoundingMode.HALF_UP);
//                        alreadyDivisionValue = alreadyDivisionValue.add(divisionValue);
//                    }            		
//            	}

                
                Integer isGift = include.getIsGift();
                if (isGift == 1) {
                    //是赠送
                    packageIncludeMap.put("applyValue", 0);// 申请总价格--金额
                    divisionValue = BigDecimal.ZERO;
                } else {
                    packageIncludeMap.put("applyValue", include.getSaleValue().multiply(new BigDecimal(num)));// 申请总价格--金额
                    
                    if(divisionValue == null || divisionValue.equals(BigDecimal.ZERO)){
                        BoutiquePackage boutiquePackage = packageSupportService.selectPackageById(packId);
                        BigDecimal salveValue = boutiquePackage.getSalveValue();
                        BigDecimal packageCount =  packageIncludeSupportService.sumPackageCountValue(packId);
//                        BigDecimal divide = salveValue.divide(retailCountValue, 7, BigDecimal.ROUND_HALF_UP);
//                        BigDecimal divide2 = unitprice.divide(packageCount, 7, BigDecimal.ROUND_HALF_UP);
//                        BigDecimal multiply = applyCount.multiply(divide).setScale(7, RoundingMode.HALF_UP);
//                        divisionValue = multiply.multiply(divide2).setScale(2, RoundingMode.HALF_UP);
                        
                        divisionValue = applyCount.multiply(salveValue.divide(retailCountValue, 7, BigDecimal.ROUND_HALF_UP)).multiply(unitprice.divide(packageCount, 7, BigDecimal.ROUND_HALF_UP)).setScale(2, RoundingMode.HALF_UP);
                        
                        alreadyDivisionValue = alreadyDivisionValue.add(divisionValue);
                    } 
                }
                packageIncludeMap.put("isGift", isGift);//是否是赠送
                packageIncludeMap.put("divisionValue", divisionValue);// 划价价格
                list2.add(packageIncludeMap);

                BoutiquePackage packageById = packageSupportService.selectPackageById(packId);
                packMap.put(packId, list2);
                packMapId.put(packageById.getId(), packageById.getName());
                packMapSalve.put(packageById.getId(), packageById.getSalveValue());

            }
            count++;
        }

        Set<Integer> packageIds = packMap.keySet();
        for (Integer packageId : packageIds) {
            Map<String, Object> pakeInclue = new HashMap<>();
            pakeInclue.put("packageId", packageId);
            pakeInclue.put("packageName", packMapId.get(packageId));
            pakeInclue.put("packageSaleCount", packMapSalve.get(packageId));
            pakeInclue.put("packageIncluedes", packMap.get(packageId));
            pack.add(pakeInclue);
        }
        resultMap.put("retailId", id);
        resultMap.put("single", single);// 精品列表
        resultMap.put("pack", pack);// 精品礼包列表
        Integer type = retail.getType();
        if (type >= 3) {
            type = 3;
        }
        resultMap.put("type", type);// 审批状态

        List<BoutiqueRetailRecord> records = retailRecordSupportService.selectRecordByRetailId(retail.getId());

        String reason = "";
        if (records != null && records.size() > 0) {
            BoutiqueRetailRecord record = records.get(0);
            reason = record.getNote() == null ? "" : record.getNote();
        }

        resultMap.put("reason", reason);// 审批原因
        resultMap.put("saleCount", retail.getSaleCount());// 销售价格
        resultMap.put("applyCount", applyCount);// 申请价格
        resultMap.put("allTaxCost", retail.getApplyCount().subtract(allTaxCost));// 总毛利
        resultMap.put("discount", retail.getApplyCount().divide(retail.getSaleCount(), 4, BigDecimal.ROUND_HALF_DOWN)
                .multiply(new BigDecimal(100)).setScale(2) + "%");// 折扣比例
        resultMap.put("applyDate", DateUtil.dateFormat(retail.getSaleDate(), DateUtil.sdf3)); // 申请日期
        result.setData(resultMap);
        return result;
    }

    /**
     * 订单审批
     */
    @ApiOperation(value = "订单审批", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "精品订单Id", required = true, dataType = "Number"),
            @ApiImplicitParam(name = "type", value = "(2,'审批不通过'),(3,'通过')", required = true, dataType = "Number"),
            @ApiImplicitParam(name = "note", value = "不通过原因", required = false, dataType = "String")})
    @ResponseBody
    @RequestMapping(value = "/boutiqueApproval", method = {RequestMethod.POST})
    public ApiReturnInfo<String> boutiqueApproval(HttpServletRequest request, Integer id, Integer type, String note) {
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();
        Employee member = getMember(request);
        try {
            int status = retailSupportService.approvalRetail(id, type, note, member);
            if (status == 1) {
                result.setData("success!");
            } else {
                result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
                result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
                result.setData("failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
            result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
            result.setData("failed!");
        }

        return result;
    }

    /**
     * 划价
     */
    @ApiOperation(value = "价格划价", notes = "")
    @ApiImplicitParam(name = "division", value = "json格式", required = true, dataType = "BoutiqueInformation")
    @ResponseBody
    @RequestMapping(value = "/updateRetailDivision", method = {RequestMethod.POST})
    public ApiReturnInfo<String> updateRetailDivision(HttpServletRequest request, @RequestBody String division) {
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();
        Employee member = getMember(request);
        if (division != null) {
            int update = retailSupportService.updateRetailDivision(JSON.parseObject(division), member);
        }
        return result;
    }

    /**
     * 目标设定
     */
    @ApiOperation(value = "目标设定 - 部门", notes = "")
    @ResponseBody
    @RequestMapping(value = "/selectTargetGroup", method = {RequestMethod.POST})
    public ApiReturnInfo<List<BoutiqueTargetGroup>> selectTargetGroup(HttpServletRequest request) {
        ApiReturnInfo<List<BoutiqueTargetGroup>> result = new ApiReturnInfo<List<BoutiqueTargetGroup>>();
        Employee member = getMember(request);
        List<BoutiqueTargetGroup> list = targetGroupSupportService.selectTargetGroups();
        result.setData(list);
        return result;
    }

    /**
     * 目标设定
     */
    @ApiOperation(value = "目标设定 - 查询指定年份", notes = "")
    @ApiImplicitParam(name = "year", value = "年份", required = true, dataType = "String")
    @ResponseBody
    @RequestMapping(value = "/selectTargetByYear", method = {RequestMethod.POST})
    public ApiReturnInfo<List<Map<String, Object>>> selectTargetByYear(HttpServletRequest request, String year) {
        ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<List<Map<String, Object>>>();
        Employee member = getMember(request);
        List<Map<String, Object>> list = targetSupportService.selectTargetByYear(year, member);
        result.setData(list);
        return result;
    }

    /**
     * 目标设定
     */
    @ApiOperation(value = "目标设定 - 添加、编辑确定保存", notes = "")
    @ApiImplicitParam(name = "target", value = "JSON格式", required = true, dataType = "String")
    @ResponseBody
    @RequestMapping(value = "/addOrUpdateTargetByYear", method = {RequestMethod.POST})
    public ApiReturnInfo<String> addOrUpdateTargetByYear(HttpServletRequest request, @RequestBody String target) {
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();
        Employee member = getMember(request);

        try {
            int status = targetSupportService.addOrUpdateTargetByYear(target, member);
            if (status == 1) {
                result.setData("success!");
            } else {
                result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
                result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
                result.setData("failed!");
            }
        } catch (Exception e) {
            result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
            result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
            result.setData("failed!");
        }
        return result;
    }

    /**
     * 目标设定
     */
    @ApiOperation(value = "目标设定 - 删除", notes = "")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Number")
    @ResponseBody
    @RequestMapping(value = "/deleteTargetById", method = {RequestMethod.POST})
    public ApiReturnInfo<String> deleteTargetById(Integer id) {
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();

        try {
            int delete = targetSupportService.deleteTargetById(id);
            if (delete == 1) {
                result.setData("success!");
            } else {
                result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
                result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
                result.setData("failed!");
            }
        } catch (Exception e) {
            result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
            result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
            result.setData("failed!");
        }
        return result;
    }

    /**
     * 销售明细
     */
    @ApiOperation(value = "销售明细", notes = "")
    @ResponseBody
    @RequestMapping(value = "/getSaleDetails", method = {RequestMethod.POST})
    public ApiReturnInfo getSaleDetails(HttpServletRequest request) {
        ApiReturnInfo result = new ApiReturnInfo();

        Employee member = getMember(request);

        Map<String, Object> saleMap = new HashMap<String, Object>();
        //当日交车数
        Map<String, Object> orderMap = new HashMap<String, Object>();
        orderMap.put("storeId", member.getStoreId());
        orderMap.put("deliveryDate", new Date());
        //已付全款
        orderMap.put("status", 4);
        int daySum = deliverCarService.getCurrentMothOrderNumTwo(orderMap);
        saleMap.put("daySum", daySum);// 销售明细 - 当日交车数

        // 销售部：当日精品销售订单
        Map<String, Object> dayRetail = new HashMap<String, Object>();
        dayRetail.put("dayDate", new Date());
        dayRetail.put("storeId", member.getStoreId());
        // 精品状态4,付全款
        dayRetail.put("type", BoutiqueEnum.BoutiqueType.FINISHED.getCode());
        // 销售类精品订单
        dayRetail.put("source", BoutiqueEnum.BoutiqueSource.SELL.getCode());
        List<Map<String, Object>> pageInfo = retailSupportService.getMouthBoutiqueRetailByStoreId(dayRetail);
        // 当日精品订单销售额总和
        BigDecimal saleCount = new BigDecimal(0);
        BigDecimal dayOrderSingleProduction = new BigDecimal(0);
        if (pageInfo.size() > 0) {
            for (Map<String, Object> objectMap2 : pageInfo) {
                Object sale_count = objectMap2.get("sale_count");
                if (sale_count != null) {
                    BigDecimal delivers = new BigDecimal(sale_count.toString());
                    saleCount = saleCount.add(delivers);
                }
            }
            // 订单单产
            BigDecimal delivers = new BigDecimal(pageInfo.size());
            if (!delivers.equals(BigDecimal.ZERO)) {
                dayOrderSingleProduction = saleCount.divide(delivers, 2, BigDecimal.ROUND_HALF_EVEN);
            }
        }
        saleMap.put("dayOrderSingleProduction", dayOrderSingleProduction);// 销售明细
        // -
        // 订单单产
        // 当日订单数
        saleMap.put("dayBoutiqueOdersSum", pageInfo.size());// 销售明细 - 当日订单
        // 某月某日交车订单精品收入
        Integer mapList = retailSupportService.getBoutiqueDeliverCarByStoreId(dayRetail);
        Integer daySingleProduction = 0;
        // 当日单产
        if (daySum != 0) {
            daySingleProduction = mapList / daySum;// 销售明细 - 当日单产
        }
        saleMap.put("daySingleProduction", daySingleProduction);// 销售明细 - 当日单产

        // 精品当日实际施工工时
        Map<String, Object> workHoursMap = new HashMap<String, Object>();
        workHoursMap.put("storeId", member.getStoreId());
        workHoursMap.put("status", BoutiqueEnum.IntsallType.ALL.getCode());
        workHoursMap.put("dayTime", new Date());
        Double workHours = installSupportService.getBoutiqueWorkHoursByStoreId(workHoursMap);
        saleMap.put("workHours", workHours == null ? "" : workHours.toString());// 销售明细 - 当日实际施工工时

        // 当日洗车台数
        CarWashExample washExample = new CarWashExample();
        CarWashExample.Criteria criteria = washExample.createCriteria();
        criteria.andStateEqualTo(2);
        criteria.andStoreIdEqualTo(member.getStoreId());
        List<CarWash> carWashes = carWashService.selectByExample(washExample);
        int carWashSum = 0;
        for (CarWash carWash : carWashes) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String format1 = format.format(new Date());
            String format2 = format.format(carWash.getEndTime());
            if (format1.equals(format2)) {
                carWashSum++;
            }
        }
        saleMap.put("carWashSum", carWashSum);// 销售明细 - 当日洗车台次
        result.setData(saleMap);
        return result;
    }

    /**
     * 精品明细
     */
    @ApiOperation(value = "精品明细", notes = "")
    @ResponseBody
    @RequestMapping(value = "/getBoutiqueDetails", method = {RequestMethod.POST})
    public ApiReturnInfo<Map<String, Object>> getBoutiqueDetails(HttpServletRequest request) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<Map<String, Object>>();
        Employee member = getMember(request);

        // 精品栏目
        Map<String, Object> boutiqueMap = new HashMap<String, Object>();
        // 精品部：当日精品销售订单
        Map<String, Object> dayRetail2 = new HashMap<String, Object>();
        dayRetail2.put("dayDate", new Date());
        dayRetail2.put("storeId", member.getStoreId());
        // 精品状态4,付全款
        dayRetail2.put("type", BoutiqueEnum.BoutiqueType.FINISHED.getCode());
        // 销售类精品订单
        dayRetail2.put("source", BoutiqueEnum.BoutiqueSource.RETAIL.getCode());
        List<Map<String, Object>> pageInfo2 = retailSupportService.getMouthBoutiqueRetailByStoreId(dayRetail2);

        // 当日精品订单销售额总和
        BigDecimal dayBoutiqueRetail = new BigDecimal(0);
        BigDecimal dayBoutiqueRetailSingle = new BigDecimal(0);
        if (pageInfo2.size() > 0) {
            for (Map<String, Object> objectMap2 : pageInfo2) {
                Object apply_count = objectMap2.get("apply_count");
                if (apply_count != null) {
                    dayBoutiqueRetail = dayBoutiqueRetail.add(new BigDecimal(apply_count.toString()));
                }
            }

            // 精品当日单产
            BigDecimal delivers = new BigDecimal(pageInfo2.size());
            if (!delivers.equals(BigDecimal.ZERO)) {
                dayBoutiqueRetailSingle = dayBoutiqueRetail.divide(delivers, 2, BigDecimal.ROUND_HALF_EVEN);
            }
        }
        boutiqueMap.put("dayBoutiqueRetail", dayBoutiqueRetail + "");// 精品明细 --
        // 当日收入
        boutiqueMap.put("dayBoutiqueRetailSingle", dayBoutiqueRetailSingle + ""); // 精品明细
        // --
        // 当日单产
        result.setData(boutiqueMap);
        return result;
    }


    /**
     * 精品加装分析
     */
    @ApiOperation(value = "精品加装分析", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime", value = "开始时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "Number"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Number")
    })
    @ResponseBody
    @RequestMapping(value = "/getBoutiqueInstallAnalysisPage", method = {RequestMethod.POST})
    public ApiReturnInfo<PageInfo<Map<String, Object>>> getBoutiqueInstallAnalysisPage2(HttpServletRequest request, BoutiqueAnalysisCondition condition) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (condition.getPageNum() == null || condition.getPageSize() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("分页字段不能为空");
            return result;
        }
        Employee member = getMember(request);
        Map<String, Object> params = Maps.newHashMap();
        params.put("storeId", member.getStoreId());
        if (StringUtils.isNotBlank(condition.getStartTime())) {
            params.put("startTime", condition.getStartTime() + " 00:00:00");
        }
        if (StringUtils.isNotBlank(condition.getEndTime())) {
            params.put("endTime", condition.getEndTime() + " 23:59:59");
        }
        //获取付完全款的精品订单
        List<Integer> retailIds = receiptService.getBoutiqueRetailIdsByParams(params);
        PageInfo<Map<String, Object>> pageInfo = installSupportService.selectListByParams2(retailIds, condition.getPageNum(), condition.getPageSize());
        List<Map<String, Object>> data = pageInfo.getList();
        //每页的精品ID集合
        List<Integer> boutiqueIds = Lists.newArrayList();
        for (Map<String, Object> map : data) {
            boutiqueIds.add((Integer) map.get("informationId"));
        }
        //key 精品ID value:精品订单数
        Map<Integer, Integer> orders = Maps.newHashMap();
        //key 精品ID value:加装的订单数
        Map<Integer, Integer> decorations = Maps.newHashMap();
        //精品销售数量
        Map<Integer, BigDecimal> saleQuantities = Maps.newHashMap();
        //精品赠送数量
        Map<Integer, BigDecimal> giftQuantities = Maps.newHashMap();
        //精品销售额
        Map<Integer, BigDecimal> priceMap = Maps.newHashMap();
        //获取所有的精品的总销售额
        BigDecimal sumSaleAmount = installSupportService.getSumSaleAmount2(retailIds);
        //获取所有的精品的总成本
        BigDecimal sumCost = installSupportService.getSumCost2(retailIds);
        //所有精品总利润
        BigDecimal sumProfit = sumSaleAmount.subtract(sumCost);
        if (!boutiqueIds.isEmpty()) {
            params.put("retailIds", (retailIds == null || retailIds.isEmpty()) ? null : retailIds);
            params.put("boutiqueIds", (boutiqueIds == null || boutiqueIds.isEmpty()) ? null : boutiqueIds);
            //获取销售数量
            params.put("isGift", false);
            priceMap = installSupportService.getSalePriceByboutiqueIds(params);
            saleQuantities = installSupportService.getSaleQuantityByboutiqueIds(params);
            //获取赠送数量
            params.put("isGift", true);
            giftQuantities = installSupportService.getSaleQuantityByboutiqueIds(params);
            //根据精品ID集合获取这一批精品的加装数量
            List<Map<String, Object>> decorationList = installSupportService.getDecorationsByIds2(params);
            if (decorationList != null && !decorationList.isEmpty()) {
                for (Map<String, Object> map : decorationList) {
                    decorations.put((Integer) map.get("informationId"), Integer.valueOf(map.get("count").toString()));
                }
            }
            //根据精品ID集合获取这一批精品的的销售的订单数
            List<Map<String, Object>> orderList = installSupportService.getSumOrderByBoutiqueIds2(params);
            if (orderList != null && !orderList.isEmpty()) {
                for (Map<String, Object> map : orderList) {
                    orders.put((Integer) map.get("informationId"), Integer.valueOf(map.get("count").toString()));
                }
            }
        }
        for (Map<String, Object> map : data) {
            //销售额
            BigDecimal saleAmount = priceMap.get((Integer) map.get("informationId")) == null ? BigDecimal.ZERO : new BigDecimal(priceMap.get((Integer) map.get("informationId")).toString());
            //成本
            BigDecimal cost = map.get("cost") == null ? BigDecimal.ZERO : new BigDecimal(map.get("cost").toString());
            //利润
            BigDecimal profit = saleAmount.subtract(cost);
            map.put("cost", cost.setScale(2));
            map.put("profit", profit.setScale(2));
            map.put("saleAmount", saleAmount.setScale(2));
            //销售数量
            map.put("saleQuantity", saleQuantities.get((Integer) map.get("informationId")) == null ? BigDecimal.ZERO : saleQuantities.get((Integer) map.get("informationId")));
            //赠送数量
            map.put("giftQuantity", giftQuantities.get((Integer) map.get("informationId")) == null ? BigDecimal.ZERO : giftQuantities.get((Integer) map.get("informationId")));
            //销售贡献率
            map.put("saleAmountRate", Objects.equals(sumSaleAmount, BigDecimal.ZERO) ? "0.00%" : (saleAmount.divide(sumSaleAmount, 4, RoundingMode.HALF_UP)).multiply(new BigDecimal(100)).setScale(2,RoundingMode.HALF_UP) + "%");
            //毛利贡献率
            map.put("profitRate", Objects.equals(sumProfit, BigDecimal.ZERO) ? "0.00%" : (profit.divide(sumProfit, 4, RoundingMode.HALF_UP)).multiply(new BigDecimal(100)).setScale(2,RoundingMode.HALF_UP) + "%");
            //加装台数
            map.put("decorationQuantity", decorations.get((Integer) map.get("informationId")) == null ? 0 : decorations.get((Integer) map.get("informationId")));
            //实际加装率
            if (orders.get((Integer) map.get("informationId")) == null || (orders.get((Integer) map.get("informationId")) != null && orders.get((Integer) map.get("informationId")) == 0)) {
                map.put("realDecorationRate", "0.00%");
            } else {
                map.put("realDecorationRate", new BigDecimal(map.get("decorationQuantity").toString()).divide(new BigDecimal(orders.get((Integer) map.get("informationId")).toString()), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(2,RoundingMode.HALF_UP) + "%");
            }
            //计划加装率
            map.put("planDecorationRate", null);
            //加装达成率
            map.put("successDecorationRate", null);
        }
        result.setData(pageInfo);
        return result;
    }
}
