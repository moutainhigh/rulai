package com.unicdata.dao.order;

import com.github.pagehelper.Page;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.order.OrderExample;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByCusId(Integer cusId);

    Page<Map<String, Object>> saleOrderList(Map param);

    Page<Map<String, Object>> storeOrderList(Map param);

    int equipmentCar(Map map);

    Map<String, Object> orderDetail(Integer orderId);

    Page<Map> financeOrderList(Map param);

    int getCurrentMothOrderNum(Order order);

    int getCurrentMothOrderNumTwo(Map<String, Object> record);

    Map<String, Object> getMothOrderNumByStoreId(Map<String, Object> map);

    List<Map<String, Object>> selectOrderList(Map<String, Object> map);

    Page<Map<String, Object>> orderOperation(Map<String, Object> map);

    List<Employee> saleManList(Integer storeId);

    //查看洗车是否属于关联订单 wp
    Map<String, Object> carOrderWash(Integer carId);

    Order selectByMap(Map<String, Object> params);


    Order selectByMacthCarId(Integer matchCarId);

    Map orderCirculation(Integer orderId);

    Map receivablesByOrderId(Integer orderId);

    /**
     * 根据日期和客户ID获取生效订单
     *
     * @param cusId
     * @param date("yyyy-MM-dd")
     * @return
     */
    List<Order> getOrdersByCusAndDate(@Param("cusId") Integer cusId, @Param("date") String date);
}