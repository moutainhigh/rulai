package com.unicdata.service.operation.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.BoutiqueRetailInclude;
import com.unicdata.entity.boutique.order.OrderReatilDetail;
import com.unicdata.service.boutique.RetailSupportService;
import com.unicdata.service.operation.OperationService;
import com.unicdata.service.order.OrderExtensionService;
import com.unicdata.service.order.OrderInsuranceService;
import com.unicdata.service.order.OrderSetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderInsuranceService orderInsuranceService;
    @Autowired
    private OrderExtensionService orderExtensionService;
    @Autowired
    private OrderSetMealService orderSetMealService;
    @Autowired
    private RetailSupportService retailSupportService;

    @Override
    public PageInfo<Map<String, Object>> orderOperation(Map<String, Object> param, Integer pageNum, Integer pageSize) {
        //获取订单、车辆、金融信息
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Map<String, Object>> mapPageInfo = orderMapper.orderOperation(param).toPageInfo();
        for (Map<String, Object> map : mapPageInfo.getList()) {
            Integer orderId = Integer.parseInt(map.get("orderId").toString());
            //查询保险信息
            List<Map<String, Object>> insurance = orderInsuranceService.getInsuranceByOrderId(orderId);
            map.put("insurance", insurance);
            //查询延保信息
            List<Map<String, Object>> extension = orderExtensionService.getOrderExtension(orderId);
            map.put("extension", extension);
            //查询套餐、代金券
            List<Map<String, Object>> orderSetMeal = orderSetMealService.getOrderSetMeal(orderId);
            map.put("orderSetMeal", orderSetMeal);
            //精品信息
            OrderReatilDetail reatilDetailByOrderId = new OrderReatilDetail();
            OrderReatilDetail reatilDetailByOrderId1 = retailSupportService.getReatilDetailByOrderId(orderId);
            if (reatilDetailByOrderId1 != null) {
                reatilDetailByOrderId = reatilDetailByOrderId1;
            }
            map.put("boutiqueRetail", reatilDetailByOrderId);
        }
        return mapPageInfo;
    }
}
