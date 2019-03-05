package com.unicdata.service.order.impl;

import com.unicdata.base.util.NumberToCNUtil;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.BoutiqueRetailInclude;
import com.unicdata.service.boutique.RetailSupportService;
import com.unicdata.service.order.CirculationService;
import com.unicdata.service.order.OrderInsuranceService;
import com.unicdata.service.order.OrderServiceService;
import com.unicdata.service.order.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
@Service
public class CirculationServiceImpl implements CirculationService {

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private OrderServiceService orderServiceService;
    @Autowired
    private OrderInsuranceService orderInsuranceService;
    @Autowired
    private RetailSupportService retailSupportService;

    @Override
    public Map<String, Object> getCirculation(Integer orderId) {
        //获取业务联系单客户资料和订货详情
        Map<String, Object> orderCirculation = saleOrderService.orderCirculation(orderId);
        //获取收款部分
        Map<String, Object> receivables = saleOrderService.receivablesByOrderId(orderId);
        //获取其他服务各项金额
        List<Map<String, Object>> orderService = orderServiceService.getOrderService(orderId);
        receivables.put("licensePlate", null);
        receivables.put("substitution", null);
        receivables.put("carWindow", null);
        receivables.put("compulsoryInsurance", null);
        receivables.put("vehicleAndVesselTax", null);
        receivables.put("commercialInsurance", null);
        for (Map<String, Object> map : orderService) {
            switch (map.get("serviceId").toString()) {
                case "1":
                    receivables.put("licensePlate", map.get("servicePrice"));
                    break;
                case "2":
                    receivables.put("substitution", map.get("servicePrice"));
                    break;
                case "3":
                    receivables.put("carWindow", map.get("servicePrice"));
                    break;
            }
        }

        //获取保险相关信息
        List<Map<String, Object>> insuranceByOrderId = orderInsuranceService.getInsuranceByOrderId(orderId);
        for (Map<String, Object> map : insuranceByOrderId) {
            switch (map.get("insurerName").toString()) {
                case "交强险":
                    receivables.put("compulsoryInsurance", map.get("insuredAmount"));
                    break;
                case "车船税":
                    receivables.put("vehicleAndVesselTax", map.get("insuredAmount"));
                    break;
                case "商业险":
                    receivables.put("commercialInsurance", map.get("insuredAmount"));
                    break;
            }
        }
        //获取精品相关数据
        BoutiqueRetail boutiqueRetail = retailSupportService.selectBoutiqueRetailDetailByOrderId(orderId);
        BigDecimal applyCount = new BigDecimal(0);
        List<BoutiqueRetailInclude> boutiqueList = new ArrayList<>();
        if (boutiqueRetail != null) {
            applyCount = boutiqueRetail.getApplyCount();
            boutiqueList = boutiqueRetail.getList();
        }
        receivables.put("boutiqueApplyCount", applyCount);
        //获取精品赠送和非赠送列表
        List<String> boutiqueNotGift = new ArrayList<>();
        List<String> boutiqueGift = new ArrayList<>();
        for (BoutiqueRetailInclude boutiqueRetailInclude : boutiqueList) {
            if (boutiqueRetailInclude.getIsGift() == 0) {
                boutiqueNotGift.add(boutiqueRetailInclude.getInformationName());
            } else {
                boutiqueGift.add(boutiqueRetailInclude.getInformationName());
            }
        }
        receivables.put("boutiqueNotGift", boutiqueNotGift);
        receivables.put("boutiqueGift", boutiqueGift);
        BigDecimal amount = new BigDecimal(orderCirculation.get("orderAmount").toString());
        String orderAmount = NumberToCNUtil.number2CNMontrayUnit(amount);
        receivables.put("orderAmount", amount);
        receivables.put("orderAmountCN", orderAmount);

        Map<String, Object> result = new HashMap<>();
        result.put("orderCirculation", orderCirculation);
        result.put("receivables", receivables);
        return result;
    }
}
