package com.unicdata.service.order.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.unicdata.constant.SettleEnum;
import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.car.CarVehicleConfMapper;
import com.unicdata.dao.order.OrderQuotedPriceMapper;
import com.unicdata.entity.order.OrderQuotedPrice;
import com.unicdata.entity.order.OrderQuotedPriceExample;
import com.unicdata.service.order.OrderQuotedPriceService;
import com.unicdata.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class OrderQuotedPriceServiceImpl implements OrderQuotedPriceService {

    @Autowired
    private OrderQuotedPriceMapper orderQuotedPriceMapper;

    @Autowired
    private CarVehicleConfMapper carVehicleConfMapper;


    @Override
    public List<OrderQuotedPrice> getOrderQuotesBy(Integer customerId, String date) {
        OrderQuotedPriceExample example = new OrderQuotedPriceExample();
        OrderQuotedPriceExample.Criteria criteria = example.createCriteria();
        if (customerId != null) {
            criteria.andCusIdEqualTo(customerId);
        }
        if (StringUtils.isNotBlank(date)) {
            Date todayBegin = DateUtil.stringToDate(date + " 00:00:00", DateUtil.sdf1);
            Date todayEnd = DateUtil.stringToDate(date + " 23:59:59", DateUtil.sdf1);
            criteria.andCreatTimeBetween(todayBegin, todayEnd);
        }
        example.setOrderByClause("id desc");
        List<OrderQuotedPrice> orderQuotedPrices = orderQuotedPriceMapper.selectByExample(example);
        if (orderQuotedPrices == null || orderQuotedPrices.isEmpty()) {
            return orderQuotedPrices;
        }
        //车辆ID集合
        List<Integer> carIds = Lists.newArrayList();
        for (OrderQuotedPrice orderQuotedPrice : orderQuotedPrices) {
            carIds.add(orderQuotedPrice.getVehicleId());
            orderQuotedPrice.setStateDesc(orderQuotedPrice.getState() != null ? SettleEnum.ApprovalStates.getByCode(orderQuotedPrice.getState()).getDesc() : "");
        }
        List<Map<String, Object>> names = carVehicleConfMapper.selectNameBycarIds(carIds);
        Map<Integer, String> nameMap = Maps.newHashMap();
        for (Map<String, Object> map : names) {
            nameMap.put((Integer) map.get("id"), map.get("name") != null && StringUtils.isNotBlank(map.get("name").toString()) ? map.get("name").toString() : "");
        }
        for (OrderQuotedPrice orderQuotedPrice : orderQuotedPrices) {
            orderQuotedPrice.setVehicleName(nameMap.get(orderQuotedPrice.getVehicleId()));
        }
        return orderQuotedPrices;
    }

}
