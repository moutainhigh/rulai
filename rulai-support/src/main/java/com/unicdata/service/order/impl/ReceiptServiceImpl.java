package com.unicdata.service.order.impl;

import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.constant.CarEnum;
import com.unicdata.constant.PushEnum;
import com.unicdata.constant.SettleEnum;
import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.order.*;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.BoutiqueRetailInclude;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.order.*;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.RetailSupportService;
import com.unicdata.service.order.ReceiptService;
import com.unicdata.service.order.SaleOrderService;
import com.unicdata.service.policy.RebateProjectService;
import com.unicdata.service.system.EmployeeService;
import com.unicdata.util.DateUtil;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * Create by zhang
 */
@Service
@Transactional
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    private ReceiptMapper receiptMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CarGoodInfoMapper carGoodInfoMapper;
    @Autowired
    private RebateProjectService rebateProjectService;
    @Autowired
    private RetailSupportService boutiqueRetailService;
    @Autowired
    private OrderFinanceMapper orderFinanceMapper;
    @Autowired
    private OrderServiceMapper orderServiceMapper;
    @Autowired
    private OrderSetMealMapper orderSetMealMapper;
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OrderInsuranceMapper orderInsuranceMapper;
    @Autowired
    private OrderExtensionMapper orderExtensionMapper;

    //销售顾问
    @Value("${SALES_CONSULTANT_POSITION}")
    private String salesConsultantPosition;
    //销售经理
    @Value("${SALES_MANAGER_POSITION}")
    private String salesManagerPosition;
    //财务
    @Value("${FINANCE_POSITION}")
    private String financePosition;
    //保险专员
    @Value("${INSURANCE_SPECIALIST_POSITION}")
    private String insuranceSpecialistPosition;
    //金融专员
    @Value("${FINANCE_POSITION}")
    private String financialSpecialistPosition;
    //信息员
    @Value("${FINANCE_POSITION}")
    private String informationMemberPosition;
    //销售库管
    @Value("${STOREHOUSE}")
    private String storehouse;


    @Override
    public int insertReceipt(Receipt receipt) {
        return receiptMapper.insertSelective(receipt);
    }

    @Override
    public List selectReceipts(Receipt receipt) {
        return receiptMapper.selectReceiptByType(receipt);
    }

    @Override
    @Transactional(readOnly = true)
    public Map receiptDetail(Integer orderId) {
        Map<String, Object> receiptDetail = new HashMap<>();
        //获取订单基本信息
        Order order = orderMapper.selectByPrimaryKey(orderId);
        //获取定金付款信息
        List<Map> depositFinance = depositFinance(orderId);
        //获取尾款付款信息
        List<Map> carFinance = carFinance(orderId);
        //获取精品信息以及付款信息
        Receipt boutiqueFinance = new Receipt();
        List<Receipt> receipts = boutiqueFinance(orderId);
        if (receipts != null) {
            BigDecimal bigDecimal = new BigDecimal(0);
            for (Receipt receipt : receipts) {
                bigDecimal = bigDecimal.add(receipt.getAmount());
                receipt.setAmount(bigDecimal);
                boutiqueFinance = receipt;
            }
        }
        BoutiqueRetail boutiqueRetail = boutiqueRetailService.selectBoutiqueRetailDetailByOrderId(orderId);
        List<BoutiqueRetailInclude> boutiqueList = new ArrayList<>();
        BigDecimal applyCount = new BigDecimal(0);
        if (boutiqueRetail != null) {
            boutiqueList = boutiqueRetail.getList();
            applyCount = boutiqueRetail.getApplyCount();
        }
        //获取保险信息及付款情况
        List<Map> insuranceFinance = insuranceFinance(orderId);
        //获取延保信息及付款情况
        List<Map> extensionFinance = extensionFinance(orderId);
        //获取金融信息及付款情况
        List<Map> financeFinance = financeFinance(orderId);
        //获取其他服务及付款信息
        List<Map> serviceFinance = serviceFinance(orderId);
        //获取套餐付款信息
        List<Map> setMealReceipt = setMealReceipt(orderId);
        //获取代金券付款信息
        List<Map> couponReceipt = couponReceipt(orderId);

        //查询收款记录
        Receipt receiptPa = new Receipt();
        receiptPa.setOrderId(orderId);
        List<Receipt> receiptList = receiptMapper.selectReceiptByType(receiptPa);

        //封装前端需要的数据
        //封装定金付款信息
        ReceiptParam receiptDeposit = new ReceiptParam();
        BigDecimal depositDecimal = new BigDecimal(0);
        for (int i = 0; i < depositFinance.size(); i++) {
            Map deposit = depositFinance.get(i);
            BigDecimal payAmount = (BigDecimal) deposit.get("payAmount");
            depositDecimal = depositDecimal.add(payAmount);
            String busNo = deposit.get("busNo").toString();
            if (i == 0) {
                receiptDeposit.setBusNo(busNo);
                receiptDeposit.setReceiptType(Integer.parseInt(deposit.get("receiptType").toString()));
                receiptDeposit.setReceivable((BigDecimal) deposit.get("orderDeposit"));
            }
            receiptDeposit.setPayAmount(depositDecimal);
        }

        List<ReceiptParam> carFinanceList = new ArrayList<>();
        carFinanceList.add(receiptDeposit);
        //封装尾款付款信息
        if (financeFinance.size() == 0) {
            ReceiptParam receiptCar = new ReceiptParam();
            BigDecimal carDecimal = new BigDecimal(0);
            for (int i = 0; i < carFinance.size(); i++) {
                Map rest = carFinance.get(i);
                BigDecimal restPayAmount = (BigDecimal) rest.get("payAmount");
                carDecimal = carDecimal.add(restPayAmount);
                if (i == 0) {
                    receiptCar.setReceivable((BigDecimal) rest.get("restPrice"));
                    receiptCar.setBusNo(rest.get("busNo").toString());
                    receiptCar.setReceiptType(Integer.parseInt(rest.get("receiptType").toString()));
                }
                receiptCar.setPayAmount(carDecimal);
            }
            carFinanceList.add(receiptCar);
        }

        //封装贷款相关付款信息,同时将贷款中的首付和贷款部分放入顶部数据
        Iterator<Map> iterator = financeFinance.iterator();
        while (iterator.hasNext()) {
            ReceiptParam receiptParam = new ReceiptParam();
            Map x = iterator.next();
            Integer loanPart = (Integer) x.get("loanPart");
            if (loanPart == 1 || loanPart == 2) {
                receiptParam.setLoanPart(Byte.parseByte(loanPart.toString()));
                receiptParam.setPayAmount((BigDecimal) x.get("payAmount"));
                receiptParam.setReceivable((BigDecimal) x.get("price"));
                receiptParam.setReceiptType((Integer) x.get("receiptType"));
                receiptParam.setBusNo(x.get("busNo").toString());
                carFinanceList.add(receiptParam);
                iterator.remove();
            }
        }

        receiptDetail.put("order", order);
        receiptDetail.put("carFinance", carFinanceList);
        receiptDetail.put("boutiqueFinance", boutiqueFinance);
        receiptDetail.put("boutiqueList", boutiqueList);
        receiptDetail.put("insuranceFinance", insuranceFinance);
        receiptDetail.put("extensionFinance", extensionFinance);
        receiptDetail.put("financeFinance", financeFinance);
        receiptDetail.put("serviceFinance", serviceFinance);
        receiptDetail.put("setMealReceipt", setMealReceipt);
        receiptDetail.put("couponReceipt", couponReceipt);
        receiptDetail.put("boutiqueApplyCount", applyCount);
        receiptDetail.put("receiptList", receiptList);

        return receiptDetail;
    }

    @Override
    @Transactional(readOnly = true)
    public List depositFinance(Integer orderId) {
        return receiptMapper.depositFinance(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List carFinance(Integer orderId) {
        return receiptMapper.carFinance(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Receipt> boutiqueFinance(Integer orderId) {
        return receiptMapper.boutiqueFinance(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map> insuranceFinance(Integer orderId) {
        return receiptMapper.insuranceFinance(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map> extensionFinance(Integer orderId) {
        return receiptMapper.extensionFinance(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map> financeFinance(Integer orderId) {
        Map<String, Object> map = orderFinanceMapper.selectFinanceByOrderId(orderId);
        List<Map> result = new ArrayList<>();
        if (map == null) {
            return result;
        }
        BigDecimal price;
        Receipt receipt;
        for (String key : map.keySet()) {
            Map<String, Object> param = new HashMap<>();
            param.put("orderId", orderId);
            param.put("busNo", orderId);
            param.put("receiptType", 6);
            switch (key) {
                case "loanAmount":
                    price = (BigDecimal) map.get("loanAmount");
                    param.put("loanPart", 2);
                    receipt = receiptMapper.financeFinance(param);
                    param.put("price", price);
                    param.put("payAmount", receipt == null ? new BigDecimal(0) : receipt.getAmount());
                    param.put("payRemarks", receipt == null ? null : receipt.getRemarks());
                    param.put("payTime", receipt == null ? null : DateUtil.dateFormat(receipt.getCreateTime(), DateUtil.sdf1));
                    result.add(param);
                    break;
                case "downPayment":
                    price = (BigDecimal) map.get("downPayment");
                    param.put("loanPart", 1);
                    receipt = receiptMapper.financeFinance(param);
                    param.put("price", price);
                    param.put("payAmount", receipt == null ? new BigDecimal(0) : receipt.getAmount());
                    param.put("payRemarks", receipt == null ? null : receipt.getRemarks());
                    param.put("payTime", receipt == null ? null : DateUtil.dateFormat(receipt.getCreateTime(), DateUtil.sdf1));
                    result.add(param);
                    break;
//                case "bond":
//                    price = (BigDecimal) map.get("bond");
//                    param.put("loanPart", 3);
//                    receipt = receiptMapper.financeFinance(param);
//                    param.put("price", price);
//                    param.put("payAmount", receipt == null ? new BigDecimal(0) : receipt.getAmount());
//                    param.put("payRemarks", receipt == null ? null : receipt.getRemarks());
//                    param.put("payTime", receipt == null ? null : DateUtil.dateFormat(receipt.getCreateTime(), DateUtil.sdf1));
//                    result.add(param);
//                    break;
                case "charge":
                    price = (BigDecimal) map.get("charge");
                    param.put("loanPart", 4);
                    receipt = receiptMapper.financeFinance(param);
                    param.put("price", price);
                    param.put("payAmount", receipt == null ? new BigDecimal(0) : receipt.getAmount());
                    param.put("payRemarks", receipt == null ? null : receipt.getRemarks());
                    param.put("payTime", receipt == null ? null : DateUtil.dateFormat(receipt.getCreateTime(), DateUtil.sdf1));
                    result.add(param);
                    break;
                case "mortgageCharge":
                    price = (BigDecimal) map.get("mortgageCharge");
                    param.put("loanPart", 5);
                    receipt = receiptMapper.financeFinance(param);
                    param.put("price", price);
                    param.put("payAmount", receipt == null ? new BigDecimal(0) : receipt.getAmount());
                    param.put("payRemarks", receipt == null ? null : receipt.getRemarks());
                    param.put("payTime", receipt == null ? null : DateUtil.dateFormat(receipt.getCreateTime(), DateUtil.sdf1));
                    result.add(param);
                    break;
            }
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map> serviceFinance(Integer orderId) {
        return receiptMapper.serviceFinance(orderId);
    }

    @Override
    public Boolean ifFullSection(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        BigDecimal bigDecimal = receiptMapper.sumReceipt(orderId);
        if (bigDecimal != null) {
            //如果已收款总数大于等于订单总额，则说明订单已经全款
            if (bigDecimal.compareTo(order.getAmount()) >= 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doAfterFullSection(Integer orderId, Integer createId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        int code = SettleEnum.OrderStatus.TOTAL_PAYMENT.getCode();
        order.setStatus(code);
        order.setDoneTime(new Date());
        //修改订单状态为全款
        orderMapper.updateByPrimaryKeySelective(order);
        //记录车辆信息全款时间、订单状态
        Date date = new Date();
        CarGoodInfoWithBLOBs carGoodInfoWithBLOBs = carGoodInfoMapper.selectByPrimaryKey(order.getCarId());
        carGoodInfoWithBLOBs.setFullPayDate(date);
        carGoodInfoWithBLOBs.setOrderStatus(CarEnum.CarOrderStatus.FULL_PAY.getCode());
        carGoodInfoMapper.updateByPrimaryKeySelective(carGoodInfoWithBLOBs);
        //调用rebateprojectservice的计算车辆计提金额的方法
        rebateProjectService.executeCarPlanExtraction(order.getCarId());
        //修改精品相关状态
        BoutiqueRetail boutiqueRetail = boutiqueRetailService.selectBoutiqueRetailDetailByOrderId(orderId);
        if (boutiqueRetail != null) {
            boutiqueRetailService.updateRetailType(boutiqueRetail.getId(), BoutiqueEnum.BoutiqueType.FINISHED);
            boutiqueRetailService.createInstallByRetailId(boutiqueRetail.getId());
            boutiqueRetailService.createOutboundByRetailId(boutiqueRetail.getId());
        }
        //推送消息到信息员、销售顾问
        List<String> postNames = new ArrayList<String>() {
            {
                add(informationMemberPosition);
                add(salesConsultantPosition);
            }
        };
        Employee employee = employeeService.employeeById(order.getCreateId());
        saleOrderService.pushMess(employee.getStoreId(), postNames, PushEnum.PushType.ORDER_PAY_ALL.getCode(), PushEnum.PushType.ORDER_PAY_ALL.getDesc(), createId, order, employee);
    }

    @Override
    public void receiptMoney(List<Receipt> receiptList, Integer employeeId) {
        Order order;
        for (Receipt receipt : receiptList) {
            switch (receipt.getReceiptType()) {
                case 1:
                    //订金收款，增加收款记录
                    receipt.setCreateId(employeeId);
                    receiptMapper.insertSelective(receipt);
                    //并修改订单状态为已付定金
                    order = orderMapper.selectByPrimaryKey(receipt.getOrderId());
                    order.setStatus(SettleEnum.OrderStatus.EARNEST.getCode());
                    orderMapper.updateByPrimaryKeySelective(order);
                    //判断是否有金融信息，推送消息给库管、金融专员
                    Map<String, Object> orderFinance = orderFinanceMapper.selectByOrderId(order.getId());
                    List<String> postNames = new ArrayList<String>() {
                        {
                            add(storehouse);
                        }
                    };
                    if (orderFinance.size() > 0) {
                        postNames.add(financialSpecialistPosition);
                    }
                    Employee employee = employeeService.employeeById(order.getCreateId());
                    saleOrderService.pushMess(employee.getStoreId(), postNames, PushEnum.PushType.ORDER_PAY_FIRST.getCode(), PushEnum.PushType.ORDER_PAY_FIRST.getDesc(), employeeId, order, employee);
                    //判断是否有保险,有的话推送保险信息给保险专员
                    List<Map<String, Object>> orderInsurance = orderInsuranceMapper.selectByOrderId(order.getId());
                    if (orderInsurance.size() > 0) {
                        List<String> postNameList = new ArrayList<String>() {
                            {
                                add(insuranceSpecialistPosition);
                            }
                        };
                        saleOrderService.pushMess(employee.getStoreId(), postNameList, PushEnum.PushType.ORDER_PAY_FIRST_INSURANCE.getCode(), PushEnum.PushType.ORDER_PAY_FIRST_INSURANCE.getDesc(), employeeId, order, employee);
                    }
                    //判断是否有延保,有的话推送保险信息给保险专员
                    Map<String, Object> orderExtension = orderExtensionMapper.selectByOrderId(order.getId());
                    if (orderExtension.size() > 0) {
                        List<String> postNameList = new ArrayList<String>() {
                            {
                                add(insuranceSpecialistPosition);
                            }
                        };
                        saleOrderService.pushMess(employee.getStoreId(), postNameList, PushEnum.PushType.ORDER_PAY_FIRST_EXTENSION.getCode(), PushEnum.PushType.ORDER_PAY_FIRST_EXTENSION.getDesc(), employeeId, order, employee);
                    }
                    break;
                case 7:
                    //其他服务收款
                    receipt.setCreateId(employeeId);
                    receiptMapper.insertSelective(receipt);
                    //其他服务收款如果其他服务项都已经收款则修改订单其他服务状态
                    List<Receipt> receipts = receiptMapper.selectReceiptByType(receipt);
                    List<Map<String, Object>> maps = orderServiceMapper.selectListByOrderId(receipt.getOrderId());
                    if (receipts.size() == maps.size()) {
                        order = orderMapper.selectByPrimaryKey(receipt.getOrderId());
                        order.setOtherStatus(2);
                        orderMapper.updateByPrimaryKeySelective(order);
                    }
                    break;
                case 8:
                    receipt.setCreateId(employeeId);
                    receiptMapper.insertSelective(receipt);
                    //代金券和套餐收款时判断代金券和套餐是否已经付完款，付完款则修改订单状态
                    Integer orderId = receipt.getOrderId();
                    Integer busNo = Integer.parseInt(receipt.getBusNo());
                    OrderSetMeal orderSetMeal = orderSetMealMapper.selectByPrimaryKey(busNo);
                    Map<String, Object> param = new HashMap<>();
                    param.put("orderId", orderId);
                    param.put("busNo", busNo);
                    param.put("receiptType", 8);
                    BigDecimal bigDecimal = receiptMapper.sumByParam(param);
                    BigDecimal sumMealPrice = orderSetMeal.getSumMealPrice();
                    if (bigDecimal.compareTo(sumMealPrice) >= 0) {
                        orderSetMeal.setStatus(2);
                        orderSetMealMapper.updateByPrimaryKey(orderSetMeal);
                    }
                    break;
                default:
                    receipt.setCreateId(employeeId);
                    receiptMapper.insertSelective(receipt);
                    break;
            }
        }
    }

    //获取套餐付款信息
    private List<Map> setMealReceipt(Integer orderId) {
        return receiptMapper.setMealReceipt(orderId);
    }

    //获取代金券
    private List<Map> couponReceipt(Integer orderId) {
        return receiptMapper.couponReceipt(orderId);
    }

    //判断是否有业务已经付款
    public boolean ifReceipt(Receipt receipt) {
        List<Receipt> receipts = receiptMapper.ifReceipt(receipt);
        if (receipts.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Integer> getBoutiqueRetailIdsByParams(Map<String, Object> params) {
        List<Map<String, Object>> list = receiptMapper.getBoutiqueIdsByParams(params);
        List<Integer> retailIds = Lists.newArrayList();
        if (list != null) {
            for (Map<String, Object> map : list) {
                retailIds.add(Integer.valueOf(map.get("id").toString()));
            }
        }
        return retailIds;
    }

}
