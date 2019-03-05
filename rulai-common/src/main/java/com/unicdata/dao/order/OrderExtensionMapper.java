package com.unicdata.dao.order;

import com.github.pagehelper.Page;
import com.unicdata.entity.order.OrderExtension;
import com.unicdata.entity.order.OrderExtensionExample;
import java.util.List;
import java.util.Map;

public interface OrderExtensionMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(OrderExtension record);

    int insertSelective(OrderExtension record);

    List<OrderExtension> selectByExample(OrderExtensionExample example);

    OrderExtension selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderExtension record);

    int updateByPrimaryKey(OrderExtension record);

    Map<String, Object> selectByOrderId(Integer OrderId);

    List<Map<String, Object>> getOrderExtension(Integer orderId);

    /**
     * 根据参数获取延保单列�??
     *
     * @param map
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String, Object> map);
    
    int deleteByOrderId(Integer orderId);
    
    OrderExtension getOrderExtensionByOrderId(Integer orderId);
}