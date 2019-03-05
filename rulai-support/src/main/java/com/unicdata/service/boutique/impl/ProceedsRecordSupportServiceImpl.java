package com.unicdata.service.boutique.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.dao.boutique.BoutiqueProceedsRecordMapper;
import com.unicdata.service.boutique.ProceedsRecordSupportService;

@Service
public class ProceedsRecordSupportServiceImpl extends BoutiqueProceedsRecordServiceImpl
		implements ProceedsRecordSupportService {

	@Autowired
	private BoutiqueProceedsRecordMapper boutiqueProceedsRecordMapper;

	@Override
	@Transactional
	public Map<String, Object> selectByRetail(Integer orderId, Integer type) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("orderId", orderId);
		param.put("type", type);
		return boutiqueProceedsRecordMapper.selectByRetail(param);
	}

}
