package com.unicdata.service.boutique.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.dao.boutique.BoutiqueClassifyMapper;
import com.unicdata.entity.boutique.BoutiqueClassify;
import com.unicdata.entity.boutique.BoutiqueClassifyExample;
import com.unicdata.service.boutique.BoutiqueClassifyService;

/**
 * 精品分类服务层
 * @author admin
 *
 */
@Service
public class BoutiqueClassifyServiceImpl implements BoutiqueClassifyService {

    @Autowired
    private BoutiqueClassifyMapper boutiqueClassifyMapper;

    @Transactional(readOnly=true)
	public List<Map<String,Object>> selectBoutiqueClassifyById(Integer storeId,Integer id) {
    	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
    	Map<String, Object> classifyMap = null;
    	//查询条件
    	BoutiqueClassifyExample example = new BoutiqueClassifyExample();
    	BoutiqueClassifyExample.Criteria criteria = example.createCriteria();
    	criteria.andParentIdEqualTo(id);
    	criteria.andStoreIdEqualTo(storeId);
		//根据父id查询
    	List<BoutiqueClassify> classifyList = boutiqueClassifyMapper.selectByExample(example);
    	for (BoutiqueClassify classify : classifyList) {
    		if(classify.getParentId().equals(id)){
    			classifyMap = new HashMap<String, Object>();
				classifyMap.put("id", classify.getId());
				classifyMap.put("name", classify.getClassify());
				list.add(classifyMap);
			}
    	}
    	return list;
	}

	@Override
	public List<Map<String,Object>> selectBoutiqueClassifyAll(Integer storeId,Integer id) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		//全部精品分类
		List<BoutiqueClassify> classifyAll = boutiqueClassifyMapper.selectBoutiqueClassifyAll(storeId);
		Map<String, Object> classifyMap = null;
		for (BoutiqueClassify classify : classifyAll) {
			if(classify.getParentId().equals(id)){
				classifyMap = new HashMap<String, Object>();
				classifyMap.put("id", classify.getId());
				classifyMap.put("name", classify.getClassify());
				list.add(getClassify(classifyMap,classifyAll));
			}
		}
		return list;
	}
	
	public Map<String,Object> getClassify(Map<String,Object> map,List<BoutiqueClassify> classifyAll){
		String id = map.get("id").toString();
		List<Map<String,Object>> tempList = new ArrayList<Map<String,Object>>();
		Map<String, Object> classifyMap = null;
		for (BoutiqueClassify classify : classifyAll) {
			if(id.equals(classify.getParentId().toString())){
				classifyMap = new HashMap<String, Object>();
				classifyMap.put("id", classify.getId());
				classifyMap.put("name", classify.getClassify());
				tempList.add(getClassify(classifyMap,classifyAll));
			}
		}
		if(tempList.size()>0){
			map.put("list", tempList);
		}
		return map;
	}
    
}
