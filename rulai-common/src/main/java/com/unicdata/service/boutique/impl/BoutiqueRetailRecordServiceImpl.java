package com.unicdata.service.boutique.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.boutique.BoutiqueRetailRecordMapper;
import com.unicdata.entity.boutique.BoutiqueRetailRecord;
import com.unicdata.service.boutique.BoutiqueRetailRecordService;
@Service
public class BoutiqueRetailRecordServiceImpl implements BoutiqueRetailRecordService {

	@Autowired
	private BoutiqueRetailRecordMapper recordMapper;
	
	@Override
	public int addRetailRecord(BoutiqueRetailRecord record) {
		int recordId = recordMapper.insertUseGeneratedKeys(record);
		
		return recordId;
	}

	@Override
	public BoutiqueRetailRecord selectByPrimaryKey(Integer id) {
		return recordMapper.selectByPrimaryKey(id);
	}

	
	
}
