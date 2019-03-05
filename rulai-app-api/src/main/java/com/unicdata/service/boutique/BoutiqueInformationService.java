package com.unicdata.service.boutique;

import com.unicdata.entity.boutique.BoutiqueInformation;

import java.util.List;
import java.util.Map;

/**
 * 精品信息service
 * @author admin
 *
 */
public interface BoutiqueInformationService  {
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	BoutiqueInformation selectByPrimaryKey(Integer id);
	/**
	 * 根据分类查询精品集合
	 * @param record
	 * @return
	 */
	Map<String,Object> selectBoutiqueInformation(Integer pageNum, Integer pageSize,Integer storeId,Integer id);

	/**
	 * 查询门店下所有安全库存、不安全库存
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> selectBoutiqueStockByStoreId(Map<String,Object> map);
}
