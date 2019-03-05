package com.unicdata.dao.order;

import com.unicdata.entity.order.Receipt;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ReceiptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Receipt record);

    int insertSelective(Receipt record);

    Receipt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Receipt record);

    int updateByPrimaryKey(Receipt record);

    List depositFinance(Integer orderId);

    List carFinance(Integer orderId);

    List boutiqueFinance(Integer orderId);

    List<Map> insuranceFinance(Integer orderId);

    List<Map> extensionFinance(Integer orderId);

    Receipt financeFinance(Map map);

    List<Map> serviceFinance(Integer orderId);

    BigDecimal sumReceipt(Integer orderId);

    List<Map> setMealReceipt(Integer orderId);

    List<Map> couponReceipt(Integer orderId);

    List<Receipt> ifReceipt(Receipt receipt);

    List<Receipt> selectReceiptByType(Receipt receipt);

    BigDecimal sumByParam(Map param);
    /**
     * 根据根据参数获取已付全款的精品订单
     * @param params
     * @return
     */
    List<Map<String,Object>> getBoutiqueIdsByParams(Map<String,Object> params);
}