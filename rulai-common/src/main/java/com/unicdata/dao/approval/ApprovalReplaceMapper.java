package com.unicdata.dao.approval;

import com.github.pagehelper.Page;
import com.unicdata.entity.approval.ApprovalReplace;

import java.util.Map;

public interface ApprovalReplaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApprovalReplace record);

    int insertSelective(ApprovalReplace record);

    ApprovalReplace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApprovalReplace record);

    int updateByPrimaryKey(ApprovalReplace record);

    /**
     * 根据参数获取分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);
}