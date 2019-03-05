package com.unicdata.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.constant.PushEnum;
import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.order.EquipmentMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.order.Equipment;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.order.SaleOrderService;
import com.unicdata.service.push.PushMessageService;
import com.unicdata.service.system.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@Service
@Transactional
public class SaleOrderServiceImpl implements SaleOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private CarGoodInfoMapper carGoodInfoMapper;
    @Autowired
    private PushMessageService pushMessageService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CarGoodInfoService carGoodInfoService;


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
    @Transactional(readOnly = true)
    public PageInfo<Map<String, Object>> salemanOrderList(Map param, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return orderMapper.saleOrderList(param).toPageInfo();
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo<Map<String, Object>> storeOrderList(Map param, Integer pageNum, Integer pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            return orderMapper.storeOrderList(param).toPageInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Map orderDetail(Integer orderId) {
        return orderMapper.orderDetail(orderId);
    }

    @Override
    public void equipmentCar(Map<String, Integer> map) {

        Order order = orderMapper.selectByPrimaryKey(map.get("orderId"));
        //判断订单是否配车，如果已经配车，修改原来车辆的配车状态
        if (order.getMatchingCarId() != null) {
            //查询订单绑定原车辆id，修改订单原车辆配车状态为未配车
            CarGoodInfoWithBLOBs carGoodInfoWithBLOBs = carGoodInfoMapper.selectByPrimaryKey(order.getMatchingCarId());
            carGoodInfoWithBLOBs.setCarSupplyStatus(1);
            carGoodInfoMapper.updateByPrimaryKeySelective(carGoodInfoWithBLOBs);
        }

        Equipment equipment = new Equipment();
        equipment.setCusId(map.get("cusId"));
        equipment.setOrderId(map.get("orderId"));
        equipment.setCarId(map.get("matchCarId"));

        //如果没有选中车辆，则修改订单配车状态为未配车
        if (map.get("matchCarId") == null || ("").equals(map.get("matchCarId").toString())) {
            map.put("carStatus", 0);
            //修改订单绑定的车辆id和订单配车状态
            orderMapper.equipmentCar(map);
            equipment.setType(2);
        } else {
            //修改新绑定的车辆状态为已配车
            CarGoodInfoWithBLOBs carGoodInfo = carGoodInfoMapper.selectByPrimaryKey(map.get("matchCarId"));
            carGoodInfo.setCarSupplyStatus(2);
            carGoodInfoMapper.updateByPrimaryKeySelective(carGoodInfo);
            equipment.setType(1);
            //修改订单绑定的车辆id和订单配车状态
            map.put("carStatus", 1);
            map.put("carId", map.get("matchCarId"));
            //查询所配车辆的原订单
            Order orderMacth = orderMapper.selectByMacthCarId(map.get("matchCarId"));
            orderMapper.equipmentCar(map);
            //查询新配的车辆是否已经被配车，如果已经被配车则修改原来所配的订单为未配车
            if (orderMacth != null && orderMacth.getId().longValue() != order.getId().longValue()) {
                orderMacth.setCarStatus(0);
                orderMacth.setMatchingCarId(null);
                orderMapper.updateByPrimaryKey(orderMacth);
            }
        }
        //插入配车记录
        equipmentMapper.insertSelective(equipment);
    }

    @Override
    public PageInfo<Map> financeOrderList(Map param, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return orderMapper.financeOrderList(param).toPageInfo();
    }

    @Override
    public PageInfo<Map> saleDetailed(Integer storeId) {
        return null;
    }

    @Override
    public int getCurrentMothOrderNum(Integer employeeId, Integer status) {
        Order record = new Order();
        record.setCreateId(employeeId);
        record.setStatus(status);
        return orderMapper.getCurrentMothOrderNum(record);
    }

    @Override
    public List<Employee> saleManList(Integer storeId) {
        return orderMapper.saleManList(storeId);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> selectByCusId(Integer cusId) {
        return orderMapper.selectByCusId(cusId);
    }

    @Override
    public Map orderCirculation(Integer orderId) {
        return orderMapper.orderCirculation(orderId);
    }

    @Override
    public Map receivablesByOrderId(Integer orderId) {
        return orderMapper.receivablesByOrderId(orderId);
    }


    @Override
    public List<Order> getOrdersByCusAndDate(Integer cusId, String date) {
        return orderMapper.getOrdersByCusAndDate(cusId, date);
    }

    @Override
    public void pushMess(Integer storeId, List<String> postNames,
                         Integer type, String title,
                         Integer createId, Order order, Employee employeeSale) {

        Map<String, Object> param = new HashMap<>();
        param.put("storeId", storeId);
        for (String postName : postNames) {
            param.put("postName", postName);
            //如果是销售顾问则只推送给订单所属的销售顾问
            if ((salesConsultantPosition).equals(postName)) {
                Map<String, Object> saleParam = new HashMap<>();
                saleParam.put("employeeId", employeeSale.getId());
                saleParam.put("urlId", geturlIdAndContent(type, postName, order, employeeSale).get("urlId"));
                saleParam.put("terminal", geturlIdAndContent(type, postName, order, employeeSale).get("terminal"));
                List<Map<String, Object>> receivers = new ArrayList<>();
                receivers.add(saleParam);
                pushMessageService.createPushMessage(type, title, geturlIdAndContent(type, postName, order, employeeSale).get("content").toString(), createId, receivers);
            } else {
                //其他岗位查询人员列表进行推送
                List<Employee> employees = employeeService.selectByParam(param);
                List<Map<String, Object>> receivers = new ArrayList<>();
                for (Employee employee : employees) {
                    Map<String, Object> receiver = new HashMap<>();
                    receiver.put("employeeId", employee.getId());
                    receiver.put("urlId", geturlIdAndContent(type, postName, order, employeeSale).get("urlId"));
                    receiver.put("terminal", geturlIdAndContent(type, postName, order, employeeSale).get("terminal"));
                    receivers.add(receiver);
                }
                //推送
                pushMessageService.createPushMessage(type, title, geturlIdAndContent(type, postName, order, employeeSale).get("content").toString(), createId, receivers);
            }
        }
    }

    private Map geturlIdAndContent(Integer type, String postName, Order order, Employee employee) {
        Map<String, Object> urlIdAndContent = new HashMap<>();
        Integer urlId = null;
        String content = null;
        Integer terminal = null;
        switch (type) {
            //订单通过审核
            case 1:
                if (salesConsultantPosition.equals(postName)) {
                    content = "客户" + order.getCusName() + "的订单" + order.getOrderNum() + "已通过审核.请及时跟进!";
                    terminal = PushEnum.PushTerminal.MOBILE.getCode();
                }
                if (informationMemberPosition.equals(postName)) {
                    urlId = PushEnum.UrlWeb.ORDER_PASS_INFO.getCode();
                    terminal = PushEnum.PushTerminal.PC.getCode();
                    content = "顾问" + employee.getFullName() + "的客户" + order.getCusName() + "订单" + order.getOrderNum() + "已审核,需要打印合同及业务联络单,请及时处理!";
                }
                if (financePosition.equals(postName)) {
                    urlId = PushEnum.UrlWeb.ORDER_AUDITED_FINANCE.getCode();
                    terminal = PushEnum.PushTerminal.PC.getCode();
                    content = "顾问" + employee.getFullName() + "的客户" + order.getCusName() + "订单" + order.getOrderNum() + "已通过审核,请及时处理!";
                }
                break;
            //订单贷款到账
            case 2:
                break;
            //订单退订通过审核
            case 3:
                if ((financePosition).equals(postName)) {
                    urlId = PushEnum.UrlWeb.ORDER_REFUND_FINANCE.getCode();
                    terminal = PushEnum.PushTerminal.PC.getCode();
                    content = "顾问" + employee.getFullName() + "的客户" + order.getCusName() + "订单" + order.getOrderNum() + "退订已通过审核,请及时处理!";
                }
                break;
            //订单提交审核
            case 4:
                break;
            //订单审核驳回
            case 5:
                if ((salesConsultantPosition).equals(postName)) {
                    urlId = PushEnum.UrlWeb.ORDER_SALE_OFFICER_REJECT.getCode();
                    terminal = PushEnum.PushTerminal.MOBILE.getCode();
                    content = "客户" + order.getCusName() + "的订单" + order.getOrderNum() + "被驳回.请及时跟进!";
                }
                break;
            //订单已付全款
            case 6:
                if (salesConsultantPosition.equals(postName)) {
                    terminal = PushEnum.PushTerminal.MOBILE.getCode();
                    content = "客户" + order.getCusName() + "的订单" + order.getOrderNum() + "已付全款.请及时跟进!";
                }
                if (informationMemberPosition.equals(postName)) {
                    urlId = PushEnum.UrlWeb.ORDER_PAY_ALL_INFO.getCode();
                    terminal = PushEnum.PushTerminal.PC.getCode();
                    content = "顾问" + employee.getFullName() + "的客户" + order.getCusName() + "订单" + order.getOrderNum() + "已付全款,需要打印交车单,请及时处理!";
                }
                break;
            //订单已付定金
            case 7:
                if (financialSpecialistPosition.equals(postName)) {
                    content = "顾问" + employee.getFullName() + "的客户" + order.getCusName() + "订单" + order.getOrderNum() + "已付定金,需要办理贷款,请及时处理!";
                    terminal = PushEnum.PushTerminal.PC.getCode();
                    urlId = PushEnum.UrlWeb.ORDER_PAY_FIRST_LOAN.getCode();
                }
                if (storehouse.equals(postName)) {
                    terminal = PushEnum.PushTerminal.MOBILE.getCode();
                    content = "顾问" + employee.getFullName() + "的客户" + order.getCusName() + "订单" + order.getOrderNum() + "已付定金,需要PDI检测,请及时处理!";
                }
                break;
            //人员休眠不通过审批
            case 10:
                if (salesConsultantPosition.equals(postName)) {
                    terminal = PushEnum.PushTerminal.MOBILE.getCode();
                    content = "客户" + order.getCusName() + "休眠审批已通过，请知悉。";
                }
                break;
            //人员休眠通过审批
            case 11:
                if (salesConsultantPosition.equals(postName)) {
                    terminal = PushEnum.PushTerminal.MOBILE.getCode();
                    content = "客户" + order.getCusName() + "战败审批已通过，请知悉。";
                }
                break;
            //人员战败不通过审批
            case 12:
                if (salesConsultantPosition.equals(postName)) {
                    terminal = PushEnum.PushTerminal.MOBILE.getCode();
                    content = "客户" + order.getCusName() + "战败审批已通过，请知悉。";
                }
                break;
            //人员战败通过审批
            case 13:
                if (salesConsultantPosition.equals(postName)) {
                    terminal = PushEnum.PushTerminal.MOBILE.getCode();
                    content = "客户" + order.getCusName() + "战败审批已通过，请知悉。";
                }
                break;
            case 25:
                if (insuranceSpecialistPosition.equals(postName)) {
                    content = "顾问" + employee.getFullName() + "的客户" + order.getCusName() + "订单" + order.getOrderNum() + "已付定金,需要办理保险,请及时处理!";
                    terminal = PushEnum.PushTerminal.PC.getCode();
                    urlId = PushEnum.UrlWeb.ORDER_PAY_FIRST_INSURANCE.getCode();
                }
                break;
            case 26:
                if (insuranceSpecialistPosition.equals(postName)) {
                    content = "顾问" + employee.getFullName() + "的客户" + order.getCusName() + "订单" + order.getOrderNum() + "已付定金,需要办理延保,请及时处理!";
                    terminal = PushEnum.PushTerminal.PC.getCode();
                    urlId = PushEnum.UrlWeb.ORDER_PAY_FIRST_EXTENSION.getCode();
                }
                break;

        }
        urlIdAndContent.put("urlId", urlId);
        urlIdAndContent.put("content", content);
        urlIdAndContent.put("terminal", terminal);
        return urlIdAndContent;
    }
    @Override
    public void replaceCarInfo(List<Map<String, Object>> list) {
        //判断如果订单没有配车则查询订单对应车辆id的相关信息
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            Integer matchingCarId = (Integer) map.get("matchingCarId");
            if (matchingCarId == null) {
                CarGoodInfoWithBLOBs carId = carGoodInfoService.selectByPrimaryKey((Integer) map.get("carId"));
                map.put("decorationsInName", carId.getDecorationsInName());
                map.put("decorationsOutName", carId.getDecorationsOutName());
                map.put("vehicleName", carId.getVehicleName());
                map.put("yearGap", carId.getYear());
                map.put("vin", null);
                map.put("engineNum", null);
            }
        }
    }
}
