package com.unicdata.service.customer;

import java.util.List;

import com.unicdata.entity.customer.CustomerSms;
import com.unicdata.entity.customer.CustomerSmsModel;

/**
 * 潜客短信service
 * @author admin
 *
 */
public interface CustomerSmsService  {
	
	/**
	 * 获取短信模板
	 * @return
	 */
    List<CustomerSmsModel> selectSmsModelList();
    
    /**
     * 添加客户短信
     * @param record
     * @return
     */
    int addCustomerSms(CustomerSms record);
}
