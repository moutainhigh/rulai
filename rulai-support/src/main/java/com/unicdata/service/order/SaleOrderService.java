package com.unicdata.service.order;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;

import java.util.List;
import java.util.Map;

/**
 * Create by zhang
 */
public interface SaleOrderService {
    /**
     * 根据销售人员id获取订单列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> salemanOrderList(Map param, Integer pageNum, Integer pageSize);

    /**
     * 获取门店所有订单列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> storeOrderList(Map param, Integer pageNum, Integer pageSize);

    /**
     * 根据订单id获取订单详情车辆、客户等相关信息
     *
     * @param orderId
     * @return
     */
    Map orderDetail(Integer orderId);

    /**
     * 修改订单绑定的车辆id
     *
     * @param map
     * @return
     */
    void equipmentCar(Map<String, Integer> map);

    /**
     * 财务管理获取订单列表
     */
    PageInfo<Map> financeOrderList(Map param, Integer pageNum, Integer pageSize);

    /**
     * 销售明细
     */
    PageInfo<Map> saleDetailed(Integer storeId);

    /**
     * 根据订单状态和员工id查询订单数量
     */
    int getCurrentMothOrderNum(Integer employeeId, Integer status);

    /**
     * 获取有订单的员工名单列表
     *
     * @param storeId
     * @return
     */
    List<Employee> saleManList(Integer storeId);

    /**
     * 修改订单相关信息
     *
     * @param order
     * @return
     */
    int updateOrder(Order order);

    /**
     * 根据orderId获取订单
     *
     * @param id
     * @return
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * 通过客户id获取订单信息
     *
     * @param cusId
     * @return
     */
    List<Order> selectByCusId(Integer cusId);

    /**
     * 获取业务联系单订单车辆部分信息
     *
     * @param orderId
     * @return
     */
    Map<String, Object> orderCirculation(Integer orderId);

    /**
     * 获取应收款信息
     *
     * @param orderId
     * @return
     */
    Map<String, Object> receivablesByOrderId(Integer orderId);

    /**
     * 根据客户ID和日期获取客户订单
     *
     * @param cusId
     * @param date("yyyy-MM-dd")
     * @return
     */
    List<Order> getOrdersByCusAndDate(Integer cusId, String date);

    void pushMess(Integer storeId, List<String> postNames,
                  Integer type, String title,
                  Integer createId,
                  Order order, Employee employeeSale);

    void replaceCarInfo(List<Map<String, Object>> list);
}
