package com.unicdata.service.order;

import com.unicdata.entity.order.Order;
import com.unicdata.entity.order.Receipt;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
public interface ReceiptService {

    int insertReceipt(Receipt receipt);

    List selectReceipts(Receipt receipt);

    Map receiptDetail(Integer orderId);

    List depositFinance(Integer orderId);

    List carFinance(Integer orderId);

    List<Receipt> boutiqueFinance(Integer orderId);

    List<Map> insuranceFinance(Integer orderId);

    List<Map> extensionFinance(Integer orderId);

    List<Map> financeFinance(Integer orderId);

    List<Map> serviceFinance(Integer orderId);

    /**
     * 判断是否已经全款，如已经全款则修改订单状态
     *
     * @param orderId
     */
    Boolean ifFullSection(Integer orderId);

    /**
     * 全款之后所需要进行的操作
     */
    void doAfterFullSection(Integer orderId,Integer createId);

    /**
     * 收款
     *
     * @param receipt
     */
    void receiptMoney(List<Receipt> receipt, Integer employeeId);

    /**
     * 判断是否有业务已经付款
     *
     * @param receipt
     * @return
     */
    public boolean ifReceipt(Receipt receipt);

    /**
     * 根据参数获取已付全款的精品订单
     * @param params
     * @return
     */
    List<Integer> getBoutiqueRetailIdsByParams(Map<String,Object> params);
}
