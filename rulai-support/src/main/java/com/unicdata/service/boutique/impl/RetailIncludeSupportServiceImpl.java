package com.unicdata.service.boutique.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.unicdata.entity.boutique.BoutiqueRetailExample;
import com.unicdata.entity.boutique.BoutiqueRetailInclude;
import com.unicdata.entity.boutique.BoutiqueRetailIncludeExample;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.boutique.BoutiqueRetailIncludeMapper;
import com.unicdata.service.boutique.RetailIncludeSupportService;

@Service
public class RetailIncludeSupportServiceImpl extends BoutiqueRetailIncludeServiceImpl
		implements RetailIncludeSupportService {

	@Autowired
	private BoutiqueRetailIncludeMapper boutiqueRetailIncludeMapper;

	@Override
	public List<Map<String, Object>> selectListByRetail(Integer retailId) {
		return boutiqueRetailIncludeMapper.selectListByRetail(retailId);
	}
}
