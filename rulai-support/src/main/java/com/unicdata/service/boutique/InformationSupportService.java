package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.home.BoutiqueStay;

public interface InformationSupportService extends BoutiqueInformationService{

	List<Map<String, Object>> selectBoutiqueStockByStoreId(Map<String, Object> map);

	PageInfo<Map<String, Object>> selectBoutiqueStockByStoreIdPage(Map<String, Object> questMap, Integer pageSize,
			Integer pageNum);

	Integer selectCountUseByClassifyId(Integer classifyId, Integer storeId);


}
