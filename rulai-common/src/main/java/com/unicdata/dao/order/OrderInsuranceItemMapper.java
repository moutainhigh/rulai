package com.unicdata.dao.order;

import com.github.pagehelper.Page;
import com.unicdata.entity.order.OrderInsuranceItem;
import com.unicdata.entity.order.OrderInsuranceItemExample;
import java.util.List;
import java.util.Map;

public interface OrderInsuranceItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInsuranceItem record);

    int insertSelective(OrderInsuranceItem record);

    List<OrderInsuranceItem> selectByExample(OrderInsuranceItemExample example);

    OrderInsuranceItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInsuranceItem record);

    int updateByPrimaryKey(OrderInsuranceItem record);

    int insertBatch(List<OrderInsuranceItem> list);
    int updateBatch(List<OrderInsuranceItem> list);
    int deleteByOrderInsuranceId(Integer orderInsuranceId);
    List<Map<String,Object>> selectByMap(Map<String,Object> params);

    /**
     * 根据参数获取订单保险列表
     *
     * @param map
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String, Object> map);

    /**
     * 根据id获取保险单信息
     *
     * @param id
     * @return
     */
    Map<String, Object> getInfoById(Integer id);
}