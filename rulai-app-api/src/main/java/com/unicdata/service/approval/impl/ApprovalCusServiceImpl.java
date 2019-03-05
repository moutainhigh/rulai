package com.unicdata.service.approval.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.CarEnum;
import com.unicdata.constant.ConstantEnum.enumIsOrNoStatus;
import com.unicdata.constant.OrderEnum.approvalStatus;
import com.unicdata.constant.CustomerEnum;
import com.unicdata.dao.approval.ApprovalCusMapper;
import com.unicdata.dao.basedata.DictionaryMapper;
import com.unicdata.dao.customer.CustomerMapper;
import com.unicdata.dao.customer.TaskFollowUpMapper;
import com.unicdata.dao.customer.TestDriveMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.entity.approval.ApprovalCus;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.TaskFollowUp;
import com.unicdata.entity.customer.TestDrive;
import com.unicdata.entity.customer.TestDriveExample;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.approval.ApprovalCusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2018/6/1.
 */
@Service
public class ApprovalCusServiceImpl implements ApprovalCusService {
    @Autowired
    ApprovalCusMapper approvalCusMapper;
    @Autowired
    TaskFollowUpMapper taskFollowUpMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    TestDriveMapper testDriveMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    private DictionaryMapper dictionaryMapper;


    /**
     * 展厅经理或销售经理通过门店id获取审批人员
     *
     * @param codeNum
     * @return
     */
    @Override
    public PageInfo selectByCodeNum(Map<String, Object> map, Integer pageNum, Integer pageSize) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> maps = approvalCusMapper.selectByCodeNum(map);
        for (Map<String, Object> objectMap : maps) {
            //设置建档时间
            Object numberDays = objectMap.get("numberDays");
            Object create_time = objectMap.get("create_time");
            if (numberDays != null && create_time != null) {
                String s = numberDays.toString();
                if (s.equals("0")) {
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    String format1 = format.format(create_time);
                    objectMap.put("createTime", format1);
                } else {
                    objectMap.put("createTime", "建档" + numberDays + "天");
                }
            }

            //客户级别
            Object level = objectMap.get("level");
            if (level != null) {
                Integer s = Integer.valueOf(level.toString());
                CustomerEnum.Level[] values = CustomerEnum.Level.values();
                if (s < values.length) {
                    String reason = values[s].getReason();
                    objectMap.put("levelStr", reason);
                }
            }

            //车辆用途
            Object usage = objectMap.get("usage");
            if (usage != null) {
                Integer s = Integer.valueOf(usage.toString());
                CustomerEnum.Usage[] values = CustomerEnum.Usage.values();
                String reason = values[s].getReason();
                objectMap.put("usage", reason);
            }


            Object cus_id = objectMap.get("cus_id");
            if (cus_id != null) {
                List<TaskFollowUp> followUps = taskFollowUpMapper.selectByCustomerId(Integer.valueOf(cus_id.toString()));
                if (followUps.size() > 0) {
                    SimpleDateFormat format = new SimpleDateFormat("MM/dd");
                    String format1 = format.format(new Date());
                    Date nextDate = followUps.get(0).getNextDate();
                    if (nextDate != null) {
                        String format2 = format.format(nextDate);
                        if (format1.equals(format2)) {
                            objectMap.put("thisDate", "今日跟进");
                        } else {
                            objectMap.put("thisDate", format2 + "跟进");
                        }
                    }
                }

                //获取客户试驾车型及时间
                TestDriveExample example = new TestDriveExample();
                TestDriveExample.Criteria criteria = example.createCriteria();
                criteria.andCusIdEqualTo(Integer.valueOf(cus_id.toString()));
                example.setOrderByClause("id desc");
                List<TestDrive> list = testDriveMapper.selectByExample(example);
                if (list != null && list.size() > 0) {
                    TestDrive testDrive = list.get(0);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String format1 = format.format(testDrive.getCreateTime());
                    objectMap.put("drive", testDrive.getVehicleName() + "/" + format1);
                }
            }
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(maps);
        return pageInfo;
    }

