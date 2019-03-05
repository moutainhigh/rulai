package com.unicdata.service.policy;

import com.unicdata.entity.policy.ListException;
import com.unicdata.entity.policy.ListExceptionExample;

import java.util.List;

/**
 * 到账单/收款单异常数据service
 * Created by shenyong on 2018/6/3.
 */
public interface ListExceptionService {

    int deleteByPrimaryKey(Integer id);

    int insert(ListException record);

    int insertSelective(ListException record);

    List<ListException> selectByExample(ListExceptionExample example);

    ListException selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ListException record);

    int updateByPrimaryKey(ListException record);

}
