package com.unicdata.service.boutique.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.boutique.BoutiquePackageIncludeMapper;
import com.unicdata.service.boutique.PackageIncludeSupportService;
@Service
public class PackageIncludeSupportServiceImpl extends BoutiquePackageIncludeServiceImpl implements PackageIncludeSupportService{

	@Autowired
	private BoutiquePackageIncludeMapper includeMapper;
	
	
	@Override
	public BigDecimal sumPackageCountValue(Integer packId) {
		return includeMapper.sumPackageCountValue(packId);
	}

}
