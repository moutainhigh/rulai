package com.unicdata.dao.push;

import com.unicdata.entity.push.PushMessageEmployee;
import com.unicdata.entity.push.PushMessageEmployeeExample;
import java.util.List;

public interface PushMessageEmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PushMessageEmployee record);

    int insertSelective(PushMessageEmployee record);

    List<PushMessageEmployee> selectByExample(PushMessageEmployeeExample example);

    PushMessageEmployee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PushMessageEmployee record);

    int updateByPrimaryKey(PushMessageEmployee record);
    
    int updateViewState(PushMessageEmployee record);
}