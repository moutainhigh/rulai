package com.unicdata.service.boutique;

import java.util.List;

import com.unicdata.entity.boutique.BoutiqueWarehouse;

public interface BoutiqueWarehouseService {

	/**
	 * 添加精品仓库
	 * @param warehouse
	 * @return
	 */
	public int add(BoutiqueWarehouse warehouse);
	
	/**
	 * 根据id删除精品仓库
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id);
	
	/**
	 * 更新仓库
	 * @param warehouse
	 * @return
	 */
	public int update(BoutiqueWarehouse warehouse);
	
	/**
	 * 查询所有的精品仓库
	 * @return
	 */
	public List<BoutiqueWarehouse> findAll(Integer storeId);
	
	/**
	 * 根据id查询精品仓库
	 * @param id
	 * @return
	 */
	public BoutiqueWarehouse selectByPrimaryKey(Integer id);
	
}
