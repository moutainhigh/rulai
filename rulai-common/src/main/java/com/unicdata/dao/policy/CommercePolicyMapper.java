package com.unicdata.dao.policy;

import com.unicdata.entity.policy.CommercePolicy;
import com.unicdata.entity.policy.CommercePolicyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommercePolicyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommercePolicy record);

    int insertSelective(CommercePolicy record);

    List<CommercePolicy> selectByExample(CommercePolicyExample example);

    CommercePolicy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommercePolicy record);

    int updateByPrimaryKey(CommercePolicy record);

    /**
     * 查询返利政策虚报台数 （车辆去重）
     * @param policyId
     * @return
     */
    List<Integer> selectPolicyVirtualRecordTotal(@Param("policyId") Integer policyId);

}