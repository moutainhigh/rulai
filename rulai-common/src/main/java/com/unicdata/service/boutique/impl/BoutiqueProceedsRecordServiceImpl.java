package com.unicdata.service.boutique.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.boutique.BoutiqueProceedsRecordMapper;
import com.unicdata.entity.boutique.BoutiqueProceedsRecord;
import com.unicdata.service.boutique.BoutiqueProceedsRecordService;

@Service
public class BoutiqueProceedsRecordServiceImpl implements BoutiqueProceedsRecordService {

	@Autowired
	private BoutiqueProceedsRecordMapper boutiqueProceedsRecordMapper;

	@Override
	public int insertSelective(BoutiqueProceedsRecord record) {
		return boutiqueProceedsRecordMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(BoutiqueProceedsRecord record) {
		return boutiqueProceedsRecordMapper.updateByPrimaryKeySelective(record);
	}

}
