package com.unicdata.controller.boutique;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.CalculateUtils;
import com.unicdata.constant.*;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.approval.ApprovalOrder;
import com.unicdata.entity.boutique.*;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.approval.ApprovalOrderService;
import com.unicdata.service.boutique.*;
import com.unicdata.service.car.AppCarWashService;
import com.unicdata.service.car.AppDeliverCarService;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.employee.AppEmployeeService;
import com.unicdata.service.employee.EmployeeTargetService;
import com.unicdata.service.order.OrderService;
import com.unicdata.service.push.PushMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 精品管理
 *
 * @author admin
 */
@Controller
@RequestMapping("/app/boutique")
@Api(value = "订单精品相关接口", tags = {"订单精品相关接口"})
public class BoutiqueController extends HomeBaseController {
    @Value("${upload.access.path}")
    private String uploadAccessPath;//图片域名
    @Autowired
    private BoutiqueRetailService boutiqueRetailService;
    @Autowired
    private BoutiqueClassifyService boutiqueClassifyService;
    @Autowired
    private BoutiqueInformationService boutiqueInformationService;
    @Autowired
    private BoutiquePackageService boutiquePackageService;
    @Autowired
    private BoutiqueTargetService boutiqueTargetService;
    @Autowired
    private AppDeliverCarService appDeliverCarService;
    @Autowired
    private EmployeeTargetService employeeTargetService;
    @Autowired
    private AppCarWashService appCarWashService;
    @Autowired
    private BoutiqueInstallProjectService boutiqueInstallProjectService;
    @Autowired
    private BoutiqueWarehouseService boutiqueWarehouseService;
    @Autowired
    private BoutiqueSupplierService boutiqueSupplierService;
    @Autowired
    private BoutiqueRetailRecordService boutiqueRetailRecordService;
    @Autowired
    private ApprovalOrderService approvalOrderService;
    @Autowired
    private BoutiqueInstallService boutiqueInstallService;
    @Autowired
    private BoutiqueRetailIncludeService boutiqueRetailIncludeService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BoutiqueRetailIncludePackDivisionService boutiqueRetailIncludePackDivisionService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AppEmployeeService appEmployeeService;
    @Autowired
    private PushMessageService pushMessageService;


    @ApiOperation(value = "查询所有精品分类信息")
    @ApiImplicitParam(name = "id", value = "精品分类id,不传值默认查第父级", required = true, dataType = "Integer")
    @RequestMapping(value = "/queryBoutiqueClassify", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo queryBoutiqueClassify(HttpServletRequest request, Integer id) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> parentList = boutiqueClassifyService.selectBoutiqueClassifyById(emp.getStoreId(), 0);
        map.put("parentList", parentList);
        //新增订单精品
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (null != id) {
            list = boutiqueClassifyService.selectBoutiqueClassifyAll(emp.getStoreId(), id);
        }
        map.put("childList", list);
        ari.setData(map);
        return ari;
    }

