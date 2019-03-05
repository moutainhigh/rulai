package com.unicdata.service.approval.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.constant.MessageCode;
import com.unicdata.constant.PushEnum;
import com.unicdata.constant.BoutiqueEnum.BoutiqueType;
import com.unicdata.constant.ConstantEnum.AppOrderStatus;
import com.unicdata.constant.ConstantEnum.CarPriceStatus;
import com.unicdata.constant.OrderEnum.ApprovalOrderType;
import com.unicdata.constant.OrderEnum.approvalStatus;
import com.unicdata.dao.approval.ApprovalOrderMapper;
import com.unicdata.dao.boutique.BoutiqueRetailMapper;
import com.unicdata.dao.customer.TaskFollowUpMapper;
import com.unicdata.dao.order.*;
import com.unicdata.entity.approval.ApprovalOrder;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.customer.TaskFollowUp;
import com.unicdata.entity.order.Order;
import com.unicdata.service.approval.ApprovalOrderService;
import com.unicdata.service.push.PushMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2018/6/1.
 */
@Service
public class ApprovalOrderServiceImpl implements ApprovalOrderService {
    @Autowired
    ApprovalOrderMapper approvalOrderMapper;
    @Autowired
    OrderInsuranceMapper orderInsuranceMapper;
    @Autowired
    OrderExtensionMapper orderExtensionMapper;
    @Autowired
    OrderFinanceMapper orderFinanceMapper;
    @Autowired
    OrderServiceMapper orderServiceMapper;
    @Autowired
    private BoutiqueRetailMapper boutiqueRetailMapper;
    @Autowired
    private TaskFollowUpMapper taskFollowUpMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderSetMealMapper orderSetMealMapper;
    @Autowired
    private OrderSetMealItemMapper orderSetMealItemMapper;
    @Autowired
    private PushMessageService pushMessageService;

    /**
     * 展厅经理或销售经理通过员工编号获取审批订单
     *
     * @param codeNum
     * @return
     */
    @Override
    public PageInfo selectByCodeNum(Map<String, Object> map, Integer pageNum, Integer pageSize) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> maps = approvalOrderMapper.selectByCodeNum(map);
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

