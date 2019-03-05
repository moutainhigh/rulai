package com.unicdata.service.boutique;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.BoutiquePackage;

import java.util.List;
import java.util.Map;

/**
 * 精品礼包及礼包明细service
 *
 * @author admin
 */
public interface BoutiquePackageService  {
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	BoutiquePackage selectByPrimaryKey(Integer id);
	/**
	 * 查询精品礼包集合
	 * @param record
	 * @return
	 */
	List<Map<String,Object>> selectBoutiquePackage(Integer storeId,Integer familyId,String name);

    /**
     * 查询精品礼包集合根据礼包名称
     *
     * @param record
     * @return
     */
	PageInfo selectBoutiquePackageByName(Integer pageNum, Integer pageSize,Integer storeId, String name);

    /**
     * 根据精品礼包id查询礼包明细
     *
     * @param packageId
     * @return
     */
    List<Map<String, Object>> selectBoutiquePackageDetail(Integer packageId);
}
