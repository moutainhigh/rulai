package com.unicdata.dao.holleworld;

import com.unicdata.entity.holleworld.HolleWorld;
import com.unicdata.entity.holleworld.HolleWorldExample;
import java.util.List;

public interface HolleWorldMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HolleWorld record);

    int insertSelective(HolleWorld record);

    List<HolleWorld> selectByExample(HolleWorldExample example);

    HolleWorld selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HolleWorld record);

    int updateByPrimaryKey(HolleWorld record);
}