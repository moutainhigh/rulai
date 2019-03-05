package com.unicdata.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.constant.PushEnum;
import com.unicdata.constant.SettleEnum;
import com.unicdata.dao.order.OrderFinanceMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.system.EmployeeMapper;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.OrderFinance;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.order.OrderFinanceService;
import com.unicdata.service.push.PushMessageService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Create by zhang
 */
@Service
public class OrderFinanceServiceImpl implements OrderFinanceService {

    //财务部经理
    @Value("${FINANCE_MANAGER}")
    public String financeManager;

    @Autowired
    private OrderFinanceMapper orderFinanceMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private PushMessageService pushMessageService;

    @Override
    public List<Map<String, Object>> getOrderFinance(Integer orderId) {
        return orderFinanceMapper.getOrderFinance(orderId);
    }

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return orderFinanceMapper.selectListByParams(params).toPageInfo();
    }

    @Transactional(readOnly = false)
    @Override
    public int save(OrderFinance orderFinance, Employee member) {
        int result = 0;
        result = orderFinanceMapper.updateByPrimaryKeySelective(orderFinance);
        //如果变为已申请/已放款，将订单状态转换为已申请/已放款
        if (result == 1 && (Objects.equals(orderFinance.getLoanStatus(), SettleEnum.OrderFinanceStates.HAVE_APPLIED.getCode()) || Objects.equals(orderFinance.getLoanStatus(), SettleEnum.OrderFinanceStates.HAVE_RELEASED.getCode()))) {
            Order order = new Order();
            order.setId(orderFinance.getOrderId());
            order.setFinanceStatus(orderFinance.getLoanStatus());
            orderMapper.updateByPrimaryKeySelective(order);
            //如果已放款，将推送消息保存到数据库
            if (Objects.equals(orderFinance.getLoanStatus(), SettleEnum.OrderFinanceStates.HAVE_RELEASED.getCode())) {
                StringBuffer content = new StringBuffer("顾问");
                Order realOrder = orderMapper.selectByPrimaryKey(orderFinance.getOrderId());
                if (realOrder.getCreateId() != null) {
                    Employee employee = employeeMapper.selectByPrimaryKey(realOrder.getCreateId());
                    if (employee != null) {
                        content.append(employee.getFullName());
                    }
                } else {
                    content.append(" ");
                }
                content.append("的客户" + realOrder.getCusName() + " 订单" + realOrder.getOrderNum() + "贷款已到账,请确认!");
                //推送消息标题
                String title = PushEnum.PushType.ORDER_LOAN.getDesc();
                List<Employee> employees = employeeMapper.selectByParam(new HashMap() {{
                    put("postName", financeManager);
                    put("storeId", member.getStoreId());
                }});
                List<Map<String, Object>> receivers = Lists.newArrayList();
                if (employees != null) {
                    for (Employee employee : employees) {
                        Map<String, Object> receiver = Maps.newHashMap();
                        receiver.put("employeeId", employee.getId());
                        receiver.put("urlId", PushEnum.UrlWeb.ORDER_LOAN_FINANCE.getCode());
                        receiver.put("terminal", PushEnum.PushTerminal.PC.getCode());
                        receivers.add(receiver);
                    }
                }
                pushMessageService.createPushMessage(PushEnum.PushType.ORDER_LOAN.getCode(), title, content.toString(), member.getId(), receivers);
            }
        }
        return result;
    }

    @Override
    public OrderFinance getOrderFinanceById(Integer id) {
        return orderFinanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map orderFinancePay(Integer orderId) {

        return null;
    }
}
