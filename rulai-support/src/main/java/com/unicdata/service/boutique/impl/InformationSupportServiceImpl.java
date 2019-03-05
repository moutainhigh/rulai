package com.unicdata.service.boutique.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.entity.boutique.home.BoutiqueStay;
import com.unicdata.service.boutique.InformationSupportService;

@Service
@Transactional
public class InformationSupportServiceImpl extends  BoutiqueInformationServiceImpl implements InformationSupportService{

	@Autowired
	private BoutiqueInformationMapper boutiqueInformationMapper;
	
	@Override
	public List<Map<String, Object>> selectBoutiqueStockByStoreId(Map<String, Object> map) {
		return boutiqueInformationMapper.selectBoutiqueStockByStoreId(map);
	}

	@Override
	public PageInfo<Map<String, Object>> selectBoutiqueStockByStoreIdPage(Map<String, Object> questMap,
			Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);

		Page<Map<String, Object>> page =  boutiqueInformationMapper.selectBoutiqueStockByStoreIdPage(questMap);
		
		
		return page.toPageInfo();
	}

	@Override
	public Integer selectCountUseByClassifyId(Integer classifyId, Integer storeId) {
		return boutiqueInformationMapper.selectCountUseByClassifyId(classifyId,storeId);
	}


}
