package com.unicdata.service.boutique.home;

import com.unicdata.dao.order.DeliverCarMapper;
import com.unicdata.dao.order.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class HomeDeliverCarServiceImpl implements HomeDeliverCarService {
    @Autowired
    private DeliverCarMapper deliverCarMapper;
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public int getMothDeliverCarNumByStoreId(Date saleDate, Integer storeId) {
		Map<String,Object> map = new HashMap<>();
		map.put("dayTime", saleDate);
		map.put("storeId", storeId);
        return deliverCarMapper.getMothDeliverCarNumByStoreId(map);
	}

	@Override
	public int getMothDeliverCarNumByStoreId(Map<String, Object> map) {
		return deliverCarMapper.getMothDeliverCarNumByStoreId(map);
	}

	/**
	 * 通过订单对象获取订单数量
	 *
	 * @param map@return
	 */
	@Override
	public int getCurrentMothOrderNumTwo(Map<String, Object> map) {
		return orderMapper.getCurrentMothOrderNumTwo(map);
	}
}
