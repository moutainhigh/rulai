package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.boutique.BoutiqueClassify;

/**
 * 精品分类service
 * @author admin
 *
 */
public interface BoutiqueClassifyService  {
	/**
	 * 查询精品父分类
	 * @param record
	 * @return
	 */
	List<Map<String,Object>> selectBoutiqueClassifyById(Integer storeId,Integer id);
	
	List<Map<String,Object>> selectBoutiqueClassifyAll(Integer storeId,Integer id);
}