    @ApiOperation(value = "根据分类查询所有精品集合")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "精品分类id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页最大数量，默认30", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/queryBoutique", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo queryBoutique(HttpServletRequest request, Integer id, Integer pageNum, Integer pageSize) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = boutiqueInformationService.selectBoutiqueInformation(pageNum, pageSize, emp.getStoreId(), id);
        ari.setData(map);
        return ari;
    }

    @ApiOperation(value = "查询精品详细")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer")
    @RequestMapping(value = "/queryBoutiqueDetail", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo queryBoutiqueInformation(HttpServletRequest request, Integer id) {
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        BoutiqueInformation information = boutiqueInformationService.selectByPrimaryKey(id);
        if (null != information) {
            map.put("id", information.getId());
            map.put("name", information.getName());
            map.put("saleValue", information.getUnitprice());
            map.put("picture", information.getPicture() == null ? "" : uploadAccessPath + information.getPicture());
            map.put("constructionNode", information.getConstructionNode());
        }
        ari.setData(map);
        return ari;
    }

    @ApiOperation(value = "查询所有精品礼包集合")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "familyId", value = "车系id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "礼包名字", required = false, dataType = "String")
    })
    @RequestMapping(value = "/queryBoutiquePackage", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo queryBoutiquePackage(HttpServletRequest request, Integer familyId, String name) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        List<Map<String, Object>> list = boutiquePackageService.selectBoutiquePackage(emp.getStoreId(), familyId, name);
        ari.setData(list);
        return ari;
    }

    @ApiOperation(value = "根据精品礼包id查询礼包明细")
    @ApiImplicitParam(name = "packageId", value = "精品礼包id", required = true, dataType = "Integer")
    @RequestMapping(value = "/queryBoutiquePackageDetail", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo queryBoutiquePackageDetail(HttpServletRequest request, Integer packageId) {
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        //礼包信息
        BoutiquePackage bPackage = boutiquePackageService.selectByPrimaryKey(packageId);
        map.put("id", bPackage != null ? bPackage.getId() : "");
        map.put("name", bPackage != null ? bPackage.getName() : "");
        map.put("salveValue", bPackage != null ? bPackage.getSalveValue() : "");
        map.put("picture", bPackage != null ? uploadAccessPath + bPackage.getPicture() : "");
        //礼包明细信息
        List<Map<String, Object>> list = boutiquePackageService.selectBoutiquePackageDetail(packageId);
        map.put("detailList", list);
        ari.setData(map);
        return ari;
    }

    @ApiOperation(value = "根据精品礼包id集合查询礼包明细")
    @ApiImplicitParam(name = "packageIds", value = "精品礼包id集合", required = true, dataType = "String")
    @RequestMapping(value = "/queryBoutiqueByPackageIdS", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo queryBoutiqueByPackageIdS(String packageIds) {
        ApiReturnInfo ari = new ApiReturnInfo();
        try {
            if (packageIds != null) {
                List<Map<String, Object>> map2 = new ArrayList<>();
                Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
                boolean matches = pattern.matcher(packageIds).matches();
                if (packageIds.indexOf("/") > 0 || matches) {
                    String[] s = packageIds.split("/");
                    if (s != null && s.length > 0) {
                        for (String packageId : s) {
                            if (pattern.matcher(packageId).matches()) {
                                Map<String, Object> map = new HashMap<String, Object>();
                                //礼包信息
                                Integer integer = Integer.valueOf(packageId);
                                BoutiquePackage bPackage = boutiquePackageService.selectByPrimaryKey(integer);
                                int i = 0;
                                if (bPackage != null) {
                                    map.put("id", bPackage != null ? bPackage.getId() : 0);
                                    map.put("name", bPackage != null ? bPackage.getName() : "");
                                    map.put("salveValue", bPackage != null ? bPackage.getSalveValue() : 0);
                                    map.put("picture", bPackage != null ? uploadAccessPath + bPackage.getPicture() : "");
                                    i++;
                                }
                                //礼包明细信息
                                List<Map<String, Object>> list = boutiquePackageService.selectBoutiquePackageDetail(integer);
                                if (list != null && list.size() > 0) {
                                    i++;
                                    map.put("detailList", list);
                                }
                                if (i > 0) {
                                    map2.add(map);
                                }
                            }
                        }
                        ari.setData(map2);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ari;
    }

    @ApiOperation(value = "添加订单精品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "editType", value = "0:新增 1：修改 ，默认新增", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "informationId", value = "精品id或礼包id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "isPackage", value = "0:精品id 1:礼包id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "isGift", value = "是否赠送 0:否 1:是", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "saleValue", value = "销售单价", required = true, dataType = "String"),
            @ApiImplicitParam(name = "informationNum", value = "购买数量", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "constructionNode", value = "施工节点 1：交车前  2：交车后  3：不施工", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "jsonStr", value = "json字符串,礼包类型需要", required = true, dataType = "String")
    })
    @RequestMapping(value = "/addOrderBoutique", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo addOrderBoutique(HttpServletRequest request, Integer editType,
                                          BoutiqueRetailInclude bri, String jsonStr, Integer orderId) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        //新增订单精品
        BoutiqueRetail record = new BoutiqueRetail();
        record.setEmployeeId(emp.getId());
        record.setStoreId(emp.getStoreId());
        record.setOrderId(orderId);
        int res = boutiqueRetailService.addBoutiqueRetail(record, bri, jsonStr, editType);
        if (res > 0) {
            orderService.calcUpdateOrderAmount(record.getOrderId());
        }
        ari.setData(null);
        return ari;
    }

    @ApiOperation(value = "App精品首页")
    @RequestMapping(value = "/index", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo index(HttpServletRequest request) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Map<String, Object> boutiqueRetail = new HashMap<String, Object>();
            boutiqueRetail.put("saleDate", new Date());
            boutiqueRetail.put("storeId", emp.getStoreId());
            //精品状态5已收讫
            boutiqueRetail.put("type", BoutiqueEnum.BoutiqueType.FINISHED.getCode());
            List<Map<String, Object>> boutiqueRetailByStoreId = boutiqueRetailService.getMouthBoutiqueRetailByStoreId(boutiqueRetail);
            BigDecimal incomeSum = new BigDecimal("0");
            for (Map<String, Object> retail : boutiqueRetailByStoreId) {
                if (retail.get("apply_count") != null) {
                    String string = retail.get("apply_count").toString();
                    BigDecimal sumMargin = new BigDecimal(string);
                    incomeSum = incomeSum.add(sumMargin);
                }
            }
            //本月收入达成
            map.put("incomeSum", incomeSum.setScale(2, BigDecimal.ROUND_HALF_UP));
            Map<String, Object> objectMap = new HashMap<String, Object>();
            objectMap.put("storeId", emp.getStoreId());
            objectMap.put("date", new Date());
            List<BoutiqueTarget> targets = boutiqueTargetService.getBoutiqueTargetByStoreId(objectMap);
            //计划毛利
            BigDecimal profitPlay = new BigDecimal("0");
            //计划收入
            BigDecimal incomePlay = new BigDecimal("0");
            for (BoutiqueTarget target : targets) {
                BigDecimal profitPlay1 = target.getProfitPlay();
                if (profitPlay1 != null) {
                    profitPlay = profitPlay.add(profitPlay1);
                }
                BigDecimal incomePlay1 = target.getIncomePlay();
                if (profitPlay1 != null) {
                    incomePlay = incomePlay.add(incomePlay1);
                }
            }
            //本月收入进度
            BigDecimal s = new BigDecimal("100");
            if (incomePlay.compareTo(BigDecimal.ZERO) == 1) {
                String incomeProcess = incomeSum.divide(incomePlay, 4, BigDecimal.ROUND_HALF_DOWN).multiply(s).setScale(2) + "%";
                map.put("incomeProcess", incomeProcess == null ? "0.00%" : incomeProcess);
            } else {
                map.put("incomeProcess", "0.00%");
            }

            //本月毛利成本
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("saleDate", new Date());
            map2.put("storeId", emp.getStoreId());
            map2.put("type", BoutiqueEnum.BoutiqueType.FINISHED.getCode());
            map2.put("isPackage", BoutiqueEnum.NoYesType.NO.getCode());
            //本月单品成本
            Double sumByisPackage1 = boutiqueRetailService.getMouthCostSumByisPackage(map2);
            BigDecimal sumByisPackage2 = new BigDecimal(sumByisPackage1.toString());
            //本月礼包成本
            map2.put("isPackage", BoutiqueEnum.NoYesType.YES.getCode());
            Double sumByisPackage3 = boutiqueRetailService.getMouthCostSumByisPackage(map2);
            BigDecimal sumByisPackage4 = new BigDecimal(sumByisPackage3.toString());
            //本月毛利达成
            BigDecimal marginSum = incomeSum.subtract(sumByisPackage2).subtract(sumByisPackage4);
            map.put("marginSum", marginSum == null ? "0" : marginSum.setScale(2, BigDecimal.ROUND_HALF_UP));
            //本月毛利进度
            if (marginSum.compareTo(BigDecimal.ZERO) == 1 && profitPlay.compareTo(BigDecimal.ZERO) == 1) {
                BigDecimal multiply = marginSum.divide(profitPlay, 4, BigDecimal.ROUND_HALF_EVEN);
                String marginSumProcess = multiply.multiply(s).setScale(2) + "%";
                map.put("marginSumProcess", marginSumProcess == null ? "0.00%" : marginSumProcess);
            } else {
                map.put("marginSumProcess", "0.00%");
            }

            //计划单产=销售部精品销售月计划金额/月计划交车总数
            objectMap.put("source", BoutiqueEnum.BoutiqueSource.SELL.getCode());
            Map<String, Object> targetMap = new HashMap<String, Object>();
            targetMap.put("targetTime", new Date());
            targetMap.put("storeId", emp.getStoreId());
            //本月目标总数
            Map<String, Object> stringObjectMap = employeeTargetService.getMothTargetNumByStoreId(targetMap);
            //交车目标计划单产
            if (stringObjectMap.get("deliverSum") != null) {
                BigDecimal delivers = new BigDecimal(stringObjectMap.get("deliverSum").toString());
                List<BoutiqueTarget> byStoreId = boutiqueTargetService.getBoutiqueTargetByStoreId(objectMap);
                if (byStoreId != null && byStoreId.size() > 0) {
                    if (byStoreId.get(0) != null && delivers.compareTo(BigDecimal.ZERO) == 1) {
                        BigDecimal intValue = byStoreId.get(0).getIncomePlay();
                        if (intValue != null) {
                            BigDecimal divide = intValue.divide(delivers, 2);
                            map.put("deliverSum", divide == null ? "0" : divide);
                        } else {
                            map.put("deliverSum", "0");
                        }
                    } else {
                        map.put("deliverSum", "0");
                    }
                } else {
                    map.put("deliverSum", "0");
                }
            } else {
                map.put("deliverSum", "0");
            }

            //实际单产=销售部实际精品收入合计/实际交车数量
            //实际交车数
            Map<String, Object> objectMap1 = new HashMap<String, Object>();
            objectMap1.put("storeId", emp.getStoreId());
            objectMap1.put("deliverTime", new Date());
            int numByStoreId = appDeliverCarService.getMothDeliverCarNumByStoreId(objectMap1);
            //销售部实际精品收入
            boutiqueRetail.put("source", BoutiqueEnum.BoutiqueSource.SELL.getCode());
            List<Map<String, Object>> boutiqueRetails = boutiqueRetailService.getMouthBoutiqueRetailByStoreId(boutiqueRetail);
            if (boutiqueRetails != null && boutiqueRetails.size() > 0 && numByStoreId != 0) {
                Map<String, Object> objectMap2 = boutiqueRetails.get(0);
                Object apply_count = objectMap2.get("apply_count");
                BigDecimal num = new BigDecimal(numByStoreId);
                if (apply_count != null && num.compareTo(BigDecimal.ZERO) == 1) {
                    BigDecimal bigDecimal = new BigDecimal(apply_count.toString());
                    BigDecimal divide = bigDecimal.divide(num, 2);
                    map.put("deliverSum2", divide == null ? "0" : divide);
                }
            } else {
                map.put("deliverSum2", "0");
            }
            Map<String, Object> retail = new HashMap<String, Object>();
            retail.put("saleDate", new Date());
            retail.put("storeId", emp.getStoreId());
            //精品状态0,待审批
            retail.put("type", BoutiqueEnum.BoutiqueType.APPROVAL_WAIT.getCode());
            List<Map<String, Object>> boutiqueRetails1 = boutiqueRetailService.getMouthBoutiqueRetailByStoreId(retail);
            //审批数量
            map.put("approvalSum", boutiqueRetails1 == null ? "0" : boutiqueRetails1.size());

            Map<String, Object> StockMap = new HashMap<String, Object>();
            StockMap.put("storeId", emp.getStoreId());
            //安全库存
            StockMap.put("bl", BoutiqueEnum.NoYesType.NO.getCode());
            List<Map<String, Object>> information = boutiqueInformationService.selectBoutiqueStockByStoreId(StockMap);
            map.put("safeStockSum", information == null ? "0" : information.size());
            //在库天数：不安全库存
            StockMap.put("bl", BoutiqueEnum.NoYesType.YES.getCode());
            List<Map<String, Object>> information2 = boutiqueInformationService.selectBoutiqueStockByStoreId(StockMap);
            map.put("IsSafeStockSum", information2 == null ? "0" : information2.size());

            //销售栏目
            Map<String, Object> saleMap = new HashMap<String, Object>();
            //当日交车数
            Map<String, Object> orderMap = new HashMap<String, Object>();
            orderMap.put("storeId", emp.getStoreId());
            orderMap.put("deliveryDate", new Date());
            //已付全款
            orderMap.put("status", 4);
            int daySum = orderService.getCurrentMothOrderNumTwo(orderMap);
            saleMap.put("daySum", daySum);
            //销售部：当日精品销售订单
            Map<String, Object> dayRetail = new HashMap<String, Object>();
            dayRetail.put("dayDate", new Date());
            dayRetail.put("storeId", emp.getStoreId());
            //精品状态4,付全款
            dayRetail.put("type", BoutiqueEnum.BoutiqueType.FINISHED.getCode());
            //销售类精品订单
            dayRetail.put("source", BoutiqueEnum.BoutiqueSource.SELL.getCode());
            List<Map<String, Object>> pageInfo = boutiqueRetailService.getMouthBoutiqueRetailByStoreId(dayRetail);
            //当日精品订单销售额总和
            BigDecimal saleCount = new BigDecimal(0);
            if (pageInfo != null && pageInfo.size() > 0) {
                for (Map<String, Object> objectMap2 : pageInfo) {
                    Object sale_count = objectMap2.get("sale_count");
                    if (sale_count != null) {
                        BigDecimal delivers = new BigDecimal(sale_count.toString());
                        saleCount = saleCount.add(delivers);
                    }
                }
                //订单单产
                BigDecimal delivers = new BigDecimal(pageInfo.size());
                if (delivers.compareTo(BigDecimal.ZERO) == 1) {
                    BigDecimal divide = saleCount.divide(delivers, 2);
                    saleMap.put("dayOrderSingleProduction", divide == null ? "0" : divide);
                } else {
                    saleMap.put("dayOrderSingleProduction", "0");
                }
            } else {
                saleMap.put("dayOrderSingleProduction", "0");
            }
            //当日订单数
            saleMap.put("dayBoutiqueOdersSum", pageInfo == null ? "0" : pageInfo.size());
            //某月某日交车订单精品收入
            Integer mapList = boutiqueRetailService.getBoutiqueDeliverCarByStoreId(dayRetail);
            //当日单产
            if (daySum != 0) {
                int i = mapList / daySum;
                saleMap.put("daySingleProduction", i);
            } else {
                saleMap.put("daySingleProduction", "0");
            }

            //精品当日实际施工工时
            Map<String, Object> workHoursMap = new HashMap<String, Object>();
            workHoursMap.put("storeId", emp.getStoreId());
            workHoursMap.put("status", BoutiqueEnum.IntsallType.ALL.getCode());
            workHoursMap.put("dayTime", new Date());
            Double workHours = boutiqueInstallProjectService.getBoutiqueWorkHoursByStoreId(workHoursMap);
            saleMap.put("workHours", workHours == null ? "" : workHours.toString());

            //当日洗车台数
            CarWashExample washExample = new CarWashExample();
            CarWashExample.Criteria criteria = washExample.createCriteria();
            criteria.andStateEqualTo(CarEnum.CarWashStates.FINISHED.getCode());
            criteria.andStoreIdEqualTo(emp.getStoreId());
            List<CarWash> carWashes = appCarWashService.selectByExample(washExample);
            int carWashSum = 0;
            for (CarWash carWash : carWashes) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String format1 = format.format(new Date());
                String format2 = format.format(carWash.getEndTime());
                if (format1.equals(format2)) {
                    carWashSum++;
                }
            }
            saleMap.put("carWashSum", carWashSum);

            //精品栏目
            Map<String, Object> boutiqueMap = new HashMap<String, Object>();
            //精品部：当日精品销售订单
            Map<String, Object> dayRetail2 = new HashMap<String, Object>();
            dayRetail2.put("dayDate", new Date());
            dayRetail2.put("storeId", emp.getStoreId());
            //精品状态4,付全款
            dayRetail2.put("type", BoutiqueEnum.BoutiqueType.FINISHED.getCode());
            //销售类精品订单
            dayRetail2.put("source", BoutiqueEnum.BoutiqueSource.RETAIL.getCode());
            List<Map<String, Object>> pageInfo2 = boutiqueRetailService.getMouthBoutiqueRetailByStoreId(dayRetail2);
            //当日精品订单销售额总和
            BigDecimal apply_count2 = new BigDecimal(0);
            if (pageInfo2 != null && pageInfo2.size() > 0) {
                for (Map<String, Object> objectMap2 : pageInfo2) {
                    Object apply_count = objectMap2.get("apply_count");
                    if (apply_count != null) {
                        BigDecimal delivers = new BigDecimal(apply_count.toString());
                        apply_count2 = apply_count2.add(delivers);
                    }
                }
                //精品当日收入
                boutiqueMap.put("dayBoutiqueRetail", apply_count2);
                //精品当日单产
                BigDecimal delivers = new BigDecimal(pageInfo2.size());
                if (delivers.compareTo(BigDecimal.ZERO) == 1) {
                    BigDecimal divide = apply_count2.divide(delivers, 2, BigDecimal.ROUND_HALF_EVEN);
                    boutiqueMap.put("dayBoutiqueRetail2", divide == null ? "0" : divide);
                } else {
                    boutiqueMap.put("dayBoutiqueRetail2", "0");
                }
            } else {
                boutiqueMap.put("dayBoutiqueRetail2", "0");
                boutiqueMap.put("dayBoutiqueRetail", "0");
            }
            map.put("saleMap", saleMap == null ? "" : saleMap);
            map.put("boutiqueMap", boutiqueMap == null ? "" : boutiqueMap);
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "精品审批处理分页-审批单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer")
    })
    @RequestMapping(value = "/boutiqueApproval", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo boutiqueApproval(HttpServletRequest request, Integer pageNum, Integer pageSize) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> retail = new HashMap<String, Object>();
        retail.put("saleDate", new Date());
        retail.put("storeId", emp.getStoreId());
        //精品状态1,待审批
        retail.put("type", BoutiqueEnum.BoutiqueType.APPROVAL_WAIT.getCode());
        PageInfo pageInfo = boutiqueRetailService.getMouthBoutiqueRetailByStoreId(retail, pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("listcar", pageInfo.getList());
        map.put("pageResult", getPageResult(pageInfo));
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "精品审批-审批历史记录分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "stratTime", value = "查询开始时间 yyyy-MM-dd", required = false, dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "查询结束时间 yyyy-MM-dd", required = false, dataType = "String")
    })
    @RequestMapping(value = "/getBoutiqueEetailRecordByMouthId", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo getBoutiqueEetailRecordByMouthId(HttpServletRequest request, Integer pageNum, Integer pageSize, String stratTime, String endTime) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> retail = new HashMap<String, Object>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (stratTime != null && stratTime != "") {
                Date s1 = sdf.parse(stratTime);
                retail.put("stratTime", s1);
            }
            if (endTime != null && endTime != "") {
                Date d1 = sdf.parse(endTime);
                retail.put("endTime", d1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        retail.put("storeId", emp.getStoreId());
        PageInfo pageInfo = boutiqueRetailService.getBoutiqueEetailRecordByMouthId(retail, pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("data", pageInfo.getList());
        map.put("pageResult", getPageResult(pageInfo));
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "精品审批处理分页-审批单详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "retailId", value = "精品订单id", required = true, dataType = "Interger")
    })
    @RequestMapping(value = "/boutiqueApprovalDetail", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo boutiqueApprovalDetail(HttpServletRequest request, Integer retailId) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> StockMap = new HashMap<String, Object>();
        StockMap.put("id", retailId);
        StockMap.put("storeId", emp.getStoreId());

        Map<String, Object> hashMap = new HashMap<String, Object>();
        //精品订单详情
        List<Map<String, Object>> pageInfo = boutiqueRetailService.getMouthBoutiqueRetailByStoreId(StockMap);
        Map<String, Object> objectMap = new HashMap<>();
        if (pageInfo != null && pageInfo.size() > 0) {
            objectMap = pageInfo.get(0);
            if (objectMap != null) {
                //精品来源
                Object source = objectMap.get("source");
                if (source != null) {
                    Integer integer = Integer.valueOf(source.toString());
                    objectMap.put("departmentName", integer == 0 ? "销售部" : "精品部");
                }
            }
        }
        //精品订单合计
        String sale_countStr = (objectMap != null && objectMap.get("sale_count") != null) ? objectMap.get("sale_count").toString() : "";
        BigDecimal bigDecimalSaleCount = new BigDecimal(sale_countStr);
        String apply_countStr = (objectMap != null && objectMap.get("apply_count") != null) ? objectMap.get("apply_count").toString() : "";
        BigDecimal bigDecimalApplyCount = new BigDecimal(apply_countStr);
        //精品单明细
        List<Map<String, Object>> boutiqueOrderId = boutiqueRetailService.getBoutiqueOrderId(retailId);
        //精品合计
        BigDecimal boutiqueSum = new BigDecimal(0);
        //礼包合计
        BigDecimal boutiquePackSum = new BigDecimal(0);
        //礼包合计集合
        Map<Integer, Object> boutiquePackSumMap = new HashMap<>();
        //礼包成本含税价
        BigDecimal taxCostSum = new BigDecimal(0);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> packMapList = new ArrayList<Map<String, Object>>();
        //礼包 id集合
        List<Integer> packIdList = new ArrayList<Integer>();
        for (Map<String, Object> stringObjectMap : boutiqueOrderId) {
            Map<String, Object> objectHashMap = new HashMap<>();
            objectHashMap.put("isGift", stringObjectMap.get("isGift"));
            objectHashMap.put("id", stringObjectMap.get("id"));
            objectHashMap.put("sale_value", stringObjectMap.get("sale_value"));
            objectHashMap.put("num", stringObjectMap.get("information_num"));
            objectHashMap.put("name", stringObjectMap.get("informationName"));
            objectHashMap.put("information_id", stringObjectMap.get("information_id"));
            Object tax_cost = stringObjectMap.get("tax_price");
            if (tax_cost != null && stringObjectMap.get("information_num") != null) {
                BigDecimal tax_cost2 = new BigDecimal(tax_cost.toString());
                BigDecimal saleNum = new BigDecimal(stringObjectMap.get("information_num").toString());
                taxCostSum = taxCostSum.add(tax_cost2.multiply(saleNum));
            }
            //精品或者礼包销售总额  金额=单价X数量
            BigDecimal bigDecimal = new BigDecimal(0);
            Object sum_money = objectHashMap.get("sale_value");
            Object information_num = objectHashMap.get("num");
            if (sum_money != null && information_num != null) {
                BigDecimal saleCount = new BigDecimal(sum_money.toString());
                BigDecimal saleNum = new BigDecimal(information_num.toString());
                bigDecimal = bigDecimal.add(saleCount.multiply(saleNum));
            }
            //判断是否赠送  是否赠送( 0 - 否 ； 1 - 是)
            Object name = objectHashMap.get("name");
            Object isGift = objectHashMap.get("isGift");
            if (isGift != null && name != null) {
                if (isGift.toString().equals("1")) {
                    String s = name.toString() + "(送)";
                    objectHashMap.put("name", s);
                    //计算精品划分后的价格
                    objectHashMap.put("thisNumByPrice", 0);
                } else {
                    //计算精品划分后的价格
                    objectHashMap.put("thisNumByPrice", CalculateUtils.boutiquePrice(bigDecimal, bigDecimalSaleCount, bigDecimalApplyCount));
                }
            } else {
                //计算精品划分后的价格
                objectHashMap.put("thisNumByPrice", CalculateUtils.boutiquePrice(bigDecimal, bigDecimalSaleCount, bigDecimalApplyCount));
            }

            objectHashMap.put("thisNum", bigDecimal);
            //合计
            boutiqueSum = boutiqueSum.add(bigDecimal);


            //判断是精品礼包
            Object is_package = stringObjectMap.get("is_package");
            if (is_package != null) {
                String pId = is_package.toString();
                if (pId.equals("1")) {
                    Integer integer = Integer.valueOf(stringObjectMap.get("pack_id").toString());
                    objectHashMap.put("packName", stringObjectMap.get("packName"));
                    objectHashMap.put("pack_id", stringObjectMap.get("pack_id"));
                    if (!packIdList.contains(integer)) {
                        packIdList.add(integer);
                        //如果是新的礼包。将boutiquePackSum清空
                        boutiquePackSum = new BigDecimal(0);
                    }
                    //礼包合计
                    boutiquePackSum = boutiquePackSum.add(bigDecimal);
                    boutiquePackSumMap.put(integer, boutiquePackSum);
                    packMapList.add(objectHashMap);
                } else {
                    mapList.add(objectHashMap);
                }
            } else {
                mapList.add(objectHashMap);
            }
        }
        for (Integer integer : packIdList) {
            Map<String, Object> objectHashMap = new HashMap<>();
            //获取礼包销售价格
            BoutiquePackage boutiquePackage = boutiquePackageService.selectByPrimaryKey(integer);
            BigDecimal packSalveValue = boutiquePackage.getSalveValue();
            objectHashMap.put("thisNum", packSalveValue);
            //获取礼包的报价
            BigDecimal packApplyValue = new BigDecimal(0);
            packApplyValue = CalculateUtils.boutiquePrice(bigDecimalApplyCount, bigDecimalSaleCount, packSalveValue);
            //礼包的合计
            String string = boutiquePackSumMap.get(integer) != null ? boutiquePackSumMap.get(integer).toString() : "0";
            BigDecimal packSaleValueSum = new BigDecimal(string);

            List<Map<String, Object>> packMapList2 = new ArrayList<Map<String, Object>>();
            BigDecimal bigDecimal = new BigDecimal(0);
            for (Map<String, Object> stringObjectMap : packMapList) {
                Object pack_id = stringObjectMap.get("pack_id");
                if (pack_id != null) {
                    Integer integer1 = Integer.valueOf(pack_id.toString());
                    if (integer == integer1) {
                        objectHashMap.put("num", stringObjectMap.get("num"));
                        objectHashMap.put("name", stringObjectMap.get("packName"));
                        objectHashMap.put("pack_id", stringObjectMap.get("pack_id"));
                        //计算礼包中精品划分后的价格
                        BigDecimal bPsaleValue = new BigDecimal(stringObjectMap.get("thisNum").toString());
                        //如果礼包是赠送的。价格划分为0
                        Boolean isGift = stringObjectMap.get("isGift") != null ? stringObjectMap.get("isGift").toString().equals("1") : false;
                        if (isGift) {
                            stringObjectMap.put("thisNumByPrice", 0);
                        } else {
                            stringObjectMap.put("thisNumByPrice", CalculateUtils.boutiquePrice(bPsaleValue, packSaleValueSum, packApplyValue));
                        }
                        Object tn = stringObjectMap.get("thisNum");
                        if (tn != null) {
                            BigDecimal bigDecimal1 = new BigDecimal(tn.toString());
                            bigDecimal = bigDecimal.add(bigDecimal1);
                        }
                        packMapList2.add(stringObjectMap);
                    }
                }
            }

            objectHashMap.put("packS", packMapList2);
            mapList.add(objectHashMap);
        }
        //订单销售合计
        Object sale_count = objectMap.get("sale_count");
        Object apply_count = objectMap.get("apply_count");
        if (sale_count != null) {
            BigDecimal decimal = new BigDecimal(apply_count.toString());
            BigDecimal bigDecimal = new BigDecimal(sale_count.toString());
            //毛利合计
            objectMap.put("maori", decimal.subtract(taxCostSum));
            //折扣率
            BigDecimal df = new BigDecimal("100");
            if (apply_count != null) {
                if (decimal.compareTo(BigDecimal.ZERO) == 1 && bigDecimal.compareTo(BigDecimal.ZERO) == 1) {
                    String marginProgress = decimal.divide(bigDecimal, 4, BigDecimal.ROUND_HALF_DOWN).multiply(df).setScale(2) + "%";
                    objectMap.put("discountRate", marginProgress);
                } else {
                    objectMap.put("discountRate", "0.00%");
                }
            } else {
                objectMap.put("discountRate", "0.00%");
            }
        }
        //转换订单类型
        Object type = objectMap.get("type");
        if (type != null) {
            Integer s = Integer.valueOf(type.toString());
            BoutiqueEnum.BoutiqueType[] values = BoutiqueEnum.BoutiqueType.values();
            String reason = values[s].getReason();
            objectMap.put("type", reason);
        }

        //精品详情
        hashMap.put("boutiqueList", mapList);
        map.put("objectMap", objectMap);
        map.put("hashMap", hashMap);
        map.put("retailId", retailId);
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "精品库存列表-分页（包括精品单项和首页库存）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "type", value = "0安全库存，1在库天数-非安全库存", required = false, dataType = "integer"),
            @ApiImplicitParam(name = "name", value = "精品名字查询", required = false, dataType = "String"),
            @ApiImplicitParam(name = "boutiqueSupplierId", value = "供应商id", required = false, dataType = "integer"),
            @ApiImplicitParam(name = "boutiqueWarehouseId", value = "仓库id", required = false, dataType = "integer"),
            @ApiImplicitParam(name = "stratTime", value = "精品库存查询开始时间 yyyy-MM-dd", required = false, dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "精品库存查询结束时间 yyyy-MM-dd", required = false, dataType = "String")
    })
    @RequestMapping(value = "/boutiqueStockList", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo boutiqueStockList(HttpServletRequest request, Integer pageNum, Integer pageSize, Integer
            type,
                                           String name, Integer boutiqueSupplierId, Integer boutiqueWarehouseId, String stratTime, String endTime) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        //仓库下拉
        List<BoutiqueWarehouse> boutiqueWarehouses = new ArrayList<>();
        List<BoutiqueWarehouse> all = boutiqueWarehouseService.findAll(emp.getStoreId());
        BoutiqueWarehouse boutiqueWarehouse = new BoutiqueWarehouse();
        boutiqueWarehouse.setId(0);
        boutiqueWarehouse.setName("默认");
        boutiqueWarehouses.add(0, boutiqueWarehouse);
        boutiqueWarehouses.addAll(all);
        map.put("warehouseList", boutiqueWarehouses == null ? "" : boutiqueWarehouses);
        //供应商下拉
        Page<Map<String, Object>> maps1 = new Page<>();
        String name2 = new String();
        Page<Map<String, Object>> maps = boutiqueSupplierService.selectSupplier(name2, emp.getStoreId());
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", 0);
        map2.put("name", "默认");
        maps1.add(0, map2);
        maps1.addAll(maps);
        map.put("supplierList", maps1 == null ? "" : maps1);

        //列表
        Map<String, Object> StockMap = new HashMap<String, Object>();
        StockMap.put("storeId", emp.getStoreId());
        //安全库存
        StockMap.put("bl", type);
        //1是0否上下架
        StockMap.put("status", 1);
        StockMap.put("name", name);
        StockMap.put("boutiqueSupplierId", boutiqueSupplierId);
        StockMap.put("boutiqueWarehouseId", boutiqueWarehouseId);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (stratTime != null && stratTime != "") {
                Date s1 = sdf.parse(stratTime);
                StockMap.put("stratTime", s1);
            }
            if (endTime != null && endTime != "") {
                Date d1 = sdf.parse(endTime);
                StockMap.put("endTime", d1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> information = boutiqueInformationService.selectBoutiqueStockByStoreId(StockMap);
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(information);
        map.put("list", pageInfo.getList());
        map.put("pageResult", getPageResult(pageInfo));
        map.put("sum", information.size());
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "精品库存列表-礼包项-分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "name", value = "精品礼包名字查询", required = false, dataType = "String")
    })
    @RequestMapping(value = "/selectBoutiquePackageList", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectBoutiquePackageList(HttpServletRequest request, Integer pageNum, Integer
            pageSize, String name) {
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        //封装分页信息
        PageInfo pageInfo = boutiquePackageService.selectBoutiquePackageByName(pageNum, pageSize, emp.getStoreId(), name);
        map.put("list", pageInfo.getList());
        map.put("pageResult", getPageResult(pageInfo));
        map.put("sum", pageInfo.getList().size());
        ari.setData(map);
        return ari;
    }


    @ApiOperation(value = "精品排程-洗车列表-日度明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "date", value = "日期(年月 yyyy-MM-dd)", required = true, dataType = "String")
    })
    @RequestMapping(value = "/selectDayCarWashList", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectDayCarWashList(HttpServletRequest request, Integer pageNum, Integer pageSize, String
            date) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> StockMap = new HashMap<String, Object>();
        StockMap.put("storeId", emp.getStoreId());
        Date date1 = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date1 = sdf.parse(date);
            StockMap.put("applyTime", date1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> information = appCarWashService.selectCarWashList(StockMap);
        //当日申请洗车数
        CarWash carWash = new CarWash();
        carWash.setApplyTime(date1);
        carWash.setStoreId(emp.getStoreId());
        int sum = appCarWashService.countByToDay(carWash);
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(information);
        map.put("list", pageInfo.getList());
        map.put("pageResult", getPageResult(pageInfo));
        map.put("sum", sum);
        //当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        map.put("toDay", sdf.format(new Date()));
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "精品排程-洗车列表-月度明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "date", value = "日期(年月 yyyy-MM)", required = true, dataType = "String")
    })
    @RequestMapping(value = "/selectMouthCarWashList", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectMouthCarWashList(HttpServletRequest request, String date) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            Map<String, Object> StockMap = new HashMap<String, Object>();
            StockMap.put("storeId", emp.getStoreId());
            String toDayStr = "";
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                Date date1 = sdf.parse(date);
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                toDayStr = sdf2.format(new Date());
                StockMap.put("mouthApplyTime", date1);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //当日申请洗车数量
            Map<String, Object> StockMap2 = new HashMap<String, Object>();
            StockMap2.put("storeId", emp.getStoreId());
            StockMap2.put("applyTime", new Date());
            StockMap2.put("state", CarEnum.CarWashStates.FINISHED.getCode());
            String mouthCount3 = "";
            List<Map<String, Object>> mouthCount2 = appCarWashService.selectCarWashList(StockMap2);
            if (mouthCount2 != null && mouthCount2.size() > 0) {
                //当天完成数
                Object s = mouthCount2.get(0) != null ? mouthCount2.get(0).get("s") : "0";
                mouthCount3 = s != null ? s.toString() : "0";
            }

            //完成洗车的
            StockMap.put("state", CarEnum.CarWashStates.FINISHED.getCode());
            List<Map<String, Object>> information = appCarWashService.selectMouthCarWashSum(StockMap);
            Float mouthCount = 0f;
            if (information != null && information.size() > 0) {
                for (Map<String, Object> m : information) {
                    Object count = m.get("s");
                    if (count != null) {
                        mouthCount += Float.valueOf(count.toString());
                    }
                    Object t = m.get("t");
                    if (t != null) {
                        if (toDayStr.equals(t.toString())) {
                            m.put("h", mouthCount3);
                        }
                    }
                }
            }


            //遍历获取当月所有日期
            List<Map<String, Object>> list2 = new ArrayList<>();
            Calendar c = Calendar.getInstance();
            int year = Integer.valueOf(date.substring(0, 4).toString());
            int mouth = Integer.valueOf(date.substring(5, 7).toString());
            String mouthStr = mouth < 10 ? "0" + mouth : mouth + "";
            c.set(year, mouth - 1, 1);
            int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int x = 1; x <= lastDay; x++) {
                //日期
                String xStr2 = x < 10 ? "0" + x : x + "";
                String xStr = year + "-" + mouthStr + "-" + xStr2;

                boolean bl = true;
                //遍历已有的数据
                for (Map<String, Object> objectMap : information) {
                    Object t = objectMap.get("t");
                    if (t != null) {
                        if (t.toString().equals(xStr)) {
                            list2.add(objectMap);
                            bl = false;
                            break;
                        }
                    }
                }
                if (bl) {
                    Map<String, Object> map2 = new HashMap<String, Object>();
                    map2.put("s", "0");
                    map2.put("t", xStr);
                    list2.add(map2);
                }
            }
            map.put("list", list2);
            map.put("mouthCount", mouthCount);
            //当前日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            map.put("toDay", sdf.format(new Date()));
            ar.setData(map);
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }

        return ar;
    }


    @ApiOperation(value = "精品排程-精品加装列表-日度明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "date", value = "日期", required = true, dataType = "String")
    })
    @RequestMapping(value = "/selectDayProjectSum", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectDayProjectSum(HttpServletRequest request, Integer pageNum, Integer pageSize, String
            date) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> StockMap = new HashMap<String, Object>();
        StockMap.put("storeId", emp.getStoreId());
        //精品app加装排程，只来自销售单
        StockMap.put("source", 0);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (date != null && date != "") {
                Date date1 = sdf.parse(date);
                StockMap.put("dayTime", date1);
            } else {
                StockMap.put("dayTime", new Date());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        //状态等于0和大于0精品排程
        StockMap.put("status", BoutiqueEnum.IntsallType.NO.getCode());
        List<Map<String, Object>> information = boutiqueInstallProjectService.selectMouthProjectSum(StockMap);
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(information);
        map.put("list", pageInfo.getList());
        map.put("pageResult", getPageResult(pageInfo));
        map.put("sum", information.size());
        //当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        map.put("toDay", sdf.format(new Date()));
        ar.setData(map);
        return ar;
    }

    @ApiOperation(value = "精品排程-精品加装列表-精品加装详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "精品排程id", required = true, dataType = "Interger")
    })
    @RequestMapping(value = "/selectDayProjectDetail", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectDayProjectDetail(HttpServletRequest request, Integer id) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> StockMap = new HashMap<String, Object>();
        StockMap.put("id", id);
        Map<String, Object> hashMap = new HashMap<String, Object>();
        //排程详情
        List<Map<String, Object>> information = boutiqueInstallProjectService.selectBoutiqueInstallDetail(StockMap);
        if (information != null && information.size() > 0) {
            Map<String, Object> objectMap = information.get(0);
            if (objectMap != null) {
                Object actual_delivery = objectMap.get("actual_delivery");
                objectMap.put("actual_delivery", actual_delivery == null ? "" : actual_delivery.toString().substring(0, 19));
                Object begin = objectMap.get("BEGIN");
                objectMap.put("begin", begin == null ? "" : begin.toString().substring(0, 19));
                Object hours = objectMap.get("hours");
                objectMap.put("hours", hours == null ? "" : hours + "H");
            }
            map.put("objectMap", objectMap);
        }

        //精品施工项目集合
        /*查询小于不施工的节点
        * 施工节点（ 1 - 交车前 ； 2 - 交车后 ； 3 - 不施工）
        * */
        StockMap.put("constructionNode", 3);
        List<Map<String, Object>> mapList = boutiqueInstallProjectService.selectBoutiqueProjectDetail(StockMap);
        hashMap.put("mapList", mapList);
        Float workinghours = 0f;
        Float expect_workinghours = 0f;
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> objectMap : mapList) {
                Object o1 = objectMap.get("workinghours");
                Object o2 = objectMap.get("expect_workinghours");
                if (o1 != null) {
                    workinghours += Float.valueOf(o1.toString());
                }
                if (o2 != null) {
                    expect_workinghours += Float.valueOf(o2.toString());
                }
            }
            //标准格式合计
            hashMap.put("workinghours", workinghours);
            //预计完成时间合计
            hashMap.put("expect_workinghours", expect_workinghours);
        }
        map.put("hashMap", hashMap);
        ar.setData(map);
        return ar;
    }


    @ApiOperation(value = "精品排程-精品加装列表-月度明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "date", value = "日期(年月 yyyy-MM)", required = true, dataType = "String")

    })
    @RequestMapping(value = "/selectMouthProjectSum", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectMouthProjectSum(HttpServletRequest request, String date) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            Map<String, Object> StockMap = new HashMap<String, Object>();
            StockMap.put("storeId", emp.getStoreId());
            //精品app加装排程，只来自销售单
            StockMap.put("source", 0);
            try {
                if (date != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                    Date date1 = sdf.parse(date);
                    StockMap.put("mouthTime", date1);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //已经完成的精品加装
            List<Map<String, Object>> information = boutiqueInstallProjectService.selectMouthProjectGroupDaySum(StockMap);
            Float toDayCount = 0f;
            if (information != null && information.size() > 0) {
                for (Map<String, Object> m : information) {
                    //总工时
                    Object count = m.get("workinghours_use");
                    if (count != null) {
                        toDayCount += Float.valueOf(count.toString());
                    }

                    //预计工时去掉小数点
                /*Object workinghours = m.get("workinghours");
                if (workinghours != null) {
                    int i = workinghours.toString().indexOf(".");
                    if (i > 0) {
                        String substring = workinghours.toString().substring(0, i);
                        m.put("workinghours", substring + "H");
                    }
                }*/
                    //预计工时
                    Object workinghours = m.get("workinghours");
                    m.put("workinghours", workinghours == null ? "" : workinghours.toString() + "H");
                    //实际时长
                    Object workinghours_use = m.get("workinghours_use");
                    m.put("workinghours_use", workinghours_use == null ? "" : workinghours_use.toString() + "H");
                }
            }
            //遍历获取当月所有日期
            List<Map<String, Object>> list2 = new ArrayList<>();
            Calendar c = Calendar.getInstance();
            int year = Integer.valueOf(date.substring(0, 4).toString());
            int mouth = Integer.valueOf(date.substring(5, 7).toString());
            String mouthStr = mouth < 10 ? "0" + mouth : mouth + "";
            c.set(year, mouth - 1, 1);
            int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int x = 1; x <= lastDay; x++) {
                //日期
                String xStr2 = x < 10 ? "0" + x : x + "";
                String xStr = year + "-" + mouthStr + "-" + xStr2;

                boolean bl = true;
                //遍历已有的数据
                for (Map<String, Object> objectMap : information) {
                    Object t = objectMap.get("t");
                    if (t != null) {
                        if (t.toString().equals(xStr)) {
                            list2.add(objectMap);
                            bl = false;
                            break;
                        }
                    }
                }
                if (bl) {
                    Map<String, Object> map2 = new HashMap<String, Object>();
                    map2.put("workinghours", "0H");
                    map2.put("workinghours_use", "0H");
                    map2.put("s", "0");
                    map2.put("t", xStr);
                    list2.add(map2);
                }
            }

            //封装分页信息
            map.put("list", list2);
            map.put("toDayCount", toDayCount);
            //当前日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            map.put("toDay", sdf.format(new Date()));
            ar.setData(map);
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;
    }

    @ApiOperation(value = "精品排程-精品加装列表-施工安排")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "排程号", required = true, dataType = "Interger"),
            @ApiImplicitParam(name = "date", value = "安排施工时间", required = true, dataType = "String")
    })
    @RequestMapping(value = "/construction", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo construction(HttpServletRequest request, Integer id, String date) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        BoutiqueInstallExample installExample = new BoutiqueInstallExample();
        BoutiqueInstallExample.Criteria criteria = installExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<BoutiqueInstall> boutiqueInstalls = boutiqueInstallService.selectByExample(installExample);
        BoutiqueInstall boutiqueInstall = new BoutiqueInstall();
        if (boutiqueInstalls != null && boutiqueInstalls.size() > 0) {
            boutiqueInstall = boutiqueInstalls.get(0);
            //生成精品出库数据
//            boutiqueRetailService.createOutboundByInstallId(boutiqueInstall.getId());
        }
        //未分配更新为未开始
        boutiqueInstall.setStatus(BoutiqueEnum.IntsallType.NOT.getCode());
        //设置安排施工时间
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(date);
            boutiqueInstall.setExpectedComplete(date1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        boutiqueInstall.setTimestamp(new Date());
        int i = boutiqueInstallService.updateByPrimaryKeySelective(boutiqueInstall);
        if (i < 1) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;
    }


    @ApiOperation(value = "精品App-我的-目标设定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "年份", required = true, dataType = "String")
    })
    @RequestMapping(value = "/selectBoutiqueTargetSum", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectBoutiqueTargetSum(HttpServletRequest request, Integer id, String date) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("storeId", emp.getStoreId());
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date1 = sdf.parse(date);
            map.put("date", date1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        List<BoutiqueTarget> boutiqueTargets = boutiqueTargetService.selectBoutiqueTargetSum(map);
        ar.setData(boutiqueTargets);
        return ar;
    }


    @ApiOperation(value = "精品App-我的-目标设定-编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "目标id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "groupId", value = "部门id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "income_play", value = "收入计划", required = true, dataType = "Double"),
            @ApiImplicitParam(name = "profit_play", value = "毛利计划", required = true, dataType = "Double"),
    })
    @RequestMapping(value = "/selectBoutiqueTargetEdit", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectBoutiqueTargetEdit(HttpServletRequest request, Integer id, Integer groupId, Double
            income_play, Double profit_play) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();

        BoutiqueTarget boutiqueTarget = new BoutiqueTarget();
        boutiqueTarget.setId(id);
        boutiqueTarget.setIncomePlay(BigDecimal.valueOf(income_play));
        boutiqueTarget.setProfitPlay(BigDecimal.valueOf(profit_play));
        boutiqueTarget.setStoreId(emp.getStoreId());
        boutiqueTarget.setDate(new Date());
        boutiqueTarget.setEmployeeGroupId(groupId);
        boutiqueTarget.setTypeLive(BoutiqueEnum.DataStatus.NORMAL.getCode());
        int i = 0;
        int i1 = 0;
        if (id != null) {
            BoutiqueTargetExample boutiqueTargetExample = new BoutiqueTargetExample();
            BoutiqueTargetExample.Criteria criteria = boutiqueTargetExample.createCriteria();
            criteria.andIdEqualTo(id);
            List<BoutiqueTarget> boutiqueTargets = boutiqueTargetService.selectByExample(boutiqueTargetExample);
            if (boutiqueTargets != null && boutiqueTargets.size() > 0) {
                i = boutiqueTargetService.updateByPrimaryKeySelective(boutiqueTarget);
            }
        } else {
            i1 = boutiqueTargetService.insertSelective(boutiqueTarget);
        }
        if (i < 1 || i1 < 1) {
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;
    }

    @ApiOperation(value = "精品审批-审批通过后-价格划分")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", value = "(id：value Map集合)", required = false, dataType = "Stirng"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "retailId", value = "精品订单id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/getBoutiqueRRByPrice", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo getBoutiqueRRByPrice(HttpServletRequest request, String data) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        try {
            Integer orderId = 0;
            Integer retailId = 0;
            JSONArray objects = JSONArray.parseArray(data);
            if (objects != null && objects.size() > 0) {
                Map<String, Object> o = (Map<String, Object>) objects.get(0);
                Object orderId1 = o.get("orderId");
                if (orderId1 != null) {
                    orderId = Integer.valueOf(orderId1.toString());
                }
                Object retailId2 = o.get("retailId");
                if (retailId2 != null) {
                    retailId = Integer.valueOf(retailId2.toString());
                }
            }
            int n = 0;
            for (Object object : objects) {
                Map<String, Object> map = (Map<String, Object>) object;
                Object id = map.get("id");
                Object code = map.get("code");
                if (code != null && id != null) {
                    //更新精品订单详情表的价格划分字段
                    BoutiqueRetailInclude boutiqueRetailInclude = new BoutiqueRetailInclude();
                    boutiqueRetailInclude.setId(Integer.valueOf(id.toString()));
                    BigDecimal bigDecimal = new BigDecimal(code.toString());
                    boutiqueRetailInclude.setDivisionValue(bigDecimal);
                    int i = boutiqueRetailIncludeService.updateByPrimaryKeySelective(boutiqueRetailInclude);
                    n += i;
                    if (i < 1) {
                        ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                        ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
                    }
                }
            }
            if (n == objects.size()) {
                BoutiqueRetailRecordExample example = new BoutiqueRetailRecordExample();
                BoutiqueRetailRecordExample.Criteria criteria = example.createCriteria();
                criteria.andRetailIdEqualTo(retailId);
                criteria.andOrderIdEqualTo(orderId);
                criteria.andStoreIdEqualTo(emp.getStoreId());
                List<BoutiqueRetailRecord> boutiqueRetailRecords = boutiqueRetailRecordService.selectByExample(example);
                //设置更新价格已划分字段
                for (BoutiqueRetailRecord boutiqueRetailRecord : boutiqueRetailRecords) {
                    boutiqueRetailRecord.setIsDivision(1);
                    boutiqueRetailRecord.setTimeStamp(new Date());
                    int i1 = boutiqueRetailRecordService.updateByPrimaryKeySelective(boutiqueRetailRecord);
                }
            } else {
                ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;
    }

    @ApiOperation(value = "删除精品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "informationId", value = "精品或礼包id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "isPackage", value = "0:精品id 1:礼包id", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = false, dataType = "Integer")
    })
    @RequestMapping(value = "/deleteBoutique", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo deleteBoutique(HttpServletRequest request, Integer informationId, Integer
            isPackage, Integer orderId) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> params = new HashMap<String, Object>();
        //封装参数
        if (isPackage == 1) {
            params.put("packId", informationId);
        } else {
            params.put("informationId", informationId);
        }
        params.put("isPackage", isPackage);
        params.put("orderId", orderId);
        int res = boutiqueRetailService.deleteBoutiqueRetail(params);
        if (res > 0) {
            orderService.calcUpdateOrderAmount(orderId);
        }
        ari.setData(res);
        return ari;
    }

    @ApiOperation(value = "查询已加入订单的精品礼包明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "retailId", value = "精品订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "packageId", value = "礼包id", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = false, dataType = "Integer")
    })
    @RequestMapping(value = "/getOrderBoutiquePackageDetail", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo getOrderBoutiquePackageDetail(HttpServletRequest request, Integer retailId, Integer
            packageId, Integer orderId) {
        ApiReturnInfo ari = new ApiReturnInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        //礼包信息
        BoutiquePackage bPackage = boutiquePackageService.selectByPrimaryKey(packageId);
        map.put("id", bPackage != null ? bPackage.getId() : "");
        map.put("name", bPackage != null ? bPackage.getName() : "");
        map.put("salveValue", bPackage != null ? bPackage.getSalveValue() : "");
        map.put("picture", bPackage != null ? uploadAccessPath + bPackage.getPicture() : "");
        //礼包明细信息
        List<Map<String, Object>> list = boutiqueRetailIncludeService.selectOrderBoutiquePackageDetail(orderId, retailId, packageId);
        map.put("detailList", list);
        map.put("isGift", list != null ? list.get(0).get("isGift") : 0);
        ari.setData(map);
        return ari;
    }

    @ApiOperation(value = "查询已加入订单的精品详细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "retailId", value = "精品订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "boutiqueId", value = "精品id", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "orderId", value = "订单id", required = false, dataType = "Integer")
    })
    @RequestMapping(value = "/getOrderBoutiqueDetail", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo getOrderBoutiqueDetail(HttpServletRequest request, Integer retailId, Integer
            boutiqueId, Integer orderId) {
        ApiReturnInfo ari = new ApiReturnInfo();
        //查询精品明细
        Map<String, Object> map = boutiqueRetailIncludeService.selectOrderBoutiqueDetail(orderId, retailId, boutiqueId);
        ari.setData(map);
        return ari;
    }

    @ApiOperation(value = "精品审批-审批通过")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "retailId", value = "精品订单id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/boutiqueApprovalPass", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo boutiqueApprovalPass(HttpServletRequest request, Integer orderId, Integer retailId) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        try {
            //更新精品历史记录精品订单详情表价格划分字段
            BoutiqueRetailRecord boutiqueRetailRecord1 = new BoutiqueRetailRecord();
            boutiqueRetailRecord1.setOrderId(orderId);
            boutiqueRetailRecord1.setRetailId(retailId);
            boutiqueRetailRecord1.setTimeStamp(new Date());
            boutiqueRetailRecord1.setEmployeeId(emp.getId());
            boutiqueRetailRecord1.setStoreId(emp.getStoreId());
            boutiqueRetailRecord1.setCreateId(emp.getId());
            //审批通过2
            boutiqueRetailRecord1.setType(BoutiqueEnum.BoutiqueRetailRecordType.EARNEST_WAIT.getCode());
            //审批记录表插入数据
            int i = boutiqueRetailRecordService.insertSelective(boutiqueRetailRecord1);

            //更新精品订单表
            BoutiqueRetail boutiqueRetail = new BoutiqueRetail();
            boutiqueRetail.setOrderId(orderId);
            boutiqueRetail.setId(retailId);
            //设置精品订单审批状态为通过
            boutiqueRetail.setType(BoutiqueEnum.BoutiqueType.EARNEST_WAIT.getCode());
            int i2 = boutiqueRetailService.updateByPrimaryKeySelective(boutiqueRetail);

            //查询订单审批
            Map<String, Object> approvalOrderMap = new HashMap<String, Object>();
            //订单审批类型 1:订单审批 2:退订审批',
            approvalOrderMap.put("approvalType", OrderEnum.ApprovalOrderType.ORDER.getCode());
            approvalOrderMap.put("orderId", orderId);
            List<ApprovalOrder> approvalOrders = approvalOrderService.selectByOrderId(approvalOrderMap);
            int i3 = 0;
            int i5 = 0;
            //精品订单客户姓名
            String customerName = "";
            ApprovalOrder approvalOrder = new ApprovalOrder();
            if (approvalOrders != null && approvalOrders.size() > 0) {
                //更新 订单审批表
                approvalOrder = approvalOrders.get(0);
                approvalOrder.setBoutiqueApproveId(emp.getId());
                //精品经理审批结果
                approvalOrder.setBoutiqueApprovalResult(1);
                approvalOrder.setBoutiqueApprovalTime(new Date());
                //精品经理是否审批 0否1是
                approvalOrder.setIfBoutiqueApproval(1);
                i3 = approvalOrderService.updateByPrimaryKeySelective(approvalOrder);

                //精品审批表id
                Integer id1 = approvalOrders.get(0).getId();
                //判断订单审批表，4个状态是否已经都满足，如果满足更新order状态表
                boolean b = approvalOrderService.ifPass(id1);
                if (b) {
                    approvalOrder.setApprovalStatus(OrderEnum.approvalStatus.APPROVAL_REFUSE.getCode());
                    int i4 = approvalOrderService.updateByPrimaryKeySelective(approvalOrder);
                }

                Order order = orderService.selectOrderbyId(orderId);
                //客户名字
                customerName = order != null ? order.getCusName() : "";
                order.setId(orderId);
                //订单状态
//                    order.setStatus(SettleEnum.OrderStatus.EFFECTIVE.getCode());
                //车辆价格审批状态 0：未提交 1：审批中 2:已通过 3：已驳回
//                order.setCarPriceStatus(2);
                //精品价格审批状态 0:默认未提交 1：审批中 2：不通过 3：通过
                order.setBoutiquePriceStatus(3);
                //精品状态
                i5 = orderService.updateByPrimaryKeySelective(order);
                //如果订单审批通过，更新客户状态由潜客变为订单
//                    Customer customer = new Customer();
//                    customer.setId(cusId);
//                    //客户分类设置为订单
//                    customer.setCategory(CustomerEnum.CustomerCategory.ORDER_CUS.getCode());
//                    customer.setModifyTime(new Date());
//                    int i5 = customerService.updateByPrimaryKeySelective(customer);
            }
            if (i3 < 1 || i5 < 1 || i < 1 || i2 < 1) {
                ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
            } else {
                //推送消息创建
                Map<String, Object> mapc = new HashMap<>();
                mapc.put("storeId", emp.getStoreId());
                ArrayList<String> strings = new ArrayList<>();
                strings.add(FINANCIAL_MANAGER);
                strings.add(BOUTIQUE_INFORMATION_OFFICER);
                //销售顾问
                mapc.put("postNameList", strings);
                //精品审批通过推送标识
                mapc.put("n", 5);
                List<Map<String, Object>> mapList = appEmployeeService.selectEmployeIdByPostName(mapc);
                //推送销售顾问自己的url设置
                Map<String, Object> map = new HashMap<>();
                map.put("urlId", PushEnum.UrlWeb.ORDER_SALE_BOUTIQUE_PASS.getCode());
                map.put("employeeId", approvalOrder.getEmployeeId());
                map.put("terminal", 2);
                mapList.add(map);
                String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_BOUTIQUEPASS);
                content = content.replace("XXX", customerName);
                Order order = orderService.selectOrderbyId(orderId);
                content = content.replace("YYY", order != null ? order.getOrderNum().toString() : "");
                pushMessageService.createPushMessage(PushEnum.PushType.ORDER_BOUTIQUE_PASS.getCode(), PushEnum.PushType.ORDER_BOUTIQUE_PASS.getDesc(), content, emp.getId(), mapList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;
    }

    @ApiOperation(value = "精品审批-审批不通过")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "retailId", value = "精品订单id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "reason", value = "不通过原因", required = true, dataType = "String")
    })
    @RequestMapping(value = "/boutiqueApprovalNoPass", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo boutiqueApprovalNoPass(HttpServletRequest request, Integer orderId, Integer
            retailId, String reason) {
        //当前用户
        Employee emp = getMember(request);
        ApiReturnInfo ar = new ApiReturnInfo();
        try {
            //更新精品单品，精品订单详情表价格划分字段
            BoutiqueRetailRecord boutiqueRetailRecord1 = new BoutiqueRetailRecord();
            boutiqueRetailRecord1.setOrderId(orderId);
            boutiqueRetailRecord1.setRetailId(retailId);
            boutiqueRetailRecord1.setTimeStamp(new Date());
            boutiqueRetailRecord1.setEmployeeId(emp.getId());
            boutiqueRetailRecord1.setNote(reason);
            boutiqueRetailRecord1.setStoreId(emp.getStoreId());
            boutiqueRetailRecord1.setCreateId(emp.getId());
            //审批不通过
            boutiqueRetailRecord1.setType(BoutiqueEnum.BoutiqueRetailRecordType.APPROVAL_REFUSE.getCode());
            //审批记录表插入数据
            int i = boutiqueRetailRecordService.insertSelective(boutiqueRetailRecord1);

            //更新精品订单表
            BoutiqueRetail boutiqueRetail = new BoutiqueRetail();
            boutiqueRetail.setOrderId(orderId);
            boutiqueRetail.setId(retailId);
            //设置精品订单审批状态为不通过
            boutiqueRetail.setType(BoutiqueEnum.BoutiqueType.APPROVAL_REFUSE.getCode());
            int i2 = boutiqueRetailService.updateByPrimaryKeySelective(boutiqueRetail);

            Order order = orderService.selectOrderbyId(orderId);
            //精品价格审批状态 0:默认未提交 1：审批中 2：不通过 3：通过
            order.setBoutiquePriceStatus(2);
            int i1 = orderService.updateByPrimaryKeySelective(order);

            //查询订单审批
            Map<String, Object> approvalOrderMap = new HashMap<String, Object>();
            //订单审批类型 1:订单审批 2:退订审批',
            approvalOrderMap.put("approvalType", OrderEnum.ApprovalOrderType.ORDER.getCode());
            approvalOrderMap.put("orderId", orderId);
            List<ApprovalOrder> approvalOrders = approvalOrderService.selectByOrderId(approvalOrderMap);
            int i3 = 0;
            ApprovalOrder approvalOrder = new ApprovalOrder();
            if (approvalOrders != null && approvalOrders.size() > 0) {
                approvalOrder = approvalOrders.get(0);
                //更新 订单审批表的精品审批结果
                approvalOrder.setBoutiqueApproveId(emp.getId());
                approvalOrder.setBoutiqueApproveId(2);
                //精品经理审批结果，1是2否
                approvalOrder.setBoutiqueApprovalResult(2);
                approvalOrder.setBoutiqueApprovalTime(new Date());
                //精品经理是否审批 1是2否
                approvalOrder.setIfBoutiqueApproval(2);
                i3 = approvalOrderService.updateByPrimaryKeySelective(approvalOrder);
            }
            if (i < 1 || i1 < 1 || i2 < 1 || i3 < 1) {
                ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
                ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
            } else {
                //推送消息创建
                List<Map<String, Object>> mapList = new ArrayList<>();
                //推送销售顾问自己的url设置
                Map<String, Object> map = new HashMap<>();
                map.put("urlId", PushEnum.UrlWeb.ORDER_SALE_BOUTIQUE_REJECT.getCode());
                map.put("employeeId", approvalOrder.getEmployeeId());
                map.put("terminal", 2);
                mapList.add(map);
                String content2 = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_BOUTIQUEREJECT);
                //精品订单客户姓名
                String customerName = order != null ? order.getCusName() : "";
                content2 = content2.replace("XXX", customerName);
                content2 = content2.replace("YYY", order != null ? order.getOrderNum().toString() : "");
                pushMessageService.createPushMessage(PushEnum.PushType.ORDER_BOUTIQUE_REJECT.getCode(), PushEnum.PushType.ORDER_BOUTIQUE_REJECT.getDesc(), content2, emp.getId(), mapList);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
        }
        return ar;
    }

    @ApiOperation(value = "精品-获取日期")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "（0月份，1天数）", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/getBoutiqueDate", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo getBoutiqueDate(Integer type) {
        ApiReturnInfo ar = new ApiReturnInfo();
        String[] strings = new String[]{"零月", "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String, Object>> maps = new ArrayList<>();
        if (type == 0) {
            Calendar cal = Calendar.getInstance();
            int month = 0;
            for (int i = -6; i <= 6; i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                Map<String, Object> map2 = new HashMap<String, Object>();
                month = cal.get(Calendar.MONTH) + i;
                int year = cal.get(Calendar.YEAR);
                if (month < 1) {
                    year--;
                    month += 12;
                    map.put("id", year + "-" + month);
                    map.put("code", strings[month]);
                }
                map.put("id", year + "-" + month);
                map.put("code", strings[month]);
                maps.add(map);
            }
        }
        ar.setData(maps);
        return ar;
    }
}