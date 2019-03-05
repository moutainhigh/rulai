package com.unicdata.dao.customer;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.customer.EntranceGuardRemind;

public interface EntranceGuardRemindMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(EntranceGuardRemind record);

    int insertSelective(EntranceGuardRemind record);

    EntranceGuardRemind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EntranceGuardRemind record);

    int updateByPrimaryKeyWithBLOBs(EntranceGuardRemind record);

    int updateByPrimaryKey(EntranceGuardRemind record);
    //获取门禁信息 wp
    List<Map<String, Object>> selectDoorRemindMes(Map<String, Object> map);
}