package com.unicdata.dao.order;

import com.github.pagehelper.Page;
import com.unicdata.entity.order.OrderInsurance;
import com.unicdata.entity.order.OrderInsuranceExample;
import java.util.List;
import java.util.Map;

public interface OrderInsuranceMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(OrderInsurance record);

    int insertSelective(OrderInsurance record);

    List<OrderInsurance> selectByExample(OrderInsuranceExample example);

    OrderInsurance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInsurance record);

    int updateByPrimaryKey(OrderInsurance record);

    List<Map<String, Object>> selectByOrderId(Integer OrderId);

    List<Map<String, Object>> getInsuranceByOrderId(Integer orderId);
    List<Map<String, Object>> getInsuranceListByMap(Map<String, Object> params);
    OrderInsurance getInsuranceByMap (OrderInsurance record);

    /**
     * 根据参数获取订单保险列表
     *
     * @param map
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String, Object> map);

    /**
     * 根据id获取保险单信�??
     *
     * @param id
     * @return
     */
    Map<String, Object> getInfoById(Integer id);
    
    int deleteByOrderInsurance(OrderInsurance record);
}