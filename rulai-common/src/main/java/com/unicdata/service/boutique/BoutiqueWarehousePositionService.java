package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.BoutiqueWarehousePosition;

public interface BoutiqueWarehousePositionService {

	/**
	 * 添加仓库库位
	 * @param warehousePosition
	 * @return
	 */
	public int add(BoutiqueWarehousePosition warehousePosition);
	
	/**
	 * 根据id删除库位
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id);
	
	/**
	 * 根据仓库id，删除所有的库位
	 * @param id
	 * @return
	 */
	public int deleteByWarehouseId(Integer warehouseId);
	
	/**
	 * 更新库位
	 * @param warehousePosition
	 * @return
	 */
	public int update(BoutiqueWarehousePosition warehousePosition);
	
	/**
	 * 根据仓库id ，查询所有的库位
	 * @param id
	 * @return
	 */
	public List<BoutiqueWarehousePosition> findAllByWarehouseId(Integer warehouseId,Integer storeId);
	
	/**
	 * 根据仓库id ，查询所有的库位分页
	 * @param id
	 * @return
	 */
	public PageInfo<Map<String, Object>> selectWarehousePositionAllPage(Integer warehouseId, Integer storeId,Integer pageSize,Integer pageNum);
}