    /**
     * 根据客户id获取审批人员详情
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> selectApprovalDetailsById(Employee emp, Integer id) {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        //获取客户信息
        Map<String, Object> custorMap = new HashMap<String, Object>();
        custorMap.put("id", id);
        objectMap = approvalCusMapper.selectApprovalDetailsById(custorMap);
        //客户id
        Integer cusId = 0;
        if (objectMap != null) {
            Object cus_id = objectMap.get("id");
            cusId = objectMap.get("id") == null ? 0 : Integer.valueOf(cus_id.toString());
            //客户订单信息
            SimpleDateFormat format5 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            List<Map<String, Object>> orders1 = new ArrayList<>();
            List<Order> orders = orderMapper.selectByCusId(cusId);
            for (Order order : orders) {
                Map<String, Object> orderMap2 = new HashMap<String, Object>();
                orderMap2.put("orderNum", order.getOrderNum());
                orderMap2.put("status", order.getStatus());
                String format1 = format5.format(order.getCreateTime());
                orderMap2.put("createTime", format1);
                orderMap2.put("orderId", order.getId());
                //判断订单状态是未生效且车辆价格状态不等于审批中或者通过才能编辑
                Integer status = order.getStatus();
                Integer carPriceStatus = order.getCarPriceStatus();
                if (carPriceStatus != null && status != null) {
                    if (order.getStatus() == 1 && (order.getCarPriceStatus() == 0 || order.getCarPriceStatus() == 3)) {
                        //1表示有完善订单按钮
                        orderMap2.put("n", 2);
                    } else {
                        orderMap2.put("n", 0);
                    }
                } else {
                    orderMap2.put("n", 0);
                }
                orders1.add(orderMap2);
            }

            objectMap.put("orderData", orders1);
            //试驾信息
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("cusId", cusId);
            map.put("storeId", emp.getStoreId());
            List<Map<String, Object>> list = testDriveMapper.selectByCusId(map);
            objectMap.put("testDriveData", list);
            //查询是否有未完成的试驾记录
            map.put("perfectState", enumIsOrNoStatus.否.getId());
            TestDrive temp = testDriveMapper.getTestDrivesByMap(map);
            objectMap.put("isTestDrive", temp != null ? 1 : 0);
            //根据客户id获取客户审批状态
            List<ApprovalCus> approvalCuses = approvalCusMapper.selectByCusId(cusId);
            if (approvalCuses != null && approvalCuses.size() > 0) {
                objectMap.put("ApprovalCus", approvalCuses.get(0));
            }

            //最后跟进时间
            List<TaskFollowUp> followUps = taskFollowUpMapper.selectByCustomerId(cusId);
            if (followUps != null && followUps.size() > 0) {
                SimpleDateFormat format = new SimpleDateFormat("MM/dd");
                String format1 = format.format(new Date());
                Date nextDate = followUps.get(0).getNextDate();
                if (nextDate != null) {
                    String format2 = format.format(nextDate);
                    if (format1.equals(format2)) {
                        objectMap.put("thisDate", "今日跟进");
                    } else {
                        objectMap.put("thisDate", format2 + "跟进");
                    }
                }
            }

            //车辆竞品
            String attention_car = "";
            Object attention_car_one = objectMap.get("attention_car_one");
            if (attention_car_one != null && attention_car_one.toString().length() > 0) {
                attention_car += attention_car_one + ",";
            }
            Object attention_car_two = objectMap.get("attention_car_two");
            if (attention_car_two != null && attention_car_two.toString().length() > 0) {
                attention_car += attention_car_two + ",";
            }
            Object attention_car_three = objectMap.get("attention_car_three");
            if (attention_car_three != null && attention_car_three.toString().length() > 0) {
                attention_car += attention_car_three + ",";
            }
            objectMap.put("attention_car", attention_car.length() > 0 ? attention_car.substring(0, attention_car.length() - 1) : "");

            //客户级别
            Object level = objectMap.get("level");
            if (level != null && level != "") {
                Integer s = Integer.valueOf(level.toString());
                CustomerEnum.Level[] values = CustomerEnum.Level.values();
                if (s < values.length) {
                    String reason = values[s].getReason();
                    objectMap.put("levelStr", reason);
                } else {
                    objectMap.put("levelStr", "-");
                }
            } else {
                objectMap.put("levelStr", "-");
            }

            //车辆用途
            Object usage = objectMap.get("usage");
            if (usage != null && usage != "") {
                Integer s = Integer.valueOf(usage.toString());
                CustomerEnum.Usage[] values = CustomerEnum.Usage.values();
                if (s < values.length) {
                    String reason = values[s].getReason();
                    objectMap.put("usage", reason);
                } else {
                    objectMap.put("usage", "-");
                }
            } else {
                objectMap.put("usage", "-");
            }

            //设置建档时间
            Object numberDays = objectMap.get("numberDays");
            Object create_time = objectMap.get("create_time");
            if (numberDays != null && create_time != null) {
                String s = numberDays.toString();
                if (s.equals("0")) {
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    String format1 = format.format(create_time);
                    objectMap.put("createTime", format1);
                } else {
                    objectMap.put("createTime", "建档" + numberDays + "天");
                }
            }
        }
        return objectMap;
    }

    @Transactional
    public int createApprovalCustomer(ApprovalCus record) {
        record.setApprovalStatus(approvalStatus.APPROVAL_WAIT.getCode());
        int res = approvalCusMapper.insertSelective(record);
        if (res > 0) {//提交审批，修改客户状态审批中
            Customer customer = new Customer();
            customer.setId(record.getCusId());
            customer.setUserStatus(1);
            customerMapper.updateByPrimaryKeySelective(customer);
        }
        return res;
    }

    /**
     * 更新人员审批
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(ApprovalCus record) {
        return approvalCusMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据id获取审批人员信息
     *
     * @param id
     * @return
     */
    @Override
    public ApprovalCus selectByPrimaryKey(Integer id) {
        return approvalCusMapper.selectByPrimaryKey(id);
    }

    @Override
    public int getApprovalCusNum(Integer employeeId) {
        ApprovalCus record = new ApprovalCus();
        record.setEmployeeId(employeeId);
        record.setApprovalStatus(approvalStatus.APPROVAL_WAIT.getCode());
        return approvalCusMapper.getApprovalCusNum(record);
    }

    @Override
    public List<ApprovalCus> selectByCusId(Integer id) {
        return approvalCusMapper.selectByCusId(id);
    }
}
