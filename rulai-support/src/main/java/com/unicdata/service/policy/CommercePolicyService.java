package com.unicdata.service.policy;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.policy.CommercePolicy;
import com.unicdata.entity.policy.CommercePolicyExample;

import java.util.List;
import java.util.Map;

/**
 * 商务政策service
 * Created by shenyong on 2018/6/3.
 */
public interface CommercePolicyService {

    int deleteByPrimaryKey(Integer id);

    int insert(CommercePolicy record);

    int insertSelective(CommercePolicy record);

    List<CommercePolicy> selectByExample(CommercePolicyExample example);

    CommercePolicy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommercePolicy record);

    int updateByPrimaryKey(CommercePolicy record);

    /**
     * 查询商务政策
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    Map selectPolicyPage(CommercePolicy record , Integer pageNum, Integer pageSize);

    /**
     * 保存/修改商务政策
     * @param cp
     * @return
     */
    Integer save(CommercePolicy cp);
}
