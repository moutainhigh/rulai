package com.unicdata.service.car;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.unicdata.entity.order.DeliverCar;

/**
 * Created by lenovo on 2018/6/5.
 */
public interface DeliverCarService {

    /**
     * 通过门店查询交车数
     * @param map 门店id
     * @return
     */
    int getMothDeliverCarNumByStoreId(Map<String,Object> map);
    /**
     * 添加订单交车记录
     * @param record
     * @return
     */
    int addDeliverCar(DeliverCar record,MultipartFile file);

}
