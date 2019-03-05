package com.unicdata.dao.order;

import com.github.pagehelper.Page;
import com.unicdata.entity.order.OrderFinance;
import com.unicdata.entity.order.OrderFinanceExample;
import java.util.List;
import java.util.Map;

public interface OrderFinanceMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(OrderFinance record);

    int insertSelective(OrderFinance record);

    List<OrderFinance> selectByExample(OrderFinanceExample example);

    OrderFinance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderFinance record);

    int updateByPrimaryKey(OrderFinance record);


    Map<String, Object> selectByOrderId(Integer OrderId);

    List<Map<String, Object>> getOrderFinance(Integer orderId);

    /**
     * 根据参数获取订单金融列表
     *
     * @param map
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String, Object> map);

    int deleteOrderFinance(Integer orderId);

    Map<String, Object> selectFinanceByOrderId(Integer orderId);
    OrderFinance getOrderFinanceByOrderId(Integer orderId);
}