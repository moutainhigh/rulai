package com.unicdata.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.push.PushMessageEmployeeMapper;
import com.unicdata.dao.push.PushMessageMapper;
import com.unicdata.entity.push.PushMessageEmployee;
import com.unicdata.service.system.AppPushMessageService;

/**
 * admin
 */
@Service
public class AppPushMessageServiceImpl implements AppPushMessageService {
    @Autowired
    private PushMessageMapper pushMessageMapper;
    @Autowired
    private PushMessageEmployeeMapper pushMessageEmployeeMapper;

	@Override
	public List<Map<String, Object>> getPushMessageList() {
		return pushMessageMapper.getPushMessageList();
	}

	@Override
	public int updateBatch(List<Map<String, Object>> list) {
		return pushMessageMapper.updateBatch(list);
	}

	@Override
	public int updateViewState(PushMessageEmployee record) {
		return pushMessageEmployeeMapper.updateViewState(record);
	}

}
