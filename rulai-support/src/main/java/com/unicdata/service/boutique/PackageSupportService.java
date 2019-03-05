package com.unicdata.service.boutique;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.condition.BoutiquePackageCondition;
import com.unicdata.entity.boutique.BoutiquePackage;

public interface PackageSupportService extends BoutiquePackageService{

	public int insert(BoutiquePackage packageInfo);

	public PageInfo<Map<String, Object>> selectPackageByCondition(BoutiquePackageCondition condition);

	public int updatePackageInfo(BoutiquePackage packageInfo);
	
	public int updatePackageInfoDrop(Integer id,Integer status);

	public BoutiquePackage selectPackageById(Integer id);

}
