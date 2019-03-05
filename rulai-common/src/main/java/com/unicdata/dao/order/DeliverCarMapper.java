package com.unicdata.dao.order;

import com.unicdata.entity.order.DeliverCar;

import java.util.List;
import java.util.Map;
import com.unicdata.entity.order.DeliverCarExample;

public interface DeliverCarMapper {

	List<DeliverCar> selectByExample(DeliverCarExample example);

	int deleteByPrimaryKey(Integer id);
    
    int insert(DeliverCar record);
    
    int insertSelective(DeliverCar record);
    
    DeliverCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliverCar record);

    int updateByPrimaryKey(DeliverCar record);
    //交车 wp
    List<Map<String, Object>> selectDeliverCarList(Map<String, Object> map);

    int getMothDeliverCarNumByStoreId(Map<String,Object> map);
    //获取今日交车洗车记录 wp
    Map<String, Object> selectCarWashRecord(Map<String, Object> map);
    //获取今日交车pdi检测记录 wp
    Map<String, Object> selectCarCheckRecord(Map<String, Object> map);
    
}