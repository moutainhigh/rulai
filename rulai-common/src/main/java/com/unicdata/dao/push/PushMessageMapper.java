package com.unicdata.dao.push;

import com.unicdata.entity.push.PushMessage;
import com.unicdata.entity.push.PushMessageExample;
import java.util.List;
import java.util.Map;

public interface PushMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PushMessage record);

    int insertSelective(PushMessage record);

    List<PushMessage> selectByExample(PushMessageExample example);

    PushMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PushMessage record);

    int updateByPrimaryKey(PushMessage record);
    
    List<Map<String, Object>> getPushMessageList();
    
    int updateBatch(List<Map<String, Object>> list);
}