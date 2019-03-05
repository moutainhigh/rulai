package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.BoutiqueSupplier;

public interface BoutiqueSupplierService {

	/**
	 * 添加供应商
	 * @param supplier
	 * @return
	 */
	public int addSupplier(BoutiqueSupplier supplier);
	
	/**
	 * 删除供应商
	 * @param supplier
	 * @return
	 */
	public int deleteSupplier(Integer id);
	
	/**
	 * 修改供应商
	 * @param supplier
	 * @return
	 */
	public int updateSupplier(BoutiqueSupplier supplier);
	
	/**
	 * 分页条件查询供应商
	 * @param storeId
	 * @param name
	 * @return
	 */
	public 	PageInfo<Map<String, Object>> selectSupplier(Integer storeId, String name,Integer pageSize,Integer pageNum);
	
	/**
	 * 查询所有供应商
	 * @param storeId
	 * @return
	 */
	public List<BoutiqueSupplier> selectAllSupplier(Integer storeId);
	
}
