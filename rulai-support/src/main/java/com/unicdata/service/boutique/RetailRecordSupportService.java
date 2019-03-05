package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.BoutiqueRetailRecord;

public interface RetailRecordSupportService extends BoutiqueRetailRecordService{

	PageInfo<Map<String, Object>> getBoutiqueRetailRecordByStoreIdPage(Map<String, Object> retail, Integer pageSize,
			Integer pageNum);

	
	List<BoutiqueRetailRecord> selectRecordByRetailId(Integer reatilId);
	
}
