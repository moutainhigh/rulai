package com.unicdata.service.boutique.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.boutique.BoutiqueRetailRecordMapper;
import com.unicdata.entity.boutique.BoutiqueRetailRecord;
import com.unicdata.service.boutique.RetailRecordSupportService;
@Service
public class RetailRecordSupportServiceImpl extends BoutiqueRetailRecordServiceImpl implements RetailRecordSupportService {

	@Autowired
	private BoutiqueRetailRecordMapper recordMapper;
	
	@Override
	public PageInfo<Map<String, Object>> getBoutiqueRetailRecordByStoreIdPage(Map<String, Object> retail,
			Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Map<String, Object>> page = recordMapper.getBoutiqueRetailRecordByStoreIdPage(retail);
		return page.toPageInfo();
	}

	@Override
	public List<BoutiqueRetailRecord> selectRecordByRetailId(Integer reatilId) {
		return recordMapper.selectRecordByRetailId(reatilId);
	}

}
