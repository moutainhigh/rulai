package com.unicdata.service.boutique.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.boutique.BoutiqueBrandMapper;
import com.unicdata.entity.boutique.BoutiqueBrand;
import com.unicdata.service.boutique.BoutiqueBrandService;

@Service
@Transactional
public class BoutiqueBrandServiceImpl implements BoutiqueBrandService {

	@Autowired
	private BoutiqueBrandMapper boutiqueBrandMapper;
	
	@Override
	public int add(BoutiqueBrand boutiqueBrand) {
		return boutiqueBrandMapper.insert(boutiqueBrand);
	}

	@Override
	public int deleteById(Integer id) {
		return boutiqueBrandMapper.deleteById(id);
	}

	@Override
	public int update(BoutiqueBrand boutiqueBrand) {
		return boutiqueBrandMapper.updateByPrimaryKeySelective(boutiqueBrand);
	}

	@Override
	public BoutiqueBrand findById(Integer id) {
		return boutiqueBrandMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BoutiqueBrand> findAll(Integer storeId) {
		return boutiqueBrandMapper.findAll(storeId);
	}

	@Override
	public PageInfo<Map<String, Object>> selectPage(Integer pageNum, Integer pageSize, Integer storeId) {
		PageHelper.startPage(pageNum, pageSize);
		return boutiqueBrandMapper.selectPage(storeId).toPageInfo();
	}

}
