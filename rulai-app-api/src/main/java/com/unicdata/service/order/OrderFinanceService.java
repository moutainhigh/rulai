package com.unicdata.service.order;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.order.OrderFinance;
import com.unicdata.entity.product.FinanceCompany;

/**
 * 金融贷款service
 * @author admin
 *
 */
public interface OrderFinanceService  {
	/**
	 * 金融公司列表
	 * @param record
	 * @return
	 */
	List<Map<String,Object>> selectFinanceCompany(FinanceCompany record);
	
	/**
	 * 修改订单金融
	 * @param record
	 * @return
	 */
	int updateOrderFinance(OrderFinance record);
	int deleteOrderFinance(Integer orderId);
	
	/**
	 * 根据订单id查询金融信息
	 * @param orderId
	 * @return
	 */
	Map<String,Object> getOrderFinance(Integer orderId);
	
	/**
	 * 金融公司贷款年限利率列表
	 * @param record
	 * @return
	 */
	List<Map<String,Object>> selectFinanceYears(Map<String,Object> params);
	
	OrderFinance getOrderFinanceByOrderId(Integer orderId);
}
