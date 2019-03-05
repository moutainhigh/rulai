package com.unicdata.service.boutique.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.boutique.BoutiqueRetailIncludePackDivisionMapper;
import com.unicdata.entity.boutique.BoutiqueRetailIncludePackDivision;
import com.unicdata.service.boutique.RetailIncludePackDivisionSupportService;

@Service
public class RetailIncludePackDivisionSupportServiceImpl implements RetailIncludePackDivisionSupportService {

	@Autowired
	private BoutiqueRetailIncludePackDivisionMapper packDivisionMapper;
	
	@Override
	public BoutiqueRetailIncludePackDivision selectByIncludeIdAndBoutiqueId(Integer retailId, Integer boutiqueId) {
		BoutiqueRetailIncludePackDivision packDivision = packDivisionMapper.selectByIncludeIdAndBoutiqueId(retailId,boutiqueId);
		return packDivision;
	}

}
