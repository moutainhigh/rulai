package com.unicdata.dao.policy;

import com.unicdata.entity.policy.ArriveBillList;
import com.unicdata.entity.policy.ArriveBillListExample;
import java.util.List;

public interface ArriveBillListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArriveBillList record);

    int insertSelective(ArriveBillList record);

    List<ArriveBillList> selectByExample(ArriveBillListExample example);

    ArriveBillList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArriveBillList record);

    int updateByPrimaryKey(ArriveBillList record);
}