            Object cus_id = objectMap.get("id");
            //设置跟进时间
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
            }
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(maps);
        return pageInfo;
    }

    /**
     * 通过订单id获取订单详情及金融保险等信息
     *
     * @param orderId
     * @return
     */
    @Override
    public Map<String, Object> approvvalOrderDetails(Integer orderId) {
        Map<String, Object> map = approvalOrderMapper.selectApprovvalOrderDetailsByOrderId(orderId);
        if (map != null) {
            //订单保险
            Map<String, Object> hashMap = new HashMap<>();
            List<Map<String, Object>> maps = orderInsuranceMapper.selectByOrderId(orderId);
            BigDecimal sum = new BigDecimal(0);
            for (Map<String, Object> stringObjectMap : maps) {
                Object sum_money = stringObjectMap.get("sum_money");
                String string = sum_money.toString();
                BigDecimal bd = new BigDecimal(string);
                sum = sum.add(bd);
            }
            hashMap.put("sumMoney", sum);
            hashMap.put("insuranceList", maps);
            //订单精品
            Map<String, Object> hashMap5 = new HashMap<>();
            List<Map<String, Object>> informationOrderId = boutiqueRetailMapper.getBoutiqueRetailByOId(orderId);
            BigDecimal boutiqueSum = new BigDecimal(0);
            List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
            for (Map<String, Object> stringObjectMap : informationOrderId) {
                Map<String, Object> objectHashMap = new HashMap<>();
                objectHashMap.put("isGift", stringObjectMap.get("isGift"));
                objectHashMap.put("construction_node", stringObjectMap.get("construction_node"));
                objectHashMap.put("sale_value", stringObjectMap.get("sale_value"));
                Object is_package = stringObjectMap.get("is_package");
                if (is_package != null) {
                    String pId = is_package.toString();
                    //判断是精品礼包
                    if (pId.equals("1")) {
                        objectHashMap.put("num", stringObjectMap.get("pack_num"));
                        objectHashMap.put("name", stringObjectMap.get("packName"));
                        objectHashMap.put("pack_id", stringObjectMap.get("pack_id"));
                    } else {
                        objectHashMap.put("num", stringObjectMap.get("information_num"));
                        objectHashMap.put("name", stringObjectMap.get("informationName"));
                    }
                } else {
                    objectHashMap.put("num", stringObjectMap.get("information_num"));
                    objectHashMap.put("name", stringObjectMap.get("informationName"));
                }
                mapList.add(objectHashMap);
                Object sum_money = objectHashMap.get("sale_value");
                String string = "";
                if (sum_money != null) {
                    string = sum_money.toString();
                }
                BigDecimal saleCount = new BigDecimal(string);
                Object information_num = objectHashMap.get("num");
                String information_num2 = "";
                if (information_num != null) {
                    information_num2 = information_num.toString();
                }
                BigDecimal saleNum = new BigDecimal(information_num2);
                boutiqueSum = boutiqueSum.add(saleCount.multiply(saleNum));
            }
            hashMap5.put("boutiqueList", mapList);
            hashMap5.put("boutiqueSum", boutiqueSum);
            //订单延保
            List<Map<String, Object>> hashMap2 = orderExtensionMapper.getOrderExtension(orderId);
            //订单金融
            List<Map<String, Object>> hashMap3 = orderFinanceMapper.getOrderFinance(orderId);
            //订单保养套餐
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("orderId", orderId);
            params.put("type", 1);
            //保养套餐和代金券主单信息
            Map<String, Object> setMealMap = orderSetMealMapper.getOrderSetMeal(params);
            if (null != setMealMap) {
                //明细项
                params.put("orderSetmealId", setMealMap.get("id"));
                List<Map<String, Object>> list = orderSetMealItemMapper.getOrderSetMealItem(params);
                setMealMap.put("itemList", list);
            }
            //订单其它服务
            List<Map<String, Object>> maps1 = orderServiceMapper.selectListByOrderId(orderId);
            HashMap<String, Object> hashMap4 = new HashMap<>();
            BigDecimal serviceSum = new BigDecimal(0);
            for (Map<String, Object> stringObjectMap : maps1) {
                Object sum_money = stringObjectMap.get("service_price");
                if (sum_money != null) {
                    String string = sum_money.toString();
                    BigDecimal bd = new BigDecimal(string);
                    serviceSum = serviceSum.add(bd);
                }
            }
            hashMap4.put("serviceSum", serviceSum);
            hashMap4.put("serviceList", maps1);

            map.put("insuranceOrder", hashMap);
            map.put("extensionOrder", hashMap2);
            map.put("financeOrder", hashMap3);
            map.put("serviceOrder", hashMap4);
            map.put("boutiqueOrder", hashMap5);
            map.put("setMealOrder", setMealMap);
        }
        return map;
    }

    @Transactional
    public int createApprovalOrder(ApprovalOrder record) {
        int res = approvalOrderMapper.insertSelective(record);
        if (res > 0) {
            Order order = new Order();
            order.setId(record.getOrderId());
            if (record.getApprovalType() == ApprovalOrderType.ORDER.getCode()) {
                //提交审批后修改订单车辆价格状态
                order.setCarPriceStatus(CarPriceStatus.审批中.getCode());
                //修改精品订单为待审批
                BoutiqueRetail temp = boutiqueRetailMapper.selectBoutiqueRetailDetailByOrderId(record.getOrderId());
                if (temp != null) {
                    order.setBoutiquePriceStatus(CarPriceStatus.审批中.getCode());
                    BoutiqueRetail boutiqueRetail = new BoutiqueRetail();
                    boutiqueRetail.setId(temp.getId());
                    boutiqueRetail.setType(BoutiqueType.APPROVAL_WAIT.getCode());
                    boutiqueRetailMapper.updateByPrimaryKeySelective(boutiqueRetail);
                }
            } else {
                order.setStatus(AppOrderStatus.退单审批.getCode());
            }
            res = orderMapper.updateByPrimaryKeySelective(order);
        }
        return res;
    }

    /**
     * 通过id获取审批订单
     *
     * @param id
     * @return
     */
    @Override
    public ApprovalOrder selectByPrimaryKey(Integer id) {
        return approvalOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新审批订单表
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(ApprovalOrder record) {
        return approvalOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int getApprovalOrderNum(Integer employeeId) {
        ApprovalOrder record = new ApprovalOrder();
        record.setEmployeeId(employeeId);
        record.setApprovalStatus(approvalStatus.APPROVAL_WAIT.getCode());
        return approvalOrderMapper.getApprovalOrderNum(record);
    }

    @Override
    public List<Map<String, Object>> selectOrderByStoreId(Map<String, Object> map) {
        return approvalOrderMapper.selectByCodeNum(map);
    }

    @Override
    public ApprovalOrder selectByCusId(Integer orderId) {
        return approvalOrderMapper.selectByCusId(orderId);
    }

    @Override
    public ApprovalOrder selectApprovalOrder(Integer approvalId) {
        return approvalOrderMapper.selectByPrimaryKey(approvalId);
    }

    @Override
    public boolean ifPass(Integer approvalId) {
        ApprovalOrder approvalOrder = selectApprovalOrder(approvalId);
        int i = 0;
        if (approvalOrder.getIfBoutiqueApproval() != null && approvalOrder.getIfBoutiqueApproval() == 1) {
            i++;
        }
        if (approvalOrder.getIfSaleApproval() != null && approvalOrder.getIfSaleApproval() == 1) {
            i++;
        }
        if (approvalOrder.getSaleApprovalResult() != null && approvalOrder.getSaleApprovalResult() == 1) {
            i++;
        }
        if (approvalOrder.getBoutiqueApprovalResult() != null && approvalOrder.getBoutiqueApprovalResult() == 1) {
            i++;
        }
        if (i == 4) {
            return true;
        }
        return false;
    }

    @Override
    public List<ApprovalOrder> selectByOrderId(Map<String, Object> map) {
        return approvalOrderMapper.selectByOrderId(map);
    }
}
