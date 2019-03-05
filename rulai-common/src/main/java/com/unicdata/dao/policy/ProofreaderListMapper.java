package com.unicdata.dao.policy;

import com.unicdata.entity.policy.ProofreaderList;
import com.unicdata.entity.policy.ProofreaderListExample;
import java.util.List;

public interface ProofreaderListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProofreaderList record);

    int insertSelective(ProofreaderList record);

    List<ProofreaderList> selectByExample(ProofreaderListExample example);

    ProofreaderList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProofreaderList record);

    int updateByPrimaryKey(ProofreaderList record);
}