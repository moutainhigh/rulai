package com.unicdata.service.customer;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.TestDrive;
import com.unicdata.entity.customer.TransactCustomer;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 客流service
 * @author admin
 *
 */
public interface CustomerService  {
    /**
     * 获取用户信息
     * @param record
     * @return
     */
    Customer selectCustomer(Customer record);
    Map<String, Object> selectCustomerMap(Customer record);
    /**
     * 客户档案修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * 客户档案修改（修改或新增）
     * @param record
     * @return
     */
    int updateCustomer(Customer record,MultipartFile file);
    
    /**
     * 获取客户分页列表 
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo selectCustomersList(Integer pageNum,Integer pageSize,Customer record);
   
    /**
     * 通过id查询
     * @param id
     * @return
     */
    Customer selectByPrimaryKey(Integer id);

    /**
     * 订单和交车状态的客户信息
     * @param record
     * @return
     */
    PageInfo selectOrderCusByParams(Integer pageNum,Integer pageSize,Map<String,Object> params);
    /**
     * 潜客，休眠，战败状态的客户信息
     * @param record
     * @return
     */
    PageInfo selectCusByStatus(Integer pageNum,Integer pageSize,Customer customer);
  
    /**
     * 办事人员列表wp
     * @param transactCustomer
     * @return
     */
    PageInfo selectTransactCustomer(Integer pageNum,Integer pageSize,Map<String, Object> map);
    /**
     * 登记办事人员
     * @param transactCustomer
     * @return
     */
    int insertSelective(TransactCustomer transactCustomer);
    
    /**
     * 条件查询客户 wp 
     * @param pageNum
     * @param pageSize
     * @param map
     * @return
     */
    PageInfo selectCustomers(Integer pageNum,Integer pageSize,Map<String, Object> map);
    //试驾信息(客户列表) wp
    Map<String, Object> testInfo(Map<String, Object> map);
}
