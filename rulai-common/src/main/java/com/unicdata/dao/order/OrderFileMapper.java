package com.unicdata.dao.order;

import com.unicdata.entity.order.OrderFile;

public interface OrderFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderFile record);

    int insertSelective(OrderFile record);

    OrderFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderFile record);

    int updateByPrimaryKey(OrderFile record);
}