package com.unicdata.service.boutique;

import java.util.List;

import com.unicdata.entity.boutique.BoutiqueClassify;

public interface BoutiqueClassifyService {

	/**
	 * 设置父分类有子分类菜单
	 * @param parentId
	 * @return
	 */
	public int updateParent(Integer parentId);
	
	/**
	 * 添加精品分类
	 * @param boutiqueClassify
	 * @return
	 */
	public int add(BoutiqueClassify boutiqueClassify);
	
	/**
	 * 删除精品分类
	 * @param id
	 * @return
	 */
	public int deleteById(BoutiqueClassify boutiqueClassify);
	
	/**
	 * 保存修改
	 * @param boutiqueClassify
	 * @return
	 */
	int update(BoutiqueClassify boutiqueClassify);
	
	/**
	 * 查询所有精品分类
	 * @return
	 */
	List<BoutiqueClassify> selectBoutiqueClassifyAll(Integer storeId);
	
	/**
	 * 根据级别查询分类
	 * @param level
	 * @param parentId
	 * @return
	 */
	List<BoutiqueClassify> selectBoutiqueClassifyByLevel(Integer level, Integer parentId);
	
	BoutiqueClassify selectBoutiqueClassifyById(Integer id);
	
	List<BoutiqueClassify> selectSonClassifyLiveByParentId(Integer id);
	
	void updateClassifyUse(Integer classifyId);
	
	void updateClassifyNotUse(Integer classifyId);
}
