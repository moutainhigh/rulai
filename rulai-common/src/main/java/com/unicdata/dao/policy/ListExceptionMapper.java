package com.unicdata.dao.policy;

import com.unicdata.entity.policy.ListException;
import com.unicdata.entity.policy.ListExceptionExample;
import java.util.List;

public interface ListExceptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ListException record);

    int insertSelective(ListException record);

    List<ListException> selectByExample(ListExceptionExample example);

    ListException selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ListException record);

    int updateByPrimaryKey(ListException record);
}