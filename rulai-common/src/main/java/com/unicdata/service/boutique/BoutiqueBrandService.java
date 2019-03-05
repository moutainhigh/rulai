package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.BoutiqueBrand;

public interface BoutiqueBrandService {

	/**
	 * 添加精品品牌
	 * @param boutiqueBrand
	 * @return
	 */
	public int add(BoutiqueBrand boutiqueBrand);
	
	/**
	 * 根据id删除品牌
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id);
	
	/**
	 * 更新精品
	 * @param boutiqueBrand
	 * @return
	 */
	public int update(BoutiqueBrand boutiqueBrand);
	
	/**
	 * 根据id 查询精品品牌
	 * @param id
	 * @return
	 */
	public BoutiqueBrand findById(Integer id);
	
	/**
	 * 查询所有精品品牌
	 * @return
	 */
	public List<BoutiqueBrand> findAll(Integer storeId);
	
	/**
	 * 分页查询
	 * @param pageNum 页码
	 * @param pageSize 查询条数
	 * @return
	 */
	public PageInfo<Map<String, Object>> selectPage(Integer pageNum, Integer pageSize, Integer storeId);
}
