package com.unicdata.service.system;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.push.PushMessageEmployee;

/**
 * 推送消息service
 * @author admin
 *
 */
public interface AppPushMessageService {
	
	List<Map<String,Object>> getPushMessageList();
	
	int updateBatch(List<Map<String,Object>> list);
	
	int updateViewState(PushMessageEmployee record);
}
