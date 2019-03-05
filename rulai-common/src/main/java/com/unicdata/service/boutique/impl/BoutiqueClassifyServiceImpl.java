package com.unicdata.service.boutique.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.dao.boutique.BoutiqueClassifyMapper;
import com.unicdata.dao.counter.CounterMapper;
import com.unicdata.entity.boutique.BoutiqueClassify;
import com.unicdata.entity.counter.Counter;
import com.unicdata.service.CounterService;
import com.unicdata.service.boutique.BoutiqueClassifyService;
@Service
@Transactional
public class BoutiqueClassifyServiceImpl implements BoutiqueClassifyService {

	@Autowired
	private BoutiqueClassifyMapper boutiqueClassifyMapper;
	
	@Autowired
	private CounterMapper counterMapper;
	
	@Override
	public int updateParent(Integer parentId) {
		return boutiqueClassifyMapper.updateParent(parentId);
	}
	
	@Override
	public int add(BoutiqueClassify boutiqueClassify) {
		boutiqueClassify.setTypeLive(1);
		boutiqueClassify.setHaveSon(0);
		
		if(boutiqueClassify.getLevel() > 1){
			Integer parentId = boutiqueClassify.getParentId();
			BoutiqueClassify parent = boutiqueClassifyMapper.selectByPrimaryKey(parentId);
			Integer code = null;
			Counter counter = new Counter();
			code = counterMapper.findCounterCode(Counter.BOUTIQUE_CLASSIFY_PRE + "_" + parent.getCode() + "_" +boutiqueClassify.getCode());
			if(code == null || code == 0){
				counter.setCounter(1);
				counter.setCodePrefix(Counter.BOUTIQUE_CLASSIFY_PRE + "_" + parent.getCode() + "_" + boutiqueClassify.getCode());
				counterMapper.insertSelective(counter);
			}
		}
		return boutiqueClassifyMapper.insert(boutiqueClassify);
	}

	@Override
	public int deleteById(BoutiqueClassify boutiqueClassify) {
		return boutiqueClassifyMapper.deleteById(boutiqueClassify.getId());
	}

	@Override
	public int update(BoutiqueClassify boutiqueClassify) {
//		if(boutiqueClassify.getLevel() > 1){
//			Integer parentId = boutiqueClassify.getParentId();
//			BoutiqueClassify parent = boutiqueClassifyMapper.selectByPrimaryKey(parentId);
//			Integer code = null;
//			Counter counter = new Counter();
//			code = counterMapper.findCounterCode(Counter.BOUTIQUE_CLASSIFY_PRE + "_" + parent.getCode() + "_" +boutiqueClassify.getCode());
//			if(code == null || code == 0){
//				counter.setCounter(1);
//				counter.setCodePrefix(Counter.BOUTIQUE_CLASSIFY_PRE + "_" + parent.getCode() + "_" + boutiqueClassify.getCode());
//				counterMapper.insertSelective(counter);
//			}
//		}
		
		return boutiqueClassifyMapper.updateByPrimaryKeySelective(boutiqueClassify);
	}

	@Override
	public List<BoutiqueClassify> selectBoutiqueClassifyAll(Integer storeId) {
		return boutiqueClassifyMapper.selectBoutiqueClassifyAll(storeId);
	}

	@Override
	public List<BoutiqueClassify> selectBoutiqueClassifyByLevel(Integer level, Integer parentId) {
		return boutiqueClassifyMapper.selectBoutiqueClassifyByLevel(level,parentId);
	}

	@Override
	public BoutiqueClassify selectBoutiqueClassifyById(Integer id) {
		return boutiqueClassifyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BoutiqueClassify> selectSonClassifyLiveByParentId(Integer id) {
		
		return boutiqueClassifyMapper.selectSonClassifyLiveByParentId(id);
	}

	@Override
	public void updateClassifyUse(Integer classifyId) {
		boutiqueClassifyMapper.updateClassifyUse(classifyId);
	}

	@Override
	public void updateClassifyNotUse(Integer classifyId) {
		boutiqueClassifyMapper.updateClassifyNotUse(classifyId);
	}



}
