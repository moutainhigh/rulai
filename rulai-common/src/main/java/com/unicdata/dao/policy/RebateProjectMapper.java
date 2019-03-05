package com.unicdata.dao.policy;

import com.unicdata.entity.policy.RebateProject;
import com.unicdata.entity.policy.RebateProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RebateProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RebateProject record);

    int insertSelective(RebateProject record);

    List<RebateProject> selectByExample(RebateProjectExample example);

    RebateProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RebateProject record);

    int updateByPrimaryKey(RebateProject record);

    int insertHistoryById(@Param("id") Integer id );

    List<RebateProject> selectHistoryById(@Param("id") Integer id);

    /**
     * 涉及台数
     * @param rebateProjectId
     * @return
     */
    Integer selectInvolvedTotal(@Param("rebateProjectId") Integer rebateProjectId);

    /**
     * 达成台数
     * @param rebateProjectId
     * @param type 1批售 2零售
     * @return
     */
    Integer selectReachTotal(@Param("rebateProjectId") Integer rebateProjectId , @Param("type") Integer type);


    /**
     * 虚报台数
     * @param rebateProjectId
     * @return
     */
    Integer selectVirtualRecordTotal(@Param("rebateProjectId") Integer rebateProjectId);


}