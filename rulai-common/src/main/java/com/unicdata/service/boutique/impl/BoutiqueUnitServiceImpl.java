package com.unicdata.service.boutique.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.boutique.BoutiqueUnitMapper;
import com.unicdata.entity.boutique.BoutiqueUnit;
import com.unicdata.service.boutique.BoutiqueUnitService;
@Service
public class BoutiqueUnitServiceImpl implements BoutiqueUnitService {

	@Autowired
	private BoutiqueUnitMapper boutiqueUnitMapper;
	
	@Override
	public List<BoutiqueUnit> selectBoutiqueUnitList() {
		return boutiqueUnitMapper.selectBoutiqueUnitList();
	}

}
