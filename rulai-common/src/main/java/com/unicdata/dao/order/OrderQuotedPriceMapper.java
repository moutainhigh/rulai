package com.unicdata.dao.order;

import com.unicdata.entity.order.OrderQuotedPrice;
import com.unicdata.entity.order.OrderQuotedPriceExample;
import java.util.List;

public interface OrderQuotedPriceMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(OrderQuotedPrice record);

    int insertSelective(OrderQuotedPrice record);

    List<OrderQuotedPrice> selectByExample(OrderQuotedPriceExample example);

    OrderQuotedPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderQuotedPrice record);

    int updateByPrimaryKey(OrderQuotedPrice record);
    
    int updateQuotedStatus(OrderQuotedPrice record);
}